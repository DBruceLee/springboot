<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org"
      xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity3" xmlns="http://www.w3.org/1999/html">
<head>
    <title>showUser</title>
</head>
<body>
<center>
    <#switch method>
        <#case "save">
        新增用户成功</br>
            <#break>
        <#case "delete">
        删除用户成功</br>
            <#break>
        <#case "findUser">
        查找用户成功</br>
            <#if user??>
                ${user.id} - ${user.name} - ${user.age}</br>
            <#else>
                ${user!"没有id为"+id+"的用户"}
            </#if>
            <#break>
        <#case "findUsers">
        查找用户列表成功</br>
            <#if userList?? && (userList?size > 0)>
                ${"userList?size : " + userList?size} / ${"userList?size : ${userList?size}"}</br>
                <#list userList as user >
                    ${user.id} - ${user.name} - ${user.age}</br>
                </#list>
            <#else>
            <#--变量为空则给一个默认值-->
                ${userList!"用户列表为空"}
            </#if>
            <#break>
    </#switch>

</center>
</body>
</html>