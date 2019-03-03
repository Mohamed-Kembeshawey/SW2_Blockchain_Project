
public class Transactions {

	private String From;
	private String To;
	private int amount;
	
	public Transactions() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Transactions(String from, String to, int amount) {
		super();
		From = from;
		To = to;
		this.amount = amount;
	}

	public String getFrom() {
		return From;
	}
	public void setFrom(String from) {
		From = from;
	}

	public String getTo() {
		return To;
	}
	public void setTo(String to) {
		To = to;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	
}
