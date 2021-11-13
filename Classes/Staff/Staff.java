package Classes.Staff;

public class Staff {


    public enum JobTitle {
		MANAGER, ASSISTANT_MANAGER, CHIEF_SERVER, SERVER
	};

    private int employeeID;
    private String name;
    private char gender;
    private JobTitle jobTitle;

    /**
     * Constructor to pass in all required parameters for menu item.
     *
     * @param employeeID          employee's ID.
     * @param name        employee's name.
     * @param gender employee's description.
     * @param jobTitle       employee's jobTitle.
     */
 
    public Staff(int employeeID, String name, char gender, JobTitle jobTitle) {
        this.employeeID = employeeID;
        this.name = name;
        this.gender = gender;
        this.jobTitle = jobTitle;
    }
    /**
     * Return the employee ID
     * 
     * @return employeeID
     */

    public int getEmployeeID() {
        return employeeID;
    }
    /**
     * Return the employee name
     * 
     * @return name
     */

    public String getName() {
        return name;
    }
    /**
     * Return the employee gender
     * 
     * @return gender
     */

    public char getGender() {
        return gender;
    }

    /**
     * Return the employee jobTitle
     * 
     * @return jobTitle
     */

    public JobTitle getJobTitle() {
        return jobTitle;
    }
}
