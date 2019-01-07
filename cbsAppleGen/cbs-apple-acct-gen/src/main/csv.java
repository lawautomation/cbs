package main;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class csv {

	String emailTitle = "Email:  ";
	String pwdTitle = "Password:  ";
	
    public void csvWrite(String email, String password) throws IOException {
	       PrintWriter pw = new PrintWriter(new File(config.getCSVConfig())); 
	       StringBuilder sb = new StringBuilder(); 
	       String e = email;
	       String p = password;
	       
	       sb.append(emailTitle);
	        sb.append(e);
	        sb.append('\n');
	        sb.append(pwdTitle);;
	        sb.append(p);
	        
	        pw.write(sb.toString());
	        pw.close();
    }

	public void csvWriter(String email, String password) throws IOException {
		csvWrite(email, password);
		
	}
}
