package src;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SearchTest {
	
	WebDriver driver = new ChromeDriver();
	
	public SearchTest(String search){
		openPage();
		enterValidCred();
		clickFindPeople();
		enterSearch(search);
		verifySearch(search);
	}
	
	private void openPage() {
		driver.get("http://dev.workmarket.com/login");
		driver.manage().window().fullscreen();
	}
	
	private void enterValidCred() {
		WebElement w = driver.findElement(By.xpath("//*[@name = 'userEmail']"));
		w.sendKeys("qa+candidatetest@workmarket.com");
		WebElement x = driver.findElement(By.xpath("//*[@name = 'password']"));
		x.sendKeys("candidate123");
		WebElement y = driver.findElement(By.xpath("//*[@id= 'login_page_button']"));
		y.click();
	}
	
	private void clickFindPeople() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement wait = driver.findElement(By.xpath("(//*[@role = 'menuitem'])[9]"));
		WebElement searchFor = driver.findElement(By.xpath("(//*[@role = 'menuitem'])[9]"));
		searchFor.click();
	}
	
	private void enterSearch(String search) {
		WebElement field = driver.findElement(By.xpath("//*[@id = 'input-text']"));
		field.sendKeys(search);
	}
	
	private void verifySearch(String search) {
		
		List<WebElement> list = driver.findElements(By.xpath("//*[@id = 'search_results']/div[@class = 'profile-card']"));
		
		for(int i = 0; i<list.size(); i++) {
			
			WebElement w = list.get(i);
			
			String name = w.findElement(By.xpath(".//a")).getText();
			
			String bigName = name.toUpperCase();
			
			String address = w.findElement(By.xpath(".//ul[@class = 'profile-card--address']")).getText();
			
			String bigAddress = address.toUpperCase();
			
			String bigSearch = search.toUpperCase();
			
			if(!bigName.contains(bigSearch) && !bigAddress.contains(bigSearch)) {
				System.out.println("On element "+i+" of the list, the element does not contain: "+search+". Info reads name: "+name+" , and address: "+address);
			}
			
		}
		
		driver.close();
	}
}
