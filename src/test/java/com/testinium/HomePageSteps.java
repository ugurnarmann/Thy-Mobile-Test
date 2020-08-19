package com.testinium;

import static com.testinium.Constants.CostantsPage.*;


import java.sql.Time;
import java.util.Date;
import  com.testinium.methods.BaseMethods;


import com.thoughtworks.gauge.Step;

import io.appium.java_client.MobileElement;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class HomePageSteps extends HookImpl {

    BaseMethods bs;

    public void waitElementIsDısplayedId(String  by){
        WebDriverWait wait = new WebDriverWait(appiumDriver,20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(by)));

    }
    @Step({"<by> li elemanı tıkla"})
    public void elementClickById(String by)
    {
        waitElementIsDısplayedId(by);
        MobileElement el3 = (MobileElement) appiumDriver.findElementById(by);
        el3.click();
    }

    public void elementSendKeysById(String by,String value)
    {
        waitElementIsDısplayedId(by);
        MobileElement el3 = (MobileElement) appiumDriver.findElementById(by);
        el3.sendKeys(value);
    }

    public void waitElementIsDısplayedXpath(String  xpath){
        WebDriverWait wait = new WebDriverWait(appiumDriver,20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));

    }
    @Step({"<xpath> li elemanı tıkla"})
    public void elementClickByXpath(String xpath)
    {
        waitElementIsDısplayedXpath(xpath);
        MobileElement el3 = (MobileElement) appiumDriver.findElementByXPath(xpath);
        el3.click();
    }


    @Step({"Giriş Kısmındaki Popupu kapat",})
    public void closePopup(){
        elementClickById(HOMEPAGE_POUOUP);


    }
    @Step({"Bilet Alma Ekranına Giriş Yap"})
    public void openTicket(){
        elementClickById(OPEN_TICKED_BUTTON);

    }
    @Step({"Tek Yöne Bilet Al"})
    public void oneWay(){
        elementClickById(ONE_WAY_BUTTON);

    }
    @Step({"SAW Yönüne Bilet Al"})
    public void sawCheck(){
        elementClickById(TO_FROM_BUTTON);
        elementSendKeysById(TO_SEARCH_AREA,"SAW");
        elementClickByXpath(TO_SELECT_FLY);


    }
    @Step({"ESB Yönüne Bilet Al"})
    public void toESB(){
        elementClickById(GO_FROM_BUTTON);

        elementSendKeysById(GO_SEARCH_AREA,"ESB");

        elementClickByXpath(GO_SELECT_FLY);

    }
    @Step({"Tarih Alanına Giriş Yap"})
    public void inToDate(){
        elementClickById(IN_TO_DATE_BUTTON);

    }
    @Step({"<value> Gün Sonraya Bilet Al"})
    public void goToDay(int value){
        Date now=new Date();

        String goDate=String.valueOf(now.getDate()+value);
        elementClickByXpath("//*[@class='android.widget.TextView' and @text='"+goDate+"']");
        elementClickById(DONE_BUTTON);


    }

    @Step({"Yolcu Sayısını 1 Arttır"})
    public void upperPassengers(){

        elementClickById(UPPER_PASSENGERS_BUTTON);

    }

    @Step({"Uçuş Ara"})
    public void goToDay(){

        elementClickById(SEARCH_BUTTON);


    }
    @Step({"Uçuş Seç"})
    public void goFly(){

        elementClickByXpath(GO_FLY);


    }
    @Step({"Uçuşu Ekonomi Seç"})
    public void goFlyEconomy(){

        elementClickByXpath(ECHONOMY_FLY);


    }
    @Step({"Seçilen Uçuşu Kabul Et"})
    public void goFlyAccept(){

        elementClickById(CONTINUE_BUTTON);
    }

    @Step({"Seçilen Uçuşa Yolcu Ekle"})
    public void goFlyAddPassenger(){

        elementClickById(ADD_PASSENGER_BUTTON);
    }
    @Step({"<value> Değerini <id> alanına gir"})
    public void valueToPut(String value,String id){

        elementSendKeysById(id,value);
    }
    @Step({"Mr alanını seç"})
    public void checkMr(){

        elementClickByXpath(MR_CHECK);
    }




    @Step({"<value> Saniye Kadar Bekle"})
    public void bekle(int value){
        appiumDriver.manage().timeouts().implicitlyWait(value, TimeUnit.SECONDS);



    }



}

