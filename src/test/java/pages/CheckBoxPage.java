package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckBoxPage extends BasePage {
    private final String url = "https://demoqa.com/checkbox";
    private final By expandAll = By.cssSelector("button[title='Expand all']");
    private final By notesCheckbox = By.xpath("//span[text()='Notes']/preceding-sibling::span[@class='rct-checkbox']");
    private final By result = By.id("result");

    public CheckBoxPage(WebDriver driver) {
        super(driver);
    }

    public CheckBoxPage open() {
        driver.get(url);
        return this;
    }

    public void expandAll() {
        click(expandAll);
    }

    public void selectNotes() {
        click(notesCheckbox);
    }

    public String getResultText() {
        return getTextSafely(result);
    }
}
