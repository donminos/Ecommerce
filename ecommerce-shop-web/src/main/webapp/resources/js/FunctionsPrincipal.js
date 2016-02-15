Handlebars.getTemplate = function (name) {
    Handlebars.registerHelper("math", function (lvalue, operator, rvalue, options) {
        lvalue = parseFloat(lvalue);
        rvalue = parseFloat(rvalue);

        return {
            "+": lvalue + rvalue,
            "-": lvalue - rvalue,
            "*": lvalue * rvalue,
            "/": lvalue / rvalue,
            "%": lvalue % rvalue
        }[operator];
    });
    Handlebars.registerHelper('addOne', function (value) {
        return value + 1;
    });
    if (Handlebars.templates === undefined || Handlebars.templates[ name ] === undefined) {
        $.ajax({
            url: '/shop/resources/js/templates/' + name + '.handlebars',
            success: function (data) {
                if (Handlebars.templates === undefined) {
                    Handlebars.templates = {};
                }
                Handlebars.templates[name] = Handlebars.compile(data);
            },
            async: false
        });
    }
    return Handlebars.templates[name];
}

function chargeCatMenu(id) {
    var jqxhr = $.getJSON("/shop/public/categorias/findAll.do");
    jqxhr.complete(function (data) {
        var constr = '';
        for (var i = 0; i < data.responseJSON.length; i++) {
            constr += '<li class="categoria"><a id="cat_' + data.responseJSON[i].idCategoria + '" href="#">' + data.responseJSON[i].nombre + '</a>'
                    + '<ul class="sub-menu">';
            for (var j = 0; j < data.responseJSON[i].categoriasList1.length; j++) {
                constr += '<li><a id="cat_' + data.responseJSON[i].categoriasList1[j].idCategoria + '" href="#">' + data.responseJSON[i].categoriasList1[j].nombre + '</a>'
                +'<ul>';
                for (var k = 0; k < data.responseJSON[i].categoriasList1[j].categoriasList1.length; k++) {
                    constr += '<li><a id="cat_' + data.responseJSON[i].categoriasList1[j].categoriasList1[k].idCategoria + '" href="#">' + data.responseJSON[i].categoriasList1[j].categoriasList1[k].nombre + '</a></li>';
                }
                constr += '</ul></li>';
            }
            constr += '</ul></li>';
        }
        $('#' + id).html(constr);
        /*var postulantsList = Handlebars.getTemplate('menuCategorias_1');
         $('#' + id).html(postulantsList(data));*/
    });
}
function chargeProd(id) {
    var categorias = '';
    var jqxhr = $.getJSON("/shop/public/productos/findAll.do");
    jqxhr.complete(function (data) {
        var postulantsList = Handlebars.getTemplate('galeriaProductos');
        $('#' + id).html(postulantsList(data));
    });
}
$(window).load(function () {
    chargeCatMenu('menuCat');
    //chargeProd('producLst');
    $("#content-slider").lightSlider({
        item: 1,
        loop: true,
        keyPress: true,
        slideMove: 1, easing: 'cubic-bezier(0.25, 0, 0.25, 1)',
        speed: 600,
        auto: true,
        responsive: [
            {
                breakpoint: 800,
                settings: {
                    item: 1,
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
    $(".content-slider-prod").lightSlider({
        item: 4,
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
});