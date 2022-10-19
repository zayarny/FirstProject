import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;

public class FirstSeleniumTest {
    @Test
    public void openHomePageCheck() {
        WebDriver browser = new SafariDriver();
        browser.get("http://www.discovercars.com/");
    }
}
