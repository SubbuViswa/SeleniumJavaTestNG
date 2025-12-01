package com.subbu.factory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.io.FileHandler;

import com.subbu.utils.Constants;
import com.subbu.utils.OptionsManager;

/**
 * This function is used to initialize driver
 * 
 */
public class DriverFactory {

	public WebDriver driver;
	public static String highlight;
	private OptionsManager optionsManager;
	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<WebDriver>();

	public WebDriver initDriver(Properties prop) {
		String browserName = prop.getProperty("browser");
		highlight = prop.getProperty("highlight");
		optionsManager = new OptionsManager(prop);

		if (browserName.equalsIgnoreCase("chrome")) {
			// driver=new ChromeDriver();
			tlDriver.set(new ChromeDriver(optionsManager.getChromeOptions()));
			} 
		else if (browserName.equalsIgnoreCase("edge")) {
			// driver = new EdgeDriver(optionsManager.getEdgeOptions());
			tlDriver.set(new EdgeDriver(optionsManager.getEdgeOptions()));
		} else
			System.out.println(" Please pass the correct browser Name");

		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		
		if (prop.getProperty("environment").equalsIgnoreCase("demo"))
			getDriver().get(Constants.DEMO_URL);
		return getDriver();
	}

	public WebDriver getDriver() {
		return tlDriver.get();
	}
	
	public void removeDriver()
	{
		tlDriver.remove();
		
	}

	public Properties initProperties() {
		Properties prop = null;
		try {
			FileInputStream ip = new FileInputStream("./src/test/resource/Config/config.properties");
			prop = new Properties();
			prop.load(ip);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
	}

	public String getScreenshot() {

		File srcfile = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir") + "/Screenshot/" + System.currentTimeMillis() + ".png";
		File destination = new File(path);
		try {
			FileHandler.copy(srcfile, destination);
			// FileUtils.copyDirectory(srcfile, destination);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Unable to Capture the Screenshots. " + e.getMessage());
		}

		return path;

	}

}
