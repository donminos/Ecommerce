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
    });
    chargeProd('.ligados',4);
});