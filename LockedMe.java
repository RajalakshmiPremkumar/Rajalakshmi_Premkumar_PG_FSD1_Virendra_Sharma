package programs.java.project.phase1;


//Importing required packeages for this Application
import java.util.*;
import java.io.*;





/**
* @author Rajalakshmi Premkumar
*LockedMe.com  Program
*Takes the y
*/
public class LockedMe {


		//Class variable dirAllFile is created to store the file list from a directory.
		TreeSet<String> dirAllFile = new TreeSet<String>();
		

/**
* This retrieveFiles Method is used to retrieve all files from the given directory.
* uses TreeSet to store the file list.As Treeset has the property to not allow duplicates and sort in ascending order.
 * If the given directory is empty it prints the empty directory message
 *
*/

		
		public void retrieveFiles() {

			try {
					
				File fileDir = new File("/Users/rajalakshmip/Documents/Phase1");

				if(fileDir.isDirectory()) { //checks if the file path is a directory
					
					String[] files = fileDir.list();
					if(fileDir.exists()) {
				
					System.out.println("Files sorted in Ascending order for the "+ fileDir.getName()+ " directory: ");
					System.out.println("***************************************************************************");
					
					for(String s: files)
					{
						dirAllFile.add(s);
					
					}
					
			        
			       dirAllFile.forEach(System.out::println);
			        
					}
				}
					
				else {
						System.out.println(fileDir.getName()+ " Empty directory and No files present inside");
					}
			
		
	}
		catch(Exception e) {
			System.out.println("Error Occured"+ e);
		}

		
		}
		
/**
* This businessOprFiles Method 
* get user Input to add/Delete/Search Operation on the file
* Switch case is used to control the flow
* @param navigate boolean variable is used to go to main menu when the navigate option is chosen.by setting th eflag to truw
* @throws InputMismatchException 
*
*/
		
		public void	businessOprFiles(boolean navigate) throws InputMismatchException {
			
			
			
			subMenu();

		   	int userChoice =0;
		   	userChoice = usrInput1();
		   	
		   	switch(userChoice){
		   	
					    case 1: System.out.println("Add the file");  
						     	addFile();
						     	break;
				     	
						case 2: System.out.println("Delete the file");  
						 		deleteFile();
						 		break;
						 		
						 		
						case 3: System.out.println("Search the file");  
							 	searchFile();
							 	break;
						  
						case 4: System.out.println("Go to Main Menu");
								mainMenu();
								navigate=true;
								break;
								
		   	}
			
			//input.close();
			
		}
		
/**
* This addFile Method 
* gets the text file Input from the user .
* if the user specified already present in the directory.Display File already present Message.
* otherwise add the user specified file to the directory.
*/
				
		public void addFile() {

				
			String add_FileName=null;
		 	 
			Scanner usrInput = new Scanner(System.in);
			
			try {
				
				System.out.println("Please Enter the Text File to be Added to the Application Without Extension" );
				
				add_FileName = usrInput.nextLine();
		
				System.out.println("Entered filename is " + add_FileName); 
			
				File  filePath = new File("/Users/rajalakshmip/Documents/Phase1/"+add_FileName+".txt");

				
					if(filePath.exists()) {            		//checks if the text file is present
						System.out.println("****************************************");
						System.out.println("Text File  "+ add_FileName+ " is Already Present");
						System.out.println("****************************************");
						dirAllFile.add(add_FileName+".txt");
					}
					
					else { 									//file not present new text file will be created
						if(filePath.createNewFile()) {
							System.out.println("****************************************");
							System.out.println("New Text File "+add_FileName + " is Created");
							System.out.println("****************************************");
						}
						}
				//usrInput.close();
				}
			
			catch(IOException e) {
				System.out.println("IOException Occured while adding the file");
			}
			catch(Exception e) {
				System.out.println("Irror occured while adding the file.Check the below trace for Reference.");
				e.printStackTrace();
			}
			
			
		}
/**
* This deleteFile Method 
* gets the text file Input from the user .
* checks for the case sensitivity of the file in the directory and user specified file and deletes the corresponding file.
* @throws MyException is used to throw "TextFileNot found error" , if the user specified file is not present in the directory.
*/
					 

