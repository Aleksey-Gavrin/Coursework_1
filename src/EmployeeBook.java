public class EmployeeBook {
    private final Employee[] employees = new Employee[10];

    public EmployeeBook getEmployeeBook() {
        EmployeeBook employees = new EmployeeBook();
        employees.addEmployee("Леонов Мирон Артёмович", 66700, 2);
        employees.addEmployee("Титов Даниил Ильич", 87750, 5);
        employees.addEmployee("Маслов Иван Ильич", 76200, 1);
        employees.addEmployee("Смирнов Максим Матвеевич", 85100, 1);
        employees.addEmployee("Елисеева Милана Марковна", 86000, 3);
        employees.addEmployee("Ушакова Елизавета Семёновна", 91000, 4);
        employees.addEmployee("Колосов Иван Дмитриевич", 92000, 3);
        employees.addEmployee("Лапшин Артемий Тимофеевич", 80400, 2);
        employees.addEmployee("Соловьев Давид Адамович", 54400, 2);
        employees.addEmployee("Анисимова Анастасия Ивановна", 83900, 3);
        return employees;
    }

    public void addEmployee(String fullName, double salary, int department) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                employees[i] = new Employee(fullName, salary, department);
                return;
            }
        }
        System.out.println("Нет места для добавления новых сотрудников");
    }
    public void removeEmployee(String fullName) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                continue;
            }
            if (employees[i].getFullName().equalsIgnoreCase(fullName)) {
                employees[i] = null;
                return;
            }
        }
        System.out.println("Сотрудник не найден");
    }

    public void removeEmployee(int id) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                continue;
            }
            if (employees[i].getId() == id) {
                employees[i] = null;
                return;
            }
        }
        System.out.println("Сотрудник не найден");
    }
    public void  updateEmployee(String fullName, double salary, int department) {
        for (Employee i : employees) {
            if (i == null) {
                continue;
            }
            if (i.getFullName().equalsIgnoreCase(fullName)) {
                i.setSalary(salary);
                i.setDepartment(department);
            }
        }
    }
    public void printAllByDeptmnt() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("*".repeat(20));
            System.out.println("В отделе №" + i + " работают:");
            for (Employee j : employees) {
                if (j != null && j.getDepartment() == i) {
                    System.out.println(j.getFullName());
                }
            }
        }
    }

    public void printAllEmployees() {
        for (Employee i : employees) {
            if (i == null) {
                continue;
            }
            System.out.println(i);
        }
    }

    public void printAllEmployees(int department) {
        for (Employee i : employees) {
            if (i != null && i.getDepartment() == department) {
                System.out.println("Сотрудник: " + i.getFullName() + " (id:" + i.getId() + ") получает " + i.getSalary() +
                        " рублей");
            }
        }
    }

    public double getSumSalaryPerMonth() {
        double sum = 0;
        for (Employee i : employees) {
            if (i == null) {
                continue;
            }
            sum += i.getSalary();
        }
        return sum;
    }

    public double getSumSalaryPerMonth(int department) {
        double sum = 0;
        for (Employee i : employees) {
            if (i != null && i.getDepartment() == department) {
                sum += i.getSalary();
            }
        }
        return sum;
    }

    public Employee getEmployeeWithMinSalary() {
        Employee employeeWithMinSalary = employees[0];
        for (Employee i : employees) {
            if (i == null) {
                continue;
            }
            if (i.getSalary() < employeeWithMinSalary.getSalary()) {
                employeeWithMinSalary = i;
            }
        }
        return employeeWithMinSalary;
    }

    public Employee getEmployeeWithMinSalary(int department) {
        Employee employeeWithMinSalary = null;
        for (Employee i : employees) {
            if (i == null) {
                continue;
            }
            if ((i.getDepartment() == department) && (employeeWithMinSalary == null || i.getSalary() < employeeWithMinSalary.getSalary())) {
                employeeWithMinSalary = i;
            }
        }
        return employeeWithMinSalary;
    }

    public Employee getEmployeeWithMaxSalary() {
        Employee employeeWithMaxSalary = employees[0];
        for (Employee i : employees) {
            if (i == null) {
                continue;
            }
            if (i.getSalary() > employeeWithMaxSalary.getSalary()) {
                employeeWithMaxSalary = i;
            }
        }
        return employeeWithMaxSalary;
    }

    public Employee getEmployeeWithMaxSalary(int department) {
        Employee employeeWithMaxSalary = null;
        for (Employee i : employees) {
            if (i == null) {
                continue;
            }
            if ((i.getDepartment() == department) && (employeeWithMaxSalary == null || employeeWithMaxSalary.getSalary() < i.getSalary())) {
                employeeWithMaxSalary = i;
            }
        }
        return employeeWithMaxSalary;
    }

    public double getAvgSalary() {
        int employeeQty = 0;
        double sumSalary = 0;
        for (Employee i : employees) {
            if (i == null) {
                continue;
            }
            sumSalary += i.getSalary();
            employeeQty++;
        }
        return sumSalary / employeeQty;
    }

    public double getAvgSalary(int department) {
        int employeeQty = 0;
        double sumSalary = 0;
        for (Employee i : employees) {
            if (i == null) {
                continue;
            }
            if (i.getDepartment() == department) {
                sumSalary += i.getSalary();
                employeeQty++;
            }
        }
        return sumSalary / employeeQty;
    }

    public void printAllNames() {
        for (Employee i : employees) {
            if (i == null) {
                continue;
            }
            System.out.println(i.getFullName());
        }
    }

    public void increaseSalary(int percent) {
        for (Employee i : employees) {
            if (i == null) {
                continue;
            }
            i.setSalary(i.getSalary() + i.getSalary() / 100 * percent);
        }
    }

    public void increaseSalaryInDeptmnt(int percent, int department) {
        for (Employee i : employees) {
            if (i == null) {
                continue;
            }
            if (i.getDepartment() == department) {
                i.setSalary(i.getSalary() + i.getSalary() / 100 * percent);
            }
        }
    }
    public void getAllWithSalaryLess(double salary) {
        for (Employee i: employees) {
            if (i == null) {
                continue;
            }
            if (i.getSalary() < salary) {
                System.out.println("Сотрудник: " + i.getFullName() + " (id:" + i.getId() + ") получает " + i.getSalary() +
                        " рублей");
            }
        }
    }
    public void getAllWithSalaryMore(double salary) {
        for (Employee i: employees) {
            if (i == null) {
                continue;
            }
            if (i.getSalary() >= salary) {
                System.out.println("Сотрудник: " + i.getFullName() + " (id:" + i.getId() + ") получает " + i.getSalary() +
                        " рублей");
            }
        }
    }

}
