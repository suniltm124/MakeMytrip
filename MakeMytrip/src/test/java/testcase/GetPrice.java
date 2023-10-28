package testcase;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Application.FlightSelectionPage;
import Application.HomePage;

public class GetPrice {

	  WebDriver driver;
	  @BeforeTest
	  public void setup() {
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(" https://www.makemytrip.com/");
	}
	  @Test
	  public void GetPricedata()
	  {
		  HomePage hp=new HomePage(driver);
		  hp.dataFil(2, 1, 1);
		  FlightSelectionPage fsp=new FlightSelectionPage(driver);
		  fsp.Price();
		  driver.quit();
	  }
}
