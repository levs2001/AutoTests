package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CollectionEditElement extends PresentableObject {
    private static final By EDIT_MENU_BY = By.xpath("//*[@id = 'hook_Block_ShortcutMenu']//*[contains(@class, 'bookmarks-collection-shortcut-menu')]");

    @Override
    protected void check() {
        check(EDIT_MENU_BY);
    }

    public CollectionEditElement(WebDriver webDriver) {
        super(webDriver);
    }
}
