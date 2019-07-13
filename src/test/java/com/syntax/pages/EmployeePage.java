package com.syntax.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.syntax.utils.BaseClass;

public class EmployeePage extends BaseClass{
	@FindBy(id="firstName")
	public WebElement firstName;
	
	@FindBy(id="middleName")
	public WebElement middleName;
	
	@FindBy(id="lastName")
	public WebElement lastName;
	
	@FindBy(id="btnSave")
	public WebElement btnSave;
	
	@FindBy(id="chkLogin")
	public WebElement chxLoginDetails;
	
	@FindBy(id="user_name")
	public WebElement userName;
	
	@FindBy(id="user_password")
	public WebElement password;
	
	@FindBy(id="re_password")
	public WebElement confPwd;
	
	@FindBy(linkText="PIM")
	public WebElement lnkPIM;
	
	@FindBy(linkText="Add Employee")
	public WebElement lnkAddEmp;
	
	@FindBy(linkText="Employee List")
	public WebElement lnkEmpList;
	
	@FindBy(id="profile-pic")
	public WebElement txtName;
	
	@FindBy(id="empsearch_employee_name_empName")
	public WebElement empName;
	
	@FindBy(id="btnDelete")
	public WebElement btnDelete;
	
	@FindBy(id="searchBtn")
	public WebElement btnSearch;
	
	@FindBy(id="dialogDeleteBtn")
	public WebElement confDelete;
	
	@FindBy(id="resultTable")
	public WebElement empTable;
	
	@FindBy(id="personal_txtLicenNo")
	public WebElement driverLic;
	
	@FindBy(id="personal_txtLicExpDate")
	public WebElement expDate;
	
	@FindBy(id="personal_cmbMarital")
	public WebElement maritalStatus;
	
	@FindBy(id="personal_cmbNation")
	public WebElement nationality;
	
	@FindBy(id="personal_DOB")
	public WebElement dob;

	public EmployeePage() {
		PageFactory.initElements(driver, this);
	}
}
