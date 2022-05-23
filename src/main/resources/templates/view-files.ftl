<html>
<head>
    <title>Files:</title>
</head>
<body>
<#list files as file>
    <a href="/files/download/${file.id}">${file.originalName}</a>
</#list>

</body>
</html>
