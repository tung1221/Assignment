package Entity;

public class BillDetail {
    private String bid;
    private String pid;
    private int buyQuantity;
    private double buyPrice;
    private double subtotal;

    public BillDetail(String bid, String pid, int buyQuantity, double buyPrice, double subtotal) {
        this.bid = bid;
        this.pid = pid;
        this.buyQuantity = buyQuantity;
        this.buyPrice = buyPrice;
        this.subtotal = subtotal;
    }

    public BillDetail() {
    }

    public String getBid() {
        return bid;
    }

    public void setBid(String bid) {
        this.bid = bid;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public int getBuyQuantity() {
        return buyQuantity;
    }

    public void setBuyQuantity(int buyQuantity) {
        this.buyQuantity = buyQuantity;
    }

    public double getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(double buyPrice) {
        this.buyPrice = buyPrice;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

}
