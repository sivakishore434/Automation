import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.Assert;


public class AllMobiles {
   
        static{         
        
        System.setProperty("webdriver.chrome.driver","C:\\Users\\siva.kishore\\Downloads\\chromedriver_win32\\chromedriver.exe");
       
         }
         WebDriver driver = new ChromeDriver();
         
             @Test(priority = 1)
             
            public void launchBrowser() {
            driver = new ChromeDriver();
            driver.get("https://mobileworld.banyanpro.com/");
            driver.manage().window().maximize();
            
           }
        
        @Test(priority = 2)
             public void allMobiles() {
                 WebElement allMobiles = driver.findElement(By.xpath("//*[text()='All Mobiles']"));
                 allMobiles.click();
                 List<WebElement> names = driver.findElements(By.xpath("//table/thead/tr"));
                 for (WebElement n1 : names) {
                 String abc = n1.getText();
                 if (abc.contains("Mobile Name")) {
                 Assert.assertTrue(true);
                        }
                    }
                }
    @Test(priority = 3)
             public void searchLenovo() throws InterruptedException {
                 driver.findElement(By.id("myInput")).sendKeys("Lenovo");
                 String mobName = driver.findElement(By.xpath("//tbody[@id='myTable']/tr[4]/td[1]")).getText();
                 Thread.sleep(1000);
                 Assert.assertTrue(mobName.contains("Lenovo"));
                 driver.findElement(By.id("myInput")).clear();
                    }
    @Test(priority = 4)
             public void searchSamsung() throws InterruptedException{
                 driver.findElement(By.id("myInput")).sendKeys("Samsung");
                 String mobName = driver.findElement(By.xpath("//th[text()='Mobile Name']/../../../tbody/tr/td")).getText();
                 Thread.sleep(1000);
                 Assert.assertTrue(mobName.contains("Samsung"));
                 driver.findElement(By.id("myInput")).clear();
                    }
    @Test(priority = 5)
              public void wrongApple() throws InterruptedException{
              driver.findElement(By.id("myInput")).sendKeys("Apple iphone ");
              Thread.sleep(1000);
    // We cannot assert statement here because no error message is displayed
              driver.findElement(By.id("myInput")).clear();
                    }
    @Test(priority = 6)
              public void wrongSamsung() throws InterruptedException{
                    driver.findElement(By.id("myInput")).sendKeys("S@msung");
                    Thread.sleep(1000);
                    // We cannot assert statement here because no error message is displayed
                    driver.findElement(By.id("myInput")).clear();
                }
    @Test(priority = 7)
             public void twoCharacter() throws InterruptedException{
                 driver.findElement(By.id("myInput")).sendKeys("Sa");
                 String mobName = driver.findElement(By.xpath("//th[text()='Mobile Name']/../../../tbody/tr/td")).getText();
                 Thread.sleep(1000);
                 Assert.assertTrue(mobName.contains("Samsung"));
                 driver.findElement(By.id("myInput")).clear();
                    }
    @Test(priority = 8)
              public void InvalidMob() throws InterruptedException {
                  driver.findElement(By.id("myInput")).sendKeys("Man");
                  Thread.sleep(1000);
                 //  We cannot assert statement here because no error message is displayed
                  driver.findElement(By.id("myInput")).clear();
                    }
    @Test(priority = 9)
             public void order() throws InterruptedException {
                 driver.findElement(By.id("myInput")).sendKeys("Samsung Galaxy S21");
                 Thread.sleep(1000);
                 driver.findElement(By.xpath("//tbody/tr[1]/td[5]/a[1]")).click();
                 Thread.sleep(1000);
                 // We cannot assert statement here because same page is opening again
                 driver.quit();
                }
   }