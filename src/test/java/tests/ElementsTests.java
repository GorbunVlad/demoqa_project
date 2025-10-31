package tests;

import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TextBoxPage;
import pages.CheckBoxPage;

public class ElementsTests extends BaseTest {

    @Test(description = "Positive: fill Text Box and verify output")
    public void textBoxPositive() {
        TextBoxPage page = new TextBoxPage(driver).open();
        page.fillForm("Иван Иванов", "ivan@example.com", "Moscow", "Saint-Petersburg");
        String nameOut = page.getOutputName();
        String emailOut = page.getOutputEmail();
        Assert.assertTrue(nameOut.contains("Иван Иванов"), "Name output mismatch");
        Assert.assertTrue(emailOut.contains("ivan@example.com"), "Email output mismatch");
    }

    @Test(description = "Positive: select checkbox 'Notes' and verify result")
    public void checkBoxPositive() {
        CheckBoxPage page = new CheckBoxPage(driver).open();
        page.expandAll();
        page.selectNotes();
        String res = page.getResultText();
        Assert.assertTrue(res.toLowerCase().contains("notes"), "Result should contain 'notes'");
    }

    @Test(description = "Negative: verify that result is empty before selecting checkbox")
    public void checkBoxNegative() {
        CheckBoxPage page = new CheckBoxPage(driver).open();
        page.expandAll();
        String res = page.getResultText();
        Assert.assertTrue(res.isEmpty() || !res.toLowerCase().contains("notes"), 
            "Result should NOT contain 'notes' before checkbox selection");
    }
}
