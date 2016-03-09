$(window).load(function () {
    var param = {}, categoria = getParameter('cat'),palabra=getParameter('palabra');
    param.categoria = categoria;
    param.palabraClave=palabra;
    var data=chargeProdGaleria('#localgrid',param);
    $(function () {
        
    });
    

});
