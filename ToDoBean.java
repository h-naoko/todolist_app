package bean;

import java.io.Serializable;

public class ToDoBean implements Serializable{
  private int No;
  private String action;
  private String place;
  
  public void setNo(int No){
    this.No = No;
  }
  public void setAction(String action){
    this.action = action;
  }
  public void setPlace(String place){
    this.place = place;
  }
  public int getNo(){
    return No;
  }
  public String getAction(){
    return action;
  }
  public String getPlace(){
    return place;
  }
}

