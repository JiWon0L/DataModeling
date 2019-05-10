package kr.ac.sunmoon.server;

import java.io.FileReader;
import java.util.Vector;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.opencsv.CSVReader;

import kr.ac.sunmoon.shared.Customer;

public class SearchServiceImpl extends RemoteServiceServlet 
{
	private Customer[] getCustomers(int option, String keyword) 
	{
		String filePath = this.getServletContext().getRealPath("/") + "\\customer_data.csv";
		Vector<Customer> vecCustomer = new Vector<Customer>();
		try 
		{ 
	        FileReader filereader = new FileReader(filePath); 
	  
	        CSVReader csvReader = new CSVReader(filereader); 
	        String[] record; 
	        
	        boolean isFirst = true;
	        while((record = csvReader.readNext()) != null) 
	        { 
	        	if(isFirst)
	        		isFirst = false;
	        	else
	        	{
	        		if(record[option].indexOf(keyword)>=0)
	        		{
	        			Customer customer = new Customer();
	        			customer.setFirstName(record[0]);
	        			customer.setLastName(record[1]);
	        			customer.setCompanyName(record[2]);
	        			customer.setAddress(record[3]);
	        			customer.setPhone(record[4]);
	        			customer.setEmail(record[5]);
	        			customer.setWeb(record[6]);
	        			vecCustomer.add(customer);
	        		}
	        	}
	        } 
	        
	        csvReader.close();
	    } 
	    catch (Exception e) { 
	        e.printStackTrace();
	        
	        System.out.println(this.getServletContext().getRealPath("/"));
	    } 
			
		Customer[] customers = new Customer[vecCustomer.size()];
		for(int i=0; i<customers.length; i++)
			customers[i] = vecCustomer.get(i);
		// TODO Auto-generated method stub
		return customers;
	}
}
