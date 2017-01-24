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
function validaNum(e) {
    tecla = (document.all) ? e.keyCode : e.which;
    //Tecla de retroceso para borrar, siempre la permite
    if (tecla === 8 || tecla === 0) {
        return true;
    }

// Patron de entrada, en este caso solo acepta numeros
    patron = /[0-9]/;
    tecla_final = String.fromCharCode(tecla);
    return patron.test(tecla_final);
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
    $('.rfc').each(function () {
        this.value = this.value.toUpperCase();
        if (!validarRFC(this.value)) {
            this.classList.add('error');
        } else {
            this.classList.remove('error');
        }
    });
    if ($('.secret')[0].value !== $('.secret')[1].value || $('.secret')[0].value.length < 8) {
        $('.secret').each(function () {
            this.classList.add('error');
        });
    } else {
        $('.secret').each(function () {
            this.classList.remove('error');
        });
    }
}
$('#cp').blur(function () {
    $.ajax({
        type: "GET",
        url: 'http://serviciosur.sytes.net/codigos/public/consulta/buscarcp.do',
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
    validateForm();
    if ($('.error').length === 0) {
        var param = {
            correo: $('#correo').val(),
            nombre: $('#name').val(),
            app: $('#ap').val(),
            apm: $('#am').val(),
            cp: $('#cp').val(),
            estado: $('#estado').val(),
            ciudad: $('#ciudad').val(),
            municipio: $('#del').val(),
            colonia: $('#colonia').val(),
            calle: $('#calle').val(),
            numext: $('#numext').val(),
            numint: $('#numint').val(),
            rfc: $('#rfc').val(),
            telcel: $('#cel').val(),
            telfig: $('#otro').val(),
            password: $('#pass1').val()
        };
        $.ajax({
            type: "POST",
            url: 'public/user/agregarUsuario.do',
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            data: JSON.stringify(param),
            success: function (data) {
                $.fancybox('<h3>Felicidades</h3><p>Te haz registrado en la pagina, por favor activa tu cuenta por medio del correo que te ha sido enviado</p>',
                        {
                            scrolling: 'auto',
                            afterClose: function () {
                                location.href = "/shop/index.html";
                            }
                        });
            },
            failure: function (errMsg) {
                alert(errMsg);
            }
        });
    }
});

