package com.boot.springrestjpa.Services;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.boot.springrestjpa.Dao.EmpRepository;
import com.boot.springrestjpa.Model.Emp;

@Service
public class EmpService {

    @Autowired
    private EmpRepository empRepository;

    // Get all Employees from Database........
    public List<Emp> getAllEmployees() {
        return (List<Emp>) this.empRepository.findAll();
    }

    // Get Single Employee by ID
    public Emp getEmployeeById(int id) {
        return this.empRepository.findById(id).orElse(null);
    }

    // Create Employee
    public Emp createEmployee(Emp emp) {
        return this.empRepository.save(emp);
    }

    // Update Employee
    @SuppressWarnings("null")
    public Emp updateEmployee(int id, Emp updatedEmp) {
        Emp emp = this.empRepository.findById(id).orElse(null);
        if (emp!= null ) {
            emp.setName(updatedEmp.getName());
            emp.setCompany(updatedEmp.getCompany());
            emp.setSalary(updatedEmp.getSalary());
        }
        return this.empRepository.save(emp);
    }

    // Delete Employee
    public void deleteEmployee(int id) {
        this.empRepository.deleteById(id);
    }
}
