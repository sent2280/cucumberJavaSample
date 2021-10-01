package SupportComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class GenericMethods {

    public ChromeDriver driver;

    public void invokeBrowser(){
        System.setProperty("webdriver.chrome.driver","F:/TestLeaf/Drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }
    public boolean timeComparision(String startTimeRange, String endTimeRange, String inputTime){
        SimpleDateFormat format = new SimpleDateFormat("HH:mm");
        Date startTimeRangeObj;
        Date endTimeRangeObj;
        Date inputTimeObj;

        try {
             startTimeRangeObj = format.parse(startTimeRange);
             endTimeRangeObj = format.parse(endTimeRange);
             inputTimeObj = format.parse(inputTime);
            if( inputTimeObj.after(startTimeRangeObj) & inputTimeObj.before(endTimeRangeObj)){
                return true;
            } else {
                return false;
            }
        }catch(Exception e1){
            System.out.println(e1.getStackTrace());
        }
        return false;

    }
    public void waitUntilTheElementLocated(ChromeDriver driver,By element, int maxTime){

        WebDriverWait wait = new WebDriverWait(driver,maxTime);
        wait.until(ExpectedConditions.presenceOfElementLocated(element));
    }

}
