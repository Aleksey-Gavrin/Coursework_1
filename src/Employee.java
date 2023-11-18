import java.util.Objects;

public class Employee {
   private final String fullName;
   private double salary;
   private int department;
   private final int id;
   private static int COUNTER = 1;

   public Employee(String fullName, double salary, int department) {
       this.fullName = fullName;
       this.salary = salary;
       this.department = department;
       this.id = COUNTER++;
   }
   public String getFullName() {
       return fullName;
   }
   public double getSalary() {
       return salary;
   }
   public int getDepartment() {
       return department;
   }
   public int getId() {
       return id;
   }
   public void setDepartment(int newDepartment) {
       department = newDepartment;
   }
   public void setSalary(double newSalary) {
       salary = newSalary;
   }
@Override
    public String toString() {
       return "Сотрудник: " + fullName + " (id:" + id + ") работает в отделе №" + department + " и получает " + salary +
               " рублей";
}
@Override
    public boolean equals(Object obj){
       if (this == obj) return true;
       if (obj == null || getClass() != obj.getClass()) return false;
       Employee employee = (Employee) obj;
       return Objects.equals(fullName, employee.fullName) && salary == employee.salary && department == employee.department
            && id == employee.id;
}

    @Override
    public int hashCode() {
        return java.util.Objects.hash(fullName, salary, department, id);
    }
}
