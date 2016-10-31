package test;

import dw317.lib.Name;

public class RegexTest {

	public static void main(String[] args) {
		String
			   e1 = "Test@tes!t.com",
			   e2 = "Eric@dawsonCollege.qc.ca",
			   e3 = "MurdaMyles@Pinto..ca",
			   e4 = "cprice31@canadiens.com",
			   e5 = "B-_.a@te..st.com",
			   e6 = "Support@fa.ce.bo.ok.com",
			   e7 = "John.busines.s@gmail.com";
		
		System.out.println(Name.isValidString(e1, 1));
		System.out.println(Name.isValidString("John ", 2));
		System.out.println(Name.isValidString(e4, 1));
		System.out.println(Name.isValidString(e7, 1));

	}

}
