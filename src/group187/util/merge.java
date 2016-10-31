package group187.util;

import dw317.hotel.business.interfaces.Customer;
import dw317.hotel.business.interfaces.Reservation;

public class merge {

	public static void main(String[] args) {
		Comparable[] list1 = {2, 4,6,8,9,99},
			      list2 = {3, 7, 8, 32, 45, 66};
		Comparable[] 
			      list3 = new Comparable[11];

		list3 = merge(list1,list2);
		for (Comparable arr: list3)
			System.out.println(arr.toString());
		
	}
	
	public static Comparable[] merge(Comparable[] list1, Comparable[] list2)
	{
		Comparable[] 
			      list3 = new Comparable[11];
		int l1counter = 0;
		int l2counter = 0;
		boolean isReservation = false;
		boolean isCustomer = false;
		if (list1[0] != null){
			if (list1[0] instanceof Reservation)
				isReservation = true;
			else if (list1[0] instanceof Customer)
				isCustomer = true;
		}
		else
			return list3; 
		 for (int i =0; i < list1.length + list2.length-1; i++)
       {
           if (l1counter != list1.length && l2counter != list2.length)
           {
          	 
               if ((list1[l1counter].compareTo(list2[l2counter])) < 0){
                   list3[i] = list1[l1counter];
                   l1counter++;
               }
               else if ((list1[l1counter].compareTo(list2[l2counter])) == 0){
            	   list3[i] = list1[l1counter];
               		l2counter++;
               		l1counter++;
               		
               }
               else{
                   list3[i] = list2[l2counter];
                   l2counter++;
               }
          
           }
           else
           {
               if (l1counter == list1.length)
               {
                   list3[i] = list2[l2counter];
                   l2counter++;
               }
               else
               {
                   list3[i] = list1[l1counter];
                   l1counter++;
               }
           }
       }
		 return list3;
	}

}
