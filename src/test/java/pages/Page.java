package pages;

import org.openqa.selenium.WebDriver;

public abstract class Page {
    protected WebDriver webDriver;

    protected abstract boolean isPresent();

    Page(WebDriver webDriver) throws Exception {
        this.webDriver = webDriver;
        if (!isPresent()) {
            throw new Exception("No loadable Component");
        }

    }
}
