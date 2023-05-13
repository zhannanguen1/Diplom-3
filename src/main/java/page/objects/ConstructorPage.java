package page.objects;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ConstructorPage {
    private static final By BUN_TAB = By.xpath("//span[text()='Булки']");
    public static String CONSTRUCTOR_PAGE_URL = "https://stellarburgers.nomoreparties.site/";
    private final WebDriver driver;
    private final By LOGIN_ACCOUNT_BUTTON = By.xpath(".//p[text()='Личный Кабинет']");
    private final By PERSONAL_ACCOUNT_BUTTON = By.xpath(".//p[text()='Личный Кабинет']");
    private final By CREATE_ORDER = By.xpath(".//button[text()='Оформить заказ']");
    private final By FILING_TAB = By.xpath(".//span[text()='Начинки']");
    private final By SAUCE_TAB = By.xpath(".//span[text()='Соусы']");
    private static final By CURRENT_MENU = By.xpath("//div[contains(@class,'tab_tab__1SPyG tab_tab_type_current__2BEPc')]");

    public ConstructorPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Клик по кнопке 'Войти в аккаунт'")
    public void clickOnLoginToAccountButton() {
        driver.findElement(LOGIN_ACCOUNT_BUTTON).click();
    }

    @Step("Клик по кнопке 'Личный кабинет'")
    public void clickOnPersonalAccountButton() {
        driver.findElement(PERSONAL_ACCOUNT_BUTTON).click();
    }

    @Step("Открыть главную страницу с конструктором")
    public void open() {
        driver.get(CONSTRUCTOR_PAGE_URL);
    }

    @Step("Дождаться загрузки страницы")
    public void waitForLoadPage() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(CREATE_ORDER));
    }

    @Step("Клик по вкладке 'Булки'")
    public void clickOnBunTab() {
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.elementToBeClickable(BUN_TAB));
        driver.findElement(BUN_TAB).click();
    }

    @Step("Клик по вкладке 'Начинки'")
    public void clickOnFilingTab() {
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.elementToBeClickable(FILING_TAB));
        driver.findElement(FILING_TAB).click();
    }

    @Step("Клик по вкладке 'Соусы'")
    public void clickOnSauceTab() {
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.elementToBeClickable(SAUCE_TAB));
        driver.findElement(SAUCE_TAB).click();
    }

    @Step("Проверка отображения страницы конструктора после авторизации")
    public boolean isConstructorPageDisplayed(){
        return driver.findElement(CREATE_ORDER).isDisplayed();
    }
    @Step("Check current section")
    public String getTextFromSelectedMenu() {
        return driver.findElement(CURRENT_MENU).getText();
    }

}
