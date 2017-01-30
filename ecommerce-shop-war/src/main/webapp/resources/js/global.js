$(document).ready(function () {
    $('#submenu-navegacion').load("menu.jsp", function (response, status, xhr) {

    });
});
function createCall(idForm, callback) {
    var param = {}, header;
    var objetos = $('#' + idForm).find('input[type=text],input[type=checkbox],input[type=password],input[type=hidden]');
    objetos.map(function (obj, input) {
        debugger;
        if ($(input)[0].attributes.subobject != undefined) {
            if (param [$(input)[0].attributes.subobject.value] == undefined) {
                param [$(input)[0].attributes.subobject.value] = {};
            }
            if ($(input).context.type == 'checkbox') {
                param [$(input)[0].attributes.subobject.value][$(input).context.name] = $(input)[0].checked;
            } else {
                param [$(input)[0].attributes.subobject.value][$(input).context.name] = $(input).val();
            }
        } else {
            if ($(input).context.type == 'checkbox') {
                param [$(input).context.name] = $(input)[0].checked;
                console.log($(input)[0].checked);
            } else if ($(input).context.type == 'hidden') {
                header = $(input).val();
                header = $("meta[name='_csrf']").attr("content");
                console.log($(input).val());
            } else {
                param [$(input).context.name] = $(input).val();
                console.log($(input).val());
            }
        }
    });
            debugger;
    callWebservices($('#' + idForm)[0].method, $('#' + idForm)[0].action, header, param, callback);
}
function callWebservices(method, url, header, param, callback) {
    debugger;
    $.ajax({
        type: method, //POST,GET,PUT,ETC
        url: url,
        dataType: "json",
        context: this,
        headers: {
            'X-CSRF-TOKEN': header,
            'Content-Type': "application/json;charset=UTF-8"

        },
        data: param != {} ? JSON.stringify(param) : '',
        success: function (data) {
            callback(data);
        }
    });
}