package hello_world;

public class Main {

	public static void main(String[] args) throws Exception {

		Wrap.setChromeDriverProperty();

		String nameValue = "Dina Dunn";
		String url = "https://register.rediff.com/register/register.php?FormName=user_details";
		String uId = "dunn";
		String password = "password";
		String confirmPassword = "password";
		String email = "email@email.com";
		
		//security answers
		String answer = "Soccer";
		String answer2 = "";
		String answer3="";
		String answer4="";
		
		
		
		String mName = "Mary";
		String areaCode = "United Kingdom";
		String phoneNumber = "555-555-5555";

		String dobDay = "12";
		String dobMonth = "APR";
		String dobYear = "2000";
		String gender = "f";
		String country = "Jersey";

		Wrap.setTestUrl(url);
		System.out.println("Loading");
		Thread.sleep(2000);

		// setting up security answer to loop through
//		Wrap.createLoopParams();

		
		//need to write if statement to change the security answer based on the selected security answer 
		for (int i = 1; i < Wrap.secQuestionsListSize(); i++) {
			Wrap.inputFullName(nameValue);
			Wrap.inputUserId(uId);
			Wrap.inputPassword(password, confirmPassword);
			Wrap.setAltEmail(email);
			Wrap.checkBoxAltId();
			Thread.sleep(800);

			Wrap.setSecQuestions(i);

			Wrap.setSecAnswer(answer);
			Wrap.maidenName(mName);
			Wrap.setAreaCode(areaCode);
			Wrap.setPhoneNumber(phoneNumber);
			Wrap.setDOBDay(dobDay);
			Wrap.setDOBMonth(dobMonth);
			Wrap.setDOBYear(dobYear);

			Thread.sleep(1500);

			Wrap.setGender(gender);
			Wrap.setCountry(country);

			Thread.sleep(2000);

			Wrap.submitForm();
			Thread.sleep(1000);
			Wrap.acceptAlert();
			Thread.sleep(1000);
			Wrap.clearInputs();
			Thread.sleep(3000);

		}
		Wrap.exitTest();
		System.out.println("Test finished");
	}
}




//
// // word wrap is alt+shift+y

