package DAO;

import javax.management.Query;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBC {
    private static JDBC instance = null;
    private static Connection conn = null;

    public static synchronized JDBC getInstance()
    {
        if (instance == null)
            instance = new JDBC();
            Connection();
        return instance;
    }

    public static synchronized void Connection()
    {
        try
        {
            Class.forName("org.sqlite.JDBC").newInstance();
            conn = DriverManager.getConnection("jdbc:sqlite:../../Project/DataBase/DataBase.db");
            //conn = DriverManager.getConnection("jdbc:sqlite:DataBase/DataBase.db");
            //conn = DriverManager.getConnection("jdbc:sqlite:../../Project/DataBase/TestDB.db");
            System.out.println("Opened database successfully");
        } catch (ClassNotFoundException | SQLException | IllegalAccessException | InstantiationException E) {
            System.err.println("--[" + E.getClass().getName() + "]: " + E.getMessage());
        }
    }

    public static void Disconnection()
    {
        if (conn != null) {
            try {
                conn.close();
                System.out.println("Close database successfully");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }




    public void AddProduct(Product product)
    {
        try (PreparedStatement statement = conn.prepareStatement
                ("INSERT INTO Products(`ID`, `Name`, `Amount`, `Price`, `Purchases`) " +
                        "VALUES(?, ?, ?, ?, ?)"))
        {
            statement.setObject(1, product.getID());
            statement.setObject(2, product.getName());
            statement.setObject(3, product.getAmount());
            statement.setObject(4, product.getPrice());
            statement.setObject(5, product.getPurchases());

            statement.execute();
        } catch (SQLException E) {
            System.err.println("--[" + E.getClass().getName() + "]: " + E.getMessage());
        }
    }

    public ArrayList<Product> GetProducts(String FilterString)
    {
        ArrayList<Product> L = new ArrayList<>();
        try
        {
            PreparedStatement PS = conn.prepareStatement("SELECT * FROM Products "+ FilterString +"");
            ResultSet RS = PS.executeQuery();
            while(RS.next())
            {
                L.add(new Product(RS));
            }
            return L;
        }
        catch (SQLException E)
        {
            System.err.println("--[" + E.getClass().getName() + "]: " + E.getMessage());
            return null;
        }
    }

    public ArrayList<Product> GetProducts(ArrayList<Long> ListID)
    {
        ArrayList<Product> L = new ArrayList<>();
        try
        {
            for(int i = 0; i < ListID.size(); i++)
            {
                PreparedStatement PS = conn.prepareStatement("SELECT * FROM Products WHERE ID = ?");
                PS.setObject(1, ListID.get(i));
                ResultSet RS = PS.executeQuery();
                //RS.next();
                L.add(new Product(RS));
            }
            return L;
        }
        catch (SQLException E)
        {
            System.err.println("--[" + E.getClass().getName() + "]: " + E.getMessage());
            return null;
        }
    }

    public Product GetProduct(long ID)
    {
        ArrayList<Product> L = new ArrayList<>();
        try
        {
            PreparedStatement PS = conn.prepareStatement("SELECT * FROM Products WHERE ID = ?");
            PS.setObject(1, ID);

            ResultSet RS = PS.executeQuery();
            RS.next();
            return new Product(RS);
        }
        catch (SQLException E)
        {
            System.err.println("--[" + E.getClass().getName() + "]: " + E.getMessage());
            return null;
        }
    }

    public ArrayList<Product> GetFourPopular()
    {
        ArrayList<Product> ListPopProduct = new ArrayList<>();

        try (Statement statement = conn.createStatement()) {
            ResultSet RS = statement.executeQuery("SELECT * FROM Products ORDER BY Purchases DESC limit 0, 4");

            while (RS.next()) {
                ListPopProduct.add(new Product(RS));
            }
        } catch (SQLException E) {
            System.err.println("--[" + E.getClass().getName() + "]: " + E.getMessage());
        }

        return ListPopProduct;
    }




    public void AddUser(User U)
    {
        try(PreparedStatement statement = conn.prepareStatement(
                "INSERT INTO Users (`ID`, `Login`, `Password`, `Email`, `Name`, `Surname`, `Country`, `City`, `Street`, `House`) " +
                        "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"))
        {
            statement.setObject(1, U.getID());
            statement.setObject(2, U.getLogin());
            statement.setObject(3, U.getPassword());
            statement.setObject(4, U.getEmail());
            statement.setObject(5, U.getName());
            statement.setObject(6, U.getSurname());
            statement.setObject(7, U.getCountry());
            statement.setObject(8, U.getCity());
            statement.setObject(9, U.getStreet());
            statement.setObject(10, U.getHouse());

            statement.execute();
        }
        catch(SQLException E)
        {
            System.err.println("--[" + E.getClass().getName() + "]: " + E.getMessage());
        }
    }

    public User GetUser(String Login, String Password)
    {
        try(PreparedStatement PS = conn.prepareStatement("SELECT * FROM Users WHERE Login =  \"" + Login + "\" AND Password = \"" + Password + "\""))
        {
            ResultSet RS = PS.executeQuery();
            if(RS.next() == false)
            {
                return null;
            }
            else
            {
                return new User(RS);
            }
        }
        catch(SQLException E)
        {
            System.err.println("--[" + E.getClass().getName() + "]: " + E.getMessage());
            return null;
        }
    }

    public User GetUser(long ID)
    {
        try(PreparedStatement PS = conn.prepareStatement("SELECT * FROM Users WHERE ID =  \"" + ID + "\""))
        {
            ResultSet RS = PS.executeQuery();
            if(RS.next() == false)
            {
                return null;
            }
            else
            {
                return new User(RS);
            }
        }
        catch(SQLException E)
        {
            System.err.println("--[" + E.getClass().getName() + "]: " + E.getMessage());
            return null;
        }
    }

    public boolean CheckLoginDuplicate(String Login)
    {
        try(PreparedStatement PS_Login = conn.prepareStatement("SELECT COUNT(*) FROM Users WHERE Login =  \"" + Login + "\""))
        {
            int Status_Login = PS_Login.executeQuery().getInt(1);

            if (Status_Login < 1)
            {
                return false;
            }
            else
            {
                return true;
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            return true;
        }
    }
}
