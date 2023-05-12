package TestCase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class Cases {
    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://the-internet.herokuapp.com/login");

    }
    @AfterMethod
    public void testCase(){
        driver.quit();

    }
    @Test
    public void testcase01(){
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.id("password")).sendKeys("superSecretPassword");
        driver.findElement(By.xpath("//*[@class='fa fa-2x fa-sign-in']")).click();
        System.out.println("the url of website is "+driver.getCurrentUrl());
        SoftAssert soft = new SoftAssert();

        soft.assertEquals(driver.getCurrentUrl(),"https://the-internet.herokuapp.com/login");






    }

}
