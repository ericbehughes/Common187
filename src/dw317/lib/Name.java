package dw317.lib;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

// TODO: Auto-generated Javadoc
/*
 * The Name class must validate the first and last names 
 * (refer to Lab 2 where you validated the Address class).
 *  Both first and last names must each contain at least 2
 *   letters. In addition to letters, the characters 
 *   � (apostrophe), - (hyphen) and space between two letters are 
 *   valid. All validation is case-insensitive.
 * 
 * */

/**
 * The Class Name.
 */
public class Name 
{
	

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 42031768871L;
	
	/** The first name. */
	private String firstName;
	
	/** The last name. */
	private String lastName;
	
	/**
	 * Instantiates a new name.
	 *
	 * @param firstName the first name
	 * @param lastName the last name
	 * @throws IllegalArgumentException the illegal argument exception
	 */
	public Name(String firstName, String lastName) throws IllegalArgumentException
	{
		if (isValidString(firstName, 2) && isValidString(lastName, 2)){
			this.firstName = firstName;
			this.lastName = lastName;
		}
		else
			throw new IllegalArgumentException();
	}
	
	/**
	 * Instantiates a new name.
	 *
	 * @param name the name
	 */
	public Name(Name name)
	{
		this.firstName = name.firstName;
		this.lastName = name.lastName;
	}
	
	// both first and last name must be >= 2
	// characters, apostrophe hyphen and space between two letters are valid
	

	/**
	 * Checks if is valid string.
	 *
	 * @param string the string
	 * @param minLength the min length
	 * @return true, if is valid string
	 */
	public static boolean isValidString(String string, int minLength)
	{
		
		if (string.length() < minLength)
			return false;
		if (minLength == 1)
			if (string.length() > 32)
				return false;
		
		 // String to be scanned to find the pattern.
	      
	      String pattern = "^[a-zA-Z0-9]*$";
	      // Create a Pattern object
	      Pattern r = Pattern.compile(pattern);

	      // Now create matcher object.
	      Matcher m = r.matcher(string);
	      if(m.find());
		return true;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return this.firstName + "*"+ this.lastName;
	}
			
	/**
	 * Gets the first name.
	 *
	 * @return the first name
	 */
	public String getFirstName()
	{
		return this.firstName;
	}
	
	/**
	 * Gets the last name.
	 *
	 * @return the last name
	 */
	public String getLastName()
	{
		return this.lastName;
	}
		
	}