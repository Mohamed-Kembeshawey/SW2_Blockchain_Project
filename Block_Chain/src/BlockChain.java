
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;



 
import java.util.Date;


public class BlockChain {
	
	private int difficulty;
	private ArrayList<Block> my_Chain = new ArrayList<Block>();
	
	public BlockChain(int difficulty) {
		super();
		this.difficulty = difficulty;
		createGinisus();
	}
	
	public int getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(int difficulty) {
		this.difficulty = difficulty;
	}

	public ArrayList<Block> getMy_Chain() {
		return my_Chain;
	}

	public void setMy_Chain(ArrayList<Block> my_Chain) {
		this.my_Chain = my_Chain;
	}

	private void createGinisus() 
	{
		Transactions t = new Transactions("system","creator",1);
		Block b = new Block("null",t,"0000");
		my_Chain.add(b);
		
	}
	
	

	public String  getCurrentTimeUsingDate() {
	    Date date = new Date();
	    String strDateFormat = "hh:mm:ss a";
        DateFormat dateFormat = new SimpleDateFormat(strDateFormat);
        String formattedDate= dateFormat.format(date);
        return formattedDate ;
    }
	
	public void show_chain() {
		for(int i = 0 ; i< my_Chain.size();i++)
		{
			System.out.println("The block: "+ i + " ph: "+ my_Chain.get(i).getPrev_hash()+" "+ "h: "+ my_Chain.get(i).getHash()+ " "+ "f: "+ my_Chain.get(i).getData().getFrom());
		}
	}
}