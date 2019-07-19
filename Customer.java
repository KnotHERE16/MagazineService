package AssignQ2;

import java.util.ArrayList;

/**
Title: ICT 373 Software Architecture Assignment 1 Question 2

Author: Aung Kyaw Myint

Date: 15/6/2019

Purpose: Customer class is the parent class of Paying Customer class and Associate Customer 
* class which will be used to store data of customer such as name and email 
**/
public class Customer
{

    private String name;
    private String email;
    private ArrayList<Supplement> supplist;

    /******Constructor**********/
    public Customer()
    {
        name = "name";
        email = "example@gmail.com";
        supplist = new ArrayList<>();
    }

    public Customer(String n)
    {
        name = n;
        email = " ";
        supplist = new ArrayList<>();
    }
    public Customer(String n, String e)
    {
        name = n;
        email = e;
        supplist = new ArrayList<>();
    }

    public Customer(String n, String e, ArrayList<Supplement> s)
    {
        name = n;
        email = e;
        supplist = s;
    }

    /*******SETTER METHODS*********/
    public void setName(String s)
    {
        name = s;
    }

    public void setEmail(String e)
    {
        email = e;
    }

    public void setSupplements(ArrayList<Supplement> s)
    {
        supplist = s;
    }

    /**********GETTER METHODS *********/
    public String getName()
    {
        return name;
    }

    public String getEmail()
    {
        return email;
    }

    public ArrayList<Supplement> getSupplement()
    {
        
        return supplist;
    }

    //method to add supplement to the customer
    public void addsupplement(Supplement s)
    {
        if(checkexist(s)==false)
        {
        supplist.add(s);
        }
        else
        {
            System.out.println("The supplement already exist");
        }
    }
    
    //method to remove supplement from the customer
    public void removeSupplement(Supplement s)
    {
        if(checkexist(s)==false)
        {
            System.out.println("There is no supplement to remove");
        }
        else
        {
            supplist.remove(s);
        }

        
    }

    //method to display supplement list in nicer format
    public String listToString()
    {
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<supplist.size();i++)
        {
            sb.append(supplist.get(i).toString());
        }
        return sb.toString();
    }
    
    //method to check if the supplement already exist
    private boolean checkexist(Supplement s)
    {
        boolean exist = false;
        for (int i = 0; i < supplist.size(); i++)
        {
            Supplement temp = supplist.get(i);
          
            if (temp == s)
            {
                exist = true;
            } 
        }
        return exist;
    }
    
    
}
