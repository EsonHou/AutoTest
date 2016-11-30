package com.auto.test.abclauncher_helper;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;

import android.graphics.Point;
import android.view.MotionEvent;
import android.view.MotionEvent.PointerCoords;

public class testABCLauncherOptionhelper extends UiAutomatorTestCase{
	testABCLauncherSharehelper helpTest = new testABCLauncherSharehelper();
	
	/**
	 * 初次启动，动画加载
	 * 
	 * @throws UiObjectNotFoundException
	 * @throws IOException
	 * @throws UnsupportedEncodingException
	 * @throws InterruptedException 
	 */
	public void startAnimation() throws UiObjectNotFoundException, UnsupportedEncodingException, IOException, InterruptedException {
	
		for (int i = 0; i < 50; i++) {
			Thread.sleep(1000);
			if (new UiObject(new UiSelector().text("Google Play services")).exists()) {
				new UiObject(new UiSelector().resourceId("android:id/button1")).click();
				Thread.sleep(1000);
			}
			if (new UiObject(new UiSelector().resourceId("android:id/button1")).exists()) {
				new UiObject(new UiSelector().resourceId("android:id/button1")).click();
				Thread.sleep(1000);
			}
			if (new UiObject(new UiSelector().resourceId("com.android.packageinstaller:id/permission_allow_button"))
					.exists()) {
				new UiObject(new UiSelector().resourceId("com.android.packageinstaller:id/permission_allow_button"))
						.click();
				Thread.sleep(1000);
			}
			if (new UiObject(new UiSelector().resourceId("com.abclauncher.launcher:id/guide_start_btn"))
					.exists()
					&& new UiObject(new UiSelector().resourceId("com.abclauncher.launcher:id/guide_start_btn")).isClickable()) {
				new UiObject(new UiSelector().resourceId("com.abclauncher.launcher:id/guide_start_btn")).click();
			}
			if (new UiObject(new UiSelector().text("Create widget and allow access")).exists()) {
				new UiObject(new UiSelector().resourceId("android:id/button1")).click();
				Thread.sleep(1000);
			}
			if (new UiObject(new UiSelector().resourceId("android:id/alertTitle"))
					.exists()) {
				new UiObject(new UiSelector().resourceId("com.huawei.systemmanager:id/btn_allow"))
						.click();
				Thread.sleep(1000);
			}
		}
	}
	
	/**
	 * 通过Id点击操作对象
	 * @param step
	 * @param id
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 */
	public void clickById(int step,String id) throws UnsupportedEncodingException, IOException{
		UiObject clickOp = new UiObject(new UiSelector().resourceId(id));	
			try {
				clickOp.click();
			} catch (UiObjectNotFoundException e) {
				helpTest.logRecord(step, "对应的操作对象没有找到", false);
				e.printStackTrace();
			}		
	}
	
	/**
	 * 通过Id长按操作对象
	 * @param step
	 * @param id
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 */
	public void longClickById(int step,String id) throws UnsupportedEncodingException, IOException{
		UiObject clickOp = new UiObject(new UiSelector().resourceId(id));	
			try {
				clickOp.longClick();
			} catch (UiObjectNotFoundException e) {
				helpTest.logRecord(step, "对应的操作对象没有找到", false);
				e.printStackTrace();
			}		
	}
	
	/**
	 * 通过Text点击操作对象
	 * @param step
	 * @param text
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 */
	public void clickByText(int step,String text) throws UnsupportedEncodingException, IOException{
		UiObject clickOp = new UiObject(new UiSelector().text(text));
			try {
				clickOp.click();
			} catch (UiObjectNotFoundException e) {
				helpTest.logRecord(step, "对应的操作对象没有找到", false);
				e.printStackTrace();
			}		
	}
	
