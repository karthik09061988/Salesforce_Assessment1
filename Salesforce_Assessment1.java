package SalesForce;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
public class Assessment1{
    public static void main(String[] args) throws InterruptedException {
        // TODO Auto-generated method stub
        WebDriverManager.chromedriver().setup();
        WebDriverManager.firefoxdriver().setup();
        ChromeOptions opt2 = new ChromeOptions();
        opt2.addArguments("disable-notifications");
        ChromeDriver driver = new ChromeDriver(opt2);
        driver.manage().window().maximize();
        
        //Login to Salesforce
        driver.get("https://login.salesforce.com");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.findElement(By.id("username")).sendKeys("ramkumar.ramaiah@testleaf.com");
        driver.findElement(By.id("password")).sendKeys("Password$123");
        driver.findElement(By.id("Login")).click();
        
        //Click Applauncher and create new opportunity
        driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
        driver.findElement(By.xpath("//button[text()='View All']")).click();
        driver.findElement(By.xpath("//one-app-launcher-app-tile[@data-name='Sales']")).click();
        driver.findElement(By.xpath("//a[@title='Opportunities']//parent::one-app-nav-bar-item-root")).click();
        driver.findElement(By.xpath("//div[text()='New']")).click();
        WebElement name1 = driver.findElement(By.xpath("//input[@name='Name']"));
        name1.sendKeys("Create Salesforce opportunity - Karthik");
        String namepr = name1.getAttribute("value");
        System.out.println(namepr);
        driver.findElement(By.xpath("//input[@name='CloseDate']")).click();
        driver.findElement(By.xpath("//span[text()='2']")).click();
        driver.findElement(By.xpath("//div[@role='none']/button")).click();
        driver.findElement(By.xpath("//lightning-base-combobox-item[@data-value='Needs Analysis']")).click();
        driver.findElement(By.xpath("//button[text()='Save']")).click();
        WebElement name2 = driver.findElement(By.xpath("//lightning-formatted-text[@slot='primaryField']"));
        String namepr2 = name2.getText();
        System.out.println(namepr2);
        if(namepr.equals(namepr2)) {
            System.out.println("Output is Expected");
        } else {
            System.out.println("Output is Not displayed as Expected");
        }
driver.quit();
    }
    }
