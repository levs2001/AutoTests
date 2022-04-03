package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public abstract class PresentableObject {
    protected final WebDriver webDriver;

    protected abstract void check();

    protected void check(By... loadableElementsBy) {
        for (By elementBy : loadableElementsBy) {
            webDriver.findElement(elementBy).isDisplayed();
        }
    }

    PresentableObject(WebDriver webDriver) {
        this.webDriver = webDriver;
        webDriver.manage().timeouts().implicitlyWait(Duration.ofMillis(4000));
        check();
    }
}
