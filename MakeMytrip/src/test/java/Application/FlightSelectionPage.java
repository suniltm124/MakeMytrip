package Application;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlightSelectionPage {

	WebDriver driver;
	WebDriverWait wait;
	JavascriptExecutor js;
	
@FindBy(xpath = "//button[text()='OKAY, GOT IT!']")
public WebElement flighpopup;

@FindBy(xpath = "//button[text()='Book Now']")
public WebElement bookbutton;

@FindBy(xpath = "//button[text()='Continue']")
public WebElement Continue;

@FindBy(xpath = "(//div[@class='fareFooter']/p[@class='fareRow']/span[@class='fontSize16 blackFont'])[2]")
public WebElement farePrice;

public FlightSelectionPage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
}

public void Price() {
	
	String window=driver.getWindowHandle();
	wait=new WebDriverWait(driver, Duration.ofSeconds(500));
	WebElement untilFlight = wait.until(ExpectedConditions.elementToBeClickable(flighpopup));
	untilFlight.click();
	
	WebElement bookbuttonflight = wait.until(ExpectedConditions.elementToBeClickable(bookbutton));
	
	bookbuttonflight.click();
	
	WebElement continuebutton = wait.until(ExpectedConditions.elementToBeClickable(Continue));
	continuebutton.click();
	
	Set<String> windowHandles = driver.getWindowHandles();
	for(String win:windowHandles )
	{
		if(!window.equals(win))
		{
			driver.switchTo().window(win);
		}
		
	}
	String Tp = farePrice.getText();
		String TotalPrice = Tp.replaceAll("[^0-9]", "");
	
	System.out.println("Total Price  "+"  "+Integer.parseInt(TotalPrice));
	
	
}
}
