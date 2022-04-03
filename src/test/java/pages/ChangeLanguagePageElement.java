package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ChangeLanguagePageElement extends PresentableObject {
    private static final By ENG_LANGUAGE_BUTTON_BY = By.xpath("//*[contains(@class, 'ph-lang-modal')]//*[text() = 'English']");

    @Override
    protected boolean isPresent() {
        return isPresent(ENG_LANGUAGE_BUTTON_BY);
    }

    public ChangeLanguagePageElement(WebDriver webDriver) {
        super(webDriver);
    }

    public void chooseLanguage(String language) {
        webDriver.findElement(getButtonByLanguage(language)).click();
    }

    private static By getButtonByLanguage(String language) {
        return By.xpath("//*[contains(@class, 'ph-lang-modal')]//*[text() = '" + language + "']");
    }
}
