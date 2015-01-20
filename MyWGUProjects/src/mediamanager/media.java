/* the abstract, super class*/
package mediamanager;
/**
 *
 * @author Pubali Banerjee
 * written on 11/14/2012
 * This is the superclass for this application. It is also an abstract class with 
 * several abstract methods 
 */

  public abstract class media 
  {
    protected  Integer mediaID;
    protected  String title;
    protected  String year;
    protected  double cost;
    protected  String type;
    
    // default constructor
    media() 
    {
       title= "";
       year = "";
       mediaID = 0;
       type= "";
       cost = 0;
    }

//setters
    public  void setmediaID(Integer SID){
        mediaID = SID;
    }
    
    public void setTitle(String Title){
         title = Title;
    }
    
    public  void setYear(String Year){
        year = Year;
    }
    
    public  void setCost(double Cost){
        cost = Cost;
    }
    
    public void setType(String Type){
        type = Type;
    }
    
    
  //getters  
    public Integer getmediaID(){
        return mediaID;
    }

    public String getTitle(){
        return title;
    }
    
    public String getYear(){
        return year;
    }
    
    public double getCost(){
        return cost;
    }
    
    public String getType(){
        return type;
    }
    
    
    //add this media object to the database, abstract
    public abstract void add(); 
    
    //query media by ID, abstract 
    public abstract void querybyid();
   
    //calc total cost, abstract
    public abstract double calcCost(int mid);
           
      
    //override the toString method to print out a media object 
    @Override
    public String toString() 
    {
           String s = "Media Name:  " + title + "\n";
           s += " Media ID:  " + mediaID;
           s += " Year:  " + year;
           s += " Type:  " + type;
           s += " Cost:  " + cost;
           return s;
     }
}
