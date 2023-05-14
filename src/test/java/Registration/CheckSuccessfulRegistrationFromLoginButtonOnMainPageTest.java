package Registration;

import com.google.gson.Gson;
import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import page.objects.LoginPage;
import page.objects.RegistrationPage;

import java.util.Random;

import static org.hamcrest.CoreMatchers.equalTo;

@RunWith(Parameterized.class)
public class CheckSuccessfulRegistrationFromLoginButtonOnMainPageTest {
    private WebDriver driver;
    private final String webDriver;
    private final String driverPath;
    private String accessToken;

    public CheckSuccessfulRegistrationFromLoginButtonOnMainPageTest(String webDriver, String driverPath) {
        this.webDriver = webDriver;
        this.driverPath = driverPath;
    }

    @Parameterized.Parameters(name = "Выбор браузера: {0},{1}")
    public static Object[][] getDriver() {
        return new Object[][]{
                {"webdriver.chrome.driver", "C:/Users/User/Downloads/chromedriver_win32/chromedriver.exe"},
                {"webdriver.chrome.driver", "C:/Users/User/Downloads/yandexdriver-23.3.0.2247-win/yandexdriver.exe"}
        };
    }

    @Before
    public void setUp() {
        System.setProperty(webDriver, driverPath);
        driver = new ChromeDriver();
        RegistrationPage registerPage = new RegistrationPage(driver);
        registerPage.open();
    }

    @Test
    @Description("Регистрация нового пользователя")
    public void successRegistrationTest() {
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
        Assert.assertTrue(objLoginPage.isLoginPageDisplayed());
        RestAssured.baseURI = "https://stellarburgers.nomoreparties.site/";
        API.LoginUser loginUser = new API.LoginUser(email, password);
        Response response = API.UserClient.postApiAuthLogin(loginUser);
        response.then().assertThat().body("success", equalTo(true))
                .and()
                .statusCode(200);
        String responseString = response.body().asString();
        Gson gson = new Gson();
        API.LoginUserResponse loginUserResponse = gson.fromJson(responseString, API.LoginUserResponse.class);
        accessToken = loginUserResponse.getAccessToken();

    }
    @After
    public void cleanUp(){
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
