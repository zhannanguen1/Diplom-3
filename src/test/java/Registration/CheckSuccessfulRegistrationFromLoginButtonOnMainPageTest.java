package Registration;

import com.google.gson.Gson;
import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.objects.LoginPage;
import page.objects.RegistrationPage;

import java.util.Random;

import static org.hamcrest.CoreMatchers.equalTo;

public class CheckSuccessfulRegistrationFromLoginButtonOnMainPageTest {
    private WebDriver driver;
    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:/Users/User/Downloads/chromedriver_win32/chromedriver.exe");
        driver = new ChromeDriver();
        RegistrationPage registerPage = new RegistrationPage(driver);
        registerPage.open();
    }
    @Test
    @Description("Регистрация нового пользователя")
    public void successRegistrationTest(){
        RegistrationPage objRegistrationPage = new RegistrationPage(driver);
        objRegistrationPage.open();
        Random random = new Random();
        String name = "zh" + random.nextInt(100);
        String email = "something" + random.nextInt(100000) + "@yandex.ru";
        String password = "aA" + random.nextInt(10000000);
        objRegistrationPage.fillNameField(name);
        objRegistrationPage.fillEmailField(email);
        objRegistrationPage.fillPasswordField(password);
        objRegistrationPage.clickOnRegisteredButton();

        LoginPage objLoginPage = new LoginPage(driver);
        objLoginPage.waitLoginPage();
        new WebDriverWait(driver, 3);
        Assert.assertEquals(LoginPage.LOGIN_PAGE_URL, driver.getCurrentUrl());

        RestAssured.baseURI = "https://stellarburgers.nomoreparties.site/";
        API.LoginUser loginUser = new API.LoginUser(email, password);
        Response response = API.UserClient.postApiAuthLogin(loginUser);
        response.then().assertThat().body("success", equalTo(true))
                .and()
                .statusCode(200);
        String responseString = response.body().asString();
        Gson gson = new Gson();
        API.LoginUserResponse loginUserResponse = gson.fromJson(responseString, API.LoginUserResponse.class);
        String accessToken = loginUserResponse.getAccessToken();
        API.UserClient.deleteApiAuthUser(accessToken).then().assertThat().body("success", equalTo(true))
                .and()
                .body("message", equalTo("User successfully removed"))
                .and()
                .statusCode(202);
    }
    @After
    public void tearDown() {
        driver.quit();
    }
}
