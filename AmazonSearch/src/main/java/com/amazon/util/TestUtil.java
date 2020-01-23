package com.amazon.util;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class TestUtil {
	
	public static long PAGE_LOAD_TIMEOUT =20;
	public static long IMPLICIT_WAIT =30;
	static WebDriver driver;
	
	public static void takeScreenshotAtEndOfTest() throws IOException {
		TakesScreenshot screenshot = ((TakesScreenshot) driver);
		File scrFile = screenshot.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File("./Screenshots/" + System.currentTimeMillis() + ".png"));
	}
}
