package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LicenseManager {
    WebDriver driver;
    WebDriverWait wait;

    By articleBlock = By.xpath("//div[contains(@class,'slds-page-header')]//span[contains(text(),'Article Number')]");
    By articleNumber = By.xpath("//div[contains(@class,'slds-page-header')]//span[contains(text(),'Article Number')]/..//span[@class='uiOutputText']");

    public LicenseManager(WebDriver driver){
        this.driver=driver;
        wait= new WebDriverWait(driver,60);
    }

    public String getArticleNumber() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(articleBlock));
        System.out.println("The Article Number Block is located, Waiting for the Actual Numbers");
        wait.until(ExpectedConditions.visibilityOfElementLocated(articleNumber));
        System.out.println("The actual numbers of article is located now, proceeding...");
        String articleNum=driver.findElement(articleNumber).getText();
        System.out.println("Article Number == "+articleNum);
        return articleNum;
    }
}
