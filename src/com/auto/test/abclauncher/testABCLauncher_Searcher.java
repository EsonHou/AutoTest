package com.auto.test.abclauncher;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;
import com.auto.test.abclauncher_helper.testABCLauncherOptionhelper;
import com.auto.test.abclauncher_helper.testABCLauncherSharehelper;

public class testABCLauncher_Searcher extends UiAutomatorTestCase{
	testABCLauncherSharehelper helpTest = new testABCLauncherSharehelper();
	testABCLauncherOptionhelper optionhelper = new testABCLauncherOptionhelper();
	@Override
	protected void setUp() throws Exception {
		helpTest.separateOfClass("testABCLauncher_Searcher");
		optionhelper.startAnimation();
		super.setUp();
	}

	@Override
	protected void tearDown() throws Exception {
		optionhelper.backToHome();
		super.tearDown();
	}

	public void testSearchBox() throws UiObjectNotFoundException, InterruptedException, UnsupportedEncodingException, IOException{
		optionhelper.clickById(1, "com.abclauncher.launcher:id/guide_start_btn");
		getUiDevice().wait(1000);
		
		UiObject startButt = new UiObject(new UiSelector().resourceId("com.abclauncher.launcher:id/guide_start_btn"));
		if(startButt.exists()){
			startButt.clickAndWaitForNewWindow(2000);
		}
		for(int i=0;i<8;i++){
			if(new UiObject(new UiSelector().resourceId("com.abclauncher.launcher:id/unlock_tips_text")).exists()){
				getUiDevice().pressBack();
				Thread.sleep(3000);
				break;
			}
			Thread.sleep(3000);
		}
	}
}
