package pkg1;

import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.AfterClass;

public class NewTest2 {

	protected static WebDriver wd;
	protected static String result;

	@Test
	void Testcase1() {
		wd.get("http://www.floraindia.com");
		wd.findElement(By.id("kwsch")).sendKeys("Red");
		wd.findElement(By.xpath("//input[@src='images/go.gif']")).click();
		result = wd.findElement(By.xpath("//font[text()='Total Items  :']//following::td[1]")).getText();
		Assert.assertEquals(result, "115");

	}

	@Test
	boolean Testcase2() {
		boolean res=false;
		wd.get("http://www.floraindia.com");
		wd.findElement(By.id("kwsch")).sendKeys("Blue");
		wd.findElement(By.xpath("//input[@src='images/go.gif']")).click();
		result = wd.findElement(By.xpath("//font[text()='Total Items  :']//following::td[1]")).getText();
		Assert.assertEquals(result, "13");

		return res;
	}

	@Test
	void Testcase3() {
		wd.get("http://www.floraindia.com");
		wd.findElement(By.id("kwsch")).sendKeys("Yellow");
		wd.findElement(By.xpath("//input[@src='images/go.gif']")).click();
		result = wd.findElement(By.xpath("//font[text()='Total Items  :']//following::td[1]")).getText();
		Assert.assertEquals(result, "27");
	}

	@Test
	void Testcase4() {
		wd.get("http://www.floraindia.com");
		wd.findElement(By.id("kwsch")).sendKeys("Purple");
		wd.findElement(By.xpath("//input[@src='images/go.gif']")).click();
		result = wd.findElement(By.xpath("//font[text()='Total Items  :']//following::td[1]")).getText();
		Assert.assertEquals(result, "10");
	}

	@AfterClass
	public static void teardown() {
		wd.close();
		wd.quit();
	}

}