<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
	<title>게시판 셀렉트</title>
</head>
<body>
	<form action="/selectBoard" id="form">
		<input type="text" name="id" value="${board.id}" readonly="readonly">
		<input type="text" name="id" value="${board.name}" readonly="readonly">
		<input type="text" name="title" value="${board.title}" readonly="readonly">
		<textarea name = "content" id="" rows="10" cols="30" readonly="readonly">${board.content}</textarea>
		<button type="button" id="writeBtn" class="btn">등록</button>
		<button type="button" id="deleteBtn" class="btn">삭제</button>
	
	
	</form>
</body>
</html>