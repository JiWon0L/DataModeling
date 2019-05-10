package viviparidaeTest;

public class book {
	private String name;
	private String author;
	private String category;
	private String date;
	private int bookNumber;
	private int totalPoint;
	private int b_readcnt;
	public book(int bookNumber, String name, String author, String category, String date,int totalPoint,int b_readcnt) {
		this.bookNumber = bookNumber;
		this.name = name;
		this.author = author;
		this.category = category;
		this.date = date;
		this.totalPoint = totalPoint;
		this.b_readcnt = b_readcnt;
	}
	public String getName() {
		return name;
	}
	public String getAuthor() {
		return author;
	}
	public String getCategory() {
		return category;
	}
	public String getDate() {
		return date;
	}
	public int getBookNumber() {
		return bookNumber;
	}
	public int getTotalPoint() {
		return totalPoint;
	}
	public void setTotalPoint(int totalPoint) {
		this.totalPoint = totalPoint;
	}
	public int getB_readcnt() {
		return b_readcnt;
	}
	public void setB_readcnt(int b_readcnt) {
		this.b_readcnt = b_readcnt;
	}
	

}
