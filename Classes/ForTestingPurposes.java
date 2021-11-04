public class MyClass {

    public static void main(String args[]) {
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
        //Line 4:
        System.out.print("| Item");
        String priceFormat = "%"+(rowLength-6)+"s";
        System.out.format(priceFormat, "|     Price    |");
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
            String priceString = "|    $"+String.format("%.2f",(5.60))+"    |";
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
        System.out.format(resultFormatter, AtaxString);
        System.out.println();
        System.out.print("|");
        System.out.format(resultFormatter, totalString);
        System.out.println();

        System.out.printf("-".repeat(rowLength)); // print a ----- row
        System.out.println();
    }
}