
public class Main 
{
	public static void main(String[] args) 
	{
		
		System.out.print("HELLO WORLD");

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
	 * (’useless’,’useful’, ’very useful’ respectively).  A user should not be allowed to provide a 
	 * usefulness-rating for his/her own feedbacks.
	 */
	public String RateUsefullness()
	{
		return "Success";
	}
	
	/*
	 * Trust recordings:A user may declare zero or more other users as ‘trusted’ or ‘not-trusted’
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
	 * Useful feedbacks:For a given UD, a user could ask for the top n most ‘useful’ feedbacks 
	 * (from all feedbacks given to UCs owned by this UD). The value of n is user-specified (say, 5, or 10).  
	 * The ‘usefulness’of a feedback is its average ‘usefulness’ score.
	 */
	public String GiveFeedback()
	{
		return "Success";
	}
	
	/*
	 * UC suggestions:When a user records his/her reservations to a UC ‘A’, your system should give a list of other suggested UCs.  
	 * UC ‘B’ is suggested, if there exist a user ‘X’ that hired both ‘A’ and ‘B’. The suggested UCs should be sorted on 
	 * decreasing total rides count (i.e., most popular first); count only rides by users like ‘X’.
	 */
	public String GiveSuggestion()
	{
		return "Success";
	}
	
	/*
	 * UC suggestions:When a user records his/her reservations to a UC ‘A’, your system should give a list 
	 * of other suggested UCs.  UC ‘B’ is suggested, if there exist a user ‘X’ that hired both ‘A’ and ‘B’. 
	 * The suggested UCs should be sorted on decreasing total rides count (i.e., most popular first); 
	 * count only rides by users like ‘X’.
	 */
	public String DetermineSeperation()
	{
		return "Success";
	}
	
	/*
	 * Statistics:At any point, a user may want to show
	 * •the list of them(say m= 5) most popular UCs (in terms of total rides) for each category,
	 * •the list of most expensive UCs (defined by the average cost of all rides on a UC) for each category
	 * •the list of highly rated UDs (defined by the average scores from all feedbacks 
	 *  a UD has received for all of his/her UCs) for each category
	 */
	public String Statistics()
	{
		return "Success";
	}
	
	/*
	 * User awards:At random points of time, the admin user wants to give awards to the ‘best’ users;
	 * thus, the admin user needs to know:
	 * •the top most ‘trusted’ users (the trust score of a user is the count of users ‘trusting’ him/her, 
	 * 	minus the count of users ‘not-trusting’ him/her)
	 * •the top most ‘useful’ users (the usefulness score of a user is the average ‘usefulness’ of all 
	 * 	of his/her feedbacks combined)
	 */
	public String UserAwards()
	{
		return "Success";
	}
}