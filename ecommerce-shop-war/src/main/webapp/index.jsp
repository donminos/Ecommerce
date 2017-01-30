<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
    <head>
        <title>Paper Show</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="IE=Edge;chrome=1" />
        <meta name="_csrf" content="${_csrf.token}"/>
        <!-- default header name is X-CSRF-TOKEN -->
        <meta name="_csrf_header" content="${_csrf.headerName}"/>
        <link rel="shortcut icon" href="/favicon.ico" />
        <link rel="stylesheet" type="text/css" href="resources/css/style.css" media="screen"/>
        <link rel="stylesheet" type="text/css" href="resources/css/style_responsive.css" media="screen"/>
        <link rel="stylesheet" href="resources/css/style_menu.css" type="text/css" media="screen">
        <link rel="stylesheet"  href="resources/css/lightslider.css"/>
    </head>
    <body>
        <header>
        </header>
        <nav class="flex-list">
        </nav>
        <section>
            <article>
                <div class="carrusel">
                    <div class="item">
                        <ul id="content-slider" class="content-slider-prod principal">
                        </ul>
                    </div>
                </div>
            </article>
            <article>
                <h3 class="tituloPageIndex">Popular esta semana</h3>
                <div class="carrusel-prod">
                    <div class="item">
                        <ul class="content-slider content-slider-prod popular">
                        </ul>
                    </div>
                </div>
            </article>

            <h3 class="tituloPageIndex">Los más vendidos</h3>
            <article>
                <div class="carrusel-prod">
                    <div class="item">
                        <ul class="content-slider content-slider-prod vendidos">
                            <!--<li>
                                <h3>6</h3>
                            </li>-->
                        </ul>
                    </div>
                </div>
            </article>
        </section>
        <footer>
        </footer>
        <div id="scripts">
            <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
            <script src="https://zonecours2.hec.ca/library/js/jquery/i18n-properties/1.0.9/jquery.i18n.properties-min-1.0.9.js"></script>
            <script src="resources/js/libs/lightslider.js"></script>
            <script src="resources/js/global.js"></script>
            <script src="resources/js/index.js"></script>
        </div>
    </body>
</html>
