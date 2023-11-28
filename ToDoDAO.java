import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import bean.ToDoBean;
import bean.ToDoDTO;

public class ToDoDAO {
  private final String URL = "jdbc:mysql://localhost/sampledb";
  private final String USER = "root";
  private final String PASS = "zxcv7890";
  private Connection con = null;

  public void connect(){
    try{
      //①DBに接続
      con = DriverManager.getConnection(URL, USER, PASS);
    } catch(Exception e){
      e.printStackTrace();
    }
  }
  
  public ToDoDTO select() {
    Statement stmt = null;
    ResultSet rs = null;
    ToDoDTO tdto = new ToDoDTO();
    String sql = "SELECT * FROM todo";
    try{
      connect();
      //②ステートメントを生成
      stmt = con.createStatement();
      //③SQLを実行
      rs = stmt.executeQuery(sql);
      //④検索結果の処理
      while(rs.next()){
        ToDoBean sb = new ToDoBean();
        sb.setNo(rs.getInt("No"));
        sb.setAction(rs.getString("action"));
        sb.setPlace(rs.getString("place"));
        tdto.add(sb);
      }
    } catch(Exception e){
      e.printStackTrace();
    } finally {
      try{
        if(rs != null) rs.close();
        if(stmt != null) stmt.close();
      } catch(Exception e){
        e.printStackTrace();
      }
    }
    disconnect();
    return tdto;
  }
  
  public int insert(int No, String action, String place) {
    String sql = "INSERT INTO todo VALUES ("
                   + No + ", '" + action + "', '" + place + "')";
    return executeSql(sql);
  }
  
  public int update(int No, String action, String place) {
    String sql = "UPDATE todo SET No = " + No + ", Action = '" + action
                   + "', Place = '" + place + "' WHERE No = " + No;
    return executeSql(sql);
  }
  
  public int delete(int No) {
    String sql = "DELETE FROM todo WHERE No = " + No;
    return executeSql(sql);
  }
  
  public int executeSql(String sql) {
    Statement stmt = null;
    ResultSet rs = null;
    int result = 0;
    try{
      connect();
      //②ステートメントを生成
      stmt = con.createStatement();
      //③SQLを実行
      result = stmt.executeUpdate(sql);
    } catch(Exception e){
      e.printStackTrace();
    } finally {
      try{
        if(rs != null) rs.close();
        if(stmt != null) stmt.close();
      } catch(Exception e){
        e.printStackTrace();
      }
    }
    disconnect();
    return result;
  }
  public void disconnect(){
	    try{
	      //⑤DBを切断
	      if(con != null) con.close();
	    } catch(Exception e){
	      e.printStackTrace();
	    }
	  }
	}
