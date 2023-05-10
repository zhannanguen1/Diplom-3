package LogOut;

import io.qameta.allure.Description;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import page.objects.ConstructorPage;
import page.objects.LoginPage;
import page.objects.PersonalAccountPage;

@RunWith(Parameterized.class)
public class LogoutTest {
    private WebDriver driver;
    private final String webDriver;
    private final String driverPath;

    public LogoutTest(String webDriver, String driverPath) {
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
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
    }

    @Test
    @Description("Выход из аккаунта")
    public void logoutTest() {
        LoginPage objLoginPage = new LoginPage(driver);
        objLoginPage.fillAllFieldsAndClick(true, "zhanna.test@mail.ru", "Zhanna12345");
        ConstructorPage objConstructorPage = new ConstructorPage(driver);
        objConstructorPage.waitForLoadPage();
        objConstructorPage.clickOnPersonalAccountButton();
        PersonalAccountPage objPersonalAccountPage = new PersonalAccountPage(driver);
        objPersonalAccountPage.waitForLoadPage();
        objPersonalAccountPage.clickOnExitButton();
        objLoginPage.waitLoginPage();
        Assert.assertEquals(LoginPage.LOGIN_PAGE_URL, driver.getCurrentUrl());
    }

    @After
    public void tearDown() {
        driver.quit();
    }

}
