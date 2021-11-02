package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import Pages.DashBoardPage;
import Utils.CommonMethods;


import java.util.ArrayList;
import java.util.List;

public class DashBoardSteps extends CommonMethods {

    @Then("user verify the dashboard options available on the page")
    public void user_verify_the_dashboard_options_available_on_the_page(DataTable dataTable) {

        List<String> expectedTabs=dataTable.asList();

        DashBoardPage dash=new DashBoardPage();
        List<String> actualList=new ArrayList<>();

        for (WebElement ele: dash.dashboardTabs) {
            actualList.add(ele.getText());

        }

        System.out.println(actualList);
        System.out.println(expectedTabs);

        Assert.assertEquals(expectedTabs, actualList);

    }

}
