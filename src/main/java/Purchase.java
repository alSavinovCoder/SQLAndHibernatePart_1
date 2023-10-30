import jakarta.persistence.Column;
import jakarta.persistence.Table;

import java.text.DecimalFormat;
import java.util.Date;


@Table (name = "purchaselest")
public class Purchase {

    public Purchase() {
    }

    public Purchase(String courceName, double lastMonthOfPurchase, double firstMonthOfPurchase, double numberOfPurchases) {
        this.courceName = courceName;
        this.lastMonthOfPurchase = lastMonthOfPurchase;
        this.firstMonthOfPurchase = firstMonthOfPurchase;
        this.numberOfPurchases = numberOfPurchases;
    }

    @Column (name = "student_name")
    //@JoinTable (name = "")
    private String studentName;

    @Column (name = "cource_name")
    private String courceName;

    private int price;

    @Column(name = "subscription_date")
    private Date subscriptionDate;

    private double lastMonthOfPurchase;
    private double firstMonthOfPurchase;
    private double numberOfPurchases;

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getCourceName() {
        return courceName;
    }

    public void setCourceName(String courceName) {
        this.courceName = courceName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Date getSubscriptionDate() {
        return subscriptionDate;
    }

    public void setSubscriptionDate(Date subscriptionDate) {
        this.subscriptionDate = subscriptionDate;
    }

    public double getLastMonthOfPurchase() {
        return lastMonthOfPurchase;
    }

    public void setLastMonthOfPurchase(double lastMonthOfPurchase) {
        this.lastMonthOfPurchase = lastMonthOfPurchase;
    }

    public double getFirstMonthOfPurchase() {
        return firstMonthOfPurchase;
    }

    public void setFirstMonthOfPurchase(double firstMonthOfPurchase) {
        this.firstMonthOfPurchase = firstMonthOfPurchase;
    }

    public double getNumberOfPurchases() {
        return numberOfPurchases;
    }

    public void setNumberOfPurchases(double numberOfPurchases) {
        this.numberOfPurchases = numberOfPurchases;
    }
}
