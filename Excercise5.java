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

public class Excercise5 {

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
		
		//*[@id='top']/body/div/div/div[3]/div/div[4]/ul/li[1]/a
		WebElement myAccountLink = driver.findElement(By.xpath("//*[@id='top']/body/div/div/div[3]/div/div[4]/ul/li[1]/a"));
		myAccountLink.click();

		//*[@id='login-form']/div/div[1]/div[2]/a
		WebElement createAccountLink = driver.findElement(By.xpath("//*[@id='login-form']/div/div[1]/div[2]/a"));
		createAccountLink.click();
		
		//*[@id='firstname']
		WebElement firstNameTextBox = driver.findElement(By.xpath("//*[@id='firstname']"));
		firstNameTextBox.sendKeys("Johny");
		
		//*[@id='lastname']
		WebElement lastNameTextBox = driver.findElement(By.xpath("//*[@id='lastname']"));
		lastNameTextBox.sendKeys("Bravo");
		
		//*[@id='email_address']
		WebElement emaiIdTextBox = driver.findElement(By.xpath("//*[@id='email_address']"));
		emaiIdTextBox.sendKeys("johnybravo0101@gmail.com");
		
		//*[@id='password']
		WebElement passwordTextBox = driver.findElement(By.xpath("//*[@id='password']"));
		passwordTextBox.sendKeys("Abc@123");
		
		//*[@id='confirmation']
		WebElement pwdConfirmTextBox = driver.findElement(By.xpath("//*[@id='confirmation']"));
		pwdConfirmTextBox.sendKeys("Abc@123");
		
		//*[@id='form-validate']/div[2]/button
		WebElement registerButton = driver.findElement(By.xpath("//*[@id='form-validate']/div[2]/button"));
		registerButton.click();
		sleep(5);
		
		
		
		
		
		//*[@id='top']/body/div/div/div[2]/div/div[2]/div/div/ul/li/ul/li/span
		
		WebElement regSuccessMsgText = driver.findElement(By.xpath("//*[@id='top']/body/div/div/div[2]/div/div[2]/div/div/ul/li/ul/li/span"));
		String regSuccessMsg = regSuccessMsgText.getText();
		System.out.println("Registation success message is: " + regSuccessMsg);
		
//		Thank you for registering with Main Website Store.
		assertEquals(regSuccessMsg,"Thank you for registering with Main Website Store.");
		
		//*[@id='nav']/ol/li[2]/a
		WebElement TVlink = driver.findElement(By.xpath("//*[@id='nav']/ol/li[2]/a"));
		TVlink.click();
		
		//*[@id='top']/body/div/div/div[2]/div/div[2]/div[1]/div[2]/ul/li[1]/div/div[3]/ul/li[1]/a
		WebElement TVaddToWishListButton = driver.findElement(By.xpath("//*[@id='top']/body/div/div/div[2]/div/div[2]/div[1]/div[2]/ul/li[1]/div/div[3]/ul/li[1]/a"));
		TVaddToWishListButton.click();
		
		//*[@id='wishlist-view-form']/div/div/button[1]/span/span
		
		WebElement shareWishlistButton = driver.findElement(By.xpath("//*[@id='wishlist-view-form']/div/div/button[1]/span/span"));
		shareWishlistButton.click();
		
		//*[@id='email_address']
		WebElement shareEmailID = driver.findElement(By.xpath("//*[@id=\"email_address\"]"));		
		shareEmailID.sendKeys("thisisemail@gmail.com");
		
		WebElement shareMessage = driver.findElement(By.xpath("//*[@id=\"message\"]"));
		shareMessage.sendKeys("This is test message");
		
		sleep(3);
		
		WebElement shareWishlistBtn = driver.findElement(By.xpath("//*[@id=\"form-validate\"]/div[2]/button"));
		shareWishlistBtn.click();
		
//		Your Wishlist has been shared.
		WebElement shareSuccessMsg = driver.findElement(By.xpath("//*[@id=\"top\"]/body/div/div/div[2]/div/div[2]/div/div[1]/ul/li/ul/li/span"));
		String shareScssMsg = shareSuccessMsg.getText();
		System.out.println("Success share msg is: " + shareScssMsg);
		assertEquals(shareScssMsg,"Your Wishlist has been shared.");
		
		
		
	}

	@AfterTest
	public void afterTest() {

		driver.quit();
	}

}
