package trungfpt.practicaltest.api;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import trungfpt.practicaltest.jpa.Employee;
import trungfpt.practicaltest.repository.EmployeeRepository;

import java.util.NoSuchElementException;


@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping
    public ResponseEntity<Page<Employee>> getAll(Pageable pageable)
    {
        return ResponseEntity.ok(employeeRepository.findAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getById(@PathVariable Integer id)
    {
        try{
            Employee employee = employeeRepository.findById(id).get();
            return new ResponseEntity<Employee>(employee,HttpStatus.OK);

        }catch (NoSuchElementException e)
        {
            return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee)
    {
        try{
            Employee emp = employeeRepository.save(employee);
            return new ResponseEntity<Employee>(employee,HttpStatus.OK);

        }catch (NoSuchElementException e)
        {
            return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Integer id,@RequestBody Employee employee)
    {

        try{
            employeeRepository.findById(id).get();
            employeeRepository.save(employee);
            return new ResponseEntity<Employee>(employee,HttpStatus.OK);
        }catch (NoSuchElementException e)
        {
            return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable Integer id)
    {
        try{
            employeeRepository.deleteById(id);
            return  ResponseEntity.unprocessableEntity().build();
        }catch (NoSuchElementException e)
        {
            return  ResponseEntity.noContent().build();
        }
    }
}
