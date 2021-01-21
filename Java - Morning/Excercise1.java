/*
    Write a Java Program to print the sorted list of integer by using one of the collection set 
*/

import java.util.*;

public class Excercise1 {
   public static void main(String[] args) {
    
    Scanner sc = new Scanner(System.in);
    HashSet<Integer> set = new HashSet<Integer>();
    
    // Taking Input in HashSet
    System.out.println("Enter the Number of Elements");
    int n = sc.nextInt();

    for(int i=0;i<n;i++)
    {
        set.add(sc.nextInt());
    }

    // Sorting Hashset in Ascending Order
    ArrayList<Integer> list = new ArrayList<Integer>(set);
    Collections.sort(list);

    set = new HashSet<Integer>(list);

    // Displaying Integer of the Hashset using Iterator 
    Iterator<Integer> itr = set.iterator();
    System.out.println("Elements of HashSet in Ascending Order are : ");
    while(itr.hasNext())
    {
        System.out.print(itr.next() + " ");
    }
    
    sc.close();
   } 
}
