package Steps;

import Base.BaseUtil;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;

import java.security.spec.RSAOtherPrimeInfo;
import java.util.ArrayList;
import java.util.List;

public class LoginSteps {

    private BaseUtil base;


    public LoginSteps(BaseUtil base) {
        this.base = base;
    }

    @Given("^I navigate to the login page$")
    public void iNavigateToTheLoginPage() {
        System.out.println("Open page");
        base.driver.navigate().to("http://www.executeautomation.com/demosite/Login.html");
    }

    @And("^I enter the login as \"([^\"]*)\" and password as \"([^\"]*)\"$")
    public void iEnterTheLoginAsAndPasswordAs(String username, String password) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("credentials");
        base.driver.findElement(By.name("UserName")).sendKeys(username);
        base.driver.findElement(By.name("Password")).sendKeys(password);
    }

    @And("^I click login button$")
    public void iClickLoginButton() {
        System.out.println("Click");
        base.driver.findElement(By.name("Login")).submit();
    }

    @Then("^I should see the userform page$")
    public void iShouldSeeTheUserformPage() {
        System.out.println("page visible");
        Assert.assertEquals("Its not displayed", base.driver.findElement(By.id("details")).isDisplayed(), true);
    }

    @And("I enter the following for Login")
    public void iEnterTheFollowingForLogin(DataTable table) {
       List<User> users = new ArrayList<User>();
       users = table.asList(User.class);
       for(User user: users) {
           System.out.println("Username is: " + user.username);
           System.out.println("Password is:" + user.password);
       }
    }


    @And("^I enter ([^\"]*) and ([^\"]*)$")
    public void iEnterUsernameAndPassword(String username,String password) {
        base.driver.findElement(By.name("UserName")).sendKeys(username);
        base.driver.findElement(By.name("Password")).sendKeys(password);
    }


    public class User {
        public String username;
        public String password;

        public User(String userName, String passWord) {
            username= userName;
            password = passWord;
        }
    }
}
