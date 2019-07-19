package AssignQ2;

/**
Title: ICT 373 Software Architecture Assignment 1 Question 2

Author: Aung Kyaw Myint

Date: 15/6/2019

File names: AssoCust.java, Customer.java, Magazine.java, Main.java, PayingCust.java, Payment.java, Supplement.java

Purpose: The program is used to perform tasks based on the project description to manage customer and magazine subscription services with different options

Assumption: User input in the correct format as required
*           For monthly email, each customer has the same magazine and supplement for all 4 weeks
* 
 */
import java.util.Scanner;
import java.util.ArrayList;

public class Main
{

    public static void main(String[] argv)
    {
        displayStudentDetails(); // display student details
        Scanner input = new Scanner(System.in);

        ArrayList<Supplement> yesSupp = new ArrayList<>(); //object to store availabe supplement
        availableSupplement(yesSupp); //add available Supplement to yesSupp

        // Question part a
        // construct a magazine with an array of 3-4 supplements with made-up details built in to the program
        ArrayList<Supplement> sM1 = new ArrayList<>();
        sM1.add(new Supplement("Art & craft", 2.0));
        sM1.add(new Supplement("Business", 3.0));
        sM1.add(new Supplement("Celebrity", 2.5));
        sM1.add(new Supplement("Health Care", 1));

        Magazine m1 = new Magazine(5, sM1, 2019, 6, 2);

        //***************************************************************************************
        // Question part b
        //construct an array of 5-6 different customers of various types with made-up details built in to the program
        ArrayList<Customer> customerList = new ArrayList<>();

        //create Paying Customer
        PayingCust p1 = new PayingCust("Kelvin", "Kelvin@gmail.com", "DBS", 1);
        PayingCust p2 = new PayingCust("Harry", "Harry@gmail.com", "UOB", 2);

        //Create Associate Customer
        AssoCust a1 = new AssoCust("Marie", "Marie@gmail.com", p1);
        AssoCust a2 = new AssoCust("Honoka", "Honoka@gmail.com", p1);
        AssoCust a3 = new AssoCust("Rose", "Rose@gmail.com", p2);

        //Add Associate Customer to Paying Customer
        p1.addAssociate(a1);
        p1.addAssociate(a2);
        p2.addAssociate(a3);

        //Create a list of supplement
        Supplement s1 = new Supplement("Business", 3.0);
        Supplement s2 = new Supplement("Celebrity", 2.5);
        Supplement s3 = new Supplement("Health Care", 1);
        Supplement s4 = new Supplement("Art & Craft", 2.0);
        Supplement s5 = new Supplement("Education", 5.0);
        Supplement s6 = new Supplement("Fiction", 6.0);

        //Add supplement to customer
        p1.addsupplement(s1);
        p1.addsupplement(s2);

        p2.addsupplement(s3);
        p2.addsupplement(s4);

        a1.addsupplement(s1);
        a1.addsupplement(s3);

        a2.addsupplement(s2);
        a2.addsupplement(s3);

        a3.addsupplement(s5);
        a3.addsupplement(s6);

        //Add customer to customer arraylist
        customerList.add(p1);
        customerList.add(p2);
        customerList.add(a1);
        customerList.add(a2);
        customerList.add(a3);

        //System.out.println(customerList);
        //****************************************************************************
        int choice;
        boolean exit = false;
        while (!exit)
        {
            menu(); // Display the menu
            choice = input.nextInt(); // Take input from user for option
            System.out.println("\n");
            switch (choice)
            {
                case 1: //construct a magazine via user input
                    System.out.println("Existing Magazine");
                    System.out.println(m1);

                    Magazine m2 = constructMagazine(yesSupp);
                    System.out.println("\nThe magazine created\n");
                    System.out.println(m2);
                    break;

                case 2: //send 4 week of email

                    //Question part c
                    System.out.println("/************Week1***************/");
                    //Send email for week 1
                    sendWeekly(customerList, 1);

                    System.out.println("/***********Week2*************/");
                    //Changing supplement subscribe list for week 2
                    System.out.println(p1);
                    p1.removeSupplement(s1);
                    p2.addsupplement(s1);
                    a1.addsupplement(s2);
                    a2.addsupplement(s5);
                    a3.addsupplement(s1);
                    //Send email for week 2
                    sendWeekly(customerList, 2);

                    System.out.println("/*************Week3**********/");
                    //Changing supplement list for week 3
                    p1.addsupplement(s3);
                    p2.removeSupplement(s3);
                    a1.removeSupplement(s1);

                    //Send email for week 3           
                    sendWeekly(customerList, 3);

                    System.out.println("/**************Week4********/");
                    //Changing supplement list for week 4
                    a2.addsupplement(s4);
                    a3.addsupplement(s2);

                    //Send email for week 4
                    sendWeekly(customerList, 4);

                    break;

                case 3: //Send monthly bill to Paying Customer
                    sendMonthly(customerList);
                    break;

                case 4: // add new customer
                    addNewCustomer(customerList);
                    break;

                case 5:// remove customer
                    removeCustomer(customerList);
                    break;

                case 6:// display all customer
                    System.out.println(customerList);
                    break;

                default:
                    exit = true;
            }
        }
    }

