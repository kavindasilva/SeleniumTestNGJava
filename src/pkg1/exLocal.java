package pkg1;

/**
 * Testing done with PHPMyAdmin 
 * DB=kss
 * table=sem1r
 */

import org.testng.annotations.*;
//import java.awt.List;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class exLocal {
	//public String baseUrl = "http://127.0.0.1/phpmyadmin1/";
	public String baseUrl= "http://127.0.0.1/phpmyadmin/sql.php?server=1&db=kss&table=sem1r"; 
    //String driverPath = "C:\\selenium\\chromedriver.exe";
    String driverPath = "C:\\temp\\sware\\chromedriver.exe";
    public WebDriver driver ; 
    public String distr="Colombo";
    private int cnt=0;
    
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
	  //Assert.assertEquals(driver.getTitle(), "127.0.0.1 / 127.0.0.1 | phpMyAdmin 4.6.5.2");
  }

  /*
  @Test(priority=2, dependsOnMethods="openURL")
  public void clickProperty() throws InterruptedException {
	  Thread.sleep(3000);
	  //driver.findElement(By.xpath("//*[@id='page_content']/div[2]/table[2]/tbody/tr/td[3]")).click();
	  //driver.findElement(By.xpath("//*[@id='page_content']/div[2]/table[2]/tbody/tr/td[3]/form/input[10]")).click();
	  //driver.findElement(By.xpath("//*[@id='page_content']/div[2]/table[1]/tbody/tr/td[3]/form/input[10]")).click();;
	  //driver.findElement(By.name("navig")).click();;
	  driver.findElement(By.xpath("//*[@id='page_content']/div[2]/table[1]/tbody/tr/td[3]")).click();
  }                                //*[@id="page_content"]/div[2]/table[1]/tbody/tr/td[3]/form/input[10]
  /*
  @Test(priority=3)
  public void clickHouses() {
	  driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div[2]/div[2]/div[1]/div[1]/div/div/form/div/div[3]/div/ul/li/ul[1]/li/ul/li[2]/a/span")).click();
  }
  
  @Test(priority=4) //4
  public void clickDistrict() {
	  driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div[2]/div[2]/div[1]/div[1]/div/div/form/div/div[4]/div/ul/li/ul/li[1]/a/span")).click();
  }
  
  @Test(priority=5) //
  public void setMinMax() {
	  driver.findElement(By.xpath("//*[@id='filters[0][minimum]']")).sendKeys("5000000");
	  driver.findElement(By.xpath("//*[@id='filters[0][maximum]']")).sendKeys("7500000");
  }
  
  @Test(priority=6) //6
  public void clickApply() {
	  driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div[2]/div[2]/div[1]/div[1]/div/div/form/div/div[6]/div/div[2]/div/div/button")).click();
  }*/
  
  @Test(priority=2, dependsOnMethods="openURL")
  public void clickNextPage() throws InterruptedException {
	  Thread.sleep(3000);
	  cnt = driver.findElements(By.cssSelector("[class='table_results ajax pma_table'] tr")).size()-1;
	  
	  driver.findElement(By.xpath("//*[@id='page_content']/div[2]/table[1]/tbody/tr/td[3]")).click();
  } 
  
  @Test(priority=8) //8
  public void adCount() throws InterruptedException {
	  //List rows = (List) driver.findElement(By.cssSelector("[class='odd']"));
	  //List rows = (List) driver.findElement(By.xpath("//*[@id='resultsForm_30953']/div[1]/table[2]/tbody/tr[1]/td[5]"));
	  //List rows = (List) driver.findElement(By.cssSelector("[class='table_results ajax pma_table'] tr"));
	  //List<WebElement> rows = driver.findElements(By.cssSelector("[class='table_results ajax pma_table'] tr"));
	  //cnt= rows.size();
	  System.out.print(cnt); //working 25+1
	  
	  //  next btn xpath
	  //  /html/body/div[2]/div/div[1]/div[2]/div[2]/div[3]/div/div/div/div/div/a/span
	  System.out.println("Next count= "+driver.findElements(By.xpath("/html/body/div[2]/div/div[1]/div[2]/div[2]/div[3]/div/div/div/div/div/a/span")).size());
	  
//	  while(driver.findElement(By.xpath("//*[@id='page_content']/div[2]/table[1]/tbody/tr/td[3]/form/input[10]")).size()!=0) {
	  //while(driver.findElement(By.xpath("//*[@id='page_content']/div[2]/table[1]/tbody/tr/td[5]/form/input[8]")).isDisplayed()) {
	  //while(driver.findElement(By.xpath("//*[@id='page_content']/div[2]/table[1]/tbody/tr/td[5]")).isDisplayed()) {
	  //while(driver.findElement(By.xpath("//*[@id='page_content']/div[2]/table[1]/tbody/tr/td[5]/form")).isDisplayed() ) {  // |
	  while(driver.findElements(By.xpath("//*[@id='page_content']/div[2]/table[1]/tbody/tr/td[5]/form")).size()>0 ) {  // |
	  //while(driver.findElement(By.name("navig")).isDisplayed()){  
		  //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);  
		  System.out.println("Ele count= "+driver.findElements(By.xpath("//*[@id='page_content']/div[2]/table[1]/tbody/tr/td[5]/form")));
		  //driver.findElement(By.xpath("//*[@id='page_content']/div[2]/table[1]/tbody/tr/td[3]/form/input[8]")).click(); //next page
		  //driver.findElement(By.xpath("//*[@id='page_content']/div[2]/table[1]/tbody/tr/td[5]/form/input[8]")).click();
		  Thread.sleep(2000);
		  int x1=driver.findElements(By.cssSelector("[class='table_results ajax pma_table'] tr")).size()-1;
		  
		  cnt+=x1;
		  System.out.println("x="+x1+"; cnt= "+cnt);
		  
		  //driver.findElement(By.name("navig")).click(); //next page
		  //driver.findElement(By.tagName("Next")).click(); 
		  //driver.findElement(By.xpath("//*[@id='page_content']/div[2]/table[1]/tbody/tr/td[5]/form/input[8]")).click();
		  driver.findElement(By.xpath("//*[@id='page_content']/div[2]/table[1]/tbody/tr/td[5]")).click();

		  //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  //cnt += driver.findElements(By.cssSelector("[class='table_results ajax pma_table'] tr")).size();
		}
	  
	  int x1=driver.findElements(By.cssSelector("[class='table_results ajax pma_table'] tr")).size()-1;
	  cnt+=x1;
	  
	  System.out.println("tot rows= "+cnt);

  }
  
  @AfterTest //------------------------------------------------------
  public void exits() {
	  driver.close();
  }
}
