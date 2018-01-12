package com.DaoImpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.Dao.CategoryDao;
import com.model.Category;
import com.model.Product;

@Repository("categoryDaoImpl")
@Service
public class CategoryDaoImpl implements CategoryDao{

	@Autowired
	SessionFactory sessionFactory;
	
	public CategoryDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public void insertCategory(Category category){
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.persist(category);
		session.getTransaction().commit();
	}
	
	@SuppressWarnings("unchecked")
	public List<Category> retrieve(){
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		List<Category> li = (List<Category>)session.createQuery("from Category").list();
		session.getTransaction().commit();;
		return li;
	}
	
	public Category findByCatId(int cid){
		Session session = sessionFactory.openSession();
		Category c= null;
		try {
			session.beginTransaction();
			c = (Category)session.get(Category.class,cid);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			System.out.println(e.getMessage());	 
			session.getTransaction().rollback();
			
		}
		return c;
	}
	
	public void update(Category c)
	{
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.update(c);
		session.getTransaction().commit();
	}
	
	public void deleteCat(int cid)
	{
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		Category c = (Category)session.get(Category.class,cid);
		session.delete(c);
		session.getTransaction().commit();
	}
}
