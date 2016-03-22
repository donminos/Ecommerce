$(document).ready(function () {
    $('#pago').click(function () {
        $.ajax({
            type: "POST",
            url: "/shop/public/compras/verCarro.do",
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            success: function (data) {
                var arrayParam=new Array();
                data.forEach(function(index){
                debugger;
                    var param={};
                    param.idproducto=index.producto.idProducto;
                    param.cantidad=index.cantidad;
                    arrayParam.push(param);
                });
                $.ajax({
                    type: "POST",
                    url: "/shop/private/pedidos/create.do",
                    contentType: "application/json; charset=utf-8",
                    dataType: "json",
                    data: JSON.stringify(arrayParam),
                    success: function (data) {
                        debugger;
                    },
                    failure: function (errMsg) {
                        alert(errMsg);
                    }
                });
            },
            failure: function (errMsg) {
                alert(errMsg);
            }
        });
    });
});
$(window).load(function () {
    $.ajax({
        type: "POST",
        url: "/shop/public/compras/verCarro.do",
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        success: function (data) {

            var suma = 0;
            var cont = '<ul>';
            for (var i = 0; i < data.length; i++) {
                cont += '<li>Nombre:' + data[i].producto.nombre + '</li>';
                cont += '<li>Costo:$' + data[i].producto.costo + '</li>';
                cont += '<li>Cantidad' + data[i].cantidad + '</li>';
                suma = suma + data[i].producto.costo * data[i].cantidad;
                cont += '<li>Total:$' + data[i].producto.costo * data[i].cantidad + '</li>';
            }
            cont += '<li>Total final:$' + suma + '</li>';
            cont += '</ul>';
            $('article.desglose').html(cont);
            $('.cost').val(suma);
            $('#pago').show();
        },
        failure: function (errMsg) {
            alert(errMsg);
        }
    });
});
