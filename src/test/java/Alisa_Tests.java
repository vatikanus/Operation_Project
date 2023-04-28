import org.testng.annotations.Test;

public class Alisa_Tests extends TestBase{
    @Test
    public void clickonElements() throws InterruptedException {
        app.clickOnElement();
        app.openSecondElementTab();
        app.openTestBoxTab();
        app.fillFullName("Alisa");
        app.fillEmail("aaaa@mail.ru");
        app.fillCurrentAddress("Herzl street 16, ap. 13, 2 floor");
        app.fillPermanentAddress("Holliwoood");
        //* app.clickOntheSubmitButton(); buttton is uncklickable. bug?
       app.clickOnCheckBox();
       Thread.sleep(1000);
       app.clickOnCheckBoxHome();
       Thread.sleep(500);
       app.closeTheCheckBoxes();
       Thread.sleep(500);
       app.fillCheckboxes();
       Thread.sleep(2000);
       app.checkradioButton();



    }
}
