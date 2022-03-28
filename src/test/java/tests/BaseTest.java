package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {
    // Нужно 2-3 теста на человека + подключить библиотеку для матчинга и попытаться ее использовать
    protected WebDriver webDriver;

    @BeforeAll
    static void allSetUp() {
        System.setProperty("webdriver.chrome.driver", "./driver/windows/chromedriver.exe");
    }

    @BeforeEach
    void setUp() {
        webDriver = new ChromeDriver();
    }

    @AfterEach
    void close() {
        webDriver.close();
    }
}
