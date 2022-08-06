package ru.yandex.uitest.additional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.uipattern.MainPage;
import ru.yandex.uipattern.OrderPage;
import ru.yandex.uipattern.TrackPage;
import ru.yandex.uitest.BaseTest;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

//Доп.задание №2 - Тест для проверки открытия доп.вкадки со страницей Яндекс при нажатии на логотип "Яндекс"
@RunWith(Parameterized.class)
public class TestLogoYandex extends BaseTest{

    private final String dataURL;

    //Логотип Яндекс на страницах
    private final By logoYandex = By.xpath(".//img[@alt='Yandex']");

    public TestLogoYandex(String dataURL) {
        this.dataURL = dataURL;
    }

    //Набор тестовых данных
    @Parameterized.Parameters
    public static Object[][] getDataTests(){

        return new Object[][]{
                {MainPage.pageURL},
                {OrderPage.pageURL},
                {TrackPage.pageURL}
        };
    }

    //Тест для проверки перехода на Главную страницу при нажатии на логотип "Яндекс"
    @Test
    public void testLogoYandexClick(){

        driver.get(dataURL);
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(logoYandex));
        driver.findElement(logoYandex).click();
        ArrayList<String> newTab = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(newTab.get(1));
        new WebDriverWait(driver, 5)
              .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//div[@aria-label='Яндекс']")));
        String actualResultURL = driver.getCurrentUrl();
        assertEquals("Ошибка при переходе по логотипу Самокат", "https://yandex.ru/", actualResultURL);
    }
}