package AssignQ2;

import java.util.ArrayList;
/**
Title: ICT 373 Software Architecture Assignment 1 Question 2

Author: Aung Kyaw Myint

Date: 15/6/2019

Purpose: This Class is to store the details of Paying Customer as well as its related methods
**/
public class PayingCust extends Customer { //inherit from Parent Customer class
    private Payment payType;
    private ArrayList<AssoCust> assolist;
    
    
/********Constructor*************/
public PayingCust()
{
    super();
    payType = new Payment();
    assolist = new ArrayList<>();
    
}

public PayingCust(String n,String e)
{
    super(n,e);
    payType = new Payment();
    assolist = new ArrayList<>();
}

public PayingCust(String n,String e,String b,int i)
{
    super(n,e);
    payType = new Payment(b,i);
    assolist = new ArrayList<>();
}

public PayingCust(String n,String e,String b,int i,ArrayList<AssoCust> list)
{
    super(n,e);
    payType = new Payment(b,i);
    assolist = list;
}


/*********SETTER METHOD ************/
public void setPayment(String s,int i) 
{
    payType = new Payment(s,i);
}

public void setAssociate(ArrayList<AssoCust> list)
{
    assolist = list;
}

/************************************/

//method to add associate
public void addAssociate(AssoCust a)
{
    assolist.add(a);
}

//method to remove associate
public void removeAssociate(AssoCust a)
{
    assolist.remove(a);
}

//*********GETTER Method*************/
public Payment getPayment()
{
    return payType;
}
public ArrayList<AssoCust> getAssociate()
{
    return assolist;
}
public ArrayList<String> getAssociateName()
{
    ArrayList<String> assoName = new ArrayList<>();
    for(int i=0;i<assolist.size();i++)
    {
        assoName.add(assolist.get(i).getName());
    }
    return assoName;
}
    
//output format
    public String toString()
{
    String name = super.getName();
    String email = super.getEmail();
    String supplement = super.listToString();
    ArrayList<String> associate = getAssociateName();
    
    return (name+"\n"+email+"\n"+payType+"\n"+"\nList of Associate Customer\n"+associate+"\n\n"+"List of Supplement\n"+supplement+"\n");
}
}
