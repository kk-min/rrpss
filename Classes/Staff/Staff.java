package Classes.Staff;
public class Staff {
    private int employeeID;
    private String name;
    private char gender;
    private String jobTitle;
 
    public Staff(int employeeID, String name, char gender, String jobTitle) {
        this.employeeID = employeeID;
        this.name = name;
        this.gender = gender;
        this.jobTitle = jobTitle;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public String getName() {
        return name;
    }

    public char getGender() {
        return gender;
    }

    public String getJobTitle() {
        return jobTitle;
    }
}
