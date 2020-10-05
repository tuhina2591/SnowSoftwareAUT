package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GlobeCommunity {
    WebDriver driver;

    By searchTextBox = By.xpath("//input[@placeholder='How can we help?']");
    By searchBtn = By.cssSelector("[title^='Search']");
    By releaseLink = By.xpath("//div[@class='result-container']//span[contains(text(),'Release Notes:')]");
    By dropDown = By.cssSelector("[class='result-container']");
    By welcomeText= By.xpath("//h2[contains(text(), 'Welcome to Snow Globe')]");
    WebDriverWait wait;


    public GlobeCommunity(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 60);
    }
    public String getGlobeTitleText(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchTextBox));
        String label= driver.findElement(welcomeText).getText();
        return label;
    }
    public void setSearchText(String searchTxt) {
        driver.findElement(searchTextBox).sendKeys(searchTxt);
        System.out.println("---Waiting for the dropdown to appear");
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(dropDown));
        System.out.println("---Wait Completed");
    }

    public void clickReleaseLink(){
        System.out.println("---Waiting for the Release link to be located");
        wait.until(ExpectedConditions.visibilityOfElementLocated(releaseLink));
        System.out.println("---Release link located, proceeding now");
        driver.findElement(releaseLink).click();
        System.out.println("---Waiting for the Release page to appear");
        wait.until(ExpectedConditions.titleIs("Release Notes: Snow License Manager 9.7.1"));
        System.out.println("---Wait Completed,,, Proceeding");
    }

}

