package pages.bookmarks.collections;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.PresentableObject;

public class EditCollectionElement extends PresentableObject {
    private static final By EDIT_MENU_BY = By.xpath("//*[@id = 'hook_Block_ShortcutMenu']//*[contains(@class, 'bookmarks-collection-shortcut-menu')]");
    private static final By RENAME_BTN_BY = By.xpath("//*[@id = 'hook_Block_ShortcutMenu']//*[contains(@data-l, 'collection_rename')]");
    private static final By DELETE_BTN_BY = By.xpath("//*[@id = 'hook_Block_ShortcutMenu']//*[contains(@data-l, 'collection_remove')]");

    @Override
    protected void check() {
        check(EDIT_MENU_BY);
    }

    public EditCollectionElement(WebDriver webDriver) {
        super(webDriver);
    }

    public RenameCollectionModal openRenameModal() {
        webDriver.findElement(RENAME_BTN_BY).click();
        return new RenameCollectionModal(webDriver);
    }

    public DeleteCollectionModal openDeleteModal() {
        webDriver.findElement(DELETE_BTN_BY).click();
        return new DeleteCollectionModal(webDriver);
    }
}
