<html>
<head>
	<meta charset="utf-8">
	<title>Circuit Scientifique Bordelais</title>
	<link rel="stylesheet" href="http://netdna.bootstrapcdn.com/bootstrap/3.0.2/css/bootstrap.min.css">
	<link rel="stylesheet" href="http://netdna.bootstrapcdn.com/bootstrap/3.0.2/css/bootstrap-theme.min.css">
	<link rel="stylesheet" href="http://getbootstrap.com/examples/starter-template/starter-template.css">
	<link rel="stylesheet" href="main.css">
</head>
	<body>
	<#import "header.ftl" as m>
	<@m.filterheader />
		<div class="page-header">
			<h1>Circuit Scientifique Bordelais <small>${header}</small></h1>
		</div>
		<div class="page-header">
			<ul class="nav nav-pills">
				<li role="presentation" class="active"><a href="#">Home</a></li>
				<li role="presentation"><a href="#">Profile</a></li>
				<li role="presentation"><a href="#">Messages</a></li>
			</ul>
		</div>

		<div class="details-atelier">

			<dl class="dl-horizontal">
			  <dt>Nom de l'atelier:</dt>
			  <dd>${atelierTitle}</dd>
			  <dt>Description:</dt>
			  <dd>${atelierDescription}</dd>
			  <dt>Horaires:</dt>
			  <dd>${atelierHour1} - ${atelierHour2}</dd>
			  <dt>Lieu:</dt>
			  <dd>${atelierPlace}</dd>
			  <dt>Responsable :</dt>
			  <dd>${atelierSupervisor}</dd>
			  <dt>Place disponibles:</dt>
			  <dd>${atelierAvailable}</dd>
			</dl>
		</div>

		<form method="POST" action="detailsAtelier"> <!-- adresse de l'URI vers detailsAtelier -->
        	<button class="btn btn-primary" type="submit">
  				S'inscrire à l'atelier 
			</button>
     	</form>

		




</body>
</html>
