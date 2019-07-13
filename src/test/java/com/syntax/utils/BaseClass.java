package com.syntax.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseClass {

	public static Properties prop;
	public static WebDriver driver;

	public static void setUp() {
		initProperties(Constants.filePath);
		String browserName = prop.getProperty("browser");

		if (browserName.equalsIgnoreCase("chrome")) {
			if (Constants.osName.contains("Mac")) {
				System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver");
			} else if (Constants.osName.contains("Windows")) {
				System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
			}
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			if (Constants.osName.contains("Mac")) {
				System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/geckodriver");
			} else if (Constants.osName.contains("Windows")) {
				System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/geckodriver.exe");
			}
			driver = new FirefoxDriver();
		}
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		if (Constants.osName.contains("Mac")) {
			driver.manage().window().fullscreen();
		} else if (Constants.osName.contains("Windows")) {
			driver.manage().window().maximize();
		}
		driver.get(prop.getProperty("url"));
	}

	public static void tearDown() {
		driver.quit();
	}

	public static void initProperties(String filePath) {

		prop = new Properties();
	
			FileInputStream fis;
			try {
				fis = new FileInputStream(filePath);
				prop.load(fis);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
}