    public static void menu() //output for main menu
    {
        System.out.println("\n--------Main Menu--------");
        System.out.println("1. Construct a Magazine");
        System.out.println("2. Print out the text of all the emails for all customers for four weeks of magazines ");
        System.out.println("3. Print out the text for the end of month emails for the paying customers");
        System.out.println("4. Add a new customer to the magazine service");
        System.out.println("5. Remove an existing customer from the magazine service");
        System.out.println("6. Display all customer");
        System.out.println("99. Any other number to exit");
    }

    //remove a customer from customer arraylist
    public static void removeCustomer(ArrayList<Customer> list)
    {
        Scanner input = new Scanner(System.in);
        String email; //to store the email from user input
        boolean exist = false;
        System.out.println("Number of customer : " + list.size());
        System.out.println("Enter the email of customer to remove");
        email = input.nextLine();

        for (int i = 0; i < list.size(); i++)
        {
            if (email.equals(list.get(i).getEmail()))
            {
                list.remove(i);
                System.out.println("Customer Removed\n");
                exist = true;
                System.out.println("Number of Customer : " + list.size() + "\n");

            }
        }
        if (exist == false)
        {
            System.out.println("Customer does not exist\n");
        }

    }

    //Add a new customer to customer arraylist
    public static void addNewCustomer(ArrayList<Customer> list)
    {
        Scanner input = new Scanner(System.in);
        int custType, payType;
        String name, email, bank, payername;

        System.out.println("Choose the type of customer");
        System.out.println("1. Paying Customer");
        System.out.println("2. Associate Customer");
        custType = input.nextInt();
        input.nextLine(); //clear \n buffer
        if (custType == 1) //Create Paying customer
        {
            System.out.println("Paying Customer");
            System.out.println("Enter customer name");
            name = input.nextLine();
            System.out.println("Enter customer email");
            email = input.nextLine();
            System.out.println("Enter Bank name");
            bank = input.nextLine();
            System.out.println("Choose Payment type");
            System.out.println("1. Debit card\n2. Credit Card");
            payType = input.nextInt();
            PayingCust tempcust = new PayingCust(name, email, bank, payType);
            if (checkCustExist(tempcust, list) == true)
            {
                System.out.println("Customer already exist");
            } else
            {
                list.add(tempcust);
                System.out.println("Customer added");
            }

        } else if (custType == 2)//Create Associate Customer
        {
            System.out.println("Associate Customer");
            System.out.println("Enter customer name");
            name = input.nextLine();
            System.out.println("Enter customer email");
            email = input.nextLine();
            System.out.println("Enter name of paying customer");
            payername = input.nextLine();
            PayingCust paytemp = new PayingCust(payername, "");
            AssoCust assotemp = new AssoCust(name, email, paytemp);
            if (checkCustExist(assotemp, list) == true)
            {
                System.out.println("Customer already exist");
            } else
            {
                list.add(assotemp);
                System.out.println("Customer added");
            }

        } else
        {
            System.out.println("Invalid input");
        }

    }

    //method to check whether the customer already exist in Customer arraylist
    //return true if yes, false if no
    public static boolean checkCustExist(Customer cust, ArrayList<Customer> list)
    {
        boolean flag = false;
        for (int i = 0; i < list.size(); i++)
        {
            if (cust.getEmail().equals(list.get(i).getEmail()))
            {
                flag = true;
            }
        }
        return flag;
    }

    //method to send monthly email to paying customer
    public static void sendMonthly(ArrayList<Customer> list)
    {
        double totalcost;// store total cost of one month
        double pccost; // store paying customer magazine cost
        double accost; // store associate customer magazine cost
        double maincost;// store maincost of magazine
        
        PayingCust temp = new PayingCust();
        ArrayList<AssoCust> assoctemp = new ArrayList<>();
        
        for (int i = 0; i < list.size(); i++)
        {
            if (list.get(i) instanceof PayingCust)
            {
                pccost = calculateCost(list.get(i).getSupplement()); //calculate cost for paying customer 
                temp = (PayingCust) list.get(i);
                accost = calculateAssociate(temp.getAssociate()); // calculate cost for associate customer
                totalcost = (pccost + accost) * 4;
                maincost = (5 + 5 * temp.getAssociate().size()) * 4;// calculate total main cost of both paying and associate
                System.out.println("To :" + list.get(i).getEmail());
                System.out.println("\n$" + totalcost + " has been charge to your " + temp.getPayment());
                System.out.println("\nTotal main cost = $(5 + 5 X no of associate) * 4 week = $" + maincost);
                System.out.println("TotalCost of your magazine subscription is $" + pccost * 4);
                System.out.println("\nYour list of supplement");
                System.out.println(temp.listToString());
                System.out.println("Your Associate and their list of supplment");

                assoctemp = temp.getAssociate();

                double oneAssocost; //store cost of one associate customer
                for (int a = 0; a < assoctemp.size(); a++)
                {
                    System.out.println(assoctemp.get(a).getName());
                    oneAssocost = calculateCost(assoctemp.get(a).getSupplement()) * 4;
                    System.out.println("Total cost = $" + oneAssocost);
                    System.out.println("Their list of supplement");
                    System.out.println(assoctemp.get(a).listToString());
                }

                System.out.println("****************************");
            }
        }

    }

