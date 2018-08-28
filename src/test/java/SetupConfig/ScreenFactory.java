package SetupConfig;

import org.openqa.selenium.Platform;
import screen.abstractScreen.LoginScreen;
import screen.abstractScreen.SearchScreen;
import screen.android.AndroidLoginScreen;
import screen.android.AndroidSearchScreen;

/**
 * Created by pravin.kumbhare on 25-07-2018.
 */
public class ScreenFactory {

    public static final String LOGIN_SCREEN = "LOGIN_SCREEN";
    public static final String SEARCH_SCREEN = "SEARCH_SCREEN";

    public static final String PLATFORM_ANDROID = "ANDROID";
    public static final String PLATFORM_IOS = "IOS";
    public static final String PLATFORM_WEB = "WEB";

    public static final String ANDROID = "android";
    public static final String IOS = "ios";
    public static final String WEB = "web";

    private LoginScreen loginScreen = null;
    private SearchScreen searchScreen = null;


    public <Screen> Screen getScreen(String platform, String screenName) {

        if(platform.equalsIgnoreCase(ANDROID) && screenName.equalsIgnoreCase(LOGIN_SCREEN)){

            loginScreen = new AndroidLoginScreen();
            return (Screen) loginScreen;

        }else if(platform.equalsIgnoreCase(ANDROID) && screenName.equalsIgnoreCase(SEARCH_SCREEN)){

            searchScreen = new AndroidSearchScreen();
            return (Screen) searchScreen;

        } else if(platform.equalsIgnoreCase(IOS) && screenName.equalsIgnoreCase(LOGIN_SCREEN)){

            //Not Applicable
            System.out.println("Not Applicable");

        }else if(platform.equalsIgnoreCase(WEB) && screenName.equalsIgnoreCase(SEARCH_SCREEN)){

          /*  if(screenName.equalsIgnoreCase(LOGIN_SCREEN)){

                loginScreen = new WebLoginScreen();
                return (Screen) loginScreen;
            }else if(screenName.equalsIgnoreCase(SEARCH_SCREEN)){

                searchScreen = new WebSearchScreen();
                return (Screen) searchScreen;
            }*/
        }else{
            System.out.println("Invalid Platform");
        }
        return null;
    }



   /* public <Screen> Screen getScreen(String screenName){

        if(PLATFORM.equalsIgnoreCase(ANDROID)){

            if(screenName.equalsIgnoreCase(LOGIN_SCREEN)){

                loginScreen = new AndroidLoginScreen();
                return (Screen) loginScreen;
            }else if(screenName.equalsIgnoreCase(SEARCH_SCREEN)){

                searchScreen = new AndroidSearchScreen();
                return (Screen) searchScreen;
            }

        }else if(PLATFORM.equalsIgnoreCase(IOS)){

            //Not Applicable
            System.out.println("Not Applicable");
        }else if(PLATFORM.equalsIgnoreCase(WEB)){

          *//*  if(screenName.equalsIgnoreCase(LOGIN_SCREEN)){

                loginScreen = new WebLoginScreen();
                return (Screen) loginScreen;
            }else if(screenName.equalsIgnoreCase(SEARCH_SCREEN)){

                searchScreen = new WebSearchScreen();
                return (Screen) searchScreen;
            }*//*
        }else{
            System.out.println("Invalid Platform");
        }
        return null;
    }*/

}
