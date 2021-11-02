package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Utils.CommonMethods;

public class EmployeeListPage extends CommonMethods {


    public EmployeeListPage(){
        PageFactory.initElements(driver,this);
    }

    @FindBy(id="empsearch_id")
        public WebElement idEmployee;


    @FindBy(id="searchBtn")
    public WebElement searchButton;

    @FindBy(id="empsearch_employee_name_empName")
    public WebElement employeenamefield;

@FindBy(xpath="//*[@id=\"resultTable\"]/tbody/tr/td[3]/a")
    public WebElement displayedEmployeeName;

    @FindBy(xpath="//*[@id=\"resultTable\"]/tbody/tr/td[4]/a")
    public WebElement displayedEmployeeSurname;
}
