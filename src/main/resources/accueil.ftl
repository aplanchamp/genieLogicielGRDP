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

		<div class="container">
			<div class="register">
				<h1> Inscription </h1>
				<form method="POST" action="accueil" class="col-md-4"> 
					<div class="input-group">
						<span class="input-group-addon" id="basic-addon1">@</span>
						<input type="text" class="form-control" placeholder="Name" aria-describedby="basic-addon1" name="name">
					</div>
					<div class="input-group">
						<span class="input-group-addon" id="basic-addon1">@</span>
						<input type="text" class="form-control" placeholder="Email" aria-describedby="basic-addon1" name="email">
					</div>
					<div class="input-group">
						<span class="input-group-addon" id="basic-addon1">@</span>
						<input type="text" class="form-control" placeholder="Phone" aria-describedby="basic-addon1" name="phone">
					</div>
					<div class="input-group">
						<span class="input-group-addon" id="basic-addon1">@</span>
						<input type="password" class="form-control" placeholder="Password" aria-describedby="basic-addon1" name="password">
					</div>
					<input type="submit" class="btn btn-primary btn-lg btn-block" value="Register">
				</form>
			</div>
		</div> <!-- /container -->


	</div>
</body>
</html>