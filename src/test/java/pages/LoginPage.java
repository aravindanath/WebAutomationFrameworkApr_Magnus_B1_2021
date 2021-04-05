package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.JavaUtils;

import java.util.HashMap;

public class LoginPage extends BasePage{

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver,this);
    }




    // Object Repo
    @FindBy(xpath = "//h1[text()='Admin area demo']")
    private WebElement  header;


    @FindBy(id = "Email")
    private WebElement  emailText;


    @FindBy(id = "Password")
    private WebElement  passwordText;


    @FindBy(xpath = "//button[text()='Log in']")
    private WebElement  loginButton;




    // Business Logic


    HashMap<String, String> lp;


    public void verifyUserLogin(String workFlowID){
        lp = JavaUtils.readExcelData("Login",workFlowID);
        verifyText(header,lp.get("HEADER"));
        waitforElement(2000);
        emailText.clear();
        emailText.sendKeys(lp.get("USERNAME"));
        passwordText.clear();
        passwordText.sendKeys(lp.get("PASSWORD"));
        loginButton.click();
    }






}
