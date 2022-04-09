package pages.bookmarks.collections;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.PresentableObject;

public class CollectionPage extends PresentableObject {
    private static final By COLLECTION_HEADER_BY = By.xpath("//*[@id = 'hook_Block_BookmarksCollectionBlock']");
    private static final By EDIT_BUTTON_BY = By.xpath("//*[@class = 'bookmark-collection-header_button-content']");

    public CollectionPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    protected void check() {
        check(COLLECTION_HEADER_BY, EDIT_BUTTON_BY);
    }

    public EditCollectionElement edit() {
        webDriver.findElement(EDIT_BUTTON_BY).click();
        return new EditCollectionElement(webDriver);
    }
}
