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

public class Excercise7 {

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
		co.addArguments("headless");
		

	}

	@Test
	public void guru99Day6Assignment() throws IOException {

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
		WebElement myOrder = driver.findElement(By.xpath("//*[@id=\"top\"]/body/div/div/div[2]/div/div[1]/div/div[2]/ul/li[4]/a"));
		myOrder.click();
		
		//view order	
		WebElement viewOrder = driver.findElement(By.xpath("//*[@id=\"my-orders-table\"]/tbody/tr[1]/td[6]/span/a[1]"));
		viewOrder.click();
		
		//print order button
		WebElement printOrder = driver.findElement(By.xpath("//*[@id=\"top\"]/body/div/div/div[2]/div/div[2]/div/div[1]/a[2]"));
		printOrder.click();

		//to save invoice page into PDF
		Pdf pdf = ((PrintsPage) driver).print(new PrintOptions());
		
		Files.write(Paths.get("./invoice.pdf"), OutputType.BYTES.convertFromBase64Png(pdf.getContent()));
		
		
	}

	@AfterTest
	public void afterTest() {

		driver.quit();
	}

}
