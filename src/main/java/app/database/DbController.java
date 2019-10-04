package app.database;
import app.model.Developer;

import javax.naming.NamingException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DbController {

    private static boolean isConnected = false;
    private static Connection connection;
    private static Statement statement;
    private static ResultSet resultSet;

    private static void connectionDataBases() throws ClassNotFoundException, SQLException, NamingException {
        Class.forName("org.h2.Driver");
        connection = DriverManager.getConnection("jdbc:h2:mem:","sa","");
        statement = connection.createStatement();
        PreparedStatement statement = connection.prepareStatement( "CREATE TABLE Market (" +
                "  `id` int(11) AUTO_INCREMENT," +
                "  `ids` varchar(50) NOT NULL," +
                "  `name` varchar(50) NOT NULL," +
                "  `price` varchar(50) NOT NULL," +
                "  PRIMARY KEY (`id`)" +
                ")");
        statement.execute();
        isConnected = true;

    }
    public static void insetInDataBase(Developer developer) throws ClassNotFoundException, SQLException {
        try {
            if(!DbController.isConnected){
                DbController.connectionDataBases();
            }
            statement = connection.createStatement();
            PreparedStatement statement = connection.prepareStatement("INSERT INTO Market (ids,name, price) VALUES ('" + developer.getId() + "','" + developer.getName() + "','" + developer.getPrice() + "');");
            statement.execute();
            System.out.println(getAllRecords());
        } catch (Exception e) {

        }
    }
    public static List<String> getAllRecords() throws ClassNotFoundException, SQLException, NamingException
    {
        List<String> listRecord = new ArrayList<String>();
        if (isConnected){
            statement = connection.createStatement();
            ResultSet executeQuery = statement.executeQuery("select * from Market");

            while (executeQuery.next()) {
                String str ="<tr>" +
                        "<td>" + executeQuery.getString("ids") + "</td>" +
                        "<td>" + executeQuery.getString("name") + "</td>" +
                        "<td>" + executeQuery.getString("price") + "</td></tr>";
                listRecord.add(str);
            }
            executeQuery.close();
        }
        return listRecord;
    }


}
