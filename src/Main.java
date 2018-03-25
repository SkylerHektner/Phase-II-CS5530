import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main 
{
	public static void main(String[] args) 
	{
		String instructions = "Welcome to Uber Console Version! Please enter an integer to select from the following options \n"
				+ "1. Register a new user \n"
				+ "2. Reserve a car \n"
				+ "3. Create a new car \n"
				+ "4. Record a ride \n"
				+ "5. Record a favorite driver/car \n"
				+ "6. Record Feedback for a driver/car \n"
				+ "7. Rate Usefullness of another user \n"
				+ "8. Declare a user trusted \n"
				+ "9. Browse Cars by matching criteria \n"
				+ "10. Find Usefull feedback on a car/driver \n"
				+ "11. Get Suggestions for other good cars to reserve \n"
				+ "12. Determine similiarity with another rider \n"
				+ "13. Find More Statistics \n"
				+ "14. Check User Awards \n"
				+ "15. Exit the application \n";
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		while (true)
		{
			
			System.out.print(instructions);
			
			String input = "";
			try {
				input = in.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
						
			if (input == "1")
			{
				
			}
			if (input == "2")
			{
				
			}
			if (input == "3")
			{
				
			}
			if (input == "4")
			{
				
			}
			if (input == "5")
			{
				
			}
			if (input == "6")
			{
				
			}
			if (input == "7")
			{
				
			}
			if (input == "8")
			{
				
			}
			if (input == "9")
			{
				
			}
			if (input == "10")
			{
				
			}
			if (input == "11")
			{
				
			}
			if (input == "12")
			{
				
			}
			if (input == "13")
			{
				
			}
			if (input == "14")
			{
				
			}
			if (input == "15")
			{
				System.out.print("Goodbye \n");
				break;
			}
			
		}

	}
	
	/* 
	 * Registration: a new user (either UD or UU) has to provide the appropriate information;
	 * he/she can pick a login-name and a password.  The login name should be checked for uniqueness.
	 * */
	public String Register(String name, String password, String userType)
	{
		
		return "Success";
	}
	
	/*
	 * Reserve:After registration, a user can record a reservation to any UC 
	 * (the same user may reserve the same UC multiple times).  Each user session 
	 * (meaning each time after a user has logged into the system)may add one or more reservations,  
	 * and all reservations added by a user in a user session are reported to 
	 * him/her for the final review and confirmation, before they are added into the database.
	 */
	public String Reserve()
	{
		return "Success";
	}
	
	/*
	 * A user may record the details of a new UC, and may update the information regarding an existing UC he/she owns.
	 */
	public String NewUC()
	{
		return "Success";
	}
	
	/*
	 * A user can record a ride with a UC (the same user may ride the same UC multiple times).
	 * Each user session (meaning each time after a user has logged into the system) 
	 * may add one or more rides,and all rides added by a user in a user session are reported to 
	 * him/her for the final review and confirmation,before they are added into the database.  
	 * Note that a user may only record a ride at a UC during a period that the associated UD is available.
	 */
	public String Rides() 
	{
		return "Success";
	}
	
	/*
	 * Favorite recordings: Users can declare a UC as his/her favorite car to hire.
	 */
	public String RecordFavorite()
	{
		return "Success";
	}
	
	/*
	 * Feedback recordings:Users  can  record  their  feedback  for  a  UC.  We  should  record  the  date,
	 * the numerical score (0= terrible, 10= excellent), and an optional short text.  No changes are allowed; 
	 * only one feedback per user per UC is allowed.
	 */
	public String RecordFeedback()
	{
		return "Success";
	}
	
	/*
	 * Usefulness ratings:Users can assess a feedback record, giving it a numerical score 0, 1, or 2 
	 * (�useless�,�useful�, �very useful� respectively).  A user should not be allowed to provide a 
	 * usefulness-rating for his/her own feedbacks.
	 */
	public String RateUsefullness()
	{
		return "Success";
	}
	
	/*
	 * Trust recordings:A user may declare zero or more other users as �trusted� or �not-trusted�
	 */
	public String RecordTrust()
	{
		return "Success";
	}
	
	/*
	 * UC Browsing:Users may search for UCs, by asking conjunctive queries on the category, 
	 * and/or address (at CITY or State level), and/or model by keywords (e.g.  BMW, Toyota, F150).  
	 * Your system should allow the user to specify that the results are to be sorted (a) by the 
	 * average numerical score of the feedbacks,or (b) by the average numerical score of the trusted user feedbacks.
	 */
	public String BrowseUC()
	{
		return "Success";
	}
	
	/*
	 * Useful feedbacks:For a given UD, a user could ask for the top n most �useful� feedbacks 
	 * (from all feedbacks given to UCs owned by this UD). The value of n is user-specified (say, 5, or 10).  
	 * The �usefulness�of a feedback is its average �usefulness� score.
	 */
	public String FindFeedback()
	{
		return "Success";
	}
	
	/*
	 * UC suggestions:When a user records his/her reservations to a UC �A�, your system should give a list of other suggested UCs.  
	 * UC �B� is suggested, if there exist a user �X� that hired both �A� and �B�. The suggested UCs should be sorted on 
	 * decreasing total rides count (i.e., most popular first); count only rides by users like �X�.
	 */
	public String GetSuggestions()
	{
		return "Success";
	}
	
	/*
	 *Two degrees of separation�:Given two user names (logins), determine their �degree of separation�,
	 *defined as follows:  Two users �A� and �B� are 1-degree away if they have both favorited 
	 *at least one commonUC; they are 2-degrees away if there exists an user �C� who is 1-degree 
	 *away from each of �A� and �B�, AND�A� and �B� are not 1-degree away at the same time.
	 */
	public String DetermineSeperation()
	{
		return "Success";
	}
	
	/*
	 * Statistics:At any point, a user may want to show
	 * �the list of them(say m= 5) most popular UCs (in terms of total rides) for each category,
	 * �the list of most expensive UCs (defined by the average cost of all rides on a UC) for each category
	 * �the list of highly rated UDs (defined by the average scores from all feedbacks 
	 *  a UD has received for all of his/her UCs) for each category
	 */
	public String Statistics()
	{
		return "Success";
	}
	
	/*
	 * User awards:At random points of time, the admin user wants to give awards to the �best� users;
	 * thus, the admin user needs to know:
	 * �the top most �trusted� users (the trust score of a user is the count of users �trusting� him/her, 
	 * 	minus the count of users �not-trusting� him/her)
	 * �the top most �useful� users (the usefulness score of a user is the average �usefulness� of all 
	 * 	of his/her feedbacks combined)
	 */
	public String UserAwards()
	{
		return "Success";
	}
}