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
    Handlebars.registerHelper('eachtable', function (context, options) {
        var ret = "";
        var cont = 0;
        debugger;
        for (var i = 0, j = context.length; i < j; i++) {
            if (cont <= 2) {
                ret+=options.fn(context[i]);
            }else{
                ret+='<tr>'+options.fn(context[i])+'</tr>';
                cont=0;
            }
            cont++;
        }

        return ret;
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
    var categorias = '';
    var jqxhr = $.getJSON("/shop/public/categorias/findAll.do");
    jqxhr.complete(function (data) {
        var postulantsList = Handlebars.getTemplate('menuCategorias');
        $('#' + id).html(postulantsList(data));
    });
}
function chargeProd(id) {
    var categorias = '';
    var jqxhr = $.getJSON("/shop/public/productos/findAll.do");
    jqxhr.complete(function (data) {
        debugger;
        var postulantsList = Handlebars.getTemplate('galeriaProductos');
        $('#' + id).html(postulantsList(data));
    });
}
$(document).ready(function () {
    chargeCatMenu('menuCat');
    chargeProd('producLst');
});