import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.ToDoDTO;

@WebServlet("/ToDoServlet")
public class ToDoServlet extends HttpServlet {
  public void doPost(HttpServletRequest req, HttpServletResponse res)
      throws IOException, ServletException {
    String msg = "やることリストを表示します";
    //入力値（btn）を取得
    req.setCharacterEncoding("utf-8");
    String btn = req.getParameter("btn");
    //StudentDAOオブジェクトを生成
    ToDoDAO tdao = new ToDoDAO();
    //押下ボタンによる分岐処理
    if(btn.equals("追加")){
      int No = Integer.parseInt(req.getParameter("No"));
      String action = req.getParameter("action");
      String place = req.getParameter("place");
      tdao.insert(No, action, place);
      msg = "番号" + No + "のやることを追加しました";
    } else if(btn.equals("修正")) {
      int No = Integer.parseInt(req.getParameter("No"));
      String action = req.getParameter("action");
      String place = req.getParameter("place");
      tdao.update(No, action, place);
      msg = "番号" + No + "のやることを修正しました";
    } else if(btn.equals("削除")) {
      int No = Integer.parseInt(req.getParameter("No"));
      tdao.delete(No);
      msg = "番号" + No + "のやることを削除しました";
    }
    //全件検索
    ToDoDTO tdto = tdao.select();
    //リクエストスコープにDTOとmsgを格納
    req.setAttribute("tdto", tdto);
    req.setAttribute("msg", msg);
    //JSPにフォワード
    RequestDispatcher rd = req.getRequestDispatcher("/todolist.jsp");
    rd.forward(req, res);
  }

  public void doGet(HttpServletRequest req, HttpServletResponse res)
      throws IOException, ServletException {
    doPost(req, res);
  }
}
