package Classes.Staff;

/**
 * Contains all the detail for Employee in the resturants
 * @version 1.0
 * @author Herhuey
 * 
 */

public class Staff {
     /**
     * enum to show the JobTitle of the resturant's employee
     */

    public enum JobTitle {
		MANAGER, ASSISTANT_MANAGER, CHIEF_SERVER, SERVER
	};

    /**
     * ID of the resturant's employee
     */
    private int employeeID;
    /**
     * name of the resturant's employee
     */
    private String name;
    /**
     * gender of the resturant's employee
     */
    private char gender;
    /**
     * jobTitle of the resturant's employee
     */
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
     * Accessor to Return the employee ID
     * 
     * @return employeeID
     */

    public int getEmployeeID() {
        return employeeID;
    }
    /**
     * Accessors to Return the employee name
     * 
     * @return name
     */

    public String getName() {
        return name;
    }
    /**
     * Accessors to Return the employee gender
     * 
     * @return gender
     */

    public char getGender() {
        return gender;
    }

    /**
     * Accessors to Return the employee jobTitle
     * 
     * @return jobTitle
     */

    public JobTitle getJobTitle() {
        return jobTitle;
    }
}
