package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {
	static WebDriver driver;
	static String browser;
	static String url;

	public static void readconfig() {

		// BufferedReader //InputStream //FileReader // Scanner      // helps to read any type of file

		// if we were reading an excel file then we would have created a excel object instead of properties object.
		// if reading a text file, then create a text file object.

		Properties prop = new Properties();                          // for java to understand the file system

		try {

			InputStream input = new FileInputStream("src\\main\\java\\config\\config.properties");
			prop.load(input);
			browser = prop.getProperty("browser");
			System.out.println("Browser used: " + browser);
			url = prop.getProperty("url");

		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	public static WebDriver init() {
		readconfig();
		if (browser.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "driver\\chromedriver_91.exe");
			driver = new ChromeDriver();
		} // else {
//			System.setProperty("webdriver.gecko.driver", "drivers\\geckodriver.exe");
//			driver = new FirefoxDriver();
//		}
		else if (browser.equalsIgnoreCase("Firefox")) {
			System.setProperty("webdriver.gecko.driver", "drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		driver.get(url);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;

	}

	public static void teardown() {

		driver.close();
		driver.quit();

	}

}
