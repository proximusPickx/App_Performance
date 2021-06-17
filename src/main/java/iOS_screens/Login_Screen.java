package iOS_screens;

import org.openqa.selenium.By;

import io.appium.java_client.MobileBy;


public interface Login_Screen {

	By home_button= MobileBy.AccessibilityId("home_tab_bar_item");
	By liveTV_button= MobileBy.AccessibilityId("livetv_tab_bar_item");
	By tvGuide_button= MobileBy.AccessibilityId("tvguide_tab_bar_item");
	By Recordings= MobileBy.AccessibilityId("recordings_tab_bar_item");
	By swimlane_title = MobileBy.id("be.belgacom.mobile.adeleeverywhere:id/textview_swimlane_title");
	By swimlane_container = MobileBy.id("be.belgacom.mobile.adeleeverywhere:id/recyclerview_swimlane");
	By live_icon = MobileBy.id("be.belgacom.mobile.adeleeverywhere:id/textview_label");
	
}
