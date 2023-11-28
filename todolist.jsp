<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@page import="bean.*" %>
<jsp:useBean id ="tdto" scope="request" class="bean.ToDoDTO" />
<jsp:useBean id ="msg" scope="request" class="java.lang.String" />
<!DOCTYPE html>
<html>
  <head>
    <link href="todolist.css" rel="stylesheet" type="text/css" />
    <title>今日のやることリスト</title>
  </head>
<body>
<h2>◎　<%= msg %></h2>
<table border="3">
  <tr>
    <th width="50">番号</th>
    <th width="200">やること</th>
    <th width="200">どこで</th>
  </tr>
<%
  for(int i = 0; i < tdto.size(); i++){
    ToDoBean sb = tdto.get(i);
%>
  <tr>
    <td align="center"><%= sb.getNo() %></td>
    <td align="center"><span class = under><%= sb.getAction() %></span></td>
    <td align="center"><%= sb.getPlace() %></td>
  </tr>
<% } %>
</table><br />
<a href="/todolist/todolist.html"><strong>入力画面に戻る</strong></a>
</body>
</html>
