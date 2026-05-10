<%@ page isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>

<h1 style="color:red;text-align:center">Report Page</h1>

<c:choose>
  <c:when test="${!empty listVO}">
    <table border="1" bgcolor="yellow" align="center"> 
      <tr bgcolor="cyan">
        <th>ActorId</th>
        <th>actorName</th>
        <th>Address</th>
        <th>Category</th>
        <th>Fee</th>
        <th>Operations</th>
      </tr>
      <c:forEach var="vo" items="${listVO}">
        <tr>
          <td>${vo.id}</td>
          <td>${vo.name}</td>
          <td>${vo.address}</td>
          <td>${vo.category}</td>
          <td>${vo.fee}</td>
          <td>
            <a href="edit?no=${vo.id}"><img src="images/edit.jpg" width="30" height="30"></a>
            &nbsp; &nbsp;&nbsp;&nbsp;
            <a href="remove?no=${vo.id}" onclick="return confirm('Do u want to delete ?')">
              <img src="images/delete.jpg" width="30" height="30">
            </a>
          </td>
        </tr>
      </c:forEach>
    </table>
  </c:when>
  <c:otherwise>
    <h1 style="color:red;text-align:center">Records not found</h1>
  </c:otherwise>
</c:choose>

<br>
<h1 style="color:green;text-align:center;text-decoration:blink">${resultMsg}</h1> 

<h1 style="text-align:center">
  <a href="register"><img src="images/add.jpg" width="40" height="60"/> Add Actor</a>
</h1>

<h1 style="text-align:center">
  <a href="./"><img src="images/home.jpg" width="50" height="60"/> Back To Home</a>
</h1>
