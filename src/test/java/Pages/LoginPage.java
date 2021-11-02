package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Utils.CommonMethods;

public class LoginPage extends CommonMethods {


    @FindBy(id = "txtUsername")
    public WebElement usernameBox;

    @FindBy(id = "txtPassword")
    public WebElement passwordBox;

    @FindBy(id = "btnLogin")
    public WebElement loginBtn;


    @FindBy(id = "spanMessage")
    public WebElement errorMessage;

    @FindBy(xpath="//span[text()='Invalid credentials']")
    public WebElement invalidCredentialMessage;

    public LoginPage() {

        PageFactory.initElements(driver, this);


    }

    public void login(String username, String password) {

        sendText(usernameBox, username);
        sendText(passwordBox, password);
        click(loginBtn);


    }


}
