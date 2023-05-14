package Registration;

import io.qameta.allure.Description;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import page.objects.RegistrationPage;

import java.util.Random;

@RunWith(Parameterized.class)
public class InvalidPasswordTest {
    private WebDriver driver;
    private final String webDriver;
    private final String driverPath;

    public InvalidPasswordTest(String webDriver, String driverPath) {
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
    @Description("Регистрация юзера с невалидным паролем")
    public void FailRegistrationInvalidPassword() {
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
        boolean actualResult = objRegistrationPage.checkPassword();
        Assert.assertTrue(actualResult);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
