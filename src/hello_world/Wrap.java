package hello_world;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
//import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Wrap {

	public static WebDriver driver;
	public static Alert alert;
	public static Select dropDownSecurity;
	public static List<WebElement> secQuestion;
	public static Select dropDownDOBDay;
	public static Select dropDownDOBMonth;
	public static Select dropDownDOBYear;
	public static Select dropDownCountry;
	public static Row newRow;
	public static Row row;

	public static void setChromeDriverProperty() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\DunnPC\\Desktop\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
	}

	public static void setTestUrl(String url) {
		driver.get(url);
	}

	public static void inputFullName(String nameValue) {
		driver.findElement(By.xpath("//input[starts-with(@name,'name')]")).sendKeys(nameValue);
	}

	public static void inputUserId(String uId) throws InterruptedException {
		driver.findElement(By.xpath("//input[contains(@name,'login')]")).sendKeys(uId);
		driver.findElement(By.xpath("//input[@class=\"btn_checkavail\"]")).click();
		Thread.sleep(500);
		WebElement element = driver.findElement(By.xpath("//div[@id=\"check_availability\"]"));

		if (element.isDisplayed()) {
			Thread.sleep(500);
			if (driver.findElements(By.xpath("//input[contains(@value,'cool')]")).size() == 0) {
				System.out.println("No cool name");
				Thread.sleep(1000);
				driver.findElement(
						By.xpath("//div[@id='recommend_text']/table/tbody/tr[2]/td[1]/input[@id='radio_login']"))
						.click();
			} else {
				WebElement cool = driver.findElement(By.xpath("//input[contains(@value,'cool')]"));
				cool.click();
			}
		}
	}

	public static void inputPassword(String password, String confirmPassword) {
		driver.findElement(By.xpath("//input[starts-with(@name,'pass')]")).sendKeys(password);
		driver.findElement(By.xpath("//input[contains(@name,'confirm_pass')]")).sendKeys(confirmPassword);
	}

	public static void setAltEmail(String email) {
		driver.findElement(By.xpath("//input[starts-with(@name,\"altemail\")]")).sendKeys(email);
	}

	public static void checkBoxAltId() {
		driver.findElement(By.xpath("//input[@type='checkbox']")).click();
	}

	public static void createLoopParams() {
		dropDownSecurity = new Select(driver.findElement(By.xpath("//select[contains(@name,\"hintq\")]")));

	}

	public static void setSecQuestions(int i) {
		dropDownSecurity = new Select(driver.findElement(By.xpath("//select[contains(@name,\"hintq\")]")));
		dropDownSecurity.selectByIndex(i);

	}

	public static int secQuestionsListSize() {
		List<WebElement> secQuestion = dropDownSecurity.getOptions();
		return secQuestion.size();
	}

	// this answer should change based on the selected security question

	public static void setSecAnswer(String answer) {
		driver.findElement(By.xpath("//input[contains(@name,\"hinta\")]")).sendKeys(answer);
	}

	public static void maidenName(String mName) {
		driver.findElement(By.xpath("//input[contains(@name,\"mother\")]")).sendKeys(mName);
	}

	public static void setAreaCode(String areaCode) throws InterruptedException {
		driver.findElement(By.xpath("//img[contains(@src,'darrow')]")).click();
		Thread.sleep(800);
		driver.findElement(By.xpath("//li[contains(text(), '" + areaCode + "')]")).click();
	}

	public static void setPhoneNumber(String phoneNumber) {
		driver.findElement(By.id("mobno")).sendKeys(phoneNumber);
	}

	public static void setDOBDay(String dobDay) {
		dropDownDOBDay = new Select(driver.findElement(By.xpath("//select[contains(@name,'DOB_Day')]")));
		dropDownDOBDay.selectByValue(dobDay);
	}

	public static void setDOBMonth(String dobMonth) {
		dropDownDOBMonth = new Select(driver.findElement(By.xpath("//select[contains(@name,'DOB_Month')]")));
		dropDownDOBMonth.selectByVisibleText(dobMonth);
	}

	public static void setDOBYear(String dobYear) {
		dropDownDOBYear = new Select(driver.findElement(By.xpath("//select[contains(@name,'DOB_Year')]")));
		dropDownDOBYear.selectByValue(dobYear);
	}

	public static void setGender(String gender) {
		driver.findElement(By.xpath("//input[@value='" + gender + "']")).click();
	}

	public static void setCountry(String country) {
		dropDownCountry = new Select(driver.findElement(By.id("country")));
		dropDownCountry.selectByVisibleText(country);

	}

	public static void submitForm() {
		driver.findElement(By.xpath("//input[contains(@name,'Regis')]")).click();
	}

	public static void clearInputs() throws InterruptedException {
		driver.findElement(By.xpath("//input[starts-with(@name,'name')]")).clear();
		driver.findElement(By.xpath("//input[contains(@name,'login')]")).clear();
		List<WebElement> clearPassword = driver.findElements(By.xpath("//input[@type='password']"));

		for (int y = 0; y < clearPassword.size(); y++) {
			clearPassword.get(y).clear();
			Thread.sleep(200);
		}
		driver.findElement(By.xpath("//input[@type='checkbox']")).click();

		try {
			dropDownDOBDay.selectByValue("");
			dropDownDOBMonth.selectByValue("");
			dropDownDOBYear.selectByValue("");
			dropDownCountry.selectByIndex(1);
		} catch (Exception e) {
			System.out.println("No Dropdown Data to clear");

		}

		driver.findElement(By.id("mobno")).clear();

	}

	public static void acceptAlert() {
		alert = driver.switchTo().alert();
		alert.accept();
		System.out.println("Accepted alert");
	}

	public static void readExcel(String filePath, String fileName, String readSheetName) throws IOException {

		File file = new File(filePath + "\\" + fileName);

		FileInputStream fileInputStream = new FileInputStream(file);
		Workbook readWorkbook = null;

		String extensionName = fileName.substring(fileName.indexOf("."));

		if (extensionName.equals(".xlsx")) {
			readWorkbook = new XSSFWorkbook(fileInputStream);

		}

		else if (extensionName.equals(".xls")) {
			readWorkbook = new HSSFWorkbook(fileInputStream);
		}

		Sheet readSheet = readWorkbook.getSheet(readSheetName);

		// Find number of rows in excel file
		int rowCount = readSheet.getLastRowNum() - readSheet.getFirstRowNum();
		//
		// Create a loop over all the rows of excel file to read it
		for (int i = 0; i < rowCount + 1; i++) {

			Row row = readSheet.getRow(i);

			// Create a loop to print cell values in a row

			for (int j = 0; j < row.getLastCellNum(); j++) {

				// Print Excel data in console

				System.out.print(row.getCell(j).getStringCellValue() + "|| ");

			}

			System.out.println();
		}
	}

	public static void writeExcel(String filePath, String fileName, String writeSheetName, String[] dataToWrite)
			throws IOException {

		File file = new File(filePath + "\\" + fileName);

		FileInputStream fileInputStream = new FileInputStream(file);
		Workbook writeWorkbook = null;

		String extensionName = fileName.substring(fileName.indexOf("."));

		if (extensionName.equals(".xlsx")) {
			writeWorkbook = new XSSFWorkbook(fileInputStream);

		}

		else if (extensionName.equals(".xls")) {
			writeWorkbook = new HSSFWorkbook(fileInputStream);
		}

		Sheet writeSheet = writeWorkbook.getSheet(writeSheetName);

		// Get the current count of rows in excel file

		int rowCount = writeSheet.getLastRowNum() - writeSheet.getFirstRowNum();
		// //Get the first row from the sheet

		// need to logic to check if this exists.. because if it does not exist, then
		// the code breaks.

		// will it be easier to create getColumn and getRow counter so I can specify to
		// always put on the 1st column while incrementing the rows?

		Row row = writeSheet.getRow(0);
		// }

		//
		// //Create a new row and append it at last of sheet
		//
		Row newRow = writeSheet.createRow(rowCount + 1);
		//

		for (int j = 0; j < row.getLastCellNum(); j++) {
			//
			// //Fill data in row
			//
			Cell cell = newRow.createCell(j);

			cell.setCellValue(dataToWrite[j]);
			//

			// //Close input stream

			fileInputStream.close();

			// //Create an object of FileOutputStream class to create write data in excel
			// file

			FileOutputStream fileOutputStream = new FileOutputStream(file);
			//
			// //write data in the excel file
			//
			writeWorkbook.write(fileOutputStream);
			//
			// //close output stream
			//
			fileOutputStream.close();
		}
	}

	public static void writeLabelsToExcel(String filePath, String fileName, String writeSheetName, String[] dataToWrite)
			throws IOException {

		File file = new File(filePath + "\\" + fileName);

		FileInputStream fileInputStream = new FileInputStream(file);
		Workbook writeWorkbook = null;

		String extensionName = fileName.substring(fileName.indexOf("."));

		if (extensionName.equals(".xlsx")) {
			writeWorkbook = new XSSFWorkbook(fileInputStream);

		}

		else if (extensionName.equals(".xls")) {
			writeWorkbook = new HSSFWorkbook(fileInputStream);
		}

		Sheet writeSheet = writeWorkbook.getSheet(writeSheetName);

		// Get the current count of rows in excel file

		int rowCount = writeSheet.getLastRowNum() - writeSheet.getFirstRowNum();

		if (rowCount == 0) {
			// //Get the first row from the sheet
			// Row row = writeSheet.getRow(0);

			// //Create a new row and append it at last of sheet
			newRow = writeSheet.createRow(0);

		}

		else {
			newRow = writeSheet.createRow(rowCount);
		}

		for (int j = 0; j < dataToWrite.length; j++) {

			Cell cell = newRow.createCell(0);
			// String label = driver.findElement(By.id(dataToWrite[j])).getText();
			String label = driver.findElement(By.xpath(dataToWrite[j])).getAttribute("innerHTML");

			System.out.println(label);

			cell.setCellValue(label);

			newRow = writeSheet.createRow(++rowCount);
			//
			//
			// if(driver.findElement(By.xpath(dataToWrite[j]) != null)) {
			//
			// }
			// if xpath ==> drive.findBy.. getText..

			// else

			fileInputStream.close();

			FileOutputStream fileOutputStream = new FileOutputStream(file);
			writeWorkbook.write(fileOutputStream);
			fileOutputStream.close();
		}
	}

	public static void sendKeysFromExcel(String filePath, String fileName, String sendSheetKeys,
			String[] xPathStringArr) throws IOException, InterruptedException {
		// String[] dataToWrite -- want to loop throuhg these as to send do
		// driver.findby(xpath).sendKeys(sheetRow[j])..?

		File file = new File(filePath + "\\" + fileName);

		FileInputStream fileInputStream = new FileInputStream(file);
		Workbook sendKeyWorkbook = null;

		String extensionName = fileName.substring(fileName.indexOf("."));

		if (extensionName.equals(".xlsx")) {
			sendKeyWorkbook = new XSSFWorkbook(fileInputStream);

		}

		else if (extensionName.equals(".xls")) {
			sendKeyWorkbook = new HSSFWorkbook(fileInputStream);
		}

		Sheet sendKeySheet = sendKeyWorkbook.getSheet(sendSheetKeys);

		// Find number of rows in excel file
		int rowCount = sendKeySheet.getLastRowNum() - sendKeySheet.getFirstRowNum();

		// Create a loop over all the rows of excel file to read it

		for (int i = 0; i <= rowCount; i++) {
			WebElement element = driver.findElement(By.xpath(xPathStringArr[i]));

			if (xPathStringArr[i].equals("//input[@type='checkbox']")) {
				driver.findElement(By.xpath(xPathStringArr[i])).click();
				// System.out.println("Skipped " + xPathStringArr[i]);
				continue;

			}

			row = sendKeySheet.getRow(i);
			// System.out.println("Actions performed for interation " + i + element);
			// System.out.println(row.getCell(0).getStringCellValue());

			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.elementToBeClickable(element));

			Thread.sleep(400);
			Actions actions = new Actions(driver);
			actions.moveToElement(element).sendKeys(element, (row.getCell(0).getStringCellValue()));

			Action actionSeries = actions.build();
			actionSeries.perform();

		}

	}

	// driver.findElement(By.xpath("//input[@id='UserName']")).sendKeys(Sheet.getCell(0,
	// i).getContents());

	public static void exitTest() {
		driver.quit();
	}
}
