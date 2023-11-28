package bean;

import java.io.Serializable;
import java.util.ArrayList;

public class ToDoDTO implements Serializable{
  private ArrayList<ToDoBean> list;

  public ToDoDTO(){
    list = new ArrayList<ToDoBean>();
  }
  public void add(ToDoBean sb){
    list.add(sb);
  }
  public ToDoBean get(int i){
    return list.get(i);
  }
  public int size(){
    return list.size();
  }
}

