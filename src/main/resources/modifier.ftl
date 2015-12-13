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

   				<div class="content" id="corpus">
		 								<h1> Modifier un Atelier </h1>
								<form method="POST" action="modifier?name=${atelier.name}" class="col-md-8">
									<div class="input-group col-md-8">
										<input type="text" class="form-control" placeholder="Nom de l'atelier" aria-describedby="basic-addon1" name="name_atelier" value="${atelier.name}" required>
									</div>
									<div class="input-group col-md-8">
										<input type="text" class="form-control" placeholder="Description" aria-describedby="basic-addon1" name="desc_atelier" value="${atelier.description}" required>
									</div>
									<div class="input-group col-md-8">
										<!-- <div class="input-group bootstrap-timepicker timepicker">
																<input placeholder="Heure de début (hh:mm)" maxlength=5 pattern="[0-9]{2}:[0-9]{2}" id="timepicker1" type="text" name="hour1_atelier" class="form-control input-small" required>
																<input id="timepicker1" type="text" name="hour2_atelier" class="form-control input-small">
																<span class="input-group-addon"><i class="glyphicon glyphicon-time"></i></span>
										</div> -->
										<input type="time" class="form-control" placeholder="Date de l'atelier" aria-describedby="basic-addon1" name="hour1_atelier" required>
										<input type="time" class="form-control" placeholder="Date de l'atelier" aria-describedby="basic-addon1" name="hour2_atelier" required>
									</div>
									<div class="input-group col-md-8"> <!-- Change to type = date -->
										<input type="text" class="form-control" placeholder="Date de l'atelier" aria-describedby="basic-addon1" name="date_atelier" value="${atelier.date}" required>
									</div>
									<div class="input-group col-md-8">
										<input type="text" class="form-control" placeholder="Lieu de l'atelier" aria-describedby="basic-addon1" name="lieu_atelier" value="${atelier.lieu}" required>
									</div>
									<div class="input-group col-md-8">
										<input type="text" class="form-control" placeholder="Responsable" aria-describedby="basic-addon1" name="resp_atelier" value="${atelier.responsable}" required>
									</div>
									<div class="input-group col-md-8">
										<input type="number" class="form-control" placeholder="Place disponibles" aria-describedby="basic-addon1" name="avail_atelier" value="${atelier.nbPlace}" required>
									</div>

									<div class="input-group col-md-8">
										<input type="submit" class="btn btn-primary btn-lg btn-block" value="Modifier">
									</div>
								</form>
							</div>
							</div>


							</div>
   				</div>
   			</div>
   		</div>



              <#import "footer.ftl" as m>
               <@m.filterfooter />
   		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
   		<script type="text/javascript" src="http://circuit-scientifique-bordelais.cnrs.fr/js/bootstrap.min.js"></script>    </body>
   </html>
