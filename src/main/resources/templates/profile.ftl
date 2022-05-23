<html>
<head>
    <title>Profile</title>
    <meta charset="UTF-8">
</head>
<body>
<h1>Profile Page:<br></h1>
<img <#--src="/files/download/${user.profilePicture.id}"--> alt="profilePhoto" width="480" height="480">
<#--<p style="font-size: medium">User: ${userName}</p><br>-->
<br>
<br>
<form method="post" action="/files/upload" enctype="multipart/form-data">

    <input type="file" name="files" multiple>
    <input type="submit">
</form>
<label for="view">View files:<br> </label>
<form method="get" action="/files/view" >
    <input type="submit" id="view">
</form>
First name: <input value="${user.firstName}" type="text"><br>
Last name: <input value="${user.lastName}" type="text"><br>
Email: <input value="${user.email}" type="text"><br>
</body>

<br>
<form action="/cart" method="get">
<button type="submit">Go to cart!</button>
</form>
<form action="/categories" method = "get">
    <button type="submit">Go to shop!</button>
</form>
<form action="/search_products" method="get">
    <button type="submit">Search for products!</button>
</form>
</body>
</html>