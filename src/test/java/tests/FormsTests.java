package tests;

import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.PracticeFormPage;

public class FormsTests extends BaseTest {

    @Test(description = "Positive: fill registration practice form minimally")
    public void practiceFormPositive() {
        PracticeFormPage page = new PracticeFormPage(driver).open();
        page.fillMinimal("Ivan", "Petrov", "ivan.petrov@example.com");
        String title = page.getModalTitle();
        Assert.assertTrue(title.toLowerCase().contains("thanks"), "Modal should show 'Thanks' after submit");
    }
}
