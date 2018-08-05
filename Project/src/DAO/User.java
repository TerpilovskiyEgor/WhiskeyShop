package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

public class User
{
    private long ID;

    private String Login;
    private String Password;

    private String Name;
    private String Surname;
    private String Email;

    private String Country;
    private String City;
    private String Street;
    private String House;

    public User()
    { }

    public User(ResultSet RS)
    {
        try
        {
            ID = RS.getLong("ID");

            Login = RS.getString("Login");
            Password = RS.getString("Password");

            Name = RS.getString("Name");
            Surname = RS.getString("Surname");
            Email = RS.getString("Email");

            Country = RS.getString("Country");
            City = RS.getString("City");
            Street = RS.getString("Street");
            House = RS.getString("House");
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public User(String Login, String Password, String Name, String Surname, String Email)
    {
        this.ID = new Random().nextLong();
        if(ID < 0){ ID *= -1; }

        this.Login = Login;
        this.Password = Password;

        this.Name = Name;
        this.Surname = Surname;
        this.Email = Email;
    }



    public long getID()
    {
        return ID;
    }
    public void setID(long ID)
    {
        this.ID = ID;
    }
    public String getLogin()
    {
        return Login;
    }
    public void setLogin(String login)
    {
        Login = login;
    }
    public String getPassword()
    {
        return Password;
    }
    public void setPassword(String password)
    {
        Password = password;
    }
    public String getName()
    {
        return Name;
    }
    public void setName(String name)
    {
        Name = name;
    }
    public String getSurname()
    {
        return Surname;
    }
    public void setSurname(String surname)
    {
        Surname = surname;
    }
    public String getEmail()
    {
        return Email;
    }
    public void setEmail(String email)
    {
        Email = email;
    }
    public String getCountry()
    {
        return Country;
    }
    public void setCountry(String country)
    {
        Country = country;
    }
    public String getCity()
    {
        return City;
    }
    public void setCity(String city)
    {
        City = city;
    }
    public String getStreet()
    {
        return Street;
    }
    public void setStreet(String street)
    {
        Street = street;
    }
    public String getHouse()
    {
        return House;
    }
    public void setHouse(String house)
    {
        House = house;
    }

    @Override
    public String toString() {
        return "User{" +
                "ID=" + ID +
                ", Login='" + Login + '\'' +
                ", Password='" + Password + '\'' +
                ", Name='" + Name + '\'' +
                ", Surname='" + Surname + '\'' +
                ", Email='" + Email + '\'' +
                ", Country='" + Country + '\'' +
                ", City='" + City + '\'' +
                ", Street='" + Street + '\'' +
                ", House='" + House + '\'' +
                '}';
    }
}