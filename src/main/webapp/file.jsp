<%--
  Created by IntelliJ IDEA.
  User: Jesusaichao
  Date: 18.10.22
  Time: 9:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>文件上传</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/file/fileUpLoad" method="post" enctype="multipart/form-data">
    文件名称:<input name="file" type="file"/><br>
    用户名称:<input name="username" type="text"/><br>
    <input type="submit" value="上传"/>
</form>
</body>
</html>
