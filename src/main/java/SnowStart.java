import org.openqa.selenium.WebDriver;
import pages.GlobeCommunity;
import pages.LicenseManager;
import pages.SnowHome;

public class SnowStart {

    public static void main(String args[]) throws InterruptedException {
        BrowserInit bi=new BrowserInit();
        WebDriver driver;
        driver=bi.OpenBrowser("Chrome","https://www.snowsoftware.com/");
        GlobeCommunity gc=new GlobeCommunity(driver);
        SnowHome sh=new SnowHome(driver);

        sh.moveToSuccessLink();
        sh.clickGlobeCommLink();
        gc.setSearchText("Snow License Manager");
        gc.clickReleaseLink();

        new LicenseManager(driver).getArticleNumber();

        System.out.println("----Started Sleeping for 5 Secs");
        Thread.sleep(5000);
        System.out.println("----Sleep Completed,, Closing the browser");

        bi.CloseBrowser();
    }
}
