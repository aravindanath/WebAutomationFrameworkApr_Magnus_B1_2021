package pages;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class BasePage {

    protected WebDriver driver;

    public BasePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }



    public static String getValue(String key)  {

        String path = System.getProperty("user.dir")+File.separator+"config.properties";
        String value = null;
        try {
            FileInputStream fis = new FileInputStream(path);
            Properties prop = new Properties();
            prop.load(fis);
            value = prop.getProperty(key);

        }catch (Exception e){
            e.printStackTrace();
        }
        return value;

    }




    public static void acceptAlert(WebDriver driver){
        Alert alert =  driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.accept();
    }

    public static void dismissAlert(WebDriver driver){
        Alert alert =  driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.dismiss();
    }

    public static void acceptAlert(WebDriver driver,String text){
        Alert alert =  driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.sendKeys(text);
        alert.accept();
    }


    public static void mouseHover(WebDriver driver, WebElement element){
        Actions act= new Actions(driver);
        act.moveToElement(element).build().perform();
    }

    public static void actionClick(WebDriver driver, WebElement element){
        Actions act= new Actions(driver);
        act.click(element).build().perform();
    }

    public static void rightClick(WebDriver driver, WebElement element){
        Actions act= new Actions(driver);
        act.contextClick(element).build().perform();
    }

    public static void randomRightClick(WebDriver driver){
        Actions act= new Actions(driver);
        act.contextClick().build().perform();
    }

    public static void selectByvisibleText(WebElement element, String text){
        Select sel = new Select(element);
        sel.selectByVisibleText(text);
    }

    public static void selectByvalueText(WebElement element, String text){
        Select sel = new Select(element);
        sel.selectByValue(text);
    }

    public static void selectByindex(WebElement element, int val){
        Select sel = new Select(element);
        sel.selectByIndex(val);
    }



    public static void takeScreenShot(WebDriver driver) throws IOException {
        //Convert web driver object to Takescrrenshot
        TakesScreenshot scrShot = (TakesScreenshot) driver;
        // Call ScreenshotAS METHOD TO CREATE IMAGE FILE
        File scrFile =  scrShot.getScreenshotAs(OutputType.FILE);
        //MOVE THE FILE TO NEW DESTINAtion
        String path = System.getProperty("user.dir")+File.separator+"demo.png";
        File destFile = new File(path);
        FileUtils.copyFile(scrFile,destFile);

    }


    public  static void deSelectByText(WebElement element,String text){
        Select sel = new Select(element);
        sel.deselectByVisibleText(text);
    }
    public static void deSelectByindex(WebElement element,int index){
        Select sel = new Select(element);
        sel.deselectByIndex(index);
    }

    public static void deSelectByvalue(WebElement element,String  val){
        Select sel = new Select(element);
        sel.deselectByValue(val);
    }



    public static void selectByvalue(WebElement element,String  val){
        Select sel = new Select(element);
        sel.selectByValue(val);
    }


    public void verifyText(WebElement element,String excepted){

       String actual = element.getText();

        Assert.assertEquals(actual, excepted,"Title not match");

    }

    public void verifyElementPrest(WebElement element){
        String actual = element.getText();
        System.out.println("Text "+ actual);
        waitforElement(2000);
        Assert.assertTrue(element.isDisplayed(),"Text is not displayed");

    }


    public static void waitforElement(long time){
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
