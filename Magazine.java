package AssignQ2;

import java.util.ArrayList;
import java.time.LocalDate;
/**
Title: ICT 373 Software Architecture Assignment 1 Question 2

Author: Aung Kyaw Myint

Date: 15/6/2019

Purpose: This Class is to store the details of a Magazine and contain the related methods
**/
public class Magazine
{
    private double cost;
    private LocalDate d1;
    private String week;
    private ArrayList<Supplement> supplist;

    /*********Constructor*******/
    public Magazine()
    {
        cost = 5.00;
        supplist = new ArrayList<>();
    }
    
    public Magazine(double c, ArrayList<Supplement> s)
    {
        cost = c;
        supplist = s;
    }
    
    public Magazine(double c, ArrayList<Supplement> s,int y,int m,int w)
    {
        cost = c;
        supplist = s;
        d1 = LocalDate.of(y,m,1);
        week = weekWhat(w);
        
    }

    /*******SETTER METHOD************/
    public void setDate(int y,int m,int w)
    {
        d1 = LocalDate.of(y,m,1);        
        week = weekWhat(w);
    }
   
    public void setSupp(ArrayList<Supplement> s)
    {
        supplist = s;
    }

    public void setcost(double c)
    {
        cost = c;
    }

    /********GETTER METHOD***********/
    public double getcost()
    {
        return cost;
    }

    public ArrayList<Supplement> getSuppLIst()
    {
        return supplist;
    }

    //method to add supplement to the magazine
    public void addsupplement(Supplement s)
    {
        if (checkexist(s) == false)
        {
            supplist.add(s);
        } else
        {
            System.out.println("The supplement already exist");
        }
    }

    //method to check if the supplmeent already exist
    private boolean checkexist(Supplement s)
    {
        boolean exist = false;
        for (int i = 0; i < supplist.size(); i++)
        {
            Supplement temp = supplist.get(i);
            if (temp == s)
            {
                exist = true;
            } else
            {
                exist = false;
            }
        }
        return exist;
    }
    
    //method to convert int 1-4 input to String week 1 - 4
    private String weekWhat(int w)
    {
        String choice;
        switch(w)
        {
            case 1: 
                choice = "week 1";
            break;
            case 2: 
                choice = "week 2";
            break;
            case 3: 
                choice = "week 3";
            break;
            case 4: 
                choice = "week 4";
            break;
            default:
                choice = "invalid week";
        }
        return choice;
    }
    
    //output format to display list of supplement
    public String listToString()
    {
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<supplist.size();i++)
        {
            sb.append(supplist.get(i).toString());
        }
        return sb.toString();
    }
    
    //output format
       public String toString()
    {
        String months = d1.getMonth().name();
        int year = d1.getYear();
        String costs = String.format("%.2f",cost);
        return (year +" "+ months +" "+ week +"\nList of Supplement\nMain cost:\t $"+ costs +"\n"+listToString());
    }
}
