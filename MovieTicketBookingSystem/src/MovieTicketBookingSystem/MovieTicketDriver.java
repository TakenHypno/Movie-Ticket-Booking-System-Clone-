package MovieTicketBookingSystem;
import java.util.Scanner;

import swingGUI.GUIOperations;

public class MovieTicketDriver {
    static Scanner sc = new Scanner(System.in);

    static DatabaseOperation db = new DatabaseOperation();
    
    //methods to sign up and login for user class
    public static void user_signup(String username, String password, String name, String phone, String address){
        String sql = "INSERT INTO users(Username,Password,Name,Phone,Address) values(?,?,?,?,?)";
        Object[] values = {username,password,name,phone,address};
        int rowsAffected = db.executeUpdate(sql, values); 
        if(rowsAffected>0)
            System.out.println("User registered successfully");
        else
            System.out.println("Something went wrong.Sign up failed.");
    }

    static void user_login(){
        System.out.println("Enter your username: ");
        String username = sc.next();
        
        System.out.println("Enter your password: ");
        String password = sc.next();

        String sql = "SELECT Password from users where username = ?";
        String pass_real = db.validatePass(sql, username);

        if (password.equals(pass_real)){
            System.out.println("Login Succesfull!");
           User u = new User();
           sql = "SELECT UserID from users where username = ?";
           int userID = db.fetchUserID(sql, username);
           u.userMenu(userID);
        }else{
            System.out.println("Invalid password! Try again!");
        }
    }

    //methods to sign up and login for admin class
    public static void admin_signup(String username, String password){
        String sql = "INSERT INTO admin(Username,Password) values(?,?)";
        Object[] values = {username,password};
        int rowsAffected = db.executeUpdate(sql, values); 
        if(rowsAffected>0)
            System.out.println("Admin registered successfully");
        else
            System.out.println("Something went wrong.Sign up failed.");
    }

    public static boolean admin_login(String username, String password){
        String sql = "SELECT Password from admin where username = ?";
        String pass_real = db.validatePass(sql, username);

        if (password.equals(pass_real)){
            System.out.println("Login Succesfull!");
            Admin a = new Admin();
            return true;
        }else{
            System.out.println("Invalid password! Try again!");
            return false;
        }
    }



    //the main page where user gets option to do so
    public static void main(String[] args) {
    	DatabaseOperation db = new DatabaseOperation();
    	db.initializeDatabase();
    	GUIOperations.initializeFrame();
    }
 
}
