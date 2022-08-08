package ru.yandex.uipattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

//POM страницы отслеживания заказа
public class TrackPage {
    WebDriver driver;

    //Конструктор класса TrackPage
    public TrackPage(WebDriver driver) {
        this.driver = driver;
    }

    //URL страницы отслеживания заказа
    public static final String pageURL = "https://qa-scooter.praktikum-services.ru/track";

    //Картинка "Такого заказа нет"
    public final By imgNoSuchOrder = By.xpath(".//img[@alt='Not found']");
}