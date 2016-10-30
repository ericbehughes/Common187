package dw317.lib;

public class RegexTest {

	public static void main(String[] args) {
		//String regex ="^[A-Za-z0-9]{1}[A-Za-z0-9-_{1}]{1,31}@[A-Za-z0-9-]{1}[\\.]?{1}[A-Za-z0-9]{1,10}[\\.][A-Za-z0-9\\.]{1,15}[A-Za-z0-9]{1,5}$",
		String regex = "^[A-Za-z0-9]+([_A-Za-z0-9-]+)@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,3})$",
			   e1 = "Test@test.com",
			   e2 = "Eric@dawsonCollege.qc.ca",
			   e3 = "MurdaMyles@Pinto..ca",
			   e4 = "cprice31@canadiens.com",
			   e5 = "B-_.a@te..st.com",
			   e6 = "Support@fa.ce.bo.ok.com",
			   e7 = "John.busines.s@gmail.com";
		
		System.out.println(Name.isValidString("John ", 2));
		System.out.println(Name.isValidString(e4, 1));

	}

}
