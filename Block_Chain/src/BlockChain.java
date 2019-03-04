
                                                                                                                                                                                  
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
	                                                                                                                                                                              
	public  void mining(Transactions trans,String ph)                                                                                                                             
		{                                                                                                                                                                         
			String hash="";                                                                                                                                                       
    		                                                                                                                                                                      
			int nonce = 0;                                                                                                                                                        
    		                                                                                                                                                                      
			boolean t = true;                                                                                                                                                     
    		Block block = null;                                                                                                                                                   
    		while(t) {                                                                                                                                                            
    			                                                                                                                                                                  
    			t = false;                                                                                                                                                        
    			                                                                                                                                                                  
    			block = new Block(getCurrentTimeUsingDate(), trans, ph);                                                                                                          
    			                                                                                                                                                                  
    			hash = block.calculateHash(nonce);                                                                                                                                
    			                                                                                                                                                                  
    			for(int i=0;i<difficulty;i++)                                                                                                                                     
    			{                                                                                                                                                                 
    				if(hash.charAt(i) != '0')                                                                                                                                     
    				{                                                                                                                                                             
    					t = true;                                                                                                                                                 
    					break;                                                                                                                                                    
    				}                                                                                                                                                             
    			}                                                                                                                                                                 
    			nonce++;                                                                                                                                                          
    		}                                                                                                                                                                     
    		block.setHash(hash);                                                                                                                                                  
    		my_Chain.add(block);                                                                                                                                                  
    		                                                                                                                                                                      
    		System.out.println("H: " + hash);    		                                                                                                                          
    	}                                                                                                                                                                         
                                                                                                                                                                                  
	public String  getCurrentTimeUsingDate() {                                                                                                                                    
	    Date date = new Date();                                                                                                                                                   
	    String strDateFormat = "hh:mm:ss a";                                                                                                                                      
        DateFormat dateFormat = new SimpleDateFormat(strDateFormat);                                                                                                              
        String formattedDate= dateFormat.format(date);                                                                                                                            
        return formattedDate ;                                                                                                                                                    
    }                                                                                                                                                                             
	                                                                                                                                                                              
		                                                                                                                                                                          
	                                                                                                                                                                              
	                                                                                                                                                                              
	public void is_Valid(){                                                                                                                                                       
			for(int i = 0; i<my_Chain.size()-1;i++)                                                                                                                               
			{                                                                                                                                                                     
				if(my_Chain.get(i).getHash() != my_Chain.get(i+1).getPrev_hash())                                                                                                 
					{System.out.println("Thier is a conflict");                                                                                                                   
					return;}                                                                                                                                                      
				                                                                                                                                                                  
			}                                                                                                                                                                     
			System.out.println("The chain is valid.");                                                                                                                            
		}                                                                                                                                                                         
	                                                                                                                                                                              
	public void show_chain() {                                                                                                                                                    
		for(int i = 0 ; i< my_Chain.size();i++)                                                                                                                                   
		{                                                                                                                                                                         
			System.out.println("The block: "+ i + " ph: "+ my_Chain.get(i).getPrev_hash()+" "+ "h: "+ my_Chain.get(i).getHash()+ " "+ "f: "+ my_Chain.get(i).getData().getFrom());
		}                                                                                                                                                                         
	}                                                                                                                                                                             
}                                                                                                                                                                                 
=======
                                                                                                                                                                                  
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
	                                                                                                                                                                              
	public  void mining(Transactions trans,String ph)                                                                                                                             
		{                                                                                                                                                                         
			String hash="";                                                                                                                                                       
    		                                                                                                                                                                      
			int nonce = 0;                                                                                                                                                        
    		                                                                                                                                                                      
			boolean t = true;                                                                                                                                                     
    		Block block = null;                                                                                                                                                   
    		while(t) {                                                                                                                                                            
    			                                                                                                                                                                  
    			t = false;                                                                                                                                                        
    			                                                                                                                                                                  
    			block = new Block(getCurrentTimeUsingDate(), trans, ph);                                                                                                          
    			                                                                                                                                                                  
    			hash = block.calculateHash(nonce);                                                                                                                                
    			                                                                                                                                                                  
    			for(int i=0;i<difficulty;i++)                                                                                                                                     
    			{                                                                                                                                                                 
    				if(hash.charAt(i) != '0')                                                                                                                                     
    				{                                                                                                                                                             
    					t = true;                                                                                                                                                 
    					break;                                                                                                                                                    
    				}                                                                                                                                                             
    			}                                                                                                                                                                 
    			nonce++;                                                                                                                                                          
    		}                                                                                                                                                                     
    		block.setHash(hash);                                                                                                                                                  
    		my_Chain.add(block);                                                                                                                                                  
    		                                                                                                                                                                      
    		System.out.println("H: " + hash);    		                                                                                                                          
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
