package Classes.Printer;

import java.util.Map;

import Classes.AMenuItem.AMenuItem;
import Classes.Order.Order;
import Classes.Staff.StaffManager;
import Classes.SalesRevenueReport.SalesRevenueReport; // Why does this not work

/**
 * Printer class that prints the receipts and Sales Revenue Reports onto the
 * console
 */
public class PrintReceipt {
    /**
     * Prints the receipt for a particular order
     * 
     * @param order The order for whhich to print the receipt
     */
    public static void printInvoice(Order order) {
        String restaurantName = "Happy Chicken Diner";
        Map<AMenuItem, Integer> itemList = order.getItemList();
        double subTotal = order.getSubTotal();
        double grandTotal = order.getGrandTotal();
        int rowLength = 63;
        // Line 1:
        System.out.printf("-".repeat(rowLength));
        System.out.println();
        // Line 2:
        String leftFormat = "%-" + ((rowLength / 2) - (restaurantName.length() / 2)) + "s";
        String rightFormat = "%" + ((rowLength / 2) - (restaurantName.length() / 2)) + "s";
        System.out.format(leftFormat, "|");
        System.out.print(restaurantName);
        System.out.format(rightFormat, "|");
        System.out.println();
        // Line 3:
        System.out.printf("-".repeat(rowLength));
        System.out.println();

        // Info Line:
        String orderIDString = "| Order ID: " + order.getID() + " |";
        String orderIDFormat = "%-" + orderIDString.length() + "s";
        String dateTimeString = "| Date: " + order.getDateTime() + " |";
        String dateTimeFormat = "%" + dateTimeString.length() + "s";
        int midLength = rowLength - orderIDString.length() - dateTimeString.length();
        String tableIDString = " Table ID: " + order.getTableID() + " ";
        String tableIDFormat = "%-" + ((midLength / 2) + (tableIDString.length() / 2)) + "s";
        System.out.format(orderIDFormat, orderIDString);
        System.out.print(" ".repeat((midLength / 2) - tableIDString.length() / 2));
        System.out.format(tableIDFormat, tableIDString);
        System.out.format(dateTimeFormat, dateTimeString);
        System.out.println();

        System.out.printf("-".repeat(rowLength)); // print a ----- row
        System.out.println();

        // Line 4:
        System.out.print("| Item");
        String priceFormat = "%" + (rowLength - 6) + "s";
        System.out.format(priceFormat, "|     Price     |");
        System.out.println();
        // Line 5:
        System.out.printf("-".repeat(rowLength));
        System.out.println();
        // Line 6:
        for (var entry : itemList.entrySet()) {
            AMenuItem item = entry.getKey();
            String itemName = item.getName();
            String leftString = "| " + itemName + " x" + entry.getValue();
            System.out.print(leftString);
            priceFormat = "%" + (rowLength - leftString.length()) + "s";
            String priceString = "|     $" + String.format("%.2f", item.getPrice() * itemList.get(item)) + "     |";
            System.out.format(priceFormat, priceString);
            System.out.println();
        }
        System.out.printf("-".repeat(rowLength));
        System.out.println();
        // Bottom segment:
        String subTotalPrice = "$" + String.format("%.2f", subTotal);
        String totalPrice = "$" + String.format("%.2f", grandTotal);
        String discountRate = Integer.toString((int) (100 * order.getDISCOUNT_RATE())) + "%";
        String taxRate = Integer.toString((int) (100 * order.getTAX_RATE())) + "%";

        String discountFormat = String.format("%" + totalPrice.length() + "s", discountRate);
        String subTotalFormat = String.format("%" + totalPrice.length() + "s", subTotalPrice);
        String totalFormat = String.format("%" + totalPrice.length() + "s", totalPrice);
        String taxFormat = String.format("%" + totalPrice.length() + "s", taxRate);

        String subTotalString = "subTotal: " + subTotalFormat + "    |";
        String discountString = "Discount: " + discountFormat + "    |";
        String taxString = "Tax:      " + taxFormat + "    |";
        String totalString = "Total:    " + totalFormat + "    |";

        String resultFormatter = "%" + (rowLength - 1) + "s";

        System.out.print("|");
        System.out.format(resultFormatter, discountString);
        System.out.println();
        System.out.print("|");
        System.out.format(resultFormatter, subTotalString);
        System.out.println();
        System.out.print("|");
        System.out.format(resultFormatter, taxString);
        System.out.println();
        System.out.print("|");
        System.out.format(resultFormatter, totalString);
        System.out.println();

        System.out.printf("-".repeat(rowLength));
        System.out.println();

    }

    /**
     * Prints the Sales Revenue Report for a particular SalesRevenueReport object
     * 
     * @param report                The Sales Revenue Report that we want to print
     * @param alacarteStatistics    Statistics that detail how much of each alacarte
     *                              items were sold
     * @param promotionalStatistics Statistics that detail how much of each
     *                              promotional items were sold
     * @param alaCarteNames         Array with the list of alacarte item names
     * @param promotionalNames      Array with teh list of promotional item names
     */
    public static void generateReport(String period, String[] alaCarteNames, String[] promotionalNames) {
        SalesRevenueReport report = new SalesRevenueReport(period);
        String Header = "SALES REVENUE REPORT" + " (" + report.getPeriod() + ")";
        int rowLength = 63;
        int count;
        Map<AMenuItem, Integer> alacarteStatistics = report.getAlaCarteStatistics();
        Map<AMenuItem, Integer> promotionalStatistics = report.getPromotionalStatistics();

        // Line 1:
        System.out.printf("-".repeat(rowLength));
        System.out.println();

        // Line 2:
        String leftFormat = "%-" + ((rowLength / 2) - (Header.length() / 2)) + "s";
        String rightFormat;
        if ((report.getPeriod().length()) % 2 == 0) {
            rightFormat = "%" + ((rowLength / 2) - (Header.length() / 2)) + "s";
        } else {
            rightFormat = "%" + ((rowLength / 2) - (Header.length() / 2) + 1) + "s";
        }
        System.out.format(leftFormat, "|");
        System.out.print(Header);
        System.out.format(rightFormat, "|");
        System.out.println();

        // Line 3:
        System.out.printf("-".repeat(rowLength));
        System.out.println();

        // Line 4 and 5:
        String totalStaffString = "| Total Staff: " + StaffManager.totalStaffNum();
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
        System.out.print(Header);
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
        for (var entry : alacarteStatistics.entrySet()) {
            AMenuItem key = entry.getKey();
            String name = key.getName();
            String leftString = "| " + name + ": ";
            System.out.print(leftString);
            count = (int) alacarteStatistics.get(key);
            System.out.print(count);
            rightFormat = "%" + (rowLength - leftString.length() - 1) + "s";
            System.out.format(rightFormat, "|");
            System.out.println();
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

        for (var entry : promotionalStatistics.entrySet()) {
            AMenuItem promotionItem = entry.getKey();
            String name = promotionItem.getName();
            String leftString = "| " + name + ": ";
            System.out.println(leftString);
            count = (int) promotionalStatistics.get(promotionItem);
            System.out.println(count);
            rightFormat = "%" + (rowLength - leftString.length() - 1) + "s";
            System.out.format(rightFormat, "|");
            System.out.println();
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