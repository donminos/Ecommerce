<%-- 
    Document   : galeria
    Created on : 1/02/2017, 11:24:40 PM
    Author     : ceasar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Paper Show</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="IE=Edge;chrome=1" />
        <meta name="_csrf" content="${_csrf.token}"/>
        <link rel="shortcut icon" href="/favicon.ico" />
        <link rel="stylesheet" type="text/css" href="resources/css/primeui-4.1.0.css" media="screen"/>
        <link rel="stylesheet" type="text/css" href="resources/css/style.css" media="screen"/>
        <link rel="stylesheet" type="text/css" href="resources/css/style_responsive.css" media="screen"/>
        <link rel="stylesheet" href="resources/css/style_menu.css" type="text/css" media="screen">
    </head>
    <body>
        <header>
        </header>
        <nav>
        </nav>
        <section>
            <article id="localgrid">
            </article>
        </section>
        <footer>
        </footer>

        <div id="scripts">
            <script src="//code.jquery.com/jquery-1.12.0.min.js"></script>
            <script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/jquery-ui.min.js"></script>
            <script src="resources/js/libs/handlebars-v4.0.5.js"></script>
            <script src="resources/js/libs/primeui-4.1.0.js"></script>
            <script src="resources/js/global.js"></script>
            <script src="resources/js/galeria.js"></script>
        </div>
    </body>
</html>
