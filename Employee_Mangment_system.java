package Java_JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import paper16march.thread;

public class Employee_Mangment_system {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		String s = "Employee Mangement System";
		System.out.println("Enter User Name");
		String username=sc.next();
		sc.nextLine();
		System.out.println("Enter Password");
		String pass=sc.next();
		if(username.equals("root") && pass.equals("Avi@7700"))
		{
			System.out.println("login");
		
			
		}
		else
		{
			System.out.println("You Enter wrong data");
			System.exit(1);
		}
		String s1 = "***** MENU ******";
		String s2 = "1.Inseration";
		String s3 = "2.Read";
		String s4 = "3.Upadation";
		String s5 = "4.Deletion";
		String s6 = "5.Exist";
		String s7 = "***** MENU END *****";
		String s8 = "Please Select Menu";
		int choice = 0;
		do {
		for (int i = 0; i < s.length(); i++) {
			System.out.print(s.charAt(i));
			Thread.sleep(10);
		}
		System.out.println();
		System.out.println();

		for (int i = 0; i < s1.length(); i++) {
			System.out.print(s1.charAt(i));
			Thread.sleep(10);
		}
		System.out.println();

		System.out.println();

		for (int i = 0; i < s2.length(); i++) {
			System.out.print(s2.charAt(i));
			Thread.sleep(10);
		}
		System.out.println();

		for (int i = 0; i < s3.length(); i++) {
			System.out.print(s3.charAt(i));
			Thread.sleep(10);
		}
		System.out.println();

		for (int i = 0; i < s4.length(); i++) {
			System.out.print(s4.charAt(i));
			Thread.sleep(10);
		}
		System.out.println();

		for (int i = 0; i < s5.length(); i++) {
			System.out.print(s5.charAt(i));
			Thread.sleep(10);
		}
		System.out.println();

		for (int i = 0; i < s6.length(); i++) {
			System.out.print(s6.charAt(i));
			Thread.sleep(10);
		}
		System.out.println();
		System.out.println();

		for (int i = 0; i < s7.length(); i++) {
			System.out.print(s7.charAt(i));
			Thread.sleep(10);
		}
		System.out.println();
		System.out.println();

		for (int i = 0; i < s8.length(); i++) {
			System.out.print(s8.charAt(i));
			Thread.sleep(10);
		}

		choice = sc.nextInt();

		switch (choice) {
		case 1:
			Insertion();
			break;
		case 2:
			Read();
			break;
		case 3:
			Updation();
			System.out.println("After Upadte Information is");
			Read();
			break;
		case 4:
			Deletion();
			System.out.println("After Delete Information is");
			Read();
			break;
		case 5:
			System.exit(1);
			break;

		default:
			break;
		}
		}while(choice!=5);

	}
 
		

	public static void Insertion() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcmeth", "root", "Avi@7700");
		String sql = "insert into emp(name,email,gender,age,phone,city,salary) values(?,?,?,?,?,?,?)";
		sc.nextLine();
		System.out.println("Please Enter Your Name : ");
		String name = sc.nextLine();

		System.out.println("Please Enter Your Email-ID : ");
		String email = sc.nextLine();

		System.out.println("Please Enter Your Gender : ");
		String gender = sc.nextLine();

		System.out.println("Please Enter Your Age : ");
		int age = sc.nextInt();
		sc.nextLine();
		System.out.println("Please Enter Your Phone-No : ");
		String phone = sc.nextLine();

		System.out.println("Please Enter Your City : ");
		String city = sc.nextLine();

		System.out.println("Please Enter Your Salary : ");
		double salary = sc.nextDouble();

		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, name);
		ps.setString(2, email);
		ps.setString(3, gender);
		ps.setInt(4, age);
		ps.setString(5, phone);
		ps.setString(6, city);
		ps.setDouble(7, salary);

		int status = ps.executeUpdate();

		if (status == 1) {
			if (gender.equalsIgnoreCase("male"))

				System.out.println("Hi,Mr." + name + " Your Data is inserted successfully");
			else
				System.out.println("Hi,Mrs." + name + " Your Data is inserted successfully");
		} else
			System.out.println("Sorry,Mr." + name + " Your Data is not inserted successfully");
	}

	public static void Read() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcmeth", "root", "Avi@7700");
		String sql = "select * from emp";

		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
 			System.out.println();
			System.out.println("Employee Id is : " + rs.getInt("id"));
			System.out.println("Employee Name is : " + rs.getString("name"));
			System.out.println("Employee Email-Id is : " + rs.getString("email"));
			System.out.println("Employee Gender is : " + rs.getString("gender"));
			System.out.println("Employee Age is : " + rs.getInt("age"));
			System.out.println("Employee Phone_No is : " + rs.getString("phone"));
			System.out.println("Employee City is : " + rs.getString("city"));
			System.out.println("Employee Salary is : " + rs.getDouble("salary"));
			System.out.println();
			System.out.println("************************************************");
		}

	}

	public static void Updation() throws  Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcmeth","root","Avi@7700");
		String sql="update emp set name=?,email=?,gender=?,age=?,phone=?,city=?,salary=? where id=?";
		
		sc.nextLine();
		System.out.println("Please Enter Your Updated Name : ");
		String name = sc.nextLine();

		System.out.println("Please Enter Your Updated Email-ID : ");
		String email = sc.nextLine();

		System.out.println("Please Enter Your Updated Gender : ");
		String gender = sc.nextLine();

		System.out.println("Please Enter Your Updated Age : ");
		int age = sc.nextInt();
		sc.nextLine();
		System.out.println("Please Enter Your Updated Phone-No : ");
		String phone = sc.nextLine();

		System.out.println("Please Enter Your Updated Updated City : ");
		String city = sc.nextLine();

		System.out.println("Please Enter Your Updated Salary : ");
		double salary = sc.nextDouble();
		
		System.out.println("Please Enter Your Id Which you want to Upadate : ");
		int  id = sc.nextInt();

		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, name);
		ps.setString(2, email);
		ps.setString(3, gender);
		ps.setInt(4, age);
		ps.setString(5, phone);
		ps.setString(6, city);
		ps.setDouble(7, salary);
		ps.setDouble(8, id);

		int status = ps.executeUpdate();

		if (status == 1) {
			if (gender.equalsIgnoreCase("male"))

				System.out.println("Hi,Mr." + name + " Your Data is Updated successfully");
			else
				System.out.println("Hi,Mrs." + name + " Your Data is Updated successfully");
		} else
			System.out.println("Sorry,Mr." + name + " Your Data is not Updated successfully");
	}
		
	

	public static void Deletion() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcmeth","root","Avi@7700");
		String sql="delete from emp where id=?";
		System.out.println("Please Enter Your Id which you want to delete");
		int id=sc.nextInt();
		
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setInt(1, id);
		
		int status=ps.executeUpdate();
		if (status == 1) {
			 
				System.out.println("Hi, Your Data is Deleted successfully");
			 
		} else
			System.out.println("Sorry, Your Data is not Deleted successfully");
	}
	}

