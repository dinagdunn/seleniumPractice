//package hello_world;
//
//import java.util.List;
//import java.util.NoSuchElementException;
//
//import org.openqa.selenium.Alert;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.Select;
//
//public class Loop {
//
//
//	public static void main(String[] args) throws Exception {
//
//		System.setProperty("webdriver.chrome.driver",
//				"C:\\Users\\DunnPC\\Desktop\\chromedriver_win32\\chromedriver.exe");
//		WebDriver driver = new ChromeDriver();
//		driver.get("https://register.rediff.com/register/register.php?FormName=user_details");
//
//		Select dropDown1 = new Select(driver.findElement(By.xpath("//select[contains(@name,\"hintq\")]")));
//		List<WebElement> secQuestion = dropDown1.getOptions();
//
//		Thread.sleep(2000);
//
//		System.out.println(secQuestion.size());
//
//		for (int i = 1; i < secQuestion.size(); i++) {
//
//			driver.findElement(By.xpath("//div[@id='wrapper']/table[@id='tblcrtac']/tbody/tr[3]/td[3]/input"))
//					.sendKeys("Dina Dunn");
//			Thread.sleep(500);
//
//			driver.findElement(By.xpath("//input[contains(@name,'login')]")).sendKeys("dunn");
//			Thread.sleep(500);
//
//			driver.findElement(By.xpath("//input[@class=\"btn_checkavail\"]")).click();
//			Thread.sleep(500);
//
//			WebElement element = driver.findElement(By.xpath("//div[@id=\"check_availability\"]"));
//			Thread.sleep(1500);
//
//			if (element.isDisplayed()) {
//
//				// If statement use of checking if the cool element exists
//
//				Thread.sleep(1000);
//				if (driver.findElements(By.xpath("//input[contains(@value,'cool')]")).size() == 0) {
//					System.out.println("No cool name");
//					driver.findElement(
//							By.xpath("//div[@id='recommend_text']/table/tbody/tr[2]/td[1]/input[@id='radio_login']"))
//							.click();
//
//				} else {
//					WebElement cool = driver.findElement(By.xpath("//input[contains(@value,'cool')]"));
//					cool.click();
//
//				}
//			}
//			Thread.sleep(500);
//
//			driver.findElement(By.xpath("//input[starts-with(@name,'pass')]")).sendKeys("password");
//			Thread.sleep(500);
//			driver.findElement(By.xpath("//input[contains(@name,'confirm_pass')]")).sendKeys("password");
//			Thread.sleep(200);
//
//			driver.findElement(By.xpath("//input[@type='checkbox']")).click();
//			Thread.sleep(1000);
//
//			dropDown1.selectByIndex(i);
//
//			Thread.sleep(400);
//			driver.findElement(By.xpath("//input[contains(@name,\"hinta\")]")).sendKeys("Soccer");
//			;
//
//			driver.findElement(By.xpath("//input[contains(@name,\"mother\")]")).sendKeys("Mary");
//			;
//
//			// selecting single element in the input style dropdown box
//			driver.findElement(By.xpath("//img[contains(@src,'darrow')]")).click();
//			Thread.sleep(500);
//			driver.findElement(By.xpath("//li[contains(text(),'United Kingdom')]")).click();
//
//			// Selecting each item of the select dropdown for the DOB Day
//			Select dropDown2 = new Select(driver.findElement(By.xpath("//select[contains(@name,'DOB_Day')]")));
//			dropDown2.selectByValue("12");
//
//			// Selecting each item of the select dropdown for the DOB Month
//
//			Select dropDown3 = new Select(driver.findElement(By.xpath("//select[contains(@name,'DOB_Month')]")));
//			dropDown3.selectByVisibleText("APR");
//
//			// Selecting each item of the select dropdown for the DOB Year
//
//			Select dropDown4 = new Select(driver.findElement(By.xpath("//select[contains(@name,'DOB_Year')]")));
//			dropDown4.selectByValue("2000");
//
//			// driver.findElement(By.xpath("//input[@value='m']")).click();
//			// Thread.sleep(200);
//			
////			Select dropDown6 = new Select(driver.findElement(By.xpath("//select[contains(@name,'DOB_Month')]")));
//			
//			driver.findElement(By.xpath("//img[contains(@src,'darrow')]")).click();
//			driver.findElement(By.xpath("//li[contains(text(),'United Kingdom')]")).click();
//			driver.findElement(By.id("mobno")).sendKeys("555-555-5555");
//			driver.findElement(By.xpath("//input[@value='f']")).click();
//
//			Select dropDown5 = new Select(driver.findElement(By.id("country")));
//			dropDown5.selectByVisibleText("Jersey");
//			Thread.sleep(1000);
//
//			driver.findElement(By.xpath("//input[contains(@name,'Regis')]")).click();
//			System.out.println("Hit Register");
//			Thread.sleep(800);
//
//			Alert alert = driver.switchTo().alert();
//			alert.accept();
//			System.out.println("Accepted alert");
//
//			// fill_metric
//			//
//
//			// // By xpath =
//			// //
//			// By.xpath("//button[@name='submit'][@type='submit'][contains(text(),'Go')]");
//			// // WebElement myDynamicElement = (new WebDriverWait(driver, 10))
//			// // .until(ExpectedConditions.presenceOfElementLocated(xpath));
//			// //
//			// // myDynamicElement.click();
//			//
//			// // driver.findElement(By.name("btnK")).click();
//			Thread.sleep(1000);
//
//			driver.findElement(By.xpath("//div[@id='wrapper']/table[@id='tblcrtac']/tbody/tr[3]/td[3]/input")).clear();
//			driver.findElement(By.xpath("//input[contains(@name,'login')]")).clear();
//			List<WebElement> clearPassword = driver.findElements(By.xpath("//input[@type='password']"));
//
//			for (int y = 0; y < clearPassword.size(); y++) {
//				clearPassword.get(y).clear();
//				Thread.sleep(200);
//			}
//			driver.findElement(By.xpath("//input[@type='checkbox']")).click();
//			dropDown2.selectByValue("");
//			dropDown3.selectByValue("");
//			dropDown4.selectByValue("");
//			dropDown5.selectByIndex(0);
//			driver.findElement(By.id("mobno")).clear();
//			
//
//
//		}
//		driver.quit();
//	}
//}
