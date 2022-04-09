package pages.bookmarks.collections;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import pages.PresentableObject;

public class RenameCollectionModal extends PresentableObject {
    private static final By FORM_BY = By.xpath("//*[@id = 'hook_Modal_popLayerModal']//*[text() = 'Изменить название']");
    private static final By NAME_INP_BY = By.xpath("//input[@id = 'field_name']");
    private static final By SAVE_BTN_BY = By.xpath("//input[@id = 'hook_FormButton_save']");

    public RenameCollectionModal(WebDriver webDriver) {
        super(webDriver);
    }

    public CollectionPage rename(String newName) {
        WebElement nameInputField = webDriver.findElement(NAME_INP_BY);
        nameInputField.clear();
        nameInputField.sendKeys(newName);
        
        webDriver.findElement(SAVE_BTN_BY).click();
        
        return new CollectionPage(webDriver);
    }

    @Override
    protected void check() {
        check(FORM_BY);
    }
}
