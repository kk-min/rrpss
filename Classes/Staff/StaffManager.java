package Classes.Staff;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * The StaffManager Class
 * manages all the Employees in the resturant
 * @author  Her Huey
 * @version 1.0
 * @since   2021-11-01
 */
public class StaffManager {
    /**
     * Scanner object to take in user input
     */
    private static Scanner input = new Scanner(System.in);
    /**
     * The ArrayList to store all Staff Objects
     */
    private static ArrayList<Staff> staffList = new ArrayList<Staff>();

    /**
     * Initialises a list of staff working at the restaurant.
     */
    public static void initialiseStaffList()
	{
		Staff s1 = new Staff(1, "Carl Ryder", 'M', Staff.JobTitle.MANAGER);
        Staff s2 = new Staff(2, "Anastazia Murray", 'F', Staff.JobTitle.ASSISTANT_MANAGER);
        Staff s3 = new Staff(3, "Skyla Gilmore", 'F', Staff.JobTitle.CHIEF_SERVER);
        Staff s4 = new Staff(4, "Darin Wilcox", 'M', Staff.JobTitle.SERVER);
        Staff s5 = new Staff(5, "Ernie Rosales", 'M', Staff.JobTitle.SERVER);
        Staff s6 = new Staff(6, "Felicia Hodges", 'F', Staff.JobTitle.SERVER);
		staffList.add(s1); staffList.add(s2); staffList.add(s3);
        staffList.add(s4); staffList.add(s5); staffList.add(s6);
	}

    /**
     * Prints a list of details of staff working at the restaurant.
     */
    public static void displayStaffList() {
        System.out.println("Staff List:");
        for (Staff staff : staffList) {
            System.out.printf("%-3s - %-30s %n", staff.getEmployeeID(), staff.getName());
        }
    }
    /**
     * Returns the number of staff working at the restaurant based on size of staffList.
     *
     * @return staffList.size() as an integer
     */
    public static int totalStaffNum() {
        return staffList.size();
    }

    /**
     * Returns a Staff based on satff ID.
     *
     * @return Staff object if given staff ID exists
     * @return null if given Staff ID does not exists
     */

    public static Staff getStaff() {
        displayStaffList();
		System.out.print("Please enter your staff ID: ");
        int staffID = input.nextInt(); input.nextLine();

		for (Staff staff : staffList) {
            if (staff.getEmployeeID() == staffID) {
                return staff;
            }
        }
        return null;
    }
}
