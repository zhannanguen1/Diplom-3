package page.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RecoverPasswordPage {
    public WebDriver driver;
    public static final String RECOVERY_PAGE_URL = "https://stellarburgers.nomoreparties.site/forgot-password";
    private final By ENTER_BUTTON = By.xpath(".//a[text()='Войти']");
    public RecoverPasswordPage(WebDriver driver){
        this.driver = driver;
    }

    public void openPageAndClickOnEnterButton(){
        driver.get(RECOVERY_PAGE_URL);
        driver.findElement(ENTER_BUTTON).click();
    }
}
