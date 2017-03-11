import org.openqa.selenium.WebElement;
import org.openqa.selenium.mobile.NetworkConnection;

import java.util.List;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.android.Connection;

/**
 * Created by jojoyao on 2016/12/2.
 */

public class main_testing {
    //driver傳入就好, 不用再new一次

    public static boolean openwelcome(AndroidDriver driver) {
        boolean isShowLogin;
        boolean isShowSignup;
        boolean isShowDetail;

        ////determine button : login/signup/plandetail in welcome page////
        isShowLogin = AllSettings.isDisplayid(driver, resourceid.W_logIn);
        isShowSignup = AllSettings.isDisplayid(driver, resourceid.W_singUp);
        isShowDetail = AllSettings.isDisplayid(driver, resourceid.W_plandetails);
        /////////////////////////////////////////////////////////////////////////

        /////////swipe welcome page/////
        AllSettings.captureScreenShots(driver,"Welcome 1");
        AllSettings.swipeLeft(driver);
        AllSettings.captureScreenShots(driver,"Welcome 2");
        AllSettings.swipeLeft(driver);
        AllSettings.captureScreenShots(driver,"Welcome 3");

        AllSettings.swipeRight(driver);
        AllSettings.swipeRight(driver);
        /////////////////////////////////

        if (isShowLogin == true && isShowSignup == true && isShowDetail == true) {
            return true;
        }
        return false;
    }

    public static boolean doLogin_movielover(AndroidDriver driver) {
        //driver.findElementById(resourceid.W_logIn).isDisplayed();
        boolean isShowSingleRental;
        boolean isShowMovileLoverUm;
        boolean isShowMovieLover_text;
        driver.findElementById(resourceid.W_logIn).click();
        driver.findElementById(resourceid.M_Num).click();
        driver.findElementById(resourceid.login_Phone).sendKeys(resourceid.movie_lover_num_text);
        driver.findElementById(resourceid.login_ps).sendKeys(resourceid.movie_lover_ps_text);
        driver.findElementById(resourceid.login_next).click();

        //handle management device
        if(AllSettings.isDisplayid(driver,resourceid.DM_Device1Logout)){
            driver.findElementById(resourceid.DM_Device1Logout).click();
            driver.findElementById(resourceid.DM_DialogLogout).click();
            driver.findElementById(resourceid.DM_Done).click();
        }

        isShowMovieLover_text = AllSettings.isDisplayName(driver,resourceid.MovieLover_text);
        driver.pressKeyCode(4);

        if(AllSettings.isDisplayid(driver,resourceid.ShowCast_ok_btn)) {
            driver.findElementById(resourceid.ShowCast_ok_btn).click();
        }
        isShowSingleRental = AllSettings.scrollToExactElement(driver,"id",resourceid.singlerental_text);

        isShowMovileLoverUm =AllSettings.scrollToExactElement(driver,"id",resourceid.movielover_text);

        AllSettings.scrollUp(driver);
        AllSettings.scrollUp(driver);

        if (isShowSingleRental == true && isShowMovileLoverUm == true ) {
            return true;
        }

        return false;
    }

    public static boolean doLogin_guest(AndroidDriver driver){
        boolean result = true;
        boolean isShowSignup;
        boolean isShowLogin;
        //click skip on wellcome
        driver.findElementById(resourceid.W_skip).click();
        //click skip when intro pop up show up(need check because not always show)
        if(AllSettings.isDisplayid(driver,resourceid.PW_skip)) {
            driver.findElementById(resourceid.PW_skip).click();
        }
        //click ok when chromecast dialog show up(need check because not always show)
        if(AllSettings.isDisplayid(driver,resourceid.ShowCast_ok_btn)) {
            driver.findElementById(resourceid.ShowCast_ok_btn).click();
        }
        //clcik avatar icon to make sure guest
        driver.findElementById(resourceid.UserAvatar_btn).click();
        isShowSignup = AllSettings.isDisplayid(driver,resourceid.H_signup);
        isShowLogin = AllSettings.isDisplayid(driver,resourceid.H_login);
        driver.pressKeyCode(AndroidKeyCode.BACK);

        if (isShowSignup == false && isShowLogin == false) {
            return false;
        }

        return result;
    }

