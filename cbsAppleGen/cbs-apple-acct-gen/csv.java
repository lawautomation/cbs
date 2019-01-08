package main;

import java.io.IOException;
import java.io.PrintWriter;

public class csv {

	String emailTitle = "Email:  ";
	String pwdTitle = "Password:  ";    
    StringBuilder sb = new StringBuilder(); 
    
    public void csvWrite(String email, String password, byte count, PrintWriter pw2) throws IOException {
    	
	       String e = email;
	       String p = password;
	       byte c = 1;
	     	 
	           sb.append('\n');
		      sb.append(emailTitle);
		      sb.append(e);
		      sb.append('\n');
		      sb.append(pwdTitle);;
		      sb.append(p);	 
		      sb.append('\n');
		     pw2.write(sb.toString());    
    }
	public void csvWriter(String email, String password, byte count, PrintWriter pw) throws IOException {
		csvWrite(email, password, count, pw);
		
	}
}