package Playwright;

import com.microsoft.playwright.*;

public class BrowserContext1 {

    public static void main(String []args){

        /*
        BrowserContexts provide a way to operate multiple independent browser sessions.
        it will open on incognito mode and does not store any cookies and catch
        we can perform single operation with multiple users at a same time
        for example login with admin user, login with employee user with same operation at a same time.
        */

        Playwright playwright = Playwright.create();
        BrowserType.LaunchOptions lp = new BrowserType.LaunchOptions();
        lp.setChannel("chrome");
        lp.setHeadless(false);
        Browser browser = playwright.chromium().launch(lp);

        BrowserContext browserContext = browser.newContext();
        Page p1 = browserContext.newPage();
        p1.navigate("https://www.wikipedia.org/");

        BrowserContext browserContext1 = browser.newContext();
        Page p2 = browserContext1.newPage();
        p2.navigate("https://www.flipkart.com/");

        BrowserContext browserContext2 = browser.newContext();
        Page p3 = browserContext2.newPage();
        p3.navigate("https://www.amazon.in/");

        p1.close();
        browserContext.close();

        p2.close();
        browserContext1.close();

        p3.close();
        browserContext2.close();
        playwright.close();

    }
}
