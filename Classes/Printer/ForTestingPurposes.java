package Classes.Printer;
import java.util.Hashtable;

public class ForTestingPurposes {
    /**
     * For testing program main
     * @param args
     */
    public static void main(String args[]) {

        //Print Receipt:
        int i;
        double TAX_RATE = 0.07;
        double DISCOUNT_RATE = 0.05;
        String restaurantName = "Happy Chicken Diner";
        //MenuItem[] itemList = order.getitemList();
        double subTotal = 5300.21;
        double grandTotal = 5400.50;
        int rowLength = 63;


        //Line 1:
        System.out.printf("-".repeat(rowLength)); // print a ----- row
        System.out.println();
        //Line 2:
        String leftFormat = "%-"+((rowLength/2)-(restaurantName.length()/2))+"s";
        String rightFormat = "%"+((rowLength/2)-(restaurantName.length()/2))+"s";
        System.out.format(leftFormat, "|");
        System.out.print(restaurantName);
        System.out.format(rightFormat, "|");
        System.out.println();
        //Line 3:
        System.out.printf("-".repeat(rowLength)); // print a ----- row
        System.out.println();

        // Info Line:
        String orderIDString = "| Order ID: "+12345+" |";
        String orderIDFormat = "%-"+orderIDString.length()+"s";
        String dateTimeString = "| Date: "+"03/12/2021"+" |";
        String dateTimeFormat = "%"+dateTimeString.length()+"s";
        int midLength = rowLength-orderIDString.length()-dateTimeString.length();
        String tableIDString = " Table ID: "+"12"+" ";
        String tableIDFormat = "%-"+((midLength/2)+(tableIDString.length()/2))+"s";
        System.out.format(orderIDFormat, orderIDString);
        System.out.print(" ".repeat((midLength/2)-tableIDString.length()/2));
        System.out.format(tableIDFormat, tableIDString);
        System.out.format(dateTimeFormat, dateTimeString);
        System.out.println();

        System.out.printf("-".repeat(rowLength)); // print a ----- row
        System.out.println();



        //Line 4:
        System.out.print("| Item");
        String priceFormat = "%"+(rowLength-6)+"s";
        System.out.format(priceFormat, "|     Price     |");
        System.out.println();
        //Line 5:
        System.out.printf("-".repeat(rowLength)); // print a ----- row
        System.out.println();
        //Line 6:
        for (i=0;i<10;i++){
            String itemName = "Chicken Rice";
            String leftString = "| "+itemName;
            System.out.print(leftString);
            priceFormat = "%"+(rowLength-leftString.length())+"s";
            String priceString = "|     $"+String.format("%.2f",(5.60))+"     |";
            System.out.format(priceFormat, priceString);
            System.out.println();
        }
        System.out.printf("-".repeat(rowLength)); // print a ----- row
        System.out.println();
        //Bottom segment:
        String subTotalPrice = "$"+String.format("%.2f",subTotal);
        String totalPrice = "$"+String.format("%.2f",grandTotal);
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

        System.out.printf("-".repeat(rowLength)); // print a ----- row
        System.out.println();

        //----------------------------------------------------------------------------------------------------------
        //Print SalesRevenueReport:

        String[] staffList = {"John", "Jane", "Mike", "Alice", "Bob"};
        String[] alaCarteNames = {"Chicken Rice", "Soda", "Pizza", "Juice"};
        String[] promotionalNames = {"Double Dessert Deluxe", "Pizza Wombo Combo", "2 in 1 Ice-cream"};
        Hashtable<String, Integer> alaCarteStatistics = new Hashtable<>();
        Hashtable<String, Integer> promotionalStatistics = new Hashtable<>();
        for (int j = 0; j < alaCarteNames.length; j++) {
            alaCarteStatistics.put(alaCarteNames[j], j+1);
        }
        for (int j = 0; j < promotionalNames.length; j++) {
            promotionalStatistics.put(promotionalNames[j], j+1);
        }

        String SalesHeader = "SALES REVENUE REPORT" +" (MONTHLY)";
        int count;

        //Line 1:
        System.out.printf("-".repeat(rowLength));
        System.out.println();

        //Line 2:
        leftFormat = "%-"+((rowLength/2)-(SalesHeader.length()/2))+"s";
        rightFormat = "%"+((rowLength/2)-(SalesHeader.length()/2)+1)+"s";
        System.out.format(leftFormat, "|");
        System.out.print(SalesHeader);
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
        String totalOrderString = "| Orders fulfilled: "+10;
        System.out.print(totalOrderString);
        System.out.format("%"+(rowLength-totalOrderString.length())+"s", "|");
        System.out.println();

        //Line 6:
        System.out.printf("-".repeat(rowLength));
        System.out.println();

        //Line 7:
        String itemsSoldHeader = "ITEMS SOLD";
        leftFormat = "%-"+((rowLength/2)-(itemsSoldHeader.length()/2))+"s";
        rightFormat = "%"+((rowLength/2)-(itemsSoldHeader.length()/2)+1)+"s";
        System.out.format(leftFormat, "|");
        System.out.print(itemsSoldHeader);
        System.out.format(rightFormat, "|");
        System.out.println();

        //Line 8:
        System.out.printf("-".repeat(rowLength));
        System.out.println();

        //Line 9:
        String alacarteHeader = "Ala Carte";
        leftFormat = "%-"+((rowLength/2)-(alacarteHeader.length()/2))+"s";
        rightFormat = "%"+((rowLength/2)-(alacarteHeader.length()/2))+"s";
        System.out.format(leftFormat, "|");
        System.out.print(alacarteHeader);
        System.out.format(rightFormat, "|");
        System.out.println();

        //Line 10:
        System.out.print("|");
        System.out.printf(" ".repeat(rowLength-2));
        System.out.println("|");
        //Item lists:
        for (String name : alaCarteNames){
            String leftString = "| "+name+": ";
            System.out.print(leftString);
            count = (int) alaCarteStatistics.get(name);
            System.out.print(count);
            rightFormat = "%"+(rowLength-leftString.length()-1)+"s";
            System.out.format(rightFormat, "|");
            System.out.println();
        }

        //Promotional:
        String promotionalHeader = "Promotions";
        leftFormat = "%-"+((rowLength/2)-(promotionalHeader.length()/2))+"s";
        rightFormat = "%"+((rowLength/2)-(promotionalHeader.length()/2)+1)+"s";
        System.out.format(leftFormat, "|");
        System.out.print(promotionalHeader);
        System.out.format(rightFormat, "|");
        System.out.println();

        //Line Promotional+1
        System.out.print("|");
        System.out.printf(" ".repeat(rowLength-2));
        System.out.println("|");

        for (String name : promotionalNames){
            String leftString = "| "+name+": ";
            System.out.print(leftString);
            count = (int) promotionalStatistics.get(name);
            System.out.print(count);
            rightFormat = "%"+(rowLength-leftString.length()-1)+"s";
            System.out.format(rightFormat, "|");
            System.out.println();
        }

        //Line x:
        System.out.printf("-".repeat(rowLength));
        System.out.println();

        //Line x+1:
        System.out.print("| Sales Revenue");
        String revenueFormat = "%"+(rowLength-15)+"s";
        String revenueString = "|    $"+String.format("%.2f",105698.58)+"    |";
        System.out.format(revenueFormat, revenueString);
        System.out.println();
        //Line x+2:
        System.out.printf("-".repeat(rowLength));
        System.out.println();

        //Line x+3:
        System.out.print("| Earnings before income tax");
        String beforeTaxFormat = "%"+(rowLength-28)+"s";
        String beforeTaxString = "$"+String.format("%.2f",90543.53)+"    |";
        beforeTaxString = String.format("|"+" ".repeat(revenueString.length()-beforeTaxString.length()-1)+beforeTaxString);
        System.out.format(beforeTaxFormat, beforeTaxString);
        System.out.println();

        //Line x+4:
        System.out.printf("-".repeat(rowLength));
        System.out.println();

        //Line x+5:
        System.out.print("| Income tax expense");
        String incomeTaxFormat = "%"+(rowLength-20)+"s";
        String incomeTaxString = "$"+String.format("%.2f",(105698.58*(double)(7/107)))+"    |";
        incomeTaxString = String.format("|"+" ".repeat(revenueString.length()-incomeTaxString.length()-1)+incomeTaxString);
        System.out.format(incomeTaxFormat, incomeTaxString);
        System.out.println();

        //Line x+6:
        System.out.printf("-".repeat(rowLength));
        System.out.println();

        //Line x+7:
        System.out.print("| Net income");
        String netIncomeFormat = "%"+(rowLength-12)+"s";
        String netIncomeString = "$"+String.format("%.2f",(105698.58*(double)(100/107)))+"    |";
        netIncomeString = String.format("|"+" ".repeat(revenueString.length()-netIncomeString.length()-1)+netIncomeString);
        System.out.format(netIncomeFormat, netIncomeString);
        System.out.println();

        //Line x+8:
        System.out.printf("-".repeat(rowLength));
        System.out.println();
    }
}