package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage extends Page {

    public static final String FOOTER_XPATH = "//footer";
    public static final String FOOTER_PHONE_NUMBER_BUTTON_XPATH = "//a[@href=\"tel:+74957409979\"]";

    @FindBy(xpath = "//div[@class=\"sc-222969c7-2 hxbCMU\"]")
    WebElement footerStartProjectButton;

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public void clickFooterStartProjectButton() {
        String url = driver.getCurrentUrl();

        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", footerStartProjectButton);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.not(ExpectedConditions.urlToBe(url)));
    }

    public WebElement getFooterStartProjectButton() {
        return footerStartProjectButton;
    }

}
