Handlebars.getTemplate = function (name) {
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
$(document).ready(function () {
    chargeCatMenu('menuCat');
});