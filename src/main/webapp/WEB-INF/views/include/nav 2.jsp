<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<nav class="navbar navbar-light bg-light static-top" style="text-align:left;">
    <div class="container" style="width:150px;display:inline-block;margin:0;">
      <a class="navbar-brand" href="/bm"><i  style="color: palevioletred; padding-right: 5px;"class="fas fa-book"></i>�󵵼���</a>
    </div>
    <form>
	<%
	if((Boolean)session.getAttribute("isLogon")==null){
	%>
      <a class="btn btn-primary" href="login">�α���</a>
      <a class="btn btn-primary" href="join">ȸ������</a>
    <%
	}else{
    %>
    <% out.print(session.getAttribute("mid")); %> �� ȯ���մϴ�.
    <a class="btn btn-primary" href="myinfo">�� ����</a>
    <a class="btn btn-primary" href="logout">�α׾ƿ�</a>
    <%
	}
    %>
    </form>
  </nav>