    //calculate the total cost of associate customers
    public static double calculateAssociate(ArrayList<AssoCust> list)
    {
        double cost = 0;
        for (int i = 0; i < list.size(); i++)
        {
            cost = cost + calculateCost(list.get(i).getSupplement());
        }
        return cost;
    }

    //calculate the cost of 1 week of magazine
    public static double calculateCost(ArrayList<Supplement> list)
    {
        double cost = 5.0;
        for (int i = 0; i < list.size(); i++)
        {
            cost = cost + list.get(i).getCost();
        }
        return cost;
    }

    //output for the weekly email
    public static void sendWeekly(ArrayList<Customer> list, int w)
    {
        for (int i = 0; i < list.size(); i++)
        {
            System.out.println("TO : " + list.get(i).getEmail());
            System.out.println("Your magazine for week " + w + " is ready");
            System.out.println("List of Supplement Subscribed");
            System.out.println(list.get(i).listToString());
        }
    }

    //method to construct a magazine
    public static Magazine constructMagazine(ArrayList<Supplement> yes)
    {
        ArrayList<Supplement> newSupplist = new ArrayList<>();
        Supplement temp = new Supplement();
        Boolean flag = false;
        int choice, year, month, week;
        double cost;
        Scanner input = new Scanner(System.in);

        //taking input from user to construct magazine
        System.out.println("Enter the Published Year");
        year = input.nextInt();

        System.out.println("Enther the month(number)");
        month = input.nextInt();

        System.out.println("Enter the week (1-4)");
        week = input.nextInt();

        System.out.println("Enter the main cost of magazine");
        cost = input.nextDouble();

        System.out.println("Choose a maximum of 5 supplement from below");
        while (!flag) //while loop to choose a max of 5 supplement
        {
            supplementChoice(yes); // Display the availabe supplement
            choice = input.nextInt();
            switch (choice)
            {
                case 0:
                    temp = yes.get(0);
                    break;
                case 1:
                    temp = yes.get(1);
                    break;
                case 2:
                    temp = yes.get(2);
                    break;
                case 3:
                    temp = yes.get(3);
                    break;
                case 4:
                    temp = yes.get(4);
                    break;
                case 5:
                    temp = yes.get(5);
                    break;
                case 6:
                    temp = yes.get(6);
                    break;
                case 7:
                    temp = yes.get(7);
                    break;
                case 8:
                    temp = yes.get(8);
                    break;
                default:
                    flag = true;

            }
            if (checkIfExist(temp, newSupplist) == true && flag == false) //check if the supplement already exist
            {
                System.out.println("Supplement already exist");
            } else
            {
                newSupplist.add(temp);
            }
            if (newSupplist.size() == 5)
            {
                flag = true;
            }
            System.out.println("\nNum of Supplement chosen:" + newSupplist.size());
        }

        Magazine m2 = new Magazine(cost, newSupplist, year, month, week);

        return m2;
    }

    //check if the supplement already exist
    public static boolean checkIfExist(Supplement s, ArrayList<Supplement> list)
    {
        boolean exist = false;
        for (int i = 0; i < list.size(); i++)
        {
            Supplement temp = list.get(i);
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

    //output menu for choosing of supplement
    public static void supplementChoice(ArrayList<Supplement> yes)
    {

        for (int i = 0; i < yes.size(); i++)
        {
            System.out.print(i + "." + yes.get(i).toString());
        }
        System.out.println("99. Any other number to quit");
        System.out.println("Enter the number of your choice");
    }

    //display Student Details
    public static void displayStudentDetails()
    {
        System.out.println("Name:\t\t\t Aung Kyaw Myint");
        System.out.println("Student Number:\t\t 33237826");
        System.out.println("Mode of enrolment:\t External");
        System.out.println("Tutor name:\t\t Sarita Singh");
        System.out.println("Tutorial attendance day & time: Wednesday 8:30 AM");
    }

    //method to add a list of supplement
    public static void availableSupplement(ArrayList<Supplement> yes)
    {

        yes.add(new Supplement("Art & craft", 2.0));
        yes.add(new Supplement("Business", 3.0));
        yes.add(new Supplement("Celebrity", 2.5));
        yes.add(new Supplement("Children", 1.5));
        yes.add(new Supplement("Education", 5.0));
        yes.add(new Supplement("Fictions", 3.5));
        yes.add(new Supplement("Health Care", 1));
        yes.add(new Supplement("Photography", 4.0));
        yes.add(new Supplement("Techonology", 1.5));

    }
}
