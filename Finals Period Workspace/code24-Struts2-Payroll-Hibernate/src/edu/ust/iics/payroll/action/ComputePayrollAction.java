package edu.ust.iics.payroll.action;

import edu.ust.iics.payroll.helper.NAVPSRate;
import edu.ust.iics.payroll.model.EmployeeBean;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.ActionSupport;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

@SuppressWarnings({ "serial", "rawtypes" })
public class ComputePayrollAction extends ActionSupport implements NAVPSRate, ModelDriven {

	private EmployeeBean employee = new EmployeeBean();

	public String execute() {

		employee.setBasicPay((employee.getHoursWorked() <= 40) ? employee.getHoursWorked() * employee.getPayRate()
				: 40 * employee.getPayRate());

		employee.setOverTimePay(
				(employee.getHoursWorked() >= 40) ? (employee.getHoursWorked() - 40) * employee.getPayRate() * 1.5 : 0);

		employee.setGrossPay(employee.getBasicPay() + employee.getOverTimePay());

		if (employee.getGrossPay() < 10000) {
			employee.setTaxRate(employee.getGrossPay() * LT10K);
		} else if (employee.getGrossPay() < 15000) {
			employee.setTaxRate(employee.getGrossPay() * LT14K);
		} else if (employee.getGrossPay() < 20000) {
			employee.setTaxRate(employee.getGrossPay() * LT20K);
		} else if (employee.getGrossPay() < 25000) {
			employee.setTaxRate(employee.getGrossPay() * LT25K);
		} else if (employee.getGrossPay() < 30000) {
			employee.setTaxRate(employee.getGrossPay() * LT30K);
		} else if (employee.getGrossPay() < 40000) {
			employee.setTaxRate(employee.getGrossPay() * LT40K);
		} else if (employee.getGrossPay() >= 40000) {
			employee.setTaxRate(employee.getGrossPay() * GTE40K);
		}

		employee.setNetPay(employee.getGrossPay() - employee.getTaxRate());

		System.out.println("Hours Worked: " + employee.getHoursWorked());
		System.out.println("Pay Rate: Php" + employee.getPayRate());
		System.out.println("Basic Pay: Php" + employee.getBasicPay());
		System.out.println("Overtime Pay: Php" + employee.getOverTimePay());
		System.out.println("Gross Pay: Php" + employee.getGrossPay());
		System.out.println("Withholding Tax: Php" + employee.getTaxRate());
		System.out.println("Net Pay: Php" + employee.getNetPay());

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(employee);
		session.getTransaction().commit();
		
		return SUCCESS;
	}

	@Override
	public void validate() {
		if (employee.getLastName().trim().length() == 0) {
			addFieldError("lastName", "Missing entry for last name.");
		}

		if (employee.getFirstName().trim().length() == 0) {
			addFieldError("firstName", "Missing entry for first name.");
		}

		if (employee.getHoursWorked() < 0) {
			addFieldError("hoursWorked", "Hours worked must be positive.");
		}

		if (employee.getPayRate() <= 0) {
			addFieldError("payRate", "Payrate value must be positive.");
		}

	}

	public EmployeeBean getEmployee() {
		return employee;
	}

	public void setEmployee(EmployeeBean employee) {
		this.employee = employee;
	}

	@Override
	public Object getModel() {
		return employee;
	}

}
