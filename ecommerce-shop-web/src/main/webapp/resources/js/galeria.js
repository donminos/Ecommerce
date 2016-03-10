function chargeProdGaleria(id, param) {
    var variable;
    if(param.categoria!==undefined){
        variable=param.categoria;
    }else if(param.palabraClave!==undefined){
        variable=param.palabraClave;
    }
    var categoria=$.getJSON('/shop/public/categorias/findId.do>' + variable);
    categoria.done(function(info){
        galeriaCharge(info,param,id);
    });
    categoria.error(function(){
        var infoCat={};
        infoCat.responseJSON={},infoCat.nombre='Busqueda de '+param.palabraClave;
        galeriaCharge(infoCat,param,id);
    });
}
function galeriaCharge(infoCat,param,id){
        $.ajax({
            type: "POST",
            url: "/shop/public/productos/findAll.do",
            // The key needs to match your method's input parameter (case-sensitive).
            data: JSON.stringify(param),
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            success: function (data) {
                $(id).puidatagrid({
                    paginator: {
                        rows: 6
                    },
                    header: '<b>' + infoCat.nombre + '</b>',
                    datasource: data,
                    content: function (prod) {
                        return $('<div id="prod_' + prod.idProducto + '" class="programa"><img width="80%" src="/shop/public/images/getimage?image=' + prod.imagenesList[0].path +
                                '" /><div class="titleGaleria">' + prod.nombre + '</div><p>' + prod.detalle + '</p><p class="costoGaleria">$' + prod.costo + '</p></div>').puipanel();
                    }
                });
                $('.programa').click(function () {
                    var programa = this.id.replace('prod_', '');
                    window.location.href = '/shop/desc-prod.html?prod=' + programa;
                });
            },
            failure: function (errMsg) {
                alert(errMsg);
            }
        });
}
$(window).load(function () {
    var param = {}, categoria = getParameter('cat'),palabra=getParameter('palabra');
    param.categoria = categoria;
    param.palabraClave=palabra;
    chargeProdGaleria('#localgrid',param);
});
