package alt.playground;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Test01_Windows {
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
	public void confirmNewWindowOpens() {
		//
		driver.findElement(By.id("menuform:j_idt39")).click();
		driver.findElement(By.id("menuform:m_window")).click();
		//
		driver.findElement(By.id("j_idt88:new")).click();
		int windowHandleSize = driver.getWindowHandles().size();
		assertTrue(windowHandleSize>1);
	}

	//
	@Test
	public void findTheNumberOfOpenedTabs() {
		//
		driver.findElement(By.id("menuform:j_idt39")).click();
		driver.findElement(By.id("menuform:m_window")).click();
		//
		driver.findElement(By.id("j_idt88:j_idt91")).click();
		int windowHandleSize = driver.getWindowHandles().size();
		System.out.println(windowHandleSize);
		assertTrue(windowHandleSize>1);
	}
	
	@Test
	public void closeAllWindowsExceptPrimary() {
		//
		driver.findElement(By.id("menuform:j_idt39")).click();
		driver.findElement(By.id("menuform:m_window")).click();
		//
		String primaryWindowHandle = driver.getWindowHandle();
		driver.findElement(By.id("j_idt88:j_idt93")).click();
		
//		for(String handle:driver.getWindowHandles()) {
//			if(!primaryWindowHandle.contentEquals(handle)) {
//				driver.switchTo().window(handle);
//				driver.close();
//			}
//		}
//		driver.switchTo().defaultContent();
		assertTrue(driver.getWindowHandles().size()==1);
	}
	
	
	@Test
	public void waitFor2NewTabsToOpen() {
		//
		driver.findElement(By.id("menuform:j_idt39")).click();
		driver.findElement(By.id("menuform:m_window")).click();
		//
		driver.findElement(By.id("j_idt88:j_idt95")).click();
		Wait<WebDriver> wait = new WebDriverWait(driver,Duration.ofSeconds(2));
		wait.until(d-> driver.getWindowHandles().size()==3);
		driver.close();
	}
}
