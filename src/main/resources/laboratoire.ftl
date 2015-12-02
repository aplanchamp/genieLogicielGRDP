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

				<h2>Gestion des ateliers</h2>
				<button type="submit" class="btn btn-success">Ajouter un nouvel atelier</button>
				<hr>
				<h2>Liste de mes ateliers:</h2>

				<div class="liste-atelier-laboratoire">
					<div class="one-atelier-list">
						<dl class="dl-horizontal"> <!-- Mettre un ng-repeat plus tard -->
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

						<button>Modifier les détails de cet atelier</button>
						<button>Supprimer cet atelier</button>
						<button>Voir les participants</button>
						<hr>
					</div>



					<div class="one-atelier-list">
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
						<button>Modifier les détails de cet atelier</button>
						<button>Supprimer cet atelier</button>
						<button>Voir les participants</button>
						<hr>
					</div>

				</div>

			</div>
		</div>
	</body>
</html>