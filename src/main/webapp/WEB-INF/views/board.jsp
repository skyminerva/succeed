<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head> 
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>게시판리스트</title>

<style>
table {
	width: 80%;
	border: 1px solid #444444;
	border-collapse: collapse;
}
th {
	border: 1px solid #444444;
	background-color: #eee;
}
td {
	border: 1px solid #444444;
	padding: 10px;
}
</style>

</head>
<body>  
	<div style="text-align:center">
		<h1>내맘대로 게시판</h1>
		<br/><br/><br/>
		
		<table align="center">
		<div style="text-align:right; width: 89.5%;">
			<input type="button" value="게시물 등록" onclick="location.href='/writeView'">
			<br/><br/>
		</div>
		<thead>
			<tr>
				<th >ID</th>
				<th>작성자</th>
				<th>제목</th>
				<th>등록일</th>

			</tr>
			</thead>
			<!-- 게시글 리스트 -->
			<c:forEach var="board" items="${board}">
				<tr >
					<td width="10%">${board.id}</td>
					<td width="30%"><a href="/selectBoard/${board.id}">${board.name}</a></td>
					<td width="10%">${board.title}</td>
					<td width="15%"><fmt:formatDate pattern="yyyy-MM-dd" value="${board.regdate}" /></td>

				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>