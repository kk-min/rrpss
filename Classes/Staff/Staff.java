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
    private int id;
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
     * @param id                  employee's id.
     * @param name                employee's name.
     * @param gender              employee's description.
     * @param jobTitle            employee's jobTitle.
     */
    public Staff(int id, String name, char gender, JobTitle jobTitle) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.jobTitle = jobTitle;
    }
    /**
     * Accessor to return the employee id
     * 
     * @return id
     */
    public int getId() {
        return id;
    }
    /**
     * Accessor to return the employee name
     *
     * @return name
     */
    public String getName() {
        return name;
    }
    /**
     * Accessor to return the employee gender
     *
     * @return gender
     */
    public char getGender() {
        return gender;
    }

    /**
     * Accessor to return the employee jobTitle
     *
     * @return jobTitle
     */
    public JobTitle getJobTitle() {
        return jobTitle;
    }
}
