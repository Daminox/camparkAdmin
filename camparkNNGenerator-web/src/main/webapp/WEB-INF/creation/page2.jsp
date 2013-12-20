<%-- 
    Document   : page2
    Created on : 13 déc. 2013, 14:51:36
    Author     : Damien
--%>

<%@page import="java.io.FileOutputStream"%>
<%@page import="java.io.File"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Page2</title>


        <!--Scripts !-->
        <script type="text/javascript" src="ressources/js/libs/jquery-1.9.1.min.js"></script>
        <script type="text/javascript" src="ressources/js/libs/jquery.imgareaselect.pack.js"></script>
        <script type="text/javascript" src="ressources/js/creation/cropImages.js"></script>
        <script type="text/javascript">
            $(document).ready(function() {
                $('#valider').on('click', function(event) {
                    alert('click');
                    console.log($(this).parent('form').serialize());
                    event.preventDefault();
                    return false;
                });

                $('#seeImage').on('click', function(event) {
                    afficherImage($("#selectNbPlace"),  $('#mainCropArea'));
                    event.preventDefault();
                    return false;
                });
            });
        </script>

    </head>
    <body>
        <h1>Selection des places et des zones<%= System.getProperty("jboss.server.base.dir")%></h1>
        <h1><%= System.getProperty("jboss.server.base.url")%></h1>
        <h1><%= System.getProperty("jboss.server.base.url") + "/" + "00_1.JPG"%></h1>
        <form action="#">
            <image src="<%= "file://"+System.getProperty("jboss.server.base.dir") + "\\" + "00_1.JPG"%>"/>
            
            <image src="<%= "../00_1.JPG"%>"/>
            <image src="<%= "../../00_1.JPG"%>"/>
            <image src="<%= "../../../00_1.JPG"%>"/>
            <image src="<%= "../../../../00_1.JPG"%>"/>
            
            <div id="top">
                <h2>Selection des places pour la caméra : ${nomCamera} (${idCamera})</h2>
                Réduire la photo de <input type="number" id="selectReduction" name="selectReduction" placeholder="Réduire l'image" />% - 
                Il y a <input type="number" id="selectNbPlace" name="selectNbPlace" placeholder="Remplir le nombre de place dans la page" /> places sur la photo.
                <img src="${pathImage}" id="imgReferenceRaw" style="" />
                <button value="Voir les images" id="seeImage" >Voir les images</button>
                <button type="submit" value="Valider l'envoie" id="valider">Valider !</button>
            </div>


            <br/>
            <div id="mainCropArea"></div>

        </form>

    </body>
</html>
