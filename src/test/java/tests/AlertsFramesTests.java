package tests;

import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AlertsFramesPage;

public class AlertsFramesTests extends BaseTest {

    @Test(description = "Positive: click simple alert and accept")
    public void simpleAlertAccept() {
        AlertsFramesPage page = new AlertsFramesPage(driver).openAlerts();
        page.clickAlert();
        page.acceptAlert();
        Assert.assertNotNull(driver);
    }

    @Test(description = "Positive: switch to iframe and verify text")
    public void frameSwitch() {
        AlertsFramesPage page = new AlertsFramesPage(driver);
        page.openFrames();
        page.switchToFirstFrame();
        String text = page.getFrameText();
        Assert.assertTrue(text.toLowerCase().contains("sample"), "Frame should contain 'Sample'");
    }

    @Test(description = "Positive: click timer alert button and accept after delay")
    public void timerAlertAccept() {
        AlertsFramesPage page = new AlertsFramesPage(driver).openAlerts();
        page.clickTimerAlert();
        page.acceptAlert();
        Assert.assertNotNull(driver);
    }

    @Test(description = "Positive: click confirm alert button and accept")
    public void confirmAlertAccept() {
        AlertsFramesPage page = new AlertsFramesPage(driver).openAlerts();
        page.clickConfirm();
        page.acceptAlert();
        Assert.assertNotNull(driver);
    }

    @Test(description = "Positive: click prompt alert button, enter text and accept")
    public void promptAlertAccept() {
        AlertsFramesPage page = new AlertsFramesPage(driver).openAlerts();
        page.clickPrompt();
        page.acceptPromptAlert("Test User");
        Assert.assertNotNull(driver);
    }
}
