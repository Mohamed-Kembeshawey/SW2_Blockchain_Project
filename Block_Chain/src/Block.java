import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Block {
	
	private String timeStemp;
	private String hash;
	private String prev_hash;
	private Transactions data;
	
	public Block(String timeStemp, Transactions data , String prev_hash) {
		super();
		this.timeStemp = timeStemp;
		this.data = data;
		this.prev_hash = prev_hash;
	}

	public String getTimeStemp() {
		return timeStemp;
	}

	public void setTimeStemp(String timeStemp) {
		this.timeStemp = timeStemp;
	}

	public Transactions getData() {
		return data;
	}

	public void setData(Transactions data) {
		this.data = data;
	}

	public String getHash() {
		return hash;
	}

	public void setHash(String hash) {
		this.hash = hash;
	}

	public String getPrev_hash() {
		return prev_hash;
	}

	public void setPrev_hash(String prev_hash) {
		this.prev_hash = prev_hash;
	}
	
	public String calculateHash(int nonce) {
		
		String Data = data.getFrom()+ data.getAmount() + data.getTo() + prev_hash + nonce + timeStemp;
		
		if (Data != null) {
			MessageDigest digest = null;

			String h = "";
			try {
				digest = MessageDigest.getInstance("SHA-256");
			} catch (NoSuchAlgorithmException e) {
				return null;
			}

			
			String txt = Data;
			
			final StringBuilder builder;
				final byte bytes[] = digest.digest(txt.getBytes());
				builder = new StringBuilder();

			for (final byte b : bytes) {
				String hex = Integer.toHexString(0xff & b);

				if (hex.length() == 1) {
					builder.append('0');
				}

				builder.append(hex);
			}
			h= builder.toString();
			
			return h;
		}

		return null;
	}

	
}

