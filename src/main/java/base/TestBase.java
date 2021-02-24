package base;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	public static WebDriver driver;
	
	public static void initializeDriver()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://techfios.com/billing/?ng=admin/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
}
	public void takeScreenshotAtEndOfTest() throws IOException
	{
		TakesScreenshot ts = ((TakesScreenshot)driver);
		SimpleDateFormat formatter = new SimpleDateFormat("MMddyy_HHmmss");
		Date date = new Date();
		String label =formatter.format(date);
		File souceFile = ts.getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		FileUtils.copyFile(souceFile, new File(currentDir + "/screenshot/"+label + ".png"));
	}
}
