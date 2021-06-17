package utils;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.TestException;

import base.base;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class CommonUtils extends base {

	public AppiumDriver<MobileElement> driver;
	public WebDriverWait wait;
	public Actions actions;

	public CommonUtils(AppiumDriver<MobileElement> driver) throws IOException {
		this.driver = driver;
	}

	public void clickonElement(By locator) {
		try {
			driver.findElement(locator).click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void sendKey(By locator, String value) {
		try {
			driver.findElement(locator).sendKeys(value);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public boolean displayed(By locator) {

		try {
			return driver.findElement(locator).isDisplayed();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;

	}

	public boolean enabled(By locator) {

		try {
			return driver.findElement(locator).isEnabled();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;

	}

	public boolean selected(By locator) {

		try {
			return driver.findElement(locator).isSelected();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;

	}

	public void navigateToURL(String URL) {
		System.out.println("Navigating to: " + URL);
		System.out.println("Thread id = " + Thread.currentThread().getId());

		try {
			driver.navigate().to(URL);
		} catch (Exception e) {
			System.out.println("URL did not load: " + URL);
			throw new TestException("URL did not load");
		}
	}

	public String getPageTitle() {
		try {
			System.out.print(String.format("The title of the page is: %s\n\n", driver.getTitle()));
			return driver.getTitle();
		} catch (Exception e) {
			throw new TestException(String.format("Current page title is: %s", driver.getTitle()));
		}
	}

	public WebElement getElement(By selector) {
		try {
			return driver.findElement(selector);
		} catch (Exception e) {
			System.out.println(String.format("Element %s does not exist - proceeding", selector));
		}
		return null;
	}

	public void clearField(WebElement locator) {
		try {
			locator.clear();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void waitTillVisibility(By locator, int timeoutInSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	public MobileElement findElement(By locator) {
		try {
			return driver.findElement(locator);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<MobileElement> findElements(By locator) {
		List<MobileElement> elementList = driver.findElements(locator);
		if (elementList.isEmpty())
			throw new TestException(String.format("Element %s does not exist", locator));
		return elementList;
	}

	public String getText(By locator) {
		try {
			return driver.findElement(locator).getText();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
        public void waitTillTextChanges(String expectedText, By locator) {
    		WebDriverWait wait = new WebDriverWait(driver, 10);
    		wait.until(ExpectedConditions.attributeToBe(locator, "text", expectedText));
        }
        
        public void swipeUpOverHomeScreen() {
    		int heighOfScreen = driver.manage().window().getSize().height;
    		int widthOfScreen = driver.manage().window().getSize().width;
    		int startX = widthOfScreen / 2;
    		int startY = heighOfScreen / 2;
    		int stopX = startX;
    		int stopY = heighOfScreen / 4;
        	new TouchAction(driver).press(PointOption.point(startX, startY))
        		.waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000))).moveTo(PointOption.point(stopX, stopY))
        		.release().perform();
        }

        public void switchcontext(String context) {
    		System.out.println("Before switching : " + driver.getContext());
    		Set<String> contextNames = driver.getContextHandles();
        	for (String contextName : contextNames) {
        	    System.out.println("Available context : " + contextName);
        	    if(contextName.contains(context)) {
        	    	driver.context(contextName);
        	    	break;
        	    }
        	}
        	System.out.println("After switching : " + driver.getContext());
    	}

        public void waitTillInvisibility(By locator, int timeoutInSeconds) {
        	WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        	wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
        }
}
