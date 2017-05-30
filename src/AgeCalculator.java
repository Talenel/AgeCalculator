import java.time.LocalDate;
import java.time.Month;
import java.util.Scanner;

public class AgeCalculator {

	public static void main(String[] args) {
		
		
		// TODO Auto-generated method stub
		int monthInt=0;
		String month;
		int year;
		int day;
		int[] age=new int[50];
		boolean leapYear;
		
		
		Scanner user = new Scanner(System.in);
		boolean check=false;
		LocalDate cur = LocalDate.now();
		int i=0;
		while(check==false)
		{	
			
			do
			{
				System.out.println("Please input your year of birth");
				year=user.nextInt();
				if(year>=1900 &&year <= cur.getYear())
				{
					check=true;
				}
				else
				{
					System.out.println("Invalid year");
				}
				
				
			}while(check==false);
			
			
			
			user.nextLine();
			check=false;
			do
			{
				
				System.out.println("Please input your month of birth");
				month= user.nextLine();
				
				switch (month) {
		        case "January":  monthInt = 1;
		        	 	 check=true;
		                 break;
		        case "February":  monthInt = 2;
		        	 	 check=true;
		                 break;
		        case "March":  monthInt = 3;
		 			 	 check=true;
		                 break;
		        case "April":  monthInt =4;
		 			 	 check=true;
		                 break;
		        case "May":  monthInt =5;
		 			 	 check=true;
		                 break;
		        case "June":  monthInt = 6;
		 			 	 check=true;
		                 break;
		        case "July":  monthInt = 7;
		 			 	 check=true;
		                 break;
		        case "August":  monthInt = 8;
		 			 	 check=true;
		                 break;
		        case "September":  monthInt =9 ;
		 			 	 check=true;
		                 break;
		        case "October": monthInt = 10;
		 			 	 check=true;
		                 break;
		        case "November": monthInt = 11;
		 			 	 check=true;
		                 break;
		        case "December": monthInt = 12;
	   		 			 check=true;
		                 break;
		        default: month = "Invalid month";
		        	 	 System.out.println(month);
		                 break;
				}
			}while(check==false);
			
			check=false;
			do
			{
				Month bMonth= Month.of(monthInt);
				System.out.println("Please input your day of birth");
				day=user.nextInt();
				if((year%4)==0)
				{
					 leapYear=true;
				}
				else
				{
					leapYear=false;
				}
				
				if((!(year == cur.getYear() && monthInt ==cur.getMonthValue()))|| day<=cur.getDayOfMonth())
				{
					if(day<=bMonth.length(leapYear)&& day>=1)
					{	
						check=true;
					}
					else
					{
						System.out.println("Invalid day");
					}
				}
				
				else
				{
					System.out.println("Invalid day");
				}
				
				
			}while(check==false);
			
			age[i]= processAge(year, monthInt, year, cur);
			i++;
		
			user.nextLine();
			System.out.println("Would you like to enter details for another client? (Y/N)");
			String ans=user.nextLine();
			if(ans.equals("Y"))
			{
				check=false;
			}
			
		}
		user.close();
		for(int j=0;j<i; j++)
		{
			System.out.println("The client's age is: "+age[j]);
		}
		System.out.println("Thanks for using the age calculator!");
		
	}

	public static int processAge(int aYear, int aMonth, int aDay, LocalDate date)
	{
		
		int calcAge=0;
		calcAge=date.getYear()-aYear;
		if(aMonth>date.getMonthValue())
		{
			calcAge--;
		}
		else if(aMonth==date.getMonthValue()&&aDay<date.getDayOfMonth())
		{
			calcAge--;
		}
		
		
		
		return calcAge;
    }
	
}


