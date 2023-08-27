import java.util.*;
import java.text.DecimalFormat;
class Currency_Converter
{
    public static void main(String[] args) 
        {
            double rupee,dollar,pound,euro;
            DecimalFormat f = new DecimalFormat("##.###");
            Scanner scn = new Scanner(System.in);
            System.out.println("*** WelCome to  Currency Converter ***\nEnter the currency code \n1:Rupees\n2:Dollar\n3:Pound\n4:Euro"); 
             int code =scn.nextInt();
            if(code == 1)
            {
                System.out.println("Enter amount in rupees:");
                rupee = scn.nextFloat();
                dollar = rupee / 82.64;
                System.out.println("Dollar : "+f.format(dollar));
                pound = rupee / 103.93;
                System.out.println("Pound : "+f.format(pound));
                euro = rupee / 89.25;
                System.out.println("Euro : "+f.format(euro));
                
            }
            else if (code == 2)
            {
                System.out.println("Enter amount in dollar:");
                dollar = scn.nextFloat();
                rupee = dollar * 82.64;
                System.out.println("Rupees : "+f.format(rupee));
                pound = dollar * 1.26;
                System.out.println("Pound : "+f.format(pound));
                euro = dollar * 1.08;
                System.out.println("Euro : "+f.format(euro));
                
            }
            else if(code == 3)
            {
                System.out.println("Enter amount in Pound:");
                pound = scn.nextFloat();
                rupee = pound * 103.85;
                System.out.println("Rupees : "+f.format(rupee));
                dollar = pound * 1.26;
                System.out.println("Dollar : "+f.format(dollar));
                euro = pound * 1.17;
                System.out.println("Euro : "+f.format(euro));
                
            }
            else if(code == 4)
            {
                System.out.println("Enter amount in Euro:");
                euro = scn.nextFloat();
                rupee = euro * 89.11;
                System.out.println("Rupees : "+f.format(rupee));
                dollar = euro * 1.08;
                System.out.println("Dollar : "+f.format(dollar));
                pound = euro * 0.86;
                System.out.println("Pound : "+f.format(pound));
               
            }
            
            else
                System.out.println("Invalid Code!");
    }
}
