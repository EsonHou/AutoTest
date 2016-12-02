package com.auto.test.abclauncher.main;

import java.io.IOException;

import com.auto.test.abclauncher_helper.testABCLauncherSharehelper;

public class startTest {


    public static void main(String args[]) throws InterruptedException, IOException {
		testABCLauncherSharehelper helpTest = new testABCLauncherSharehelper();
		helpTest.runBatFile();
		//abc
    }
}
