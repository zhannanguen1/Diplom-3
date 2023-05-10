package Constructor;

import io.qameta.allure.Description;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import page.objects.ConstructorPage;

public class ConstructorTest {
    private WebDriver driver;
    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:/Users/User/Downloads/chromedriver_win32/chromedriver.exe");
        driver = new ChromeDriver();
    }
    @Test
    @Description("Проверка вкладки Булки")
    public void checkBunTab(){
        ConstructorPage objConstructorPage = new ConstructorPage(driver);
        objConstructorPage.open();
        objConstructorPage.clickOnSauceTab();
        objConstructorPage.clickOnBunTab();
        objConstructorPage.checkSectionFiling();
        boolean actualResult = objConstructorPage.checkSectionBun();
        Assert.assertEquals(true, actualResult);
    }
    @Test
    @Description("Проверка вкладки Соусы")
    public void checkSauceTab(){
        ConstructorPage objConstructorPage = new ConstructorPage(driver);
        objConstructorPage.open();
        objConstructorPage.clickOnSauceTab();
        objConstructorPage.checkSectionFiling();
        boolean actualResult = objConstructorPage.checkSectionSauce();
        Assert.assertEquals(true, actualResult);
    }
    @Test
    @Description("Проверка вкладки Начинки")
    public void checkFilingTab(){
        ConstructorPage objConstructorPage = new ConstructorPage(driver);
        objConstructorPage.open();
        objConstructorPage.clickOnSauceTab();
        objConstructorPage.clickOnBunTab();
        objConstructorPage.checkSectionFiling();
        boolean actualResult = objConstructorPage.checkSectionFiling();
        Assert.assertEquals(true, actualResult);
    }
    @After
    public void tearDown() {
        driver.quit();
    }
}
