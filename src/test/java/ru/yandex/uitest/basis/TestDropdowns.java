package ru.yandex.uitest.basis;

import ru.yandex.uipattern.MainPage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import ru.yandex.uitest.BaseTest;

import static org.junit.Assert.assertEquals;


//Задание №1 - Параметризированный тест для проверки дропдаунов раздела "Вопросы о важном" на главной странице
@RunWith(Parameterized.class)
public class TestDropdowns extends BaseTest {

    MainPage mainPage = new MainPage(driver);

    private final By questionsItem;
    private final By responsesItem;

    private final String responsesText;

    //Текст ответов раздела Вопросы о важном
    private static final String responsesText0 = "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";
    private static final String responsesText1 = "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.";
    private static final String responsesText2 = "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.";
    private static final String responsesText3 = "Только начиная с завтрашнего дня. Но скоро станем расторопнее.";
    private static final String responsesText4 = "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.";
    private static final String responsesText5 = "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.";
    private static final String responsesText6 = "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.";
    private static final String responsesText7 = "Да, обязательно. Всем самокатов! И Москве, и Московской области.";

    public TestDropdowns(By questionsItem, By responsesItem, String responsesText) {
        this.questionsItem = questionsItem;
        this.responsesItem = responsesItem;
        this.responsesText = responsesText;
    }

    //Набор тестовых данных
    @Parameterized.Parameters(name = "Тестовые данные: {0} {1} {2}")
    public static Object[][] getDataTests() {

        return new Object[][]{
                {MainPage.questionsItem0, MainPage.responsesItem0, responsesText0},
                {MainPage.questionsItem1, MainPage.responsesItem1, responsesText1},
                {MainPage.questionsItem2, MainPage.responsesItem2, responsesText2},
                {MainPage.questionsItem3, MainPage.responsesItem3, responsesText3},
                {MainPage.questionsItem4, MainPage.responsesItem4, responsesText4},
                {MainPage.questionsItem5, MainPage.responsesItem5, responsesText5},
                {MainPage.questionsItem6, MainPage.responsesItem6, responsesText6},
                {MainPage.questionsItem7, MainPage.responsesItem7, responsesText7}
        };
    }

    //Тест, проверяющий, что при нажатии на любой пункт списка "Вопросы о важном" открывается определенный текст
    @Test
    public void testQuestionsDropdowns() {

        mainPage.openPage();
        mainPage.clickQuestionsItem(questionsItem, responsesItem);
        String resultText = mainPage.getTextDropdownsItem(responsesItem);
        assertEquals("Ошибка в тексте элемента выпадающего списка", responsesText, resultText);
    }
}