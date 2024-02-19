package alt.playground;


import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Test04_TextBox {
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
	public void typeIn() {
		//
		driver.findElement(By.id("menuform:j_idt40")).click();
		driver.findElement(By.id("menuform:m_input")).click();
		//
		driver.findElement(By.id("j_idt88:name")).sendKeys("Sathish Johnson");
	}
	
	//
	@Test
	public void appendTo() {
		//
		driver.findElement(By.id("menuform:j_idt40")).click();
		driver.findElement(By.id("menuform:m_input")).click();
		//
		driver.findElement(By.id("j_idt88:j_idt91")).sendKeys("Sathish Johnson");
	}
	
	//
	@Test
	public void disabledTextBox() {
		//
		driver.findElement(By.id("menuform:j_idt40")).click();
		driver.findElement(By.id("menuform:m_input")).click();
		//
		Boolean status = driver.findElement(By.id("j_idt88:j_idt93")).isEnabled();
		assertTrue(!status);
	}
	
	//
	@Test
	public void clearTypedText() {
		//
		driver.findElement(By.id("menuform:j_idt40")).click();
		driver.findElement(By.id("menuform:m_input")).click();
		//
		WebElement textBox = driver.findElement(By.id("j_idt88:j_idt95"));
		textBox.clear();
		assertTrue(textBox.getText().contentEquals(""));
	}
	
	//
	@Test
	public void getTypedText() {
		//
		driver.findElement(By.id("menuform:j_idt40")).click();
		driver.findElement(By.id("menuform:m_input")).click();
		//
		String text = driver.findElement(By.id("j_idt88:j_idt97")).getAttribute("value");
		System.out.println(text);
	}
	
	//
	@Test
	public void typeEmailAndPressTab() throws InterruptedException {
		//
		driver.findElement(By.id("menuform:j_idt40")).click();
		driver.findElement(By.id("menuform:m_input")).click();
		//
		WebElement emailBox = driver.findElement(By.id("j_idt88:j_idt99"));
		emailBox.sendKeys("sathish@email.com" + Keys.TAB);
		Thread.sleep(Duration.ofSeconds(3));
		assertTrue(driver.findElement(By.tagName("textarea")).isSelected());
	}
	
	//
	@Test
	public void pressEnterAndVerifyErrorMessage() throws InterruptedException {
		//
		driver.findElement(By.id("menuform:j_idt40")).click();
		driver.findElement(By.id("menuform:m_input")).click();
		//
		
		WebElement label = driver.findElement(By.id("j_idt106:j_idt113"));
		Rectangle labelPosition1 = label.getRect();
		driver.findElement(By.id("j_idt106:float-input")).click();
		Rectangle labelPosition2 = label.getRect();
		Thread.sleep(Duration.ofSeconds(3));
		assertTrue(!labelPosition1.equals(labelPosition2));
	}
	
	//
	@Test
	public void typeAndChooseThirdOption() throws InterruptedException {
		//
		driver.findElement(By.id("menuform:j_idt40")).click();
		driver.findElement(By.id("menuform:m_input")).click();
		//
		
		WebElement textList = driver.findElement(By.id("j_idt106:j_idt113"));
		textList.sendKeys("sa");
		
	}
	
	//
	@Test
	public void typeDateAndConfirmSelectedDate() throws InterruptedException {
		//
		driver.findElement(By.id("menuform:j_idt40")).click();
		driver.findElement(By.id("menuform:m_input")).click();
		//
		
		driver.findElement(By.id("j_idt106:j_idt116_input")).sendKeys("2/2/83");

	}
	
	//
	@Test
	public void typeNumberAndSpinAndConfirmValue() throws InterruptedException {
		//
		driver.findElement(By.id("menuform:j_idt40")).click();
		driver.findElement(By.id("menuform:m_input")).click();
		//
		
		WebElement spinner = driver.findElement(By.id("j_idt106:j_idt118_input"));
		spinner.sendKeys("3");
		driver.findElement(By.className("ui-icon-triangle-1-n")).click();
		assertTrue(spinner.getAttribute("aria-valuenow").contentEquals("4"));
	}
	
	//
	@Test
	public void typeNumberAndSpinAndConfirmSliderMoves() throws InterruptedException {
		//
		driver.findElement(By.id("menuform:j_idt40")).click();
		driver.findElement(By.id("menuform:m_input")).click();
		//

	}
	
	//
	@Test
	public void clickAndConfirmKeyboardAppears() throws InterruptedException {
		//
		driver.findElement(By.id("menuform:j_idt40")).click();
		driver.findElement(By.id("menuform:m_input")).click();
		//
		WebElement keyboard = driver.findElement(By.className("keypad-popup"));
		System.out.println(keyboard.getAttribute("display"));
		driver.findElement(By.id("j_idt106:j_idt122")).click();
		System.out.println(keyboard.getAttribute("display"));
		Thread.sleep(Duration.ofSeconds(2));
		assertTrue(keyboard.getAttribute("display").contentEquals("block"));
	}
	
	//
	@Test
	public void textEditor() throws InterruptedException {
		//
		driver.findElement(By.id("menuform:j_idt40")).click();
		driver.findElement(By.id("menuform:m_input")).click();
		//

	}
	
	//
	@Test
	public void customToolBar() throws InterruptedException {
		//
		driver.findElement(By.id("menuform:j_idt40")).click();
		driver.findElement(By.id("menuform:m_input")).click();
		//

	}
}
