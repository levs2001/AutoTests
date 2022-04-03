package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BookmarksPage extends PresentableObject {
    private static final By BOOKMARKS_BTN_BY = By.xpath("//*[@id = 'hook_Block_AsideColumn']//*[@class = 'tico']//*[text() = 'Закладки']");

    public BookmarksPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    protected void check() {

    }
}
