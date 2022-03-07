package com.teksystems;

import javax.xml.transform.Result;
import java.sql.*;

public class Main {

    public static void main(String[] args) {
        try{
            Connection connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/classicmodels","root","root");

            PreparedStatement getById = connection.prepareStatement(SqlQueries.GetEmployeeByID);
            getById.setInt(1, 1002);
            ResultSet idResultSet = getById.executeQuery();

            PreparedStatement getByOfficeCode = connection.prepareStatement(SqlQueries.GetEmployeeByOfficeCode);
            getByOfficeCode.setInt(1, 1);
            getByOfficeCode.setInt(2, 4);
            getByOfficeCode.setInt(3, 6);
            ResultSet officeCodeResultSet = getByOfficeCode.executeQuery();

            PreparedStatement updateExtension = connection.prepareStatement(SqlQueries.UpdateExtension);
            updateExtension.setString(1, "x5698");
            updateExtension.setInt(2, 2);
            updateExtension.executeUpdate();

            PreparedStatement getByNameLength = connection.prepareStatement(SqlQueries.GetEmployeeByNameLength);
            getByNameLength.setInt(1, 5);
            ResultSet nameResultSet = getByNameLength.executeQuery();

            while (idResultSet.next()){
                String name = idResultSet.getString("firstName");
                String email = idResultSet.getString("email");
                System.out.println(name + " | " + email);
            }

            while (officeCodeResultSet.next()){
                String name = officeCodeResultSet.getString("firstName");
                String officeCode = officeCodeResultSet.getString("officeCode");
                System.out.println(name + " | " + officeCode);
            }

            while (nameResultSet.next()){
                String firstName = nameResultSet.getString("firstName");
                String lastName = nameResultSet.getString("lastName");
                System.out.println(firstName + " " + lastName);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
