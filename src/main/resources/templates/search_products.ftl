<html>
<head>
    <title>Search Products</title>
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
                        // alert(response)
                    }
                }
            )
            return false;
        });
    </script>
    <style>
        table {
            font-family: arial, sans-serif;
            border-collapse: collapse;
            width: 100%;
        }

        td, th {
            border: 1px solid #dddddd;
            text-align: center;
            padding: 8px;
        }
    </style>
</head>
<body>
<script>
    function searchUsers(prodName) {
        let request = new XMLHttpRequest();

        request.open('GET', '/search_products/searchByName?prodName=' + prodName, false);

        request.send();

        if (request.status !== 200) {
            alert('Ошибка!');
        } else {
            let html =
                '<tr>' +
                '<th>ID</th>' +
                '<th>Name</th>' +
                '<th>Price</th>' +
                '</tr>'

            let response = JSON.parse(request.response);

            for (let i = 0; i < response.length; i++) {
                html += '<tr>';
                html += '<td>' + response[i]['id'] + '</td>';
                html += '<td>' + response[i]['name'] + '</td>';
                html += '<td>' + response[i]['price'] + '</td>';
                html += '<td style="border: 0px solid;"><input id="q'+response[i]['id']+'" name="q" type="number" placeholder="quantity"></td>';
                html += '<td style="border: 0px solid;"><button id="'+response[i]['id']+'" class="product">to the cart!</button></td>';
                html += '</tr>';
            }


            document.getElementById('products_table').innerHTML = html;
        }
    }
</script>
<h1>Search page</h1>
<label>
    <input id="prodName" name="prodName" placeholder="Product name" onkeyup="searchUsers(document.getElementById('prodName').value)">
    <br>
    Search by ProductName
</label>
<br>
<table id="products_table">

</table>
</body>
</html>
