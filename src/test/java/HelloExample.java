/**
 * Created by pravin.kumbhare on 23-07-2018.
 */

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class HelloExample{

    final static Logger logger = Logger.getLogger(HelloExample.class);

    public static void main(String[] args) {

        PropertyConfigurator.configure("D:\\Solaris Project\\solaris\\Appium_Android_Project\\src\\test\\resources\\log4j.properties");

        logger.debug("Log4j debug is implemented..");
        logger.info("Log4j info is implemented..");
        HelloExample obj = new HelloExample();
        obj.runMe("mkyong");
    }

    private void runMe(String parameter){

        if(logger.isDebugEnabled()){
            logger.debug("Log4j is implemented..");
            logger.info("Log4j is implemented..");
            logger.debug("This is debug : " + parameter);
        }

        if(logger.isInfoEnabled()){
            logger.info("This is info : " + parameter);
        }

        logger.warn("This is warn : " + parameter);
        logger.error("This is error : " + parameter);
        logger.fatal("This is fatal : " + parameter);

    }

}