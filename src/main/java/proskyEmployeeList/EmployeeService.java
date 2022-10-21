package proskyEmployeeList;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Service
public class EmployeeService {


    private final Map<String, Employee> employees=new HashMap<>();

        EmployeeService()
        {
            String [] data = {
                    "Иван,Иванович,Иванов,1,52000",
                    "Петр,Иванович,Иванов,2,62000",
                    "Петр,Иванович,Петров,2,42000",
                    "Петр,Иванович,Семенов,3,92000",
                    "Петр,Иванович,Смирнов,5,72000",
                    "Петр,Иванович,Ларин,4,62000",
                    "Петр,Иванович,Ложкин,3,52000",
                    "Петр,Иванович,Яковлев,2,67000",
                    "Петр,Иванович,Леонов,5,77000"
            };

            Arrays.stream(data).map(datum -> datum.substring(0, datum.length() - 1).split(",")).forEach(result -> {
                Employee employee = new Employee(result[0], result[1], result[2]);
                employee.setDepartment(Integer.parseInt(result[3]));
                employee.setSalary(Double.parseDouble(result[4]));
                employees.put(employeeKey(employee), employee);
            });
        }

        public String employeeKey(Employee employee){
            return employee.getName() + employee.getPatronymic() + employee.getSurname();
        }

        public boolean employeeAdd(String name, String patronymic, String surname, int department, double salary) throws BadRequestException {
            checkEmployeeInput(name,  patronymic,  surname);
            Employee employee=new Employee( name, patronymic, surname);
            employee.setDepartment(department);
            employee.setSalary(salary);
            String key=employeeKey(employee);
            if (employees.containsKey(key)) {
                System.out.println("Сотрудник "+key+ " уже существует!");
                return false;
            }
            employees.put(key, employee);
            System.out.println("Сотрудник "+key+" добавлен");
            return true;
        }
        public Employee searchEmployee(String name, String patronymic, String surname) {
            checkEmployeeInput(name,  patronymic,  surname);
            Employee employee=new Employee(name, patronymic, surname);
            String key=employeeKey(employee);
            return  employees.get(key); //ищет значение по его ключу;
        }
        public boolean employeeRemove(String name, String patronymic, String surname) {
            checkEmployeeInput(name,  patronymic,  surname);
            Employee employee=new Employee(name, patronymic, surname);
            String key=employeeKey(employee);
            if (!employees.containsKey(key)) {
                System.out.println("Сотрудник "+key+ " не существует!");
                return false;
            }
            employees.remove(key); //удаляет значение по его ключу;
            System.out.println("Сотрудник "+name+" "+patronymic+" "+ surname+" успешно удален");
            return true;
        }

    public ArrayList<Employee> getAll() {
        return new ArrayList<>(employees.values());
    }

    public void checkEmployeeInput(String name, String patronymic, String surname){
        if(StringUtils.isEmpty(name)||StringUtils.isEmpty(patronymic)||StringUtils.isEmpty(surname)) {
            throw new BadRequestException();
        }
        if(!StringUtils.isAlpha(name)||!StringUtils.isAlpha(patronymic)||!StringUtils.isAlpha(surname)) {
            throw new BadRequestException();
        }
    }
}
