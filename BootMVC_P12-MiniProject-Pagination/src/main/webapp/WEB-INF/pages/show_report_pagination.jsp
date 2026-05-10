<%@ page isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>



<h1 style="color: red; text-align: center">Report Page By
	Pagination Page No:: ${pageData.getNumber()+1} /
	${pageData.getTotalPages()}</h1>

<c:choose>
	<c:when test="${!empty pageData}">

		<table border="1" bgcolor="yellow" align="center">
			<tr bgcolor="cyan">
				<th>ActorId</th>
				<th>ActorName</th>
				<th>Address</th>
				<th>Category</th>
				<th>Fee</th>
				<th>Operations</th>
			</tr>
			<c:forEach var="vo" items="${pageData.getContent()}">
				<tr>
					<td>${vo.id}</td>
					<td>${vo.name}</td>
					<td>${vo.address}</td>
					<td>${vo.category}</td>
					<td>${vo.fee}</td>
					<td><a href="edit?no=${vo.id}"><img src="images/edit.jpg"
							width="30" height="30"> &nbsp; &nbsp;&nbsp;&nbsp;
							 <a href="remove?no=${vo.id}"
							onclick="return confirm('Do u want to delete ?')"><img
								src="images/delete.jpg" width="30" height="30"> </a></td>
				</tr>
			</c:forEach>
		</table>
		<center>
			<c:if test="${!pageData.isFirst()}">
				<a href="page_report?page=0">First</a>
			</c:if>
			&nbsp;&nbsp;
			<c:if test="${pageData.hasNext()}">
				<a href="page_report?page=${pageData.getNumber()+1}">next</a>
			</c:if>
			&nbsp;&nbsp;
			<c:forEach var="i" begin="0" end="${pageData.getTotalPages()-1}">
            [<a href="page_report?page=${i}">${i+1}</a>] &nbsp;&nbsp;&nbsp;
        </c:forEach>
			&nbsp;&nbsp;

			<c:if test="${pageData.hasPrevious()}">
				<a href="page_report?page=${pageData.getNumber()-1}">Previous</a>
			</c:if>
			&nbsp;&nbsp;
			<c:if test="${!pageData.isLast()}">
				<a href="page_report?page=${pageData.getTotalPages()-1}">Last</a>
			</c:if>

		</center>

	</c:when>
	<c:otherwise>
		<h1 style="color: red; text-align: center">Records not found</h1>
	</c:otherwise>
</c:choose>
<br>
<h1 style="color: green; text-align: center; text-decoration: blink">
	${resultMsg}</h1>
<br>
<br>
<h1 style="text-align: center">
	<a href="register"><img src="images/add.jpg" width="40" height="60" />
		Add Actor</a>
</h1>

<br>
<br>

<h1 style="text-align: center">
	<a href="./"><img src="images/home.jpg"></a>
</h1>
