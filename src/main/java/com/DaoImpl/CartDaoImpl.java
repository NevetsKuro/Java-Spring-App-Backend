package com.DaoImpl;

import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Dao.CartDao;
import com.model.Cart;

@Repository("cartDaoImpl")
@Service
public class CartDaoImpl implements CartDao
{
	@Autowired
	SessionFactory sessionFactory;
	
	public CartDaoImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	public void insertCart(Cart cart){
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		session.persist(cart);
		session.getTransaction().commit();
	}
	
	@SuppressWarnings("unchecked")
	public List<Cart> findByCartID(String username)
	{
		Session session=sessionFactory.openSession();
		List<Cart> cr = null;
		try{
		session.beginTransaction();
		cr = session.createQuery("from Cart where cartUserDetails=:name").setString("name",username).list();
		session.getTransaction().commit();
		}catch(HibernateException e){
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return cr;
	}
	
	public Cart getByCartID(int cartId,String username)
	{
		Session session=sessionFactory.openSession();
		Cart cr = null;
		
		try{
		session.beginTransaction();
		cr = (Cart)session.createQuery("from Cart where cartProductID=:pid and cartUserDetails=:name").setInteger("pid",cartId).setString("name", username).uniqueResult();
		System.out.println("getByCartId method executed");
		session.getTransaction().commit();
		}catch(HibernateException e){
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return cr;
	}
	
	public void deleteCart(int cartId)
	{
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Cart cr = (Cart)session.get(Cart.class,cartId);
		session.delete(cr);
		session.getTransaction().commit();
	}
	
	public void updateCart(Cart cr){
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.update(cr);
		session.getTransaction().commit();
	}
	
	@SuppressWarnings("unchecked")
	public void deleteCartByName(String cartname){
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		List<Cart> cr = (List<Cart>)session.createQuery("from Cart where cartUserDetails=:cartName").setString("cartName",cartname).list();
		for (Cart num : cr) { 		      
			session.delete(num);
		}
		session.getTransaction().commit();
	}
}