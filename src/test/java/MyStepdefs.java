import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.After;
import org.junit.AfterClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MyStepdefs {
    WebDriver driver;

    @Before
    public void getBrowser() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver81");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Given("I am on the Google search page")
    public void iAmOnTheGoogleSearchPage() {
        driver.navigate().to("https://www.google.com/");
    }

    @When("I search for {string}")
    public void iSearchFor(String searchText) throws InterruptedException {
        driver.findElement(By.name("q")).sendKeys(searchText);
        Thread.sleep(5000);
        driver.findElement(By.xpath("//div[@class='FPdoLc tfB0Bf']//*[@name='btnK']")).submit();
//        driver.findElement(By.id("lga")).click();
//        driver.findElement(By.xpath("//div[@class='FPdoLc tfB0Bf']//*[@name='btnK']")).click();
        // bu yukarida yorumlanmis kisim, @Then 'in calismama nedeniymis.


    }

    @Then("I should see the number of search results")
    public void iShouldSeeTheNumberOfSearchResults() throws InterruptedException {
        WebElement result = driver.findElement(By.id("result-stats"));
        String results= result.getText();
        System.out.println("results = " + results);
        
    }

//    @Then("the page title should start with {string}")
//    public void thePageTitleShouldStartWith(String arg0) {
//    }

    @After
    public void tearDown() {
        driver.quit();
    }


}
