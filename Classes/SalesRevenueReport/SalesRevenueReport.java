package Classes.SalesRevenueReport;

import java.util.ArrayList;

import Classes.Order.Order;
import Classes.Staff.Staff;
import Classes.Time.DateTimeFormatHelper;

/**
 * Contains the sales information of all items sold for a particular period of time.
 */
public class SalesRevenueReport {
    /**
     * Creates a Sales Revenue Report for a certain period of time.
     * @param orderList List of all orders sold within the period
     * @param period The period (day, month, year) which sales are being reported for
     */
    private ArrayList<Order> orderList;
    private String period;
    private double totalRevenue;
    public SalesRevenueReport(ArrayList<Order> orderList, String period){
        int i = 0;
        this.totalRevenue = 0;
        this.orderList = new ArrayList<Order>();
        this.period = period;
        String currentDate = DateTimeFormatHelper.formatToStringDate(DateTimeFormatHelper.getTodayDate(false));

        // TODO Min: fix errors
        switch(this.period){
            case "DAY":
                for (Order order : orderList){
                    if ((order.getDateTime().charAt(0)+order.getDateTime().charAt(1)) == (currentDate.charAt(0)+currentDate.charAt(1)))
                    {
                        this.orderList.add(order);
                        this.totalRevenue += order.getGrandTotal();
                    }
                }
                break;

            case "MONTH":
                for (Order order : orderList){
                    if ((order.getDateTime().charAt(3)+order.getdateTime.charAt(4)) == (currentDate.charAt(3)+currentDate.charAt(4)))
                    {
                        this.orderList.add(order);
                        this.totalRevenue += order.getGrandTotal();
                    }
                }
                break;

            case "YEAR":
                for (Order order : orderList){
                    if ((order.getDateTime().charAt(6)+order.getdateTime.charAt(7)+order.getDateTime().charAt(8)+order.getDateTime().charAt(9)) == (currentDate.charAt(6)+currentDate.charAt(7)+currentDate.charAt(8)+currentDate.charAt(9)))
                    {
                        this.orderList.add(order);
                        this.totalRevenue += order.getGrandTotal();
                    }
                }
                break;
            default:
        }
            this.totalRevenue += order.getGrandTotal();
    }

    public ArrayList<Order> getOrderList() {
        return this.orderList;
    }

    public String getPeriod() {
        return this.period;
    }

    public double getTotalRevenue() {
        return this.totalRevenue;
    }
}
