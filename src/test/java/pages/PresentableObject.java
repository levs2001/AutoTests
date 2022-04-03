package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public abstract class PresentableObject {
    protected WebDriver webDriver;

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

    PresentableObject(WebDriver webDriver, String url) {
        this.webDriver = webDriver;
        this.webDriver.get(url);

        if (!isPresent()) {
            throw new RuntimeException("No loadable Component");
        }
    }

    PresentableObject(WebDriver webDriver) {
        this.webDriver = webDriver;
        if (!isPresent()) {
            throw new RuntimeException("No loadable Component");
        }
    }
}
