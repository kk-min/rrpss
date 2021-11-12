package Classes.Staff;

import java.util.ArrayList;
import java.util.Scanner;

public class StaffManager {
    
    private static Scanner input = new Scanner(System.in);

    private static ArrayList<Staff> staffList;

    public StaffManager() {
        staffList = new ArrayList<Staff>();
        initialiseStaffList();
    }

    public static void initialiseStaffList()
	{
		Staff s1 = new Staff(1, "Carl Ryder", 'M', "General Manager");
        Staff s2 = new Staff(2, "Anastazia Murray", 'F', "Assistant Manager");
        Staff s3 = new Staff(3, "Skyla Gilmore", 'F', "Chief Server");
        Staff s4 = new Staff(4, "Darin Wilcox", 'M', "Server");
        Staff s5 = new Staff(5, "Ernie Rosales", 'M', "Server");
        Staff s6 = new Staff(6, "Felicia Hodges", 'F', "Server");
		staffList.add(s1); staffList.add(s2); staffList.add(s3);
        staffList.add(s4); staffList.add(s5); staffList.add(s6);
	}

    public static void displayStaffList() {
        System.out.println("Staff List:");
        for (Staff staff : staffList) {
            System.out.printf("%-9s: %-9s %n", staff.getEmployeeID(), staff.getName());
        }
    }

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