	/**
	 * 通过Text长按操作对象
	 * @param step
	 * @param text
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 */
	public void longClickByText(int step,String text) throws UnsupportedEncodingException, IOException{
		UiObject clickOp = new UiObject(new UiSelector().text(text));
			try {
				clickOp.longClick();
			} catch (UiObjectNotFoundException e) {
				helpTest.logRecord(step, "对应的操作对象没有找到", false);
				e.printStackTrace();
			}		
	}
	
	/**
	 * 通过Id判断空间是否存在
	 * @param id
	 * @return
	 */
	public boolean isExistsById(String id){
		UiObject element = new UiObject(new UiSelector().resourceId(id));
		if(element.exists()){
			return true;
		}else{
			return false;
		}		
	}
	
	/**
	 * 通过Text判断控件是否存在
	 */
	public boolean isExistsByText(String text){
		UiObject element = new UiObject(new UiSelector().text(text));
		if(element.exists()){
			return true;
		}else{
			return false;
		}		
	}
	
	/**
	 * 通过id定位控件，并判断是否已经选中
	 * @param step
	 * @param id
	 * @return
	 * @throws UiObjectNotFoundException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 */
	public boolean isCheckedById(int step,String id) throws UiObjectNotFoundException, UnsupportedEncodingException, IOException{
		UiObject element = new UiObject(new UiSelector().resourceId(id));
		if(element.exists()){
			if(element.isChecked()){
				return true;
			}else{
				return false;
			}			
		}else{
			helpTest.logRecord(step, "对应的操作对象没有找到", false);
			return false;
		}
	}
	
	/**
	 * 通过text定位控件，并判断是否已经选中
	 * @param step
	 * @param id
	 * @return
	 * @throws UiObjectNotFoundException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 */
	public boolean isCheckedByText(int step,String text) throws UiObjectNotFoundException, UnsupportedEncodingException, IOException{
		UiObject element = new UiObject(new UiSelector().text(text));
		if(element.exists()){
			if(element.isChecked()){
				return true;
			}else{
				return false;
			}			
		}else{
			helpTest.logRecord(step, "对应的操作对象没有找到", false);
			return false;
		}
	}

	/**
	 * 通过id定位控件，并判断是否可选
	 * @param step
	 * @param id
	 * @return
	 * @throws UiObjectNotFoundException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 */
	public boolean isCheckableById(int step,String id) throws UiObjectNotFoundException, UnsupportedEncodingException, IOException{
		UiObject element = new UiObject(new UiSelector().resourceId(id));
		if(element.exists()){
			if(element.isCheckable()){
				return true;
			}else{
				return false;
			}			
		}else{
			helpTest.logRecord(step, "对应的操作对象没有找到", false);
			return false;
		}
	}
	
	/**
	 * 通过text定位控件，并判断是否可选
	 * @param step
	 * @param id
	 * @return
	 * @throws UiObjectNotFoundException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 */
	public boolean isCheckableByText(int step,String text) throws UiObjectNotFoundException, UnsupportedEncodingException, IOException{
		UiObject element = new UiObject(new UiSelector().text(text));
		if(element.exists()){
			if(element.isCheckable()){
				return true;
			}else{
				return false;
			}			
		}else{
			helpTest.logRecord(step, "对应的操作对象没有找到", false);
			return false;
		}
	}
	
	/**
	 * 通过id定位控件，并判断是否可点
	 * @param step
	 * @param id
	 * @return
	 * @throws UiObjectNotFoundException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 */
	public boolean isClickableById(int step,String id) throws UiObjectNotFoundException, UnsupportedEncodingException, IOException{
		UiObject element = new UiObject(new UiSelector().resourceId(id));
		if(element.exists()){
			if(element.isClickable()){
				return true;
			}else{
				return false;
			}			
		}else{
			helpTest.logRecord(step, "对应的操作对象没有找到", false);
			return false;
		}
	}
	
