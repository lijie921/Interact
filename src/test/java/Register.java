import org.junit.Test;
import org.openqa.selenium.WebElement;

public class Register
{
    PublicFunction pb=new PublicFunction();

    @Test
    public void register()
    {
        //=======================进入注册页面================================//
        //查找注册页面的入口元素
        try {
            WebElement clkLogin = pb.findElement(DriverInit.driver, "com.intrctu.sample_test:id/tv_title_login_name");
            if (clkLogin.isDisplayed()) {
                clkLogin.click();
                pb.screenShot(DriverInit.driver, DriverInit.phoneName, "注册页面");
            } else {
                pb.screenShot(DriverInit.driver, DriverInit.phoneName, "主页上找不到click login按钮");
            }
        }
        catch (Exception e)
        {
            pb.screenShot(DriverInit.driver, DriverInit.phoneName, "主页上找不到click login按钮");
        }
    }

    @Test
    public void login()
    {
        //=======================进入登陆页面================================//
        try {
            WebElement login = pb.findElement(DriverInit.driver, "com.intrctu.sample_test:id/tv_jump_login");
            if (login.isDisplayed()) {
                login.click();
                pb.screenShot(DriverInit.driver, DriverInit.phoneName, "登陆页面");

                WebElement email = pb.findElement(DriverInit.driver, "com.intrctu.sample_test:id/et_mail");
                WebElement pwd = pb.findElement(DriverInit.driver, "com.intrctu.sample_test:id/et_password");
                if (email.isDisplayed() && pwd.isDisplayed()) {
                    email.sendKeys("lijie@batmobi.net");
                    pwd.sendKeys("1234");
                    pb.findElement(DriverInit.driver, "com.intrctu.sample_test:id/bt_login").click();
                } else {
                    pb.screenShot(DriverInit.driver, DriverInit.phoneName, "登陆页面显示不完整");
                }
            } else {
                pb.screenShot(DriverInit.driver, DriverInit.phoneName, "无法进入登陆页面");
            }
        }
        catch (Exception e)
        {
            pb.screenShot(DriverInit.driver, DriverInit.phoneName, "无法进入登陆页面");
        }
        DriverInit.driver.navigate().back();
    }
}
