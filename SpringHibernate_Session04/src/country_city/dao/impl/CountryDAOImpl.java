package country_city.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import country_city.dao.CountryDAO;
import country_city.entities.Country;
@Repository
public class CountryDAOImpl implements CountryDAO{
	@Autowired
	private SessionFactory sessionFactory;
	@Override
	public List<Country> getCountries() {
		Session session =  sessionFactory.openSession();
		try {
			session.beginTransaction();
			List list = session.createQuery("from Country").list();
			session.getTransaction().commit();
			session.close();
			return list;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			session.getTransaction().rollback();
			session.close();
		}finally {
			session.close();
		}
		return null;
	}

}
