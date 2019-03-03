<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%--启用EL表达式--%>
<%@page isELIgnored="false" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<br>
<head>
    <title>Title</title>
</head>
<s:debug/>
<br>
<h1>User List</h1>
</br>
${ name } ---- ${age}
</br>
<s:property value="name"/> ---- <s:property value="age"/>
</br>
${password}
</br>
<h3>使用s:property来访问ActionContext中的数据需要加#,在struts2.3之后，如果ActionContext中的数据是String类型就不用加#,
    但是在今后的开发中,只要是获取ActionContext中的数据就一定加#访问，这样就不需要再单独记忆String的特殊性了</h3>
<s:property value="password"/>
<h3>如果不是String类型，就需要加#</h3>
<s:property value="#num"/>
<br>
<h3>通过EL表达式同样可以获取request中的值</h3>
${gender}
<h3>通过#request的方式获取值</h3>
<s:property value="#request.gender"/>
<h3>获取root中的UserAciton的name值</h3>
<s:property value="#root[1].name"/>
如果正常操作CompoundRoot的时候，也就是正常从栈顶取值时，是不需要加#的
但如果不想从栈顶取值，而是要取某一个特殊的值，这个值不是在栈顶，这时就
要使用#root[index]来取值。
</body>
</html>
