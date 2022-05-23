<!DOCTYPE html>
<html lang="en">
<head>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script>$(document).on('click', 'button', function () {
            var prod_id = $(this).attr("id");
            var quant = document.getElementById("q" + prod_id).value;
            var url = "/cart/addProduct";
            console.log(prod_id, quant)
            $.ajax(
                {
                    url: '/cart/addProduct',
                    method: 'post',
                    data : {
                        id : prod_id,
                        q: quant
                    },
                    success (response){
                        alert(response)
                    }
                }
            )
            return false;
        });
    </script>
    <meta charset="UTF-8">
    <title>Catalog</title>
    <style>
        .product {

        }

        .borderClass {
            border-width: 3px;
            border-color: black;
        }
    </style>
    <script>

    </script>
</head>
<body>
<div id="container" style="white-space:nowrap; margin-top: auto; position: absolute; margin-left: 300px;">
    <h2>Products of type: ${type}</h2>

    <#list products as product>
        <div id="image" style="display:inline;">
            <img src="images\default.jpg" height="300" width="300">
        </div>

        <div id="texts" style="display:inline; white-space: break-spaces;">
            ${product.name}
            ${product.price}
            <input id="q${product.id}" name="q" type="number" placeholder="quantity">
            <button id="${product.id}" class="product">to the cart!</button>

        </div>
    </#list>


</div>


</body>
</html>