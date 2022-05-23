<html>
<head>
    <style>
        .product{

        }
    </style>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js">

    </script>
    <meta charset="UTF-8">
    <title>Catalog</title>

    <script>
        $(document).click(
            $(".product").click(function (){
                var prod_id = this.getAttribute('id');
                var quant = document.getElementById('q'+prod_id);
                var url = "/cart";
                $.post(url, {id: prod_id, q: quant}, alert("ok"));
            })
        );
    </script>


</head>
<p>

            product.name
            product.price
            <input id="q1" name="q" type="number">
            <button id="1" class="product">to the cart!</button>

</p>
</html>