<%-- Context :
<%=request.getContextPath()%>
<BR> 
URL :
<%=request.getRequestURL()%>
<BR>
URI :
<%=request.getRequestURI()%>
<BR>
<!--    ex) http://localhost:8080/board/list.jsp
        return => /board/list.jsp ( 프로젝트 context path와 파일 경로까지 가져온다 ) -->
Path :
<%=request.getServletPath()%>
<BR>
getQueryString :
<%=request.getQueryString()%><BR>
getParameterMap :
<%=request.getParameterMap()%><BR>
javax.servlet.include.request_uri :
<%=request.getAttribute("javax.servlet.include.request_uri")%><BR>--%>