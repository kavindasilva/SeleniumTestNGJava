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


public class Exercise1 {
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
  
  //open url
  @Test(priority=1) //1
  public void openURL() {
	  driver.get(baseUrl);
  }
  
  //properties
  @Test(priority=2) //2
  public void clickProperty() {
	  driver.findElement(By.cssSelector("body > div.app-content > div.home-top > div > div.home-focus > div > div:nth-child(1) > div:nth-child(2) > a")).click();
  }
  
  //houses
  @Test(priority=3) //3
  public void clickHouses() {
	  /*if(!driver.findElement(By.xpath("/html/body/div[3]/div/div[1]/div[2]/div[2]/div[1]/div[1]/div/div/form/div/div[3]/div/ul/li/ul[1]/li/ul/li[2]/a/span")).isDisplayed()){
		  System.out.print("house button not found");
	  }*/
	  driver.findElement(By.cssSelector("body > div.app-content > div > div.serp-listing > div.ui-panel.is-rounded.serp-panel > div.ui-panel-content.ui-panel-block > div:nth-child(1) > div.col-12.lg-3.lg-filter-area > div > div > form > div > div:nth-child(3) > div > ul > li > ul:nth-child(2) > li > ul > li.ui-link-tree-item.cat-411 > a")).click();
  }
  
  //colombo
  @Test(priority=4) //4
  public void clickDistrict() {
	  driver.findElement(By.cssSelector("body > div.app-content > div > div.serp-listing > div.ui-panel.is-rounded.serp-panel > div.ui-panel-content.ui-panel-block > div:nth-child(1) > div.col-12.lg-3.lg-filter-area > div > div > form > div > div:nth-child(4) > div > ul > li > ul > li.ui-link-tree-item.loc-1506 > a")).click();
  }
  
  @Test(priority=5) //
  public void setMinMax() {
	  //  /html/body/div[3]/div/div[1]/div[2]/div[2]/div[1]/div[1]/div/div/form/div/div[6]/a/span
	  if(!driver.findElement(By.xpath("//*[@id='filters[0][minimum]']")).isDisplayed()){
		  driver.findElement(By.cssSelector("body > div.app-content > div > div.serp-listing > div.ui-panel.is-rounded.serp-panel > div.ui-panel-content.ui-panel-block > div:nth-child(1) > div.col-12.lg-3.lg-filter-area > div > div > form > div > div.ui-accordion-item.filter-price > a")).click();
	  }
	  driver.findElement(By.xpath("//*[@id='filters[0][minimum]']")).sendKeys("5000000");
	  driver.findElement(By.xpath("//*[@id='filters[0][maximum]']")).sendKeys("7500000");
  }
  
  @Test(priority=6) //6
  public void clickApply() {
	  driver.findElement(By.cssSelector("body > div.app-content > div > div.serp-listing > div.ui-panel.is-rounded.serp-panel > div.ui-panel-content.ui-panel-block > div:nth-child(1) > div.col-12.lg-3.lg-filter-area > div > div > form > div > div.ui-accordion-item.filter-price.is-open > div > div:nth-child(6) > div > div > button")).click();
  }
  
  @Test(priority=7) //
  public void beds3() {
	  if(!driver.findElement(By.xpath("//*[@id='filters2values-3']")).isDisplayed()){
		  driver.findElement((By.cssSelector("body > div.app-content > div > div.serp-listing > div.ui-panel.is-rounded.serp-panel > div.ui-panel-content.ui-panel-block > div:nth-child(1) > div.col-12.lg-3.lg-filter-area > div > div > form > div > div.ui-accordion-item.filter-enum.filter-bedrooms > a"))).click();
	  }
	//*[@id="filters2values-3"]
	  driver.findElement(By.xpath("//*[@id='filters2values-3']")).click();
  }
  
  @Test(priority=8) //8
  public void adCount() throws InterruptedException {
	  int totAds=1;
	  int totHouses=Integer.parseInt(driver.findElement(By.cssSelector("body > div.app-content > div > div.serp-listing > div.ui-panel.is-rounded.serp-panel > div.ui-panel-content.ui-panel-block > div:nth-child(1) > div.col-12.lg-9 > div > div > div:nth-child(1) > div > div > div > span")).getText().substring(driver.findElement(By.cssSelector("body > div.app-content > div > div.serp-listing > div.ui-panel.is-rounded.serp-panel > div.ui-panel-content.ui-panel-block > div:nth-child(1) > div.col-12.lg-9 > div > div > div:nth-child(1) > div > div > div > span")).getText().indexOf("of")+3,driver.findElement(By.cssSelector("body > div.app-content > div > div.serp-listing > div.ui-panel.is-rounded.serp-panel > div.ui-panel-content.ui-panel-block > div:nth-child(1) > div.col-12.lg-9 > div > div > div:nth-child(1) > div > div > div > span")).getText().indexOf("ads")-1));
	  
	  //ads per page 25
	  for (int i=0; i<totHouses/25 + 1; i++){
	  //while(driver.findElement(By.cssSelector("body > div.app-content > div > div.serp-listing > div.ui-panel.is-rounded.serp-panel > div.ui-panel-content.ui-panel-block > div.row.lg-g > div > div > div > div > div > a")).isDisplayed()){
		  
          WebElement nItems = driver.findElement(By.cssSelector("body > div.app-content > div > div.serp-listing > div.ui-panel.is-rounded.serp-panel > div.ui-panel-content.ui-panel-block > div:nth-child(1) > div.col-12.lg-9 > div > div > div.row.lg-g > div.col-12.lg-9 > div"));
          List<WebElement> ads = nItems.findElements(By.className("ui-item"));

          for (WebElement item : ads) {
              System.out.print("Ad Number "+ totAds+" Price is : "+item.findElement(By.className("item-info")).getText() + " "+ validatePrice(Integer.parseInt(item.findElement(By.className("item-info")).getText().replace("Rs ", "").replace(",",""))) + " "); 
              System.out.println(validateBeds(Integer.parseInt(item.findElement(By.className("item-meta")).getText().substring(item.findElement(By.className("item-meta")).getText().indexOf("Beds")+6,item.findElement(By.className("item-meta")).getText().indexOf(",")))));

              totAds++;
          }
          
          Thread.sleep(2000);

          if(i!=totHouses/25){ //check for last page
              //next button click
              driver.findElement(By.cssSelector("body > div.app-content > div > div.serp-listing > div.ui-panel.is-rounded.serp-panel > div.ui-panel-content.ui-panel-block > div.row.lg-g > div > div > div > div > div > a.col-6.lg-3.pag-next")).click();
          }
          
          Thread.sleep(2000);
      }
	  
	  

  }
  
  //exit the testing
  @AfterTest //------------------------------------------------------
  public void exits() {
	  driver.close();
  }
  
  //validate price
  public static String validatePrice(int price){
      if(price>= 5000000 && price<=7500000){
    	  return " ";
      }
      else{
    	  //System.out.print("Out of price range");
    	  return " price invalid ";
      }
  }

  //validate beds
  public static String validateBeds(int beds){
      if(beds!=3){
    	  //System.out.println("Wrong number of beds");
    	  return " beds invalid ";
      }
      else{
    	  return " ";
      }
  }
}
