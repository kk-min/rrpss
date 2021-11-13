package Printer;
import Classes.Order.Order;

public class PrintOrderSummary implements Printer{
    public static void print(Order viewOrder){
        int rowLength = 63;

        //Line 1:
        System.out.printf("-".repeat(rowLength));
        System.out.println();

        //Line 2:
        String orderSummary = "ORDER SUMMARY";
        String leftFormat = "%-"+((rowLength/2)-(orderSummary.length()/2))+"s";
        String rightFormat = "%"+((rowLength/2)-(orderSummary.length()/2))+"s";
        System.out.format(leftFormat, " ");
        System.out.print(orderSummary);
        System.out.format(rightFormat, " ");
        System.out.println();

        //Line 3:
        System.out.printf("-".repeat(rowLength));
        System.out.println();

        //Line 4:
        String OrderNo = "Order no. "+viewOrder.getID();
        System.out.println(OrderNo);

        //Line 5:
        String tableFormat = String.format("%"+(OrderNo.length()-8)+"s");
        System.out.print("Table ID");
        System.out.format(tableFormat, viewOrder.getTableID());

        //Line 6:
        System.out.printf("-".repeat(rowLength));
        System.out.println();

        //Items:
        for (var entry : viewOrder.getItemList().entrySet()){
            Classes.AMenuItem.AMenuItem item = entry.getKey();
            String itemName = item.getName();
            String leftString = itemName+" x"+entry.getValue();
            System.out.print(leftString);
            String priceFormat = "%"+(rowLength-leftString.length())+"s";
            String priceString = "      S$"+String.format("%.2f",item.getPrice()*entry.getValue())+"      ";
            System.out.format(priceFormat, priceString);
            System.out.println();
        }
        System.out.printf("-".repeat(rowLength));
        System.out.println();

        double subTotal = viewOrder.getSubTotal();
        double grandTotal = viewOrder.getGrandTotal();
        //Bottom segment:
        String subTotalPrice = "S$"+String.format("%.2f",subTotal);
        String totalPrice = "S$"+String.format("%.2f",grandTotal);
        String discountRate = Integer.toString((int)(100*viewOrder.getDISCOUNT_RATE())) + "%";
        String taxRate = Integer.toString((int)(100*viewOrder.getTAX_RATE())) + "%";

        String discountFormat = String.format("%"+totalPrice.length()+"s", discountRate);
        String subTotalFormat = String.format("%"+totalPrice.length()+"s", subTotalPrice);
        String totalFormat = String.format("%"+totalPrice.length()+"s", totalPrice);
        String taxFormat = String.format("%"+totalPrice.length()+"s", taxRate);

        String subTotalString = "subTotal: "+subTotalFormat+"     ";
        String discountString = "Discount: "+discountFormat+"     ";
        String taxString = "GST:      "+taxFormat+"     ";
        String totalString = "Total:    "+totalFormat+"     ";

        String resultFormatter = "%"+(rowLength)+"s";

        System.out.format(resultFormatter, discountString);
        System.out.println();
        System.out.format(resultFormatter, subTotalString);
        System.out.println();
        System.out.format(resultFormatter, taxString);
        System.out.println();
        System.out.format(resultFormatter, totalString);
        System.out.println();

        System.out.printf("-".repeat(rowLength));
        System.out.println();
    }
}
