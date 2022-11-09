import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class FirstSeleniumTest {
    private final By ACCEPT_COOKIES_BTN = By.id("onetrust-accept-btn-handler");
    private final By TOP_LOCATION_BLOCK = By.xpath(".//div[@class = 'tl-box']");
    // private final By TOP_LOCATION_LINK = By.xpath(".//div[@class = 'tl-box']/a"); - OPTIONAL

    private WebDriver browser;
    private WebDriverWait wait;

    @Test
    public void openHomePageCheck() {
        String country = "Latvia";

        browser = new SafariDriver();
        browser.manage().window().maximize();
        browser.get("http://www.discovercars.com/");

        wait = new WebDriverWait(browser, Duration.ofSeconds(2, 1));

        wait.until(ExpectedConditions.elementToBeClickable(ACCEPT_COOKIES_BTN));
        browser.findElement(ACCEPT_COOKIES_BTN).click();

        clickOnCountry(country);
    }

    private void clickOnCountry(String country) {
        List<WebElement> topLocations = browser.findElements(TOP_LOCATION_BLOCK);
        // List<WebElement> links = browser.findElements(TOP_LOCATION_LINK); - OPTIONAL
        boolean isCountryFound = false;
        for (WebElement location : topLocations) {
            // for (WebElement link : link) { - OPTIONAL
            if (location.findElement(By.tagName("a")).getText().equals(country)) {
                // if (link.getText().equals("Latvia")) { - OPTIONAL
                isCountryFound = true;
                wait.until(ExpectedConditions.elementToBeClickable(location.findElement(By.tagName("a"))));
                location.findElement(By.tagName("a")).click();
                // link.click(); - OPTIONAL
                break;
            }
        }

        Assertions.assertTrue(isCountryFound, "Country not found!");
    }
}
