package AssignQ2;

import java.util.ArrayList;

/**
Title: ICT 373 Software Architecture Assignment 1 Question 2

Author: Aung Kyaw Myint

Date: 15/6/2019

Purpose: This Class is to store the details of Associate Customer as well as its related methods
**/
public class AssoCust extends Customer
{

    private PayingCust payBy;

    /*****Constructor**************/
    public AssoCust()
    {
        super();
        payBy = new PayingCust();
    }

    public AssoCust(String n)
    {
        super(n);
        payBy = new PayingCust();
    }
    public AssoCust(String n, String e, PayingCust p)
    {
        super(n, e);
        payBy = p;
    }
    
    public AssoCust(String n, String e, ArrayList<Supplement> sup,PayingCust p)
    {
        super(n,e,sup);
        payBy = p;
    }
    
    /********Setter Method*********/
    public void setAssoCust(String n,String e,PayingCust p)
    {
        super.setName(n);
        super.setEmail(e);
        payBy = p;
    }
    
    public void setPayBy(PayingCust p)
    {
        payBy = p;
    }
    
    /*********GETTER METHOD**********/
    public PayingCust getPayby()
    {
        return payBy;
    }
    
    //Output format
    public String toString()
    {
    String name = super.getName();
    String email = super.getEmail();
    String payer = payBy.getName();
    String supplement = super.listToString();
    
    return (name+"\n"+email+"\n"+"Pay By : "+payer+"\n"+"List of Supplement\n"+supplement+"\n");
    }

}
