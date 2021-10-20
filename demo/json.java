package com.example.demo;

public class json  {
	

		 private long vaka;
		    private long ölü;
		    private long kurtarıldı;
		    private long aktif;
		
			
		  
		    public json(long vaka, long ölü, long kurtarıldı, long aktif) {
		       
		     
		    }
		    
		    @Override
		    public String toString() {
		        return "{" + "vaka=" + vaka + ", ölü=" + ölü + ", kurtarıldı=" + kurtarıldı + ", aktif=" + aktif + '}';
		    }
	   
		    public json() {
		        vaka = aktif = kurtarıldı = ölü = 0;
		       
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
			
		
		    

}
