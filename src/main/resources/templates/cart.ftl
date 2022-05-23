<html>
<head>
</head>
<h1>Order#${order.order_id}</h1>

<h3>
    Your cart:
</h3>
<body>
<div id="container" style="white-space:nowrap; margin-top: auto; position: absolute; margin-left: 300px;">
    <br>
    <#list pr_links as link>
        <div id="image" style="display:inline;">
            <img src="images\default.jpg" height="300" width="300">
        </div>

        <div id="texts" style="display:inline; white-space: pre-line;"><#--break-spaces-->
            Product: ${link.name}
            Price: ${link.price * link.quantity}
            <#--todo send object to delete-->
            <form name="change quantity" method="post" action="/cart/changeQuantity">
                Quantity: <input  name="q" type="number" value="${link.quantity}">
                <button type="submit">Change quantity!</button>
                <input type="hidden" name="linkId" value="${link.pql_id}">
            </form>

            <form action="/cart/removeItem" method="post" name="delete">
                <input name="linkId" type="hidden" value="${link.pql_id}">
                <button type="submit" name="delete">Delete from cart!</button>
            </form>

        </div>
    </#list>

    <br>

    <form action="/cart/buy" name="buyProds" method="post">
        <input type="hidden" name="client_id" value="${order.client_id}">
        <button name="user_id" type="submit" >Click here to purchase products in the cart!</button>
    </form>


</div>
</body>
</html>