<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %> 
<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <!-- Bootstrap -->
        <link href="../css/bootstrap.min.css" rel="stylesheet">

        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
          <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
          <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
        <![endif]-->
    </head>
    <body>
        <s:form action="addCamera" method="POST">
            <input type="text" name="nomCamera" placeholder="Saisir nom caméra" />
            <s:submit>Valider</s:submit>
        </s:form>
        <s:property value="bouh"></s:property>
            <div class="container"> </br>
                <div class="span6 well">
                    <h4><s:text name="main.titreListe" ></s:text><s:text name="toto"></s:text></h4>
                    <br>
                    <div class="accordion-heading">
                            <a class="accordion-toggle" href="#item1" data-toggle="collapse" data-original-title="<s:text name="main.creerCamera.info"></s:text>">
                        <s:text name="main.creerCamera"/>
                    </a>
                </div>
                <div id="item1" class="collapse">
                    <div class="accordion-inner"> 
                        Yo dog.
                    </div>
                </div>
                <div class="accordion-heading"> <a class="accordion-toggle" href="#item2" data-toggle="collapse"> Fenêtre modale </a> </div>
                <div id="item2" class="collapse">
                    <div class="accordion-inner"> Ce plugin permet de créer des fenêtres modales élégantes avec une grande simplicité. </div>
                </div>
                <div class="accordion-heading"> <a class="accordion-toggle" href="#item3" data-toggle="collapse"> Carousel </a> </div>
                <div id="item3" class="collapse">
                    <div class="accordion-inner"> Ce plugin permet de faire défiler des images ou des vidéo, ou tout autre élément média avec une mise 
                        en forme esthétique </div>
                </div>
            </div>
        </div>    
        <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
        <script src="../js/jquery.js"></script>
        <!-- Include all compiled plugins (below), or include individual files as needed -->
        <script src="../js/bootstrap.min.js"></script>
    </body>
</html>