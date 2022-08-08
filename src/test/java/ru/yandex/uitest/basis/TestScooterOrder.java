package ru.yandex.uitest.basis;

import ru.yandex.uipattern.MainPage;
import ru.yandex.uipattern.OrderPage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.hamcrest.MatcherAssert;
import ru.yandex.uitest.BaseTest;

import static org.hamcrest.CoreMatchers.containsString;


//Задание №2 - Параметризированные тесты для проверки заказа самоката (весь флоу позитивного сценария с двумя точками входа)
@RunWith(Parameterized.class)
public class TestScooterOrder extends BaseTest {

    MainPage mainPage = new MainPage(driver);
    OrderPage orderPage = new OrderPage(driver);

    private final String expectedResultOrder = "Заказ оформлен";

    private final String name;
    private final String lastName;
    private final String address;
    private final String xpathItemMetro;
    private final String phone;
    private final String xpathDate;
    private final String xpathPeriod;
    private final By checkbox;
    private final String comText;

    public TestScooterOrder(String name, String lastName, String address, String xpathItemMetro, String phone, String xpathDate, String xpathPeriod, By checkbox, String comText) {
        this.name = name;
        this.lastName = lastName;
        this.address = address;
        this.xpathItemMetro = xpathItemMetro;
        this.phone = phone;
        this.xpathDate = xpathDate;
        this.xpathPeriod = xpathPeriod;
        this.checkbox = checkbox;
        this.comText = comText;
    }

    //Набор тестовых данных
    @Parameterized.Parameters(name = "Тестовые данные: {0} {1} {2} {3} {4} {5} {6} {7} {8}")
    public static Object[][] getDataTests() {

        return new Object[][]{
                {
                        "Евгений",
                        "Сазанов",
                        "г.Нижний Новгород, ул.Новая, д.15, кв.99",
                        ".//ul[@class='select-search__options']//button[@value='21']",
                        "89051117890",
                        ".//div[@aria-label='Choose пятница, 19-е августа 2022 г.']",
                        ".//div[text()='двое суток']",
                        OrderPage.checkboxGreyColor,
                        "Предварительно позвонить по телефону"
                },
                {
                        "максим",
                        "ноутов",
                        "МОСКВА ПУШКИНА 22-75",
                        ".//ul[@class='select-search__options']//button[@value='5']",
                        "+79051234567",
                        ".//div[@aria-label='Choose суббота, 3-е сентября 2022 г.']",
                        ".//div[text()='семеро суток']",
                        OrderPage.checkboxBlackColor,
                        ""
                }
        };

    }

    //Тест№1 - Тест для проверки заказа самоката (весь флоу позитивного сценария, точка входа -> кнопка Заказать, расположенная в хедере главной страницы)
    @Test
    public void positiveTestsOrderClickHeaderButton() {

        mainPage.openPage();
        mainPage.clickHeaderOrderButton();
        orderPage.generalScenarioPageForWhomScooter(name, lastName, address, xpathItemMetro, phone);
        orderPage.generalScenarioPageAboutRent(xpathDate, xpathPeriod, checkbox, comText);
        orderPage.clickYesButton();
        String actualResultOrder = orderPage.getTextOrderIsProcessed();
        MatcherAssert.assertThat("Ошибка в подтверждении оформления заказа", actualResultOrder, containsString(expectedResultOrder));
    }

    //Тест№2 - Тест для проверки заказа самоката (весь флоу позитивного сценария, точка входа -> кнопка Заказать, расположенная внизу главной страницы)
    @Test
    public void positiveTestsOrderClickFooterButton() {

        mainPage.openPage();
        mainPage.clickFooterOrderButton();
        orderPage.generalScenarioPageForWhomScooter(name, lastName, address, xpathItemMetro, phone);
        orderPage.generalScenarioPageAboutRent(xpathDate, xpathPeriod, checkbox, comText);
        orderPage.clickYesButton();
        String actualResultOrder = orderPage.getTextOrderIsProcessed();
        MatcherAssert.assertThat("Ошибка в подтверждении оформления заказа", actualResultOrder, containsString(expectedResultOrder));
    }
}