package src;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SignUpTest {

	
	WebDriver driver = new ChromeDriver();
	
	public SignUpTest(String first, String last, String email, String password) {
		openPage();
		selectInd();
		enterFirst(first);
		enterLast(last);
		enterEmail(email);
		enterPassword(password);
		selectTerms();
		selectSignUp();
		errorCheck();
	}
	
	private void openPage() {
		driver.get("https://dev.workmarket.com/register/campaign/10081C503B209A0C8E7F05FDCC1AA98D4C904DEEF5F73265CAE38C744E7EAD3E");
		driver.manage().window().fullscreen();
	}
	
	private void enterFirst(String name) {
		WebElement firstInput = driver.findElement(By.xpath("//*[@id = 'firstname']"));
		firstInput.sendKeys(name);
	}
	
	private void enterLast(String name) {
		WebElement lastInput = driver.findElement(By.xpath("//*[@id = 'lastname']"));
		lastInput.sendKeys(name);
	}
	
	private void enterEmail(String input) {
		WebElement email = driver.findElement(By.xpath("//*[@id = 'email']"));
		email.sendKeys(input);
	}
	
	private void enterPassword(String pass) {
		WebElement passwordInput = driver.findElement(By.xpath("//*[@id = 'password']"));
		passwordInput.sendKeys(pass);
		passwordInput.click();
	}
	
	private void selectTerms() {
		WebElement terms = driver.findElement(By.xpath("//*[@value = 'on']"));
		terms.click();
	}
	
	private void selectSignUp() {
		WebElement reg = driver.findElement(By.xpath("//*[contains(text(), 'Register')]"));
		reg.click();
	}
	
	private void errorCheck() {
		List<WebElement> err = driver.findElements(By.xpath("//*[contains(text(), 'Please')]"));
		
		if(err.size() > 0) {
			
			List<WebElement> firstError = driver.findElements(By.xpath("//*[contains(text(), 'Please enter a valid  email')]"));
			if(firstError.size() > 0) {
				System.out.println("Email is not valid");
			}
			
			List<WebElement> secondError = driver.findElements(By.xpath("//*[contains(text(), 'Please enter a valid password')]"));
			if(secondError.size() > 0) {
				System.out.println("Password is not valid");
				driver.close();
			}
			
			System.out.println("There seems to be an error");
			
		}else {
			System.out.println("Credentials created a profile");
			driver.close();
		}
	}
	
	private void selectInd() {
		WebElement ind = driver.findElement(By.xpath("//*[contains(text(), 'Join as an individual')]"));
		ind.click();
	}
	
}
