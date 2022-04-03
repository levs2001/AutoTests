package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

class BaseTest {
    private static final String BASE_URL = "https://ok.ru";

    // Нужно 2-3 теста на человека + подключить библиотеку для матчинга и попытаться ее использовать
    protected WebDriver webDriver = new ChromeDriver();

    @BeforeAll
    static void allSetUp() {
        System.setProperty("webdriver.chrome.driver", "./driver/windows/chromedriver.exe");
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
