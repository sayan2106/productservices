package com.springbootjava.product.data;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import com.google.gson.Gson; 
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject; 

public class ProductDetails {
	
	public String readContentFromURL() {
		String content=" ";
		Scanner sc=null;
		try {
			URL url = new URL("https://products-json-example.s3.eu-central-1.amazonaws.com/data.json");
			HttpURLConnection conn = (HttpURLConnection)url.openConnection();
			conn.setRequestMethod("GET");
			conn.connect();
			int responsecode = conn.getResponseCode();
			System.out.println("Response code is: " +responsecode);

			if(responsecode != 200)
				throw new RuntimeException("HttpResponseCode: " +responsecode);
			else
			{
				//Scanner functionality will read the JSON data from the stream
				sc = new Scanner(url.openStream());
				while(sc.hasNext())
				{
					content+=sc.nextLine();
				}
				System.out.println("\nJSON Response in String format"); 
				
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		finally {
			sc.close();
		}
		return content;
		
	}

	   public static void main(String[] args) { 
	      String jsonString = "{\"name\":\"Mahesh\", \"age\":21}"; 
	      
	      
	      GsonBuilder builder = new GsonBuilder(); 
	      builder.setPrettyPrinting(); 
	      
	      Gson gson = builder.create(); 
	      Student student = gson.fromJson(jsonString, Student.class); 
	      System.out.println(student);    
	      
	      jsonString = gson.toJson(student); 
	      System.out.println(jsonString);
	      
	      ProductDetails _productDetails=new ProductDetails();
	      String out=_productDetails.readContentFromURL();
	      System.out.println(out);
	      
	     
	      
	   } 
	} 

	class Student { 
	   private String name; 
	   private int age; 
	   public Student(){} 
	   
	   public String getName() { 
	      return name; 
	   }
	   
	   public void setName(String name) { 
	      this.name = name; 
	   } 
	   
	   public int getAge() { 
	      return age; 
	   }
	   
	   public void setAge(int age) { 
	      this.age = age; 
	   }
	   
	   public String toString() { 
	      return "Student [ name: "+name+", age: "+ age+ " ]"; 
	   }  
	

}
