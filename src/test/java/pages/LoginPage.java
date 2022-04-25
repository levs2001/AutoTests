package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.User;

public class LoginPage extends PresentableObject {
    private static final By SUBMIT_BUTTON_BY = By.xpath("//input[@data-l='t,sign_in']");
    private static final By EMAIL_FIELD_BY = By.id("field_email");
    private static final By PASSWORD_FIELD_BY = By.id("field_password");

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    public MainPage login(User user) {
        final WebElement loginField = webDriver.findElement(EMAIL_FIELD_BY);
        final WebElement passWordField = webDriver.findElement(PASSWORD_FIELD_BY);
        final WebElement submitButton = webDriver.findElement(SUBMIT_BUTTON_BY);

        loginField.sendKeys(user.login());
        passWordField.sendKeys(user.password());
        submitButton.submit();

        return new MainPage(webDriver);
    }

    @Override
    protected void check() {
        check(EMAIL_FIELD_BY, PASSWORD_FIELD_BY);
    }
}
