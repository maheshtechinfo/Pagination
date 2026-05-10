<%@ page isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="frm"%>
<h1 style="color: red; text-align: center">Actor Edit Page</h1>

<frm:form modelAttribute="actor">
	<table bgcolor="cyan" align="center">
		<tr>
			<th>Actor Id::</th>
			<th><frm:input type="text" path="id" readonly="true" /></th>
		</tr>
		<tr>
			<th>Actor Name::</th>
			<th><frm:input type="text" path="name" /></th>
		</tr>
		<tr>
			<th>Actor Address::</th>
			<th><frm:input type="text" path="address" /></th>
		</tr>
		<tr>
			<th>Actor Catetory::</th>
			<th><frm:input type="text" path="category" /></th>
		</tr>
		<tr>
			<th>Actor Fee::</th>
			<th><frm:input type="text" path="fee" /></th>
		</tr>
		<tr>
			<th><input type="submit" value="Edit Actor"></th>
			<th><input type="reset" value="cancel"></th>
		</tr>
	</table>

</frm:form>