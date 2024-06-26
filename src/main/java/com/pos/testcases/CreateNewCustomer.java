package com.pos.testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.framework.testng.api.base.ProjectSpecificMethods;
import com.pos.pages.LoginPage;

public class CreateNewCustomer extends ProjectSpecificMethods{
	
	@BeforeTest
	public void setValues() {
		testcaseName = "CreateNewCustomer";
		testDescription ="Verify The New customer has created";
		authors="Hari";
		category ="Smoke";
		excelFileName="NewCustomer";
	}
	
	@Test(dataProvider = "fetchData")
	public void runLogin(String customerId,String customerName,String customerDescription
			,String customeAddress,String customeMobile,String emailId) {
		System.out.println("Running Testcase : " + "Create New Customer");
		new LoginPage()
		.login()
		.clickCustomersMenu()
		.clickCreateNewButton()
		.enterCustomerId(customerId)
        .enterCustomerName(customerName)
        .enterCustomerDescription(customerDescription)
        .enterCustomerAddress(customeAddress)
        .enterCustomerMobile(customeMobile)
        .enterEmailId(emailId)
        .clickSubmitButton()
        .clickCustomersMenu()
        .enterId(customerId)
        .verifyCustomer(customerId);
	}

}
