package group187.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Array;

import dw317.hotel.business.interfaces.Customer;
import dw317.hotel.business.interfaces.Reservation;


public class ListUtilities {
	private ListUtilities(){}
	public static int recordCount;
	@SuppressWarnings("null")
	public static void saveListToTextFile(Comparable[] array, File file) throws FileNotFoundException {
		if (array == null)
			throw new IllegalArgumentException("The array "+array.toString() +" is null");
		if (!file.exists())
			throw new FileNotFoundException("The file cannot be found");
		PrintWriter printWriter = null;
        try {
            printWriter = new PrintWriter(new FileOutputStream(new File(file.getPath()),true));
            for (int i = 0; i < array.length; i++) {
            	if (array[i] == null)
            		continue;
                printWriter.println(array[i].toString());
                recordCount++;
            }
        } catch (NullPointerException npe) {
        	System.out.println("cant print to file");
        	npe.printStackTrace();
            
        } finally {
            if (printWriter != null) {
                printWriter.close();
            }
        }
		
	}
	
			//		

	/*
	* Sorts a list of objects in ascending natural order using
	* selection sort.
	*
	* Precondition: Assumes that the list is not null and that the
	* list's capacity is equal to the list's size.
	*
	*
	* @param list A list of objects. Assumes that the
	* list's capacity is equal to the list's size.
	*
	* @throws IllegalArgumentException if the parameter is
	* not full to capacity.
	*
	* @throws NullPointerException if the list is null.
	*/
	/**@SuppressWarnings({ "rawtypes", "unchecked" })
	 * THIS IS METHOD FOR PHASE 3 that uses GENERICS, he wants us to code it with Comparable
	public static <E extends Comparable<E>>void sort(E[] list) 
			throws IllegalArgumentException, NullPointerException {
		if (list == null)
			throw new IllegalArgumentException("List is null");
		for (int i = 0; i < list.length; i ++)
			if (list[i] == null)
				throw new IllegalArgumentException("list is not filled to capacity or has null element");
		
		for (int i = 0; i < list.length - 1; i++) {
	            // find index of smallest element
	            int smallest = i;
	            for (int j = i + 1; j < list.length; j++) {
	                if (list[j].compareTo(list[smallest])<=0) {
	                    smallest = j;
	                }
	            }

	            swap(list, i, smallest);  // swap smallest to front
	        }
	}
	
	  private static <E> void swap(E[] a, int i, int j) {
	        if (i != j) {
	            E temp = a[i];
	            a[i] = a[j];
	            a[j] = temp;
	        }
	    }
	    */
	@SuppressWarnings({ "rawtypes", "unchecked", "null" })
	public static void sort(Comparable[] list) throws IllegalArgumentException, NullPointerException{
		
		if (list == null)
			throw new IllegalArgumentException("List is null for "+ list.toString());
		if (!isNullElement(list))
			throw new IllegalArgumentException("Element for " + list.toString()+" is null");
			
         int smallindex;
         for(int i = 0; i < list.length; i++)
         {
              smallindex = i; // set first element as smallest
              for(int j = i + 1; j < list.length; j++) // find smallest
                   if(list[j].compareTo(list[smallindex]) < 0)
                        smallindex = j;
              if(smallindex != i)
                   swap(list, smallindex, i);
         }
    }

	/**
     * Swap for two elements of an array of Objects
     * @param array the Objects to sort
     * @param index1 the index of the first element to swap
     * @param index2 the index of the second element to swap
     */
    static void swap(Object[] array, int index1, int index2)
    {
         Object temp = array[index1];
         array[index1] = array[index2];
         array[index2] = temp;
    } 
	
    @SuppressWarnings({ "rawtypes" })
    private static boolean isNullElement(Comparable[] list) {
    	
    	for (int i = 0; i < list.length; i ++)
			if (list[i] == null)
				return false;
		return true;
	}
    
	/**
	 * The method must merge two sorted object lists referenced by list1 and list2 into a third
	object list (created in the merge method). When the lists have been merged, the merge
	method returns a reference to the third object list. NOTE: this method must be efficient!
	Take advantage of the fact that the two lists are already sorted!
	In order to create the third list from within the merge method with the same base ty
	pe as those of the arrays that you are merging, you will have to use the approach below.
	This is necessary to ensure that you will not end up with a ClassCastException
	when you cast the array returned from the merge array to a Customer[ ] or a
	Reservation[] in the application class
	 */
	/*
	* Efficiently merges two sorted lists of objects in ascending
	* natural order. If the duplicate objects are in both lists,
	* the object from list1 is merged into the resulting list, and
	420-317-DW Fall 2016
	J. Nilakantan, N. Hallam 3/6 Dawson College
	* both objects are written to the duplicate file.
	*
	* Precondition: Assumes that the lists are not null and that
	* both lists contain objects that can be compared to
	* each other and are filled to capacity.
	*
	*
	* @param list1 A naturally sorted list of objects. Assumes
	* that the list contains no duplicates and that
	* its capacity is equal to its size.
	* @param list2 A naturally sorted list of objects. Assumes
	* that the list contains no duplicates and that
	* its capacity is equal to its size.
	* @param duplicateFileName The name of the file in
	* datafiles\duplicates to which duplicate pairs
	* will be appended.
	*
	* @throws IllegalArgumentException if either parameter is
	* not full to capacity.
	*
	* @throws NullPointerException if the either list is
	* null.
	*/
	 	//@SuppressWarnings({ "rawtypes", "unchecked" })
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static Comparable[] merge(Comparable[] list1,Comparable[] list2, String duplicateFileName)throws IOException{
			
		Comparable[] list1 = {5, 7, 8, 77, 88, 111},
			      list2 = {2, 3, 5, 7, 10, 55},
			      list3 =  (Comparable[]) Array.newInstance(
			    		  list1.getClass().getComponentType(), list1.length + list2.length);
			int l1counter = 0;
			int l2counter = 0;
			boolean isReservation = false;
			boolean isCustomer = false;
			File duplicates = new File("datafiles/duplicates/mergeduplicates.txt");
			duplicates.createNewFile();
			
			if (list1[0] != null){
				if (list1[0] instanceof Reservation)
					isReservation = true;
				else if (list1[0] instanceof Customer)
					isCustomer = true;
			}
			else
				return list3;
			
			for (int i =0; i < list1.length + list2.length; i++)
			{
				if (l1counter != list1.length && l2counter != list2.length)
				{
					if (isReservation){
						if (((Reservation)list1[l1counter]).compareTo((Reservation) list1[l1counter]) == 0)
							ListUtilities.saveListToTextFile(((Reservation)list1[l1counter]).toString().split("\\*"), file);
						if (((Reservation)list1[l1counter]).compareTo((Reservation) list1[l1counter]) < 0){
							list3[i] = list1[l1counter];
							l1counter++;
						}
						else{
							list3[i] = list2[l2counter];
							l2counter++;
						}
					
					}
					
					else if (isCustomer){
						if (((Customer)list1[l1counter]).compareTo((Customer) list1[l1counter]) == 0)
							ListUtilities.saveListToTextFile(list1[1].toString().split("\\*"), file);
						if (((Customer)list1[l1counter]).compareTo((Customer) list1[l1counter]) < 0){
							list3[i] = list1[l1counter];
							l1counter++;
						}
						else{
							list3[i] = list2[l2counter];
							l2counter++;
						}
					
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
				
	 			for (Comparable arr : list3)
	 				System.out.println(arr.toString());
	 			System.out.println(duplicates);
	}
				


	
}