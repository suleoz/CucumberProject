package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Utils.CommonMethods;

import java.util.List;

public class DashBoardPage extends CommonMethods {

    @FindBy (id="welcome")
        public WebElement welcomeMessage;

    @FindBy (id="menu_pim_viewPimModule")
    public WebElement pimOption;

    @FindBy (id="menu_pim_addEmployee")
    public WebElement addEmployeeButton;

    @FindBy(id="menu_pim_viewEmployeeList")
    public WebElement employeeListOption;

    @FindBy(xpath="//*[@class='menu']/ul/li")
    public List<WebElement> dashboardTabs;

    @FindBy(id="menu_admin_viewAdminModule")
    public WebElement AdminButton;

    @FindBy(id="menu_admin_Qualifications")
    public WebElement QualificationButton;


    public DashBoardPage(){
        PageFactory.initElements(driver,this);
    }










}
