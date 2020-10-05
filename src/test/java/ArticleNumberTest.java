import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.GlobeCommunity;
import pages.LicenseManager;
import pages.SnowHome;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;


public class ArticleNumberTest{

    BrowserInit bi=new BrowserInit();
    WebDriver driver;
    GlobeCommunity gc;
    SnowHome sh;
    LicenseManager lm;
    Properties prop;

    @BeforeMethod
    public void setProperty() throws FileNotFoundException, IOException {
        prop = new Properties();
        prop.load(new FileInputStream("application.properties"));
    }

    @Test(priority=0)
    public void checkBrowserInit() {
        driver = bi.OpenBrowser(prop.getProperty("browserName"), prop.getProperty("fullURL"));
        Assert.assertEquals(driver.getTitle(),"Snow Software – The Technology Intelligence Platform");
    }

    @Test(priority=1)
    public void verifySnowGlobeRedirection() throws InterruptedException {
        sh = new SnowHome(driver);
        gc = new GlobeCommunity(driver);
        sh.moveToSuccessLink();
        sh.clickGlobeCommLink();
        String pageLabel = gc.getGlobeTitleText();
        Assert.assertEquals(pageLabel,"Welcome to Snow Globe");

    }
    @Test(priority=2)
    public void checkReleasePage(){
        gc = new GlobeCommunity(driver);
        gc.setSearchText(prop.getProperty("searchText"));
        gc.clickReleaseLink();
        Assert.assertEquals(driver.getTitle(),"Release Notes: Snow License Manager 9.7.1");

    }
    @Test(priority=3)
    public void checkArticleNumber() {
        lm = new LicenseManager(driver);
        Assert.assertEquals(lm.getArticleNumber(),"000013119");

    }
    @Test(priority=4)
    public void checkBrowserClose() {
        boolean flag;
        bi.CloseBrowser();
        try {
            driver.getTitle();
            flag=true;
        }catch(Exception e){
            flag=false;
        }
        Assert.assertFalse(flag);
    }
}
