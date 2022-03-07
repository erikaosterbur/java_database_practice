package com.teksystems;

public class SqlQueries {
    public final static String GetEmployeeByID =
            "SELECT * FROM employees WHERE employeeNumber = ?";

    public final static String GetEmployeeByOfficeCode =
            "SELECT * FROM employees WHERE officeCode = ? OR officeCode = ? OR officeCode = ?";

    public final static String UpdateExtension =
            "UPDATE employees SET extension=? WHERE officeCode=?";

    public final static String GetEmployeeByNameLength =
            "SELECT * FROM employees WHERE LENGTH(lastName) < ?";

}
