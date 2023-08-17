package testng01;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.xmlbeans.impl.xb.xsdschema.ListDocument.List;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.google.common.collect.Table.Cell;
import com.microsoft.schemas.office.visio.x2012.main.CellType;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Baseclass {
	
	public static WebDriver driver;

	//************To Launch Browser************
		public static void initDriver(String name) {
			switch (name) {
			case "Chrome":
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				break;
			case "Edge":
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
				break;
			default:
				System.out.println("None of the above browsers is not available in local Machine");
				break;
			}
		}
		
		//************To Launch Url************
		public static void getUrl(String url) {
			driver.get(url);
			driver.manage().window().maximize();
		}
		
			
		
		//************To Select from Dropdown List************

		public static void select(WebElement name, String type, String text) {
			Select s = new Select(name);
			switch (type) {
			case "index":
				s.selectByIndex(Integer.parseInt(text));
				break;
			case "value":
				s.selectByValue(text);
				break;
			case "visible text":
				s.selectByVisibleText(text);
				break;
			default:
				System.out.println("Please pass the correct selection criteria");
			}
		}

		
		
		//************To perform SendKeys Function************

		public static void sendKeys(WebElement name, String valuepass) {
			name.sendKeys(valuepass);
		}
		
		//************To click an WebElement************

		public static void click(WebElement name) {
			name.click();
		}
		
		//************To set values using set attribute************

		public static void javaScriptExecutor(WebElement name, String textvalue) {
			try {
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].setAttribute('value','" + textvalue + "')", name);
			} catch (Exception e) {
			}
		}
		
		//************To get Values using get attribute************

		public static Object javaScriptGet(WebElement name) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			Object executeScript = js.executeScript("return arguments[0].getAttribute('value')", name);
			return executeScript;
		}
		
		//************To click webelement using javascript executor************

		public static void javascriptClick(WebElement name) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click()", name);
		}
		
		//************To select options from dropdown using jsExecutor************

		public static void javascriptSelect(WebElement name, String text) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].value='" + text + "'", name);
		}
		
		//************To perform   mouseover actions************

		public static void actionsMouseHover(WebElement target) {
			Actions act = new Actions(driver);
			act.moveToElement(target).build().perform();
		}
		
		//************To perform drag and drop************

		public static void actionDragandDrop(WebElement source, WebElement target) {
			Actions act = new Actions(driver);
			act.dragAndDrop(source, target);
		}
		
		//************To perform right click************

		public static void contextClick(WebElement target) {
			Actions act = new Actions(driver);
			act.contextClick(target);
		}
		
		//************To perform double click************

		public static void doubleClick(WebElement target) {
			Actions act = new Actions(driver);
			act.doubleClick(target);
		}
		
		//************To get text from the WebElement************

		public static String getTextPerform(WebElement element) {
			String text = element.getText();
			return text;

		}

		//************To get value of attribute************
		
		public static String getAttributePerform(WebElement attribute,String name) {
			String attribute2 = attribute.getAttribute(name);
			return attribute2;
		}
		
		//************To get parent window id************

		public static String tofindParentId() {
			String paerntId = driver.getWindowHandle();
			return paerntId;
		}
		
		//************To get child window Id************
//		
//		public static String allWindowsId(int index, WebDriver driver) {
//			Set<String> windowHandles = driver.getWindowHandles();
//		   //List li=new ArrayList();
			//li.addAll(windowHandles);
			//String string = li.get(index);
			//return string;
//		}
		
		//************To perform simple alert************

		public static void simpleAlert(WebDriver driver) {
			Alert alert = driver.switchTo().alert();
			alert.accept();
		}
		
		//************To perform confirm alert************

		public static void confirmAlert(WebDriver driver, String name) {
			Alert alert = driver.switchTo().alert();
			switch (name) {
			case "accept":
				alert.accept();
				break;
			case "dismiss":
				alert.dismiss();
				break;
			default:
				System.out.println("Input not given");
			}

		}
		
		//************To perform promptalert************

		public static void PromptAlert(WebDriver driver, String message, String name) {
			Alert alert = driver.switchTo().alert();
			alert.sendKeys(message);
			switch (name) {
			case "accept":
				alert.accept();
				break;
			case "dismiss":
				alert.dismiss();
				break;
			default:
				System.out.println("Input not given");
			}
		}

		//************To perform deselect functions************
		
		public static void deSelect(WebElement name, String type, String text) {
			Select s = new Select(name);
			switch (type) {
			case "index":
				s.deselectByIndex(Integer.parseInt(text));
				break;
			case "value":
				s.deselectByValue(text);
				break;
			case "visible text":
				s.deselectByVisibleText(text);
			case "deselectAll":
				s.deselectAll();
				break;
			default:
				System.out.println("Please pass the correct selection criteria");

			}
		}
		
		//************To get all the options from the dropdown************
//
//		public static void getOptions(WebElement name) {
//			Select s = new Select(name);
//			List<WebElement> options = s.getOptions();
//			for (int i = 0; i < options.size(); i++) {
//				WebElement webElement = options.get(i);
//				String text = webElement.getText();
//				System.out.println();
//			}
//		}
		
		//************To get all the selected options from dropdown************
//
//		public static void getAllSelectedOptions(WebElement name) {
//			Select s = new Select(name);
//			//List<WebElement> allSelectedOptions = s.getAllSelectedOptions();
//			for (int i = 0; i < allSelectedOptions.size(); i++) {
//				WebElement webElement = allSelectedOptions.get(i);
//				String text = webElement.getText();
//				System.out.println(text);
//			}
//		}

		//************To get the first selected from dropdown************
		
		public static WebElement firstSelectedOption(WebElement name) {
			Select s = new Select(name);
			WebElement firstSelectedOption = s.getFirstSelectedOption();
			return firstSelectedOption;

		}
		
		//************To find whether we can select multiple selections from dropdown or not************

		public static boolean isMultiple(WebElement name) {
			Select s = new Select(name);
			boolean multiple = s.isMultiple();
			return multiple;
		}
		
		//************To switch the control from driver to frame************

		public static void switchFrames(WebDriver driver, WebElement name) {
			driver.switchTo().frame(name);
		}
		
		//************Implicit Waits************

		public void implicitWait(int num, String type) {
			switch (type) {
			case "minutes":
				driver.manage().timeouts().implicitlyWait(num, TimeUnit.MINUTES);
			case "seconds":
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(num));
			case "milliseconds":
				driver.manage().timeouts().implicitlyWait(num, TimeUnit.MILLISECONDS);
			}

		}
		
		//************To close the current window of the Website************

		public static void closeDriver() {
			driver.close();
		}
		
		//************To close the entire session************

		public static void quitDriver() {
			driver.quit();
		}

	}


