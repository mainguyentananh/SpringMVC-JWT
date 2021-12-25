package demo3.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import demo3.model.RefreshToken;

@Repository
public class RefreshTokenDao {

	@Autowired
	private SessionFactory sessionfactory;
	
	
	public void save(RefreshToken rt) {
		Session session = sessionfactory.getCurrentSession();
		session.save(rt);
	}
	
	public RefreshToken findByToken(String refreshtoken){
		Session session = sessionfactory.getCurrentSession();
		String hql = "From RefreshToken where refreshtoken like :refreshtoken";
		RefreshToken rt = session.createQuery(hql,RefreshToken.class)
				.setParameter("refreshtoken", refreshtoken).uniqueResult();
		return rt;
	}
	
	public void delete(RefreshToken rt) {
		Session session = sessionfactory.getCurrentSession();
		session.delete(rt);
	}
	
	
	public RefreshToken finByIdAccount(int id_account) {
		Session session = sessionfactory.getCurrentSession();
		String hql = "From RefreshToken where RT_account.id_account = :id_account";
		RefreshToken rt = session.createQuery(hql,RefreshToken.class)
				.setParameter("id_account", id_account)
				.uniqueResult();
		return rt;
	}
		
}
