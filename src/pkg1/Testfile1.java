package pkg1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

//import org.testng.annotations.Test;

public class Testfile1 {
    //public driver;
    public String baseUrl = "http://127.0.0.1/ucsc1/skm/";
    //String driverPath = "C:\\temp\\sware\\geckodriver.exe";
    //String driverPath = "C:\\temp\\sware\\geckodriver64.exe";
    String driverPath = "C:\\temp\\sware\\chromedriver.exe";
    //String driverPath = "C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe";
    
    public WebDriver driver ; 
    
    @BeforeTest
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //driver.get(baseUrl);
    }
/**/
    
    @Test(priority=1,enabled=true)
    //@Test(enabled=false)
    public void kscus1() throws InterruptedException{
    	System.out.print("custom 1 ");
    	driver.get(baseUrl);
    	//driver.close();
    	//Assert.assertEquals(driver.getTitle(), "s");
    	//driver.wait(2000);
    	try{
    	      Thread.sleep(10000);
    	      }
    	      catch(Exception e){
    	    	  System.out.print(e);
    	      }
    	//System.out.print("wait 1 finish");
    	System.out.print("T1 end");
    	//driver.close();
    }/***/
     
  //@Test(dependsOnMethods=kscus1)
    @Test(priority=2)
  public void verifyHomepageTitle() {
       
      System.out.println("launching firefox browser"); 
      //driver.get("http://127.0.0.1/dashboard/");
      //driver.navigate().to("http://127.0.0.1/dashboard/");
      //driver.get(baseUrl);
      
      //driver.findElement(By.name("submit")).click();
      //int wait = WaitUpTo(TimeSpan.FromSeconds(10));
      //var element = wait.Until(ExpectedConditions.ElementIsVisible((selector)));
      
      //String expectedTitle = "Welcome: Mercury Tours";
      String expectedTitle = "Welcome to XAMPP";
      String actualTitle = driver.getTitle();
      System.out.println("actual= "+actualTitle);
      //Assert.assertEquals(actualTitle, expectedTitle);
      
      /*
      try {
		Thread.sleep(4000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		System.out.print("catch");
		e.printStackTrace();
	}*/
      
      driver.findElement(By.xpath("//*[@id='myInput']")).sendKeys("12"); //working
      //driver.findElement(By.xpath("//*[@id='pricelist']/div[1]/button[2]")).click(); //working
      //driver.findElement(By.className("btn-warning")).click();
      //driver.findElement(By.className("btn btn-warning")).click();
      //driver.findElement(By.id("btn btn-warning")).click();
      
      try{
      Thread.sleep(5000);
      }
      catch(Exception e){
    	  System.out.print(e);
      }
      //driver.close();
  }
    
    @Test(priority=3)
    public void T3(){
    	System.out.print("test3");
    }
    
    @AfterTest
    void closeAll(){
    	driver.close();
    }
}