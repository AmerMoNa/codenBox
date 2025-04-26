package codenboxautomationlab;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap.KeySetView;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class testCodenBox {

	WebDriver driver = new ChromeDriver();
	String theWebside = "https://codenboxautomationlab.com/practice/";

	Random rand = new Random();

	@BeforeTest
	public void mySetup() {

		driver.get(theWebside);
		driver.manage().window().maximize();
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	}

	@Test(priority = 1, enabled = false)
	public void radioButton() {

		WebElement radioButton = driver.findElement(By.id("radio-btn-example"));
		List<WebElement> allradioButton = radioButton.findElements(By.tagName("input"));
		int randomRadioButton = rand.nextInt(allradioButton.size());

		allradioButton.get(randomRadioButton).click();

//		List<WebElement> randomRadioButtons = driver.findElements(By.className("radioButton"));
//		int anyRandomRadio = rand.nextInt(randomRadioButtons.size());
//		randomRadioButtons.get(anyRandomRadio);

//		List<WebElement> selectOne = driver.findElements(By.className("radioButton"));
//		selectOne.get(2).click();
	}

	@Test(priority = 2, enabled = false)
	public void autoCompletTest() throws InterruptedException {
		WebElement autoCompletField = driver.findElement(By.id("autocomplete"));
		String[] countries = { "jo", "sa", "la", "pl", "us" };
		int randomIndex = rand.nextInt(countries.length);
		autoCompletField.sendKeys(countries[randomIndex]);
		Thread.sleep(1000);
		autoCompletField.sendKeys(Keys.chord(Keys.ARROW_DOWN, Keys.ENTER));

	}

	@Test(priority = 3, enabled = false)
	public void staticSelect() throws InterruptedException {
		WebElement theSelect = driver.findElement(By.id("dropdown-class-example"));
		Select mySelect = new Select(theSelect);

		mySelect.selectByVisibleText("API");

//		mySelect.selectByIndex(1);
//		mySelect.selectByValue("option2");

//		System.out.println(theSelect.findElements(By.tagName("option")).size());

//		"another ways without using Select"
//		theSelect.click();
//		Thread.sleep(1000);
//		theSelect.sendKeys(Keys.chord(Keys.ARROW_DOWN ,Keys.ARROW_DOWN, Keys.ENTER));

	}

	@Test(priority = 4, enabled = false)
	public void checkBoxTest() {
		WebElement checkBox = driver.findElement(By.id("checkbox-example"));
		List<WebElement> allCheckBoses = checkBox.findElements(By.tagName("input"));

		int randomCheckBoxes = rand.nextInt(allCheckBoses.size());
		allCheckBoses.get(randomCheckBoxes).click();

	}

	@Test(priority = 5, enabled = false)
	public void switchWindow() throws InterruptedException {

		WebElement openWindow = driver.findElement(By.id("openwindow"));
		openWindow.click();

		Set<String> handles = driver.getWindowHandles();
		List<String> windowHandle = new ArrayList<>(handles);
		driver.switchTo().window(windowHandle.get(1));

		driver.findElement(By.xpath("//*[@id=\"menu-item-9675\"]/a/span[1]"));
		System.out.println(driver.getTitle());

		driver.switchTo().window(windowHandle.get(0));

	}

	@Test(priority = 6, enabled = false)
	public void switchTab() throws InterruptedException {
		WebElement openNewTab = driver.findElement(By.id("opentab"));
		openNewTab.click();

		Set<String> newTab = driver.getWindowHandles();
		List<String> tabList = new ArrayList<>(newTab);
		driver.switchTo().window(tabList.get(1));

		driver.findElement(By.xpath("//div[@class='yt-tab-shape-wiz__tab']")).click();
		System.out.println(driver.getTitle());
		Thread.sleep(1000);

		driver.switchTo().window(tabList.get(0));
		System.out.println(driver.getTitle());

	}

	@Test(priority = 7, enabled = false)
	public void alertTabTest() {
		WebElement alertFieldForName = driver.findElement(By.id("name"));
		alertFieldForName.sendKeys("amer");

		WebElement alertButton = driver.findElement(By.id("alertbtn"));
		alertButton.click();

		driver.switchTo().alert().accept();

	}

	@Test(priority = 8, enabled = false)
	public void confirmButtonTest() {
		WebElement confirmFeildForName = driver.findElement(By.id("name"));
		confirmFeildForName.sendKeys("student");
		WebElement confirmButton = driver.findElement(By.id("confirmbtn"));
		confirmButton.click();

//		driver.switchTo().alert().accept();
		driver.switchTo().alert().dismiss();

	}

	@Test(priority = 9)
	public void testTheTable() {
		WebElement tableTest = driver.findElement(By.id("product"));
//		List<WebElement> allRows = driver.findElements(By.tagName("tr"));
		List<WebElement> headrow = tableTest.findElements(By.tagName("th"));
		List<WebElement> datarows = tableTest.findElements(By.tagName("td"));

		
		System.out.println(headrow.get(2).getText());
		

		for (int j = 2; j < datarows.size(); j = j + 3) {

			System.out.println(datarows.get(j).getText());

		}

//		print random row
//		int randomRows = rand.nextInt(allRows.size());
//		
//		System.out.println(allRows.get(randomRows).getText());

//		print all rows , print th or print td 
//		for(int i=0 ; i<allRows.size();i++) {
//			
//			
//			System.out.println(allRows.get(i).getText());
//			
//			
//		}
//			

	}

}
