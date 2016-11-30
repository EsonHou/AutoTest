package com.auto.test.abclauncher_helper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import com.android.uiautomator.core.UiDevice;

/**
 * Creat by Eson on 2016/9/28 This class use to help to test on common place
 */
public class testABCLauncherSharehelper {

	String classname;

	/**
	 * 手机截屏并保存
	 * 
	 * @throws InterruptedException
	 */
	public void shotcutAndSave(int errorStep) {
		UiDevice.getInstance().takeScreenshot(new File("data/local/tmp/ABCLauncherTestLog/SaveShortcut/"
				+classname+"_"+ "Step" + Integer.toString(errorStep)  + ".png"));
	}


	/**
	 * 截屏并将错误信息写入log文件
	 * 
	 * @throws IOException
	 * @throws UnsupportedEncodingException
	 */
	public void errorLog(int step, String errorInfo) throws UnsupportedEncodingException, IOException {
		shotcutAndSave(step);// 截屏保存至文件夹
		
		File file2 = new File("data/local/tmp/ABCLauncherTestLog/LogRecord.txt");
		FileOutputStream out = new FileOutputStream(file2, true);
		StringBuffer sb = new StringBuffer();
		String errordsr = "Step " + Integer.toString(step) + ": " + errorInfo + "\n";
		sb.append(errordsr);
		out.write(sb.toString().getBytes("utf-8"));
	}

	/**
	 * 对操作结果判断并录入日志
	 * @throws IOException 
	 * @throws UnsupportedEncodingException 
	 */
	public void logRecord(int step,String desc,Boolean justic) throws UnsupportedEncodingException, IOException {
		if (!justic) {
			errorLog(step, desc);
		}
	}
	
	/**
	 * 一个用例开始在log文件加标识，便于log查看
	 */
	public void separateOfClass(String classname) throws UnsupportedEncodingException, IOException{
		File file = new File("data/local/tmp/ABCLauncherTestLog/LogRecord.txt");
		if(!file.exists()){
			file.mkdirs();
		}
		FileOutputStream out = new FileOutputStream(file, true);
		StringBuffer sb = new StringBuffer();
		String errordsr ="**********************" + classname + "**********************" + "\n"+ "\n";
		sb.append(errordsr);
		out.write(sb.toString().getBytes("utf-8"));
		this.classname = classname;
	}
	
	/**
	 * 运行bat文件中的adb命令
	 */
	public void runBatFile(){
	       try {  
	            Process ps = Runtime.getRuntime().exec("/Users/Eson/Documents/WorkSpaceForAndroidAuto/AutoTest_ABCLauncher/run.bat");  
	            InputStream in = ps.getInputStream();  
	            int c;  
	            while ((c = in.read()) != -1) {  
	            }  
	            in.close();  
	            ps.waitFor();  
	  
	        } catch (IOException ioe) {  
	            ioe.printStackTrace();  
	        } catch (InterruptedException e) {  
	            // TODO Auto-generated catch block  
	            e.printStackTrace();  
	        } 
	}

}
