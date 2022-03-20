package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class MainPage extends PresentableObject {

    @Override
    protected boolean isPresent() {
        try {
            return webDriver.findElement(By.className("pf-head_itx")).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    MainPage(WebDriver webDriver) {
        super(webDriver);
    }

    public ChangeLanguagePageElement openChangeLanguagePane() {
        webDriver.findElement(By.xpath("//*[@id=\"ph-whiteline\"]/div/div[2]/div")).click();
        return new ChangeLanguagePageElement(webDriver);
    }

    public String getSettingsText() {
        return webDriver.findElement(By.xpath("//*[@id='hook_Block_LeftColumnTopCardUser']/div/ul/li[2]/a/div")).getText();
    }
}
