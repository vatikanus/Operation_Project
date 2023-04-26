package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class QAToolsHelper extends HelperBase{

    public QAToolsHelper(EventFiringWebDriver wd) {
        super(wd);
    }
public void clickSite(){
        click(By.xpath("//div[@class='category-cards']//div[1]//div[1]//div[2]//*[name()='svg']"));
}



}
