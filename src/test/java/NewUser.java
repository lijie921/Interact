import org.junit.Test;
import org.openqa.selenium.WebElement;

public class NewUser
{
    @Test
    public void newUserGetCoins()
    {
        PublicFunction pb=new PublicFunction();
        //=======================新用户弹框送金币================================//
        //查找新用户奖励弹窗上面的元素
        DriverInit.driver.switchTo();
        try {
            WebElement getNow = pb.findElement(DriverInit.driver, "com.intrctu.sample_test:id/getNow");
            if (getNow.isDisplayed())
            {
                pb.screenShot(DriverInit.driver,DriverInit.phoneName,"新用户送金币弹框");
                getNow.click();
                pb.screenShot(DriverInit.driver, DriverInit.phoneName, "获取新用户金币后关闭弹框");
            }
            else {
                pb.screenShot(DriverInit.driver, DriverInit.phoneName, "无新用户奖励弹框");
            }
        }
        catch (Exception e)
        {
            pb.screenShot(DriverInit.driver, DriverInit.phoneName, "无新用户奖励弹框");
        }

    }
}
