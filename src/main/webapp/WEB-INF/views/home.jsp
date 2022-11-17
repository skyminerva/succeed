<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server(util.date) is ${serverTime}. </P>
<P>  밑에는 마이바티스에서 가져온 시간 </P>
<P>  The time on the server(sql.date) is ${selectNow}. </P>

<a href="/board5/board"> 게시판 리스트 화면으로</a>


<h2> 셀렉트화면</h2>
	<form action="" id="form">
		<input type="text" name="id" value="${boardVo.id}" readonly="readonly">
		<input type="text" name="id" value="${boardVo.name}" readonly="readonly">
		<input type="text" name="title" value="${boardVo.title}" readonly="readonly">
		<textarea name = "content" id="" rows="10" cols="30" readonly="readonly">${boardVo.content}</textarea>
		<button type="button" id="writeBtn" class="btn">등록</button>
		<button type="button" id="deleteBtn" class="btn">삭제</button>
	
	
	</form>

</body>
</html>
