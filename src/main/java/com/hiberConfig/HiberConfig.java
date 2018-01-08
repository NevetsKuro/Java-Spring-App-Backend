package com.hiberConfig;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.DaoImpl.CategoryDaoImpl;
import com.DaoImpl.ProductDaoImpl;
import com.DaoImpl.SupplierDaoImpl;
import com.DaoImpl.UserDaoImpl;
import com.model.Category;
import com.model.Product;
import com.model.Supplier;
import com.model.User;

@Configuration
@ComponentScan("com")
@EnableTransactionManagement
public class HiberConfig {
	
	@Autowired 
	@Bean(name="datasource")
	public DriverManagerDataSource getH2Data(){
		System.out.println("initialized connection.");
		DriverManagerDataSource dm=new DriverManagerDataSource();
		dm.setDriverClassName("org.h2.Driver");
		dm.setUrl("jdbc:h2:tcp://localhost/~/webby");
		dm.setUsername("sa");
		dm.setPassword("");
		System.out.println("h2 connected");
		return dm;
	}
	
	private Properties getHiber(){
		Properties p=new Properties();
		p.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		p.put("hibernate.hbm2ddl.auto", "update");
		p.put("hibernate.show_sql", "true");
		System.out.println("Tables created");
	
		return p;
	}
	
	@Autowired
	@Bean(name="sessionFactory")
	public SessionFactory getHiberSession(DataSource datasource){
		LocalSessionFactoryBuilder lsfb = new LocalSessionFactoryBuilder(datasource);
		lsfb.addProperties(getHiber());
		lsfb.addAnnotatedClass(User.class); // User class is annotated with @Entity
		lsfb.addAnnotatedClass(Supplier.class);
		lsfb.addAnnotatedClass(Category.class);
		lsfb.addAnnotatedClass(Product.class);
		return lsfb.buildSessionFactory();
		
	}
	
	@Autowired
	@Bean(name="userDaoImpl")
	public UserDaoImpl saveUserData(SessionFactory sf){
		return new UserDaoImpl(sf);
	}
	
	@Autowired
	@Bean(name="categoryDaoImpl")
	public CategoryDaoImpl saveCategoryData(SessionFactory sf){
		return new CategoryDaoImpl(sf);
	}
	
	@Autowired
	@Bean(name="supplierDaoImpl")
	public SupplierDaoImpl saveSupplierData(SessionFactory sf){
		return new SupplierDaoImpl(sf);
	}
	
	@Autowired
	@Bean(name="productDaoImpl")
	public ProductDaoImpl saveProductData(SessionFactory sf){
		return new ProductDaoImpl(sf);
	}
	
	@Autowired
	@Bean(name="trasactionManager")
	public HibernateTransactionManager gettrans(SessionFactory sf){
		HibernateTransactionManager tm = new HibernateTransactionManager(sf);
		return tm;
	}
}
	