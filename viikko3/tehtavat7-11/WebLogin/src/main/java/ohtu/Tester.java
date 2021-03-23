package ohtu;

import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class Tester {

    public static void main(String[] args) {
        WebDriver driver = new HtmlUnitDriver();

        driver.get("http://localhost:4567");
        
        System.out.println(driver.getPageSource());
        
        //UUDEN KÄYTTÄJÄN LUOMINEN
        String username = generateUsername();
        String password = generatePassword();        
        
        WebElement element = driver.findElement(By.linkText("register new user"));
        element.click();

        System.out.println(driver.getPageSource());
        
        sleep(5);

        element = driver.findElement(By.name("username"));
        element.sendKeys(username);
        element = driver.findElement(By.name("password"));
        element.sendKeys(password);
        element = driver.findElement(By.name("passwordConfirmation"));
        element.sendKeys(password);
        element = driver.findElement(By.name("signup"));

        System.out.println(driver.getPageSource());
        
        sleep(5);
        element.submit();

        System.out.println(driver.getPageSource());

        sleep(5);
        
        //ULOSKIRJAUTUMINEN
        
        element = driver.findElement(By.linkText("continue to application mainpage"));  
        element.click();
        
        System.out.println(driver.getPageSource());

        sleep(5);
        
        element = driver.findElement(By.linkText("logout"));  
        element.click();
        
        System.out.println(driver.getPageSource());
        
        // SISÄÄNKIRJAUTUMINEN OIKEALLA KÄYTTÄJÄTUNNUKSELLA, VÄÄRÄLLÄ SALASANALLA
        
        sleep(5);
        
        element = driver.findElement(By.linkText("login"));
        element.click();

        System.out.println(driver.getPageSource());
        
        sleep(5);

        element = driver.findElement(By.name("username"));
        element.sendKeys(username);
        element = driver.findElement(By.name("password"));
        element.sendKeys("12345");
        element = driver.findElement(By.name("login"));

        System.out.println(driver.getPageSource());
        
        sleep(5);
        element.submit();

        System.out.println(driver.getPageSource());

        sleep(3);
        
        element = driver.findElement(By.linkText("back to home"));
        element.click();
        
        //ALKUPERÄINEN SKENAARIO = SISÄÄNKIRJAUTUMINEN
        
        sleep(5);
        
        element = driver.findElement(By.linkText("login"));
        element.click();

        System.out.println(driver.getPageSource());
        
        sleep(5);

        element = driver.findElement(By.name("username"));
        element.sendKeys(username);
        element = driver.findElement(By.name("password"));
        element.sendKeys(password);
        element = driver.findElement(By.name("login"));

        System.out.println(driver.getPageSource());
        
        sleep(5);
        element.submit();

        System.out.println(driver.getPageSource());

        sleep(3);
        
        driver.quit();
    }
    
    public static String generateUsername() {
        Random r = new Random();
        String username = "laura" + r.nextInt(10000);
        return username;
    }
    
    public static String generatePassword() {
        Random r = new Random();
        String password = "arual" + r.nextInt(10000);
        return password;
    }
    
    private static void sleep(int n){
        try{
            Thread.sleep(n*1000);
        } catch(Exception e){}
    }
}
