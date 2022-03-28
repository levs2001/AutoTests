package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ChangeLanguagePageElement extends PresentableObject {
    private static final By ENG_LANGUAGE_BUTTON_BY = By.xpath("//*[contains(@class, 'ph-lang-modal')]//*[text() = 'English']");
    private static final By RUS_LANGUAGE_BUTTON_BY = By.xpath("//*[contains(@class, 'ph-lang-modal')]//*[text() = 'Русский']");

    @Override
    protected boolean isPresent() {
        return isPresent(ENG_LANGUAGE_BUTTON_BY);
    }

    public ChangeLanguagePageElement(WebDriver webDriver) {
        super(webDriver);
    }

    public void chooseEnglishLanguage() {
        webDriver.findElement(ENG_LANGUAGE_BUTTON_BY).click();
    }

    public void chooseRussianLanguage() {
        webDriver.findElement(RUS_LANGUAGE_BUTTON_BY).click();
    }
}
