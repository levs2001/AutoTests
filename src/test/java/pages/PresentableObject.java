package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public abstract class PresentableObject {
    protected final WebDriver webDriver;

    protected abstract boolean isPresent();

    protected boolean isPresent(By... loadableElementsBy) {
        try {
            for (By elementBy : loadableElementsBy) {
                if (!webDriver.findElement(elementBy).isDisplayed()) {
                    return false;
                }
            }
        } catch (NoSuchElementException e) {
            return false;
        }

        return true;
    }

    PresentableObject(WebDriver webDriver) {
        this.webDriver = webDriver;
        webDriver.manage().timeouts().implicitlyWait(Duration.ofMillis(4000));
        if (!isPresent()) {
            throw new RuntimeException("No loadable Component");
        }
    }
}
