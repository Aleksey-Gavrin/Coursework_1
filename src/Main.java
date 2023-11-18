public class Main {
    public static void main(String[] args) {
        System.out.println();

        Employee[] employees = new Employee[10];
        employees[0] = new Employee("Леонов Мирон Артёмович", 66700, 2);
        employees[1] = new Employee("Титов Даниил Ильич", 87750, 5);
        employees[2] = new Employee("Маслов Иван Ильич", 76200, 1);
        employees[3] = new Employee("Смирнов Максим Матвеевич", 85100, 1);
        employees[4] = new Employee("Елисеева Милана Марковна", 86000, 3);
        employees[5] = new Employee("Ушакова Елизавета Семёновна", 91000, 4);
        employees[6] = new Employee("Колосов Иван Дмитриевич", 92000, 3);
        employees[7] = new Employee("Лапшин Артемий Тимофеевич", 80400, 2);
        employees[8] = new Employee("Соловьев Давид Адамович", 54400, 2);
        employees[9] = new Employee("Анисимова Анастасия Ивановна", 83900, 3);

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
        System.out.println();
        increaseSalary(employees, 10);
        printAllEmployees(employees);
        System.out.println();
        System.out.println("Сумма затрат на зарплаты сотрудников за месяц по одному отделу - " +
                getSumSalaryPerMonth(employees, 2) + " рублей");
        System.out.println();
        System.out.println("Сотрудник с минимальной зарплатой по одному отделу: " + "\n" +
                getEmployeeWithMinSalary(employees, 2));
        System.out.println("Сотрудник с максимальной зарплатой по одному отделу: " + "\n" +
                getEmployeeWithMaxSalary(employees, 2));
        System.out.println();
        System.out.print("Среднее значение зарплаты по одному отделу: ");
        System.out.printf("%.2f", getAvgSalary(employees, 2));
        System.out.println();
        System.out.println();
        increaseSalaryInDeptmnt(employees, 20, 2);
        System.out.println("Все сотрудники одного отдела:");
        printAllEmployees(employees, 2);
        System.out.println();
        System.out.println("Все сотрудники, получающие зарплату меньше указанной:");
        getAllWithSalaryLess(employees, 90000);
        System.out.println();
        System.out.println("Все сотрудники, получающие зарплату больше указанной:");
        getAllWithSalaryMore(employees, 90000);
    }

    public static void printAllEmployees(Employee[] employees) {
        for (Employee i : employees) {
            System.out.println(i);
        }
    }

    public static void printAllEmployees(Employee[] employees, int department) {
        for (Employee i : employees) {
            if (i.getDepartment() == department) {
                System.out.println("Сотрудник: " + i.getFullName() + " (id:" + i.getId() + ") получает " + i.getSalary() +
                        " рублей");
            }
        }
    }

    public static double getSumSalaryPerMonth(Employee[] employees) {
        double sum = 0;
        for (Employee i : employees) {
            sum += i.getSalary();
        }
        return sum;
    }

    public static double getSumSalaryPerMonth(Employee[] employees, int department) {
        double sum = 0;
        for (Employee i : employees) {
            if (i.getDepartment() == department) {
                sum += i.getSalary();
            }
        }
        return sum;
    }

    public static Employee getEmployeeWithMinSalary(Employee[] employees) {
        Employee employeeWithMinSalary = employees[0];
        for (Employee i : employees) {
            if (i.getSalary() < employeeWithMinSalary.getSalary()) {
                employeeWithMinSalary = i;
            }
        }
        return employeeWithMinSalary;
    }

    public static Employee getEmployeeWithMinSalary(Employee[] employees, int department) {
        Employee employeeWithMinSalary = null;
        for (Employee i : employees) {
            if ((i.getDepartment() == department) && (employeeWithMinSalary == null || i.getSalary() < employeeWithMinSalary.getSalary())) {
                employeeWithMinSalary = i;
            }
        }
        return employeeWithMinSalary;
    }

    public static Employee getEmployeeWithMaxSalary(Employee[] employees) {
        Employee employeeWithMaxSalary = employees[0];
        for (Employee i : employees) {
            if (i.getSalary() > employeeWithMaxSalary.getSalary()) {
                employeeWithMaxSalary = i;
            }
        }
        return employeeWithMaxSalary;
    }

    public static Employee getEmployeeWithMaxSalary(Employee[] employees, int department) {
        Employee employeeWithMaxSalary = null;
        for (Employee i : employees) {
            if ((i.getDepartment() == department) && (employeeWithMaxSalary == null || employeeWithMaxSalary.getSalary() < i.getSalary())) {
                employeeWithMaxSalary = i;
            }
        }
        return employeeWithMaxSalary;
    }

    public static double getAvgSalary(Employee[] employees) {
        return getSumSalaryPerMonth(employees) / employees.length;
    }

    public static double getAvgSalary(Employee[] employees, int department) {
        int employeeQty = 0;
        double sumSalary = 0;
        for (Employee i : employees) {
            if (i.getDepartment() == department) {
                sumSalary += i.getSalary();
                employeeQty++;
            }
        }
        return sumSalary / employeeQty;
    }

    public static void printAllNames(Employee[] employees) {
        for (Employee i : employees) {
            System.out.println(i.getFullName());
        }
    }

    public static void increaseSalary(Employee[] employees, int percent) {
        for (Employee i : employees) {
            i.setSalary(i.getSalary() + i.getSalary() / 100 * percent);
        }
    }

    public static void increaseSalaryInDeptmnt(Employee[] employees, int percent, int department) {
        for (Employee i : employees) {
            if (i.getDepartment() == department) {
                i.setSalary(i.getSalary() + i.getSalary() / 100 * percent);
            }
        }
    }
    public static void getAllWithSalaryLess(Employee[] employees, double salary) {
        for (Employee i: employees) {
            if (i.getSalary() < salary) {
                System.out.println("Сотрудник: " + i.getFullName() + " (id:" + i.getId() + ") получает " + i.getSalary() +
                        " рублей");
            }
        }
    }
    public static void getAllWithSalaryMore(Employee[] employees, double salary) {
        for (Employee i: employees) {
            if (i.getSalary() >= salary) {
                System.out.println("Сотрудник: " + i.getFullName() + " (id:" + i.getId() + ") получает " + i.getSalary() +
                        " рублей");
            }
        }
    }






}