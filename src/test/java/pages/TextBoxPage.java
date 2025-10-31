package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TextBoxPage extends BasePage {
    private final String url = "https://demoqa.com/text-box";
    private final By fullName = By.id("userName");
    private final By email = By.id("userEmail");
    private final By currentAddress = By.id("currentAddress");
    private final By permanentAddress = By.id("permanentAddress");
    private final By submit = By.id("submit");
    private final By outputName = By.id("name");
    private final By outputEmail = By.id("email");

    public TextBoxPage(WebDriver driver) {
        super(driver);
    }

    public TextBoxPage open() {
        driver.get(url);
        return this;
    }

    public void fillForm(String name, String mail, String currAddr, String permAddr) {
        type(fullName, name);
        type(email, mail);
        type(currentAddress, currAddr);
        type(permanentAddress, permAddr);
        // scroll to button and click
        click(submit);
    }

    public String getOutputName() { return getText(outputName); }
    public String getOutputEmail() { return getText(outputEmail); }
}
