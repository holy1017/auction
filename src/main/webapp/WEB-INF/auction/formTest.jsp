<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<c:forEach items="${cart}" var="goods">
	Name : ${goods.name}, Price : ${goods.price}, Cnt : ${goods.cnt }  
	<br/>
</c:forEach>

<form method="post" action="add.ac">
	Name  : <input type="text" name="name"><br>
	Price : <input type="text" name="price"><br>
	Cnt   : <input type="text" name="cnt">	<br><br>
	<button>Add Goods...</button>
</form>