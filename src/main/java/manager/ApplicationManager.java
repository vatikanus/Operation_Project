package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    EventFiringWebDriver wd;
    String browser;
    QAToolsHelper QA;


    public ApplicationManager(String browser){
        this.browser= browser;
    }
    public void init() {

        if (browser.equals(BrowserType.CHROME)){

            wd = new EventFiringWebDriver(new ChromeDriver());
        } else if (browser.equals(BrowserType.FIREFOX)){

            wd = new EventFiringWebDriver(new FirefoxDriver());
        }

        wd.navigate().to("https://demoqa.com/");
        wd.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        //Alisa
        wd.manage().window().maximize();
        QA= new QAToolsHelper(wd);
    }
    public void stop() {

        wd.quit();
    }

public QAToolsHelper getQA(){
        return QA;
}

    //Alisa
    public void type(By locator, String text) {
        if (text != null) {
            wd.findElement(locator).clear();
            wd.findElement(locator).sendKeys(text);
        }
    }
    //Alisa
    public void click(By locator)
    {
        wd.findElement(locator).click();
    }
    //Alisa
    public void clickOnElement()
    {
        click(By.xpath("//*[@class='category-cards']"));
    }
    //Alisa
    public void openTestBoxTab()
    {
        click(By.xpath("//*[@id='item-0']"));
    }
    //Alisa
    public void fillFullName(String fullname)
    {

        type(By.id("userName"), fullname);
    }
    //Alisa
    public void openSecondElementTab()
    {
        click(By.xpath("//*[contains(@class,'header-wrapper')]"));
    }
    //Alisa
    public void fillEmail(String email)
    {
        type(By.id("userEmail"), email);
    }
    //Alisa
    public void fillCurrentAddress(String address)
    {
        type(By.id("currentAddress"), address);
    }
    //Alisa
    public void fillPermanentAddress(String permAddr)
    {
        type(By.id("permanentAddress"), permAddr);
    }
    //Alisa
    public void clickOntheSubmitButton()
    {
        click(By.id("submit"));
    }
}
