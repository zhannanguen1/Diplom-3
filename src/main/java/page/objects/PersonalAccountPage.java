package page.objects;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PersonalAccountPage {
    public static String PERSONAL_ACCOUNT_URL = "https://stellarburgers.nomoreparties.site/account/profile";
    private final By PERSONAL_ACCOUNT_BUTTON = By.xpath(".//p[text()='Личный Кабинет']");
    private final By PROFILE_BUTTON = By.xpath(".//a[text()='Профиль']");
    private final By CONSTRUCTOR_BUTTON = By.xpath(".//p[text()='Конструктор']");
    private final By LOGO = By.xpath(".//div[@class='AppHeader_header__logo__2D0X2']");
    private final By LOGOUT_BUTTON = By.xpath(".//button[text()='Выход']");
    private final WebDriver driver;

    public PersonalAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Клик по кнопке 'Личный кабинет'")
    public void clickOnPersonalAccountButton() {
        driver.findElement(PERSONAL_ACCOUNT_BUTTON).click();
    }

    @Step("Клик по кнопке 'Конструктор'")
    public void clickOnConstructorButton() {
        driver.findElement(LOGO).click();
    }

    @Step("Клик по логотипу в хедере")
    public void clickOnLogo() {
        driver.findElement(CONSTRUCTOR_BUTTON).click();
    }

    @Step("Дождаться загрузки страницы")
    public void waitForLoadPage() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(PROFILE_BUTTON));
    }

    @Step("Клик по кнопке 'Выход'")
    public void clickOnExitButton() {
        driver.findElement(LOGOUT_BUTTON).click();
    }
}
