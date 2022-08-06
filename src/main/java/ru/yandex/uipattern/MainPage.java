package ru.yandex.uipattern;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//POM Главной страницы сайта
public class MainPage{
    WebDriver driver;

    //Конструктор класса MainPage
    public MainPage(WebDriver driver){
        this.driver = driver;
    }

    //<-----ПОЛЯ КЛАССА MainPage----->
    //URL главной страницы сайта
    public static final String pageURL = "https://qa-scooter.praktikum-services.ru/";

    //Локаторы пунктов раздела Вопросы о важном
    public static final By questionsItem0 = By.id("accordion__heading-0");
    public static final By questionsItem1 = By.id("accordion__heading-1");
    public static final By questionsItem2 = By.id("accordion__heading-2");
    public static final By questionsItem3 = By.id("accordion__heading-3");
    public static final By questionsItem4 = By.id("accordion__heading-4");
    public static final By questionsItem5 = By.id("accordion__heading-5");
    public static final By questionsItem6 = By.id("accordion__heading-6");
    public static final By questionsItem7 = By.id("accordion__heading-7");

    //Локаторы выпадающих элементов раздела Вопросы о важном
    public static final By responsesItem0 = By.id("accordion__panel-0");
    public static final By responsesItem1 = By.id("accordion__panel-1");
    public static final By responsesItem2 = By.id("accordion__panel-2");
    public static final By responsesItem3 = By.id("accordion__panel-3");
    public static final By responsesItem4 = By.id("accordion__panel-4");
    public static final By responsesItem5 = By.id("accordion__panel-5");
    public static final By responsesItem6 = By.id("accordion__panel-6");
    public static final By responsesItem7 = By.id("accordion__panel-7");

    //Текст ответов раздела Вопросы о важном
    public static final String responsesText0 = "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";
    public static final String responsesText1 = "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.";
    public static final String responsesText2 = "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.";
    public static final String responsesText3 = "Только начиная с завтрашнего дня. Но скоро станем расторопнее.";
    public static final String responsesText4 = "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.";
    public static final String responsesText5 = "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.";
    public static final String responsesText6 = "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.";
    public static final String responsesText7 = "Да, обязательно. Всем самокатов! И Москве, и Московской области.";

    //Кнопка - согласие с Куки
    public final By confirmCookieButton = By.id("rcc-confirm-button");

    //Кнопка Заказать, расположенная в хедере главной страницы
    public final By headerOrderButton = By.xpath(".//div[@class='Header_Nav__AGCXC']/button[text()='Заказать']");

    //Кнопка Заказать, расположенная внизу главной страницы
    public final By footerOrderButton = By.xpath(".//div[@class='Home_FinishButton__1_cWm']/button[text()='Заказать']");

    //Кнопка Статус заказа
    public final By orderStatusButton = By.className("Header_Link__1TAG7");

    //Поле ввода номера заказа
    public final By fieldOrderNumber = By.xpath(".//input[@placeholder='Введите номер заказа']");

    //Кнопка Go!
    public final By goButton = By.xpath(".//button[text()='Go!']");


    //<-----МЕТОДЫ КЛАССА MainPage----->
    //Открыть главную страницу и согласиться с Куки
    public void openPage(){
        driver.get(pageURL);
        driver.findElement(confirmCookieButton).click();
    }

    //Общий метод ожидания видимости элемента на странице
    public void visibilityOfElement(By visibleElement){
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(visibleElement));
    }

    //Скрол до определенного пункта с вопросом из раздела Вопросы о важном, клик на данный пункт и ожидание отображения выпадающего элемента
    public void clickQuestionsItem(By questionsItem, By responsesItem){
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(questionsItem));
        driver.findElement(questionsItem).click();
        visibilityOfElement(responsesItem);
    }

    //Получение текста развернутого пункта раздела Вопросы о важном
    public String getTextDropdownsItem(By responsesItem){
        return driver.findElement(responsesItem).getText();
    }

    //Клик на кнопку Заказать, расположенной в хедере Главной страницы
    public void clickHeaderOrderButton(){
        visibilityOfElement(headerOrderButton);
        driver.findElement(headerOrderButton).click();
    }

    //Скрол и клик на кнопку Заказать, расположенной внизу Главной страницы
    public void clickFooterOrderButton(){
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(footerOrderButton));
        visibilityOfElement(footerOrderButton);
        driver.findElement(footerOrderButton).click();
    }

    //Клик на кнопку Статус заказа
    public void clickOrderStatusButton(){
        driver.findElement(orderStatusButton).click();
    }

    //Ввод номера заказа
    public void inputOrderNumber(String orderNumber){
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(fieldOrderNumber));
        driver.findElement(fieldOrderNumber).sendKeys(orderNumber);
    }

    //Клик на кнопку Go!
    public void clickGoButton(){
        driver.findElement(goButton).click();
    }
}