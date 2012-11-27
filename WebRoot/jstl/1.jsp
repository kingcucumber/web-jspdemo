<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>cout标签</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  <br>---------------------------------c:out ----------------</br>
    <c:out value="aaaaaaaaaa"></c:out>
    
    <c:out value="<a href=''>点点</a>" escapeXml="true" ></c:out>
    <br>------------------------------c:set ------------------</br>
    <c:set var="data" value="xxxxx" scope="page" ></c:set>
    ${data }
    <%
    		Map map = new HashMap();
    		request.setAttribute("map",map);
     %>
    <c:set property = "dd" value="yyyyy" target="${map }"/>
    ${map }
  <br>------------------------------c:catch ------------------</br>  
    <c:catch var="myex"  >
    <%
    		int x = 1/0;
     %>
     </c:catch>
     ${myex.message }
     
     <br>------------------------------c:if ------------------</br>
     <c:if var="aaa" test="${user==null}" scope="page">
     aaaaaa
     </c:if>
     ${aaa }
     
     <br>------------------------------c:foreach ------------------</br>
     
     <%
     		List list1 = new ArrayList();
     		list1.add("aaaa");
     		list1.add("bbbb");
     		list1.add("ccccc");
     		list1.add("dddd");
     		request.setAttribute("list",list1);
      %>
      <c:forEach var="str" items="${list1 }">
      ${str }
      </c:forEach>
      
      <br/>
      <c:forEach var="num" begin="1" end="9" step="1">
      ${num }
      </c:forEach>
      <br>------------------------------c:foreach 表格阶色 ------------------</br>
      <%
     		List list = new ArrayList();
     		list.add("aaaa");
     		list.add("bbbb");
     		list.add("ccccc");
     		list.add("dddd");
     		list.add("eeeee");
     		list.add("fffff");
     		list.add("gggggg");
     		list.add("iiiiiii");
     		list.add("hhhhhh");
     		
     		request.setAttribute("list",list);
      %>
      <style>
      	.odd{background-color: #FF99FF;}
      	.even{background-color: #FF6688;}
      	tr:HOVER {
      		background-color: #0000FF;}
      	}
      </style>
      <table border="1" width="20%">
      		<c:forEach var="str" items = "${list }" varStatus="status">
      			<tr class="${status.count%2==0? 'even':'odd'}">
      				<td>${str }</td>
      			</tr>
      		</c:forEach>
      </table>
      
      <br>--------------------------------c:url ----------------<br/>
      <c:url var="index" value="index.jsp"/>
      
      <a href ='${index }'>购买</a>
      
      <br>--------------------------------c:forTokens ----------------<br/>
      
      <%
      	request.setAttribute("da","aa,bbb,ccc,dddd");
       %>
       <c:forTokens var="ss" items="${da}" delims=",">
       	${ss }
       </c:forTokens>
  </body>
</html>
