package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public abstract class PresentableObject {
    protected final WebDriver webDriver;
    protected static final int PAUSE_TIME_MS = 300;

    protected abstract void check();

    protected PresentableObject(WebDriver webDriver) {
        this.webDriver = webDriver;
        new Actions(webDriver).pause(PAUSE_TIME_MS).perform();
        check();
    }

    protected void check(By... loadableElementsBy) {
        for (By elementBy : loadableElementsBy) {
            if (!webDriver.findElement(elementBy).isDisplayed()) {
                throw new RuntimeException("ELEMENT IS NOT DISPLAYED: " + elementBy);
            }
        }
    }
}
