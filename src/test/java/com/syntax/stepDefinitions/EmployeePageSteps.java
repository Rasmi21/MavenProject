package com.syntax.stepDefinitions;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import com.syntax.pages.EmployeePage;
import com.syntax.pages.LoginPage;
import com.syntax.utils.BaseClass;
import com.syntax.utils.CommonMethods;


import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;

public class EmployeePageSteps {

	LoginPage login;
	EmployeePage emp;

	String firstName;
	String middleName;
	String lastName;
	String employeeName;

	@Given("^I logged into OrangeHRM$")
	public void i_logged_into_OrangeHRM() {
		login = new LoginPage();
		login.login(BaseClass.prop.getProperty("userName"), BaseClass.prop.getProperty("password"));
		emp = new EmployeePage();
	}

	@Given("^I navigated to the Add Employee Page$")
	public void i_navigated_to_the_Add_Employee_Page() {
		CommonMethods.click(emp.lnkPIM);
		CommonMethods.click(emp.lnkAddEmp);
	}

	@When("^I provide \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\"$")
	public void i_provide_and_and(String firstName, String middleName, String lastName) {
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		CommonMethods.enterValue(emp.firstName, firstName);
		CommonMethods.enterValue(emp.middleName, middleName);
		CommonMethods.enterValue(emp.lastName, lastName);
		CommonMethods.click(emp.btnSave);
	}

	@Then("^I successfully added an employee$")
	public void i_successfully_added_an_employee() {
		String actual = emp.txtName.getText();
		String expected = firstName + " " + middleName + " " + lastName;
		Assert.assertEquals(actual, expected);
	}

	@Given("^I navigated to the Employee List Page$")
	public void i_navigated_to_the_Employee_List_Page() {
		CommonMethods.click(emp.lnkPIM);
		CommonMethods.click(emp.lnkEmpList);
	}

	@When("^I search for employee \"([^\"]*)\"$")
	public void i_search_for_employee(String empName) throws InterruptedException {
		employeeName = empName;
		CommonMethods.sendValueAndEnter(emp.empName, empName);
		CommonMethods.click(emp.btnSearch);
	}

	@When("^I select \"(.*)\"$")
	public void i_select(String empName) {
		CommonMethods.clickWebtableAnyLink(emp.empTable, empName);
	}

	@Then("^I navigated to the employee profile$")
	public void i_navigated_to_the_employee_profile() {
		String name = emp.txtName.getText();
		Assert.assertEquals(name, employeeName);
	}

	@Then("^I can edit Employee information$")
	public void i_can_edit_Employee_information(DataTable employeeTable) throws InterruptedException {
		Thread.sleep(5000);
		CommonMethods.click(emp.btnSave);
		List<Map<String, String>> maps = employeeTable.asMaps(String.class, String.class);
		for (Map<String, String> map : maps) {
			CommonMethods.enterValue(emp.driverLic, map.get("driverLicense"));
			CommonMethods.sendValueAndEnter(emp.expDate, map.get("licenseExpDate"));
			CommonMethods.selectDropDown(emp.maritalStatus, map.get("maritalStatus"));
			CommonMethods.sendValueAndEnter(emp.dob, map.get("dob"));
			CommonMethods.selectDropDown(emp.nationality, map.get("nationality"));
			CommonMethods.click(emp.btnSave);
		}
	}
	
	@Then("^I can delete employee$")
	public void i_can_delete_employee() throws InterruptedException {
		CommonMethods.clickWebtableCell(emp.empTable, lastName, 0);
		CommonMethods.click(emp.btnDelete);
		Thread.sleep(5000);
		CommonMethods.click(emp.confDelete);
		Thread.sleep(5000);
	}
}
