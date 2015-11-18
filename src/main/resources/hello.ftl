<html>
<head>
	<meta charset="utf-8">
	<title>Circuit Scientifique Bordelais</title>
	<link rel="stylesheet" href="http://netdna.bootstrapcdn.com/bootstrap/3.0.2/css/bootstrap.min.css">
	<link rel="stylesheet" href="http://netdna.bootstrapcdn.com/bootstrap/3.0.2/css/bootstrap-theme.min.css">
	<link rel="stylesheet" href="http://getbootstrap.com/examples/starter-template/starter-template.css"></head>
	<body>
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

		<form method="POST" action="accueil"> 
			<div class="col-md-2">
				<div class="input-group">
					<span class="input-group-addon" id="basic-addon1">@</span>
					<input type="text" class="form-control" placeholder="Username" aria-describedby="basic-addon1" name="user">
				</div>
				<div class="input-group">
					<span class="input-group-addon" id="basic-addon1">@</span>
					<input type="text" class="form-control" placeholder="Password" aria-describedby="basic-addon1" name="password">
				</div>
				<input type="submit" class="btn btn-primary btn-lg btn-block" value="Register">
			</div>
		</form>
</body>
</html>