package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BookmarksPage extends PresentableObject {
    private static final By BOOKMARKS_BTN_BY = By.xpath("//*[@id = 'hook_Block_BookmarksMenuRB']");

    public BookmarksPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    protected void check() {
        check(BOOKMARKS_BTN_BY);
    }
}
