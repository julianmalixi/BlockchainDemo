package blockchain;

import java.util.Date;

import util.StringHasher;

public class Block {

	public String currentHash;
	public String previousHash;
	private String data;
	private long time;
	
	public Block(String data, String prevHash) {
		this.data = data;
		this.previousHash = prevHash;
		this.time = new Date().getTime();
		this.currentHash = computeHash();
	}
	
	public String computeHash() {
		String hash = StringHasher.sha256ify(previousHash + Long.toString(time) + data);
		return hash;
	}
}
