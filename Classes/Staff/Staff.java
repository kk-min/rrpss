package Classes.Staff;

/**
 Contains information about the employees/staff in the restaurant.
 @author  Her Huey
 @version 1.0
 @since   2021-11-02
 */
public class Staff {
    /**
     * The job title which the staff holds
     * This can be Manager, Assistant Manager, Chief Server, or Server.
     */
    public enum JobTitle {
		MANAGER, ASSISTANT_MANAGER, CHIEF_SERVER, SERVER
	};

    /**
     * ID of the staff.
     */
    private int employeeID;
    /**
     * The name of the staff.
     */
    private String name;
    /**
     * The gender of the staff.
     */
    private char gender;
    /**
     * The job title which the staff holds.
     */
    private JobTitle jobTitle;

    /**
     * Constructor to create staff instances
     * @param employeeID ID assigned to the staff.
     * @param name Name of the staff.
     * @param gender Gender of the staff.
     * @param jobTitle Job title of the staff.
     */
    public Staff(int employeeID, String name, char gender, JobTitle jobTitle) {
        this.employeeID = employeeID;
        this.name = name;
        this.gender = gender;
        this.jobTitle = jobTitle;
    }
    /**
     * Accessor for the ID of the staff.
     * @return ID of the staff.
     */
    public int getEmployeeID() {
        return employeeID;
    }
    /**
     * Accessor for the gender of the staff.
     * @return Name of the staff.
     */
    public String getName() {
        return name;
    }
    /**
     * Accessor for the gender of the staff.
     * @return Gender of the staff.
     */
    public char getGender() {
        return gender;
    }
    /**
     * Accessor for the job title of the staff.
     * @return jobTitle of the staff.
     */
    public JobTitle getJobTitle() {
        return jobTitle;
    }
}
