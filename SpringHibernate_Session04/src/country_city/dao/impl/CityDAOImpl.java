package country_city.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import country_city.dao.CityDAO;
import country_city.entities.City;

@Repository
public class CityDAOImpl implements CityDAO{
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<City> getCities() {
		Session session =  sessionFactory.openSession();
		try {
			session.beginTransaction();
			List list = session.createQuery("from City").list();
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

	@Override
	public boolean insertCirty(City c) {
		Session session =  sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.save(c);
			session.getTransaction().commit();
			session.close();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			session.getTransaction().rollback();
			session.close();
		}finally {
			session.close();
		}
		return false;
	}

	@Override
	public City getCityById(Integer cityId) {
		// TODO Auto-generated method stub
		Session session =  sessionFactory.openSession();
		try {
			session.beginTransaction();
			City c= (City) session.createQuery("from City where cityId = :cityId").setParameter("cityId", cityId).uniqueResult();
			
			session.getTransaction().commit();
			session.close();
			return c;
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

	@Override
	public boolean updateCity(City c) {
		Session session =  sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.update(c);
			session.getTransaction().commit();
			session.close();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			session.getTransaction().rollback();
			session.close();
		}finally {
			session.close();
		}
		return false;
	}

	@Override
	public boolean deleteCity(Integer cityId) {
		Session session =  sessionFactory.openSession();
		try {
			session.beginTransaction();
			int i=  session.createQuery("delete from City where cityId = :cityId").setParameter("cityId", cityId).executeUpdate();
			
			session.getTransaction().commit();
			if(i>0)
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			session.getTransaction().rollback();
			session.close();
		}finally {
			session.close();
		}
		
		return false;
	}

}
