import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class Roman_sTests extends TestBase{
    @Test
    public void example(){
        System.out.println("Privet");
        app.getQA().clickSite();
        app.getQA().pause(3000);
    }

}
