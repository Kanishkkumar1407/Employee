import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Employee {
    int empNo;
    String empName;
    String joinDate;
    char designationCode;
    String department;
    int basic;
    int hra;
    int it;

    Employee(int empNo, String empName, String joinDate, char designationCode, String department, int basic, int hra, int it) {
        this.empNo = empNo;
        this.empName = empName;
        this.joinDate = joinDate;
        this.designationCode = designationCode;
        this.department = department;
        this.basic = basic;
        this.hra = hra;
        this.it = it;
    }

    int calculateSalary() {
        int da = getDA();
        return basic + hra + da - it;
    }

    int getDA() {
        switch (designationCode) {
            case 'e':
                return 20000;
            case 'c':
                return 32000;
            case 'k':
                return 12000;
            case 'r':
                return 15000;
            case 'm':
                return 40000;
            default:
                return 0;
        }
    }

    @Override
    public String toString() {
        return String.format("Emp No: %d, Emp Name: %s, Department: %s, Designation: %s, Salary: %d",
                empNo, empName, department, getDesignation(), calculateSalary());
    }

    String getDesignation() {
        switch (designationCode) {
            case 'e':
                return "Engineer";
            case 'c':
                return "Consultant";
            case 'k':
                return "Clerk";
            case 'r':
                return "Receptionist";
            case 'm':
                return "Manager";
            default:
                return "Unknown";
        }
    }
}

class Project1 {
    public static void main(String[] args) {
        Employee[] employees = {
            new Employee(1001, "Ashish", "01/04/2009", 'e', "R&D", 20000, 8000, 3000),
            new Employee(1002, "Sushma", "23/08/2012", 'c', "PM", 30000, 12000, 9000),
            new Employee(1003, "Rahul", "12/11/2008", 'k', "Acct", 10000, 8000, 1000),
            new Employee(1004, "Chahat", "29/01/2013", 'r', "Front Desk", 12000, 6000, 2000),
            new Employee(1005, "Ranjan", "16/07/2005", 'm', "Engg", 50000, 20000, 20000),
            new Employee(1006, "Suman", "01/01/2000", 'e', "Manufacturing", 23000, 9000, 4400),
            new Employee(1007, "Tamay", "12/06/2006", 'c', "PM", 29000, 12000, 10000)
        };

        Map<Integer, Employee> employeeMap = new HashMap<>();
        for (Employee emp : employees) {
            employeeMap.put(emp.empNo, emp);
        }

        int empId;
        if (args.length == 1) {
            try {
                empId = Integer.parseInt(args[0]);
            } catch (NumberFormatException e) {
                System.out.println("Invalid employee ID format. Please enter a number.");
                return;
            }
        } else {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Please enter an employee ID: ");
            try {
                empId = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid employee ID format. Please enter a number.");
                scanner.close();
                return;
            }
            scanner.close();
        }

        Employee foundEmployee = employeeMap.get(empId);

        if (foundEmployee != null) {
            System.out.println(foundEmployee);
        } else {
            System.out.printf("There is no employee with empid : %d%n", empId);
        }
    }
}
