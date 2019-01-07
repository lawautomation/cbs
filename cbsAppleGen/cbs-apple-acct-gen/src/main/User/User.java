package main.User;

import main.User.userEnum;

public class User {
	
    private static String firstName = null;
    private static String lastName = null;
    private static String password = null;
    private static String confirmPwd = null;
    private static String secretQ = null;
    private static String secretA = null;
    private static String email = null;
    private static String territory = null;
    
	public User(userEnum userType) {
		
		int i = (int) (Math.random()*10000);
		String e = "may@c"+ i+".com";

        switch (userType) {
            case USAccount:
                firstName = "Sherdon";
                lastName = "Cooper";
                email = e;
                password = "cbs123456";
                confirmPwd = "cbs123456";
                secretQ = "What does Olga like?";
                secretA = "llamas";  
                territory = "USA"; 
                break;
        
         case AUAccount:
         firstName = "Sherdon";
         lastName = "Cooper";
         email = e;
         password = "cbs12345";
         confirmPwd = "cbs12345";
         secretQ = "What does Olga like?";
         secretA = "llamas";  
         territory = "AUS"; 
         break;
	
        case CAAccount:
        firstName = "Sherdon";
        lastName = "Cooper";
        email = e;
        password = "aaaaaaaa";
        confirmPwd = "aaaaaaaa";
        secretQ = "What does Olga like?";
        secretA = "llamas";  
        territory = "CAN"; 
        break;}}
        
	    public String firstName() {
		return firstName;
	}
	    
	    public String lastName() {
		return lastName;
	}

		public static String password() {
	        return password;
	    }
		
		public String confirmPwd() {
	        return confirmPwd;
	    }

		public String secretQ() {
	        return secretQ;
	    }
		
		public String secretA() {
	        return secretA;
	    }
		
		public static  String email() {
	        return email;
	    }
		
		public String territory() {
	        return territory;
	    }

}
                	
