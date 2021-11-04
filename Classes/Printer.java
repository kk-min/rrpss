public class Printer{

    public static void printInvoice(Order order){
        String restaurantName = "Happy Chicken Diner";
        MenuItem[] itemList = order.getitemList();
        double subTotal = order.getSubTotal();
        double grandTotal = order.getGrandTotal();
        int rowLength = 63;
        //Line 1:
        System.out.printf("-".repeat(rowLength));
        System.out.println();
        //Line 2:
        String leftFormat = "%-"+((rowLength/2)-(restaurantName.length()/2))+"s";
        String rightFormat = "%"+((rowLength/2)-(restaurantName.length()/2))+"s";
        System.out.format(leftFormat, "|");
        System.out.print(restaurantName);
        System.out.format(rightFormat, "|");
        System.out.println();
        //Line 3:
        System.out.printf("-".repeat(rowLength));
        System.out.println();
        //Line 4:
        System.out.print("| Item");
        String priceFormat = "%"+(rowLength-6)+"s";
        System.out.format(priceFormat, "|     Price    |");
        System.out.println();
        //Line 5:
        System.out.printf("-".repeat(rowLength));
        System.out.println();
        //Line 6:
        for (MenuItem item : itemList){
            String itemName = item.getName();
            String leftString = "| "+itemName;
            System.out.print(leftString);
            priceFormat = "%"+(rowLength-leftString.length())+"s";
            String priceString = "|    $"+Double.toString(item.getPrice())+"    |";
            System.out.format(priceFormat, priceString);
            System.out.println();
        }
        System.out.printf("-".repeat(rowLength));
        System.out.println();
        //Bottom segment:
        String subTotalPrice = "$"+Double.toString(subTotal);
        String totalPrice = "$"+Double.toString(grandTotal);
        String discountRate = Integer.toString((int)(100*DISCOUNT_RATE)) + "%";
        String taxRate = Integer.toString((int)(100*TAX_RATE)) + "%";

        String discountFormat = String.format("%"+totalPrice.length()+"s", discountRate);
        String subTotalFormat = String.format("%"+totalPrice.length()+"s", subTotalPrice);
        String totalFormat = String.format("%"+totalPrice.length()+"s", totalPrice);
        String taxFormat = String.format("%"+totalPrice.length()+"s", taxRate);

        String subTotalString = "subTotal: "+subTotalFormat+"    |";
        String discountString = "Discount: "+discountFormat+"    |";
        String taxString = "Tax:      "+taxFormat+"    |";
        String totalString = "Total:    "+totalFormat+"    |";

        String resultFormatter = "%"+(rowLength-1)+"s";

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

    public static void generateReport(SalesRevenueReport report){
        String Header = "SALES REVENUE REPORT" +" ("+report.getPeriod()+")";
        int rowLength = 63;

        //Line 1:
        System.out.printf("-".repeat(rowLength));
        System.out.println();

        //Line 2:
        String leftFormat = "%-"+((rowLength/2)-(Header.length()/2))+"s";
        String rightFormat = "%"+((rowLength/2)-(Header.length()/2))+"s";
        System.out.format(leftFormat, "|");
        System.out.print(Header);
        System.out.format(rightFormat, "|");
        System.out.println();

        //Line 3:
        System.out.printf("-".repeat(rowLength));
        System.out.println();

        //Line 4 and 5:
        String totalStaffString = "| Total Staff: "+staffList.length;
        System.out.print(totalStaffString);
        System.out.format("%"+(rowLength-totalStaffString.length())+"s", "|");
        System.out.println();
        String totalOrderString = "| Orders fulfilled: "+orderList.length;
        System.out.print(totalOrderString);
        System.out.format("%"+(rowLength-totalOrderString.length())+"s", "|");
        System.out.println();

        //Line 6:
        System.out.printf("-".repeat(rowLength));
        System.out.println();

        //Line 7:
        System.out.print("| Sales Revenue");
        String revenueFormat = "%"+(rowLength-15)+"s";
        String revenueString = "|    $"+report.getTotalRevenue()+"    |";
        System.out.format(revenueFormat, revenueString);
        System.out.println();
        //Line 8:
        System.out.printf("-".repeat(rowLength));
        System.out.println();

        //Line 9:
        System.out.print("| Earnings before income tax");
        String beforeTaxFormat = "%"+(rowLength-28)+"s";
        String beforeTaxString = "|    $"+report.getTotalRevenue()+"    |";
        System.out.format(beforeTaxFormat, beforeTaxString);
        System.out.println();

        //Line 10:
        System.out.printf("-".repeat(rowLength));
        System.out.println();

        //Line 11:

        System.out.println("| Income tax expense");
        String incomeTaxFormat = "%"+(rowLength-20)+"s";
        String incomeTaxString = "|    $"+(report.getTotalRevenue()*(double)(7/107))+"    |";
        System.out.format(incomeTaxFormat, incomeTaxString);
        System.out.println();

        //Line 12:
        System.out.printf("-".repeat(rowLength));
        System.out.println();

        //Line 13:

        System.out.println("| Net income");
        String netIncomeFormat = "%"+(rowLength-12)+"s";
        String netIncomeString = "|    $"+(report.getTotalRevenue()*(double)(100/107))+"    |";
        System.out.format(netIncomeFormat, netIncomeString);
        System.out.println();

        //Line 14:

        System.out.printf("-".repeat(rowLength));
        System.out.println();
    }

}