import org.junit.Test;
public class Register
{
    PublicFunction pb=new PublicFunction();

    @Test
    public void register()
    {
        //=======================进入注册页面================================//
        try {
            Thread.sleep(10000);
        } catch (Exception e) { }

        pb.findElement(DriverInit.driver,"com.intrctu.sample_test:id/tv_title_login_name").click();
        pb.screenShot(DriverInit.driver,DriverInit.phoneName,"注册页面");
    }

    @Test
    public void login()
    {
        //=======================进入登陆页面================================//
        pb.findElement(DriverInit.driver,"com.intrctu.sample_test:id/tv_jump_login").click();
        pb.screenShot(DriverInit.driver,DriverInit.phoneName,"登陆页面");

        pb.findElement(DriverInit.driver,"com.intrctu.sample_test:id/et_mail").sendKeys("lijie@batmobi.net");
        pb.findElement(DriverInit.driver,"com.intrctu.sample_test:id/et_password").sendKeys("1234");
        pb.findElement(DriverInit.driver,"com.intrctu.sample_test:id/bt_login").click();

        DriverInit.driver.navigate().back();
    }
}
