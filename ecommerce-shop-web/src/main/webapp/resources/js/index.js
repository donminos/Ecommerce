$(window).load(function () {
    var param={};
    param.categoria = 0, param.marca = 0, param.palabraClave = "";
    chargeProd('.principal', 1, param);
    chargeProd('.popular', 4, param);
    chargeProd('.vendidos', 4, param);
    
});