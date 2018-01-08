package com.DaoImpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.Dao.SupplierDao;
import com.model.Supplier;

@Repository("supplierDaoImpl")
@Service
public class SupplierDaoImpl implements SupplierDao {

	@Autowired
	SessionFactory sessionFactory;
	
	@Autowired
	public SupplierDaoImpl(SessionFactory sessionFactory){
		this.sessionFactory=sessionFactory;
	}
	
	public void insertSupplier(Supplier supplier){
		
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.persist(supplier);
		session.getTransaction().commit();
		
	}
	
	@SuppressWarnings("unchecked")
	public List<Supplier> retrieve(){
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		List<Supplier> li = session.createQuery("from Supplier").list();
		session.getTransaction().commit();;
		return li;
	}
	
	public Supplier findBySuppId(int sid){
		Session session = sessionFactory.openSession();
		Supplier s= null;
		try {
			session.beginTransaction();
			s = (Supplier)session.get(Supplier.class,sid);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return s;
	}
}
