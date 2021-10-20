package com.example.demo;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;


public class Url 


{
	
	
	 String country;
	static HttpURLConnection  connection =null;
	BufferedReader br =null;
	public ArrayList<Stats> res;
	String responseContent;
    String satir;
	String dosya="";
	
	 private long vaka;
	 private long ölü;
	 private long kurtarıldı;
	 private long aktif;
	
	
	
	public  Url (String country) {
		this.country=country;
		
		 String responseContent;
		 try {  responseContent = connect("https://disease.sh/v3/covid-19/countries/" + country);
	     if (responseContent==null){
	           System.out.println("Server yok");
	           
	       }
	     
	     parse(responseContent);
	     
	     
		
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	   
		
	}
	
	
	private static String connect(String myURL){
	       BufferedReader reader;
	       String line;
	       String  responseContent = new String();

	       try {
	           URL url = new URL(myURL);
	           connection = (HttpURLConnection) url.openConnection();

	           connection.setRequestMethod("GET");
	           connection.setReadTimeout(15000);
	           connection.setConnectTimeout(15000);

	           int status = connection.getResponseCode();
	           if (status == 200) {
	               reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
	               while ((line = reader.readLine()) != null) {
	                   
	           		responseContent+=line;
	        	
	               }
	               reader.close();
	           }

	       } catch (Exception e) {
	           e.printStackTrace();
	       } finally {
	           connection.disconnect();
	       }
	       return responseContent;
	   }
	
	
	private void parse(String responseContent) {
		
		
			
		     JSONObject stat = new JSONObject(responseContent);
		     vaka  = stat.getLong("todayCases");       
	         ölü  = stat.getLong("todayDeaths");
	        kurtarıldı  = stat.getLong("todayRecovered");
	        aktif  = stat.getLong("cases");
	         
	       
			
			
			
	
           
		}


	public long getVaka() {
		return vaka;
	}


	public void setVaka(long vaka) {
		this.vaka = vaka;
	}


	public long getÖlü() {
		return ölü;
	}


	public void setÖlü(long ölü) {
		this.ölü = ölü;
	}


	public long getKurtarıldı() {
		return kurtarıldı;
	}


	public void setKurtarıldı(long kurtarıldı) {
		this.kurtarıldı = kurtarıldı;
	}


	public long getAktif() {
		return aktif;
	}


	public void setAktif(long aktif) {
		this.aktif = aktif;
	}
	

    @Override
    public String toString() {
        return "{" +  "Vaka=" + vaka +" Dead=" + ölü + "  Kurtln=" + kurtarıldı + "  Aktif=" + aktif + '}';
    }
	
	

}

	        
	      
	           
	        
	          
		
//		   res = new ArrayList<Stats>();
//	          
//		     
//		      
//	       
//	           JSONObject stat = new JSONObject(responseContent);
//	           
//	         
//	        
	           
	            
	          
	

		
	
	
	
	 
	   
	
	

	
		
		
	
	



