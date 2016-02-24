$(window).load(function () {
    var param={},categoria = getParameter('cat');
    param.categoria = categoria, param.marca = 0, param.palabraClave = "";
    chargeProdGaleria('article',param);
});