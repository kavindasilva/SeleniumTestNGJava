package pkg1;

/*
 * xpath List<WebElement> rows = driver.findElements(By.xpath("//table[@class='table table-condensed table-hover event-list']/tbody/tr"));
 * css   List<WebElement> rows = driver.findElement(By.cssSelector("[class='table table-condensed table-hover event-list'] tr"));
 * 
 * int count = rows.size();
 * for(WebElement e : rows) {
        assertEquals("expected text", e.getText());
    }
 */


import org.testng.annotations.*;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class exercise1 {
	public String baseUrl = "http://ikman.lk/";
    //String driverPath = "C:\\selenium\\chromedriver.exe";
    String driverPath = "C:\\temp\\sware\\chromedriver.exe";
    public WebDriver driver ; 
    public String distr="Colombo";
    
  @BeforeTest
  public void inits() {
	  System.setProperty("webdriver.chrome.driver", driverPath);
      driver = new ChromeDriver();
      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
      driver.get(baseUrl);
  }//----------------------------------------------------------------
  
  @Test(priority=0)
  public void openURL() {
  }
  
  @Test(priority=0)
  public void clickProperty() {
  }
  
  @Test(priority=0)
  public void clickHouses() {
  }
  
  @Test(priority=0)
  public void clickDistrict() {
  }
  
  @AfterTest //------------------------------------------------------
  public void exits() {
	  driver.close();
  }
}
