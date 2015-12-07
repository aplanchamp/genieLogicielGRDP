<html>
<head>
	<meta charset="utf-8">
	<title>Circuit Scientifique Bordelais</title>
	<link rel="stylesheet" href="http://netdna.bootstrapcdn.com/bootstrap/3.0.2/css/bootstrap.min.css">
	<link rel="stylesheet" href="http://netdna.bootstrapcdn.com/bootstrap/3.0.2/css/bootstrap-theme.min.css">
	<link rel="stylesheet" href="http://getbootstrap.com/examples/starter-template/starter-template.css">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.17.37/css/bootstrap-datetimepicker.min.css">
	<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.17.37/js/bootstrap-datetimepicker.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	<link rel="stylesheet" href="main.css">
</head>
<body>
	<div class="container theme-showcase" role="main">
		<#import "header.ftl" as m>
		<@m.filterheader />

			<div class="register">
				<h1> Ajouter un Atelier </h1>
				<form method="POST" action="accueil" class="col-md-8">
					<div class="input-group col-md-8">
						<input type="text" class="form-control" placeholder="Nom de l'atelier" aria-describedby="basic-addon1" name="name">
					</div>
					<div class="input-group col-md-8">
						<input type="text" class="form-control" placeholder="Description" aria-describedby="basic-addon1" name="email">
					</div>
					<div class="input-group col-md-8">
						<div class="input-group bootstrap-timepicker timepicker">
						            <input id="timepicker1" type="text" class="form-control input-small">
						            <span class="input-group-addon"><i class="glyphicon glyphicon-time"></i></span>
						</div>
					</div>
					<div class="input-group col-md-8">
						<input type="text" class="form-control" placeholder="Password" aria-describedby="basic-addon1" name="password">
					</div>
					<div class="input-group col-md-8">
						<input type="submit" class="btn btn-primary btn-lg btn-block" value="Register">
					</div>
				</form>
			</div>
	</div>

	<script type="text/javascript">
            $('#timepicker1').timepicker();
   </script>

</body>
</html>