	/**
	 * 通过text定位控件，并判断是否可点
	 * @param step
	 * @param id
	 * @return
	 * @throws UiObjectNotFoundException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 */
	public boolean isClickableByText(int step,String text) throws UiObjectNotFoundException, UnsupportedEncodingException, IOException{
		UiObject element = new UiObject(new UiSelector().text(text));
		if(element.exists()){
			if(element.isClickable()){
				return true;
			}else{
				return false;
			}			
		}else{
			helpTest.logRecord(step, "对应的操作对象没有找到", false);
			return false;
		}
	}
	
	/**
	 * 通过id定位控件，并判断是否获取焦点
	 * @param step
	 * @param id
	 * @return
	 * @throws UiObjectNotFoundException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 */
	public boolean isFocusedById(int step,String id) throws UiObjectNotFoundException, UnsupportedEncodingException, IOException{
		UiObject element = new UiObject(new UiSelector().resourceId(id));
		if(element.isFocused()){
			if(element.isCheckable()){
				return true;
			}else{
				return false;
			}			
		}else{
			helpTest.logRecord(step, "对应的操作对象没有找到", false);
			return false;
		}
	}
	
	/**
	 * 通过text定位控件，并判断是否获取焦点
	 * @param step
	 * @param id
	 * @return
	 * @throws UiObjectNotFoundException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 */
	public boolean isFocusedByText(int step,String text) throws UiObjectNotFoundException, UnsupportedEncodingException, IOException{
		UiObject element = new UiObject(new UiSelector().text(text));
		if(element.isFocused()){
			if(element.isCheckable()){
				return true;
			}else{
				return false;
			}			
		}else{
			helpTest.logRecord(step, "对应的操作对象没有找到", false);
			return false;
		}
	}
	
	/**
	 * 通过Id定位对象，并输入内容
	 * @param step
	 * @param id
	 * @param des
	 * @throws UiObjectNotFoundException
	 * @throws InterruptedException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 */
	public void setTextById(int step,String id,String des) throws UiObjectNotFoundException, InterruptedException, UnsupportedEncodingException, IOException{
		UiObject element = new UiObject(new UiSelector().resourceId(id));
		if(element.exists()){
			element.setText(des);
			Thread.sleep(1000);
		}else{
			helpTest.logRecord(step, "操作对象不存在", false);
		}
	}
	
	/**
	 * 通过Text定位对象，并输入内容
	 * @param step
	 * @param text
	 * @param des
	 * @throws UiObjectNotFoundException
	 * @throws InterruptedException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 */
	public void setTextByText(int step,String text,String des) throws UiObjectNotFoundException, InterruptedException, UnsupportedEncodingException, IOException{
		UiObject element = new UiObject(new UiSelector().text(text));
		if(element.exists()){
			element.setText(des);
			Thread.sleep(1000);
		}else{
			helpTest.logRecord(step, "操作对象不存在", false);
		}
	}
	
	/**
	 * 通过Id定位对象，并清空内容
	 * @param step
	 * @param id
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 * @throws InterruptedException
	 * @throws UiObjectNotFoundException
	 */
	public void clearEditTextById(int step,String id) throws UnsupportedEncodingException, IOException, InterruptedException, UiObjectNotFoundException{
		UiObject element = new UiObject(new UiSelector().resourceId(id));
		if(element.exists()){
			element.clearTextField();
			Thread.sleep(1000);
		}else{
			helpTest.logRecord(step, "操作对象不存在", false);
		}
		
		
		PointerCoords p = new PointerCoords();
		p.x = 200;
		p.y = 200;
		p.pressure = 1;
		p.size = 1;
		
		element.performMultiPointerGesture();
	}
	
	/**
	 * 通过Text定位对象，并清空内容
	 * @param step
	 * @param text
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 * @throws InterruptedException
	 * @throws UiObjectNotFoundException
	 */
	public void clearEditTextByText(int step,String text) throws UnsupportedEncodingException, IOException, InterruptedException, UiObjectNotFoundException{
		UiObject element = new UiObject(new UiSelector().text(text));
		if(element.exists()){
			element.clearTextField();
			Thread.sleep(1000);
		}else{
			helpTest.logRecord(step, "操作对象不存在", false);
		}
	}
	