    public static boolean dologin_moviefan(AndroidDriver driver) {
        driver.findElementById(resourceid.W_logIn).click();
        driver.findElementById(resourceid.M_Num).click();
        driver.findElementById(resourceid.login_Phone).sendKeys(resourceid.movie_fan_num_text);
        driver.findElementById(resourceid.login_ps).sendKeys(resourceid.movie_fan_ps_text);
        driver.findElementById(resourceid.login_next).click();

        //handle management device
        if(AllSettings.isDisplayid(driver,resourceid.DM_Device1Logout)){
            driver.findElementById(resourceid.DM_Device1Logout).click();
            driver.findElementById(resourceid.DM_DialogLogout).click();
            driver.findElementById(resourceid.DM_Done).click();
        }

        driver.pressKeyCode(4);
        if(AllSettings.isDisplayid(driver,resourceid.ShowCast_ok_btn)) {
            driver.findElementById(resourceid.ShowCast_ok_btn).click();
        }

        boolean isShowSingleRental;
        boolean isShowOnTheHouse;
        isShowSingleRental = AllSettings.isDisplayid(driver, resourceid.singlerental_text);
        isShowOnTheHouse = AllSettings.isDisplayid(driver, resourceid.onthehouse_text);

        AllSettings.scrollUp(driver);
        AllSettings.scrollUp(driver);

        if (isShowSingleRental == true && isShowOnTheHouse == true) {
            return true;
        }
        return false;
    }

    public static boolean doFBLogin_moviefan(AndroidDriver driver) {
        driver.findElementById(resourceid.W_logIn).click();
        driver.findElementById(resourceid.FB).click();
        driver.pressKeyCode(4);
        driver.findElementById(resourceid.ShowCast_ok_btn).click();

        boolean isShowSingleRental;
        boolean isShowOnTheHouse;
        isShowSingleRental = AllSettings.isDisplayid(driver, resourceid.singlerental_text);
        isShowOnTheHouse = AllSettings.isDisplayid(driver, resourceid.onthehouse_text);

        AllSettings.scrollUp(driver);
        AllSettings.scrollUp(driver);

        if (isShowSingleRental == true && isShowOnTheHouse == true) {
            return true;
        }
        return false;
    }

    public static boolean doLogout(AndroidDriver driver) {
        driver.findElementById(resourceid.UserAvatar_btn).click();
        driver.findElementById(resourceid.Myaccount_btn).click();
        AllSettings.scrollToExactElement(driver,"id",resourceid.Logout_btn);
        driver.findElementById(resourceid.Logout_btn).click();
        driver.findElementById(resourceid.logout_yes_btn).click();
        driver.findElementById(resourceid.UserAvatar_btn).click();

        boolean isShowSignup;
        boolean isShowLogin;
        isShowSignup = AllSettings.isDisplayid(driver,resourceid.H_signup);
        isShowLogin = AllSettings.isDisplayid(driver,resourceid.H_login);
        driver.pressKeyCode(4);

        AllSettings.scrollUp(driver);
        AllSettings.scrollUp(driver);

        if (isShowSignup == true && isShowLogin == true) {
            return true;
        }
        return false;

    }

    public static boolean DoShareViaFBTesting(AndroidDriver driver)
    {
        boolean result=false;

        //clcik item page on hot pick
        driver.findElementById(resourceid.H_hotpick).click();

        //click button share on item page
        driver.findElementById(resourceid.I_share).click();

        //find facebook text and click
        AllSettings.scrollDown(driver);//need for show full listbox of list share app
        driver.findElementByAndroidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView" +
                        "(new UiSelector().text(\"Facebook\").instance(0))").click();

        //check facebook share page is show?
        result = AllSettings.isDisplayid(driver,resourceid.I_FacebookSharePage);

        //back to home
        driver.pressKeyCode(AndroidKeyCode.BACK);

        driver.pressKeyCode(AndroidKeyCode.BACK);

        driver.findElementById(resourceid.I_FacebookDisard).click();//click discard

        driver.pressKeyCode(AndroidKeyCode.BACK);
        /////////////////////////////////////////////

