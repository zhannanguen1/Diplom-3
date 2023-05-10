package page.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PersonalAccountPage {
    private WebDriver driver;
    public static String PERSONAL_ACCOUNT_URL = "https://stellarburgers.nomoreparties.site/account/profile";
    private final By PERSONAL_ACCOUNT_BUTTON = By.xpath(".//p[text()='Личный Кабинет']");
    private final By PROFILE_BUTTON = By.xpath(".//a[text()='Профиль']");
    private final By CONSTRUCTOR_BUTTON = By.xpath(".//p[text()='Конструктор']");
    private final By LOGO = By.xpath(".//div[@class='AppHeader_header__logo__2D0X2']");
    private final By LOGOUT_BUTTON = By.xpath(".//button[text()='Выход']");

    public PersonalAccountPage(WebDriver driver){
        this.driver = driver;
    }
    public void clickOnPersonalAccountButton(){
        driver.findElement(PERSONAL_ACCOUNT_BUTTON).click();
    }
    public void clickOnConstructorButton(){
        driver.findElement(LOGO).click();
    }
    public void clickOnLogo(){
        driver.findElement(CONSTRUCTOR_BUTTON).click();
    }
    public void waitForLoadPage(){
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(PROFILE_BUTTON));
    }
    public void clickOnExitButton(){
        driver.findElement(LOGOUT_BUTTON).click();
    }
}
