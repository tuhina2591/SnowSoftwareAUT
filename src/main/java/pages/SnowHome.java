package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SnowHome {
    WebDriver driver;
    Actions action;
    WebElement element;
    WebDriverWait wait;
    By successLink= By.linkText("Success");
    By globeCommLink=By.linkText("Snow Globe Community");

    public SnowHome(WebDriver driver){
        this.driver=driver;
        action=new Actions(driver);
        wait=new WebDriverWait(driver,60);
    }


    public void moveToSuccessLink() {
        element=driver.findElement(successLink);
        action.moveToElement(element).perform();
    }

    public By getGlobeCommLink() {
        return globeCommLink;
    }

    public void clickGlobeCommLink() throws InterruptedException {
        driver.findElement(globeCommLink).click();
        wait.until(ExpectedConditions.titleContains("Snow Globe"));
    }

}
