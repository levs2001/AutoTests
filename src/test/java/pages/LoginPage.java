package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.User;

public class LoginPage extends Page {
    private static final String URL = "https://ok.ru";

    private final WebElement loginField;
    private final WebElement passwordField;
    private final WebElement submintButton;

    @Override
    protected boolean isPresent() {
        boolean isDisplayed = false;
        try {
            isDisplayed = webDriver.findElement(By.id("field_email")).isDisplayed()
                    && webDriver.findElement(By.id("field_password")).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }

        return isDisplayed;
    }

    public LoginPage(WebDriver webDriver) throws Exception {
        super(webDriver, URL);
        loginField = webDriver.findElement(By.id("field_email"));
        passwordField = webDriver.findElement(By.id("field_password"));
        submintButton = webDriver.findElement(By.xpath("//*[@id=\"anonymPageContent\"]/div/div[1]/div[2]/div/div[2]/div[2]/div[1]/form/div[4]/input"));
    }

    public MainPage login(User user) throws Exception {
        loginField.sendKeys(user.login);
        passwordField.sendKeys(user.password);
        submintButton.submit();

        return new MainPage(webDriver);
    }
}
