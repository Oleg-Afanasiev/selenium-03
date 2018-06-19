package com.academy.automation.practice.ddt.manager.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class AddressPage extends BasePage {

    @FindBy(css="#center_column > div.addresses ul > li:nth-child(1) > h3")
    private List<WebElement> addressAliasElements;

    @FindBy(css="#center_column > div.clearfix.main-page-indent > a")
    private WebElement addNewAddressButton;

    @FindBy(css="#center_column > div.addresses   ul > li:nth-child(2) > span:nth-child(1)")
    private List<WebElement> firstNameElements;

    @FindBy(css="#center_column > div.addresses   ul > li:nth-child(2) > span:nth-child(2)")
    private List<WebElement> lastNameElements;

    @FindBy(css="#center_column > div.addresses > div  ul > li:nth-child(4) > span.address_address1")
    private List<WebElement> addressElements;

    @FindBy(css="#center_column > div.addresses > div  ul > li:nth-child(5) > span:nth-child(1)")
    private List<WebElement> cityElements;

    @FindBy(css="#center_column > div.addresses > div  ul > li:nth-child(5) > span:nth-child(2)")
    private List<WebElement> stateElements;

    @FindBy(css="#center_column > div.addresses > div  ul > li:nth-child(5) > span:nth-child(3)")
    private List<WebElement> zipCodeElements;

    @FindBy(css="#center_column > div.addresses > div  ul > li:nth-child(6) > span")
    private List<WebElement> countryElements;

    @FindBy(css="#center_column > div.addresses > div  ul > li:nth-child(7) > span")
    private List<WebElement> homePhoneElements;

    @FindBy(css="#center_column > div.addresses > div ul > li:nth-child(8) > span")
    private List<WebElement> mobilePhoneElements;

    private String deleteAddressByAliasXPath = "//div[@id='center_column']/div[@class='addresses']//ul[li/h3[text()='%s']]//li[last()]/a[2]";

    public AddressPage(WebDriver driver) {
        super(driver);
    }

    private WebElement findDeleteButtonByAlias(String alias) {
        return driver.findElement(By.xpath(String.format(deleteAddressByAliasXPath, alias.trim())));
    }

    public List<String> getAliases() {
        return extractTextFromElements(addressAliasElements);
    }

    public AddressPage clickDeleteButton(String alias) {
        findDeleteButtonByAlias(alias).click();
        return new AddressPage(driver);
    }

    public AddressPage acceptDeletion() {
        driver.switchTo().alert().accept();
        return new AddressPage(driver);
    }

    public FormAddressPage clickByAddNewAddress() {
        addNewAddressButton.click();
        return new FormAddressPage(driver);
    }

    public List<String> getFirstNameList() {
        return extractTextFromElements(firstNameElements);
    }

    public List<String> getLastNameList() {
        return extractTextFromElements(lastNameElements);
    }

    public List<String> getAddressList() {
        return extractTextFromElements(addressElements);
    }

    public List<String> getCityList() {
        return extractTextFromElements(cityElements);
    }

    public List<String> getStateList() {
        return extractTextFromElements(stateElements);
    }

    public List<String> getZipCodeList() {
        return extractTextFromElements(zipCodeElements);
    }

    public List<String> getCountryList() {
        return extractTextFromElements(countryElements);
    }

    public List<String> getHomePhoneList() {
        return extractTextFromElements(homePhoneElements);
    }

    public List<String> getMobilePhoneList() {
        return extractTextFromElements(mobilePhoneElements);
    }

    public List<String> getAddressAliasList() {
        return extractTextFromElements(addressAliasElements);
    }
}
