package edu.ust.iics.payroll.action;

import edu.ust.iics.payroll.helper.TaxPercentage;
import com.opensymphony.xwork2.ActionSupport;
import edu.ust.iics.payroll.model.*;
import com.opensymphony.xwork2.*;
import edu.ust.iics.payroll.utility.DBConnectionUtil;
import java.sql.*;

@SuppressWarnings("serial")
public class ComputePayrollAction extends ActionSupport implements
		TaxPercentage, ModelDriven<EmployeeBean>{
	
	private EmployeeBean employee = new EmployeeBean();
	
	public String execute() {
		employee.setBasicPay((employee.getHours() <= 40) ? employee.getHours() * employee.getPayRate() : (40 * employee.getPayRate()));

		employee.setOvertimePay((employee.getHours() > 40) ? (employee.getHours() - 40) * employee.getPayRate() * 1.5 : 0);

		employee.setGrossPay(employee.getBasicPay() + employee.getOvertimePay());

		if (employee.getGrossPay() < 10000) {
			employee.setWithHoldingTax(employee.getGrossPay() * GPLT10K);
		} else if (employee.getGrossPay() < 18000) {
			employee.setWithHoldingTax(employee.getGrossPay() * GPLT18K);
		} else if (employee.getGrossPay() < 22000) {
			employee.setWithHoldingTax(employee.getGrossPay() * GPLT22K);
		} else if (employee.getGrossPay() < 28000) {
			employee.setWithHoldingTax(employee.getGrossPay() * GPLT28K);
		} else if (employee.getGrossPay() < 35000) {
			employee.setWithHoldingTax(employee.getGrossPay() * GPLT35K);
		} else if (employee.getGrossPay() >= 35000) {
			employee.setWithHoldingTax(employee.getGrossPay() * GPGTE35K);
		}

		employee.setNetPay(employee.getGrossPay() - employee.getWithHoldingTax());

		System.out.println("Hours Worked: " + employee.getHours());
		System.out.println("Payrate: Php" + employee.getPayRate());
		System.out.println("Basic Pay: Php" + employee.getBasicPay());
		System.out.println("Overtime Payment: Php" + employee.getOvertimePay());
		System.out.println("Gross Pay: Php" + employee.getGrossPay());
		System.out.println("Withholding Tax: Php" + employee.getWithHoldingTax());
		System.out.println("Net Payment: Php" + employee.getNetPay());

		Connection connection = DBConnectionUtil.getDBConnection();
		employee.insertRecord(connection);
		
		return SUCCESS;
	}

	@Override
	public void validate() {
		if (employee.getLastName().trim().length() == 0) {
			addFieldError("lastName", "Missing entry for last name");
		}
		if (employee.getFirstName().trim().length() == 0) {
			addFieldError("firstName", "Missing entry for first name");
		}
		if (employee.getHours() < 0) {
			addFieldError("hours", "Hours worked must be positive");
		}
		if (employee.getPayRate() <= 0) {
			addFieldError("payRate", "Pay Rate value must be positive");
		}
	}

	public EmployeeBean getEmployee() {
		return employee;
	}

	public void setEmployee(EmployeeBean employee) {
		this.employee = employee;
	}

	@Override
	public EmployeeBean getModel() {
		return employee;
	}
}