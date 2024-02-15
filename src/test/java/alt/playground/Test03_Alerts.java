package alt.playground;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Test03_Alerts {
	//
	WebDriver driver;

	//
	@BeforeTest
	public void setUp() {
		//
		driver = new ChromeDriver();
		driver.get("https://www.leafground.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	}

	//
	@AfterTest
	public void tearDown() {
		driver.quit();
	}

	//
	@Test
	public void simpleDialog() {
		//
		driver.findElement(By.id("menuform:j_idt39")).click();
		driver.findElement(By.id("menuform:m_overlay")).click();
		//
		driver.findElement(By.id("j_idt88:j_idt91")).click();
		Wait<WebDriver> wait = new WebDriverWait(driver,Duration.ofSeconds(2));
		Alert simpleAlert = wait.until(ExpectedConditions.alertIsPresent());
//		Alert simpleAlert = driver.switchTo().alert();
		System.out.println(simpleAlert.getText());
		simpleAlert.accept();
	}
	
	@Test
	public void confirmDialog() {
		//
		driver.findElement(By.id("menuform:j_idt39")).click();
		driver.findElement(By.id("menuform:m_overlay")).click();
		//
		driver.findElement(By.id("j_idt88:j_idt93")).click();
		Wait<WebDriver> wait = new WebDriverWait(driver,Duration.ofSeconds(2));
		Alert confirmAlert = wait.until(ExpectedConditions.alertIsPresent());
		confirmAlert.accept();
		System.out.println(driver.findElement(By.id("result")).getText());
	}
	
	//
	@Test
	public void promptDialog() {
		//
		driver.findElement(By.id("menuform:j_idt39")).click();
		driver.findElement(By.id("menuform:m_overlay")).click();
		//
		driver.findElement(By.id("j_idt88:j_idt104")).click();
		Wait<WebDriver> wait = new WebDriverWait(driver,Duration.ofSeconds(2));
		Alert promptAlert = wait.until(ExpectedConditions.alertIsPresent());
		promptAlert.sendKeys("hello guys");
		promptAlert.accept();
		System.out.println(driver.findElement(By.id("confirm_result")).getText());
	}
	
	//
	@Test
	public void simpleSweetDialog() {
		//
		driver.findElement(By.id("menuform:j_idt39")).click();
		driver.findElement(By.id("menuform:m_overlay")).click();
		//
		driver.findElement(By.id("j_idt88:j_idt95")).click();
		System.out.println(driver.findElement(By.id("j_idt88:j_idt101")).getText());
		driver.findElement(By.className("ui-icon-closethick")).click();
	}

	//
	@Test
	public void modalSweetDialog() {
		//
		driver.findElement(By.id("menuform:j_idt39")).click();
		driver.findElement(By.id("menuform:m_overlay")).click();
		//
		driver.findElement(By.id("j_idt88:j_idt100")).click();
		System.out.println(driver.findElement(By.id("j_idt88:j_idt101_title")).getText());
		driver.findElement(By.xpath("//*[@id=\"j_idt88:j_idt101\"]/div[1]/a")).click();
	}
	
	//
	@Test
	public void maximizeMinimize() {
		//
		driver.findElement(By.id("menuform:j_idt39")).click();
		driver.findElement(By.id("menuform:m_overlay")).click();
		//
//		driver.findElement(By.id("j_idt88:j_idt100")).click();
//		System.out.println(driver.findElement(By.id("j_idt88:j_idt101_title")).getText());
//		driver.findElement(By.xpath("//*[@id=\"j_idt88:j_idt101\"]/div[1]/a")).click();
	}
}
