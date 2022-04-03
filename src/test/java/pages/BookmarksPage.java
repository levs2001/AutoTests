package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BookmarksPage extends PresentableObject {
    private static final By BOOKMARKS_BTN_BY = By.xpath("//*[@id = 'hook_Block_BookmarksMenuRB']");
    private static final By CREATE_COLLECTION_BTN_BY = By.xpath("//*[@id = 'hook_Block_BookmarksRB']//*[text() = 'Добавить подборку']");

    public BookmarksPage(WebDriver webDriver) {
        super(webDriver);
    }

    public CreateBookmarkCollectionModal openCreateBookmarkCollectionModal() {
        webDriver.findElement(CREATE_COLLECTION_BTN_BY).click();

        return new CreateBookmarkCollectionModal(webDriver);
    }

    @Override
    protected void check() {
        check(BOOKMARKS_BTN_BY);
    }
}
