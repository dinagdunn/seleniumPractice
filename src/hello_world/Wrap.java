package hello_world;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Wrap {

	public static WebDriver driver;
	public static Alert alert;
	public static Select dropDownSecurity;
	public static List<WebElement> secQuestion;
	public static Select dropDownDOBDay;
	public static Select dropDownDOBMonth;
	public static Select dropDownDOBYear;
	public static Select dropDownCountry;

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
		Thread.sleep(500);
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
		dropDownDOBDay.selectByValue("");
		dropDownDOBMonth.selectByValue("");
		dropDownDOBYear.selectByValue("");
		dropDownCountry.selectByIndex(1);
		driver.findElement(By.id("mobno")).clear();
	}

	public static void acceptAlert() {
		alert = driver.switchTo().alert();
		alert.accept();
		System.out.println("Accepted alert");
	}

	public static void exitTest() {
		driver.quit();
	}
}
