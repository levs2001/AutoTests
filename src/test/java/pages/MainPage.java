package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class MainPage extends PresentableObject {
    private static final String CHANGE_LANG_BTN_XPATH = "//*[contains(@class, 'ph-lang-select')]";
    private static final String SETTINGS_BTN_XPATH = "//*[@id = 'hook_Block_LeftColumnTopCardUser']//*[@href = '/settings']/*[@class = 'tico']";

    @Override
    protected boolean isPresent() {
        try {
            return webDriver.findElement(By.className("pf-head_itx")).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public MainPage(WebDriver webDriver) {
        super(webDriver);
    }

    public ChangeLanguagePageElement openChangeLanguageModal() {
        webDriver.findElement(By.xpath(CHANGE_LANG_BTN_XPATH)).click();
        return new ChangeLanguagePageElement(webDriver);
    }

    public String getSettingsText() {
        return webDriver.findElement(By.xpath(SETTINGS_BTN_XPATH)).getText();
    }
}
