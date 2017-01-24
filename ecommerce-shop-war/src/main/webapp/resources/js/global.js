function chargeLibs() {
    var cssId = 'jquery.fancybox';  // you could encode the css path itself to generate id..
    if (!document.getElementById(cssId)) {
        var head = document.getElementsByTagName('head')[0];
        var link = document.createElement('link');
        link.id = cssId;
        link.rel = 'stylesheet';
        link.type = 'text/css';
        link.href = 'resources/css/jquery.fancybox.css';
        link.media = 'all';
        head.appendChild(link);
    }
    cssId = 'puzzleCAPTCHA';  // you could encode the css path itself to generate id..
    if (!document.getElementById(cssId)) {
        var head = document.getElementsByTagName('head')[0];
        var link = document.createElement('link');
        link.id = cssId;
        link.rel = 'stylesheet';
        link.type = 'text/css';
        link.href = 'resources/css/puzzleCAPTCHA.css';
        link.media = 'all';
        head.appendChild(link);
    }
    $.getScript("resources/js/libs/puzzleCAPTCHA.js");
    $.getScript("resources/js/libs/jquery.fancybox.js", function () {
        if (getParameter('errorLogin')) {
            $.fancybox('El usuario y contraseña introducidos son incorrectos');
        }else if (getParameter('activate')==='true') {
            $.fancybox('Se ha activado tu usuario');
        }else if (getParameter('activate')==='false'){
            $.fancybox('Hubo un problema al activar tu usario porfavor contactate con el administrador del sistema');
        }
    });
    $('#login-bt').click(function () {
        $.get('/shop/j_security_check?j_username=' + $('#user').val() + '&j_password=' + $('#pass').val(), function () {
            $.post('/shop/public/user/login.do', function (data) {
                if (data.response.success) {
                    window.location.href = 'index.html';
                } else {
                    window.location.href = 'index.html?errorLogin=true';
                }
            });
        });

    });

    $('#pass').keydown(function (e) {
        if (e.keyCode == 13) {
            $.get('/j_security_check?j_username=' + $('#user').val() + '&j_password=' + $('#pass').val(), function () {
                $.post('/shop/public/user/login.do', function (data) {
                    window.location.href = data;
                });
            });
        }
    });
    $('.login').click(function () {
        $.fancybox($('#login'));
        $("#PuzzleCaptcha").html('');
        $("#PuzzleCaptcha").PuzzleCAPTCHA({
            //width: "250px",
            rows: 3,
            targetInput: '.validationValue',
            targetVal: 'Validated!!',
            targetButton: '.btnSubmit'
        });
    });
}
function getParameter(sParam) {
    var sPageURL = window.location.search.substring(1);
    var sURLVariables = sPageURL.split('&');
    for (var i = 0; i < sURLVariables.length; i++) {
        var sParameterName = sURLVariables[i].split('=');
        if (sParameterName[0] === sParam) {
            return sParameterName[1];
        }
    }
}
var chargeMenu = function () {
    var touch = $('#touch-menu');
    var menu = $('.menu');

    $(touch).on('click', function (e) {
        e.preventDefault();
        menu.slideToggle();
    });

    $(window).resize(function () {
        var w = $(window).width();
        if (w > 767 && menu.is(':hidden')) {
            menu.removeAttr('style');
        }
    });
};
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
            url: '/resources/js/templates/' + name + '.handlebars',
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

function chargeCatMenu() {
    var jqxhr = $.getJSON("public/categorias/findAll.do");
    jqxhr.complete(function (data) {
        var constr = '';
        for (var i = 0; i < data.responseJSON.length; i++) {
            constr += '<li class="categoria"><a id="cat_' + data.responseJSON[i].idCategoria + '" href="galeria.html?cat=' + data.responseJSON[i].idCategoria + '">' + data.responseJSON[i].nombre + '</a>'
                    + '<ul class="sub-menu">';
            for (var j = 0; j < data.responseJSON[i].categoriasList1.length; j++) {
                constr += '<li><a id="cat_' + data.responseJSON[i].categoriasList1[j].idCategoria + '" href="galeria.html?cat=' + data.responseJSON[i].categoriasList1[j].idCategoria + '">' + data.responseJSON[i].categoriasList1[j].nombre + '</a>'
                        + '<ul>';
                for (var k = 0; k < data.responseJSON[i].categoriasList1[j].categoriasList1.length; k++) {
                    constr += '<li><a id="cat_' + data.responseJSON[i].categoriasList1[j].categoriasList1[k].idCategoria + '" href="galeria.html?cat=' + data.responseJSON[i].categoriasList1[j].categoriasList1[k].idCategoria + '">' + data.responseJSON[i].categoriasList1[j].categoriasList1[k].nombre + '</a></li>';
                }
                constr += '</ul></li>';
            }
            constr += '</ul></li>';
        }
        constr += '<li class="carro-compra"><a href="carroCompra.html">Carrito</a></li>';
        $('#menuCat').html(constr);
        chargeMenu();
    });
}
function sesion() {
    var jqxhr = $.getJSON("/private/user/name.do");
    jqxhr.success(function (data) {
        $('.panel-login').html('<div class="name-login">Bienvenido ' + data.response.Nombre + "</div>\n\
        <button class='boton' onclick=$.get('/shop/private/user/logout.do',function(){location.reload();});>salir</button>");
    });
    jqxhr.fail(function (data) {
        console.log('Error sesion no iniciada');
    });
}
function chargeProd(id, items, param) {
    $.ajax({
        type: "POST",
        url: "/public/productos/findAll.do",
        // The key needs to match your method's input parameter (case-sensitive).
        data: JSON.stringify(param),
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        success: function (data) {
            var info = {};
            info.data = data;
            var postulantsList = Handlebars.getTemplate('galeriaProductos_1');
            $(id).html(postulantsList(info));
            chargeCarrusel(id, items);
        },
        failure: function (errMsg) {
            alert(errMsg);
        }
    });
}
function initHeader() {
    chargeLibs();
    chargeCatMenu();
    sesion();
    $('#search').keydown(function (e) {
        if (e.keyCode == 13) {
            window.location.href = 'galeria.html?palabra=' + this.value;
        }
    });
}
$(document).ready(function () {
    $("header").load("resources/templates/header.html", function () {
        initHeader();
    });
    $("nav").load("resources/templates/menu.html");
    $("footer").load("resources/templates/footer.html");
});