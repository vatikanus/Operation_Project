package manager;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    EventFiringWebDriver wd;
    String browser;

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
    }
    public void stop() {

        wd.quit();
    }

}
