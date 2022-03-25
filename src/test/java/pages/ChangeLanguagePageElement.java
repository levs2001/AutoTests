package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class ChangeLanguagePageElement extends PresentableObject {
    private static final By ENG_LANGUAGE_BUTTON_XPATH = By.xpath("//*[contains(@class, 'ph-lang-modal')]//*[text() = 'English']");
    private static final By RUS_LANGUAGE_BUTTON_XPATH = By.xpath("//*[contains(@class, 'ph-lang-modal')]//*[text() = 'Русский']");

    @Override
    protected boolean isPresent() {
        try {
            return webDriver.findElement(ENG_LANGUAGE_BUTTON_XPATH).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public ChangeLanguagePageElement(WebDriver webDriver) {
        super(webDriver);
    }

    public void chooseEnglishLanguage() {
        webDriver.findElement(ENG_LANGUAGE_BUTTON_XPATH).click();
    }

    public void chooseRussianLanguage() {
        webDriver.findElement(RUS_LANGUAGE_BUTTON_XPATH).click();
    }
}
