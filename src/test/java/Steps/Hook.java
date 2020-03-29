package Steps;

import Base.BaseUtil;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static java.lang.Thread.sleep;

public class Hook {

    private BaseUtil base;

    public Hook(BaseUtil base) {
        this.base = base;
    }

    @Before
    public void InitializeTest(Scenario scenario) {
//
//        System.out.println("Opening the browser : Firefox");
//        System.setProperty("webdriver.firefox.marionette", "C:\\Libs\\geckodriver.exe");
//        base.driver = new FirefoxDriver();

        System.out.println("Opening the browser : Chrome");
        System.setProperty("webdriver.chrome.driver", "C:\\Libs\\chromedriver.exe");
        base.driver = new ChromeDriver();

    }

    @After
    public void TearDownTest(Scenario scenario) throws InterruptedException {
        System.out.println("Closing the browser : MOCK");
        sleep(4000);
        base.driver.close();
    }
}
