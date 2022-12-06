package maveneight;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FaceBook_Register {

	public static Properties prop;
	public static FileInputStream file;
	public static WebDriver driver;
	public static WebDriverWait wait;
	public static Select select;
	public static void main(String[] args) throws Exception {

		System.out.println(System.getProperty("user.dir"));
		//C:\Users\zuly0\eclipse-workspace\Maven_Eight
		String path = System.getProperty("user.dir") + "\\src\\test\\java\\maveneight\\config.properties";
		
		prop = new Properties();
		file = new FileInputStream(path);
		prop.load(file);
		
		System.out.println(prop.getProperty("url"));
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(prop.getProperty("url"));
		
		driver.findElement(By.linkText(prop.getProperty("createaccount"))).click();
		driver.findElement(By.name(prop.getProperty("fnamexpath"))).sendKeys(prop.getProperty("fname"));
		driver.findElement(By.name(prop.getProperty("lnamexpath"))).sendKeys(prop.getProperty("lname"));
		driver.findElement(By.name(prop.getProperty("emailxpath"))).sendKeys(prop.getProperty("email"));
		
		wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		WebElement confirmemail = driver.findElement(By.name("reg_email_confirmation__"));
		wait.until(ExpectedConditions.elementToBeClickable(confirmemail)).sendKeys(prop.getProperty("email"));
		driver.findElement(By.name(prop.getProperty("passwordxpath"))).sendKeys(prop.getProperty("password"));
		//wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		//WebElement confirmpassword = driver.findElement(By.)
		select = new Select(driver.findElement(By.cssSelector("#month")));
		select.selectByVisibleText("Jan");
		select = new Select(driver.findElement(By.cssSelector("#day")));
		select.selectByVisibleText("29");
		
		driver.findElement(By.xpath("//label[contains(text(),'Female')]")).click();
		
		driver.quit();
		
		
		
	}

}
