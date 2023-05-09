package Registration;

import io.qameta.allure.Description;
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
    }
    @After
    public void tearDown() {
        driver.quit();
    }
}
