package com.puma.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.FindBy;

import com.puma.qa.util.TestUtil;

public class base {
	
	public static WebDriver driver;
	public static Properties prop;
	
			public base()  {
				
				try {
						prop = new Properties();
						FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+"/src/main/java/com/puma/qa/config/config.properties");
						prop.load(ip);
					
					} catch (FileNotFoundException e) {
						
						e.printStackTrace();
					}catch (IOException e) {
						
						e.printStackTrace();
					}
				
			}
		public void initialization() {
			
			String browserName=prop.getProperty("browser");
			
			
			if(browserName.equals("FF")) {
				System.setProperty("webdriver.gecko.driver", "/Users/vandanayadav/geckodriver");
				FirefoxProfile ffprofile = new FirefoxProfile();
				ffprofile.setPreference("dom.webnotifications.enabled", false);
				driver = new FirefoxDriver(ffprofile); 
				
			}
			else if(browserName.equals("Chrome")) {
				
				System.setProperty("webdriver.chrome.driver", "/Users/vandanayadav/chromedriver/chromedriver");
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--disable-notifications");
				driver = new ChromeDriver(options);
				
				}
			else if (browserName.equalsIgnoreCase("ie")) { 
			 	  System.setProperty("webdriver.ie.driver", "drivers\\IEDriverServer.exe");
			 	  
			 	  DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();    
			 	  capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
			 	  driver = new InternetExplorerDriver(capabilities);
			  }
			  
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
			driver.get(prop.getProperty("url"));
			
			driver.switchTo().frame(driver.findElement(By.cssSelector("iframe.__st_preview_frame_bpn")));
					
			driver.findElement(By.cssSelector("input#__st_bpn_yes")).click();
			
			

			
		}

}
