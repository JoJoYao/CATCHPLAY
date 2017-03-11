
/**
 * Created by jojoyao on 2016/12/2.
 */

import android.os.Build;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;


public class AllSettings {

    //Element_is_visible(id)
    public static boolean isDisplayid(AndroidDriver driver, String id) {
        try {
            driver.findElementById(id);
                System.out.println("ID "+id+" found");
                return true;

        } catch (NoSuchElementException e) {
            System.out.println("ID "+id+" not found");
            return false;
        }

    }

    //Element_is_visible(text)
    public static boolean isDisplayName(AndroidDriver driver, String id) {
        try {
             driver.findElementByXPath("//*[@text='"+id+"']");
                System.out.println("Text "+id+" found");
                return true;
        } catch (NoSuchElementException e) {
            System.out.println("Text "+id+" not found");
            return false;
        }
    }


    //ScreenShots
    public static void captureScreenShots(AndroidDriver driver, String FileName)
    {
        String DeviceID = driver.getSessionDetails().get("deviceName").toString();
        DateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
        String FolderName = df.format(new Date());

        File f = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        //create dir with given folder name
        new File(FolderName).mkdir();
        //Setting file name
        String file_name = DeviceID+"_"+FileName + ".png";
        //copy screenshot file into screenshot folder.
        try {
            FileUtils.copyFile(f, new File(FolderName + "/" + file_name));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //scroll to find Element in view
    public static boolean scrollToExactElement(AndroidDriver driver, String type, String str) {
        try {
            if (type.equals("text")) {
                driver.findElementByAndroidUIAutomator(
                        "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView" +
                                "(new UiSelector().text(\"" + str + "\").instance(0))");
            } else if (type.equals("id")) {
                driver.findElementByAndroidUIAutomator(
                        "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView" +
                                "(new UiSelector().resourceId(\"" + str + "\").instance(0))");
            }
            System.out.println("found "+type+" : " +str);
            return true ;
        } catch (NoSuchElementException e) {
            System.out.println("not found "+type+" : " +str);
            return false;
          }
    }

    //Swipe left-right
    public static void swipeLeft(AndroidDriver driver) {
        try {
            Thread.sleep(2000);
            driver.context("NATIVE_APP");
            Dimension size = driver.manage().window().getSize();
            int startx = (int) (size.width * 0.8);
            int endx = (int) (size.width * 0.20);
            int starty = size.height / 2;
            driver.swipe(startx, starty, endx, starty, 1000);
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //Swipe right-left
    public static void swipeRight(AndroidDriver driver) {
        try {
            Thread.sleep(2000);
            driver.context("NATIVE_APP");
            Dimension size = driver.manage().window().getSize();
            int endx = (int) (size.width * 0.8);
            int startx = (int) (size.width * 0.20);
            int starty = size.height / 2;
            driver.swipe(startx, starty, endx, starty, 1000);
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //Swipe from Bottom to Top.
    public static void scrollDown(AndroidDriver driver) {
        try {
            Thread.sleep(2000);
            driver.context("NATIVE_APP");
            Dimension size = driver.manage().window().getSize();
            int starty = (int) (size.height * 0.80);
            int endy = (int) (size.height * 0.20);
            int startx = size.width / 2;
            driver.swipe(startx, starty, startx, endy, 1000);
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //Swipe from Top to Bottom.
    public static void scrollUp(AndroidDriver driver) {
        try {
            Thread.sleep(2000);
            driver.context("NATIVE_APP");
            Dimension size = driver.manage().window().getSize();
            int starty = (int) (size.height * 0.80);
            int endy = (int) (size.height * 0.20);
            int startx = size.width / 2;
            driver.swipe(startx, endy, startx, starty, 1000);
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


