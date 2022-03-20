package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ChangeLanguagePageElement extends PresentableObject {
    private static final String ENG_LANGUAGE_BUTTON_XPATH = "//*[@id=\"ph-whiteline\"]/div/div[3]/div/div[2]/div[1]";
    private static final String RUS_LANGUAGE_BUTTON_XPATH = "//*[@id=\"ph-whiteline\"]/div/div[3]/div/div[1]/div[1]";

    private final WebElement englishLanguageBtn;
    private final WebElement russianLanguageBtn;

    @Override
    protected boolean isPresent() {
        try {
            return webDriver.findElement(By.xpath(ENG_LANGUAGE_BUTTON_XPATH)).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public ChangeLanguagePageElement(WebDriver webDriver) {
        super(webDriver);
        englishLanguageBtn = webDriver.findElement(By.xpath(ENG_LANGUAGE_BUTTON_XPATH));
        russianLanguageBtn = webDriver.findElement(By.xpath(RUS_LANGUAGE_BUTTON_XPATH));
    }

    public void chooseEnglishLanguage() {
        englishLanguageBtn.click();
    }

    public void chooseRussianLanguage() {
        russianLanguageBtn.click();
    }
}
