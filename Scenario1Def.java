package StepDefinition;

import SupportComponents.MonthMapping;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import SupportComponents.GenericMethods;
import SupportComponents.MonthMapping;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Scenario1Def extends GenericMethods{


    public WebDriverWait wait;
    public JavascriptExecutor js;
    ArrayList<Integer> index;
    public String trainName;
    private int trainIndex;


    @And("^Select the Journey date as \"([^\"]*)\"$")
    public void enterTheJourneyDateAs(String date) {
         String[] dateArray = date.split("-");
         driver.findElementByXPath("//img[@class='ui-datepicker-trigger']").click();
         String firstActualMonth = driver.findElementByXPath("(//span[@class='ui-datepicker-month'])[1]").getText();
         String secondActualMonth = driver.findElementByXPath("(//span[@class='ui-datepicker-month'])[2]").getText();
         String firstMonthYear = driver.findElementByXPath("(//span[@class='ui-datepicker-year'])[1]").getText();
         String  secondMonthYear = driver.findElementByXPath("(//span[@class='ui-datepicker-year'])[2]").getText();
         MonthMapping monthMapping1 = new MonthMapping();
         String inputMonth = monthMapping1.getstringFormOfMonth(Integer.parseInt(dateArray[1]));

        //Select day from first month of calendar
        if(inputMonth.equals(firstActualMonth) & firstMonthYear.equals(dateArray[2]) & firstMonthYear.equals(dateArray[2])) {
            OuterloopLable:
            for (int i = 1; i <= 5; i++) {
                for (int j = 1; j <= 7; j++) {
                    WebElement actualDayWebElement = driver.findElementByXPath("(//tbody[1]/tr["+i+"]/td["+j+"])[1]");
                    String actualDay = actualDayWebElement.getText();
                    if(actualDay.equals(dateArray[0])){
                        actualDayWebElement.click();
                        break OuterloopLable;
                    }

                }
                System.out.println();
            }
        }

        //Select day from first month of calendar
        if(inputMonth.equals(secondActualMonth)& secondMonthYear.equals(dateArray[2]) & secondMonthYear.equals(dateArray[2])) {
            OuterloopLable:
            for (int i = 1; i <= 5; i++) {
                for (int j = 1; j <= 7; j++) {
                    WebElement actualDayWebElement = driver.findElementByXPath("(//tbody[1]/tr["+i+"]/td["+j+"])[2]");
                    String actualDay = actualDayWebElement.getText();
                    //System.out.println(actualDayWebElement);
                    if(actualDay.equals(dateArray[0])){
                        actualDayWebElement.click();
                        break OuterloopLable;
                    }

                }
                System.out.println();
            }
        }
        else{
            System.out.println("Please provide the valid month/Year");
        }

//        }
//        for(int i=1;i<=5;i++){
//            for(int j=1;j<=7;j++){
//                boolean result = driver.findElementByXPath("(//tbody[1]/tr['++i++']/td['++j++'])[1]").isDisplayed();
//                System.out.format("%b %d %d ",result,i,j);
//
//            }
//            System.out.println();
    }

    @Given("^Open the chrome Browser$")
    public void openTheChromeBrowser() {
        invokeBrowser();
        //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        //JavascriptExecutor executor = (JavascriptExecutor) driver;
        //executor.executeScript("window.resizeTo(2966, 1168);");
        //driver.manage().window().maximize();
        //System.exit(1);
    }

    @And("^Load the Indian railway URL$")
    public void loadTheIndianRailwayURL(){

        driver.get("http://www.indianrail.gov.in/enquiry/TBIS/TrainBetweenImportantStations.html?locale=en");
    }

    @And("^Enter the Source station code as \"([^\"]*)\"$")
    public void enterTheSourceStationCodeAs(String sourceStation) {
        js = (JavascriptExecutor)driver;
        //js.executeScript("document.getElementById(\"sourceStation\").value=\'KSR BENGALURU - SBC\'");
        String SourceStationJS ="document.getElementById(\"sourceStation\").value=\'" + sourceStation + "\'";
        js.executeScript(SourceStationJS);
        }

    @And("^Enter the Destination station code as \"([^\"]*)\"$")
    public void enterTheDestinationStationCodeAs(String DestinationStation){
        //js.executeScript("document.getElementById(\"destinationStation\").value=\'DINDIGUL JN - DG\'");
        String destinationStationJS ="document.getElementById(\"destinationStation\").value=\'" + DestinationStation + "\'";
        js.executeScript(destinationStationJS);
    }

    @And("^Click on Go button$")
    public void clickOnGoButton() throws InterruptedException {
        //Thread.sleep(5000);
        //driver.findElementByXPath("(//input[@type='button'])[2]").click();
        WebElement goButtonElement = driver.findElementByXPath("(//input[@type='button'])[2]");
        js.executeScript("arguments[0].click();",goButtonElement);
    }

    @And("^Wait until user manually enters the captcha$")
    public void waitUntilUserManuallyEntersTheCaptcha() throws InterruptedException {
        Thread.sleep(12000);
    }

    @And("^test$")
    public void test() {
        MonthMapping test123 = new MonthMapping();
    }

    @And("^Identify the trains between \"([^\"]*)\" to \"([^\"]*)\"$")
    public void identifyTheTrainsBetweenTo(String startTime, String EndTime) {
        int rowSize = driver.findElementsByXPath("//table[@data-toggle='table']/tbody/tr").size();
        System.out.println("rowSize = " + rowSize);
        boolean result;
        int totalTrainInGivenTimeRange=0;
        index = new ArrayList<Integer>();
        for (int i = 1; i <= rowSize; i++) {
            WebElement trainTimeWebElement = driver.findElementByXPath("//table[@data-toggle='table']/tbody/tr["+i+"]/td[4]");
                String inputTime = trainTimeWebElement.getText();
                result = timeComparision(startTime,EndTime,inputTime);
              if(result){
                  ++totalTrainInGivenTimeRange;
                  index.add(i);
                  //System.out.format("\nindex of train, which falls in the time range is %d inputTime = %s",totalTrainInGivenTimeRange,inputTime);
              }
            //System.out.format("\nCurrently Number of trains falls in the time range is = %d", index.size());
            }
            System.out.println();
        }

    @And("^Click on the \"([^\"]*)\" link here SL refers sleeper$")
    public void clickOnTheLinkHereSLRefersSleeper(String typeOfClass) throws InterruptedException {
        trainIndex=3;
        //Iterate and identify SL
         for (int index1 :
                index) {

            List<WebElement> elements = driver.findElementsByXPath("//table[@data-toggle='table']/tbody/tr["+index1+"]/td[15]/a/u");
            trainName = driver.findElementByXPath("//table[@data-toggle='table']/tbody/tr["+index1+"]/td[1]/a").getText();
            for (WebElement element :
                    elements) {
                //System.out.println("index1 = " + index1 + " Sleeper Class = " + element.getText());
                if (element.getText().contains(typeOfClass)) {
//                  js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
//                  js.executeScript("arguments[0].scrollIntoView();",element);
//                  Thread.sleep(20000);
//                  Actions action1 = new Actions(driver);
//                  action1.moveToElement(element).build().perform();
//                  element.click();
                    js.executeScript("arguments[0].click();",element);
                    getTheAvailabilityOfAllTrainsInTheGivenTimeRange();
                    trainIndex = trainIndex + 2;
                }
            }
        }
    }

    public void getTheAvailabilityOfAllTrainsInTheGivenTimeRange() throws InterruptedException {
        //Thread.sleep(5000);
        waitUntilTheElementLocated(driver, By.xpath("(//table/tbody)[" + trainIndex + "]/tr[3]/td[2]"),15);
        String availability = driver.findElementByXPath("(//table/tbody)["+trainIndex+"]/tr[3]/td[2]").getText();
        //System.out.println("\nTrain Name = " + trainName +  " availability = " + availability);
        System.out.format("\r\nTrain Name = %s availability = %s",trainName,availability );
    }
}

