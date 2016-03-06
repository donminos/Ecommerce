function validarEmail(email) {
    var expr = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
    if (!expr.test(email))
        return false;
    else
        return true;
}

function validarRFC(rfc) {
    var expr = /^(([A-Z]|[a-z]|\s){1})(([A-Z]|[a-z]){3})([0-9]{6})((([A-Z]|[a-z]|[0-9]){3}))/;
    if (!expr.test(rfc))
        return false;
    else
        return true;
}
function validateForm() {
    $('.required').each(function () {
        if (this.value === '') {
            this.classList.add('error');
        } else {
            this.classList.remove('error');
        }
    });
    $('.email').each(function () {
        if (!validarEmail(this.value)) {
            this.classList.add('error');
        } else {
            this.classList.remove('error');
        }
    });
    $('.numerico').each(function () {
        if (isNaN(this.value) || this.value === '') {
            this.classList.add('error');
        } else {
            this.classList.remove('error');
        }
    });
    $('.rfc').each(function () {
        this.value=this.value.toUpperCase();
        if (!validarRFC(this.value)) {
            this.classList.add('error');
        } else {
            this.classList.remove('error');
        }
    });
}
$('#cp').blur(function () {
    $.ajax({
        type: "GET",
        url: '/codigos/public/consulta/buscarcp.do',
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        data: {cp: $('#cp').prop('value')},
        success: function (data) {
            $('#estado').prop('value', data[0].idEstado.nombre);
            $('#ciudad').prop('value', data[0].ciudad);
            $('#del').prop('value', data[0].idMunicipio.nombre);
            if (data.length > 1) {
                var constt = '<select id="colonia">';
                for (var i = 0; i < data.length; i++) {
                    constt += '<option value="' + data[i].asentamiento + '">' + data[i].asentamiento + '</option>';
                }
                constt += '</select>';
                $('#more').html(constt);
            } else {
                $('#more').html('<input id="colonia" type="text" value="' + data[0].asentamiento + '" class="required" placeholder="Colonia">');
            }
        },
        failure: function (errMsg) {
            alert(errMsg);
        }
    });
});
$('#send').click(function () {
    var validado=true;
    validateForm();
    if($('.error').length<=1){
        alert('todos aceptados');
        var param = {correo: $('#email').val(), name: $('#name').val()};
    }
});

