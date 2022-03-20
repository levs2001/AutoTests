package pages;

import org.openqa.selenium.WebDriver;

public abstract class PresentableObject {
    protected WebDriver webDriver;

    protected abstract boolean isPresent();

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
