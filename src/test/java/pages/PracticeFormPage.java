package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PracticeFormPage extends BasePage {
    private final String url = "https://demoqa.com/automation-practice-form";
    private final By firstName = By.id("firstName");
    private final By lastName = By.id("lastName");
    private final By email = By.id("userEmail");
    private final By genderMale = By.xpath("//label[@for='gender-radio-1']");
    private final By mobile = By.id("userNumber");
    private final By submit = By.id("submit");
    private final By modal = By.id("example-modal-sizes-title-lg");

    public PracticeFormPage(WebDriver driver) {
        super(driver);
    }

    public PracticeFormPage open() {
        driver.get(url);
        return this;
    }

    public void fillMinimal(String fName, String lName, String mail) {
        type(firstName, fName);
        type(lastName, lName);
        type(email, mail);
        // Select gender (required field) - click on label
        click(genderMale);
        type(mobile, "1234567890");
        // scroll to submit button and click using JavaScript
        WebElement submitButton = waitClickable(submit);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", submitButton);
        try {
            Thread.sleep(500); // Small delay to ensure page is ready
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", submitButton);
    }

    public String getModalTitle() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOfElementLocated(modal));
        return getText(modal);
    }
}
