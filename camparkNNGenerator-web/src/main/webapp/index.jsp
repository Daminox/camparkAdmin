<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Page 1</title>
        <script type="text/javascript" src="ressources/js/libs/jquery-1.9.1.min.js"></script>
        <script type="text/javascript" src="ressources/js/libs/jquery.imgareaselect.pack.js"></script>
        <script type="text/javascript">
            $(document).ready(function()
            {
                $('#inputFolderFile').on('change', function() {
                    $('#inputFolder').val($(this).val());
                    console.log($('#inputFolder').val());
                    console.log($('#inputFolderFile').val());
                });
                
                
                
            });
        </script>
    </head>
    <body>
        <h1>Création caméra</h1>
        <form action="Creation">
            <input type="hidden" value="creerCamera" name="action" />

            <label for="nomCamera">Saisir le nom de la caméra</label>
            <input type="text" name="nomCamera" id="nomCamera"/>

            <label for="inputFolderFile">Donnez le chemin vers le dossier input</label>
            <input type="file" name="" id="inputFolderFile"/>
            
            <input type="text" name="inputFolder" id="inputFolder" style="display: none;"/>

            <div>
                
            </div>
            
            <input type="submit" value="Valider"/>
            <img src="static/Data_2012/minimized/troll/PC110688.JPG" />
            <img src="static/Data_2012/minimized/11_1.JPG" />
            <img src="static/Data_2012/minimized/11_2.JPG" />
        </form>
    </body>
</html>
