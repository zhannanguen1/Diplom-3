package Constructor;

import io.qameta.allure.Description;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.objects.ConstructorPage;


@RunWith(Parameterized.class)
public class ConstructorTest {
    private WebDriver driver;
    private final String webDriver;
    private final String driverPath;

    public ConstructorTest(String webDriver, String driverPath) {
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
        driver.manage().window().maximize();
        new WebDriverWait(driver, 5);
    }

    @Test
    @Description("Проверка вкладки Булки")
    public void checkBunTab() {
        ConstructorPage objConstructorPage = new ConstructorPage(driver);
        objConstructorPage.open();
        objConstructorPage.clickOnFilingTab();
        objConstructorPage.clickOnBunTab();
        Assert.assertEquals("Булки", objConstructorPage.getTextFromSelectedMenu());
    }

    @Test
    @Description("Проверка вкладки Соусы")
    public void checkSauceTab() {
        ConstructorPage objConstructorPage = new ConstructorPage(driver);
        objConstructorPage.open();
        objConstructorPage.clickOnSauceTab();
        Assert.assertEquals("Соусы", objConstructorPage.getTextFromSelectedMenu());
    }

    @Test
    @Description("Проверка вкладки Начинки")
    public void checkFilingTab() {
        ConstructorPage objConstructorPage = new ConstructorPage(driver);
        objConstructorPage.open();
        objConstructorPage.clickOnFilingTab();
        Assert.assertEquals("Начинки", objConstructorPage.getTextFromSelectedMenu());
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
