package automation.utils;

public class Constants {
    final static String CHROME_DRIVER_WINDOWS_DIR = "src/webDriverExecutables/chrome/chromedriver.exe";
    final static String CHROME_DRIVER_SYSTEM_PROPERTY = "webdriver.chrome.driver";
    final static String BUNNINGS_URL = "https://www.bunnings.com.au/";
    final static String CHROME_DRIVER_MAC_DIR = "src/webDriverExecutables/chrome/chromedriver";

    public String getDriverDirectoryWindows()
    {
        return CHROME_DRIVER_WINDOWS_DIR;
    }

    public String getDriverDirectoryMac()
    {
        return CHROME_DRIVER_WINDOWS_DIR;
    }

    public String getSystemProperty()
    {
        return CHROME_DRIVER_SYSTEM_PROPERTY;
    }

    public String getBunningsUrl(){
        return BUNNINGS_URL;
    }
}
