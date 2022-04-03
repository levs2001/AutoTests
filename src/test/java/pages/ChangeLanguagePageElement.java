package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ChangeLanguagePageElement extends PresentableObject {
    private static final By ENG_LANGUAGE_BUTTON_BY = By.xpath("//*[contains(@class, 'ph-lang-modal')]//*[text() = 'English']");

    public ChangeLanguagePageElement(WebDriver webDriver) {
        super(webDriver);
    }

    public void chooseLanguage(String language) {
        webDriver.findElement(getButtonByLanguage(language)).click();
    }

    @Override
    protected void check() {
        check(ENG_LANGUAGE_BUTTON_BY);
    }

    private static By getButtonByLanguage(String language) {
        return By.xpath("//*[contains(@class, 'ph-lang-modal')]//*[text() = '" + language + "']");
    }
}
