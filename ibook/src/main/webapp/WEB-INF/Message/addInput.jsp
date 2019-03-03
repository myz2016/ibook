<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/5/3
  Time: 21:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
Message AddInput
<s:debug/>
<form action="Message_add" method="post">
    ID:<input type="text" name="id"><br>
    Title:<input type="text" name="title"><br>
    Content:<input type="text" name="content"><br>
    <input type="submit" value="提交"/>
</form>
</body>
</html>
