import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserInit {
    WebDriver webDriver;


    public WebDriver OpenBrowser(String browserName, String fullURL){

        if(browserName.equalsIgnoreCase("Firefox")) {
            webDriver = new FirefoxDriver();
            System.setProperty("webdriver.firefox.driver",".\\geckodriver.exe");
            webDriver.get(fullURL);
            webDriver.manage().window().maximize();
        }
        if(browserName.equalsIgnoreCase("Chrome")){
            webDriver=new ChromeDriver();
            System.setProperty("webdriver.chrome.driver",".\\chromedriver.exe");
            webDriver.get(fullURL);
            webDriver.manage().window().maximize();
        }
        if(browserName.equalsIgnoreCase("IE")){
            webDriver=new InternetExplorerDriver();
            System.setProperty("webdriver.ie.driver",".\\IEDriverServer.exe");
            webDriver.get(fullURL);
            webDriver.manage().window().maximize();
        }
        return webDriver;
    }


    public void CloseBrowser(){
        webDriver.quit();
    }
}
