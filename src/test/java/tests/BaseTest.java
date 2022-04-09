package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;
import utils.User;

class BaseTest {
    private static final String BASE_URL = "https://ok.ru";
    protected static final User TEST_USER = new User("event2", "private");

    protected WebDriver webDriver = new ChromeDriver();

    @BeforeAll
    static void allSetUp() {
        System.setProperty("webdriver.chrome.driver", "./driver/windows/chromedriver.exe");
    }

    @BeforeEach
    void setUp() {
        webDriver.manage().window().maximize();
        webDriver.get(BASE_URL);

        new LoginPage(webDriver).login(TEST_USER);
    }

    @AfterEach
    void close() {
        webDriver.quit();
    }
}
