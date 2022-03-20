package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {
    protected WebDriver webDriver;

    @BeforeEach
    void setUp() {
        webDriver = new ChromeDriver();
    }

    @AfterEach
    void close() {
        webDriver.close();
    }
}
