package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DeleteCollectionModal extends PresentableObject {
    private static final By FORM_BY = By.xpath("//*[@id = 'hook_Modal_popLayerModal']//*[text() = 'Удалить подборку']");
    private static final By DELETE_BTN_BY = By.xpath("//input[@id = 'hook_FormButton_deleteCollectionConfirm']");

    DeleteCollectionModal(WebDriver webDriver) {
        super(webDriver);
    }

    public BookmarksPage delete() {
        webDriver.findElement(DELETE_BTN_BY).click();
        return new BookmarksPage(webDriver);
    }

    @Override
    protected void check() {
        check(FORM_BY);
    }
}