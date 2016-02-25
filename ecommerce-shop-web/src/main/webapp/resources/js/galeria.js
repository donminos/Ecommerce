$(window).load(function () {
    var param = {}, categoria = getParameter('cat');
    param.categoria = categoria;
    var data=chargeProdGaleria('#localgrid',param);
    $(function () {
        
    });
    

});
