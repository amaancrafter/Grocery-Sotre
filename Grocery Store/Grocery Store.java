import java.io.*;
public class DisplayList
{ public static void main(String args[])
{
display();
}
public static void display()
{ int i;
ListOfItems l=null;
try
{
FileInputStream fin=new FileInputStream("List Of Items.txt");
ObjectInputStream in= new ObjectInputStream(fin);
l=(ListOfItems)in.readObject();
in.close();
fin.close();
} catch(IOException e)
{
System.out.println(e);
} catch(ClassNotFoundException a)
{
System.out.println(a);
return;
} //System.out.println("Welcome to Harshita's Grocery Store");
System.out.println("Here's the List of Items, plz go through the list to select items that
you want to shop for,Thank You");
for(i=0;i<20;i++)
{
System.out.println("Item: - "+l. item[i]+"\t\tID: "+l.ID[i]+"\tPrice: "+l. price[i]);
}
System.out.println("Enjoy Shopping :D");
}}
2.	Class ListOfItems
public class ListOfItems implements java.io.Serializable
{
public String[] item=new String[20];
public int[] ID= new int[20];
public int[] price=new int[20];
}
3.	Class ShoppersStop

import java.io. *;
import java.util.*;
public class ShoppersStop
{
public static void main(String args[])
{
String ch;
String address;
int itemid;
int bill=0;
int i;
int flag=1;
int quant;
String id;
Scanner sc=new Scanner(System.in);
ListOfItems l=null;
try
{
FileInputStream fin=new FileInputStream("List Of Items.txt");
ObjectInputStream in= new ObjectInputStream(fin);
l=(ListOfItems)in.readObject();
in.close();
fin.close();
} catch(IOException k)
{
System.out.println(k);
} catch(ClassNotFoundException a)
{
System.out.println(a);
return;
}
System.out.println("Welcome dear Customer to AKS Grocery Store");
System.out.println("Are you a first time user?? \n Kindly Press 'Y' for Yes and 'N' for
No");
ch=sc.next();
switch(ch)
{ case "
Y":
System.out.println("Enter your user id");
id=sc.next();
System.out.println("Thank You for registering with us");
break;
case "N":
System.out.println(" You are already a registered user.");
System.out.println("Plzz enter your id for log-in");
id=sc.next();
System.out.println("Log In successful");
break;
default:
System.out.println("plz run the program again...cuz the value you enterd is neither Y
nor N");
}
System.out.println("Prsenting to you the items we have for sale in our grocery store");
DisplayList ob2=new DisplayList();
ob2.display();
System.out.println("For selecting the items, plz enter their user id and quantity");
System.out.print("Shopping Cart items...");
bill=0;
while(flag!=0)
{
System.out.println("Enter id");
itemid=sc.nextInt();
System.out.println("Enter Quantity");
quant=sc.nextInt();
for(i=0;i<20;i++)
{
int m=l.ID[i];
if(itemid==m)
bill=bill+quant*(l.price[i]);
}
System.out.println("Do you want to add more items?? Enter 1 for Yes and 0 for no");
flag=sc.nextInt();
if (flag==0)
break;
}
System.out.println();
System.out.println("Thank you for shopping with us");
System.out.println("Your total bill is="+bill);
System.out.println("The mode of payment is Cash on Delivery");
System.out.println("Plz enter shipping address=");
address=sc.next();
System.out.println("Thank you, your order will be shipped to you in 3-4 days, kindly
keep ready Rs"+bill+" for payment");
}}
4. Class StoringList

import java.util.Scanner;
import java.io.*;
public class StoringList
{
public static void main(String args[])
{
Scanner sc=new Scanner(System.in);
ListOfItems l=new ListOfItems();
int i;
System.out.println("Enetr the list of items, their ID and price that you want to display
in your Grocery Store");
for(i=0;i<20;i++)
{
System.out.println("Item Name");
l.item[i]=sc.next();
System.out.println("ID");
l.ID[i]=sc.nextInt();
System.out.println("Price");
l.price[i]=sc.nextInt();
System.out.println();
} try
{
FileOutputStream fw=new FileOutputStream("List of Items.txt");
ObjectOutputStream out=new ObjectOutputStream(fw);
out.writeObject(l);
out.close();
fw.close();
} catch(IOException e)
{
System.out.println(e);
}}
}
