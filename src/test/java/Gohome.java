import org.junit.Test;


public class Gohome
{
    @Test
    public void openHomepage()
    {
        PublicFunction pb=new PublicFunction();
        //=======================打开互动主页================================//
        DriverInit.driver.switchTo();
        pb.findElement(DriverInit.driver,"com.intrctu.sample_test:id/button3").click();
        pb.screenShot(DriverInit.driver,DriverInit.phoneName,"进入互动主页");
    }
}
