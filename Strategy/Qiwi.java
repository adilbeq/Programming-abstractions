import java.io.*;
import java.util.*;
import java.util.Arrays;
import java.util.List;

public class Qiwi implements OnlineWallet{
    Scanner input = new Scanner(System.in);
	public static void main(String[] args) {
	}
	String login;
	String pass;
	int amount;
	Qiwi(String login, String pass, int amount){
		this.login  = login;
		this.pass   = pass;
		this.amount = amount;
	}
	public boolean checkLogin() throws Exception{
		File f = new File("qiwiUsers.txt");
        Scanner sc = new Scanner(f);
        while(sc.hasNextLine()){
            String line = sc.nextLine();
            String[] details = line.split(":");
            String log = details[0];
            String pas = details[1];
            int balik = Integer.parseInt(details[2]);
            if(log.equals(login)){
            	if(pas.equals(pass)){
            		return true;
            	}
            }
        }
        return false;
	}
	public boolean checkBalance() throws Exception{
		File f = new File("qiwiUsers.txt");
        Scanner sc = new Scanner(f);
        while(sc.hasNext()){
            String line = sc.nextLine();
            String[] details = line.split(":");
            if(details[0].equals(login))
            {
            	if(details[1].equals(pass))
            	{
            		int balik = Integer.parseInt(details[2]);
		            if(balik >= amount){
		            	return true;
		            }
            	}
            }
            
        }
        return false;
	}	
    public void againCheck() throws Exception{
    System.out.print("Enter the user's number: ");
    String login = input.next();
    System.out.print("Enter the password: ");
    String password = input.next();

    Qiwi e = new Qiwi(login, password, amount);
    if(e.checkLogin() == true)
    {
        System.out.println("Data verification has been successful.");
        System.out.println("Paying "+amount+" using Qiwi.");
        System.out.println("Payment has been successful."); 
    }
    else
    {
        System.out.println("Wrong email or password!");
        againCheck();
    }
}

}