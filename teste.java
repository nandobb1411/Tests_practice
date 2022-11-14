import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

public class teste {

    @Test
    public void testabrirPagina () {
    //teste que abre a pagina

        System.setProperty("webdriver.chrome.driv", "C:\\Users\\Desktop\\Eclipse\\chromedriver.exe");

        WebDriver driv = new ChromeDriver();
        driv.manage().window().maximize();
        driv.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


        driv.get("https://www.amazon.com.br");

        
        String url = driv.getCurrentUrl();
        assertEquals("https://www.amazon.com.br", url);
        
        driv.quit();

    }
    @Test
    public void testClear() {
    //teste que checa as pesquisas de um quadro e um roteador na amazon
        System.setProperty("webdriver.chrome.driv", "C:\\Users\\Desktop\\Eclipse\\chromedriver.exe");
//colocar o caminho para o chromedriver haha
        WebDriver driv = new ChromeDriver();
        driv.manage().window().maximize();
        driv.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driv.get("https://www.amazon.com.br");

        
        WebElement search = driv.findElement(By.id("twotabsearchtextbox"));
        search.sendKeys("roteador");
        search.clear();
        search.sendKeys("quadro");

       
        WebElement searchButton = driv.findElement(By.id("nav-search-submit-button"));
        searchButton.click();


        String url = driv.getCurrentUrl();
        assertTrue(driv.getCurrentUrl().contains("quadro"));

      
        driv.quit();

    }
    @Test
    public void testSearch() {
//buscar nintendo switch
        System.setProperty("webdriver.chrome.driv", "C:\\Users\\Desktop\\Eclipse\\chromedriver.exe");

        WebDriver driv = new ChromeDriver();
        driv.manage().window().maximize();
        driv.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driv.get("https://www.amazon.com.br");

        
        WebElement search = driv.findElement(By.id("twotabsearchtextbox"));
        search.sendKeys("nintendo switch");


        WebElement searchButton = driv.findElement(By.id("nav-search-submit-button"));
        searchButton.click();

        
        String title = driv.getTitle();
        assertTrue(title.contains("nintendo switch"));

        
        driv.quit();

    }
    
}

