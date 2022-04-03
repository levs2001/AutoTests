package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage extends PresentableObject {
    private static final By CHANGE_LANG_BTN_BY = By.xpath("//*[contains(@class, 'ph-lang-select')]");
    private static final By SETTINGS_BTN_BY = By.xpath("//*[@id = 'hook_Block_LeftColumnTopCardUser']//*[@href = '/settings']/*[@class = 'tico']");

    @Override
    protected boolean isPresent() {
        return isPresent(By.className("pf-head_itx"));
    }

    public MainPage(WebDriver webDriver) {
        super(webDriver);
    }

    public ChangeLanguagePageElement openChangeLanguageModal() {
        webDriver.findElement(CHANGE_LANG_BTN_BY).click();
        return new ChangeLanguagePageElement(webDriver);
    }

    public String getSettingsText() {
        return webDriver.findElement(SETTINGS_BTN_BY).getText();
    }
}
