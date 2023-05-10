package LogOut;

import io.qameta.allure.Description;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import page.objects.ConstructorPage;
import page.objects.LoginPage;
import page.objects.PersonalAccountPage;

public class LogoutTest {
    private WebDriver driver;
    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:/Users/User/Downloads/yandexdriver-23.3.0.2247-win/yandexdriver.exe");
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
    }
    @Test
    @Description("Выход из аккаунта")
    public void logoutTest(){
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
    public void tearDown(){
        driver.quit();
    }

}
