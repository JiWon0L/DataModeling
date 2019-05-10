package viviparidaeTest;

public class labeling {
	private String name;
	private int cnt;
	public labeling(String name) {
		this.name = name;
		cnt = 1;
	}
	
	public String getName() {
		return name;
	}

	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
}
