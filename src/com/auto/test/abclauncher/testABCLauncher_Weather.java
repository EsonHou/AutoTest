package com.auto.test.abclauncher;

import java.io.IOException;

import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;
import com.auto.test.abclauncher_helper.testABCLauncherOptionhelper;
import com.auto.test.abclauncher_helper.testABCLauncherSharehelper;

public class testABCLauncher_Weather extends UiAutomatorTestCase {
	testABCLauncherSharehelper helpTest = new testABCLauncherSharehelper();
	testABCLauncherOptionhelper optionhelper = new testABCLauncherOptionhelper();

	@Override
	protected void setUp() throws Exception {
		helpTest.separateOfClass("testABCLauncher_Weather");
		optionhelper.startAnimation();
		super.setUp();
	}

	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testWeatherWight() throws UiObjectNotFoundException, IOException, InterruptedException {
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

		UiObject weatherwig = new UiObject(new UiSelector().resourceId("com.abclauncher.launcher:id/condition_des"));
		helpTest.logRecord(1, "点击开始按钮进入主界面失败", weatherwig.exists());
		
		/**
		 * Step 1:点击天气小部件
		 * ExceptResult：进入天气详情页
		 */
		weatherwig.clickAndWaitForNewWindow();
		UiObject citySear = new UiObject(new UiSelector().resourceId("com.abclauncher.launcher:id/action_search"));
		helpTest.logRecord(2, "进入天气详情页失败", citySear.exists());
		Thread.sleep(1500);

		citySear.clickAndWaitForNewWindow(1000);
		UiObject inputName = new UiObject(new UiSelector().resourceId("com.abclauncher.launcher:id/edittext"));
		helpTest.logRecord(3, "进入搜索城市页面失败", inputName.exists());
		String before = inputName.getText();
		
		inputName.setText("hou");
		getUiDevice().click(getUiDevice().getDisplayWidth()/2, getUiDevice().getDisplayHeight()*4/5);
		Thread.sleep(5000);
		helpTest.logRecord(4, inputName.getText()+"************8", !inputName.getText().equals(before));
		
		if(new UiObject(new UiSelector().resourceId("com.abclauncher.launcher:id/tv_no_network")).exists()){
			helpTest.logRecord(5, "无网络，无法搜索", true);
			getUiDevice().pressBack();
			if(!citySear.exists()){
				getUiDevice().pressBack();
			}
		}else if(new UiObject(new UiSelector().resourceId("com.abclauncher.launcher:id/tv_no_such_city")).exists()){
			helpTest.logRecord(6, "无匹配城市", true);
			if(!citySear.exists()){
				getUiDevice().pressBack();
			}
		}else if(new UiObject(new UiSelector().resourceId("com.abclauncher.launcher:id/textview")).exists()){
			new UiObject(new UiSelector().resourceId("com.abclauncher.launcher:id/textview")).clickAndWaitForNewWindow();
			Thread.sleep(3000);
		}
		
		UiObject showMore = new UiObject(new UiSelector().resourceId("com.abclauncher.launcher:id/condition_show_more"));
		showMore.click();
		Thread.sleep(1500);
		
		UiObject dewPoint = new UiObject(new UiSelector().resourceId("com.abclauncher.launcher:id/dewpoint"));
		helpTest.logRecord(7, "点击展示更多失败", dewPoint.exists());
		
		showMore.click();
		Thread.sleep(1500);
		helpTest.logRecord(8, "点击收起更多失败", !dewPoint.exists());
		
		helpTest.logRecord(9, "控件不存在0", new UiObject(new UiSelector().resourceId("com.abclauncher.launcher:id/weekday")).exists());
		helpTest.logRecord(9, "控件不存在", new UiObject(new UiSelector().resourceId("com.abclauncher.launcher:id/daily_forecast_weekday").instance(6)).exists());
		String whichDay = new UiObject(new UiSelector().resourceId("com.abclauncher.launcher:id/weekday")).getText();
		String nextSevenDay = new UiObject(new UiSelector().resourceId("com.abclauncher.launcher:id/daily_forecast_weekday").instance(6)).getText();
		helpTest.logRecord(9,whichDay+ "展示的不是接下来7天的天气"+nextSevenDay, whichDay.equals(nextSevenDay));
				
		UiObject dailyOne = new UiObject(new UiSelector().resourceId("com.abclauncher.launcher:id/forecast_daily_one"));
		dailyOne.click();
		Thread.sleep(1500);
		UiObject dailyInfo = new UiObject(new UiSelector().resourceId("com.abclauncher.launcher:id/daily_forecast_part_three_ll"));
		helpTest.logRecord(10, "点击查看明日天气失败", dailyInfo.exists());
		
		String currTemp = new UiObject(new UiSelector().resourceId("com.abclauncher.launcher:id/curr_temp")).getText();
		
		getUiDevice().drag(0, 300, getUiDevice().getDisplayWidth()-100, 300, 50);
		UiObject tempButt = new UiObject(new UiSelector().text("Temperature"));
		tempButt.click();
		Thread.sleep(1500);
		
		getUiDevice().pressBack();
		helpTest.logRecord(11, "返回到天气详情页失败", new UiObject(new UiSelector().resourceId("com.abclauncher.launcher:id/curr_temp")).exists());
		
		String currTemp1 = new UiObject(new UiSelector().resourceId("com.abclauncher.launcher:id/curr_temp")).getText();
		helpTest.logRecord(12, "切换温度单位失败",! currTemp.equals(currTemp1));
		
		
	}
}