package viviparidaeTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;
import java.util.Vector;

public class sqltest {

	public static void main(String args[]) {
		try {
			String url = "jdbc:mysql://localhost:3306/viviparidae?useSSL=false";
			String user = "root";
			String password = "@#lee98021";
			
			Connection con = DriverManager.getConnection(url, user, password);
			Statement stmt = con.createStatement();
			
			Scanner scan = new Scanner(System.in);
			System.out.print("학번을 입력해주세요 : ");
			String studentNumber = scan.nextLine();
			
			Vector<Integer> loan = new Vector<Integer>();
			Vector<book> loanr = new Vector<book>();
			Vector<book> library = new Vector<book>();

			String sql = "select * from record where studentNumber = \"" + studentNumber + "\"";
			ResultSet rs=stmt.executeQuery(sql);
			
			while(rs.next()) {
				loan.add(rs.getInt("b_number"));
			}
			
			for(int i = 0 ; i < loan.size(); i++){
				sql = "select * from book where b_number =" + loan.elementAt(i);
				rs=stmt.executeQuery(sql);
				rs.next();
				loanr.add(new book(loan.elementAt(i),
						rs.getString("b_name"),
						rs.getString("b_author"),
						rs.getString("b_category"),
						rs.getString("b_date"),
						rs.getInt("b_totalPoint"),
						rs.getInt("b_readcnt")));
			}
			Vector<labeling> author = new Vector<labeling>();
			Vector<labeling> category = new Vector<labeling>();
			
			for(int i = 0 ; i < loanr.size(); i++) {
				int check = 0;
				for(int j = 0; j < author.size(); j++) {
					if(loanr.elementAt(i).getAuthor().equals(author.elementAt(j).getName())) {
						author.elementAt(j).setCnt(author.elementAt(j).getCnt()+1);
						check++;
					}
				}
				if(check == 0) {
					author.add(new labeling(loanr.elementAt(i).getAuthor()));
				}
				check = 0;
				for(int j = 0; j < category.size(); j++) {
					if(loanr.elementAt(i).getCategory().equals(category.elementAt(j).getName())) {
						category.elementAt(j).setCnt(category.elementAt(j).getCnt()+1);
						check++;
					}
				}
				if(check == 0) {
					category.add(new labeling(loanr.elementAt(i).getCategory()));
				}
			}
			
			
			Collections.sort(author, new Mycomparator());
			
			double total = loanr.size();
			double authorPoint = (author.elementAt(0).getCnt() / total);
			
			Collections.sort(category, new Mycomparator());
			double categoryPoint = (category.elementAt(0).getCnt() / total);
			
			System.out.println(author.elementAt(0).getName() + ", 유사도 : "+ authorPoint * 100 +"%");
			

			System.out.println(category.elementAt(0).getName() + ", 유사도 : "+ categoryPoint * 100 +"%");
			
			if(authorPoint > categoryPoint) {
				System.out.println("작가 기준으로 찾아드렸어요!");
				sql = "select * from book where ";
				for(int i = 0; i < loan.size(); i++) {
					sql += "not b_number = \"" + loan.elementAt(i) +"\" ";
					sql += "and ";
				}
				sql += "b_author like \"%" + author.elementAt(0).getName() + "%\"";
				rs = stmt.executeQuery(sql);
				rs.next();

				book advice = new book(rs.getInt("b_number"),
						rs.getString("b_name"),
						rs.getString("b_author"),
						rs.getString("b_category"),
						rs.getString("b_date"),
						rs.getInt("b_totalPoint"),
						rs.getInt("b_readcnt"));
				while(rs.next()) {
					if(new Double(rs.getInt("b_totalPoint"))/rs.getInt("b_readcnt")>new Double(advice.getTotalPoint()) / advice.getB_readcnt()) {
						advice = new book(rs.getInt("b_number"),
								rs.getString("b_name"),
								rs.getString("b_author"),
								rs.getString("b_category"),
								rs.getString("b_date"),
								rs.getInt("b_totalPoint"),
								rs.getInt("b_readcnt"));	
					}
				}
				System.out.println("책의 번호: " + advice.getBookNumber() 
				+ "\n책의 이름: " + advice.getName()
				+ "\n책의 저자: " + advice.getAuthor()
				+ "\n책의 분류: " + advice.getCategory() 
				+ "\n책의 출판일: " + advice.getDate()
				+ "\n책의 평점: " + new Double(advice.getTotalPoint()) /advice.getB_readcnt());
			}
			else {
				System.out.println("장르 기준으로 찾아드렸어요!");
				sql = "select * from book where ";
				for(int i = 0; i < loan.size(); i++) {
					sql += "not b_number = \"" + loan.elementAt(i) +"\" ";
					sql += "and ";
				}
				sql += "b_category like \"%" + category.elementAt(0).getName() + "%\"";
				rs = stmt.executeQuery(sql);
				rs.next();
		
				book advice = new book(rs.getInt("b_number"),
						rs.getString("b_name"),
						rs.getString("b_author"),
						rs.getString("b_category"),
						rs.getString("b_date"),
						rs.getInt("b_totalPoint"),
						rs.getInt("b_readcnt"));
				while(rs.next()) {
					if(new Double(rs.getInt("b_totalPoint"))/rs.getInt("b_readcnt")>new Double(advice.getTotalPoint()) / advice.getB_readcnt()) {
						advice = new book(rs.getInt("b_number"),
								rs.getString("b_name"),
								rs.getString("b_author"),
								rs.getString("b_category"),
								rs.getString("b_date"),
								rs.getInt("b_totalPoint"),
								rs.getInt("b_readcnt"));	
					}
				}
				System.out.println("책의 번호: " + advice.getBookNumber() 
				+ "\n책의 이름: " + advice.getName()
				+ "\n책의 저자: " + advice.getAuthor()
				+ "\n책의 분류: " + advice.getCategory() 
				+ "\n책의 출판일: " + advice.getDate()
				+ "\n책의 평점: " + new Double(advice.getTotalPoint()) /advice.getB_readcnt());
			}
			
			rs.close();
			stmt.close();
			con.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
