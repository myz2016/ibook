<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%--启用EL表达式--%>
<%@page isELIgnored="false" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="js/json2.js"></script>
    <script type="text/javascript" src="js/jquery-1.7.1.min.js"></script>
    <script type="text/javascript">
        $(function () {
            $.ajax(
                {
                    url: "/Json_json.action",
                    type: "post",
                    dataType: "json",
                    success: function (result) {
                        var json = $.parseJSON(result); //{age: 20, dep: null, name: "json"}
                        console.log(json);
                        console.log(json.age);
                        console.log(json.name);

                        // var jsonObj = eval("(" + result + ")"); //{age: 20, dep: null, name: "json"}
                        // console.log(jsonObj);

                        // var parse = JSON.parse(result); //{age: 20, dep: null, name: "json"}
                        // console.log(parse);
                    }
                });
        });

        function btn_1() {
            $.ajax({
                url: "/Json_json1.action",
                type: "post",
                dataType: "json",
                success: function (result) {
                    console.log(result);
                    var parseJSON = $.parseJSON(result);
                    console.log(parseJSON);
                }
            });
        }

        function btn_2() {
            $.ajax({
                url: "/Json_json2.action",
                type: "post",
                dataType: "json",
                success: function (result) {
                    console.log(result);
                    var parseJSON = JSON.parse(result);
                    console.log(parseJSON);
                }
            });
        }

        function btn_3() {
            $.ajax({
                url: "/Json_json3.action",
                type: "post",
                dataType: "json",
                success: function (result) {
                   console.log(result);
                }
            });
        }

        function btn_4() {
            $.ajax({
                url: "/Json_json4.action",
                type: "post",
                dataType: "json",
                success: function (result) {
                    console.log(result);
                }
            });
        }

        function btn_5() {
            $.ajax({
                url: "/Json_json5.action",
                type: "post",
                dataType: "json",
                success: function (result) {
                    console.log($.parseJSON(result));
                }
            });
        }

        function btn_6() {
            $.ajax({
                url: "/Json_json6.action",
                type: "post",
                dataType: "json",
                success: function (result) {
                    // console.log(result);
                    var json = $.parseJSON(result);
                    for (var tmp in json) {
                        console.log(json[tmp]);
                    }
                }
            });
        }

        function btn_7() {
            $.ajax({
                url: "/Json_json7.action",
                type: "post",
                dataType: "json",
                success: function (result) {
                    console.log(result);
                }
            });
        }

        function btn_8() {
            $.ajax({
                url: "/Json_json8.action",
                type: "post",
                dataType: "json",
                success: function (result) {
                    console.log(result);
                }
            });
        }

        function btn_9() {
            $.ajax({
                url: "/Json_json9.action",
                type: "post",
                dataType: "json",
                success: function (result) {
                    console.log(result);
                    //将json对象转成字符串
                    /*var s = JSON.stringify(result);
                    console.log(s);*/
                }
            });
        }

    </script>
</head>
<body>
<input type="button" value="BTN_1" onclick="btn_1()"/>
<input type="button" value="BTN_2" onclick="btn_2()"/>
<input type="button" value="BTN_3" onclick="btn_3()"/>
<input type="button" value="BTN_4" onclick="btn_4()"/>
<input type="button" value="BTN_5" onclick="btn_5()"/>
<input type="button" value="BTN_6" onclick="btn_6()"/>
<input type="button" value="BTN_7" onclick="btn_7()"/>
<input type="button" value="BTN_8" onclick="btn_8()"/>
<input type="button" value="BTN_9" onclick="btn_9()"/>
</body>
</html>
