package Playwright;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class PlaywrightBasic {


//Resuable experiment(line 11 to 20)
//    public void browserType(Boolean name){
//        BrowserType browserType= (BrowserType) new BrowserType.LaunchOptions().setHeadless(name);
//        return;
//    }

//    public void url(String urlName){
//        Page page=browser.newPage();
//        page.navigate(urlName);
//    }

    public static void main(String[]args){

        //used to open server
       Playwright playwright = Playwright.create();

       //It will start open in the chrome browser
       BrowserType.LaunchOptions lp =new BrowserType.LaunchOptions();
       lp.setChannel("chrome");
       lp.setHeadless(false);
       Browser browser = playwright.chromium().launch(lp);


        //It will open in the chrominum browser
       //Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

//Resuable experiment(line 26 to 29)
//        PlaywrightBasic py=new PlaywrightBasic();
//        py.url("https://www.flipkart.com/");
//        py.browserType(false);


       Page page=browser.newPage();
       page.navigate("https://www.flipkart.com/");
       // It is used to pause were we want and start debug and record and create new code also
       page.pause();
       String string=page.title();
       System.out.println(string);
       browser.close();
       playwright.close();

    }
}
