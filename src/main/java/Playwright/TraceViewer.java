package Playwright;
import com.microsoft.playwright.*;
import com.microsoft.playwright.options.*;

import java.nio.file.Paths;


public class TraceViewer {

    public static void main(String[]args) {

        /*
         Trace viewer is used to create screenshot and snapshot
          we can paste set of code at starting and end of the test
          After execution reload the project and trace.zip file is create in your project
          use can navigate to this url https://trace.playwright.dev/ and navigate to the zip file location in the local
          C:\Users\ak3282976\IdeaProjects\BasicTask\trace.zip
                        (or)
          open command prompt under project dir and paste this command
          mvn exec:java -e -D exec.mainClass=com.microsoft.playwright.CLI -D exec.args="show-trace trace.zip"

        */

        //used to open server
        Playwright playwright = Playwright.create();

        //It will start open in the Chrome browser
        BrowserType.LaunchOptions lp = new BrowserType.LaunchOptions();
        lp.setChannel("chrome");
        lp.setHeadless(false);
        Browser browser = playwright.chromium().launch(lp);


        // Start tracing before creating / navigating a page

        BrowserContext context = browser.newContext();
        context.tracing().start(new Tracing.StartOptions()
                .setScreenshots(true)
                .setSnapshots(true)
                .setSources(true));

        Page page = browser.newPage();
        page.navigate("https://www.wikipedia.org/");

        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Commons Free media collection")).click();
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("View source")).click();
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("History")).click();
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Log in")).click();
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Main page").setExact(true)).click();
        page.navigate("https://commons.wikimedia.org/wiki/Commons:Welcome");
        page.navigate("https://commons.wikimedia.org/wiki/Main_Page");


        // Stop tracing and export it into a zip archive.
        context.tracing().stop(new Tracing.StopOptions()
                .setPath(Paths.get("trace.zip")));

        browser.close();
        playwright.close();
    }

}
