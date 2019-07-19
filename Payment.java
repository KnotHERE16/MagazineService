package AssignQ2;

/**
Title: ICT 373 Software Architecture Assignment 1 Question 2

Author: Aung Kyaw Myint

Date: 15/6/2019

Purpose: This Class is to store the details of a Payment that the paying customer will use
**/
public class Payment {
private String bankname;
private String paytype;

/***Constructor******/
public Payment()
{
    bankname =" ";
    paytype = " ";
}
public Payment(String b,int e)
{
    bankname = b;
    paytype = convert(e);
}

/*convert paytype input 1 = Debit card
                        2 = Credit card
*/
private String convert(int i) 
{
    if (i == 1)
            {
                return "Debit";
            }
    else if (i == 2)
            {
                return "Credit";
            }
    else
    {
        return "Invalid";
    }
}

/*********SETTER METHOD*********/
public void setBank(String s) // set Bank name
{
    bankname = s;
}

public void setType(int i) // set payment type
{
    paytype=convert(i);
}

/*********GETTER METHOD**********/
public String getBank()
{
    return bankname;
}

public String getType()
{
    return paytype;
}

//Output Format
public String toString()
{
    return (bankname+" : "+paytype);
}
}
