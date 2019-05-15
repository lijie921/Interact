import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

import org.junit.BeforeClass;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

import org.junit.Test;
import java.io.*;
import org.openqa.selenium.remote.DesiredCapabilities;


public class DriverInit
{
    public static AndroidDriver driver;
    public static String phoneName="";
    public static PublicFunction pb=new PublicFunction();
    //定义DesiredCapabilities
    public static DesiredCapabilities cap=new DesiredCapabilities();

    public static File app;

    @BeforeClass
    public static void setUp()
    {
        //加载配置文件
        InputStream inStream = DriverInit.class.getClassLoader().getResourceAsStream("BaseConfig");
        Properties prop = new Properties();
        try {
            prop.load(inStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        phoneName=prop.getProperty("phoneName");

        //先创建指定手机目录，用于存放截图文件
        pb.CreateFolders(phoneName);

        //关闭文件
        try {
            inStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //设置apk的路径
        File clasPathRoot = new File(System.getProperty("user.dir"));
        File appDir = new File(clasPathRoot,"apps");
        app = new File(appDir,"Interact_Sample_2.0.2_debug_1905131345.apk");

        //初始化DesiredCapabilities对象
        cap.setCapability("automationName","Appium");
        cap.setCapability("platformName","Android");
        cap.setCapability("deviceName","3b56e6f1");
    }

    @Test
    public void install()
    {
        cap.setCapability("app",app.getAbsolutePath());
        cap.setCapability("appPackage","com.intrctu.sample_test");//被测app的包名
        cap.setCapability("appActivity","MainActivity");//被测app的入口Activity名称

        //运行case前,先卸载已存app,并安装新app,打开app
        cap.setCapability(MobileCapabilityType.FULL_RESET,"true");
        try
        {
            driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), cap);
            Thread.sleep(10000);
        }
        catch (Exception e){}
    }

}
