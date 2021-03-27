package country_city;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import country_city.dao.CityDAO;
import country_city.dao.CountryDAO;
import country_city.entities.City;
import country_city.entities.Country;

@Controller
public class CityController {
	@Autowired
	private CityDAO cityDAO;
	@Autowired
	private CountryDAO countryDAO;
	@InitBinder
	public void InitBinder(WebDataBinder data)
	{
		SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
		data.registerCustomEditor(Date.class, new CustomDateEditor(s, true));
	}
	
	@RequestMapping(value = {"/listCity","/"})
	public String listCity(Model model)
	{
		List<City> list = cityDAO.getCities();
		model.addAttribute("list11", list);
		return "listCities";
	}
	
	@RequestMapping("/initInsertCity")
	public String initInsertCity(Model model)
	{
		List<Country> countries =  countryDAO.getCountries();
		model.addAttribute("listCountry",countries);
		
		City c = new City();
		model.addAttribute("c",c);
		return "insertCity";
	}
	
	@RequestMapping("/insertCity")
	public String insertCity(@ModelAttribute("c")City c,Model model)
	{
		boolean bl = cityDAO.insertCirty(c);
		if(bl)
		{
			return "redirect:/listCity";
		}else {
			model.addAttribute("err", "Insert Failed!");
			List<Country> countries =  countryDAO.getCountries();
			model.addAttribute("listCountry",countries);
			
			
			model.addAttribute("c",c);
			return "insertCity";
		}
		
	}
	
	@RequestMapping("/detailCity")
	public String detailCity(@RequestParam("cityId")Integer cityId,Model model)
	{
		City objCity = cityDAO.getCityById(cityId);
		model.addAttribute("c",objCity);
		return "detailCity";
	}
	
	@RequestMapping("/proUpdateCity")
	public String proUpdateCity(@RequestParam("cityId")Integer cityId, Model model)
	{
		City objCity = cityDAO.getCityById(cityId);
		List<Country> listCountry = countryDAO.getCountries();
		
		model.addAttribute("c",objCity);
		model.addAttribute("listCountry",listCountry);
		return "updateCity";
	}
	
	@RequestMapping("/updateCity")
	public String updateCity(@ModelAttribute("c")City c, Model model)
	{
		boolean bl= cityDAO.updateCity(c);
		if(bl)
		{
			return "redirect:/listCity";
		}else {
			model.addAttribute("err", "Update Failed!");
			
			List<Country> listCountry = countryDAO.getCountries();
			
			model.addAttribute("c",c);
			model.addAttribute("listCountry",listCountry);
			return "updateCity";
		}
	}
	
	@RequestMapping("/deleteCity")
	public String deleteCity(@RequestParam("cityId")Integer cityId,Model model) {
		boolean bl =  cityDAO.deleteCity(cityId);
		if(bl) {
			model.addAttribute("success","Delete successfully!");
		}else {
			model.addAttribute("err","Delete failed!");
			
		}
		List<City> list = cityDAO.getCities();
		model.addAttribute("list11", list);
		return "listCities";
	}
}
