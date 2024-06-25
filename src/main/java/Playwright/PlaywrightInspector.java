package Playwright;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.AriaRole;

public class PlaywrightInspector {

    public static void main(String[]args) {

        /*
        In cmd prompt using this step to create your project dir
        C:\Users\ak3282976>cd C:\Users\ak3282976\IdeaProjects\BasicTask
        C:\Users\ak3282976\IdeaProjects\BasicTask>dir
        C:\Users\ak3282976\IdeaProjects\BasicTask>
        */

        /*
        Type1:
        record and generate code using below command
        open cmd prompt of your project dir and paste below command and your url
        mvn exec:java -e -Dexec.mainClass=com.microsoft.playwright.CLI -Dexec.args="codegen https:wikipedia.org"
        */

        /*
        Type2: PWDEBUG=1
        if we want debug step by step
        1.Rightclick on your class->select Modify run configuration->select environment->select edit environment
        ->enter PWDEBUG(name)=1(value)->apply and Ok
         then start run and your code start debugging from step by step
        after that delete you environment name and value after debugging is complete
        PWDEBUG=0 is for no timeout
        */

        /*
        Type3:page.pause()
        if you want debug in between of any line of code you use this method
        page.pause(); this will help to debug anywhere in your code
        */


        //used to open server
        Playwright playwright = Playwright.create();

        //It will start open in the chrome browser
        BrowserType.LaunchOptions lp = new BrowserType.LaunchOptions();
        lp.setChannel("chrome");
        lp.setHeadless(false);
        Browser browser = playwright.chromium().launch(lp);

        Page page=browser.newPage();
        page.navigate("https://www.flipkart.com/");
        //debug mode
        page.pause();
        page.getByLabel("Top Offer").click();
        page.navigate("https://www.flipkart.com/");
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("✕")).click();
        String string=page.title();
        System.out.println(string);
        browser.close();
        playwright.close();

    }
    }
