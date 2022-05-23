<html>
<head>
   <#-- <script>
        function loadPage(type) {
            var url = "/catalog?t="+type
            var xmlHttp = new XMLHttpRequest();
            xmlHttp.open("GET", url, false); // false for synchronous request
            xmlHttp.send(null);
            return xmlHttp.responseText;
        }
    </script>-->
</head>
<body>
<div id="container" style="white-space:nowrap; margin-top: auto; position: absolute; margin-left: 300px;">

    <#list types as type>

        <div id="${type.type_id}" style="border: 2px solid;"
             onclick=window.location.href="/catalog?type_id=${type.type_id}">
        ${type.name}
        </div><br>
    </#list>


</div>
</body>
</html>