		public void deleteFile() {
			
			try {
				
				String delete_FileName=null;
			 	 
				Scanner usrInput = new Scanner(System.in);
				
				System.out.println("Please Enter the text file to be Deleted " );
				
				delete_FileName = usrInput.nextLine();
				
				
	
				System.out.println("Entered filename is " + delete_FileName ); 
				
			
				File delete_FileInput = new File("/Users/rajalakshmip/Documents/Phase1/"+delete_FileName+".txt");
				
	
				if((delete_FileInput.exists()) && (delete_FileInput.getCanonicalFile().getName().equals(delete_FileInput.getName()))) 
				{
				
					boolean b = delete_FileInput.delete(); // deleting the Given file
				
					if(b==true) {
						System.out.println("****************************************");
						System.out.println(" File " + delete_FileName +  " is Deleted.");
						System.out.println("****************************************");
						dirAllFile.remove(delete_FileName+".txt");
	
					}
				
				}
				else {
					System.out.println("****************************************");
					throw new MyException("Text File " + delete_FileName +" is Not Found.");
					
				}
		
			}
			
		catch(IOException e) {
				System.out.println("Error Occured While Deleting File.");
			}
		catch(MyException e){
			System.out.println(e);
			
		}
	}
		
/**
* This searchFile Method 
* gets the text file Input from the user .
* iterate through the directory and check for the user specified search file .
* If the file is present,Display "File Present" Message .Otherwise Display "File Not Present" Message.
*/
						
		public void searchFile() {
			
			boolean fileFound = false;
		
		try {
				File  dir = new File("/Users/rajalakshmip/Documents/Phase1");
				
				Scanner input = new Scanner(System.in);
				System.out.println("Please Enter the Text file to be Searched without Extension:: ");
				String searchFile= input.nextLine();
			
				String checkFile =searchFile.concat(".txt"); //.txt extension has been added

				if(dir.exists()) {
					File [] fileList = dir.listFiles();
					System.out.println("FileList : ");
			
					for(File x: fileList) {
						if(x.getName().equals(checkFile)) { //checks the case sensitivity to search the appropriate file
							fileFound =  true;
							break;
							}
					 }
				 }
				else {
					System.out.println("Empty directory and no files present");
				}
				
				if(fileFound==true) {
					System.out.println("****************************************");
					System.out.println(" Searching Text File " +searchFile+" is Present");
					System.out.println("****************************************");
				}
				else {
					System.out.println("****************************************");
					System.out.println("Searching Text File " +searchFile+" is NOT Present");
					System.out.println("****************************************");
					
				}
		}
		
		catch(Exception e) {
			e.printStackTrace();
			}
		}
		
/**
* This CloseAppln Method 
* Display the Application Closed message and Exits the Application.
*/
		public void closeAppln() {
			   System.out.println();
			   System.out.println("************************************************");
			   System.out.println("LockedMe.com Application Closed");
			   System.out.println("************************************************");
			
			   
			   System.exit(1);
		}
		
/**
* This WelcomeScreen Method 
* Display the Application Name and Author name of the Application.
*/		
		
