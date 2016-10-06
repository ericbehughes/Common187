package dw317.lib;

import java.io.Serializable;

public class Email implements Serializable, Comparable<Email> {
	private static final long serialVersionUID = 42031768871L;
	private final String address;
	
	public Email(String address){
		
		if (!validateEmail(address))
			throw new IllegalArgumentException();
		this.address = address;
		//.///
	}
	public Email(Email email)
	{
		this.address = email.address;
	}
	
	public String getAddress() {
		return address;
	}
	
	public String getUserId() {
		String str = getAddress().split("@")[0];
		return str;
	}
	
	public String getHost() {
		String str =  getAddress().split("@")[1];
		return str;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public final int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address.toUpperCase() == null) ? 0 : address.toUpperCase().hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public final boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Email))
			return false;
		Email other = (Email) obj;
		if (address == null) {
			if (other.address != null)
				return false;
	} else if (!address.equalsIgnoreCase(other.address))
	return false;
		
		return true;
		
	}
	
	
	@Override
	public String toString() {
		return getAddress();
	}
	
	public boolean validateEmail(String address){
		//dot cannot be first or last character of userid and no consecutive dots
		//can't have hyphen as first or last either
		String host = address.split("@")[1];
		String userID = address.split("@")[0];
		String[] hosts = hostSplit(host);
		if(checkLength(userID))
			return false;
		if(!Name.isValidString(userID, 1))
			return false;
		for(int i = 0 ; i < hosts.length ; i++){
			if(checkLength(hosts[i]))
				return false;
			if(!Name.isValidString(hosts[i], 1))
				return false;
		}
		
		return true;
	}
	
	private static String[] hostSplit(String host){
		return host.split(".");
	}
	
	private static boolean checkLength(String input) {
		if(input.length() > 1 || input.length() < 32)
			return false;
		return true;
	}

	//Email must implement the compareTo method. Emails are naturally ordered by their case-insensitive host name, 
	//followed by case-insensitive userid. So zhu@abc.com is before A@ba.com

	@Override
	public int compareTo(Email o) {
		
		if (o == null)
			throw new NullPointerException();
		// handle if same host id
		if (this.getHost().equalsIgnoreCase(o.getHost())){
				if (this.getUserId().equalsIgnoreCase(o.getUserId())){
					return 0; //same everything
				// same host but different userID
				}
				else if (this.getUserId().compareToIgnoreCase(o.getUserId()) > 0)
					return -1;
				else if (this.getUserId().compareToIgnoreCase(o.getUserId()) < 0)
					return 1;
		}
		//handle for different hosts
		else if (this.getHost().compareToIgnoreCase(o.getHost())> 0)
			return -1;
		return 1;
	}
}