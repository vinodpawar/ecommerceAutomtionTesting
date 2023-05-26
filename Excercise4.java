package wordpress;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Excercise4 {

	WebDriver driver = new ChromeDriver();
	
	public void sleep(int seconds) {

		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	@BeforeTest
	public void beforeTest() {

		ChromeOptions co = new ChromeOptions();
		co.addArguments("--remote-allow-origins=*");

	}

	@Test
	public void guru99Day4Assignment() {
		

		driver.get("http://live.techpanda.org/index.php/");
		
		WebElement mobileButton = driver.findElement(By.xpath("//*[@id='nav']/ol/li[1]/a"));
		mobileButton.click();
		
		WebElement addToCompareXperia = driver.findElement(By.xpath("//*[@id='top']/body/div/div/div[2]/div/div[2]/div[1]/div[3]/ul/li[3]/div/div[3]/ul/li[2]/a"));
		addToCompareXperia.click();
		
		WebElement addToCompareIphone = driver.findElement(By.xpath("//*[@id='top']/body/div/div/div[2]/div/div[2]/div[1]/div[3]/ul/li[1]/div/div[3]/ul/li[2]/a"));
		addToCompareIphone.click();
		
		sleep(3);
		WebElement compareButton = driver.findElement(By.cssSelector("[title=\"Compare\"]"));
		compareButton.click();
		sleep(3);

		
		driver.get("http://live.techpanda.org/index.php/catalog/product_compare/index/");
		
		WebElement firstMobile = driver.findElement(By.xpath("//*[@id='product_comparison']/tbody[1]/tr[1]/td[1]/h2/a"));
		String firstMobileName = firstMobile.getText();
		System.out.println("First mobile name is: " + firstMobileName);
		
		assertEquals(firstMobileName,"SONY XPERIA");
		
		WebElement secondMobile = driver.findElement(By.xpath("//*[@id='product_comparison']/tbody[1]/tr[1]/td[2]/h2/a"));
		String secondMobileName = secondMobile.getText();
		System.out.println("Second mobile name is: " + secondMobileName);
		assertEquals(secondMobileName,"IPHONE");
		
		
	}

	@AfterTest
	public void afterTest() {

		driver.quit();
	}

}
