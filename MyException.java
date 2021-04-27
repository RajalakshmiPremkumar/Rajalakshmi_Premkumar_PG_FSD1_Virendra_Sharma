package programs.java.project.phase1;

public class MyException extends Exception{

	String excptn =null;
	   MyException(String b) {
		   excptn=b; 
	   }
	   
	   public String toString() {
		   return (" Error :: "+excptn) ;
	   }
	  
}
