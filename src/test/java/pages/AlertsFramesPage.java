package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AlertsFramesPage extends BasePage {
    private final String alertsUrl = "https://demoqa.com/alerts";
    private final String framesUrl = "https://demoqa.com/frames";

    // Alerts
    private final By alertButton = By.id("alertButton");
    private final By timerAlertButton = By.id("timerAlertButton");
    private final By confirmButton = By.id("confirmButton");
    private final By promptButton = By.id("promtButton");

    // Frames
    private final By firstFrame = By.id("frame1");
    private final By sampleHeading = By.id("sampleHeading");

    public AlertsFramesPage(WebDriver driver) {
        super(driver);
    }

    public AlertsFramesPage openAlerts() {
        driver.get(alertsUrl);
        return this;
    }

    public void clickAlert() {
        click(alertButton);
    }

    public void clickTimerAlert() {
        click(timerAlertButton);
    }

    public void clickConfirm() {
        click(confirmButton);
    }

    public void clickPrompt() {
        click(promptButton);
    }

    public void openFrames() {
        driver.get(framesUrl);
    }

    public void switchToFirstFrame() {
        switchToFrame(firstFrame);
    }

    public String getFrameText() {
        return getText(sampleHeading);
    }
}
