package demo3.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import demo3.model.Account;

@Repository
public class AccountDao {

	@Autowired
	private SessionFactory sessionfactory;

	public Account findByUserName(String username) {
		Session session = sessionfactory.getCurrentSession();
		String hql = "From Account where username like :username";
		Account ac = session.createQuery(hql, Account.class).setParameter("username", username).uniqueResult();
		return ac;
	}

	public Account findById(int id) {
		Session session = sessionfactory.getCurrentSession();
		return session.get(Account.class, id);
	}

}
