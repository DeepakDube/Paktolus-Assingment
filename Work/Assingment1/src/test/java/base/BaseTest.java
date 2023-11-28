package base;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	public static WebDriver driver;
	public static Properties prop = new Properties();
	public static Properties loc = new Properties();
	public static FileReader fr;
	public static FileReader fr1;

	@BeforeMethod
	public void setUp() throws IOException {

		if (driver == null) {
			 fr = new FileReader(System.getProperty("user.dir") + "\\src\\test\\resources\\configfiles\\config.properties");
			 fr1 = new FileReader(System.getProperty("user.dir") + "\\src\\test\\resources\\configfiles\\locators.properties");
			prop.load(fr);
			loc.load(fr1);
		}

		if (prop.getProperty("browser").equalsIgnoreCase("chrome")) {

			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			System.out.println("Browser launched successfully");
			driver.get(prop.getProperty("url"));
		} else if (prop.getProperty("browser").equalsIgnoreCase("firefox")) {

			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			System.out.println("Browser launched successfully");
			driver.get(prop.getProperty("url"));
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();

	}

	@AfterMethod
	public void tearDown() {
		driver.close();
		System.out.println("TearDown Successful");

	}
}
