package page.objects;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ConstructorPage {
    private final WebDriver driver;
    public static String CONSTRUCTOR_PAGE_URL = "https://stellarburgers.nomoreparties.site/";
    private final By LOGIN_ACCOUNT_BUTTON = By.xpath(".//p[text()='Личный Кабинет']");
    private final By PERSONAL_ACCOUNT_BUTTON = By.xpath(".//p[text()='Личный Кабинет']");
    private final By CREATE_ORDER = By.xpath(".//button[text()='Оформить заказ']");
    private static final By BUN_TAB = By.xpath("//span[text()='Булки']");
    private final By FILING_TAB = By.xpath(".//span[text()='Начинки']");
    private final By SAUCE_TAB = By.xpath(".//span[text()='Соусы']");
    private static final By VISIBILITY_SECTION_CONSTRUCTOR_SAUCE = By.xpath(".//h2[text()='Соусы']");
    private static final By VISIBILITY_SECTION_CONSTRUCTOR_FILING = By.xpath(".//h2[text()='Начинки']");
    private static final By VISIBILITY_SECTION_CONSTRUCTOR_BUN = By.xpath(".//h2[text()='Булки']");

    public ConstructorPage(WebDriver driver) {
        this.driver = driver;
    }
    public void clickOnLoginToAccountButton(){
        driver.findElement(LOGIN_ACCOUNT_BUTTON).click();
    }
    public void clickOnPersonalAccountButton(){
        driver.findElement(PERSONAL_ACCOUNT_BUTTON).click();
    }
    public void open(){
        driver.get(CONSTRUCTOR_PAGE_URL);
    }
    public void waitForLoadPage(){
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(CREATE_ORDER));
    }
    public void clickOnBunTab(){
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.elementToBeClickable(BUN_TAB));
        driver.findElement(BUN_TAB).click();
    }
    public void clickOnFilingTab(){
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.elementToBeClickable(FILING_TAB));
        driver.findElement(FILING_TAB).click();
    }
    public void clickOnSauceTab(){
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.elementToBeClickable(SAUCE_TAB));
        driver.findElement(SAUCE_TAB).click();
    }
    @Step("Проверка на видимость раздела Начинки в самом конструкторе")
    public boolean checkSectionFiling() {
        return driver.findElement(VISIBILITY_SECTION_CONSTRUCTOR_FILING).isDisplayed();
    }

    @Step("Проверка на видимость раздела Соусы в самом конструкторе")
    public boolean checkSectionSauce() {
        return driver.findElement(VISIBILITY_SECTION_CONSTRUCTOR_SAUCE).isDisplayed();
    }

    @Step("Проверка на видимость раздела Булки в самом конструкторе")
    public boolean checkSectionBun() {
        return driver.findElement(VISIBILITY_SECTION_CONSTRUCTOR_BUN).isDisplayed();
    }

}
