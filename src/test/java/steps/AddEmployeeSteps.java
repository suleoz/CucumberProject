package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import Pages.AddEmployeePage;
import Pages.DashBoardPage;
import Utils.CommonMethods;
import Utils.Constants;
import Utils.ExcelReading;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class AddEmployeeSteps extends CommonMethods {

    @When("user clicks on PIM option")
    public void user_clicks_on_pim_option() {
        DashBoardPage dash = new DashBoardPage();
        dash.pimOption.click();
    }


    @When("user clicks on Add Employee button")
    public void user_clicks_on_add_employee_button() {
        DashBoardPage dash = new DashBoardPage();
        dash.addEmployeeButton.click();
    }

    @When("user enters firstname middlename and lastname")
    public void user_enters_firstname_middlename_and_lastname() {
        AddEmployeePage addEmployeePage = new AddEmployeePage();
        sendText(addEmployeePage.firstName, "Nooran");
        sendText(addEmployeePage.middleName, "007break33manager");
        sendText(addEmployeePage.lastName, "khano");
    }


    @When("user deletes employee id")
    public void user_deletes_employee_id() {
        AddEmployeePage addEmployeePage = new AddEmployeePage();
        addEmployeePage.employeeId.clear();
    }


    @When("user selects checkbox")
    public void user_selects_checkbox() {
        AddEmployeePage addEmployeePage = new AddEmployeePage();
        click(addEmployeePage.createLoginCheckBox);
    }

    @When("user enters username password and confirmpassword")
    public void user_enters_username_password_and_confirmpassword() {
        AddEmployeePage addEmployeePage = new AddEmployeePage();
        sendText(addEmployeePage.createUsername, "nooran021234");
        sendText(addEmployeePage.createPassword, "Hum@nhrm123");
        sendText(addEmployeePage.rePassword, "Hum@nhrm123");

    }

    @When("user clicks on save button")
    public void user_clicks_on_save_button() {
        AddEmployeePage addEmployeePage = new AddEmployeePage();
        click(addEmployeePage.saveBtn);
    }

    @Then("employee added successfully")
    public void employee_added_successfully() {
        System.out.println("Employee added successfully");
    }

    @When("user enters {string} {string} and {string}")
    public void user_enters_and(String firstname, String middlename, String lastname) {

        AddEmployeePage addEmployeePage = new AddEmployeePage();
        sendText(addEmployeePage.firstName, firstname);
        sendText(addEmployeePage.middleName, middlename);
        sendText(addEmployeePage.lastName, lastname);
    }


    @When("user enters {string} {string} and {string} for an employee")
    public void user_enters_and_for_an_employee(String firstname, String middlename, String lastname) {
        AddEmployeePage addEmployeePage = new AddEmployeePage();
        sendText(addEmployeePage.firstName, firstname);
        sendText(addEmployeePage.middleName, middlename);
        sendText(addEmployeePage.lastName, lastname);
    }

    @When("I add multiple employees and verify that user has been added successfully")
    public void i_add_multiple_employees_and_verify_that_user_has_been_added_successfully(DataTable employees) throws InterruptedException {

        List<Map<String, String>> employeeNames = employees.asMaps();
        for (Map<String, String> employeeName : employeeNames) {
            String valueFirstName = employeeName.get("firstname");
            String valueMiddleName = employeeName.get("middlename");
            String valueLastName = employeeName.get("lastname");

            AddEmployeePage addEmployeePage = new AddEmployeePage();
            sendText(addEmployeePage.firstName, valueFirstName);
            sendText(addEmployeePage.middleName, valueMiddleName);
            sendText(addEmployeePage.lastName, valueLastName);
            click(addEmployeePage.saveBtn);

            //Assertion in hmework==> verify the employye has been added

            DashBoardPage dash=new DashBoardPage();
            click(dash.addEmployeeButton);
            Thread.sleep(3000);


        }




    }
    @When("user adds multiple employees from excel file using {string} sheet and verify the added employee")
    public void user_adds_multiple_employees_from_excel_file_using_sheet_and_verify_the_added_employee(String sheetName) {

        List<Map<String,String>> newEployees=ExcelReading.excelIntoListMap(Constants.TESTDATA_FILEPATH,sheetName);
        DashBoardPage dash=new DashBoardPage();

        AddEmployeePage add=new AddEmployeePage();

        Iterator<Map<String,String>> it= newEployees.iterator();
        while(it.hasNext()){

            Map<String,String> mapNewEmp=it.next();

            sendText(add.firstName,mapNewEmp.get("FirstName"));
            sendText(add.middleName,mapNewEmp.get("MiddleName"));
            sendText(add.lastName,mapNewEmp.get("LastName"));
            click(add.saveBtn);

            //AssertionInHW

            click(dash.addEmployeeButton);


        }


    }

}