        return result;
    }

    public static boolean DoGenreTesting(AndroidDriver driver)
    {
        boolean result=true;

        //click genre on Tab
        driver.findElementById(resourceid.Tabgenres_btn).click();

        ////////////////////////clcik every genre and check it/////////
        if(AllSettings.scrollToExactElement(driver,"text",resourceid.G_action)) {
            driver.findElementByXPath("//*[@text='"+resourceid.G_action+"']").click();
            if(AllSettings.isDisplayid(driver,resourceid.G_subgenreListView)) {
                driver.pressKeyCode(AndroidKeyCode.BACK);
            } else {
                return false;
            }
        } else {
            return false;
        }

        if(AllSettings.scrollToExactElement(driver,"text",resourceid.G_sport))  {
            driver.findElementByXPath("//*[@text='"+resourceid.G_sport+"']").click();
            if(AllSettings.isDisplayid(driver,resourceid.G_subgenreListView)) {
                driver.pressKeyCode(AndroidKeyCode.BACK);
            } else {
                return false;
            }
        } else {
            return false;
        }

        if(AllSettings.scrollToExactElement(driver,"text",resourceid.G_drama)) {
            driver.findElementByXPath("//*[@text='"+resourceid.G_drama+"']").click();
            if(AllSettings.isDisplayid(driver,resourceid.G_subgenreListView)) {
                driver.pressKeyCode(AndroidKeyCode.BACK);
            } else {
                return false;
            }
        } else {
            return false;
        }

        if(AllSettings.scrollToExactElement(driver,"text",resourceid.G_biography)) {
            driver.findElementByXPath("//*[@text='"+resourceid.G_biography+"']").click();
            if(AllSettings.isDisplayid(driver,resourceid.G_subgenreListView)) {
                driver.pressKeyCode(AndroidKeyCode.BACK);
            } else {
                return false;
            }
        } else {
            return false;
        }

        if(AllSettings.scrollToExactElement(driver,"text",resourceid.G_documentary)) {
            driver.findElementByXPath("//*[@text='"+resourceid.G_documentary+"']").click();
            if(AllSettings.isDisplayid(driver,resourceid.G_subgenreListView)) {
                driver.pressKeyCode(AndroidKeyCode.BACK);
            } else {
                return false;
            }
        } else {
            return false;
        }

        if(AllSettings.scrollToExactElement(driver,"text",resourceid.G_disaster)) {
            driver.findElementByXPath("//*[@text='"+resourceid.G_disaster+"']").click();
            if(AllSettings.isDisplayid(driver,resourceid.G_subgenreListView)) {
                driver.pressKeyCode(AndroidKeyCode.BACK);
            } else {
                return false;
            }
        } else {
            return false;
        }

        if(AllSettings.scrollToExactElement(driver,"text",resourceid.G_war)) {
            driver.findElementByXPath("//*[@text='"+resourceid.G_war+"']").click();
            if(AllSettings.isDisplayid(driver,resourceid.G_subgenreListView)) {
                driver.pressKeyCode(AndroidKeyCode.BACK);
            } else {
                return false;
            }
        } else {
            return false;
        }

        if(AllSettings.scrollToExactElement(driver,"text",resourceid.G_period)) {
            driver.findElementByXPath("//*[@text='"+resourceid.G_period+"']").click();
            if(AllSettings.isDisplayid(driver,resourceid.G_subgenreListView)) {
                driver.pressKeyCode(AndroidKeyCode.BACK);
            } else {
                return false;
            }
        } else {
            return false;
        }

        if(AllSettings.scrollToExactElement(driver,"text",resourceid.G_scifi)) {
            driver.findElementByXPath("//*[@text='"+resourceid.G_scifi+"']").click();
            if(AllSettings.isDisplayid(driver,resourceid.G_subgenreListView)) {
                driver.pressKeyCode(AndroidKeyCode.BACK);
            } else {
                return false;
            }
        } else {
            return false;
        }

        if(AllSettings.scrollToExactElement(driver,"text",resourceid.G_comedy)) {
            driver.findElementByXPath("//*[@text='"+resourceid.G_comedy+"']").click();
            if(AllSettings.isDisplayid(driver,resourceid.G_subgenreListView)) {
                driver.pressKeyCode(AndroidKeyCode.BACK);
            } else {
                return false;
            }
        } else {
            return false;
        }

        if(AllSettings.scrollToExactElement(driver,"text",resourceid.G_animation)) {
            driver.findElementByXPath("//*[@text='"+resourceid.G_animation+"']").click();
            if(AllSettings.isDisplayid(driver,resourceid.G_subgenreListView)) {
                driver.pressKeyCode(AndroidKeyCode.BACK);
            } else {
                return false;
            }
        } else {
            return false;
        }

        if(AllSettings.scrollToExactElement(driver,"text",resourceid.G_kids)) {
            driver.findElementByXPath("//*[@text='"+resourceid.G_kids+"']").click();
            if(AllSettings.isDisplayid(driver,resourceid.G_subgenreListView)) {
                driver.pressKeyCode(AndroidKeyCode.BACK);
            } else {
                return false;
            }
        } else {
            return false;
        }

        if(AllSettings.scrollToExactElement(driver,"text",resourceid.G_romance)) {
            driver.findElementByXPath("//*[@text='"+resourceid.G_romance+"']").click();
            if(AllSettings.isDisplayid(driver,resourceid.G_subgenreListView)) {
                driver.pressKeyCode(AndroidKeyCode.BACK);
            } else {
                return false;
            }
        } else {
            return false;
        }

        if(AllSettings.scrollToExactElement(driver,"text",resourceid.G_musical)) {
            driver.findElementByXPath("//*[@text='"+resourceid.G_musical+"']").click();
            if(AllSettings.isDisplayid(driver,resourceid.G_subgenreListView)) {
                driver.pressKeyCode(AndroidKeyCode.BACK);
            } else {
                return false;
            }
        } else {
            return false;
        }

        if(AllSettings.scrollToExactElement(driver,"text",resourceid.G_horror)) {
            driver.findElementByXPath("//*[@text='"+resourceid.G_horror+"']").click();
            if(AllSettings.isDisplayid(driver,resourceid.G_subgenreListView)) {
                driver.pressKeyCode(AndroidKeyCode.BACK);
            } else {
                return false;
            }
        } else {
            return false;
        }

        if(AllSettings.scrollToExactElement(driver,"text",resourceid.G_thriller)) {
            driver.findElementByXPath("//*[@text='"+resourceid.G_thriller+"']").click();
            if(AllSettings.isDisplayid(driver,resourceid.G_subgenreListView)) {
                driver.pressKeyCode(AndroidKeyCode.BACK);
            } else {
                return false;
            }
        } else {
            return false;
        }

        if(AllSettings.scrollToExactElement(driver,"text",resourceid.G_crime)) {
            driver.findElementByXPath("//*[@text='"+resourceid.G_crime+"']").click();
            if(AllSettings.isDisplayid(driver,resourceid.G_subgenreListView)) {
                driver.pressKeyCode(AndroidKeyCode.BACK);
            } else {
                return false;
            }
        } else {
            return false;
        }

        if(AllSettings.scrollToExactElement(driver,"text",resourceid.G_digital)) {
            driver.findElementByXPath("//*[@text='"+resourceid.G_digital+"']").click();
            if(AllSettings.isDisplayid(driver,resourceid.G_subgenreListView)) {
                driver.pressKeyCode(AndroidKeyCode.BACK);
            } else {
                return false;
            }
        } else {
            return false;
        }

        if(AllSettings.scrollToExactElement(driver,"text",resourceid.G_language)) {
            driver.findElementByXPath("//*[@text='"+resourceid.G_language+"']").click();
            if(AllSettings.isDisplayid(driver,resourceid.G_subgenreListView)) {
                driver.pressKeyCode(AndroidKeyCode.BACK);
            } else {
                return false;
            }
        } else {
            return false;
        }
        /////////////////////////////////////////////////////////

        ///////////////////check subgenre////////
        if(AllSettings.scrollToExactElement(driver,"text",resourceid.G_action)){
            driver.findElementByXPath("//*[@text='"+resourceid.G_action+"']").click();
            if(AllSettings.isDisplayName(driver, resourceid.G_subgenreText1)){
                driver.findElementByXPath("//*[@text='" + resourceid.G_subgenreText1 + "']").click();
                result = AllSettings.isDisplayid(driver, resourceid.G_subgenreListView);
            } else {
                return false;
            }
        } else {
            return false;
        }
        ///////////////////////////

        //back to home
        driver.findElementById(resourceid.Tabgenres_btn).click();
        driver.findElementById(resourceid.Tabhome_btn).click();
        /////////////////////////////

        return result;
    }

    public static boolean DoAddToMyListTestingAsMember(AndroidDriver driver)
    {
        boolean result=true;
        String TitleMovie,HintDialog;

        //clcik item page on hot pick
        driver.findElementById(resourceid.H_hotpick).click();
        TitleMovie = driver.findElementById(resourceid.I_Title).getText().toString();

        //check add to my list feature
        driver.findElementById(resourceid.I_AddToMyList).click();
        HintDialog = driver.findElementById(resourceid.I_HintDialog).getText();
        if(HintDialog.equals("Added to 'My List'") || HintDialog.equals("Removed"))
        {
            if(HintDialog.equals("Added to 'My List'")) {
                //check on My list
                driver.findElementById(resourceid.Tabmylist_btn).click();
                List <WebElement> ListMovieDrawer = driver.findElementsByXPath("//android.support.v7.widget.RecyclerView[@resource-id='"+resourceid.M_MyMovieDrawerList+"']/android.widget.LinearLayout");
                ListMovieDrawer.get(0).click();
                if(!driver.findElementById(resourceid.I_Title).getText().toString().equals(TitleMovie)) {
                    System.out.println("Item Page Error : Added item to my list not show on My Drawer");
                    return false;
                }
                driver.findElementById(resourceid.Tabmylist_btn).click();
                driver.findElementById(resourceid.Tabhome_btn).click();
            }
        }
        else
        {
            System.out.println("Item Page Error : Dialog add to my list Text not correct");
            return false;
        }

        driver.findElementById(resourceid.I_AddToMyList).click();
        HintDialog = driver.findElementById(resourceid.I_HintDialog).getText();
        if(HintDialog.equals("Added to 'My List'") || HintDialog.equals("Removed"))
        {
            if(HintDialog.equals("Added to 'My List'")) {
                //check on My list
                driver.findElementById(resourceid.Tabmylist_btn).click();
                List <WebElement> ListMovieDrawer = driver.findElementsByXPath("//android.support.v7.widget.RecyclerView[@resource-id='"+resourceid.M_MyMovieDrawerList+"']/android.widget.LinearLayout");
                ListMovieDrawer.get(0).click();
                if(!driver.findElementById(resourceid.I_Title).getText().toString().equals(TitleMovie)) {
                    System.out.println("Item Page Error : Added item to my list not show on My Drawer");
                    return false;
                }
                driver.findElementById(resourceid.Tabmylist_btn).click();
                driver.findElementById(resourceid.Tabhome_btn).click();
            }
        }
        else
        {
            System.out.println("Item Page Error : Dialog add to my list Text not correct");
            return false;
        }


        return result;
    }

    public static boolean DoRatingTestingAsMember(AndroidDriver driver)
    {
        boolean result=true;

        //check rating feature
        driver.findElementById(resourceid.I_Rate).click();
        driver.findElementById(resourceid.I_Star1).click();
        driver.findElementById(resourceid.I_SaveRate).click();
        if(!driver.findElementById(resourceid.I_ScoreMyRate).getText().toString().equals("1"))
        {
            System.out.println("Item Page Error : Rate 1 not success");
            return false;
        }

        driver.findElementById(resourceid.I_Rate).click();
        driver.findElementById(resourceid.I_Star2).click();
        driver.findElementById(resourceid.I_SaveRate).click();
        if(!driver.findElementById(resourceid.I_ScoreMyRate).getText().toString().equals("2"))
        {
            System.out.println("Item Page Error : Rate 2 not success");
            return false;
        }

        driver.findElementById(resourceid.I_Rate).click();
        driver.findElementById(resourceid.I_Star3).click();
        driver.findElementById(resourceid.I_SaveRate).click();
        if(!driver.findElementById(resourceid.I_ScoreMyRate).getText().toString().equals("3"))
        {
            System.out.println("Item Page Error : Rate 3 not success");
            return false;
        }

        driver.findElementById(resourceid.I_Rate).click();
        driver.findElementById(resourceid.I_Star4).click();
        driver.findElementById(resourceid.I_SaveRate).click();
        if(!driver.findElementById(resourceid.I_ScoreMyRate).getText().toString().equals("4"))
        {
            System.out.println("Item Page Error : Rate 4 not success");
            return false;
        }

        driver.findElementById(resourceid.I_Rate).click();
        driver.findElementById(resourceid.I_Star5).click();
        driver.findElementById(resourceid.I_SaveRate).click();
        if(!driver.findElementById(resourceid.I_ScoreMyRate).getText().toString().equals("5"))
        {
            System.out.println("Item Page Error : Rate 5 not success");
            return false;
        }

        //check cancel rate button
        driver.findElementById(resourceid.I_Rate).click();
        driver.findElementById(resourceid.I_Star1).click();
        driver.findElementById(resourceid.I_CancelRate).click();
        if(!driver.findElementById(resourceid.I_ScoreMyRate).getText().toString().equals("5"))
        {
            System.out.println("Item Page Error : Button cancel Rate not success");
            return false;
        }

        //check reset rate button
        driver.findElementById(resourceid.I_Rate).click();
        driver.findElementById(resourceid.I_Star5).click();
        driver.findElementById(resourceid.I_SaveRate).click();
        if(!driver.findElementById(resourceid.I_ScoreMyRate).getText().toString().equals(""))
        {
            System.out.println("Item Page Error : Reset Rate not success");
            return false;
        }

        return result;
    }

    public static boolean DoAddToMyListTestingAsGuest(AndroidDriver driver)
    {
        boolean result = true;
        boolean isShowSignup;
        boolean isShowLogin;

        //clcik item page on hot pick
        driver.findElementById(resourceid.H_hotpick).click();

        //click add to my list
        driver.findElementByAndroidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView" +
                        "(new UiSelector().resourceId(\"" + resourceid.I_AddToMyList + "\").instance(0))").click();
        isShowSignup = AllSettings.isDisplayid(driver,resourceid.H_signup);
        isShowLogin = AllSettings.isDisplayid(driver,resourceid.H_login);
        if (isShowSignup == false && isShowLogin == false) {
            System.out.println("Item Page Error : Add my list work when not login");
            return false;
        }
        else {
            driver.pressKeyCode(AndroidKeyCode.BACK);
        }

        return result;
    }

    public static boolean DoRatingTestingAsGuest(AndroidDriver driver)
    {
        boolean result = true;
        boolean isShowSignup;
        boolean isShowLogin;

        //click rate
        driver.findElementByAndroidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView" +
                        "(new UiSelector().resourceId(\"" + resourceid.I_Rate + "\").instance(0))").click();
        isShowSignup = AllSettings.isDisplayid(driver,resourceid.H_signup);
        isShowLogin = AllSettings.isDisplayid(driver,resourceid.H_login);
        if (isShowSignup == false && isShowLogin == false) {
            System.out.println("Item Page Error : Rate work when not login");
            return false;
        }
        else{
            driver.pressKeyCode(AndroidKeyCode.BACK);
        }

        return result;
    }

    public static boolean DoCastAndCrewTesting(AndroidDriver driver)
    {
        boolean result = true;
        //click Cast & Crew
        driver.findElementByAndroidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView" +
                        "(new UiSelector().resourceId(\"" + resourceid.I_CastAndCrew + "\").instance(0))");
        List<WebElement> ListCastAndCrew = driver.findElementsByXPath("//android.support.v7.widget.RecyclerView[@resource-id='"+resourceid.I_CastAndCrew+"']/android.widget.RelativeLayout");
        for(int i=0;i<ListCastAndCrew.size();i++)
        {
            ListCastAndCrew.get(i).click();
            if(AllSettings.isDisplayid(driver,resourceid.I_ListItemCastAndCrew)==false)
            {
                System.out.println("Item Page Error : Cast and crew fail");
                return false;
            }
            driver.pressKeyCode(AndroidKeyCode.BACK);
        }

        return result;
    }

    public static boolean DoStillsTetsting(AndroidDriver driver)
    {
        boolean result = true;

        //click Stills
        driver.findElementByAndroidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView" +
                        "(new UiSelector().resourceId(\"" + resourceid.I_Stills + "\").instance(0))");
        List<WebElement> ListStills = driver.findElementsByXPath("//android.support.v7.widget.RecyclerView[@resource-id='"+resourceid.I_Stills+"']/android.widget.LinearLayout");
        for(int i=0;i<ListStills.size();i++)
        {
            ListStills.get(i).click();
            if(AllSettings.isDisplayid(driver,resourceid.I_ImageStills)==false)
            {
                System.out.println("Item Page Error : Stills fail");
                return false;
            }
            driver.pressKeyCode(AndroidKeyCode.BACK);
        }

        //back to home
        driver.findElementById(resourceid.Tabhome_btn).click();

        return result;
    }

    public static boolean DoChangeProfile(AndroidDriver driver)
    {
        boolean result = true;
        //click avatar icon to open greeting page
        driver.findElementById(resourceid.UserAvatar_btn).click();
        //click my account button
        driver.findElementById(resourceid.Myaccount_btn).click();
        //clcik my profile button
        driver.findElementById(resourceid.AccProfileBtn).click();
        //get data(nickname, gender, and email)
        String nickname = driver.findElementById(resourceid.PrNickNameText).getText().toString();
        String gender = driver.findElementById(resourceid.PrGenderText).getText().toString();
        String email = driver.findElementById(resourceid.PrEmailText).getText().toString();
        //take a screenshoot
        AllSettings.captureScreenShots(driver,"Profile Data Before Changed");
        //click edit button
        driver.findElementById(resourceid.PrEditBtn).click();
        //edit nickname
        driver.findElementById(resourceid.EpNickNameEditText).sendKeys("test");
        //click save button
        driver.findElementById(resourceid.EpSaveButton).click();
        //check data nickname
        if(!driver.findElementById(resourceid.PrNickNameText).getText().toString().equals(nickname+"test"))
        {
            System.out.println("Nickname changed not success");
            return false;
        }
        //take a screenshoot
        AllSettings.captureScreenShots(driver,"Profile Change Nickname");
        //click edit button
        driver.findElementById(resourceid.PrEditBtn).click();
        //edit gender
        driver.findElementById(resourceid.EpGenderButton).click();
        if(gender.equals("male")) {
            driver.findElementByXPath("//*[@text='female']").click();
        } else {
            driver.findElementByXPath("//*[@text='male']").click();
        }
        //click save button
        driver.findElementById(resourceid.EpSaveButton).click();
        //check data gender
        if(driver.findElementById(resourceid.PrGenderText).getText().toString().equals(gender))
        {
            System.out.println("Gender changed not success");
            return false;
        }
        //take a screenshoot
        AllSettings.captureScreenShots(driver,"Profile Change Gender");
        //back to home
        driver.pressKeyCode(AndroidKeyCode.BACK);
        driver.pressKeyCode(AndroidKeyCode.BACK);
        driver.pressKeyCode(AndroidKeyCode.BACK);
        return result;
    }

    public static boolean DoOfflineChecking(AndroidDriver driver)
    {
        boolean result = true;

        driver.setConnection(Connection.AIRPLANE);
        if(!AllSettings.isDisplayid(driver,resourceid.OfflineErrorTextView)){
            return false;
        }
        AllSettings.captureScreenShots(driver,"No Network Show Error");
        driver.setConnection(Connection.WIFI);

        return result;
    }

    public static boolean DoPlayTraillerAndPreviewAsMember(AndroidDriver driver)
    {
        boolean result=true;

        return result;
    }

    public static boolean DoPlayTraillerAndPreviewAsGuest(AndroidDriver driver)
    {
        boolean result=true;

        return result;
    }

    public static boolean memorytest (AndroidDriver driver)
    {
        boolean result = true;
        driver.findElementById(resourceid.H_hotpick).click();
        driver.pressKeyCode(AndroidKeyCode.BACK);
        return result;
    }
}