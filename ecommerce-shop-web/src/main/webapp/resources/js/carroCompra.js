$(window).load(function () {
    $.ajax({
        type: "POST",
        url: "/shop/public/compras/verCarro.do",
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        success: function (data) {
            var suma=0;
            var cont='<ul>';
            for(var i=0;i<data.length;i++){
            cont+='<li>Nombre:'+data[i].producto.nombre+'</li>';
            cont+='<li>Costo:$'+data[i].producto.costo+'</li>';
            cont+='<li>Cantidad'+data[i].cantidad+'</li>';
            suma=suma+data[i].producto.costo*data[i].cantidad;
            cont+='<li>Total:$'+data[i].producto.costo*data[i].cantidad+'</li>';
        }
            cont+='<li>Total final:$'+suma+'</li>';
            cont+='</ul>';
            $('article.desglose').html(cont);
            $('.cost').val(suma);
        },
        failure: function (errMsg) {
            alert(errMsg);
        }
    });
});