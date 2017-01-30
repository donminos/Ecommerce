/* global usuario, contrasena */

$(document).ready(function () {
    var ln = x = window.navigator.language || navigator.browserLanguage;
    //alert(ln.split("-")[0]);
    jQuery.i18n.properties({
        name: 'Messages',
        path: 'message/',
        mode: 'both',
        language: ln.split("-")[0],
        checkAvailableLanguages: true,
        async: true,
        callback: function () {
            $('#usuario').html(usuario);
            $('#contrasena').html(contrasena);
        }
    });
});
$(window).load(function () {
    var param = {};
    chargeProd('.principal', 1, param);
    chargeProd('.popular', 4, param);
    chargeProd('.vendidos', 4, param);
});
function chargeProd(id, items, param) {
    $.ajax({
        type: "POST",
        url: "public/productos/findAll.do",
        // The key needs to match your method's input parameter (case-sensitive).
        data: JSON.stringify(param),
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        success: function (data) {
            var postulantsList = prodStruct(data.response.Productos);
            $(id).html(postulantsList);
            chargeCarrusel(id, items);
        },
        failure: function (errMsg) {
            alert(errMsg);
        }
    });
}
function prodStruct(data) {
    var model = '';
    data.forEach(function (inf) {
        model = '<li data-thumb="public/images/getimage?image='+inf.imagenesPath+'">' +
                '<a href="desc-prod.html?prod='+inf.idProducto+'"><img class="carPrincipalItem" src="public/images/getimage?image='+inf.imagenesPath+'" /></a>' +
                '</li>';
    });
    return model;
}
var chargeCarrusel = function (id, items) {
    $(id).lightSlider({
        item: items,
        loop: true,
        keyPress: true,
        slideMove: 1, easing: 'cubic-bezier(0.25, 0, 0.25, 1)',
        speed: 600,
        auto: true,
        responsive: [
            {
                breakpoint: 800,
                settings: {
                    item: 2,
                    slideMove: 1,
                    slideMargin: 6
                }
            },
            {
                breakpoint: 480,
                settings: {
                    item: 1,
                    slideMove: 1
                }
            }
        ]
    });
};