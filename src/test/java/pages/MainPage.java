package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class MainPage extends Page {

    @Override
    protected boolean isPresent() {
        boolean isDisplayed;
        try {
            isDisplayed = webDriver.findElement(By.className("pf-head_itx")).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }

        return isDisplayed;
    }

    MainPage(WebDriver webDriver) {
        super(webDriver);
    }

    public ChangeLanguagePageElement openChangeLanguagePane() {
        return new ChangeLanguagePageElement(webDriver);
    }
}
