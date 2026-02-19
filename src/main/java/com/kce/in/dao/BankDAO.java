package com.kce.in.dao;



import org.hibernate.Session;

import com.kce.util.HibernateUtil;
import com.kce.in.bean.AccountBean;
import com.kce.in.bean.TransferBean;


public class BankDAO {
	
	public boolean validateAccount(String accountNumber) {
		
	    try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	        AccountBean account = session.get(AccountBean.class, accountNumber);
	        return account != null;
	    } catch (Exception e) {
	        e.printStackTrace();
	        return false;
	    }
	}

	
	public float findBalance(String accountNumber) throws Exception {
		try(Session session =HibernateUtil.getSessionFactory().openSession()) {
			
			if(validateAccount(accountNumber)==false) {
				return -1;
			}
			AccountBean account = session.get(AccountBean.class,accountNumber);
			
			return account.getBalance();
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
			// TODO: handle exception
		}
	}
	
	public boolean transferMoney(TransferBean transferbean) {
		try (Session session =HibernateUtil.getSessionFactory().openSession()){
			session.persist(transferbean);
			
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
			// TODO: handle exception
		}
	}
	
	public boolean updateBalance(String accountNumber,float newBalance) {
		try (Session session =HibernateUtil.getSessionFactory().openSession()){
			AccountBean account = session.get(AccountBean.class, accountNumber);
			account.setBalance((int)newBalance);
			session.merge(account);;
			
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
			// TODO: handle exception
		}
	}
	
}