		public void welcomeScreen() {
		   	 System.out.println("****************************************************************");
		   	 System.out.println("********************* WELCOME TO  LockedMe.COM  ********************");
		   	 System.out.println("****************************************************************");
		   	 System.out.println();
		   	 
		   	 System.out.println("****************************************************************");
		   	 System.out.println("*********************  Application Developed By Rajalakshmi Premkumar  ********************");
		   	 System.out.println("****************************************************************");
		}
/**
* This mainMenu Method 
* Displays the Menu Options-RetrieveFiles,BusinessOperations,Close Application
*/				
		public void mainMenu(){
	   		 
			 System.out.println("***************************************");
			 System.out.println("MAIN MENU :: Enter value 1 to 3 - Application Operations");
			 System.out.println("***************************************");
			 System.out.println();
		   	 System.out.println("1: Retrieve Files");
		   	 System.out.println("2: Add or Delete or Search a file");
		   	 System.out.println("3: Close the Application");
		   	 System.out.println();
  	 
  	 }
/**
* This subMenu Method 
* Displays the Business Menu Operations to be performed on the file-Add/Delete/Search and Navigate  to go to Main menu.
*/				
		public void subMenu() {
			
			 System.out.println("***************************************");
			 System.out.println("SUB MENU :: Enter 1 to 4 - File Operations");
			 System.out.println("***************************************");
			 System.out.println();
			 System.out.println("1: To Add a file");
		   	 System.out.println("2: To Delete a File");
		   	 System.out.println("3: To Search a File");
		   	 System.out.println("4: To Go to MainMenu");
		   	 System.out.println();
		}

		
/**
* usrInput Method 
* Gets the userIput for the main menu.Entered Input should be 1 0r 2 0r 3.
* Continuosly request for User Input Until correct  input is enetered.
*/	
		public int usrInput() {
			
			int userChoice = 0;
			
			while (true) {//Always receive user input

				System.out.println("Enter your Choice");
				try {
					Scanner input = new Scanner(System.in);
					userChoice = input.nextInt();

					
				  } catch (InputMismatchException e) {
					System.out.println("Enter Only Integer Value from 1 to 3");
					continue;//Jump out of this while loop and execute the next while loop
				}
				
				//When the received value is 0, the loop is exited, otherwise the received value is printed
				if(userChoice==1 || userChoice ==2 || userChoice==3) {
					break;
				} else {
					System.out.println("Entered Input is : " + userChoice + " Please enter input only from 1 to 3");
				}
			}
			return userChoice;
		}
	
		
/**
* usrInput Method 
* Gets the userIput for the main menu.Entered Input should be 1 0r 2 0r 3.
* Continuosly request for User Input Until correct  input is enetered.
*/
		
		public int usrInput1() {
			
			int userChoice = 0;
			
			while (true) {//Always receive user input

				System.out.println("Enter your Choice");
				try {
					Scanner input = new Scanner(System.in);
					userChoice = input.nextInt();

					
				  } catch (InputMismatchException e) {
					System.out.println("Enter Only Integer Value from 1 to 4");
					continue;//Jump out of this while loop and execute the next while loop
				}
				
				//When the received value is 0, the loop is exited, otherwise the received value is printed
				if(userChoice==1 || userChoice ==2 || userChoice==3 || userChoice==4) {
					break;
				} else {
					System.out.println("Entered Input is : " + userChoice + " Please enter input only from 1 to 4");
				}
			}
			return userChoice;
		}
		
/**
* Main Method
* Gets the User Input for Various Operations to be performed on the Application.
* do while loop is used to loop the menu.
* The Application Continues until the person choosesto Close Application.
*InputMismatchException,IOException,NoSuchElementException and Generic Exception has been handled.
*Finally block also used to close the application.
*/	
	public static void main(String[] args) {
		

			LockedMe obj = new LockedMe();
	
		   	int userChoice = 0;
		   	boolean navigate = false;
		   	boolean closeAppln = false;
		   	 
		   
		   	 obj.welcomeScreen();
	   	 try {
			  do {
					obj.mainMenu();
					userChoice = obj.usrInput();
	
		        switch(userChoice) {    
		        
			        case 1: System.out.println("Retrieving Files"); 
			        		System.out.println("******************"); 
			                obj.retrieveFiles();  
			                break;
			                
			        case 2: System.out.println("To Add or Delete or Search the file");
			        		System.out.println("************************************"); 
			             	obj.businessOprFiles(navigate);
			             	break;          	
			       
			       case 3: System.out.println("Closing the Application"); 
			       			System.out.println("***********************"); 
			        		obj.closeAppln();
			        		break;
			        
			       	default: System.out.println("Enter Only From Option 1 to 3");
			       			break;
	
	
		        	}
		        
			  }while(!navigate || !closeAppln);
	}
	   	 catch(Exception e) {
			System.out.println("Exception Occured Please refer the trace log for reference");
			e.printStackTrace();
			}
	 
		finally {

			   obj.closeAppln();
		 }
	}
}
