public class Main {
    public static void main(String[] args) {
        System.out.println();

        EmployeeBook employees = new EmployeeBook();
        employees = employees.getEmployeeBook();

        employees.printAllEmployees();
        System.out.println();
        employees.removeEmployee(8);
        employees.removeEmployee("ЛАПШИН Артемий Тимофеевич");
        employees.updateEmployee("СОЛОВЬЕВ Давид Адамович", 54401, 3);
        System.out.println();
        System.out.println("Сумма затрат на зарплаты сотрудников за месяц - " + employees.getSumSalaryPerMonth() + " рублей");
        System.out.println();
        System.out.println("Сотрудник с минимальной зарплатой: " + "\n" + employees.getEmployeeWithMinSalary());
        System.out.println("Сотрудник с максимальной зарплатой: " + "\n" + employees.getEmployeeWithMaxSalary());
        System.out.println();
        System.out.println("Среднее значение зарплаты: " + employees.getAvgSalary());
        System.out.println();
        employees.printAllNames();
        System.out.println();
        employees.increaseSalary(10);
        employees.printAllEmployees();
        System.out.println();
        System.out.println("Сумма затрат на зарплаты сотрудников за месяц по одному отделу - " +
                employees.getSumSalaryPerMonth(2) + " рублей");
        System.out.println();
        System.out.println("Сотрудник с минимальной зарплатой по одному отделу: " + "\n" +
                employees.getEmployeeWithMinSalary(2));
        System.out.println("Сотрудник с максимальной зарплатой по одному отделу: " + "\n" +
                employees.getEmployeeWithMaxSalary(2));
        System.out.println();
        System.out.print("Среднее значение зарплаты по одному отделу: ");
        System.out.printf("%.2f", employees.getAvgSalary(2));
        System.out.println();
        System.out.println();
        employees.increaseSalaryInDeptmnt(20, 2);
        System.out.println("Все сотрудники одного отдела:");
        employees.printAllEmployees(2);
        System.out.println();
        System.out.println("Все сотрудники, получающие зарплату меньше указанной:");
        employees.getAllWithSalaryLess(90000);
        System.out.println();
        System.out.println("Все сотрудники, получающие зарплату больше указанной:");
        employees.getAllWithSalaryMore(90000);
        System.out.println();
        employees.printAllByDeptmnt();





    }
}