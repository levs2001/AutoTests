package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {
    private static final String BASE_URL = "https://ok.ru";

    protected WebDriver webDriver = new ChromeDriver();

    @BeforeAll
    static void allSetUp() {
        System.setProperty("webdriver.chrome.driver", "./driver/macos/chromedriver");
    }

    @BeforeEach
    void setUp() {
        webDriver.manage().window().maximize();
        webDriver.get(BASE_URL);
    }

    @AfterEach
    void close() {
        webDriver.quit();
    }
}
