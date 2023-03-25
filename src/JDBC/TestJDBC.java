package JDBC;

import java.sql.*;

public class TestJDBC {

    public static void main(String[] args) {

        var url = "jdbc:mysql://localhost:3306/etudiant";
        var login = "root";
        var pass = "";
        var driver = "com.mysql.cj.jdbc.Driver";
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;


        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.printf("le driver sql a ete charge avec succes ^_^");
            Connection Connection = DriverManager.getConnection(url, login, pass);
            System.out.printf("connection a ete etabli ^_^");
            ps= Connection.prepareStatement("select * from etudiant");
            resultSet= ps.executeQuery();


            while(resultSet.next()){
                var id = resultSet.getLong("id");
                var name=resultSet.getString("name");
                var note=resultSet.getDouble("note");


            }

        }catch (ClassNotFoundException e)


        {
            System.out.printf("le driver sql est introuvable");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            if(connection!=null){
                try {
                    connection.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }
        }
    }


    }



