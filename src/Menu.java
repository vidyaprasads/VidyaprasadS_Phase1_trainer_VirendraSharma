import java.util.*;
import java.io.*;
import java.util.Arrays;

public class Menu {
static File fileList;
static String path;
static Menu menuObj=new Menu();

static void folderCreation()  
{
   String dir = System.getProperty("user.dir");
   fileList=new File(dir+"/"+"fileList");

    if(!(fileList.exists()))
     {
     fileList.mkdir();
     }  
    path=fileList.getAbsolutePath();
    System.out.println(" path"+path);
}        

static void addNewFile(String addFile)
{
    File addObj=new File(path+"/"+addFile);
    String[] list = fileList.list();
    try {

    for(String fileName:list)
    {
    if(addFile.equalsIgnoreCase(fileName))
   { 
    System.out.println(" file "+addFile+" is already present in directory,enter valid name ");
    return;
    } 
    } 
    addObj.createNewFile();
    System.out.println(" File "+addFile+" is created ");
    } 
    catch (IOException e) {
    }
}

static void deleteFile(String deteteFile)
{
    File deleteObj=new File(path+"/"+deteteFile);
    String[] list=fileList.list();
    for (String fileName: list) {
        if (deteteFile.equals(fileName) && deleteObj.delete()) {
        System.out.println( "File "+ deteteFile+" is deleted from the directory");
        return;
        }
        }
        System.out.println("FILE NOT FOUND, so it could not be deleted");
}

static void searchFile(String searchFile)
{

        String[] file_List=fileList.list();
        for (String file: file_List)
        {
        if (searchFile.equals(file))
        {
        System.out.println("file "+searchFile+" is found in the directory ");
        return;
         }
        }
        System.out.println("File NOT found");
 
}

static void ascendingOrderSorting()
{
    File f = new File(path);   
    if(f.list().length==0)
    {
    System.out.println("The Directory is empty");
    }
    else
    {
    String[] file_List=fileList.list();   
    Arrays.sort(file_List);
    System.out.println("Files sorted in ascending order as below:");
    for(String list:file_List)
    {
    System.out.println(list);
    }
    }
}

static void methodForOption2(){
      
               System.out.println("1-->Add a file to existing directory" );
               System.out.println("2-->Delete specified file from the existing directory" );
               System.out.println("3-->Search file from the main director" );
               System.out.println("4-->Main menu" );
               
               Scanner mymenuObj = new Scanner(System.in);  
               String userInput1 = mymenuObj.nextLine();

               if(userInput1.equals("1"))
               {
               System.out.println("enter the file name to add");
               Scanner addObj = new Scanner(System.in);  
               String userInput3 = addObj.nextLine();
               addNewFile(userInput3);
               methodForOption2();
               }

               else if(userInput1.equals("2"))
               {
               System.out.println("enter the file name to delete");
               Scanner deleteObj = new Scanner(System.in);  
               String userInput3 = deleteObj.nextLine();          
               deleteFile(userInput3);
               methodForOption2();
               }
               else if(userInput1.equals("3"))
               {
               System.out.println("enter the file name to search");
               Scanner searchObj = new Scanner(System.in);  
               String userInput4 = searchObj.nextLine();
               searchFile(userInput4);
               methodForOption2();
               }
               else if(userInput1.equals("4"))
               {                 
               menuObj.mainMenuFunction();                                      
               }
               else
               {
               System.out.println("enter the vaild input");
               methodForOption2();
               }                   
    }

public static void welcomeMethod()
 {            
System.out.println("********************************************************");
System.out.println("WELCOME TO Lockers Pvt.Ltd developed by Vidyaprasad S");
System.out.println("********************************************************");         
 }

public static void mainMenuFunction()
 {            
    System.out.println("please enter the input 1 or 2 or 3");
    System.out.println("1-->to display current file names in ascending order");
    System.out.println("2-->to Add  Delete and Search the file ");
    System.out.println("3-->Exit ");
    Scanner myObj = new Scanner(System.in);  // Create a Scanner object
 
    String userInput;
    userInput = myObj.nextLine();
    Menu obj=new Menu();
    switch(userInput) {
        
    case "1":{
             ascendingOrderSorting();
             obj.mainMenuFunction();
            }
            break;  
    case "2":{
             methodForOption2();
             }
             break;    
   case "3":{
               System.out.println("Are you sure you want to exit?" );
               System.out.println("y-->yes or n-->no" );
               Scanner myObj2 = new Scanner(System.in);  
               String userInput2 = myObj2.nextLine();              
               if(userInput2.equals("n") )
                 {
                 obj.mainMenuFunction();
                 }   
               else if(userInput2.equals("y"))
                {
                System.out.println("THANK YOU");
                }
                else
                {
                System.out.println("Enter the proper Input as below");
                    obj.mainMenuFunction();      
                }
                
            }              
                 break;
      
   default:
           System.out.println("please enter the proper mentioned proper input" );
           obj.mainMenuFunction();    
 }
 }
public static void main(String[] args) 
{    
    welcomeMethod();
    folderCreation(); 
    mainMenuFunction();
    
 }
}
