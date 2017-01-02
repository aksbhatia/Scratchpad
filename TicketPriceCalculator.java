
/**
 * Utility class that helps to establish the relation between ticket price and profit earned,
 * under a set of pre-defined constraints eg: operating cost etc.
 * 
 * @author aksbhatia
 *
 */
public class TicketPriceCalculator {

	//TODO: Get all values from a config file
	private static final double ORIGINAL_COST_OF_TICKET_IN_DOLLAR = 5;
	private static final int ORIGINAL_NUMBER_OF_ATTENDEES = 120;

	private static final double FIXED_OPERATING_COST_IN_DOLLAR = 180;
	private static final double OPERATING_COST_PER_ATTENDEE_IN_CENTS = 4;

	//TODO: Link these two in a key value map and initialize during configuration.
	private static double VARIANCE_IN_TICKET_PRICE_IN_CENTS = 10;
	private static final int VARIANCE_IN_NUMBER_OF_ATTENDEES = 15;


	/**
	 * Helper method to compute the profit
	 * 
	 * @param n is the step with which the ticket price is changed.
	 * Eg: If n = 3, Ticket price => 5 - (VARIANCE_IN_TICKET_PRICE_IN_CENTS/100 * 3) i.e. 4.7$ in this case.
	 * @return profit
	 */
	public static double computeProfit(int n) {
		return ((computeTicketPrice(n) * computeNumberOfAttendees(n)) - (computeOperatingCost(n)));
	}

	private static double computeTicketPrice(int n) {
		return  (ORIGINAL_COST_OF_TICKET_IN_DOLLAR - (VARIANCE_IN_TICKET_PRICE_IN_CENTS / 100) * n);
	}

	private static int computeNumberOfAttendees(int n) {
		return (ORIGINAL_NUMBER_OF_ATTENDEES + VARIANCE_IN_NUMBER_OF_ATTENDEES * n) ;
	}

	private static double computeOperatingCost(int n) {
		return (OPERATING_COST_PER_ATTENDEE_IN_CENTS/100 * computeNumberOfAttendees(n) 
				+ FIXED_OPERATING_COST_IN_DOLLAR);
	}


	public static void main(String args[]) {

		// use priority queue in case the max profit is desired.
		/*MinMaxPriorityQueue<Double> profit = MinMaxPriorityQueue
			.maximumSize(1000)
			.create();*/

		for(int n=1; n<50; n++) {
			double profitMade = computeProfit(n);
			System.out.println("At n=" + n + " i.e. | Price = $" + computeTicketPrice(n) + " , Profit = $" + profitMade);
			//profit.add(profitMade);
		}


		//System.out.println("Max Profit:" + profit.pollLast());


	}

}
