package proskyEmployeeList;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Service
public class EmployeeService {
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

        Map<String, Employee> employees=new HashMap<>();

        EmployeeService()
        {
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

        public boolean employeeAdd(String name, String patronymic, String surname, int department, double salary){
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
            Employee employee=new Employee(name, patronymic, surname);
            String key=employeeKey(employee);
            return  employees.get(key); //ищет значение по его ключу;
        }
        public boolean employeeRemove(String name, String patronymic, String surname) {
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
        public void employeesFullPrint(){
            employees.keySet().stream().map(key -> employees.get(key).toString()).forEach(System.out::println);
        }
        public void employeesNamePrint(){
            employees.keySet().forEach(System.out::println);
        }
        // Напечатать всех сотрудников отдела (все данные, кроме отдела)
        public void employeesPrint(int numDepartment){
            System.out.println("Список сотрудников отдела "+numDepartment+" :");
            employees.values().stream().filter(value -> value.getDepartment() == numDepartment).map(value -> value.getSurname() + " " + value.getName() + " " + value.getPatronymic() + " " + value.getSalary()).forEach(System.out::println);
        }

        public void employeesSalary(){
            double sumCost=0.0;
            for (Employee value: employees.values()) {
                sumCost += value.getSalary();
            }
            System.out.println("Сумма затрат на зарплаты в месяц : "+sumCost);
        }
        public void employeesAverageSalary(){
            double sumCost=0.0;
            int employeesNumber=0;
            for (Employee value: employees.values()) {
                if (value == null) continue;
                sumCost += value.getSalary();
                employeesNumber++;
            }
            System.out.println("Среднее значение зарплат: "+sumCost/employeesNumber);
        }
        public void employeesMinSalary(){
            double minSalary=Integer.MAX_VALUE;
            String minSalaryEmployeeName="";
            for (Employee value: employees.values()) {
                if (minSalary > value.getSalary()) {
                    minSalary = value.getSalary();
                    minSalaryEmployeeName = value.getSurname() + " " + value.getName() + " " + value.getPatronymic();
                }
            }
            System.out.println("Сотрудник с минимальной зарплатой: "+minSalaryEmployeeName);
        }
        public void employeesMaxSalary(){
            double maxSalary;
            maxSalary = Integer.MIN_VALUE;
            String maxSalaryEmployeeName="";
            for (Employee value: employees.values()) {
                if (maxSalary < value.getSalary()) {
                    maxSalary = value.getSalary();
                    maxSalaryEmployeeName = value.getSurname() + " " + value.getName() + " " + value.getPatronymic();
                }

            }
            System.out.println("Сотрудник с максимальной зарплатой: "+maxSalaryEmployeeName);
        }
        public void employeesSalary(int department){
            double sumCost=0.0;
            for (Employee value: employees.values()) {
                if (department == value.getDepartment()) {
                    sumCost += value.getSalary();
                }
            }
            System.out.println("Сумма затрат на зарплаты в месяц отдела "+ department +": "+sumCost);
        }
        public void employeesAverageSalary(int department){
            double sumCost=0.0;
            int employeesNumber=0;
            for (Employee value: employees.values()) {
                if (department == value.getDepartment()) {
                    sumCost += value.getSalary();
                    employeesNumber++;
                }
            }
            System.out.println("Среднее значение зарплат: "+sumCost/employeesNumber);
        }
        public void employeesMinSalary(int department){
            double minSalary=Integer.MAX_VALUE;
            String minSalaryEmployeeName="";
            for (Employee value: employees.values()) {
                if (department == value.getDepartment()) {
                    if (minSalary > value.getSalary()) {
                        minSalary = value.getSalary();
                        minSalaryEmployeeName = value.getSurname() + " " + value.getName() + " " + value.getPatronymic();
                    }
                }
            }
            System.out.println("Сотрудник с минимальной зарплатой: "+minSalaryEmployeeName);
        }
        public void employeesMaxSalary(int department){
            double maxSalary;
            maxSalary = Integer.MIN_VALUE;
            String maxSalaryEmployeeName="";
            for (Employee value: employees.values()) {
                if (department == value.getDepartment()) {
                    if (maxSalary < value.getSalary()) {
                        maxSalary = value.getSalary();
                        maxSalaryEmployeeName = value.getSurname() + " " + value.getName() + " " + value.getPatronymic();
                    }
                }
            }
            System.out.println("Сотрудник с максимальной зарплатой: "+maxSalaryEmployeeName);
        }
        public void indexingSalary(int department, double increasePercent){
            int indStrDepartment=0;
            int indStrFullEmployee=0;
            for (Employee value: employees.values()) {
                if(value==null) continue;
                if (department == value.getDepartment()) {
                    value.setSalary(value.getSalary() + value.getSalary() * increasePercent / 100);
                    //заголовок для раздела
                    if(indStrDepartment==0) {System.out.println("Индексация зарплаты для сотрудников отдела " + value.getDepartment());}
                    System.out.println(value.getSurname()+" "+value.getName()+" "+value.getPatronymic() +" "+ value.getSalary());
                    indStrDepartment++;
                } else if (department == 0) {
                    value.setSalary(value.getSalary()+value.getSalary() * increasePercent / 100);
                    //заголовок для раздела
                    if(indStrFullEmployee==0) System.out.println("Индексация зарплаты для всех сотрудников");
                    System.out.println(value.getSurname()+" "+value.getName()+" "+value.getPatronymic() +" "+ value.getSalary());
                    indStrFullEmployee++;
                }
            }
        }
        public void employeesMinSalary(double salary) {
            System.out.println("Сотрудники с зарплатой ниже " + salary + " :");
            employees.values().stream().filter(value -> value.getSalary() < salary).map(value -> value.getSurname() + " " + value.getName() + " " + value.getPatronymic() + " " + value.getSalary()).forEach(System.out::println);
        }
        public void employeesMaxSalary(double salary) {
            System.out.println("Сотрудники с зарплатой выше " + salary + " :");
            employees.values().stream().filter(value -> value.getSalary() >= salary).map(value -> value.getSurname() + " " + value.getName() + " " + value.getPatronymic() + " " + value.getSalary()).forEach(System.out::println);
        }
}
