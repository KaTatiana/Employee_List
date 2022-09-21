package proskyEmployeeList;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {
    //private final Employee[] employees=new Employee[10];
    List<Employee> employees = new ArrayList<>();

    public EmployeeService()
    {
    }

    public List<Employee> printAll(){
        return employees;
    }

    public boolean completeCollectionEmployeeBook() {
        employees.add(new Employee("Иван", "Иванов"));
        employees.add(new Employee("Петр", "Иванов"));
        employees.add(new Employee("Петр", "Петров"));
        employees.add(new Employee("Петр", "Семенов"));
        employees.add(new Employee("Петр", "Смирнов"));
        employees.add(new Employee("Петр", "Ларин"));
        employees.add(new Employee("Петр", "Ложкин"));
        employees.add(new Employee("Петр", "Яковлев"));
        employees.add(new Employee("Петр", "Леонов"));
        return false;
    }

    public boolean employeesAdd(String firstName, String lastName){
        Employee addEmployee =new Employee(firstName, lastName);
        if(employees.contains(addEmployee)){
            throw new EmployeeNotFoundException("Сотрудник с таким именем уже существует!");
        }
        return employees.add(new Employee(firstName, lastName));
    }

    public Employee employeeSearch(String firstName, String lastName){
        Employee searchEmployee =new Employee(firstName, lastName);
        if (employees.contains(searchEmployee)){
            return searchEmployee;
        }
        throw new EmployeeNotFoundException("Сотрудник не найден!");
    }

    public boolean employeesRemove(String firstName, String lastName){
        Employee removeEmployee =new Employee(firstName, lastName);
        if(employees.remove(removeEmployee)){
            return true;
        }
        throw new EmployeeNotFoundException("Сотрудник не найден!");
    }


}
