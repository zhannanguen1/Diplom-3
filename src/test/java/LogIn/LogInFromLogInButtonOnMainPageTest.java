package LogIn;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import page.objects.ConstructorPage;
import page.objects.LoginPage;
import page.objects.RegistrationPage;

public class LogInFromLogInButtonOnMainPageTest {
    private WebDriver driver;
    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:/Users/User/Downloads/chromedriver_win32/chromedriver.exe");
        driver = new ChromeDriver();
        ConstructorPage constructorPage = new ConstructorPage(driver);
        constructorPage.open();
    }
    @Test
    public void LoginToAccount(){
        ConstructorPage objConstructorPage = new ConstructorPage(driver);
        objConstructorPage.clickOnLoginToAccountButton();
        LoginPage objLoginPage = new LoginPage(driver);
        objLoginPage.waitLoginPage();
        objLoginPage.fillEmailField("zhanna.test@mail.ru");
        objLoginPage.fillPasswordField("Zhanna12345");
        objLoginPage.clickOnLoginButton();
        objConstructorPage.waitForLoadPage();
        Assert.assertEquals(ConstructorPage.CONSTRUCTOR_PAGE_URL, driver.getCurrentUrl());
    }
    @After
    public void tearDown() {
        driver.quit();
    }
}
