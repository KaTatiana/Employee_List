package proskyEmployeeList;
public class Employee {
    private final String name;
    private final String patronymic;
    private final String surname;
    private int department;
    private double salary;

    public Employee(String name, String patronymic, String surname) {
        this.name = name;
        this.patronymic=patronymic;
        this.surname = surname;
        this.department = 0;
        this.salary = 0;
    }

    public Employee() {
        this.name = "";
        this.patronymic = "";
        this.surname = "";
        this.department = 0;
        this.salary = 0;
    }

    public String getName() { return name; }
    public String getPatronymic() { return patronymic; }
    public String getSurname() { return surname; }
    public int getDepartment() { return department; }
    public double getSalary() { return salary; }

    public void setSalary(double salary){
        this.salary = salary;
    }
    public void setDepartment(int department){
        this.department = department;
    }
    public String toString() {
        return surname + " " + name + " " + patronymic + " " + " " + department + " " +salary;
    }
}
