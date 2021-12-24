package org.base1;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.jsoup.helper.DataUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	public static WebDriver driver;
	private static String value;

	public void ChromeLaunch() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

	}

	// switch

	public static void browserLaunch(String browsername) {
		switch (browsername) {

		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;

		case "edge":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;

		}

	}

	public static void imWait(int sec) {
		driver.manage().timeouts().implicitlyWait(sec, TimeUnit.SECONDS);

	}

	// url
	public static void urlLaunch(String url) {
		driver.get(url);
		driver.manage().window().maximize();

	}

	// sendkeys

	public static void sendKeys(WebElement e, String data) {
		e.sendKeys(data);

	}

	// click
	public static void Click(WebElement e) {
		e.click();

	}

	// get current url

	public static String getCurrentUrl() {
		String Url = driver.getCurrentUrl();
		return Url;

	}

	// Action

	public static void dragAndDrop(WebElement from, WebElement to) {
		Actions a = new Actions(driver);
		a.dragAndDrop(from, to).perform();

	}

	public static void Actclick() {
		Actions a = new Actions(driver);
		a.click().perform();
	}
	// select

	public static void selectByIndex(WebElement drp, int index) {
		Select s = new Select(drp);
		s.selectByIndex(index);
	}

	// quit
	public static void Quit() {
		driver.quit();

	}

	public static void framesSwitch(int index) {
		driver.switchTo().frame(index);

	}

	// WindowsHandling
	public static void WindowsHandling(int index) {
		Set<String> allId = driver.getWindowHandles();
		List<String> li = new ArrayList<>();
		li.addAll(allId);
		driver.switchTo().window(li.get(1));
	}
	// ExcelRead

	public static String getExcel(String file, String sheetname, int rowno, int cellno) throws IOException {
		File f = new File("C:\\Users\\Ser\\eclipse-workspace\\MavenProject\\src\\test\\resources\\" + file + ".xlsx");
		FileInputStream fi = new FileInputStream(f);

		Workbook w = new XSSFWorkbook(fi);
		Sheet s = w.getSheet(sheetname);
		Row r = s.getRow(rowno);
		Cell c = r.getCell(cellno);
		
		int type =c.getCellType();
		
		String value =null;
		if(type==1) {
		 value = c.getStringCellValue();
		}else {
			
			if(DateUtil.isCellDateFormatted(c)) {
				
			Date dd = c.getDateCellValue();	
		SimpleDateFormat ss =	new SimpleDateFormat("dd-mm-yyyy")	;
		 value = ss.format(dd);
				
			}else {
				
			double db = c.getNumericCellValue();
			long ln =(long)db;
			 value = String.valueOf(ln);
			
			}
		
		}
		return value;
		
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
		
}		
	
		
		
		
		
		
		
	
