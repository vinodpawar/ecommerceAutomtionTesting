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

public class Excercise8 {

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
	public void guru99Day8Assignment() throws IOException {

		//reorder the product
		
		driver.get("http://live.techpanda.org/index.php/");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		WebElement myAccountLink = driver.findElement(By.xpath("//*[@id=\"top\"]/body/div/div/div[3]/div/div[4]/ul/li[1]/a"));
		myAccountLink.click();

		WebElement emailAddressTextBox = driver.findElement(By.xpath("//*[@id=\"email\"]"));
		emailAddressTextBox.sendKeys("johnybravo0101@gmail.com");
		
		WebElement passwordTextBox = driver.findElement(By.xpath("//*[@id=\"pass\"]"));
		passwordTextBox.sendKeys("Abc@123");

		//login button
		WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"send2\"]"));
		loginButton.click();
		
		//my orders
		WebElement reOrder = driver.findElement(By.xpath("//*[@id=\"my-orders-table\"]/tbody/tr[1]/td[6]/span/a[2]"));
		reOrder.click();
		
		// reorder textbox
		WebElement reOrderTextBox = driver.findElement(By.xpath("//*[@id=\"shopping-cart-table\"]/tbody/tr/td[4]/input"));
		reOrderTextBox.clear();
		reOrderTextBox.sendKeys("10");
		
		// update button
		WebElement updateButton = driver.findElement(By.xpath("//*[@id=\"shopping-cart-table\"]/tbody/tr/td[4]/button/span/span"));
		updateButton.click();

		// grand total
		WebElement grandTotal = driver.findElement(By.xpath("//*[@id=\"shopping-cart-totals-table\"]/tfoot/tr/td[2]/strong/span"));
		String grandTotalText = grandTotal.getText();
		assertEquals(grandTotalText,"$6,150.00");
		
		// proceed to checkout button
		WebElement proceedToCheckOutButton = driver.findElement(By.xpath("//*[@id=\"top\"]/body/div/div/div[2]/div/div/div/div[3]/div/ul/li[1]/button"));
		proceedToCheckOutButton.click();

		// billing information continue button
		WebElement billingInformationContinueButton = driver.findElement(By.xpath("//*[@id=\"billing-buttons-container\"]/button"));
		billingInformationContinueButton.click();
		
		//shipping method 'continue'
		WebElement shippingContinueButton = driver.findElement(By.xpath("//*[@id=\"shipping-method-buttons-container\"]/button/span/span"));
		shippingContinueButton.click();
		
		// money order 
		WebElement moneyOrderRadio = driver.findElement(By.xpath("//*[@id=\"dt_method_checkmo\"]/label"));
		moneyOrderRadio.click();

		// payment method continue button
		WebElement paymentContinue = driver.findElement(By.xpath("//*[@id=\"payment-buttons-container\"]/button"));
		paymentContinue.click();

		//place order button
		
		WebElement placeOrderButton = driver.findElement(By.xpath("//*[@id=\"review-buttons-container\"]/button"));
		placeOrderButton.click();
		
		//order ID noted
		WebElement orderID = driver.findElement(By.xpath("//*[@id=\"top\"]/body/div/div/div[2]/div/div/p[1]/a"));
		String orderIDtext = orderID.getText();
		System.out.println("Order ID is: " + orderIDtext);
	}

	@AfterTest
	public void afterTest() {

		driver.quit();
	}

}
