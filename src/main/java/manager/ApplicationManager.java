package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

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
public void pause(int millis) {
    try {
        Thread.sleep(millis);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
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
        WebElement element = wd.findElement(locator);
        WebDriverWait wait = new WebDriverWait(wd, 30);
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
    //Allisa
    public void clickOnCheckBox()
    {
        click(By.id("item-1"));
    }
    //Alisa
    public void clickOnCheckBoxHome()
    {
        click(By.xpath("//span[@class='rct-checkbox']//*[name()='svg']"));
        click(By.xpath("//button[@title='Toggle']"));
        click(By.xpath("//label[contains(@for,'tree-node-desktop')]//span[contains(@class,'rct-checkbox')]//*[name()='svg']"));
        click(By.xpath("//label[@for='tree-node-desktop']//span[@class='rct-checkbox']"));
        click(By.xpath("//body/div[@id='app']/div[@class='body-height']/div[@class='container playgound-body']/div[@class='row']/div[@class='col-12 mt-4 col-md-6']/div[@class='check-box-tree-wrapper']/div[@id='tree-node']/ol/li[@class='rct-node rct-node-parent rct-node-expanded']/ol/li[1]/span[1]/button[1]" ));
        click(By.xpath("//li[2]//span[1]//button[1]"));
        click(By.xpath("//body/div[@id='app']/div[contains(@class,'body-height')]/div[contains(@class,'container playgound-body')]/div[contains(@class,'row')]/div[contains(@class,'col-12 mt-4 col-md-6')]/div[contains(@class,'check-box-tree-wrapper')]/div[@id='tree-node']/ol/li[contains(@class,'rct-node rct-node-parent rct-node-expanded')]/ol/li[contains(@class,'rct-node rct-node-parent rct-node-collapsed')]/span[contains(@class,'rct-text')]/button[1]"));

    }
    //Alisa
    public void closeTheCheckBoxes() throws InterruptedException {
        click(By.xpath("//li[3]//span[1]//button[1]"));
        Thread.sleep(10);
        click(By.xpath("//body/div[@id='app']/div[contains(@class,'body-height')]/div[contains(@class,'container playgound-body')]/div[contains(@class,'row')]/div[contains(@class,'col-12 mt-4 col-md-6')]/div[contains(@class,'check-box-tree-wrapper')]/div[@id='tree-node']/ol/li[contains(@class,'rct-node rct-node-parent rct-node-expanded')]/ol/li[2]/span[1]/button[1]"));
        Thread.sleep(1000);
        click(By.xpath("//li[contains(@class,'rct-node rct-node-parent rct-node-expanded')]//li[contains(@class,'rct-node rct-node-parent rct-node-expanded')]//button[contains(@title,'Toggle')]"));
        Thread.sleep(1000);
        click(By.xpath("//body/div[@id='app']/div[contains(@class,'body-height')]/div[contains(@class,'container playgound-body')]/div[contains(@class,'row')]/div[contains(@class,'col-12 mt-4 col-md-6')]/div[contains(@class,'check-box-tree-wrapper')]/div[@id='tree-node']/ol/li[contains(@class,'rct-node rct-node-parent rct-node-expanded')]/span[contains(@class,'rct-text')]/button[1]"));
       }
       //Alisa
    public void fillCheckboxes() throws InterruptedException {
        click(By.xpath("//button[@title='Toggle']"));//open Home section
        Thread.sleep(1000);
        click(By.xpath("//label[@for='tree-node-desktop']//span[@class='rct-checkbox']//*[name()='svg']"));//remove V from checkBox Desctop
        Thread.sleep(1000);
        click(By.xpath("//label[contains(@for,'tree-node-documents')]//span[contains(@class,'rct-checkbox')]//*[name()='svg']"));//remove V from checkBox Documents
        Thread.sleep(1000);
        click(By.xpath("//label[contains(@for,'tree-node-downloads')]//span[contains(@class,'rct-checkbox')]//*[name()='svg']"));////remove V from checkBox Downloads
        Thread.sleep(1000);
        click(By.xpath("(//button[@title='Toggle'])[4]"));//Open Downloads grid
        Thread.sleep(1000);
        click(By.xpath("//label[contains(@for,'tree-node-excelFile')]//span[contains(@class,'rct-checkbox')]//*[name()='svg']"));//set Exel
        Thread.sleep(1000);
        click(By.xpath("//label[contains(@for,'tree-node-wordFile')]//span[contains(@class,'rct-checkbox')]//*[name()='svg']"));//set Word
        Thread.sleep(1000);
        click(By.xpath("(//button[@title='Toggle'])[4]")); //close Downloads grid
        Thread.sleep(1000);
        click(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[2]/div[1]/ol/li/ol/li[2]/span/button"));// open Documents grid
        Thread.sleep(1000);
        click(By.xpath("//label[@for='tree-node-office']//span[@class='rct-checkbox']")); //set Office
        Thread.sleep(1000);
        click(By.xpath("//label[contains(@for,'tree-node-workspace')]//span[contains(@class,'rct-checkbox')]//*[name()='svg']")); //set WorkSpace
        Thread.sleep(1000);
        click(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[2]/div[1]/ol/li/ol/li[2]/span/button"));// close Docement grig
        Thread.sleep(1000);
        click(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[2]/div[1]/ol/li/ol/li[1]/span/button")); //open Desctop grid
        Thread.sleep(1000);
        click(By.xpath("(//*[name()='svg'][contains(@class,'rct-icon rct-icon-uncheck')])[3]"));// set Commands
        Thread.sleep(1000);
        click(By.xpath("//label[contains(@for,'tree-node-notes')]//span[contains(@class,'rct-checkbox')]//*[name()='svg']")); //set Notes
        Thread.sleep(1000);
        click(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[2]/div[1]/ol/li/ol/li[1]/span/button")); //close Desctop grid
        Thread.sleep(1000);
        click(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[2]/div[1]/ol/li/span/button")); //close Home grid
    }
    public void checkradioButton() throws InterruptedException {
        click(By.xpath("//div[@class='element-list collapse show']//li[@id='item-2']")); //Open Radio button section
        Thread.sleep(1000);
        click(By.xpath("//label[normalize-space()='Yes']")); //click the "yes" raddio bitton
        Thread.sleep(1000);
        click(By.xpath("//label[normalize-space()='Impressive']"));//click the "Impressive" radio button
    }
}
