/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smartassistant.automation;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class WebDriverFactory {

	private static String browser;

	
	/**
	 * Getting browser preference
	 */
	public WebDriver getDriver(Map<String, String> seleniumconfig) {
		browser = seleniumconfig.get("browser");
		if (browser.equalsIgnoreCase("firefox")) {
			return new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("chrome")) {
			return getChromeDriver(seleniumconfig.get("driverpath"));
		}

		return new FirefoxDriver();
	}

	/**
	 * Setting chromedriver properties
	 */
	private static WebDriver getChromeDriver(String driverpath) {
		System.setProperty("webdriver.chrome.driver", driverpath);
		ChromeOptions options = new ChromeOptions();
		options.addArguments("disable-popup-blocking", "true");
		options.addArguments("--disable-extensions");
		options.addArguments("ignore-certificate-errors");
		options.addArguments("allow-running-insecure-content");
		DesiredCapabilities cap = DesiredCapabilities.chrome();
		cap.setCapability(ChromeOptions.CAPABILITY, options);
		return new ChromeDriver(cap);
	}

}
