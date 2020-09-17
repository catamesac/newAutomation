package certification.pages;


import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterFormPOM {
	
	 static WebDriver driver;
	 private static By NAME = By.name("firstname");
	 private static By LASTNAME  = By.name("lastname");
	 private static By EMAIL = By.name("reg_email__");
	 private static By PASSWORD = By.name("reg_passwd__");
	 private static By BIRTHDAYDATEBUTTON = By.name("birthday_day");
	 private static By BIRTHDAYDATE = By.xpath("//parent::span[@class=\"_5k_4\"]//select[@id=\"day\"]//following::option[contains(text(),'12')]");
	 private static By BIRTHDAYMONTHBUTTON = By.name("birthday_month");
	 private static By BIRTHDAYMONTH = By.xpath("//parent::span[@class=\"_5k_4\"]//select[@id=\"month\"]//following::option[contains(text(),'oct')]");
	 private static By BIRTHDAYYEARBUTTON = By.name("birthday_year");
	 private static By BIRTHDAYYEAR = By.xpath("//parent::span[@class=\"_5k_4\"]//select[@id=\"year\"]//following::option[contains(text(),'1984')]");
	 
	 private static By CREATE_ACCOUNT_BUTTON = By.id("u_0_2");
	 

	
	public static void openBrowser(String url) throws InterruptedException {		
		System.setProperty("webdriver.chrome.driver", "/Users/catalinamesa/Downloads/chromedriver");		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url); 
	}
	
	public static void searchWord(String name, String lastname, String email, String password,String birthdayDate, String sexGender) throws InterruptedException {						
		
		WebElement createAccount = driver.findElement(CREATE_ACCOUNT_BUTTON);
		createAccount.click();
		
		WebElement TextBox = (new WebDriverWait(driver, 10))
				.until(ExpectedConditions.visibilityOfElementLocated(NAME));
		TextBox.sendKeys(name);
		driver.findElement(LASTNAME).sendKeys(lastname);
	    WebElement emailText = driver.findElement(EMAIL);	    
	    if(emailText.isEnabled()) {
	    	emailText.sendKeys(email);
	    }	
		driver.findElement(PASSWORD).sendKeys(password);
		
		WebElement bithdayDateButton = driver.findElement(BIRTHDAYDATEBUTTON);
		bithdayDateButton.click();
		
		WebElement birthday = (new WebDriverWait(driver, 10))
				.until(ExpectedConditions.visibilityOfElementLocated(BIRTHDAYDATE)); 
		birthday.click();
		
		WebElement bithdayMonthButton = driver.findElement(BIRTHDAYMONTHBUTTON);
		bithdayMonthButton.click();
		
		WebElement birthdayMonth = (new WebDriverWait(driver, 10))
				.until(ExpectedConditions.visibilityOfElementLocated(BIRTHDAYMONTH)); 
		birthdayMonth.click();
		
		WebElement bithdayYearButton = driver.findElement(BIRTHDAYYEARBUTTON);
		bithdayYearButton.click();
		
		WebElement birthdayYear = (new WebDriverWait(driver, 10))
				.until(ExpectedConditions.visibilityOfElementLocated(BIRTHDAYYEAR)); 
		birthdayYear.click();

	    
		switch(sexGender.toUpperCase()){
		case "MUJER":
			WebElement genderSelectionF = driver.findElement(By.xpath("//input[@name='sex' and @value='1']"));
			genderSelectionF.click();
			break;
		case "HOMBRE":
			WebElement genderSelectionM = driver.findElement(By.xpath("//input[@name='sex' and @value='2']"));
			genderSelectionM.click();
			break;
			
		default:
			System.out.println("GENDER UNDEFINED");
		}	
		
	    Assert.assertEquals("Mujer",driver.findElement(By.xpath("//span[@class='_5k_2 _5dba']")).getText());    
		
	}
		

	public static void testNameTextArea(String nameNull) {
		WebElement TextBox = (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(NAME));
		TextBox.sendKeys(nameNull);
	    driver.findElement(CREATE_ACCOUNT_BUTTON).click();
	    Assert.assertEquals("El nombre es obligatorio",driver.findElement(By.xpath("//input[@name='firstname']//following::span[@class='error']")).getText());

	}
	
	public static void testLastnameTextArea(String lastNameNull) {
		WebElement TextBox = (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(NAME));
		TextBox.sendKeys(lastNameNull);
	    driver.findElement(CREATE_ACCOUNT_BUTTON).click();
	    Assert.assertEquals("El nombre es obligatorio",driver.findElement(By.xpath("//input[@name='firstname']//following::span[@class='error']")).getText());

	}
	
	public static void testPasswordTextArea(String passwordNull) {
		WebElement TextBox = (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(PASSWORD));
		TextBox.sendKeys(passwordNull);
	    driver.findElement(CREATE_ACCOUNT_BUTTON).click();
	    Assert.assertEquals("La constraseña es obligatoria",driver.findElement(By.xpath("//input[@name='password']//following::span[@class='error']")).getText());
	}
	
	
	public static void testEmailStructure(String emailWrongStructure) throws InterruptedException {		
		WebElement TextBox = (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(EMAIL));
		TextBox.sendKeys(emailWrongStructure);
	    driver.findElement(CREATE_ACCOUNT_BUTTON).click();
	    Assert.assertEquals("El correo electrónico no es válido",driver.findElement(By.xpath("//input[@name='email']//following::span[contains(text(),'El correo electrónico no es válido')]")).getText());		
	}
	

	
	public static void closeBrowser() {
		driver.close(); 
	}

}
