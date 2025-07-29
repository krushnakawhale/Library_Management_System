package library_management_system;

import java.util.Scanner;

public class MainController 
{
   public static void main(String[] args) throws Exception 
   {
	   Scanner scanner=new Scanner(System.in);
	   
	   Admin admin=new Admin();
	   AdminCrud adminCrud=new AdminCrud();
	   Book book=new Book();
	   BookCrud bookCrud=new BookCrud();
	   User user=new User();
	   UserCrud userCrud=new UserCrud();
	   
	   System.out.println("   **Welcome**   \n1.Admin \n2.User \n3.Exit");
	   int who=scanner.nextInt();
	   switch (who) 
	   {
	       case 1:
		   {
			   boolean repeat =true;
			   int no=0;
			   while(repeat)
			   {
				   System.out.println("Enter the choice: \n1.SignUp \n2.LogIn \n3.Exit ");
				   int choice=scanner.nextInt();
				   switch(choice) {
				   case 1:
				   {
					   System.out.println("Enter the id:");
					   admin.setId(scanner.nextInt());
					   System.out.println("Enter the name");
					   admin.setName(scanner.next());
					   System.out.println("Enter the phone:");
					   admin.setPhone(scanner.nextLong());;
					   System.out.println("Enter the email:");
					   admin.setEmail(scanner.next());;
					   System.out.println("Enter the password");
					   admin.setPassword(scanner.next());
					   int result=adminCrud.saveAdmin(admin);
					   if(result>0) {
						   System.out.println("Admin Saved Successfully!!!");
					   }else if (result<0) {
						    System.err.println("Admin is already present!!");
					   }else {
					          System.err.println("Failed.... Please try again !!!");
					   }
				   }
				   break;
				   case 2:
				   {
					   System.out.println("Enter the email or phone:");
					   String loginAdmin=scanner.next();
					   System.out.println("Enter the Password:");
					   String password=scanner.next();
					   int login=adminCrud.loginAdmin(loginAdmin, password);
					   if(login==1)
					   {
						   System.out.println("Login Successful !!! ");
						   boolean logged=true;
						   while(logged)
						   {
							   System.out.println("What you want: \n1.AddBook \n2.DeleteBook \n3.UpdateBook \n4.ViewBook \n5.ViewAllBook \n6.UpdateAdmin \n7.DeleteAdmin \n8.DeleteUser \n9.Exit \n10.Logout");
							   int operation=scanner.nextInt();
							   switch (operation) {
							   case 1:
							   {
								   System.out.println("Enter the book Id:");
								   book.setId(scanner.nextInt());
								   System.out.println("Enter the book Name:");
								   book.setName(scanner.next());
								   System.out.println("Enter the book Author:");
								   book.setAuthor(scanner.next());
								   System.out.println("Enter the book Price:");
								   book.setPrice(scanner.nextDouble());
								   System.out.println("Enter the book Genre:");
								   book.setGenre(scanner.next());
								   System.out.println("Enter the book Status:");
								   book.setStatus(scanner.next());
							       int add=bookCrud.saveBook(book);
							       if(add>0) {
							    	 System.out.println("Book Added Successfully!!!");
							       }else{
							    	   System.err.println("failed......try again");
							       }
							   }break;
							   case 2:
							   {
								   System.out.println("Enter the book Id:");
								   int id=scanner.nextInt();
								   int delete=bookCrud.deleteBook(id);
								   if (delete==1) {
									System.out.println("Book has been Removed Successfully !!");
								    }else if (delete==-1){
									  System.err.println("Failed......Please try again!");	
									}else {
										System.err.println("Book Not Found!!!");
									}
								   
							   }break;
							   case 3:
							   {
								   System.out.println("Enter the Id:");
								   int id=scanner.nextInt();
								   System.out.println("1.Available \n2.Taken \n3.Lost");
								   int update=scanner.nextInt();
								   switch(update){
								   case 1:{
									   int available=bookCrud.updateAvailable(id);
									   if(available==1){
										   System.out.println("Status updated Successfully!!!");
									   }else {System.err.println("Book Not Found !!");}
								   }break;
                                   case 2:{
                                	   int taken=bookCrud.updateTaken(id);
									   if(taken==1){
										   System.out.println("Status updated Successfully!!!");
									   }else {System.err.println("Book Not Found !!");}
								   }break;
                                   case 3:{
									   int lost=bookCrud.updateLost(id);
									   if(lost==1){
										   System.out.println("Status updated Successfully!!!");
									   }else {System.err.println("Book Not Found !!");}
								   }break;
                                   default:
    								   System.err.println("Enter valid option");
    								 break;
								   }
							   }break;
							   case 4:
							   {
								   boolean viewed=true;
								   while(viewed)
								   {
								   System.out.println("1.ById \n2.ByName \n3.ByAuthor \n4.ByPrice \n5.ByGenre \n6.ByStatus \n7.Exit \n8.LogOut");
								   int view=scanner.nextInt();
								   switch (view) {
								    case 1:{
								    	System.out.println("Enter the Id");
								    	int id=scanner.nextInt();
								        bookCrud.getBookById(id);
								    }break;
								    case 2:{
								    	System.out.println("Enter the Name");
								    	String name=scanner.next();
								        bookCrud.getBookByName(name);
								    }break;
								    case 3:{
								    	System.out.println("Enter the Author");
								    	String author=scanner.next();
								        bookCrud.getBookByAuthor(author);;
								    }break;
								    case 4:{
								    	System.out.println("Enter the Price");
								    	Double price=scanner.nextDouble();
								        bookCrud.getBookByPrice(price);
								    }break;
								    case 5:{
								    	System.out.println("Enter the Genre");
								    	String genre=scanner.next();
								        bookCrud.getBookByGenre(genre);;
								    }break;
								    case 6:{
								    	System.out.println("Enter the Status");
								    	String status=scanner.next();
								        bookCrud.getBookByStatus(status);;
								    }break;
								    case 7:{
								    	viewed=false;
								    }break;
								    case 8:{
								    	  viewed=false;
								    	  logged=false;
							    	      System.out.println("Thank You!!");
								    }break;
								    default:
								    	System.err.println("Enter valid Option");
									  break;
								   }
								}
							   }break;
							   case 5:
							   {
								   bookCrud.getAllBook();
							   }break;
							   case 6:
							   {
								   boolean updateTo=true;
								   while(updateTo)
								   {
								    System.out.println("What you want to Update:\n1.Name \n2.Phone \n3.Email \n4.Password \n5.AllInformation \n6.Exit \n7.LogOut "); 
								   int updateAdmin=scanner.nextInt();
								  switch (updateAdmin) {
								  case 1:
								  {
									  System.out.println("Enter the name:");
									  String name=scanner.next();
									  int updateName=adminCrud.updateName(name);
									  if(updateName>0) {
										  System.out.println("Admin Name has been updated Successfully!!!");
									  }else {
										  System.err.println("Failed.....Try Again!!");
									  }
								   }break;
								  case 2:
								  {
									  System.out.println("Enter the phone:");
									  Long phone=scanner.nextLong();
									  int updatePhone=adminCrud.updatePhone(phone);
									  if(updatePhone>0) {
										  System.out.println("Admin Phone has been updated Successfully!!!");
									  }else {
										  System.err.println("Failed.....Try Again!!");
									  }
								   }break;
								  case 3:
								  {
									  System.out.println("Enter the Email:");
									  String email=scanner.next()+"@gmail";
									  int updateEmail=adminCrud.updateEmail(email);
									  if(updateEmail>0) {
										  System.out.println("Admin Email has been updated Successfully!!!");
									  }else {
										  System.err.println("Failed.....Try Again!!");
									  }
								   }break;
								  case 4:
								  {
									  System.out.println("Enter the Old Password");
									  String oldPassword=scanner.next();
									  System.out.println("Enter the New Password");
									  String newPassword=scanner.next();
									  int updatePassword=adminCrud.updatePassword(oldPassword, newPassword);
									  if(updatePassword>0) {
										  System.out.println("Admin Password updated Successfully!!!");
									  }else {
										  System.err.println("Invalid Credential.....Try Again!!");
									  }
								   }break;
								  case 5:
								  {
									   System.out.println("Enter the name");
									   admin.setName(scanner.next());
									   System.out.println("Enter the phone:");
									   admin.setPhone(scanner.nextLong());;
									   System.out.println("Enter the email");
									   admin.setEmail(scanner.next());;
									   System.out.println("Enter the password");
									   admin.setPassword(scanner.next());
									   int result=adminCrud.updateAdmin(admin);
									   if(result>0) {
										   System.out.println("Admin Updated Successfully!!!");
									   }else {
									          System.err.println("Failed.... Please try again !!!");
									   }
								   }break;
								  case 6:
								    {
								    	updateTo=false;
								    }break;
								    case 7:
								    {
								    	updateTo=false;
								    	logged=false;
								    	 System.out.println("Thank You!!");
								    }break;
								  default:
									  System.err.println("Ente valid option");
									break;
								  }
								}
							   }break;
							   case 7:
							   {
								   int deleteAdmin=adminCrud.deleteAdmin(loginAdmin);
								   if (deleteAdmin==1) {
									System.out.println("User of "+loginAdmin+" has been Removed Successfully !!");
									System.err.println("Thank You...\n Please SignUp!!!");
									 logged=false;
								    }else{
									  System.err.println("Failed......Please  LogOut and then try again!");	
									}
							   }
								break;
							   case 8:
							   {
								   System.out.println("Remove User By :\n1.Id \n2.Phone \n3.Email");
								   int deleteUser=scanner.nextInt();
								   switch (deleteUser) {
								    case 1:{
								    	System.out.println("Enter the Id");
								    	int id=scanner.nextInt();
								    	int deleteById=userCrud.deleteUserById(id);
										   if (deleteById==1) {
											System.out.println("User of Id="+id+" has been Removed Successfully !!");
										    }else if (deleteById==-1){
											  System.err.println("Failed......Please try again!");	
											}else {
												System.err.println("User Not Found!!!");
											}
								    }break;
								    case 2:{
								    	System.out.println("Enter the Phone");
								    	long phone=scanner.nextLong();
								    	int deleteByPhone=userCrud.deleteUserByPhone(phone);
										   if (deleteByPhone==1) {
											System.out.println("User of Phone="+phone+" has been Removed Successfully !!");
										    }else if (deleteByPhone==-1){
											  System.err.println("Failed......Please try again!");	
											}else {
												System.err.println("User Not Found!!!");
											}
								    }break;
								    case 3:{
								    	System.out.println("Enter the Email");
								    	String email=scanner.next();
								    	int deleteByEmail=userCrud.deleteUserByEmail(email);
										   if (deleteByEmail==1) {
											System.out.println("User of Email="+email+" has been Removed Successfully !!");
										    }else if (deleteByEmail==-1){
											  System.err.println("Failed......Please try again!");	
											}else {
												System.err.println("User Not Found!!!");
											}
								    }break;
								    default:
								    	System.err.println("Enter valid option!!");
									break;
								}
							   }
								break;
							   case 9:
							   {
								   logged=false;
							   }
								break;
							   case 10:
							   {
								   System.out.println("*** Thank You ***");
								  logged=false;
								  repeat=false;
							   }
								break;
							   default:
								   System.err.println("Enter valid option");
								 break;
							  }
						   }
					   }
					   else if (login==-1) 
					   {
						  System.err.println("Invalid Password!!! \n1.Forgot \n2.Retry");
						  int forgot=scanner.nextInt();
						  switch (forgot) {
						  case 1:{
							 System.out.println("Enter Email id: ");
							 String email=scanner.next();
							 System.out.println("Enter Phone : ");
							 long phone=scanner.nextLong();
							 System.out.println("Enter New Password: ");
							 String newPassword=scanner.next();
							 int result=adminCrud.forgotPass(email, phone, newPassword);
							 if(result==1){
							    System.out.println("Password UPdated Successfully!!!");
						      }else if (result==0) {
								System.err.println("Failed.....try again !!!");
							}else {
								System.err.println("Invalid credientials !!!");
							} 
						   }break;
						   default:
							break;
						 }  
					   }
					   else 
					   {
						   System.err.println("You are not a Admin ");
					   }
				   }
				   break;
				   case 3:
				   {
					   System.out.println("*** Thank You ***");
					   repeat=false;
				   }
				   break;
					default:
						no++;
						if(no<3)
						{
							System.out.println("Please provide valid option");
						}
						else {
							System.out.println("*** Thank You ***");
							   repeat=false;
						}
						break;
					}
			   }
		    }
			break;
		   case 2:
		   {
		      
			   
			   boolean repeat =true;
			   int no=0;
			   while(repeat)
			   {
				   System.out.println("Enter the choice: \n1.SignUp \n2.LogIn \n3.Exit ");
				   int choice=scanner.nextInt();
				   switch(choice) {
				   case 1:
				   {
					   System.out.println("Enter the id:");
					   user.setId(scanner.nextInt());
					   System.out.println("Enter the name");
					   user.setName(scanner.next());
					   System.out.println("Enter the phone:");
					   user.setPhone(scanner.nextLong());;
					   System.out.println("Enter the email :");
					   user.setEmail(scanner.next());;
					   System.out.println("Enter the password");
					   user.setPassword(scanner.next());
					   int result=userCrud.saveUser(user);
					   if(result>0) {
						   System.out.println("User Saved Successfully!!!");
					   }else {
					          System.err.println("Failed.... Please try again !!!");
					   }
				   }
				   break;
				   case 2:
				   {
					   System.out.println("Enter the email or phone:");
					   String loginUser=scanner.next();
					   System.out.println("Enter the Password:");
					   String password=scanner.next();
					   int login=userCrud.LoginUser(loginUser, password);
					   if(login==1)
					   {
						   System.out.println("Login Successful !!! ");
						   boolean logged=true;
						   while(logged)
						   {
							   System.out.println("What you want: \n1.TakeBook \n2.ReturnBook  \n3.ViewBook \n4.ViewAllBook \n5.UpdateUser \n6.DeleteUser \n7.Exit \n8.Logout");
							   int operation=scanner.nextInt();
							   switch (operation) {
							   case 1:
							   {
								   System.out.println("Enter the book Id:");
								   int id=scanner.nextInt();
								   int take=bookCrud.takeBook(id);
							       if(take>0) {
							    	 System.out.println("Book Taken Successfully.....Please return on time!!!");
							       }else if (take<0) {
							    	   System.err.println("Book Aleady Taken by someone.....Please take other!!!");
							     	} else{
							    	   System.err.println("Book Not Available in Library!!");
							         }
							   }break;
							   case 2:
							   {
								   System.out.println("Enter the book Id:");
								   int id=scanner.nextInt();
								   int returnBook=bookCrud.returnBook(id);
							       if(returnBook>0) {
							    	 System.out.println("Book Recieved Successfully.!!!");
							       }else if (returnBook<0) {
							    	   System.err.println("Cannot take this Book because...This Book is not from our library..!!!");
							     	} else{
							    	   System.err.println("Please enter correct id.!!");
							         }
								  
							   }break;
							   case 3:
							   {
								   boolean viewed=true;
								   while(viewed)
								   {
								   System.out.println("1.ById \n2.ByName \n3.ByAuthor \n4.ByPrice \n5.ByGenre \n6.ByStatus \n7.Exit \n8.LogOut");
								   int view=scanner.nextInt();
								   switch (view) {
								    case 1:{
								    	System.out.println("Enter the Id");
								    	int id=scanner.nextInt();
								        bookCrud.getBookById(id);
								    }break;
								    case 2:{
								    	System.out.println("Enter the Name");
								    	String name=scanner.next();
								        bookCrud.getBookByName(name);
								    }break;
								    case 3:{
								    	System.out.println("Enter the Author");
								    	String author=scanner.next();
								        bookCrud.getBookByAuthor(author);;
								    }break;
								    case 4:{
								    	System.out.println("Enter the Price");
								    	Double price=scanner.nextDouble();
								        bookCrud.getBookByPrice(price);
								    }break;
								    case 5:{
								    	System.out.println("Enter the Genre");
								    	String genre=scanner.next();
								        bookCrud.getBookByGenre(genre);;
								    }break;
								    case 6:{
								    	System.out.println("Enter the Status");
								    	String status=scanner.next();
								        bookCrud.getBookByStatus(status);;
								    }break;
								    case 7:{
								    	      viewed=false;
								    }break;
								    case 8:{
								    	     viewed=false;
								    	     logged=false;
								    	     System.out.println("Thank You!!");
								    }break;
								    default:
								    	System.err.println("Enter valid Option");
									  break;
								}
								   }
							   }break;
							   case 4:
							   {
								   bookCrud.getAllBook();
							   }break;
							   case 5:
							   {
								   boolean updateTo=true;
								   while(updateTo)
								   {
								     System.out.println("What you want to Update:\n1.Name \n2.Phone \n3.Email \n4.Password \n5.AllInformation \n6.Exit \n7.LogOut "); 
								    int updateUser=scanner.nextInt();
								    switch (updateUser) {
								    case 1:
								    {
									  System.out.println("Enter the name:");
									  String name=scanner.next();
									  int updateName=userCrud.updateName(name);
									  if(updateName>0) {
										  System.out.println("User Name has been updated Successfully!!!");
									  }else {
										  System.err.println("Failed.....Try Again!!");
									  }
								    }break;
								    case 2:
								    {
									  System.out.println("Enter the phone:");
									  Long phone=scanner.nextLong();
									  int updatePhone=userCrud.updatePhone(phone);
									  if(updatePhone>0) {
										  System.out.println("User Phone has been updated Successfully!!!");
									  }else {
										  System.err.println("Failed.....Try Again!!");
									  }
								     }break;
								    case 3:
								     {
									  System.out.println("Enter the Email:");
									  String email=scanner.next();
									  int updateEmail=userCrud.updateEmail(email);
									  if(updateEmail>0) {
										  System.out.println("User Email has been updated Successfully!!!");
									  }else {
										  System.err.println("Failed.....Try Again!!");
									  }
								     }break;
								    case 4:
								     {
									  System.out.println("Enter the Old Password");
									  String oldPassword=scanner.next();
									  System.out.println("Enter the New Password");
									  String newPassword=scanner.next();
									  int updatePassword=userCrud.updatePassword(oldPassword, newPassword);
									  if(updatePassword>0) {
										  System.out.println("User Password updated Successfully!!!");
									  }else {
										  System.err.println("Invalid Credential.....Try Again!!");
									  }
								     }break;
								    case 5:
								     {
									   System.out.println("Enter the name");
									   user.setName(scanner.next());
									   System.out.println("Enter the phone:");
									   user.setPhone(scanner.nextLong());;
									   System.out.println("Enter the email");
									   user.setEmail(scanner.next());;
									   System.out.println("Enter the password");
									   user.setPassword(scanner.next());
									   int result=userCrud.updateUser(user);
									   if(result>0) {
										   System.out.println("User Updated Successfully!!!");
									   }else {
									          System.err.println("Failed.... Please try again !!!");
									   }
								    }break;
								    case 6:
								    {
								    	updateTo=false;
								    }break;
								    case 7:
								    {
								    	updateTo=false;
								    	logged=false;
								    	 System.out.println("Thank You!!");
								    }break;
								     default:{
									  System.err.println("Ente valid option");
								    }break;
								   }
							     }
							   }break;
							   case 6:
							   {
								   int deleteUser=userCrud.deleteUser(loginUser);
								   if (deleteUser==1) {
									System.out.println("User of "+loginUser+" has been Removed Successfully !!");
									System.err.println("Thank You...\n Please SignUp!!!");
									 logged=false;
								    }else{
									  System.err.println("Failed......Please  LogOut and then try again!");	
									}
							   }
								break;
							   case 7:
							   {
								   logged=false;
							   }
								break;
							   case 8:
							   {
								   System.out.println("*** Thank You ***");
								  logged=false;
								  repeat=false;
							   }
								break;
							   default:
								   System.err.println("Enter valid option");
								 break;
							  }
						   }
					   }
					   else if (login==-1) 
					   {
						   System.err.println("Invalid Password!!! \n1.Forgot \n2.Retry");
							  int forgot=scanner.nextInt();
							  switch (forgot) {
							  case 1:{
								 System.out.println("Enter Email id: ");
								 String email=scanner.next();
								 System.out.println("Enter Phone : ");
								 long phone=scanner.nextLong();
								 System.out.println("Enter New Password: ");
								 String newPassword=scanner.next();
								 int result=userCrud.forgotPass(email, phone, newPassword);
								 if(result==1){
								    System.out.println("Password UPdated Successfully!!!");
							      }else if (result==0) {
									System.err.println("Failed.....try again !!!");
								}else {
									System.err.println("Invalid credientials !!!");
								} 
							   }break;
							   default:
								break;
							 }  
					   }
					   else 
					   {
						   System.err.println("Please SignUp first!!");
					   }
				   }
				   break;
				   case 3:
				   {
					   System.out.println("*** Thank You ***");
					   repeat=false;
				   }
				   break;
					default:
						no++;
						if(no<3)
						{
							System.out.println("Please provide valid option");
						}
						else {
							System.out.println("*** Thank You ***");
							   repeat=false;
						}
						break;
					}
			   } 
		   }
			break;
		  default:
			  System.out.println("Thank You");
			 break;
		}
   }
}
