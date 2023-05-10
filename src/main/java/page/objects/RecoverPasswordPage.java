package page.objects;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RecoverPasswordPage {
    public static final String RECOVERY_PAGE_URL = "https://stellarburgers.nomoreparties.site/forgot-password";
    private final By ENTER_BUTTON = By.xpath(".//a[text()='Войти']");
    public WebDriver driver;

    public RecoverPasswordPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Перейти на страницу восстановления пароля и кликнуть по кнопке 'Вход'")
    public void openPageAndClickOnEnterButton() {
        driver.get(RECOVERY_PAGE_URL);
        driver.findElement(ENTER_BUTTON).click();
    }
}
