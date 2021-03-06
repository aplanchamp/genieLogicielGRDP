<!DOCTYPE html>
<html>
    <head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />		<title>
			Accueil - Circuit Scientifique Bordelais - CNRS
		</title>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link href="http://circuit-scientifique-bordelais.cnrs.fr/favicon.ico" type="image/x-icon" rel="icon" />
		<link href="http://circuit-scientifique-bordelais.cnrs.fr/favicon.ico" type="image/x-icon" rel="shortcut icon" />
		<link rel="stylesheet" type="text/css" href="http://circuit-scientifique-bordelais.cnrs.fr/css/bootstrap.min.css" />
		<link rel="stylesheet" href="main.css">
		<link rel="stylesheet" type="text/css" href="http://circuit-scientifique-bordelais.cnrs.fr/css/footer.css" />
		<script type="text/javascript" src="http://circuit-scientifique-bordelais.cnrs.fr/js/main.js">
		</script>
		    </head>
        <body>

   		<div id="wrap">

   			<div class="container" id="main">
   				<div class="row">
   					<div class="col-xs-12 col-lg-2 visible-lg-block" id="sidebar">
   						<a href="/" id="logo">

   						</a>
   						<div id="discover">
   							Venez découvrir le monde passionnant de la recherche
   						</div>
   					</div>
   					<div class="col-xs-12 col-lg-10">

              <#import "header.ftl" as m>
        			<@m.filterheader />

							<div class="details-atelier">

								<dl class="dl-horizontal">
									<dt>Nom de l'atelier:</dt>
									<dd>${atelier.name}</dd>
									<dt>Description:</dt>
									<dd>${atelier.description}</dd>
									<dt>Heure de début:</dt>
									<dd>${atelier.heure1}</dd>
									<dt>Heure de fin:</dt>
									<dd>${atelier.heure2}</dd>
									<dt>Lieu:</dt>
									<dd>${atelier.lieu}</dd>
									<dt>Responsable :</dt>
									<dd>${atelier.responsable}</dd>
									<dt>Place disponibles:</dt>
									<dd>${atelier.nbPlace}</dd>
								</dl>
							</div>

									<a href="/delete?name=${atelier.name}" >
										<button class="btn btn-primary btn-xs" >
											Supprimer l'atelier
										</button>
									</a>
									<a href="/modifier?name=${atelier.name}" >
										<button class="btn btn-primary btn-xs" >
											Modifier l'atelier
										</button>
									</a>

							</div>
   				</div>
   			</div>


   		</div>


              <#import "footer.ftl" as m>
               <@m.filterfooter />
   		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
   		<script type="text/javascript" src="http://circuit-scientifique-bordelais.cnrs.fr/js/bootstrap.min.js"></script>    </body>
   </html>
