package pages;

import org.openqa.selenium.WebDriver;

public class MainPage extends Page {

    @Override
    protected boolean isPresent() {
        return false;
    }

    MainPage(WebDriver webDriver) throws Exception {
        super(webDriver);
    }
}
