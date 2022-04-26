package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

public class LoginTest extends Utility {
    String baseUrl = "https://courses.ultimateqa.com/";
    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }
    @Test
    public void userShouldNavigateToLoginPageSuccessfully(){
        //Finding sign in link element and click on sign in link
        clickOnElement(By.linkText("Sign In"));

        //Validate expected and actual message
        verifyElements("Welcome Back message not displayed","Welcome Back!",By.xpath("//h1[contains(text(),'Welcome Back!')]"));
    }
    @Test
    public void verifyTheErrorMessage(){
        //Finding sign in link element and click on sign in link
        clickOnElement(By.linkText("Sign In"));

        //Finding the email field element
        sendTextToElement(By.id("user[email]"),"Asdfg@gmail.com");

        // Finding the password field element
        sendTextToElement(By.id("user[password]"),"abc123");

        // Finding the Sign in button and clicking on it
        clickOnElement(By.xpath("//div/input[@value='Sign in']"));

        //Validate expected and actual message
        verifyElements("Login unsuccessful","Invalid email or password.",By.xpath("//li[contains(text(),'Invalid email or password.')]"));
    }

    @After
    public void tearDown(){
        closeBrowser();
    }
}
