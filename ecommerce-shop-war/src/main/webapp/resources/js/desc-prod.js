zoomImage = function () {
    //initiate the plugin and pass the id of the div containing gallery images
    $("#img_01").elevateZoom({gallery: 'gal1', cursor: 'pointer', galleryActiveClass: 'active', imageCrossfade: true});

    //pass the images to Fancybox
    $("#img_01").bind("click", function (e) {
        var ez = $('#img_01').data('elevateZoom');
        $.fancybox(ez.getGalleryList());
        return false;
    });
};

$(window).load(function () {
    var idprod = getParameter('prod');
    $.getJSON('/shop/public/productos/findId.do>' + idprod).complete(function (data) {
        var list = Handlebars.getTemplate('productoGaleria');
        $('#producto').html(list(data));
        zoomImage();
        $('.descProd').html('<h3>' + data.responseJSON.nombre + '</h3><p>' + data.responseJSON.descripcion + '</p><p>' + data.responseJSON.detalle + '</p>');
        $('.precios').html('<p>$' + data.responseJSON.costo + '</p><p>Cantidad:<input id="cantidad" type="number" min="1" max="' + data.responseJSON.cantidad + '" placeholder=""/></p><p><input type="button" class="boton agregar" value="Agregar al carrito"/></p>');
        $('.agregar').click(function () {
            var param = {};
            param.idproducto = idprod;
            param.cantidad = $('#cantidad').val();
            $.ajax({
                type: "POST",
                url: "/shop/private/compras/agregarCarro.do",
                data: JSON.stringify(param),
                contentType: "application/json; charset=utf-8",
                dataType: "json",
                success: function (data) {
                    if (data.response.success) {
                        $.fancybox('<p>Se ha agregado al carro de compras</p>');
                    }else{
                        $.fancybox('<p>Debes colocar una cantidad</p>');
                    }
                }, error: function () {
                    $.fancybox('<p>No se puede agregar productos al carro de compra hasta que inicie sesión</p>');
                }
            });
        });
    });
    chargeProd('.ligados', 4, {});
});
