package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public abstract class PresentableObject {
    protected final WebDriver webDriver;

    protected abstract void check();

    PresentableObject(WebDriver webDriver) {
        this.webDriver = webDriver;
        webDriver.manage().timeouts().implicitlyWait(Duration.ofMillis(4000));
        check();
    }

    protected void check(By... loadableElementsBy) {
        for (By elementBy : loadableElementsBy) {
            boolean displayed = webDriver.findElement(elementBy).isDisplayed();

            if (!displayed) {
                throw new RuntimeException("ELEMENT IS NOT DISPLAYED");
            }
        }
    }
}
