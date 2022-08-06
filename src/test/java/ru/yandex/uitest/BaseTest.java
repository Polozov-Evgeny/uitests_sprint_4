package ru.yandex.uitest;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

//Базовый класс для общих настроек к тестовым классам
public class BaseTest{

    //Выбираем браузер для выполнения тестов
//    public WebDriver driver = new FirefoxDriver();
    public WebDriver driver = new ChromeDriver();

    @Before
    public void setUp(){
        driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}