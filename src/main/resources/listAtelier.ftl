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
		<div class="container theme-showcase" role="main">
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

			<div class="laboratoire">
				<h2>Liste des ateliers disponibles: </h2>



				



				<div class="liste-atelier-laboratoire">
				<#list ateliers as atelier>
					
					<div class="one-atelier-list">
						<dl class="dl-horizontal"> <!-- Mettre un ng-repeat plus tard -->
						  <dt>Nom de l'atelier:</dt>
						  <dd>${atelier.name}</dd>
						  <dt>Description:</dt>
						  <dd>${atelier.description}</dd>
						  <dt>Horaires:</dt>
						  <dd>${atelier.heure}</dd>
						  <dt>Lieu:</dt>
						  <dd>${atelier.lieu}</dd>
						  <dt>Responsable :</dt>
						  <dd>${atelier.responsable}</dd>
						  <dt>Place disponibles:</dt>
						  <dd>${atelier.nbPlace}</dd>
						</dl>

						<button class="btn btn-primary btn-xs" >Modifier les détails de cet atelier</button>
						<button class="btn btn-primary btn-xs">Supprimer cet atelier</button>
						<button class="btn btn-primary btn-xs">Voir les participants</button>
						<button class="btn btn-primary btn-xs">Participer à l'atelier</button>

						<hr>
					</div>

				</#list>

				</div>

			</div>
		</div>
	</body>
</html>