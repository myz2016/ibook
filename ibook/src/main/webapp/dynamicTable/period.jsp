<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%--启用EL表达式--%>
<%@page isELIgnored="false" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="css/page.css">
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <style type="text/css">
        td.odd{
            filter:progid:DXImageTransform.Microsoft.AlphaImageLoader(src='../img/grid-head-background-small.jpg', sizingMethod='scale')
        }
    </style>
    <script type="text/javascript" src="js/json2.js"></script>
    <script type="text/javascript" src="js/jquery-1.7.1.min.js"></script>
    <script type="text/javascript" src="js/jquery-1.7.1.min.js"></script>
    <script type="text/javascript" src="js/common.js"></script>
    <script type="text/javascript">
        $(function () {
            $.ajax({
               url:"/dynamicTable.action",
               type:"POST",
               dataType:"json",
                success: function (result) {
                    console.log(result);
                    var depTab = $("#departmentTable");
                    for (var i = 0; i < result.length; i++) {
                        var row = result[i];
                        // console.log(row);
                        // console.log(row["cells"].length);
                        var tr = createTR();
                        for (var j = 0; j < row["cells"].length; j++) {
                            var cell = row["cells"][j];
                            console.log(cell);
                            var cellValue = cell["value"];
                            var cellRowSpan = cell["rowSpan"];
                            var colSpan = cell["colSpan"];
                            var td = createTDWithBorderDef(cellValue, "0%", cellRowSpan, colSpan);
                            td.appendTo(tr);
                        }
                        tr.appendTo(depTab);
                    }
               }
            });
        });
    </script>
</head>
<body>
<form id="report" method="post">
    <table width="100%" cellspacing="0" cellpadding="5" height=100% style="background-color:transparent;">
        <tr bgcolor="#A6C8EE">
            <td height="15">
                <input type="button" value="添加表格" onclick="CreateTable(5,6)">
                <input type="button" value="添加行" onclick="addRow()">
                <input type="button" value="自定义表格1" onclick="ct1();">
                <input type="button" value="自定义表格2" onclick="ct2();">
                <input type="button" value="插入行" onclick="ir();">
            </td>
        </tr>
        <tr bgcolor="#E0EFFC">
            <td hight="100">
                <div style="height: 100%;width: 100%">
                    <table width="100%" cellspacing="0" class="inputs" cellpadding="4">
                        <tr>
                            <td nowrap="nowrap" align="right" width="10%">
                                统计周期：
                            </td>
                            <td nowrap="nowrap" align="left">
                                下拉框
                            </td>
                        </tr>
                    </table>
                </div>
            </td>
        </tr>
        <tr bgcolor="#E0EFFC" height="100%">
            <td valign="top">
                <div style="width:100%; overflow-x:scroll; overflow-y:auto">
                    <table class="drag" border="1" id="departmentTable" width="100%" cellspacing="0" cellpadding="0">
                        <thead>
                        <tr>
                            <td class="odd" rowspan="2" colspan="2" nowrap="nowrap" align="center" width="4%">部门用印类型</td>
                            <td colspan="2" nowrap="nowrap" align="center" width="4%">业务合同章</td>
                            <td colspan="2" nowrap="nowrap" align="center" width="4%">法人人名章（业务用途）</td>
                            <td colspan="2" nowrap="nowrap" align="center" width="4%">法人人名章（财务用途）</td>
                            <td colspan="2" nowrap="nowrap" align="center" width="4%">集合信托合同专用章</td>
                            <td colspan="2" nowrap="nowrap" align="center" width="4%">总经理人名章</td>
                            <td colspan="2" nowrap="nowrap" align="center" width="4%">公司公章</td>
                            <td class="odd" rowspan="2" nowrap="nowrap" align="center" width="2%">部门</td>
                        </tr>
                        <tr>
                            <td>电子章</td>
                            <td>实体章</td>
                            <td>电子章</td>
                            <td>实体章</td>
                            <td>电子章</td>
                            <td>实体章</td>
                            <td>电子章</td>
                            <td>实体章</td>
                            <td>电子章</td>
                            <td>实体章</td>
                            <td>电子章</td>
                            <td>实体章</td>
                        </tr>
                        </thead>
                    </table>
                </div>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
