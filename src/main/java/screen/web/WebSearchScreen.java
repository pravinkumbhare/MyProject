package screen.web;

import screen.abstractScreen.SearchScreen;

/**
 * Created by pravin.kumbhare on 25-07-2018.
 */
public class WebSearchScreen extends SearchScreen {

    //default constructor
    public WebSearchScreen(){}


    @Override
    public boolean searchPageReusableMethod() {
        return false;
    }
}
