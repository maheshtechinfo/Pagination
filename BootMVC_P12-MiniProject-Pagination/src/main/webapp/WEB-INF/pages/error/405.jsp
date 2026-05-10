<%@ page isELIgnored="false"%>


<h1  style="color:red;text-align:center"> 405.jsp (Error Code Page)</h1>

<h1 style="color:red;text-align:center"> The Error details are</h1>

<table  border="1"  align="center">
   <tr>
     <th> message </th>
     <th> ${message}  </th>
   </tr>
   
   <tr>
     <th> status </th>
     <th> ${status}  </th>
   </tr>
   
   <tr>
     <th> Path </th>
     <th> ${path}  </th>
   </tr>
   
   <tr>
     <th> timestamp </th>
     <th> ${timestamp}  </th>
   </tr>
   
   <tr>
     <th> trace </th>
     <th> ${trace}  </th>
   </tr>
  </table>