package Application;

import javax.security.auth.DestroyFailedException;
import java.security.KeyStore.PasswordProtection;
import java.sql.*;

public class Sql {
    static Connection connection = null;

    public static boolean connect(PasswordProtection pass) {///check password and connection
        Class driver = null;
        try {
            driver = Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e1) {
            // TODO Auto-generated catch block
            return false;
        }

        char[] p = pass.getPassword();
        String Password = String.valueOf(p);
        try {
///password=1234
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/school?autoReconnect=true&useSSL=false", "root", Password);
            Password = null;
        } catch (SQLException e) {
            Password = null;
            return false;
        }
        try {
            pass.destroy();
        } catch (DestroyFailedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        Password = null;
        return true;
    }

    public static boolean excute(String st) {
        try {
            Statement p = connection.createStatement();
            p.execute(st);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            Null.showSqlError(e.getMessage());
            return false;
        }
        return true;
    }

    public static void update(String table, String valueCh, String value1, String value2, String att) {
        String type = getType(table, valueCh);
        String s;
        if (type.contains("CHAR"))
            value1 = '\"' + value1 + '\"';
        s = "update " + table + " set " + valueCh + "=" + value1 + " where " + att + "=" + value2;
        excute(s);
    }

    public static void delete(String table, String att, String value) {
        String s = "delete from " + table + " where " + att + "=" + value;
        excute(s);
    }


    public static String[][] getResultsTable(String table) {
        final String query = "Select * from " + table;
        int rows = getRowsCount(table);
        int columns = getColumnsCount(table);
        int j = 0;
        String[][] result = new String[rows][columns];

        Statement p;
        try {
            p = connection.createStatement();
            ResultSet res = p.executeQuery(query);
            while (res.next()) {
                for (int i = 0; i < columns; i++)
                    result[j][i] = res.getString(i + 1);
                j++;
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            Null.showSqlError(e.getMessage());
        }
        return result;
    }

    public static int getRowsCount(String table) {
        int rows = 0;
        String query = "Select Count(*) from " + table;
        try {
            Statement p = connection.createStatement();
            ResultSet res = p.executeQuery(query);
            while (res.next()) {
                rows = res.getInt(1);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


        return rows;

    }

    public static int getColumnsCount(String table) {
        int columns = 0;
        String query = "select * from " + table;
        try {
            Statement p = connection.createStatement();
            ResultSet res = p.executeQuery(query);
            ResultSetMetaData rsmd = res.getMetaData(); //get columns size
            columns = rsmd.getColumnCount(); //get columns size
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return columns;
    }

    public static String[] getTableLabels(String table) {
        int columns = getColumnsCount(table);
        String[] labelName = new String[columns];
        String query = "Select * from " + table;
        Statement stmt = null;
        try {
            stmt = connection.createStatement();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        ResultSet rs;
        try {
            rs = stmt.executeQuery(query);
            ResultSetMetaData rsmd = rs.getMetaData();
            // The column count starts from 1
            for (int i = 1; i <= columns; i++) {
                labelName[i - 1] = rsmd.getColumnName(i);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return labelName;

    }

    public static int getColumnIndex(String[] labels, String att) {
        for (int i = 0; i < labels.length; i++)
            if (labels[i].matches(att))
                return i + 1;
        return -1;
    }

    public static String getType(String table, String con) { //get sql column types
        String[] labels = getTableLabels(table);
        int index = getColumnIndex(labels, con);
        try {
            Statement p = connection.createStatement();
            String query = "Select * from " + table;
            ResultSet res = p.executeQuery(query);
            ResultSetMetaData rsmd = res.getMetaData();
            String type = rsmd.getColumnTypeName(index);
            return type;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return null;
    }

    public static String[][] complexSqlQuery(String table1, String att1, String val1) {
        String type1 = getType(table1, att1);
        String[][] results = null;
        int columns = 0;
        String query;
        if (type1.contains("CHAR"))//char
            val1 = '"' + val1 + '"';
        query = "select * from " + table1 + " t1 where t1." + att1 + "=" + val1;
        System.out.println(query);
        Statement s;
        try {
            s = connection.createStatement();
            ResultSet res = s.executeQuery(query);
            ResultSetMetaData rsmd = res.getMetaData(); //get columns size
            columns = rsmd.getColumnCount(); //get columns size
            int rows = 0;
            String rowsQuery;
            rowsQuery = "Select count(*) from " + table1 + " t1 where t1." + att1 + "=" + val1;
            Statement s2 = connection.createStatement();
            ResultSet r = s2.executeQuery(rowsQuery); //getRow
            while (r.next())
                rows = r.getInt(1);
            if (rows >= 1) {
                results = new String[rows][columns];
                int j = 0;
                while (res.next()) {
                    for (int i = 0; i < columns; i++)
                        results[j][i] = res.getString(i + 1);
                    j++;
                }
                return results;
            } else
                return null;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            Null.showSqlError(e.getMessage());
            return null;
        }
    }

    public static String[] getComplexLabels(String table1, String att1, String val1) {
        String type1 = getType(table1, att1);
        String query;
        if (type1.contains("CHAR"))//char
            val1 = '"' + val1 + '"';
        int columns = 0;
            query = "Select * from " + table1 + " t1 where " + "t1." + att1 + "=" + val1;
        Statement stmt = null;
        try {
            stmt = connection.createStatement();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        ResultSet rs;
        try {
            rs = stmt.executeQuery(query);
            ResultSetMetaData rsmd = rs.getMetaData();
            columns = rsmd.getColumnCount();
            String[] labelName = new String[columns];
            // The column count starts from 1
            for (int i = 1; i <= columns; i++)
                labelName[i - 1] = rsmd.getColumnName(i);
            return labelName;

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }
    }




    public String[][] studentDistribution() {
        return null;
    }
}
