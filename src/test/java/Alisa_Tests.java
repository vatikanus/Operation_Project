import org.testng.annotations.Test;

public class Alisa_Tests extends TestBase{
    @Test
    public void clickonElements() {
        app.clickOnElement();
        app.openSecondElementTab();
        app.openTestBoxTab();
        app.fillFullName("Alisa");
        app.fillEmail("aaaa@mail.ru");
        app.fillCurrentAddress("Herzl street 16, ap. 13, 2 floor");
        app.fillPermanentAddress("Holliwoood");
        // app.clickOntheSubmitButton(); buttton is uncklickable. bug?


    }
}
