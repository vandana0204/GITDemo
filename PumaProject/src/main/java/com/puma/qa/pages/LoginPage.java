package com.puma.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.puma.qa.base.base;


public class LoginPage extends base {
	
	//Page Factory OR Object repository
	
	//@FindBy(css =".menu-utility-user>li>a")
	@FindBy(xpath="//a[contains(text(),'Email Sign Up')]")
	WebElement signinemail;
	@FindBy(css="#email")
	WebElement email;
	@FindBy(xpath="//input[@name='gender' and @value ='Female']")
	WebElement RadioBtnFemale;
	@FindBy(xpath="//input[@name='gender' and @value ='Male']")
	WebElement RadioBtnMale;
	@FindBy(css="#maleSubmit")
	WebElement Submitbtn;
	@FindBy(css="#success>img")
	WebElement signInDialog;
	@FindBy(css=".js-modal-close.close_btn.signup-btn")
	WebElement closeBtn;
	
	

	public LoginPage() {
		
		PageFactory.initElements(driver, this);
	}


	public String ValidateLoginPageTitle() {
		
		return driver.getTitle();
		
	}
	public HomePage LoginCredential(String mail,String gender) {
		
		//click on the link 
		WebDriverWait wait = new WebDriverWait(driver, 100);
		WebElement element= wait.until(ExpectedConditions.elementToBeClickable(signinemail));
		if (signinemail.isDisplayed())
		signinemail.click();
		
		if(email.isEnabled())
		email.sendKeys(mail);
		if(gender.equalsIgnoreCase("Female"))
				RadioBtnFemale.click();
		else if (gender.equalsIgnoreCase(""))
			RadioBtnMale.click();
		Submitbtn.click();
		closeBtn.click();
		
		return new HomePage();
		
	}

}
