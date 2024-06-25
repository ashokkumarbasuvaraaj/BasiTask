package Playwright;

import com.microsoft.playwright.*;

public class WindowHandle {

    public static void main(String []args) throws InterruptedException {

//        1.Single browser we can open multiple browser context
//        2.Single browser context we can open multiple page
//
        Playwright playwright = Playwright.create();
        BrowserType.LaunchOptions lp = new BrowserType.LaunchOptions();
        lp.setChannel("chrome");
        lp.setHeadless(false);
        Browser browser = playwright.chromium().launch(lp);

        BrowserContext bx1 = browser.newContext();

        Page page= bx1.newPage();
        page.navigate("https://opensource-demo.orangehrmlive.com/");

        //Method1:open a new child window/tab/popup after clicking on the link on the parent page
        Page childWindow = page.waitForPopup(() ->{
            page.click("//a[@href='https://twitter.com/orangehrm?lang=en']//*[name()='svg']");
        });
        childWindow.waitForLoadState();
        System.out.println(("ChildWindow : "+childWindow.title()));
        childWindow.close();
        System.out.println(("ParentWindow : "+page.title()));
          page.close();

        //Method2:open a new empty child window/tab/popup and then enter the new url
//        page.navigate("https://amazon.com/");
//        Page child = page.waitForPopup(()->{
//            page.click("a[target='_blank']"); //open new empty window/tab
//        });
//        child.waitForLoadState();
//        child.navigate("https://www.google.com");
//        System.out.println(("ChildWindow : "+child.title()));
//        child.close();
//        System.out.println(("ParentWindow : "+page.title()));
//        page.close();

//        boolean visible1 = page.getByText(" Login ").isVisible();
//        Locator loginButton = page.locator("//button[@type='submit']");
//        boolean enabled = loginButton.isEnabled();
//        System.out.println(enabled);
//        System.out.println(visible1);


        bx1.close();
        playwright.close();
    }
}
