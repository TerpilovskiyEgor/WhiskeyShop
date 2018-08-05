package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

public class Product
{
    private long ID;            // ID (PRIMARY KEY, UNIQUE, NOT NULL)
    private String Name;        // Название товара (NOT NULL)
    private int Amount;         // Количество товара (NOT NULL, DEFAULT (0))
    private double Price;       // Цена за штуку (NOT NULL)
    private long Purchases;     // Количество покупок / рейтинг (NOT NULL, DEFAULT (0))

    private String Description; // Описание
    private int Stars;          // Количество звезд
    private int VoL;            // Крепость
    private int Year;           // Год производства
    private String Country;     // Страна производитель
    private double Scope;       // Объем

    /* --- Конструкторы --- */
    public Product()
    { }

    public Product(String Name, int Amount, double Price, long Purchases)
    {
        this.Name = Name;
        this.Amount = Amount;
        this.Price = Price;
        this.Purchases = Purchases;

        long Temp = new Random().nextLong();
        if (Temp < 0)
        { Temp *= -1;}
        ID = Temp;
    }

    public Product(String Name, int Amount, double Price, long Purchases, String Description, int Stars, int VoL,
                   int Year, String Country, double Scope)
    {
        this.Name = Name;
        this.Amount = Amount;
        this.Price = Price;
        this.Purchases = Purchases;

        this.Description = Description;
        this.Stars = Stars;
        this.VoL = VoL;
        this.Year = Year;
        this.Country = Country;
        this.Scope = Scope;

        long Temp = new Random().nextLong();
        if (Temp < 0)
        { Temp *= -1;}
        ID = Temp;
    }

    public Product(ResultSet RS)
    {
        try
        {
            this.ID = RS.getLong("ID");
            this.Name = RS.getString("Name");
            this.Amount = RS.getInt("Amount");
            this.Price = RS.getDouble("Price");
            this.Purchases = RS.getLong("Purchases");

            this.Description = RS.getString("Description");
            this.Stars = RS.getInt("Stars");
            this.VoL = RS.getInt("VoL");
            this.Year = RS.getInt("Year");
            this.Country = RS.getString("Country");
            this.Scope = RS.getDouble("Scope");
        }
        catch (SQLException E)
        {
            System.err.println("--[" + E.getClass().getName() + "]: " + E.getMessage());
        }
    }


    @Override
    public String toString() {
        return "Product{" +
                "ID=" + ID +
                ", Name='" + Name + '\'' +
                ", Amount=" + Amount +
                ", Price=" + Price +
                ", Purchases=" + Purchases +
                ", Description='" + Description + '\'' +
                ", Stars=" + Stars +
                ", VoL=" + VoL +
                ", Year=" + Year +
                ", Country='" + Country + '\'' +
                ", Scope=" + Scope +
                '}';
    }

    /* --- Get / Set --- */
    public long getID()
    {
        return ID;
    }

    public void setID(long ID)
    {
        this.ID = ID;
    }

    public String getName()
    {
        return Name;
    }

    public void setName(String name)
    {
        Name = name;
    }

    public int getAmount()
    {
        return Amount;
    }

    public void setAmount(int amount)
    {
        Amount = amount;
    }

    public double getPrice()
    {
        return Price;
    }

    public void setPrice(double price)
    {
        Price = price;
    }

    public long getPurchases()
    {
        return Purchases;
    }

    public void setPurchases(long purchases)
    {
        Purchases = purchases;
    }

    public String getDescription()
    {
        return Description;
    }

    public void setDescription(String description)
    {
        Description = description;
    }

    public int getStars()
    {
        return Stars;
    }

    public void setStars(int stars)
    {
        Stars = stars;
    }

    public int getVoL()
    {
        return VoL;
    }

    public void setVoL(int voL)
    {
        VoL = voL;
    }

    public int getYear()
    {
        return Year;
    }

    public void setYear(int year)
    {
        Year = year;
    }

    public String getCountry()
    {
        return Country;
    }

    public void setCountry(String country)
    {
        Country = country;
    }

    public double getScope()
    {
        return Scope;
    }

    public void setScope(double scope)
    {
        Scope = scope;
    }
}
