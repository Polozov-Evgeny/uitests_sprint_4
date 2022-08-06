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

    public TestDropdowns(By questionsItem, By responsesItem, String responsesText) {
        this.questionsItem = questionsItem;
        this.responsesItem = responsesItem;
        this.responsesText = responsesText;
    }

    //Набор тестовых данных
    @Parameterized.Parameters
    public static Object[][] getDataTests(){

        return new Object[][]{
                {MainPage.questionsItem0, MainPage.responsesItem0, MainPage.responsesText0},
                {MainPage.questionsItem1, MainPage.responsesItem1, MainPage.responsesText1},
                {MainPage.questionsItem2, MainPage.responsesItem2, MainPage.responsesText2},
                {MainPage.questionsItem3, MainPage.responsesItem3, MainPage.responsesText3},
                {MainPage.questionsItem4, MainPage.responsesItem4, MainPage.responsesText4},
                {MainPage.questionsItem5, MainPage.responsesItem5, MainPage.responsesText5},
                {MainPage.questionsItem6, MainPage.responsesItem6, MainPage.responsesText6},
                {MainPage.questionsItem7, MainPage.responsesItem7, MainPage.responsesText7}
        };
    }

    //Тест, проверяющий, что при нажатии на люббой пункт списка "Вопросы о важном" открывается определенный текст
    @Test
    public void testQuestionsDropdowns(){

        mainPage.openPage();
        mainPage.clickQuestionsItem(questionsItem, responsesItem);
        String resultText = mainPage.getTextDropdownsItem(responsesItem);
        assertEquals("Ошибка в тексте элемента выпадающего списка", responsesText, resultText);
    }
}