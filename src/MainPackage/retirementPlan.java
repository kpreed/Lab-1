/*Quentin Dubroff and Kaelan Reed
 * Lab 1
 * 9/14/15
 * This program asks the users for the required inputs and then prints how much money they need saved and how much they
 * need to save monthly in order to meet this requirement.
 */
package MainPackage;
import java.util.Scanner;
import org.apache.poi.ss.formula.functions.FinanceLib;

public class retirementPlan 
{
	public static void main(String[] args) 
	{
		Scanner input = new Scanner(System.in);
		System.out.println("How many years do you have left to work?");
		double yearsWork = input.nextDouble();
		
		System.out.println("What will the annual return on your saved money be while you're working? (%)");
		double workReturn = input.nextDouble();
		
		System.out.println("How many years do you plan on being retired?");
		double yearsRetired = input.nextDouble();
		
		System.out.println("What will the annual return on your saved money be while you're retired? (%)");
		double retiredReturn = input.nextDouble();
		
		System.out.println("What is your retired monthly income while you're retired?");
		double requiredIncome = input.nextDouble();
		
		System.out.println("How much will you get monthly from social security?");
		double monthlySSI = input.nextDouble();
		
		double needSaved = FinanceLib.pv(retiredReturn/100/12,yearsRetired*12,requiredIncome-monthlySSI,0,false);
		double PMT = FinanceLib.pmt(workReturn/100/12,yearsWork*12,0,needSaved,false);
		
		System.out.printf("You need to save $%.2f", PMT);
		System.out.printf(" a month for retirement");
		
	}

}
