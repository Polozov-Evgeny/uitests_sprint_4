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

import static org.junit.Assert.assertEquals;


//Доп.задание №1 - Тест для проверки перехода на Главную страницу при нажатии на логотип "Самокат"
@RunWith(Parameterized.class)
public class TestLogoScooter extends BaseTest {

    private final String dataURL;

    //Логотип Самокат на страницах
    private final By logoScooter = By.xpath(".//img[@alt='Scooter']");

    public TestLogoScooter(String dataURL) {
        this.dataURL = dataURL;
    }

    //Набор тестовых данных
    @Parameterized.Parameters(name = "Тестовые данные: {0}")
    public static Object[][] getDataTests() {

        return new Object[][]{
                {MainPage.pageURL},
                {OrderPage.pageURL},
                {TrackPage.pageURL}
        };
    }

    //Тест для проверки перехода на Главную страницу при нажатии на логотип "Самокат"
    @Test
    public void testLogoScooterClick() {

        driver.get(dataURL);
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(logoScooter));
        driver.findElement(logoScooter).click();
        String actualResultURL = driver.getCurrentUrl();
        assertEquals("Ошибка при переходе по логотипу Самокат", "https://qa-scooter.praktikum-services.ru/", actualResultURL);
    }
}