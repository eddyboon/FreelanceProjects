package model;

public class TipModel {
    private double billAmount;
    private double tipAmount;
    private double totalAmount;

    public TipModel() {
        this.billAmount = 0.0;
        this.tipAmount = 0.0;
        totalAmount = 0.0;
    }

    public double getBillAmount() {
        return this.billAmount;
    }

    public double getTipAmount() {
        return tipAmount;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setBillAmount(double billAmount) {
        this.billAmount = billAmount;
    }

    public void setTipAmount(double tipAmount) {
        this.tipAmount = tipAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }
}
