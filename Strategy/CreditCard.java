import java.io.*;
import java.util.*;
import java.util.Arrays;
import java.util.List;

public class CreditCard implements ForCards{
    Scanner input = new Scanner(System.in);
	public static void main(String[] args) {
	}
	String num;
	int exp;
	String cvv;
	CreditCard(String number, int expD, String cvvCode){
		this.num = number;
		this.exp = expD;
		this.cvv = cvvCode;
	}
    public boolean checkCard(){
        if(num.length() == 19){
            if(exp >= 2018){
                if(cvv.length() == 3){
                    return true;
                }
            }
        }
        else{
            return false;
        }
        return false;
    }
    public void againCheckCard(int cntS) throws Exception{
        System.out.print("Enter the numbers of card: ");
        String cardNum = input.next();
        System.out.print("Enter the expiration date: ");
        int expDate = input.nextInt();
        System.out.print("Enter the CVV: ");
        String cvv = input.next();
        CreditCard c = new CreditCard(cardNum, expDate, cvv);

        if(c.checkCard() == true)
        {
            System.out.println("Data verification has been successful.");
            System.out.println("Paying" + cntS + " using Credit Card.");
            System.out.println("Payment has been successful."); 
        }
        else
        {
            System.out.println("Wrong card!");
            againCheckCard(cntS);
        }
    }
}