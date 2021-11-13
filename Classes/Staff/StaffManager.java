package Classes.Staff;

import java.util.ArrayList;
import java.util.Scanner;
/**
 * StaffManager for all the Employees in the resturants
 * @version 1.0
 * @author Herhuey
 */

public class StaffManager {
    
    private static Scanner input = new Scanner(System.in);
    /**
     * ArrayList staffList to store Staff Object 
     */

    private static ArrayList<Staff> staffList = new ArrayList<Staff>();

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

    public static void displayStaffList() {
        System.out.println("Staff List:");
        for (Staff staff : staffList) {
            System.out.printf("%-3s - %-30s %n", staff.getEmployeeID(), staff.getName());
        }
    }
    /**
     * Return the how long is the staffList
     * 
     * @return staffList.size()
     */
    public static int totalStaffNum() {
        return staffList.size();
    }
    /**
     * If the staff ID exist, return Object staff
     * if the staff ID does not exist, return null
     * 
     * @return staff,null
     */

    public static Staff getStaff() {
        displayStaffList();
		System.out.print("Please enter your staff ID: ");
        int staffID = input.nextInt();

		for (Staff staff : staffList) {
            if (staff.getEmployeeID() == staffID) {
                return staff;
            }
        }
        return null;
    }
}
