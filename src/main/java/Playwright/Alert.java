package Playwright;

import com.microsoft.playwright.*;

public class Alert {

    public static void main (String[]args) throws InterruptedException {

        //alert was handled automaticall by playwright default
        //otherwise we can add listerners and handle the alert automatically like simple, confirm and prompt alert


        //used to open server
        Playwright playwright = Playwright.create();

        //It will start open in the chrome browser
        BrowserType.LaunchOptions lp = new BrowserType.LaunchOptions();
        lp.setChannel("chrome");
        lp.setHeadless(false);
        Browser browser = playwright.chromium().launch(lp);


        Page page= browser.newPage();

        //listerners to handle all three types alert this will for your reference only
        page.onceDialog(dialog -> {
            String text = dialog.message();
            System.out.println(text);
            //we have a method called accept(String) to pass the value in the text box in alert
            dialog.accept("Prompt alert");
            //dialog.dismiss();
        });
        page.navigate("https://the-internet.herokuapp.com/javascript_alerts");
        Locator simpleAlert =page.locator("//button[@onclick='jsAlert()']");
        simpleAlert.click();
        Thread.sleep(1500);
        Locator confirmAlert =page.locator("//button[@onclick='jsConfirm()']");
        confirmAlert.click();
        Thread.sleep(1500);
        Locator promptAlert =page.locator("//button[@onclick='jsPrompt()']");
        promptAlert.click();
        Thread.sleep(1500);

        browser.close();
        playwright.close();
    }
    }

