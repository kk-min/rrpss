package Classes.Staff;

public class Staff {

    public enum JobTitle {
		MANAGER, ASSISTANT_MANAGER, CHIEF_SERVER, SERVER
	};

    private int employeeID;
    private String name;
    private char gender;
    private JobTitle jobTitle;
 
    public Staff(int employeeID, String name, char gender, JobTitle jobTitle) {
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

    public JobTitle getJobTitle() {
        return jobTitle;
    }
}
