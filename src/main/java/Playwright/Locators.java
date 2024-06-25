package Playwright;

import com.microsoft.playwright.*;

public class Locators {

//    public void selectBrowser(String browserName){
//            Playwright playwright = Playwright.create();
//            Browser browser = null;
//            browserName = System.getenv("BROWSER");
//            if (browserName.equals("chromium")) {
//                browser = playwright.chromium().launch();
//            } else if (browserName.equals("firefox")) {
//                browser = playwright.firefox().launch();
//            } else if (browserName.equals("webkit")) {
//                browser = playwright.webkit().launch();
//            }
//            Page page = browser.newPage();
//            page.navigate("https://www.orangehrm.com/en/");
//
//    }

    public static void main (String[]args){
//        Locators locator=new Locators();
//        locator.selectBrowser("chromium");

        Playwright playwright = Playwright.create();
        BrowserType.LaunchOptions lp = new BrowserType.LaunchOptions();
        lp.setChannel("chrome");
        lp.setHeadless(false);
        Browser browser = playwright.chromium().launch(lp);

        Page newPage = browser.newPage();

//        Request request = newPage.waitForRequest("**/*logo*.png", () -> {
//            newPage.navigate("https://wikipedia.org");
//        });
//        System.out.println(request.url());
//
//        Page popup = newPage.waitForPopup(() -> {
//            newPage.locator("#js-link-box-en").click();
//        });
//        popup.navigate("https://wikipedia.org");
//
//        newPage.navigate("https://www.orangehrm.com/en/");
//
//        newPage.navigate("https://www.facebook.com/");
//        newPage.locator("//button[@name='login']").click();

        //newPage.locator("text=Contact Sales").first().click();
       // newPage.locator("text=Privacy Policy").first().click();


//        Locator links =newPage.locator("text=Privacy Policy");
//        for(int i=0; i<links.count();i++){
//            String linkText= links.nth(i).textContent();
//            if(linkText.contains("Service Policy")){
//                links.nth(i).click();
//                break;
//            }
//        }
//
//        String content =newPage.locator("a:has-text('30-Day Free Trial')").first().textContent();
//        System.out.println(content);


//        String content =newPage.locator("button:has-text('30-Day Free Trial')").textContent();
//        System.out.println(content);

//        String header =newPage.locator("//input[@type='submit']").textContent();
//        System.out.println(header);

//        String content1 =newPage.locator("div.middleColumn input:has-text('Enter your email address here')").textContent();
//        System.out.println(content1);




        browser.close();;
        playwright.close();

    }
}
