package Android_stepdefinations;

import java.io.IOException;

import org.testng.Assert;

import Android_screens.Login_Screen;
import config.Hooks;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import utils.CommonUtils;

//@RunWith(Cucumber.class)
public class Login_Page implements Login_Screen {

	public static AppiumDriver<MobileElement> driver;
	public CommonUtils commonUtils;

	public Login_Page() throws IOException {
		driver = Hooks.getDriver();
		commonUtils = new CommonUtils(driver);
	}

	@Given("^User opens the PickxTV application$")
	public void user_opens_the_pickxtv_application() {
		commonUtils.waitTillVisibility(home_button, 8);
		Assert.assertTrue(commonUtils.displayed(home_button));
	}

	@When("^The user see the home page and validates the loaded home page$")
	public void the_user_see_the_home_page_and_validates_the_loaded_home_page() throws InterruptedException {
		commonUtils.swipeUpOverHomeScreen();
		Assert.assertTrue(commonUtils.displayed(swimlane_title));
		Assert.assertTrue(commonUtils.displayed(swimlane_container));
//		Assert.assertTrue(commonUtils.displayed(liveTV_button));
//		Assert.assertTrue(commonUtils.displayed(tvGuide_button));
//		Assert.assertTrue(commonUtils.displayed(Recordings));
		commonUtils.waitTillVisibility(live_icon, 8);
		Assert.assertTrue(commonUtils.displayed(live_icon));
	}
}
