public class Main {
    public static void main(String[] args) {
        System.out.println();

        Employee[] employees = new Employee[10];
        employees[0] = new Employee("Леонов Мирон Артёмович",66700, 2);
        employees[1] = new Employee("Титов Даниил Ильич",87750, 5);
        employees[2] = new Employee("Маслов Иван Ильич",76200, 1);
        employees[3] = new Employee("Смирнов Максим Матвеевич",85100, 1);
        employees[4] = new Employee("Елисеева Милана Марковна",86000, 3);
        employees[5] = new Employee("Ушакова Елизавета Семёновна",91000, 4);
        employees[6] = new Employee("Колосов Иван Дмитриевич",92000, 3);
        employees[7] = new Employee("Лапшин Артемий Тимофеевич",80400, 2);
        employees[8] = new Employee("Соловьев Давид Адамович",54400, 2);
        employees[9] = new Employee("Анисимова Анастасия Ивановна",83900, 3);

        printAllEmployees(employees);
        System.out.println();
        System.out.println("Сумма затрат на зарплаты сотрудников за месяц - " + getSumSalaryPerMonth(employees) + " рублей");
        System.out.println();
        System.out.println("Сотрудник с минимальной зарплатой: " + "\n" + getEmployeeWithMinSalary(employees));
        System.out.println("Сотрудник с максимальной зарплатой: " + "\n" + getEmployeeWithMaxSalary(employees));
        System.out.println();
        System.out.println("Среднее значение зарплаты: " + getAvgSalary(employees));
        System.out.println();
        printAllNames(employees);
    }
    public static void printAllEmployees(Employee[] employees) {
        for (Employee i: employees) {
            System.out.println(i);
        }
    }
    public static double getSumSalaryPerMonth(Employee[] employees) {
        double sum = 0;
        for (Employee i: employees) {
            sum += i.getSalary();
        }
        return sum;
    }
    public static Employee getEmployeeWithMinSalary(Employee[] employees) {
        Employee employeeWithMinSalary = employees[0];
        for (Employee i: employees) {
            if (i.getSalary() < employeeWithMinSalary.getSalary()){
                employeeWithMinSalary = i;
            }
        }
        return employeeWithMinSalary;
    }
    public static Employee getEmployeeWithMaxSalary(Employee[] employees) {
        Employee employeeWithMaxSalary = employees[0];
        for (Employee i: employees) {
            if (i.getSalary() > employeeWithMaxSalary.getSalary()){
                employeeWithMaxSalary = i;
            }
        }
        return employeeWithMaxSalary;
    }
    public static double getAvgSalary(Employee[] employees) {
        return getSumSalaryPerMonth(employees) / employees.length;
        }
    public static void printAllNames(Employee[] employees) {
        for (Employee i: employees) {
            System.out.println(i.getFullName());
        }
    }
}