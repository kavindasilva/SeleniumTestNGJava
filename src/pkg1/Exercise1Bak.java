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
import java.util.List;;


public class Exercise1Bak {
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
      //driver.get(baseUrl);
  }//----------------------------------------------------------------
  
  @Test(priority=1) //1
  public void openURL() {
	  driver.get(baseUrl);
  }
  
  @Test(priority=2)
  public void clickProperty() {
	  driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[3]/div/div[1]/div[2]/a/span[1]")).click();
  }
  
  @Test(priority=3)
  public void clickHouses() {
	  if(!driver.findElement(By.xpath("/html/body/div[3]/div/div[1]/div[2]/div[2]/div[1]/div[1]/div/div/form/div/div[3]/div/ul/li/ul[1]/li/ul/li[2]/a/span")).isDisplayed()){
		  System.out.print("house btn not found");
	  }
	  driver.findElement(By.xpath("/html/body/div[3]/div/div[1]/div[2]/div[2]/div[1]/div[1]/div/div/form/div/div[3]/div/ul/li/ul[1]/li/ul/li[2]/a/span")).click();
  }
  
  @Test(priority=4) //4
  public void clickDistrict() {
	  if(!driver.findElement(By.xpath("/html/body/div[3]/div/div[1]/div[2]/div[2]/div[1]/div[1]/div/div/form/div/div[4]/div/ul/li/ul/li[1]/a/span")).isDisplayed()){
		  driver.findElement(By.xpath("/html/body/div[3]/div/div[1]/div[2]/div[2]/div[1]/div[1]/div/div/form/div/div[4]/a/span")).click();
	  }
	  driver.findElement(By.xpath("/html/body/div[3]/div/div[1]/div[2]/div[2]/div[1]/div[1]/div/div/form/div/div[4]/div/ul/li/ul/li[1]/a/span")).click();
  }
  
  @Test(priority=5) //
  public void setMinMax() {
	  //  /html/body/div[3]/div/div[1]/div[2]/div[2]/div[1]/div[1]/div/div/form/div/div[6]/a/span
	  if(!driver.findElement(By.xpath("//*[@id='filters[0][minimum]']")).isDisplayed()){
		  driver.findElement(By.xpath("/html/body/div[3]/div/div[1]/div[2]/div[2]/div[1]/div[1]/div/div/form/div/div[6]/a")).click();
	  }
	  driver.findElement(By.xpath("//*[@id='filters[0][minimum]']")).sendKeys("5000000");
	  driver.findElement(By.xpath("//*[@id='filters[0][maximum]']")).sendKeys("7500000");
  }
  
  @Test(priority=6) //6
  public void clickApply() {
	  driver.findElement(By.xpath("/html/body/div[3]/div/div[1]/div[2]/div[2]/div[1]/div[1]/div/div/form/div/div[6]/div/div[2]/div/div/button")).click();
  }
  
  @Test(priority=7) //
  public void beds3() {
	  if(!driver.findElement(By.xpath("//*[@id='filters2values-3']")).isDisplayed()){
		  driver.findElement(By.xpath("/html/body/div[3]/div/div[1]/div[2]/div[2]/div[1]/div[1]/div/div/form/div/div[8]/a/span")).click();
	  }
	//*[@id="filters2values-3"]
	  driver.findElement(By.xpath("//*[@id='filters2values-3']")).click();
  }
  
  @Test(priority=8) //8
  public void adCount() {
	  int totAds=0;
	  System.out.println("Next count= "+driver.findElements(By.xpath("/html/body/div[2]/div/div[1]/div[2]/div[2]/div[3]/div/div/div/div/div/a/span")).size());
	  
	  while(driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div[2]/div[2]/div[3]/div/div/div/div/div/a/svg")).isEnabled()){
	  //while(driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div[2]/div[2]/div[3]/div/div/div/div/div/a/span")).) {
		    //driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div[2]/div[2]/div[3]/div/div/div/div/div/a/span")).click(); //next page
		    
		    List<WebElement> forms = driver.findElements(By.xpath("/html/body/div[2]/div/div[1]/div[2]/div[2]/div[1]/div[2]/div/div/div[2]/div[1]/div div"));
		    int count = forms.size();
		    totAds+=count;
		    System.out.print("temp= "+totAds);
		    
		    driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div[2]/div[2]/div[3]/div/div/div/div/div/a/span")).click(); //next pg
		}
  }
  
  @AfterTest //------------------------------------------------------
  public void exits() {
	  driver.close();
  }
}
