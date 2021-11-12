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
                    if ((order.getDateTime()[0]+order.getDateTime[1]) == (currentDate[0]+currentDate[1]))
                    {
                        this.orderList.add(order);
                        this.totalRevenue += order.getGrandTotal();
                    }
                }
            case "MONTH":
                for (Order order : orderList){
                    if ((order.getDateTime()[3]+order.getdateTime[4]) == (currentDate[3]+currentDate[4]))
                    {
                        this.orderList.add(order);
                        this.totalRevenue += order.getGrandTotal();
                    }
                }
            case "YEAR":
                for (Order order : orderList){
                    if ((order.getDateTime()[6]+order.getdateTime[7]+order.getDateTime()[8]+order.getDateTime()[9]) == (currentDate[6]+currentDate[7]+currentDate[8]+currentDate[9]))
                    {
                        this.orderList.add(order);
                        this.totalRevenue += order.getGrandTotal();
                    }
                }
        }
            this.totalRevenue += order.getGrandTotal();
    }

    public ArrayList<Order> getOrderList() {
        return this.orderList;
    }

    public double getPeriod() {
        return this.period;
    }

    public double getTotalRevenue() {
        return this.totalRevenue;
    }
}
