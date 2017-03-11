/**
 * Created by jojoyao on 2016/12/2.
 */

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.android.AndroidDriver;

public class AutoTest {

    //初始化AppiumDriver
    private AndroidDriver driver;

    @Before
    public void setUp() throws Exception {

        // 設定App路徑
        //File classpathRoot = new File(System.getProperty("user.air"));
        //File app = new File("/Users/jojoyao/Downloads/catchplay-debug-1.1.15-511_original.apk");
        System.out.println("設置路徑完成");

        //設置自動化相關參數
        DesiredCapabilities cap = new DesiredCapabilities();
        //cap.setCapability("appium-version", "1.5.3");
        //cap.setCapability("platformVersion", "4.4.2");
        //cap.setCapability("platformName", "Androiad");
        cap.setCapability("deviceName", "Nexus 6P");
        System.out.println("設置測試裝置參數完成");

        //设置apk路径
        //cap.setCapability("app",app.getAbsolutePath());
        //如果测试的是AndroidApp的话,需要设置app的package_name & mainActivity-------iOS可以省略
        //cap.setCapability("appPackage", "com.catchplay.asiaplay");
        //cap.setCapability("appActivity", "com.catchplay.asiaplay.MainActivity");
        System.out.println("Apk Load Success");

        //初始化 AppiumDriver
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);

        //設置等待秒數
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println("初始化 AppiumDriver");
    }

    @After
    public void tearDown() throws Exception{

        //driver.wait(60000);
        driver.quit();
        //System.out.println("測試结束!!!!!!!");
        //System.out.println("即将執行NextSession");
    }

    @Test
    public void allTests() {
        System.out.println("Testing Start");
        //設true第一個判斷式才會做
        boolean pass = true;

        if (pass) {
            pass = main_testing.openwelcome(driver);
            System.out.println("Welcome_Page : " + pass);
        }

        if (pass) {
            pass = main_testing.doLogin_movielover(driver);
            System.out.println("Login Movie Lover : " + pass);
        }
        
        if(pass)
        {
            pass = main_testing.DoShareViaFBTesting(driver);
            System.out.println("Share via FB : " + pass);
        }

        if(pass)
        {
            pass = main_testing.DoGenreTesting(driver);
            System.out.println("Genre Testing : " + pass);
        }

        if(pass)
        {
            pass = main_testing.DoAddToMyListTestingAsMember(driver);
            System.out.println("Add to My List Testing As Member : " + pass);
        }

        if(pass)
        {
            pass = main_testing.DoRatingTestingAsMember(driver);
            System.out.println("Rating Testing As Member : " + pass);
        }

        if(pass)
        {
            pass = main_testing.DoCastAndCrewTesting(driver);
            System.out.println("Cast & Crew Testing : " + pass);
        }

        if(pass)
        {
            pass = main_testing.DoStillsTetsting(driver);
            System.out.println("Stills Testing : " + pass);
        }

        if(pass)
        {
            pass = main_testing.DoChangeProfile(driver);
            System.out.println("Change Profile : " + pass);
        }

        if (pass) {
            pass = main_testing.doLogout(driver);
            System.out.println("LogOut : " + pass);
        }

        if (pass)
        {
            pass = main_testing.DoOfflineChecking(driver);
            System.out.println("Offline Checking : " + pass);
        }

        if(pass)
        {
            pass = main_testing.DoAddToMyListTestingAsGuest(driver);
            System.out.println("Add to My List Testing As Guest : " + pass);
        }

        if(pass)
        {
            pass = main_testing.DoRatingTestingAsGuest(driver);
            System.out.println("Rating Testing As Guest : " + pass);
        }

        if(pass)
        {
            pass = main_testing.DoCastAndCrewTesting(driver);
            System.out.println("Cast & Crew Testing : " + pass);
        }

        if(pass)
        {
            pass = main_testing.DoStillsTetsting(driver);
            System.out.println("Stills Testing : " + pass);
        }

        System.out.println("Testing End");
    }

}