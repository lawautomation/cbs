package main.Creds;

public class crediential implements creds{
	//put in login info
	private final static String LOGIN = "test@email.com";
	//put in password info
	private final static String PASSWORD = "password";
	
	public String getLogin(){
			return LOGIN;	
	}
	
	public String getPwd(){
		return PASSWORD;	
}
}
