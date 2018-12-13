import java.io.*;
import java.util.*;

public class First{
	public static int amount  = 0;
	public static Scanner input = new Scanner(System.in);
	public static void main(String[] args) throws Exception {
		int product = 0;
		int count   = 0;
		String ans;
		while(true){
			System.out.println("Please, select a product: ");
			System.out.println("1 - Mother board");
			System.out.println("2 - CPU");
			System.out.println("3 - HDD");
			System.out.println("4 - Memory");
			product = input.nextInt();
			System.out.print("Count: ");
			count = input.nextInt();
			amount = amount + (500*count);
			System.out.print("Do you wish to continue selecting products? Y/N: ");
			ans = input.next();	
			if (ans.equals("n")){
				break;
			}
		}
		System.out.println("Please, select a payment method: ");
		System.out.println("1 - PayPal");
		System.out.println("2 - Credit Card");
		System.out.println("3 - Qiwi");
		OnlineWallet e;
		int payment = input.nextInt();
		if(payment == 1){
			System.out.print("Enter the user's email: ");
			String login = input.next();
			System.out.print("Enter the password: ");
			String password = input.next();

			e = new PayPal(login, password, amount);
			if(e.checkLogin() == true)
			{
				System.out.println("Data verification has been successful.");
			}
			else
			{
				System.out.println("Wrong email or password!");
				e.againCheck();
			}
			
			if(e.checkBalance() == true)
			{
				System.out.print("Pay "+ amount +" units or Continue shopping? P/C: ");
				String payorcan = input.next();
				if(payorcan.equals("c")){
					e.againCheck();
				}
				else{
					System.out.println("Paying "+amount+" using PayPal.");
					System.out.println("Payment has been successful.");		
				}
			}
			else
			{
				System.out.println("Insufficient funds on your account!");
				System.out.println("Please, enter another PayPal account or top up the balance.");
				e.againCheck();		
			}
		}
		if(payment == 2){
			System.out.print("Enter the numbers of card: ");
			String cardNum = input.next();
			System.out.print("Enter the expiration date: ");
			int expDate = input.nextInt();
			System.out.print("Enter the CVV: ");
			String cvv = input.next();
			CreditCard c = new CreditCard(cardNum, expDate, cvv);
			if(c.checkCard() == true)
			{
				System.out.print("Pay "+ amount +" units or Continue shopping? P/C: ");
				String payorcan = input.next();
				if(payorcan.equals("c")){
					c.againCheckCard(count);
				}
				else{
					System.out.println("Paying "+amount+" using Credit Card.");
					System.out.println("Payment has been successful.");		
				}
			}
			else
			{
				System.out.println("Insufficient funds on your account or Wrong Card!");
				System.out.println("Please, enter another Credit Card account or top up the balance.");
				c.againCheckCard(count);		
			}
		}

		if(payment == 3){
			System.out.print("Enter the user's number: ");
			String login = input.next();
			System.out.print("Enter the password: ");
			String password = input.next();

			e = new Qiwi(login, password, amount);
			if(e.checkLogin() == true)
			{
				System.out.println("Data verification has been successful.");
			}
			else
			{
				System.out.println("Wrong email or password!");
				e.againCheck();
			}
			
			if(e.checkBalance() == true)
			{
				System.out.print("Pay "+ amount +" units or Continue shopping? P/C: ");
				String payorcan = input.next();
				if(payorcan.equals("c")){
					e.againCheck();
				}
				else{
					System.out.println("Paying "+amount+" using Qiwi.");
					System.out.println("Payment has been successful.");		
				}
			}
			else
			{
				System.out.println("Insufficient funds on your account!");
				System.out.println("Please, enter another Qiwi account or top up the balance.");
				e.againCheck();		
			}
		}
	}
}

