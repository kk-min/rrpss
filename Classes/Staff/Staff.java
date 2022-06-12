package Classes.Staff;

/**
 * The Staff Class
 * Contains all the details for an employee (Staff) working in the resturant
 * @author  Her Huey
 * @version 1.0
 * @since   2021-11-01
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
    private int ID;
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
     * @param ID                  employee's ID.
     * @param name                employee's name.
     * @param gender              employee's description.
     * @param jobTitle            employee's jobTitle.
     */
    public Staff(int ID, String name, char gender, JobTitle jobTitle) {
        this.ID = ID;
        this.name = name;
        this.gender = gender;
        this.jobTitle = jobTitle;
    }
    /**
     * Accessor to Return the employee ID
     * 
     * @return ID
     */
    public int getID() {
        return ID;
    }
    /**
     * Accessor to Return the employee name
     *
     * @return name
     */
    public String getName() {
        return name;
    }
    /**
     * Accessor to Return the employee gender
     *
     * @return gender
     */
    public char getGender() {
        return gender;
    }

    /**
     * Accessor to Return the employee jobTitle
     *
     * @return jobTitle
     */
    public JobTitle getJobTitle() {
        return jobTitle;
    }
}
