package page.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage {
    private final WebDriver driver;
    public static String REGISTRATION_PAGE_URL = "https://stellarburgers.nomoreparties.site/register";
    private final By NAME_FIELD = By.xpath(".//label[text()='Имя']/../input");
    private final By EMAIL_FIELD = By.xpath(".//label[text()='Email']/../input");
    private final By PASSWORD_FIELD = By.xpath(".//label[text()='Пароль']/../input");
    private final By REGISTRATION_BUTTON = By.xpath(".//button[text()='Зарегистрироваться']");
    private final By ERROR_MESSAGE = By.xpath(".//p[text()='Некорректный пароль']");


    public RegistrationPage(WebDriver driver){this.driver = driver;}
    public void open(){
        driver.get(REGISTRATION_PAGE_URL);
    }
    public void fillNameField(String name){
        driver.findElement(NAME_FIELD).click();
        driver.findElement(NAME_FIELD).sendKeys(name);
    }
    public void fillEmailField(String email){
        driver.findElement(EMAIL_FIELD).click();
        driver.findElement(EMAIL_FIELD).sendKeys(email);
    }
    public void fillPasswordField(String password){
        driver.findElement(PASSWORD_FIELD).click();
        driver.findElement(PASSWORD_FIELD).sendKeys(password);
    }
    public void clickOnRegisteredButton(){
        driver.findElement(REGISTRATION_BUTTON).click();
    }
}
