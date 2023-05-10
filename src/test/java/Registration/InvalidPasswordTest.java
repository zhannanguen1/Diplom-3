package Registration;

import io.qameta.allure.Description;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import page.objects.RegistrationPage;

import java.util.Random;

public class InvalidPasswordTest {
    private WebDriver driver;
    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:/Users/User/Downloads/chromedriver_win32/chromedriver.exe");
        driver = new ChromeDriver();
        RegistrationPage registerPage = new RegistrationPage(driver);
        registerPage.open();
    }
    @Test
    @Description("Регистрация юзера с невалидным паролем")
    public void FailRegistrationInvalidPassword(){
        RegistrationPage objRegistrationPage = new RegistrationPage(driver);
        objRegistrationPage.open();
        Random random = new Random();
        String name = "zh" + random.nextInt(100);
        String email = "something" + random.nextInt(100000) + "@yandex.ru";
        String password = "aA" + random.nextInt(1000);
        objRegistrationPage.fillNameField(name);
        objRegistrationPage.fillEmailField(email);
        objRegistrationPage.fillPasswordField(password);
        objRegistrationPage.clickOnRegisteredButton();
        Assert.assertTrue(driver.findElement(By.xpath(".//p[text()='Некорректный пароль']")).isDisplayed());
    }
    @After
    public void tearDown() {
        driver.quit();
    }
}
