package ru.yandex.uitest.additional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.uipattern.MainPage;
import ru.yandex.uipattern.TrackPage;
import ru.yandex.uitest.BaseTest;

import static org.junit.Assert.assertTrue;


//Задание №4 - Параметризированный тест для проверки отображения страницы с сообщением об отсутствии товара, если введен некорректный номер
@RunWith(Parameterized.class)
public class TestNoSuchOrder extends BaseTest {

    MainPage mainPage = new MainPage(driver);
    TrackPage trackPage = new TrackPage(driver);

    private final String wrongNumber;

    public TestNoSuchOrder(String wrongNumber) {
        this.wrongNumber = wrongNumber;
    }

    //Набор тестовых данных
    @Parameterized.Parameters(name = "Тестовые данные: {0}")
    public static Object[][] getDataTests() {

        return new Object[][]{
                {"1234567890"},
                {"ЙЦУкенQWErty"},
                {"!@&*"},
                {"123ZXC"},
                {""}
        };
    }

    //Тест, проверяющий отображение страницы с сообщением об отсутствии товара, если введен некорректный номер
    @Test
    public void TestPageNoSuchOrder() {

        mainPage.openPage();
        mainPage.clickOrderStatusButton();
        mainPage.inputOrderNumber(wrongNumber);
        mainPage.clickGoButton();
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(trackPage.imgNoSuchOrder));
        boolean resultAboutNoSuchOrder = driver.findElement(trackPage.imgNoSuchOrder).isDisplayed();
        assertTrue("Сообщение 'Такого заказа нет' отсутствует", resultAboutNoSuchOrder);
    }
}