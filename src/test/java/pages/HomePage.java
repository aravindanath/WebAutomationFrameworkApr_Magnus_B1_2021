package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage{
    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }


    @FindBy(xpath = "//div[@id='navbarText']/ul/li[2]/a")
    public WebElement userName;

    @FindBy(xpath = "//h1[contains(text(),'Dashboard')]")
    public WebElement dashBoardTitle;



    public void verifyHomePage(){
        verifyText(dashBoardTitle,"Dashboard");
        verifyElementPrest(userName);

    }



}
