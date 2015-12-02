<#macro filterheader>
		<nav class="navbar navbar-inverse navbar-fixed-top">
			<div class="container-fluid">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span> 
					</button>
					<a class="navbar-brand" href="#">Laboratoire de Bordeaux</a>
				</div>
				<div class="collapse navbar-collapse" id="myNavbar">
					<ul class="nav navbar-nav">
						<li class="active"><a href="#">Home</a></li>
						<li><a href="#">Liste des ateliers</a></li> 
					</ul>
					<form method="POST" class="navbar-form navbar-right">
						<div class="form-group">
							<input type="text" placeholder="Email" class="form-control" name="userConnect">
						</div>
						<div class="form-group">
							<input type="password" placeholder="Password" class="form-control" name="passwordConnect">
						</div>
						<button type="submit" class="btn btn-success">Sign in</button>
						<button type="submit" class="btn ">Deconnect</button>

					</form>
				</div>
			</div>
		</nav>
</#macro>