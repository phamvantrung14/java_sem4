package country_city.dao;

import java.util.List;

import country_city.entities.City;

public interface CityDAO {
	public List<City> getCities();
	public boolean insertCirty(City c);
	public City getCityById(Integer cityId);
	public boolean updateCity(City c);
	public boolean deleteCity(Integer cityId);
	
}
