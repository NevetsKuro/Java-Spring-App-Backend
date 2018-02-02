package com.DaoImpl;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.Dao.UserDao;
import com.model.User;

@Repository("userDaoImpl")
public class UserDaoImpl implements UserDao {

	@Autowired
	SessionFactory sessionFactory;
	
	@Autowired
	public UserDaoImpl(SessionFactory sessionFactory){
		super();
		this.sessionFactory = sessionFactory;
	}
	
	@Transactional
	public void insertUser(User user){
		Session session=sessionFactory.openSession();
		
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
	}
	
	public User findUserByName(String implname){
		Session session=sessionFactory.openSession();
		User u = null;
		try{
		session.beginTransaction();
		System.out.println(implname);
		u = (User)session.get(User.class,implname);
		session.getTransaction().commit();
		}catch (HibernateException e) {
			e.printStackTrace();
			System.out.println("transaction unsuccessful UserDetails");
		}
		return u;
	}
	
}
