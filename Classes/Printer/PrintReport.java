package Classes.Printer;

import java.util.Map;

import Classes.SalesRevenueReport.SalesRevenueReport;

/**
 * Implements printing functionality for printing the Sales Revenue Report
 * object.
 */
public class PrintReport extends UserInterfacePrinter {
    /**
     * Prints the Sales Revenue Report. If generation failed,Return SalesRevenueReport Object for debugging 
     * @return SalesRevenueReport r with name report 
     */
    public static SalesRevenueReport generateReport() {
        System.out.print("Choose a period to generate the Sales Revenue Report for\n1) Day\n2) Month\n3) Year\nYour Choice: ");
        int choice = input.nextInt();
        input.nextLine();
        String period = "";
        switch (choice) {
        case 1:
            period = "DAY";
            break;
        case 2:
            period = "MONTH";
            break;
        case 3:
        default:
            period = "YEAR";
        }
        SalesRevenueReport report = new Classes.SalesRevenueReport.SalesRevenueReport(period);
        System.out.println("DEBUGGGGGGGGGGG");
        return report;
    }

    /**
     * Prints the Sales Revenue Report for a particular SalesRevenueReport object
     *
     * @param period String variable denoting the time period we are generating the
     *               report for.
     */
    public static void print() {
        SalesRevenueReport report = PrintReport.generateReport();
        Map<Classes.AMenuItem.AMenuItem, Integer> alacarteStatistics = report.getAlaCarteStatistics();
        Map<Classes.AMenuItem.AMenuItem, Integer> promotionalStatistics = report.getPromotionalStatistics();
        String Header = "SALES REVENUE REPORT" + " (" + report.getPeriod() + ")";
        int count;

        // Line 1:
        System.out.printf("-".repeat(rowLength));
        System.out.println();

        // Line 2:
        String leftFormat = "%-" + ((rowLength-Header.length())/2) + "s";
        String rightFormat;
        if ((report.getPeriod().length()) % 2 == 0) {
            rightFormat = "%" + (((rowLength-Header.length())/2)) + "s";
        } else {
            rightFormat = "%" + (((rowLength-Header.length())/2) + 1) + "s";
        }
        System.out.format(leftFormat, "|");
        System.out.print(Header);
        System.out.format(rightFormat, "|");
        System.out.println();

        // Line 3:
        System.out.printf("-".repeat(rowLength));
        System.out.println();

        // Line 4 and 5:
        String totalStaffString = "| Total Staff: " + Classes.Staff.StaffManager.totalStaffNum();
        System.out.print(totalStaffString);
        System.out.format("%" + (rowLength - totalStaffString.length()) + "s", "|");
        System.out.println();
        String totalOrderString = "| Orders fulfilled: " + report.getOrderList().size();
        System.out.print(totalOrderString);
        System.out.format("%" + (rowLength - totalOrderString.length()) + "s", "|");
        System.out.println();

        // Line 6:
        System.out.printf("-".repeat(rowLength));
        System.out.println();

        // Line 7:
        String itemsSoldHeader = "ITEMS SOLD";
        leftFormat = "%-" + ((rowLength / 2) - (itemsSoldHeader.length() / 2)) + "s";
        rightFormat = "%" + ((rowLength / 2) - (itemsSoldHeader.length() / 2) + 1) + "s";
        System.out.format(leftFormat, "|");
        System.out.print(itemsSoldHeader);
        System.out.format(rightFormat, "|");
        System.out.println();

        // Line 8:
        System.out.printf("-".repeat(rowLength));
        System.out.println();

        // Line 9:
        String alacarteHeader = "Ala Carte";
        leftFormat = "%-" + ((rowLength / 2) - (alacarteHeader.length() / 2)) + "s";
        rightFormat = "%" + ((rowLength / 2) - (alacarteHeader.length() / 2)) + "s";
        System.out.format(leftFormat, "|");
        System.out.print(alacarteHeader);
        System.out.format(rightFormat, "|");
        System.out.println();

        // Line 10:
        System.out.print("|");
        System.out.printf(" ".repeat(rowLength - 2));
        System.out.println("|");

        // Item lists:
        if (alacarteStatistics == null) {
            String leftString = "| No Items sold.";
            System.out.print(leftString);
            String formatString = "%" + (rowLength - leftString.length()) + "s";
            System.out.format(formatString, "|");
            System.out.println();
        } else {
            for (var entry : alacarteStatistics.entrySet()) {
                Classes.AMenuItem.AMenuItem key = entry.getKey();
                String name = key.getName();
                String leftString = "| " + name + ": ";
                System.out.print(leftString);
                count = (int) alacarteStatistics.get(key);
                System.out.print(count);
                rightFormat = "%" + (rowLength - leftString.length() - 1) + "s";
                System.out.format(rightFormat, "|");
                System.out.println();
            }
        }

        // Promotional:
        String promotionalHeader = "Promotions";
        leftFormat = "%-" + ((rowLength / 2) - (promotionalHeader.length() / 2)) + "s";
        rightFormat = "%" + ((rowLength / 2) - (promotionalHeader.length() / 2) + 1) + "s";
        System.out.format(leftFormat, "|");
        System.out.print(promotionalHeader);
        System.out.format(rightFormat, "|");
        System.out.println();

        // Line Promotional+1
        System.out.print("|");
        System.out.printf(" ".repeat(rowLength - 2));
        System.out.println("|");

        if (promotionalStatistics == null) {
            String leftString = "| No Items sold.";
            System.out.print(leftString);
            String formatString = "%" + (rowLength - leftString.length()) + "s";
            System.out.format(formatString, "|");
            System.out.println();
        } else {
            for (var entry : promotionalStatistics.entrySet()) {
                Classes.AMenuItem.AMenuItem promotionItem = entry.getKey();
                String name = promotionItem.getName();
                String leftString = "| " + name + ": ";
                System.out.println(leftString);
                count = (int) promotionalStatistics.get(promotionItem);
                System.out.println(count);
                rightFormat = "%" + (rowLength - leftString.length() - 1) + "s";
                System.out.format(rightFormat, "|");
                System.out.println();
            }
        }

        // Line x:
        System.out.printf("-".repeat(rowLength));
        System.out.println();

        // Line x+1:
        System.out.print("| Sales Revenue");
        String revenueFormat = "%" + (rowLength - 15) + "s";
        String revenueString = "|    $" + String.format("%.2f", report.getTotalRevenue()) + "    |";
        System.out.format(revenueFormat, revenueString);
        System.out.println();

        // Line x+2:
        System.out.printf("-".repeat(rowLength));
        System.out.println();

        // Line x+3:
        double earningsBeforeIncomeTax = report.getTotalRevenue();
        System.out.print("| Earnings before income tax");
        String beforeTaxFormat = "%" + (rowLength - 28) + "s";
        String beforeTaxString = "$" + String.format("%.2f", earningsBeforeIncomeTax) + "    |";
        beforeTaxString = String
                .format("|" + " ".repeat(revenueString.length() - beforeTaxString.length() - 1) + beforeTaxString);
        System.out.format(beforeTaxFormat, beforeTaxString);
        System.out.println();

        // Line x+4:
        System.out.printf("-".repeat(rowLength));
        System.out.println();

        // Line x+5:

        System.out.print("| Income tax expense");
        String incomeTaxFormat = "%" + (rowLength - 20) + "s";
        String incomeTaxString = "$" + String.format("%.2f", (earningsBeforeIncomeTax * (double) (7 / 107))) + "    |";
        incomeTaxString = String
                .format("|" + " ".repeat(revenueString.length() - incomeTaxString.length() - 1) + incomeTaxString);
        System.out.format(incomeTaxFormat, incomeTaxString);
        System.out.println();

        // Line x+6:
        System.out.printf("-".repeat(rowLength));
        System.out.println();

        // Line x+7:
        double netIncome = earningsBeforeIncomeTax * (double) (100 / 107);
        System.out.print("| Net income");
        String netIncomeFormat = "%" + (rowLength - 12) + "s";
        String netIncomeString = "$" + String.format("%.2f", netIncome) + "    |";
        netIncomeString = String
                .format("|" + " ".repeat(revenueString.length() - netIncomeString.length() - 1) + netIncomeString);
        System.out.format(netIncomeFormat, netIncomeString);
        System.out.println();
        // Line x+8:
        System.out.printf("-".repeat(rowLength));
        System.out.println();
    }
}
