package pages;

import org.openqa.selenium.WebDriver;

public abstract class PresentableObject {
    protected WebDriver webDriver;

    protected abstract boolean isPresent();

    PresentableObject(WebDriver webDriver) {
        this.webDriver = webDriver;
        if (!isPresent()) {
            throw new RuntimeException("No loadable Component");
        }
    }
}
