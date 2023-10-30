import java.sql.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args)  {

        List<Purchase> purchaseList = new ArrayList<>();
        DecimalFormat df = new DecimalFormat("###.##"); //df.format(��������)


        String url = "jdbc:mysql://localhost:3306";
        String root = "root";
        String pass = "13Zpsrd;jgt04";

        try {
            Connection connection = DriverManager.getConnection(url, root, pass);
            Statement statement = connection.createStatement();

            ResultSet requestForPurchaseStatistics = statement
                    .executeQuery("SELECT course_name, max(month(subscription_date)), min(month(subscription_date)), count(course_name) FROM skillbox.purchaselist group by course_name");
            while (requestForPurchaseStatistics.next()) {
                purchaseList.add(new Purchase(requestForPurchaseStatistics.getString("course_name"),
                        requestForPurchaseStatistics.getDouble("max(month(subscription_date))"),
                        requestForPurchaseStatistics.getDouble("min(month(subscription_date))"),
                        requestForPurchaseStatistics.getDouble("count(course_name)")
                        ));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        for (Purchase p : purchaseList) {
            double averageNumberOfPurchases = p.getNumberOfPurchases()/(p.getLastMonthOfPurchase() - p.getFirstMonthOfPurchase());
            System.out.println("������� ���������� ������� ����� " + p.getCourceName() + " ��������� - "
                    + df.format(averageNumberOfPurchases)  + " ��� � �����");
        }

    }
}
