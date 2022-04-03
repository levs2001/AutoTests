package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RenameCollectionModal extends PresentableObject {
    private static final By FORM_BY = By.xpath("//*[@id = 'hook_Modal_popLayerModal']//*[text() = 'Изменить название']");
    private static final By NAME_INP_BY = By.xpath("//input[@id = 'field_name']");
    private static final By SAVE_BTN_BY = By.xpath("//input[@id = 'hook_FormButton_save']");

    RenameCollectionModal(WebDriver webDriver) {
        super(webDriver);
    }

    public CollectionPage rename(String newName) {
        webDriver.findElement(NAME_INP_BY).sendKeys(newName);
        webDriver.findElement(SAVE_BTN_BY).click();
        return new CollectionPage(webDriver);
    }

    @Override
    protected void check() {
        check(FORM_BY);
    }
}
