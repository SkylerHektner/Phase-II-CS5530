import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Main 
{
	public static void main(String[] args) throws IOException 
	{
		String instructions = ""
				+ "Welcome to Uber Console Version! Please enter an integer to select from the following options \n"
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
		
		Boolean keepReading = true;
		
		while (keepReading)
		{
			System.out.print(instructions);
			
			String input = "";
			try {
				input = in.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			int c = 0;
			try {
				c = Integer.parseInt(input);
			} catch (NumberFormatException e) {
				System.out.println("You did not enter a number correctly");
			}
			
				
			// CASE 1: REGISTER A NEW USER
			if (c == 1)
			{
				System.out.println("You are now registering a new user");
				
				System.out.println("Please enter your login-name: ");
				String name = in.readLine();
				System.out.println("Please enter your password: ");
				String password = in.readLine();
				System.out.println("Please enter your user type (\"UU\" for uber user, \"UD for uber driver\": ");
				String userType = in.readLine();
				
				String result = Register(name, password, userType);
				System.out.println(result);
			}
			
			// CASE 2: Reserve times for a car
			else if (c == 2)
			{
				System.out.println("Please enter your login name: ");
				String login = in.readLine();
				System.out.println("Please enter your password");
				String password = in.readLine();
				System.out.println("Please enter the number of reservations you'd like to make");
				Integer numReservations = Integer.parseInt(in.readLine());
				System.out.println("Please enter your times one line at a time in the following format (hh:mm:ss)");
				List<String> Dates = new ArrayList<String>();
				for(int i = 0; i < numReservations; i++)
				{
					Dates.add(in.readLine());
				}
				System.out.println("Confirm that the following times are correct (y/n)");
				for (String s: Dates)
				{
					System.out.println(s);
				}
				if ("y".equals(in.readLine()))
				{
					System.out.println(Reserve(login, password, Dates));
				}
				
			}
			else if (c == 3)
			{
				System.out.println("Please enter your login name: ");
				String login = in.readLine();
				System.out.println("Please enter your password");
				String password = in.readLine();
				System.out.println("Please enter your Vehicle ID Number");
				String vin = in.readLine();
				System.out.println("Please enter your Vehicle Category");
				String category = in.readLine();
				System.out.println(NewUC(login, password, vin, category));
			}
			else if (c == 4)
			{
				
			}
			else if (c == 5)
			{
				System.out.println("Please enter your login name: ");
				String login = in.readLine();
				System.out.println("Please enter your password");
				String password = in.readLine();
				System.out.println("Please enter the Vehicle ID Number");
				String vin = in.readLine();
				System.out.println(RecordFavorite(login, password, vin));
			}
			else if (c == 6)
			{
				System.out.println("Please enter your login name: ");
				String login = in.readLine();
				System.out.println("Please enter your password");
				String password = in.readLine();
				System.out.println("Please enter the Vehicle ID Number");
				String vin = in.readLine();
				System.out.println("Please enter a score from 0-10");
				String score = in.readLine();
				if (0 > Integer.parseInt(score) || 10 < Integer.parseInt(score))
				{
					System.out.println("You did not enter a score from 0-10");
					continue;
				}
				System.out.println("Please enter any feedback (optional, press enter to skip)");
				String text = in.readLine();
				System.out.println(RecordFeedback(login, password, vin, score, text));
			}
			else if (c == 7)
			{
				System.out.println("Please enter your login name: ");
				String login = in.readLine();
				System.out.println("Please enter your password");
				String password = in.readLine();
				System.out.println("Please enter the Feedback ID Number");
				String fin = in.readLine();
				System.out.println("Please enter a score from 0-2");
				String score = in.readLine();
				if (0 > Integer.parseInt(score) || 2 < Integer.parseInt(score))
				{
					System.out.println("You did not enter a score from 0-10");
					continue;
				}
				System.out.println(RateUsefullness(login, password, fin, score));
			}
			else if (c == 8)
			{
				
			}
			else if (c == 9)
			{
				
			}
			else if (c == 10)
			{
				
			}
			else if (c == 11)
			{
				
			}
			else if (c == 12)
			{
				
			}
			else if (c == 13)
			{
				
			}
			else if (c == 14)
			{
				
			}
			else if (c == 15)
			{
				System.out.print("Goodbye \n");
				keepReading = false;
			}
			
			System.out.println("Press any enter to continue...");
			in.readLine();
		}
	}
	
	/* 
	 * Registration: a new user (either UD or UU) has to provide the appropriate information;
	 * he/she can pick a login-name and a password.  The login name should be checked for uniqueness.
	 * */
	public static String Register(String loginName, String password, String userType)
	{
		// create a new connection with the database
		Connector connection;
		try {
			connection = new Connector();
		} catch (Exception e) {
			return e.getMessage();
		}
		
		// select the 5530db26 from the server
		try {
			connection.con.createStatement().executeQuery("use 5530db26");
		} catch (SQLException e) {
			return e.getMessage();
		}
		
		// construct a query
		String Query = "";
		if (userType.equals("UU"))
		{
			Query = String.format("INSERT INTO UU VALUES ('%s', 'noName', 'noAddress', 5555555, '%s')", loginName, password);
		}
		else if (userType.equals("UD"))
		{
			Query = String.format("INSERT INTO UD VALUES ('%s', 'noName', 'noAddress', 5555555, '0', '%s', 'noUDCol')", loginName, password);
		}
						
		// execute the query
		try {
			connection.con.createStatement().execute(Query);
		} catch (SQLException e) {
			return e.getMessage();
		}
		
		
		// close the connection
		try {
			connection.closeConnection();
		} catch (Exception e) {
			return e.getMessage();
		}
		
		// return a success message for the User
		return "Success";
	}
	
	/*
	 * Reserve: After registration, a user can record a reservation to any UC 
	 * (the same user may reserve the same UC multiple times).  Each user session 
	 * (meaning each time after a user has logged into the system) may add one or more reservations,  
	 * and all reservations added by a user in a user session are reported to 
	 * him/her for the final review and confirmation, before they are added into the database.
	 */
	public static String Reserve(String login, String password, List<String> Times)
	{
		// check that the login and password are valid
		String loginVerification = verifyLogin(login, password, "UU");
		if(!loginVerification.equals("Success"))
		{
			return loginVerification;
		}
		
		// create a new connection with the database
		Connector connection;
		try {
			connection = new Connector();
		} catch (Exception e) {
			return e.getMessage();
		}
		
		// select the 5530db26 from the server
		try {
			connection.con.createStatement().executeQuery("use 5530db26");
		} catch (SQLException e) {
			return e.getMessage();
		}
		
		for(String s : Times)
		{
			String time = s.substring(0, 2);
			String Query = String.format("select vin, pid from UC inner join "
					+ "(select login, pid from Available where pid in "
					+ "(select pid from Period where %s < Period.to and %s > Period.from)) a on UC.login = a.login;", time, time);
						
			ResultSet results;
			
			// execute the query
			try {
				results = connection.con.createStatement().executeQuery(Query);
				if (!results.first()) 
				{
					System.out.println("No valid reservations at " + s 
							+ "\n This reservation was skipped");
				}
				
				else
				{
					int vin = results.getInt(1);
					int pid = results.getInt(2);
					connection.con.createStatement().execute(String.format(""
							+ "INSERT INTO Reserve VALUES ('%s', %d, %d, 100, '%s')", login,
							vin, pid, s));
				}
			} catch (SQLException e) {
				// close the connection
				try {
					connection.closeConnection();
				} catch (Exception j) {
					return j.getMessage();
				}
				return e.getMessage();
			}
		}
		// close the connection
		try {
			connection.closeConnection();
		} catch (Exception e) {
			return e.getMessage();
		}
		
		// return a success message for the user
		return "Success";
	}
	
	/*
	 * A user may record the details of a new UC, and may update the information regarding an existing UC he/she owns.
	 */
	public static String NewUC(String login, String password, String vin, String category)
	{
		String loginVerification = verifyLogin(login, password, "UD");
		if(!loginVerification.equals("Success"))
		{
			return loginVerification;
		}
		
		// create a new connection with the database
		Connector connection;
		try {
			connection = new Connector();
		} catch (Exception e) {
			return e.getMessage();
		}
		
		// select the 5530db26 from the server
		try {
			connection.con.createStatement().executeQuery("use 5530db26");
		} catch (SQLException e) {
			return e.getMessage();
		}
		
		// Create the query
		String NewEntryQuery = String.format("INSERT INTO UC VALUES (%s, '%s', '%s')",
				vin, category, login);
		String ModifyEntryQuery = String.format("UPDATE UC SET category = '%s'"
				+ "WHERE vin = %s", category, vin);
		
		// execute the query
		try {
			// first we try to create a new entry in the UC table
			connection.con.createStatement().execute(NewEntryQuery);
		} catch (SQLException e) {
			// if we get the duplicate entry error, we try to modify the existing entry
			if (e.getMessage().contains("Duplicate entry"))
			{
				try {
					connection.con.createStatement().execute(ModifyEntryQuery);
				} catch (SQLException e1) {
					// close the connection
					try {
						connection.closeConnection();
					} catch (Exception j) {
						return j.getMessage();
					}
					return e1.getMessage();
				}
			}
			else
			{
				// close the connection
				try {
					connection.closeConnection();
				} catch (Exception j) {
					return j.getMessage();
				}
				return e.getMessage();
			}
		}
		// close the connection
		try {
			connection.closeConnection();
		} catch (Exception e) {
			return e.getMessage();
		}
		
		
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
	public static String RecordFavorite(String login, String password, String vin)
	{
		// Verify the login information of the user
		String loginVerification = verifyLogin(login, password, "UU");
		if(!loginVerification.equals("Success"))
		{
			return loginVerification;
		}
		
		// create a new connection with the database
		Connector connection;
		try {
			connection = new Connector();
		} catch (Exception e) {
			return e.getMessage();
		}
		
		// select the 5530db26 from the server
		try {
			connection.con.createStatement().executeQuery("use 5530db26");
		} catch (SQLException e) {
			return e.getMessage();
		}
		
		String Query = String.format("INSERT INTO Favorites VALUES (%s, '%s', cast(CURDATE() as Date))", 
				vin, login);
		
		// execute the Query
		try {
			connection.con.createStatement().execute(Query);
		} catch (SQLException e) {
			// close the connection
			try {
				connection.closeConnection();
			} catch (Exception j) {
				return j.getMessage();
			}
			return e.getMessage();
		}
		
		// close the connection
		try {
			connection.closeConnection();
		} catch (Exception e) {
			return e.getMessage();
		}
		
		return "Success";
	}
	
	/*
	 * Feedback recordings:Users  can  record  their  feedback  for  a  UC.  We  should  record  the  date,
	 * the numerical score (0= terrible, 10= excellent), and an optional short text.  No changes are allowed; 
	 * only one feedback per user per UC is allowed.
	 */
	public static String RecordFeedback(String login, String password, String vin, String score, String text)
	{
		// Verify the login information of the user
		String loginVerification = verifyLogin(login, password, "UU");
		if(!loginVerification.equals("Success"))
		{
			return loginVerification;
		}
		
		// create a new connection with the database
		Connector connection;
		try {
			connection = new Connector();
		} catch (Exception e) {
			return e.getMessage();
		}
		
		// select the 5530db26 from the server
		try {
			connection.con.createStatement().executeQuery("use 5530db26");
		} catch (SQLException e) {
			return e.getMessage();
		}
		
		String Query = String.format("INSERT INTO Feedback (text, fbdate, vin, login, score) "
				+ "VALUES ('%s', cast(CURDATE() as Date), %s, '%s', %s)",
				text, vin, login, score);
		
		// execute the Query
		try {
			connection.con.createStatement().execute(Query);
		} catch (SQLException e) {
			// close the connection
			try {
				connection.closeConnection();
			} catch (Exception j) {
				return j.getMessage();
			}
			return e.getMessage();
		}
		
		// close the connection
		try {
			connection.closeConnection();
		} catch (Exception e) {
			return e.getMessage();
		}
		
		return "Success";
	}
	
	/*
	 * Usefulness ratings:Users can assess a feedback record, giving it a numerical score 0, 1, or 2 
	 * (�useless�,�useful�, �very useful� respectively).  A user should not be allowed to provide a 
	 * usefulness-rating for his/her own feedbacks.
	 */
	public static String RateUsefullness(String login, String password, String fid, String rating)
	{
		// Verify the login information of the user
		String loginVerification = verifyLogin(login, password, "UU");
		if(!loginVerification.equals("Success"))
		{
			return loginVerification;
		}
		
		// create a new connection with the database
		Connector connection;
		try {
			connection = new Connector();
		} catch (Exception e) {
			return e.getMessage();
		}
		
		// select the 5530db26 from the server
		try {
			connection.con.createStatement().executeQuery("use 5530db26");
		} catch (SQLException e) {
			return e.getMessage();
		}
		
		// TEST if the user is trying to rate their own feedback
		String testQuery = String.format("Select login from Feedback where fid = %s", fid);
		// Check if the feedback ID is valid or they are rating themselves
		try {
			ResultSet results = connection.con.createStatement().executeQuery(testQuery);
			if (results.first() && !results.getString(1).equals(login))
			{
				// do nothing and proceed with the method
			}
			else
			{
				// close the connection
				try {
					connection.closeConnection();
				} catch (Exception j) {
					return j.getMessage();
				}
				return "Either feedback ID doesn't exist or you are rating yourself";
			}
		} catch (SQLException e) {
			// close the connection
			try {
				connection.closeConnection();
			} catch (Exception j) {
				return j.getMessage();
			}
			return e.getMessage();
		}

		//quickly format rating into it's corresponding value
		if (rating.equals("0"))
		{
			rating = "useless";
		}
		else if (rating.equals("1"))
		{
			rating = "useful";
		}
		else if (rating.equals("2"))
		{
			rating = "very useful";
		}
		
		// construct insert query for rating table
		String Query = String.format("INSERT INTO Rates VALUES ('%s', %s, '%s')",
				login, fid, rating);
		
		// Insert new rating into Rates table
		try {
			connection.con.createStatement().execute(Query);
		} catch (SQLException e) {
			// close the connection
			try {
				connection.closeConnection();
			} catch (Exception j) {
				return j.getMessage();
			}
			return e.getMessage();
		}
		
		// close the connection
		try {
			connection.closeConnection();
		} catch (Exception e) {
			return e.getMessage();
		}
		
		
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
	
	public static String verifyLogin(String login, String password, String userType)
	{
		// create a new connection with the database
		Connector connection;
		try {
			connection = new Connector();
		} catch (Exception e) {
			return e.getMessage();
		}
		
		// select the 5530db26 from the server
		try {
			connection.con.createStatement().executeQuery("use 5530db26");
		} catch (SQLException e) {
			return e.getMessage();
		}
		
		// check that the login and password are valid
		try {
			ResultSet pasRes = connection.con.createStatement().executeQuery(String.format(
					"select * from "
					+ "%s where login = '%s' AND password = '%s'", userType, login, password));
			if (!pasRes.first()) {
				// close the connection
				try {
					connection.closeConnection();
				} catch (Exception e) {
					return e.getMessage();
				}
				return "Your login information was invalid";
			}
		} catch (SQLException e) {
			return e.getMessage();
		}
		
		// close the connection
		try {
			connection.closeConnection();
		} catch (Exception e) {
			return e.getMessage();
		}
		
		
		return "Success";
	}
}