// //another idea can have Math.random select an input within the size range.
//
// System.setProperty("webdriver.chrome.driver",
// "C:\\Users\\DunnPC\\Desktop\\chromedriver_win32\\chromedriver.exe");
// WebDriver driver = new ChromeDriver();
// driver.get("https://register.rediff.com/register/register.php?FormName=user_details");
// Thread.sleep(2000);
//
// driver.findElement(By.xpath("//div[@id='wrapper']/table[@id='tblcrtac']/tbody/tr[3]/td[3]/input"))
// .sendKeys("Dina Dunn");
// Thread.sleep(500);
//
// driver.findElement(By.xpath("//input[contains(@name,'login')]")).sendKeys("dunn");
// Thread.sleep(500);
//
// driver.findElement(By.xpath("//input[@class=\"btn_checkavail\"]")).click();
// Thread.sleep(500);
//
// WebElement element =
// driver.findElement(By.xpath("//div[@id=\"check_availability\"]"));
// Thread.sleep(1000);
// if (element.isDisplayed()) {
//
// try {
// List<WebElement> cool =
// driver.findElements(By.xpath("//input[contains(@value,'cool')]"));
// if (cool.size() == 0) {
// List<WebElement> altUser = driver.findElements(By.id("radio_login"));
//
// for (int i = 0; i < altUser.size(); i++) {
// Thread.sleep(200);
// altUser.get(i).click();
// }
//
// // driver.findElement(
// //
// By.xpath("//div[@id='recommend_text']/table/tbody/tr[2]/td[1]/input[@id='radio_login']"))
// // .click();
// }
//
// else if (cool.size() != 0) {
// ((WebElement) cool).click();
// }
// }
//
// catch (NoSuchElementException e) {
// System.out.println("Catch");
// }
// }
//
// // If statement use of checking if the cool element exists
//
// // Thread.sleep(1000);
// // if
// (driver.findElements(By.xpath("//input[contains(@value,'cool')]")).size()
// // == 0) {
// // System.out.println("No cool name");
// // driver.findElement(
// //
// By.xpath("//div[@id='recommend_text']/table/tbody/tr[2]/td[1]/input[@id='radio_login']"))
// // .click();
// //
// // } else {
// // WebElement cool =
// // driver.findElement(By.xpath("//input[contains(@value,'cool')]"));
// // cool.click();
// //
// // }
//
// Thread.sleep(500);
//
// driver.findElement(By.xpath("//input[starts-with(@name,'pass')]")).sendKeys("password");
// Thread.sleep(500);
// driver.findElement(By.xpath("//input[contains(@name,'confirm_pass')]")).sendKeys("hello");
//
// driver.findElement(By.xpath("//input[starts-with(@name,\"altemail\")]")).sendKeys("email@email.com");
// Thread.sleep(500);
//
// driver.findElement(By.xpath("//input[contains(@name,'chk_alt')]")).click();
// Thread.sleep(1000);
// Select dropDown1 = new
// Select(driver.findElement(By.xpath("//select[contains(@name,\"hintq\")]")));
// List<WebElement> secQuestion = dropDown1.getOptions();
//
// for (int i = 0; i < secQuestion.size(); i++) {
// dropDown1.selectByIndex(i);
// Thread.sleep(800);
// }
//
// // Select one element of dropdown items
// // Select dropDown1 = new
// //
// Select(driver.findElement(By.xpath("//select[contains(@name,\"hintq\")]")));
// // dropDown1.selectByIndex(2);
// // Thread.sleep(1000);
// // dropDown1.selectByVisibleText("What is your favourite pass-time?");
// driver.findElement(By.xpath("//input[contains(@name,\"hinta\")]")).sendKeys("Soccer");
// ;
//
// driver.findElement(By.xpath("//input[contains(@name,\"mother\")]")).sendKeys("Mary");
// ;
//
// List<WebElement> areaCode =
// driver.findElements(By.xpath("//div[@id=\"country_id\"]/ul/li"));
// System.out.println(areaCode.size());
// for (int i = 0; i < areaCode.size(); i++) {
//// for (int i = 0; i < 5; i++) {
// driver.findElement(By.id("mobno")).clear();
// driver.findElement(By.xpath("//img[contains(@src,'darrow')]")).click();
// Thread.sleep(1400);
// areaCode.get(i).click();
// driver.findElement(By.id("mobno")).sendKeys("555-555-5555");
//
// // System.out.println(areaCode.get(i).getText());
// // Thread.sleep(500);
// ;
// }
//
// // selecting single element in the input style dropdown box
// // Thread.sleep(1000);
// // driver.findElement(By.xpath("//li[contains(text(),'United
// // Kingdom')]")).click();
//
//
// //Selecting each item of the select dropdown for the DOB Day
// Select dropDown2 = new
// Select(driver.findElement(By.xpath("//select[contains(@name,'DOB_Day')]")));
// List<WebElement> dobDay = dropDown2.getOptions();
// for (int i = 0; i < dobDay.size(); i++) {
// dropDown2.selectByIndex(i);
// }
//
// dropDown2.selectByValue("12");
//
//
//
// //Selecting each item of the select dropdown for the DOB Month
//
// Select dropDown3 = new
// Select(driver.findElement(By.xpath("//select[contains(@name,'DOB_Month')]")));
// List<WebElement> dobMonth = dropDown3.getOptions();
// for (int i = 0; i < dobMonth.size(); i++) {
// dropDown3.selectByIndex(i);
// }
// dropDown3.selectByVisibleText("APR");
//
//
// //Selecting each item of the select dropdown for the DOB Year
//
// Select dropDownDOBYear = new
// Select(driver.findElement(By.xpath("//select[contains(@name,'DOB_Year')]")));
// List<WebElement> dobYear = dropDownDOBYear.getOptions();
// for (int i = 0; i < dobYear.size(); i++) {
// dropDownDOBYear.selectByIndex(i);
// }
// dropDownDOBYear.selectByValue("2000");
//
// driver.findElement(By.xpath("//input[@value='m']")).click();
// Thread.sleep(200);
// driver.findElement(By.xpath("//input[@value='f']")).click();
//
// Select dropDown5 = new Select(driver.findElement(By.id("country")));
// List<WebElement> countryList = dropDown5.getOptions();
//
// //For india, the city pops up. if the getText() === "India", loop throuhg the
// city list.
// for (int i = 0; i < countryList.size(); i++) {
//
// //if()
//
// dropDown5.selectByIndex(i);
// }
//
//
// dropDown5.selectByVisibleText("Jersey");
// Thread.sleep(1000);
//
// // Select dropDown6 = new
// // Select(driver.findElement(By.xpath("//select[contains(@name,'city')]")));
// // dropDown6.select
// //
// driver.findElement(By.xpath("//input[contains(@name,'Regis')]")).click();
// System.out.println("Hit Register");
// Thread.sleep(3000);
//
// // if alert box exists for mismatched password
// Alert alert = driver.switchTo().alert();
// alert.accept();
// System.out.println("Accepted alert");
// Thread.sleep(1000);
//
// driver.findElement(By.xpath("//input[contains(@name,\"confirm_pass\")]")).clear();
// driver.findElement(By.xpath("//input[contains(@name,\"confirm_pass\")]")).sendKeys("password");
// driver.findElement(By.xpath("//input[contains(@name,'Regis')]")).click();
// Thread.sleep(800);
// alert.accept();
//
// // fill_metric
// //
//
// // // By xpath =
// // //
// //
// By.xpath("//button[@name='submit'][@type='submit'][contains(text(),'Go')]");
// // // WebElement myDynamicElement = (new WebDriverWait(driver, 10))
// // // .until(ExpectedConditions.presenceOfElementLocated(xpath));
// // //
// // // myDynamicElement.click();
// //
// // // driver.findElement(By.name("btnK")).click();
// Thread.sleep(5000);
//
// driver.quit();
//
//
//
// //wrap everything in a for loop that is limited by the size of the security
// question dropdown box.. keep everything the same but loop throuhg the
// security question
//
// }
//
