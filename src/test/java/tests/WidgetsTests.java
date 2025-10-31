package tests;

import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DragAndDropPage;

public class WidgetsTests extends BaseTest {

    @Test(description = "Positive: Drag and drop basic example")
    public void dragAndDropPositive() {
        DragAndDropPage page = new DragAndDropPage(driver).open();
        page.dragToTarget();
        String text = page.getDroppableText();
        Assert.assertTrue(text.toLowerCase().contains("dropped"), "Droppable should contain 'Dropped!'");
    }

    @Test(description = "Negative: attempt incorrect drag (simulate by not moving) - assert text unchanged")
    public void dragAndDropNegative() {
        DragAndDropPage page = new DragAndDropPage(driver).open();
        String text = page.getDroppableText();
        Assert.assertTrue(!text.toLowerCase().contains("dropped"), "If not dragged, text should NOT contain 'Dropped!'");
    }
}
