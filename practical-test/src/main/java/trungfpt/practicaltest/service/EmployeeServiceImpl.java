package trungfpt.practicaltest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import trungfpt.practicaltest.jpa.Employee;
import trungfpt.practicaltest.repository.EmployeeRepository;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> listEmployee() {
        try{
            List<Employee> list = employeeRepository.findAll();
            return list;
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Employee getEmployeeById(int emp_id) {
        try{
            Employee employee = employeeRepository.findById(emp_id).get();
            return employee;
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean saveEmployee(Employee employee) {
        try{
            employeeRepository.save(employee);
            return true;
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteEmployee(int emp_id) {
        try {
            employeeRepository.deleteById(emp_id);
            return true;
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateEmployee(Employee employee) {
        try{
            employeeRepository.findById(employee.getId()).get();
            employeeRepository.save(employee);
            return true;
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return false;
    }


}
