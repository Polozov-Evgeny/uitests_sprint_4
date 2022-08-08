package ru.yandex.uipattern;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//POM Страницы заказа товара
public class OrderPage {

    WebDriver driver;

    //Конструктор класса OrderPage
    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }

    //<-----ПОЛЯ КЛАССА MainPage----->
    //URL страницы оформления заказа
    public static final String pageURL = "https://qa-scooter.praktikum-services.ru/order";

    //Поле Имя в форме "Для кого самокат"
    public final By fieldName = By.xpath(".//input[@placeholder='* Имя']");

    //Поле Фамилия в форме "Для кого самокат"
    public final By fieldLastName = By.xpath(".//input[@placeholder='* Фамилия']");

    //Поле Адрес в форме "Для кого самокат"
    public final By fieldAddress = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");

    //Дроп-даун Станция метро в форме "Для кого самокат"
    public final By dropdownMetro = By.xpath(".//input[@placeholder='* Станция метро']");

    //Поле Телефон в форме "Для кого самокат"
    public final By fieldPhone = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");

    //Кнопка Далее в форме "Для кого самокат"
    public final By nextButton = By.xpath(".//div[@class='Order_NextButton__1_rCA']/button[text()='Далее']");

    //Поле Когда привезти в форме "Про аренду"
    public final By fieldWhenToBring = By.xpath(".//input[@placeholder='* Когда привезти самокат']");

    //Дроп-даун Срок аренды в форме "Про аренду"
    public final By dropdownRentalPeriod = By.xpath(".//div[text()='* Срок аренды']");

    //Чекбокс Цвет самоката "чёрный жемчуг" в форме "Про аренду"
    public static final By checkboxBlackColor = By.id("black");

    //Чекбокс Цвет самоката "серая безысходность" в форме "Про аренду"
    public static final By checkboxGreyColor = By.id("grey");

    //Поле Комментарий в форме "Про аренду"
    public final By fieldComment = By.xpath(".//input[@placeholder='Комментарий для курьера']");

    //Кнопка Заказать в форме "Про аренду"
    public final By totalOrderButton = By.xpath(".//div[@class='Order_Buttons__1xGrp']/button[text()='Заказать']");

    //Кнопка Да в модальном окне "Хотите оформить заказ?"
    public final By yesButton = By.xpath(".//div[@class='Order_Buttons__1xGrp']/button[text()='Да']");

    //Сообщение "Заказ оформлен"
    public final By orderIsProcessed = By.xpath(".//div[@class='Order_ModalHeader__3FDaJ' and text()='Заказ оформлен']");


    //<-----МЕТОДЫ КЛАССА MainPage----->
    //РАЗДЕЛ "Для кого самокат"
    //Заполнение поля Имя
    public void inputName(String name) {
        driver.findElement(fieldName).sendKeys(name);
    }

    //Заполнение поля Фамилия
    public void inputLastName(String lastName) {
        driver.findElement(fieldLastName).sendKeys(lastName);
    }

    //Заполнение поля Адрес
    public void inputAddress(String address) {
        driver.findElement(fieldAddress).sendKeys(address);
    }

    //Заполнение поля Станция метро
    public void inputMetro(String xpathItemMetro) {
        driver.findElement(dropdownMetro).click();
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath(xpathItemMetro)));
        driver.findElement(By.xpath(xpathItemMetro)).click();
    }

    //Заполнение поля Телефон
    public void inputPhone(String phone) {
        driver.findElement(fieldPhone).sendKeys(phone);
    }

    //Клик на кнопку Далее раздела "Для кого самокат"
    public void clickNextButton() {
        driver.findElement(nextButton).click();
    }

    //Общий сценарий раздела "Для кого самокат"
    public void generalScenarioPageForWhomScooter(String name, String lastName, String address, String xpathItemMetro, String phone) {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(nextButton));
        inputName(name);
        inputLastName(lastName);
        inputAddress(address);
        inputMetro(xpathItemMetro);
        inputPhone(phone);
        clickNextButton();
    }

    //РАЗДЕЛ "Про аренду"
    //Выбор Даты доставки
    public void inputWhenToBring(String xpathDate) {
        driver.findElement(fieldWhenToBring).click();
        driver.findElement(By.xpath(xpathDate)).click();
    }

    //Выбор Срока аренды
    public void inputRentalPeriod(String xpathPeriod) {
        driver.findElement(dropdownRentalPeriod).click();
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath(xpathPeriod)));
        driver.findElement(By.xpath(xpathPeriod)).click();
    }

    //Выбор Цвета самоката
    public void clickCheckboxColor(By checkbox) {
        driver.findElement(checkbox).click();
    }

    //Заполнение поле Комментарий
    public void inputComment(String comText) {
        driver.findElement(fieldComment).sendKeys(comText);
    }

    //Клик на кнопку Заказать раздела "Про аренду"
    public void clickTotalOrderButton() {
        driver.findElement(totalOrderButton).click();
    }

    //Общий сценарий раздела "Про аренду"
    public void generalScenarioPageAboutRent(String xpathDate, String xpathPeriod, By checkbox, String comText) {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(totalOrderButton));
        inputWhenToBring(xpathDate);
        inputRentalPeriod(xpathPeriod);
        clickCheckboxColor(checkbox);
        inputComment(comText);
        clickTotalOrderButton();
    }

    //Клик на кнопку Да в модальном окне "Хотите оформить заказ?"
    public void clickYesButton() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(yesButton));
        driver.findElement(yesButton).click();
    }

    //Получение текста сообщения "Заказ оформлен"
    public String getTextOrderIsProcessed() {
        return driver.findElement(orderIsProcessed).getText();
    }
}