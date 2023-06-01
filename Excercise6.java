package wordpress;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.openqa.selenium.support.ui.Select;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Excercise6 {

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
	public void guru99Day6Assignment() {

		driver.get("http://live.techpanda.org/index.php/");
		
		WebElement myAccountLink = driver.findElement(By.xpath("//*[@id=\"top\"]/body/div/div/div[3]/div/div[4]/ul/li[1]/a"));
		myAccountLink.click();

		WebElement emailAddressTextBox = driver.findElement(By.xpath("//*[@id=\"email\"]"));
		emailAddressTextBox.sendKeys("johnybravo0101@gmail.com");
		
		WebElement passwordTextBox = driver.findElement(By.xpath("//*[@id=\"pass\"]"));
		passwordTextBox.sendKeys("Abc@123");

		WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"send2\"]"));
		loginButton.click();
		
		WebElement myWishListLink = driver.findElement(By.xpath("//*[@id=\"top\"]/body/div/div/div[2]/div/div[1]/div/div[2]/ul/li[8]/a"));
		myWishListLink.click();
		
		//add to cart
		WebElement addToCartLink = driver.findElement(By.xpath("//*[@id=\"item_67583\"]/td[5]/div/button/span/span"));
		addToCartLink.click();
		sleep(3);

		Select stateDropDown = new Select(driver.findElement(By.xpath("//*[@id='region_id']")));
		stateDropDown.selectByVisibleText("New York");
		sleep(3);
		
		WebElement zipcodeTextBox = driver.findElement(By.xpath("//*[@id=\"postcode\"]"));
		zipcodeTextBox.sendKeys("542896");
		sleep(3);
		
		WebElement estimateLink = driver.findElement(By.xpath("//*[@id=\"shipping-zip-form\"]/div/button/span/span"));
		estimateLink.click();
		sleep(3);
		WebElement estimateBox = driver.findElement(By.xpath("//*[@id=\"co-shipping-method-form\"]/dl/dd/ul/li/label"));
		String estimateValue = estimateBox.getText();
		assertEquals(estimateValue,"Fixed - $5.00");

		WebElement updateTotalButton = driver.findElement(By.xpath("//*[@id=\"co-shipping-method-form\"]/div/button"));
		updateTotalButton.click();

		WebElement totalCost = driver.findElement(By.xpath("//*[@id=\"shopping-cart-totals-table\"]/tfoot/tr/td[2]/strong/span"));
		String totalCostValue = totalCost.getText();
		assertEquals(totalCostValue,"$620.00");
		
		WebElement proceedToCheckout = driver.findElement(By.xpath("//*[@id=\"top\"]/body/div/div/div[2]/div/div/div/div[3]/div/ul/li[1]/button/span/span"));
		proceedToCheckout.click();
		
		WebElement continueButton = driver.findElement(By.xpath("//*[@id=\"billing-buttons-container\"]/button/span/span"));
		continueButton.click();
		
		WebElement shippingContinueButton = driver.findElement(By.xpath("//*[@id=\"shipping-method-buttons-container\"]/button"));
		shippingContinueButton.click();

		WebElement moneyOrderCheckbox = driver.findElement(By.xpath("//*[@id=\"dt_method_checkmo\"]/label"));
		moneyOrderCheckbox.click();

		WebElement moneyOrderContinueButton = driver.findElement(By.xpath("//*[@id=\"payment-buttons-container\"]/button"));
		moneyOrderContinueButton.click();

		WebElement placeOrderButton = driver.findElement(By.xpath("//*[@id=\"review-buttons-container\"]/button"));
		placeOrderButton.click();
		
		WebElement orderID = driver.findElement(By.xpath("//*[@id=\"top\"]/body/div/div/div[2]/div/div/p[1]/a"));
		String orderIDtext = orderID.getText();
		System.out.println("Your order ID is : " + orderIDtext);
		sleep(6);
		
	}

	@AfterTest
	public void afterTest() {

		driver.quit();
	}

}
