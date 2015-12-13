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
   <h1>
   Inscription Enseignant
   </h1>
   </p>
  <form action="accueil" method="post" accept-charset="utf-8">
     <div style="display:none;">
       <input type="hidden" name="_method" value="POST"/>
     </div>
     <div class="form-group" style="padding:1.5em 0;">
       <label for="TeacherEmail" class="col-sm-2 control-label">Nom</label>
       <div class="col-sm-10">
         <input placeholder="Nom du laboratoire" name="name" role="form" class="form-control" maxlength="100" type="text" id="basic-addon1"/>
       </div>
     </div>
     <div class="form-group" style="padding:1.5em 0;">
       <label for="TeacherEmail" class="col-sm-2 control-label">Adresse email</label>
       <div class="col-sm-10">
         <input placeholder="E-mail" name="email" role="form" class="form-control" maxlength="100" type="email" id="basic-addon1"/>
       </div>
     </div>
     <div class="form-group" style="padding:1.5em 0;">
       <label for="TeacherEmail" class="col-sm-2 control-label">Téléphone</label>
       <div class="col-sm-10">
         <input placeholder="XXXXXXXXXX" pattern = "[0-9]{10}" name="phone" role="form" class="form-control" maxlength="100" type="text" id="basic-addon1"/>
       </div>
     </div>

     <div class="form-group" style="padding:1.5em 0;">
       <label for="TeacherPassword" class="col-sm-2 control-label">Mot de passe</label>
       <div class="col-sm-10 required">
         <input minlength=6 placeholder="Mot de passe" name="password" role="form" class="form-control" type="password" id="basic-addon1" required="required"/>
       </div>
     </div>
     <div class="form-group" style="padding:1.5em 0;">
       <div class="col-sm-offset-2 col-sm-10">
         <input  class="btn btn-default" title="S'enregistrer" type="submit" value="Register"/>
       </div>
    </div>
  </form>
						</div>


   												<div class="content" id="corpus">
   							<h1>
       Connexion Enseignant
   </h1>

   <p>
   	Vous avez déjà créé votre compte personnel. Vous pouvez y accéder en rentrant vos identifiants.
   	Si vous n’avez pas encore créé de compte vous pouvez le faire en vous inscrivant via le formulaire ci-dessus</a>.
   	<br/>
   	Avant de vous connecter, assurez-vous de bien avoir lu le guide d'aide à l’inscription des enseignants :
   	<a href="http://circuit-scientifique-bordelais.cnrs.fr/files/documents/Guide enseignant VF.pdf">Guide d'aide</a>.</br>
   </p>
   <form action="/accueil" id="TeacherLoginForm" method="post" accept-charset="utf-8">
     <div style="display:none;">
       <input type="hidden" name="_method" value="POST"/>
     </div>
     <div class="form-group" style="padding:1.5em 0;">
       <label for="TeacherEmail" class="col-sm-2 control-label">Adresse email</label>
       <div class="col-sm-10">
         <input placeholder="E-mail" name="userConnect" role="form" class="form-control" maxlength="100" type="email" id="TeacherEmail"/>
       </div>
     </div>
     <div class="form-group" style="padding:1.5em 0;">
       <label for="TeacherPassword" class="col-sm-2 control-label">Mot de passe</label>
       <div class="col-sm-10 required">
         <input placeholder="Mot de passe" name="passwordConnect" role="form" class="form-control" type="password" id="TeacherPassword" required="required"/>
       </div>
     </div>
     <div class="form-group" style="padding:1.5em 0;">
       <div class="col-sm-offset-2 col-sm-10">
         <input  class="btn btn-default" title="Se connecter" type="submit" value="Se connecter"/>
       </div>
     </div>
   </form>
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
