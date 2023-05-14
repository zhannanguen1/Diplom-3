package page.objects;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    public static final String LOGIN_PAGE_URL = "https://stellarburgers.nomoreparties.site/login";
    private final By EMAIL_FIELD = By.xpath(".//label[text()='Email']/../input");
    private final By PASSWORD_FIELD = By.xpath(".//label[text()='Пароль']/../input");
    private final By LOGIN_BUTTON = By.xpath(".//button[text()='Войти']");
    private final By HEADER_LOGIN = By.xpath(".//h2[text()='Вход']");
    private final WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Дождаться загрузки страницы")
    public void waitLoginPage() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(LOGIN_BUTTON));
    }

    @Step("Заполнить поля в форме входа и кликнуть по кнопке 'Вход'")
    public void fillAllFieldsAndClick(Boolean open, String email, String password) {
        if (open) {
            driver.get(LOGIN_PAGE_URL);
        }
        driver.findElement(EMAIL_FIELD).click();
        driver.findElement(EMAIL_FIELD).sendKeys(email);
        driver.findElement(PASSWORD_FIELD).click();
        driver.findElement(PASSWORD_FIELD).sendKeys(password);
        driver.findElement(LOGIN_BUTTON).click();
    }
    @Step("Проверка отображения страницы входа")
    public boolean isLoginPageDisplayed(){
        return driver.findElement(HEADER_LOGIN).isDisplayed();
    }

}
