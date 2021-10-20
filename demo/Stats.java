package com.example.demo;


/**
 *
 * @author Mohamed Kramti
 */
public class Stats {
    private long totalConfirmed;
    private long dailyDeaths;
    private long totalRecovered;
    private long totalActive;
   
    
   
    public Stats(long totalConfirmed, long dailyDeaths, long totalRecovered, long totalActive) {
        this.totalConfirmed = totalConfirmed;
        this.dailyDeaths = dailyDeaths;
        this.totalRecovered = totalRecovered;
        this.totalActive = totalActive;
      
    }
    public Stats() {
        totalConfirmed = dailyDeaths = totalRecovered = totalActive = 0;
     
    }
  
  

    public long getTotalConfirmed() {
        return totalConfirmed;
    }

    public long getDailyDeaths() {
        return dailyDeaths;
    }

    public long getTotalRecovered() {
        return totalRecovered;
    }

    public long getTotalActive() {
        return totalActive;
    }



    public void setTotalConfirmed(long totalConfirmed) {
        this.totalConfirmed = totalConfirmed;
    }

    public void setDailyDeaths(long dailyDeaths) {
        this.dailyDeaths = dailyDeaths;
    }

    public void setTotalRecovered(long totalRecovered) {
        this.totalRecovered = totalRecovered;
    }

    public void setTotalActive(long totalActive) {
        this.totalActive = totalActive;
    }


    @Override
    public String toString() {
        return "Stats{" + "totalConfirmed=" + totalConfirmed + ", dailyDeaths=" + dailyDeaths + ", totalRecovered=" + totalRecovered + ", totalActive=" + totalActive +  '}';
    }
    
    
    
}
