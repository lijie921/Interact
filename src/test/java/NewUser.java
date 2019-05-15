import org.junit.Test;
import org.openqa.selenium.By;

public class NewUser
{
    @Test
    public void newUserGetCoins()
    {
        PublicFunction pb=new PublicFunction();
        //=======================新用户弹框送金币================================//
        try {
            Thread.sleep(10000);
        } catch (Exception e) { }

        pb.screenShot(DriverInit.driver,DriverInit.phoneName,"新用户送金币弹框");

        DriverInit.driver.findElement(By.id("com.intrctu.sample_test:id/getNow")).click();
        pb.screenShot(DriverInit.driver,DriverInit.phoneName,"获取新用户金币后关闭弹框");
    }
}
