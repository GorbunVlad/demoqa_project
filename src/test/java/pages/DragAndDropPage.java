package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class DragAndDropPage extends BasePage {
    private final String url = "https://demoqa.com/droppable";
    private final By draggable = By.id("draggable");
    private final By droppable = By.id("droppable");
    private final By droppableText = By.cssSelector("#droppable p");

    public DragAndDropPage(WebDriver driver) {
        super(driver);
    }

    public DragAndDropPage open() {
        driver.get(url);
        return this;
    }

    public void dragToTarget() {
        WebElement src = waitVisible(draggable);
        WebElement tgt = waitVisible(droppable);
        Actions actions = new Actions(driver);
        actions.dragAndDrop(src, tgt).perform();
    }

    public String getDroppableText() {
        return getText(droppableText);
    }
}
