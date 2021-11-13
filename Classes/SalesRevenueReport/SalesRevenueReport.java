package Classes.SalesRevenueReport;

import java.util.ArrayList;

import Classes.Order.Order;
import Classes.Order.OrderManager;
import Classes.Staff.Staff;
import Classes.Time.DateTimeFormatHelper;
import java.util.Map;
import Classes.AMenuItem.AMenuItem;
import Classes.AMenuItem.AMenuItem.TYPE;

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
    private Map<AMenuItem, Integer> alacarteStatistics;
    private Map<AMenuItem, Integer> promotionalStatistics;

    public SalesRevenueReport(String period){
        int i = 0;
        this.totalRevenue = 0;
        this.orderList = OrderManager.getOrderHistory();
        this.period = period;
        String currentDate = DateTimeFormatHelper.formatToStringDate(DateTimeFormatHelper.getTodayDate(false));
        
        for (Order order : this.orderList){
            for (var entry : order.getItemList().entrySet()){
                AMenuItem item = entry.getKey();
                int quantity = entry.getValue();
                if (item.getType() == TYPE.ALACARTE){
                    if (!alacarteStatistics.containsKey(item)){ // key is not in our map yet
                        alacarteStatistics.put(item, quantity);
                    }
                    else{
                        alacarteStatistics.put(item, alacarteStatistics.get(item));
                    }
                }
                else if (item.getType() == TYPE.PROMOTIONAL){
                    if (!promotionalStatistics.containsKey(item)){ // key is in our map
                        promotionalStatistics.put(item, quantity);
                    }
                    else{
                        promotionalStatistics.put(item, alacarteStatistics.get(item));
                    }
                }
                
            }
        }

        


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
                    if ((order.getDateTime().charAt(3)+order.getDateTime().charAt(4)) == (currentDate.charAt(3)+currentDate.charAt(4)))
                    {
                        this.orderList.add(order);
                        this.totalRevenue += order.getGrandTotal();
                    }
                }
                break;

            case "YEAR":
                for (Order order : orderList){
                    if ((order.getDateTime().charAt(6)+order.getDateTime().charAt(7)+order.getDateTime().charAt(8)+order.getDateTime().charAt(9)) == (currentDate.charAt(6)+currentDate.charAt(7)+currentDate.charAt(8)+currentDate.charAt(9)))
                    {
                        this.orderList.add(order);
                        this.totalRevenue += order.getGrandTotal();
                    }
                }
                break;
            default:
        }
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

    public Map<AMenuItem, Integer> getAlaCarteStatistics(){
        return this.alacarteStatistics;
    }

    public Map<AMenuItem, Integer> getPromotionalStatistics(){
        return this.promotionalStatistics;
    }
}
