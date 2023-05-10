package Transition;

import io.qameta.allure.Description;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import page.objects.LoginPage;
import page.objects.PersonalAccountPage;

public class GoToPersonalAccountTest {
    private WebDriver driver;
    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:/Users/User/Downloads/yandexdriver-23.3.0.2247-win/yandexdriver.exe");
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
    }
    @Test
    @Description("Проверка перехода в личный кабинет")
    public void enterToPersonalAccount(){
        LoginPage objLoginPage = new LoginPage(driver);
        objLoginPage.fillAllFieldsAndClick(true, "zhanna.test@mail.ru", "Zhanna12345");
        objLoginPage.waitLoginPage();
        PersonalAccountPage objPersonalAccountPage = new PersonalAccountPage(driver);
        objPersonalAccountPage.clickOnPersonalAccountButton();
        objPersonalAccountPage.waitForLoadPage();
        Assert.assertEquals(PersonalAccountPage.PERSONAL_ACCOUNT_URL, driver.getCurrentUrl());
    }
    @After
    public void tearDown(){
        driver.quit();
    }
}
