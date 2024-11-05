import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.MainPage;
import utils.DriverHandler;
import utils.PropsHandler;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class MainPageTest {

    static WebDriver driver;
    static MainPage mainPage;

    @BeforeAll
    public static void prepareDrivers() {
        DriverHandler.prepareSystemProps();
    }

    @BeforeEach
    public void preparePage() {
        driver = DriverHandler.getDriver();
        mainPage = new MainPage(driver);
        mainPage.loadSite(PropsHandler.get("url.main"));
    }

    @AfterEach
    public void closeDriver() {
        driver.quit();
    }

    @Test
    @Order(1)
    void testFooterExists() {
        boolean isPresent = driver.findElements(By.xpath(MainPage.FOOTER_XPATH)).size() > 0;
        Assertions.assertTrue(isPresent);
    }

    @Test
    @Order(2)
    void testClickableFooterPhoneNumberButton() {
        WebElement element = driver.findElement(By.xpath(MainPage.FOOTER_PHONE_NUMBER_BUTTON_XPATH));

        Assertions.assertTrue(element.isEnabled());
        Assertions.assertEquals("+7 (495) 740 99 79", element.findElement(By.xpath("child::p")).getAttribute("innerHTML"));
    }

    @Test
    @Order(3)
    void testClickFooterStartProjectButton() {
        WebElement element = mainPage.getFooterStartProjectButton();
        mainPage.clickFooterStartProjectButton();

        Assertions.assertTrue(element.isEnabled());
        Assertions.assertEquals(driver.getCurrentUrl(), PropsHandler.get("url.start.project"));
        Assertions.assertEquals("Начать проект", element.findElement(By.xpath("child::p")).getAttribute("innerHTML"));
    }

}

