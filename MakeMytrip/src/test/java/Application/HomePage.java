package Application;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	
	WebDriver driver;
	WebDriverWait wait;
	JavascriptExecutor js;
	
	@FindBy(xpath = "//span[@class='commonModal__close']")
	public WebElement alertpop;
	
@FindBy(xpath = "//a[@class='headerIcons makeFlex hrtlCenter column active']")
public WebElement Flights;

@FindBy(xpath = "//li[@data-cy='roundTrip']/span")
public WebElement roundTrip;

@FindBy(xpath = "//label[@for='fromCity']")
public WebElement fromcity;

@FindBy(xpath = "//input[@aria-controls='react-autowhatever-1']")
public WebElement fromcitydata;

@FindBy(xpath = "//p[text()='Bengaluru, India']")
public WebElement fromCityName;

@FindBy(xpath = "//label[@for='toCity']")
public WebElement TooCity;

@FindBy(xpath = "//input[@aria-controls='react-autowhatever-1']")
public WebElement toocityData;

@FindBy(xpath = "(//p[text()='Chennai, India'])[1]")
public WebElement toocityName;

@FindBy(xpath = "(//div[contains(@aria-label, 'Mon Oct 30 2023')])[1]")
public WebElement fromdate;

@FindBy(xpath = "//div[contains(@aria-label, 'Wed Nov 15 2023')]")
public WebElement returnDate;

@FindBy(xpath = "//label[@for='travellers']")
public WebElement travellers;

@FindBy (xpath = "//button[text()='APPLY']")
public WebElement apply;


@FindBy(xpath = "//a[text()='Search']")
public WebElement search;

public HomePage(WebDriver driver)
{
	this.driver=driver;
	PageFactory.initElements(driver, this);

}

public void dataFil(int adult,int child,int infa)
{
	alertpop.click();
	Flights.click();
	roundTrip.click();
	fromcity.click();
	fromcitydata.sendKeys("bengaluru");
	fromCityName.click();
	TooCity.click();
	toocityData.sendKeys("Chennai, India");
	WebElement scrollableDiv = driver.findElement(By.className("react-autosuggest__suggestions-container"));
	 js = (JavascriptExecutor) driver;
	js.executeScript("arguments[0].scrollTop = 200;", scrollableDiv);
	toocityName.click();
	
	 js.executeScript("window.scrollBy(0, 500);");
	 wait=new WebDriverWait(driver ,Duration.ofSeconds(10));
	 WebElement untilfromDate = wait.until(ExpectedConditions.elementToBeClickable(fromdate));
	 untilfromDate.click();
	 WebElement untiltoodate = wait.until(ExpectedConditions.elementToBeClickable(returnDate));
	 untiltoodate.click();
	 js.executeScript("window.scrollTo(0, 0);");
	 wait=new WebDriverWait(driver ,Duration.ofSeconds(10));
	 WebElement ele=wait.until(ExpectedConditions.elementToBeClickable(travellers));
	 ele.click();
	 String ad="//li[@data-cy='adults-"+adult+"']";
	 String ch="//li[@data-cy='children-"+child+"']";
	 String inf="//li[@data-cy='infants-"+infa+"']";
	 driver.findElement(By.xpath(ad)).click();
	 driver.findElement(By.xpath(ch)).click();
	 driver.findElement(By.xpath(inf)).click();
	 WebElement webElement = wait.until(ExpectedConditions.elementToBeClickable(apply));
	 js.executeScript("window.scrollBy(0, 700);");
	 webElement.click();
	 search.click();
	
}

}
