package LogIn;

import io.qameta.allure.Description;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import page.objects.ConstructorPage;
import page.objects.LoginPage;
import page.objects.RecoverPasswordPage;

@RunWith(Parameterized.class)
public class LoginTest {
    private WebDriver driver;
    private final String webDriver;
    private final String driverPath;

    public LoginTest(String webDriver, String driverPath) {
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
    }

    @Test
    @Description("Вход в аккаунт через кнопку 'Войти' на странице входа")
    public void LogInFromLogInAccountButtonOnLoginPageTest() {
        LoginPage objLoginPage = new LoginPage(driver);
        objLoginPage.fillAllFieldsAndClick(true, "zhanna.test@mail.ru", "Zhanna12345");
        objLoginPage.waitLoginPage();
        Assert.assertEquals(LoginPage.LOGIN_PAGE_URL, driver.getCurrentUrl());
    }

    @Test
    @Description("Вход в аккаунт через кнопку 'Войти в аккаунт' на главной странице")
    public void LoginToAccount() {
        ConstructorPage objConstructorPage = new ConstructorPage(driver);
        objConstructorPage.open();
        objConstructorPage.clickOnLoginToAccountButton();
        LoginPage objLoginPage = new LoginPage(driver);
        objLoginPage.fillAllFieldsAndClick(false, "zhanna.test@mail.ru", "Zhanna12345");
        objConstructorPage.waitForLoadPage();
        Assert.assertEquals(ConstructorPage.CONSTRUCTOR_PAGE_URL, driver.getCurrentUrl());
    }

    @Test
    @Description("Вход в аккаунт через кнопку 'Личный кабинет' на главной странице")
    public void LoginFromPersonalAccount() {
        ConstructorPage objConstructorPage = new ConstructorPage(driver);
        objConstructorPage.open();
        objConstructorPage.clickOnPersonalAccountButton();
        LoginPage objLoginPage = new LoginPage(driver);
        objLoginPage.fillAllFieldsAndClick(false, "zhanna.test@mail.ru", "Zhanna12345");
        objConstructorPage.waitForLoadPage();
        Assert.assertEquals(ConstructorPage.CONSTRUCTOR_PAGE_URL, driver.getCurrentUrl());
    }

    @Test
    @Description("Вход в аккаунт через кнопку 'Войти' на странице восстановления пароля")
    public void loginFromRecoveryPage() {
        RecoverPasswordPage objRecoverPasswordPage = new RecoverPasswordPage(driver);
        objRecoverPasswordPage.openPageAndClickOnEnterButton();
        LoginPage objLoginPage = new LoginPage(driver);
        objLoginPage.fillAllFieldsAndClick(false, "zhanna.test@mail.ru", "Zhanna12345");
        ConstructorPage objConstructorPage = new ConstructorPage(driver);
        objConstructorPage.waitForLoadPage();
        Assert.assertEquals(ConstructorPage.CONSTRUCTOR_PAGE_URL, driver.getCurrentUrl());

    }


    @After
    public void tearDown() {
        driver.quit();
    }
}
