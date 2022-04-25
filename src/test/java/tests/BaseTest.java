package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;
import utils.User;

/**
 * Нужно добавить переменные окружения для параметров web драйвера и User. Пример:
 * <p>
 * driver.type=webdriver.chrome.driver;driver.path=./driver/windows/chromedriver.exe;
 * ok.login=78005553535;ok.password=12345678QWERTY
 * <p>
 * в IDEA: Edit configurations... > Run > Environment variables
 */
class BaseTest {
    private static final String BASE_URL = "https://ok.ru";
    protected WebDriver webDriver = new ChromeDriver();

    @BeforeAll
    static void allSetUp() {
        System.setProperty(System.getenv("driver.type"), System.getenv("driver.path"));
    }

    @BeforeEach
    void setUp() {
        webDriver.manage().window().maximize();
        webDriver.get(BASE_URL);

        new LoginPage(webDriver).login(User.fromProperties());
    }

    @AfterEach
    void close() {
        webDriver.quit();
    }
}
