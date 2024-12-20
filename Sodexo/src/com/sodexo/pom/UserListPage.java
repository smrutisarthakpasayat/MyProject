package com.sodexo.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserListPage {
@FindBy(className = "buttonText")
private WebElement addUserBtn;
@FindBy(id="userDataLightBox")
private WebElement userPopup;
@FindBy(name = "firstName")
private WebElement firstNameTbx;
@FindBy(name = "lastName")
private WebElement lastNameTbx;
@FindBy(name = "email")
private WebElement emailTbx;
@FindBy(name = "username")
private WebElement usernameTbx;
@FindBy(name = "password")
private WebElement passwordTbx;
@FindBy(name = "passwordCopy")
private WebElement passwordCopyTbx;
@FindBy(id="userDataLightBox_commitBtn")
private WebElement createUserBtn;
@FindBy(xpath = "//input[contains(@class,'filterFieldInput')]")
private WebElement searchTbx;
@FindBy(className = "highlightToken")
private WebElement createdUser;
@FindBy(id="userDataLightBox_deleteBtn")
private WebElement deleteUserBtn;
@FindBy(id="noUsersToShowId")
private WebElement noUserMsg;

public UserListPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}
public WebElement getAddUserBtn() {
	return addUserBtn;
}
public WebElement getUserPopup() {
	return userPopup;
}
public WebElement getFirstNameTbx() {
	return firstNameTbx;
}
public WebElement getLastNameTbx() {
	return lastNameTbx;
}
public WebElement getEmailTbx() {
	return emailTbx;
}
public WebElement getUsernameTbx() {
	return usernameTbx;
}
public WebElement getPasswordTbx() {
	return passwordTbx;
}
public WebElement getPasswordCopyTbx() {
	return passwordCopyTbx;
}
public WebElement getCreateUserBtn() {
	return createUserBtn;
}
public WebElement getSearchTbx() {
	return searchTbx;
}
public WebElement getCreatedUser() {
	return createdUser;
}
public WebElement getDeleteUserBtn() {
	return deleteUserBtn;
}
public WebElement getNoUserMsg() {
	return noUserMsg;
}

}
