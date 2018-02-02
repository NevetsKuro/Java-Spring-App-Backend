package com.DaoImpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.Dao.OrdersDao;
import com.model.Orders;

@Repository("ordersDaoImpl")
@Service
public class OrdersDaoImpl implements OrdersDao
{
	@Autowired
	SessionFactory sessionFactory;
	
	public OrdersDaoImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	
	public void insertOrders(Orders orders){
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		session.persist(orders);
		session.getTransaction().commit();
	}
	
	@SuppressWarnings("unchecked")
	public List<Orders> findByCartID(int ordersId,String username)
	{
		Session session=sessionFactory.openSession();
		List<Orders> or = null;
		
		try{
		session.beginTransaction();
		or = (List<Orders>)session.createQuery("from Orders where name=:name and cartProductID=: pid").setString("name",username).setInteger("pid",ordersId).uniqueResult();
		session.getTransaction().commit();
		}catch(HibernateException e){
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return or;
	}
	
	public void deleteOrders(int ordersId)
	{
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Orders or = (Orders)session.get(Orders.class,ordersId);
		session.delete(or);
		session.getTransaction().commit();
	}
	
	public void updateOrders(Orders or){
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.update(or);
		session.getTransaction().commit();
	}

}