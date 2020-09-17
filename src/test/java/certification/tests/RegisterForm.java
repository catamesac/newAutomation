package certification.tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import certification.pages.RegisterFormPOM;

public class RegisterForm {
	
	String url = "https://www.facebook.com"; 
	String name = "Camilo"; 
	String lastname = "Mesa";
	String email = "cami_mesa2020@gmail.com"; 
	String password = "GOLDENhorse2020";
	String birthdayDate ="1984-08-24"; 
	String sexGender = "Hombre"; 
	String dataNull = "";
	String emailWrong = "milo11"; 


	
	@Before
	public void setUp() throws Exception {
		RegisterFormPOM.openBrowser(url);
	}

	@After 
	public void tearDown() throws Exception {
		RegisterFormPOM.closeBrowser();
	}
	
	@Test 
	public void test() throws InterruptedException {
		RegisterFormPOM.searchWord(name, lastname, email, password, birthdayDate, sexGender);	
		assert url!=null:String.format("Name es null");    
	}/*
	
	@Test 
	public void testNameWithoutData() throws InterruptedException {
		RegisterFormPOM.testNameTextArea(dataNull);
		assert dataNull!=null:String.format("Name is required");    
	}
	
	@Test 
	public void testLastnameWithoutData() throws InterruptedException {
		RegisterFormPOM.testLastnameTextArea(dataNull);
		assert dataNull!=null:String.format("Lastname is required");    
	}
	@Test 
	public void testPasswordWithoutData() throws InterruptedException {
		RegisterFormPOM.testPasswordTextArea(dataNull);
		assert dataNull!=null:String.format("Password is required");    
	}
	@Test 
	public void testEmailWrongData() throws InterruptedException {
		RegisterFormPOM.testEmailStructure(emailWrong);
		assert dataNull!=null:String.format("Wrong email structure");    
	}*/
		

}
