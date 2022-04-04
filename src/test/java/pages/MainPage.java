package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.bookmarks.BookmarksPage;

public class MainPage extends PresentableObject {
    private static final By CHANGE_LANG_BTN_BY = By.xpath("//*[contains(@class, 'ph-lang-select')]");
    private static final By SETTINGS_BTN_BY = By.xpath("//*[@id = 'hook_Block_LeftColumnTopCardUser']//*[@href = '/settings']/*[@class = 'tico']");
    private static final By HEAD_BY = By.className("pf-head_itx");

    private static final By MORE_BTN_BY = By.xpath("//*[@id = 'hook_Block_AsideColumn']//*[@data-module='Toggler']");
    private static final By BOOKMARKS_BTN_BY = By.xpath("//*[@id = 'hook_Block_AsideColumn']//*[@href = '/bookmarks']");

    public MainPage(WebDriver webDriver) {
        super(webDriver);
    }

    public ChangeLanguagePageElement openChangeLanguageModal() {
        webDriver.findElement(CHANGE_LANG_BTN_BY).click();
        return new ChangeLanguagePageElement(webDriver);
    }

    public BookmarksPage goToBookmarksPage() {
        webDriver.findElement(MORE_BTN_BY).click();
        webDriver.findElement(BOOKMARKS_BTN_BY).click();

        return new BookmarksPage(webDriver);
    }

    public String getSettingsText() {
        return webDriver.findElement(SETTINGS_BTN_BY).getText();
    }

    @Override
    protected void check() {
        check(HEAD_BY);
    }
}
