package funds.investment.action;

import com.opensymphony.xwork2.ModelDriven;

import funds.investment.helper.NAVPSRate;
import funds.investment.model.FundBean;

import com.opensymphony.xwork2.ActionSupport;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

@SuppressWarnings({ "serial", "rawtypes" })
public class ComputeFundInvestmentAction extends ActionSupport implements NAVPSRate, ModelDriven {

	private FundBean fund = new FundBean();

	public String execute() {

		double samount = fund.getAmount() * 0.1;
		String fundtype = fund.getFundType();

		switch (fundtype) {
		case "SALEF": {
			fund.setFundType(mSALEF);
			fund.setNavps(SALEF);
			fund.setSlAmount(samount);
			fund.setNetAmount(fund.getAmount() - fund.getSlAmount());
			fund.setTotalShares(fund.getNetAmount() / fund.getNavps());
			break;
		}
		case "SALBF": {
			fund.setFundType(mSALBF);
			fund.setNavps(SALBF);
			fund.setSlAmount(samount);
			fund.setNetAmount(fund.getAmount() - fund.getSlAmount());
			fund.setTotalShares(fund.getNetAmount() / fund.getNavps());
			break;
		}
		case "SALFIF": {
			fund.setFundType(mSALFIF);
			fund.setNavps(SALFIF);
			fund.setSlAmount(samount);
			fund.setNetAmount(fund.getAmount() - fund.getSlAmount());
			fund.setTotalShares(fund.getNetAmount() / fund.getNavps());
			break;
		}
		}

		System.out.println(fund.getNetAmount());
		System.out.println(fund.getTotalShares());

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(fund);
		session.getTransaction().commit();

		return SUCCESS;
	}

	@Override
	public void validate() {
		if (fund.getAmount() < 1000) {
			addFieldError("amount", "Error. Must be Php 1000 or higher.");
		}
	}

	public FundBean getFund() {
		return fund;
	}

	public void setFund(FundBean fund) {
		this.fund = fund;
	}

	@Override
	public FundBean getModel() {
		return fund;
	}

}
