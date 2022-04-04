package pages.bookmarks.collections;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.bookmarks.BookmarksPage;
import pages.PresentableObject;

import java.time.Duration;

public class CreateBookmarkCollectionModal extends PresentableObject {
    private static final By FORM_BY = By.xpath("//*[@id = 'hook_Modal_popLayerModal']//*[@class = 'bookmark-collection-action-form']");
    private static final By FIELD_NAME_BY = By.xpath("//*[@id = 'hook_Modal_popLayerModal']//input[@placeholder='Название подборки']");
    private static final By CREATE_BTN_BY = By.xpath("//*[@id = 'hook_Form_PopLayerBookmarksCollectionCreateForm']//*[@id = 'hook_FormButton_add']");

    public CreateBookmarkCollectionModal(WebDriver webDriver) {
        super(webDriver);
    }

    public BookmarksPage createCollection(String collectionName) {
        webDriver.findElement(FIELD_NAME_BY).sendKeys(collectionName);
        webDriver.manage().timeouts().implicitlyWait(Duration.ofMillis(4000));
        webDriver.findElement(CREATE_BTN_BY).click();

        return new BookmarksPage(webDriver);
    }

    @Override
    protected void check() {
        check(FORM_BY);
    }
}
