Locked Me Application:


Main Method:

•	Display Welcome Screen with the Author Name and Application Details.

•	In a Do While Loop Perform the Following:

o	Display Main Menu with the follow Options
	Retrieve Files 
	Business Operations On File(Add/Delete/Search)
	Close The Application
o	Get User Input in Integer to select Main Menu Options. 
	If Invalid Input is entered ,Request the user to enter Input until Valid Input is entered.(Valid Values for Main Menu( 1,2 or 3).
o	Switch Case to Perform the Main Menu Selection.
•	Case1:  Invoke Retrieve Files
Break;
•	Case2:  Invoke  Business Operations On File (navigate Parameter)
                                                  Break;

•	Case3:  Invoke  Close Application.
    Break;

•	Default: Enter Only Option from 1to 3
                                                     Break;
    End Do While Loop if (not navigate or not Close Appln).

•	Catch Generic Exception and Throw Error.

•	Finally Block Used to Close the Application .



Retrieve Files Method:

•	Assign a File Path and check if the file path is a directory.
	Check if the file Diectory Exists
	List all the files in a directory.
	Add the File list to a TreeSet to store the file Set in Ascending Order and Not to allow Duplicates.
	Display the TreeSet to list all the files in the Directory

•	If the File Path is not a directory then display “Empty Directory and No files present inside the directory.

•	Catch Generic Exception and display error Message.


Business Operation On Files Method:

o	Takes Navigate Boolean File as Method Argument.

o	Display Sub Menu with the below Options.
	Add a File
	Delete a File
	Search a File
	Navigate to Main Menu

o	Get User Input in Integer to select the Sub Menu Options. If Invalid Input is entered , Request the user to enter Input until Valid Input is entered.(Valid Values for Main Menu( 1,2 ,3or 4).

o	Switch Case to Perform the Main Menu Selection.
	Case1:  Invoke  Add Files
Break;
	Case2:  Invoke  Delete Files     
Break;
	Case3:  Invoke  Search Files
Break;
	Case4:  Invoke MainMenu method
o	Set  navigate to True;
Break;
	Default: Enter Only Option from 1to 4

Add File Method:

•	Takes UserInput to get the text file to be added to the Directory.

•	Add the given file to directory path.

•	Check if the File Already Exists
o	Add the File to The Existing Directory TreeSet
o	Display “Text File Already Present” Message.

•	Otherwise
o	CreateNew File.
o	Display “New Text File created message”.
•	Catch IoException and Generic Excception.

Delete File Method:

•	Takes UserInput to get the text file to be Deleted from the Directory.

•	Check if the File Already Exists and the file present in the directory matches the User Specified file and checks for Case sensitivity as well

o	Delete the File and Display “File is Deleted “ message
o	Remove the file from the TreeSet as well

•	Otherwise
	Used  Custom Exception to show “Text File Not Found” message.

•	Catch IoException and Generic Excception


Search File Method:

•	Takes UserInput to get the text file to be Searched from the Directory.

•	If Directory Exists
o	Store the file list to an Array.
o	For Loop to check if the File exist in the search directory. Also check for the caseSensitivity to search the correct file.
o	Set FileFound Boolean variable to true.

•	Otherwise
o	Display “Empty Directory and No Files Present” message.

•	If FileFound variable true
o	Display “File is Present.
•	Otherwise
o	Display “File is Not Present”.

•	Catch Generic Exception.

Close Application Method:

•	Display Application Closed Message.
•	Exit the Application.















