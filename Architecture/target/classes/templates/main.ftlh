<!DOCTYPE html>
<html lang="en" xmlns="http://www.w3.org/1999/html" xmlns="http://www.w3.org/1999/html">
<head>
    <meta charset="UTF-8">
    <title>Main</title>
</head>
<body>
<h1>HELLO</h1>
<form enctype="multipart/form-data" method="post">
    <input type="file" name="file"></br>
    <input type="submit" value="Загрузить">
</form>
</br>

<#if files??>
    <#list files as file>
        <a href="http://localhost/api/download/${file.getName()}">${file.getName()}</a></br>
    </#list>
</#if>
</body>
</html>