	/**
	 * 通过坐标点击
	 * @param step
	 * @param X
	 * @param Y
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 */
	public void clickByCoordinate(int step,int X,int Y) throws UnsupportedEncodingException, IOException{
		int maxX = getUiDevice().getDisplayWidth();
		int maxY = getUiDevice().getDisplayHeight();
		if(X<=maxX && Y<= maxY){
			getUiDevice().click(X, Y);
		}else{
			helpTest.logRecord(step, "坐标超出屏幕可点击范围", false);
		}
	}
	/**
	 * 通过坐标长按
	 * @param step
	 * @param X
	 * @param Y
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 */
	public void longClickByCoordinate(int step,int X,int Y) throws UnsupportedEncodingException, IOException{
		int maxX = getUiDevice().getDisplayWidth();
		int maxY = getUiDevice().getDisplayHeight();
		if(X<=maxX && Y<= maxY){
			getUiDevice().drag(X, Y, X+10, Y+10, 200);
		}else{
			helpTest.logRecord(step, "坐标超出屏幕可点击范围", false);
		}
	}
	
	/**
	 * 将控件拖拽到指定位置
	 * @param step
	 * @param id
	 * @param x
	 * @param y
	 * @param steps
	 * @throws UiObjectNotFoundException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void dragToById(int step,String id,int x,int y,int steps) throws UiObjectNotFoundException, UnsupportedEncodingException, IOException, InterruptedException{
		UiObject element = new UiObject(new UiSelector().resourceId(id));
		if(element.exists()){
			int maxX = getUiDevice().getDisplayWidth();
			int maxY = getUiDevice().getDisplayHeight();
			if(x<=maxX && y<= maxY){
				element.dragTo(x, y,100);
			}else{
				helpTest.logRecord(step, "坐标超出屏幕可点击范围", false);
			}
			Thread.sleep(1000);
		}else{
			helpTest.logRecord(step, "操作对象不存在", false);
		}
	}
	
	/**
	 * 将控件拖拽到指定位置
	 * @param step
	 * @param text
	 * @param x
	 * @param y
	 * @param steps
	 * @throws UiObjectNotFoundException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void dragToByText(int step,String text,int x,int y,int steps) throws UiObjectNotFoundException, UnsupportedEncodingException, IOException, InterruptedException{
		UiObject element = new UiObject(new UiSelector().text(text));
		if(element.exists()){
			int maxX = getUiDevice().getDisplayWidth();
			int maxY = getUiDevice().getDisplayHeight();
			if(x<=maxX && y<= maxY){
				element.dragTo(x, y,100);
			}else{
				helpTest.logRecord(step, "坐标超出屏幕可点击范围", false);
			}
			Thread.sleep(1000);
		}else{
			helpTest.logRecord(step, "操作对象不存在", false);
		}
	}
	
	/**
	 * 返回主界面
	 */
	public void backToHome(){
		getUiDevice().pressBack();
		getUiDevice().pressBack();
		getUiDevice().pressBack();
		getUiDevice().pressBack();
	}
	
	/**
	 * 单指手势滑动
	 */
	public void performMultiPointerGesture(UiObject element){
		
		//单指手势
		PointerCoords p1 = new PointerCoords();
		p1.x = 500; p1.y = 500; p1.pressure = 1; p1.size = 1;
		PointerCoords p2 = new PointerCoords();
		p2.x = 500; p2.y = 500; p2.pressure = 1; p2.size = 1;
		element.performMultiPointerGesture(p1,p2);
		
		//双指手势滑动
		Point point1 = new Point();
		point1.x = 200;
		point1.y = 300;	
		element.performTwoPointerGesture(point1, point1, point1, point1, 50);
		
		//双指捏合
		try {
			element.pinchIn(60, 50);
		} catch (UiObjectNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//双指打开
		try {
			element.pinchOut(60, 50);
		} catch (UiObjectNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}	
}
