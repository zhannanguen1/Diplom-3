package page.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    private WebDriver driver;
    public static final String LOGIN_PAGE_URL = "https://stellarburgers.nomoreparties.site/login";
    private final By EMAIL_FIELD = By.xpath(".//label[text()='Email']/../input");
    private final By PASSWORD_FIELD = By.xpath(".//label[text()='Пароль']/../input");
    private final By LOGIN_BUTTON = By.xpath(".//button[text()='Войти']");
    public LoginPage(WebDriver driver){
        this.driver = driver;
    }
    public void waitLoginPage() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(LOGIN_BUTTON));
    }
//    public void fillEmailField(String email){
//        driver.findElement(EMAIL_FIELD).click();
//        driver.findElement(EMAIL_FIELD).sendKeys(email);
//    }
//    public void fillPasswordField(String password){
//        driver.findElement(PASSWORD_FIELD).click();
//        driver.findElement(PASSWORD_FIELD).sendKeys(password);
//    }

    public void fillAllFieldsAndClick(Boolean open, String email, String password){
        if (open == true) {
            driver.get(LOGIN_PAGE_URL);
        }
        driver.findElement(EMAIL_FIELD).click();
        driver.findElement(EMAIL_FIELD).sendKeys(email);
        driver.findElement(PASSWORD_FIELD).click();
        driver.findElement(PASSWORD_FIELD).sendKeys(password);
        driver.findElement(LOGIN_BUTTON).click();
    }
//    public void clickOnLoginButton(){
//        driver.findElement(LOGIN_BUTTON).click();
//    }
    public WebDriver setDriver(boolean isYandex){
        if (isYandex == false){
            System.setProperty("webdriver.chrome.driver", "C:/Users/User/Downloads/chromedriver_win32/chromedriver.exe");
            return driver = new ChromeDriver();
        } else {
            System.setProperty("webdriver.chrome.driver", "C:/Users/User/Downloads/yandexdriver-23.3.0.2247-win/yandexdriver.exe");
            ChromeOptions options = new ChromeOptions();
            return driver = new ChromeDriver(options);
        }
    }
}
