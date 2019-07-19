package AssignQ2;

/**
Title: ICT 373 Software Architecture Assignment 1 Question 2

Author: Aung Kyaw Myint

Date: 15/6/2019

Purpose: This Class is to store the details of a Supplement and contain the related methods
**/
public class Supplement {
    private String name;
    private double cost;
    
     /*********Constructor ***********/
    public Supplement()
    {
        name = " ";
        cost = 0;
    }
    
    public Supplement(String s,double c)
    {
        name = s;
        cost = c;
    }
    
    /*******SETTER METHOD**********/
    public void setSupplement(String s,double c)
    {
        name = s;
        cost = c;
    }
    public void setName(String s)
    {
        name = s;
    }
    
    public void setCost(double c)
    {
        cost = c;
    }
    
    /**********GETTER METHOD************/
    public String getName()
    {
        return name;
    }
    
    public double getCost()
    {
        return cost;
    }
    
    //Output format
    public String toString()
    {
        String costs = String.format("%.2f",cost);
        return (name+":\t $"+ costs+"\n");
    }
}
