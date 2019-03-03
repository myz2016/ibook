<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%--启用EL表达式--%>
<%@page isELIgnored="false" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<head>
    <title>User show</title>
</head>
<body>
    <s:if test="#age < 10">
    年龄小于10
</s:if>
<s:elseif test="#age > 10 && #age < 20">
    未成年
</s:elseif>
<s:else>
    已经成年
</s:else>
<br>
<table border="1">
    <thead>
    当使用了s:iterator标签之后，会将相应的迭代对象放置到CompoundRoot中，一次循环执行完毕，被迭代的对象就会
    从CompoundRoot栈顶移除，当进入下一次循环时，被迭代的对象又会别放置在CompoundRoot的栈顶
    </thead>
    <tr>
        <td>
            姓名
        </td>
        <td>
            年龄
        </td>
    </tr>
    <s:iterator value="#users">
        <tr>
            <td>
                    <%--由于被迭代的对象放置到了栈顶，所以取name值时，就不需要加#，因为从根取值是不用加#的。--%>
                <s:property value="name"/>
            </td>
            <td>
                <s:property value="age"/>
            </td>
        </tr>
    </s:iterator>
</table>
<h4>
    当定义了var="user"之后，会将这个迭代对象又在ActionContext中存一份，ActionContext中的key就是user。所以在取值的时候，就可以使用#了，因为从map中取值要使用#嘛。
    现在已经存了两份了，一份在ActionContext中，一份在CompoundRoot中，每一次循环结束，ActionContext中的被迭代的值会被清空。
</h4>
<s:iterator value="#users" var="user">
    <s:property value="#user.name"/>
    <%--由于CompoundRoot中也有一份被迭代的对象，所以这里可以直接取值，不需要加#--%>
    <s:property value="age"/>
    <br>
</s:iterator>
<br>
<h4>上面的循环都结束了，被迭代的对象都出栈了，现在栈顶又恢复成了UserAction对象，所以下面取name,age,id时，又是取的UserAction的name,age,id</h4>
<s:property value="name"/>
<s:property value="age"/>
<s:property value="id"/>
<br>
<%--s:iterator标签的status属性对应的java类是IteratorStatus--%>
<s:iterator value="#users" var="user" status="st">
    <s:property value="#st.odd"/> -------- <s:property value="#st.index"/> ------ <s:property value="#st.count"/> ------
    <s:property value="#st.last"/>
    <br>
</s:iterator>
<br>
<h4>在循环中获取CompoundRoot中的UserAction的成员变量name的值,由于在循环的时候，栈顶会有被迭代的对象，所以要获取成员变量name的值，只能手动找栈顶的下一个元素，也就是root[1]</h4>
<s:iterator value="#users" var="user">
    <s:property value="#user.name"/> ---- <s:property value="#root[1].name"/>
    <br>
</s:iterator>
<h4>综合练习</h4>
<s:iterator value="#users" status="st">
    <s:if test="#st.odd">
        <div style="background-color: aqua; width: max-content">
            <s:property value="name"/> ----- <s:property value="age"/>
        </div>
    </s:if>
    <s:else>
        <div style="background-color: beige; width: max-content">
            <s:property value="name"/> ----- <s:property value="age"/>
        </div>
    </s:else>
</s:iterator>
    <br>
<h4>s:select标签</h4>
<s:select list="years"></s:select>
</body>
</html>
