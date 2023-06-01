package wordpress;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.openqa.selenium.support.ui.Select;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Pdf;
import org.openqa.selenium.PrintsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.print.PrintOptions;

public class Excercise9 {

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
	public void guru99Day9Assignment() throws IOException {

		//reorder the product
		
		driver.get("http://live.techpanda.org/index.php/");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//mobile button
		WebElement mobileButton = driver.findElement(By.xpath("//*[@id=\"nav\"]/ol/li[1]/a"));
		mobileButton.click();

		
		//add to cart iPhone
		WebElement addToCartIphone = driver.findElement(By.xpath("//*[@id=\"top\"]/body/div/div/div[2]/div/div[2]/div[1]/div[3]/ul/li[3]/div/div[3]/button"));
		addToCartIphone.click();

		
		//discount text box
		WebElement discountCodeTextBox = driver.findElement(By.xpath("//*[@id=\"coupon_code\"]"));
		discountCodeTextBox.clear();
		discountCodeTextBox.sendKeys("GURU50");
		
		//apply button
		WebElement applyButton = driver.findElement(By.xpath("//*[@id=\"discount-coupon-form\"]/div/div/div/div/button/span/span"));
		applyButton.click();
		
		//discounted amount = -$25.00
		WebElement discountedAmount = driver.findElement(By.xpath("//*[@id=\"shopping-cart-totals-table\"]/tbody/tr[2]/td[2]/span"));
		String discountedAmountText = discountedAmount.getText();
		assertEquals(discountedAmountText,"-$25.00");
		
		
		
		
		
		
	}

	@AfterTest
	public void afterTest() {

		driver.quit();
	}

}
