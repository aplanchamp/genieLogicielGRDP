<!DOCTYPE html>
<html>
    <head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />		<title>
			Accueil - Circuit Scientifique Bordelais - CNRS
		</title>
		<meta name="viewport" content="width=device-width, initial-scale=1">
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
         <input name="name" role="form" class="form-control" maxlength="100" type="text" id="basic-addon1"/>
       </div>
     </div>
     <div class="form-group" style="padding:1.5em 0;">
       <label for="TeacherEmail" class="col-sm-2 control-label">Adresse email</label>
       <div class="col-sm-10">
         <input name="email" role="form" class="form-control" maxlength="100" type="email" id="basic-addon1"/>
       </div>
     </div>
     <div class="form-group" style="padding:1.5em 0;">
       <label for="TeacherEmail" class="col-sm-2 control-label">Téléphone</label>
       <div class="col-sm-10">
         <input name="phone" role="form" class="form-control" maxlength="100" type="text" id="basic-addon1"/>
       </div>
     </div>

     <div class="form-group" style="padding:1.5em 0;">
       <label for="TeacherPassword" class="col-sm-2 control-label">Mot de passe</label>
       <div class="col-sm-10 required">
         <input name="password" role="form" class="form-control" type="password" id="basic-addon1" required="required"/>
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
   <form action="/teachers/login" id="TeacherLoginForm" method="post" accept-charset="utf-8"><div style="display:none;"><input type="hidden" name="_method" value="POST"/></div><div class="form-group" style="padding:1.5em 0;"><label for="TeacherEmail" class="col-sm-2 control-label">Adresse email</label><div class="col-sm-10"><input name="data[Teacher][email]" role="form" class="form-control" maxlength="100" type="email" id="TeacherEmail"/></div></div><div class="form-group" style="padding:1.5em 0;"><label for="TeacherPassword" class="col-sm-2 control-label">Mot de passe</label><div class="col-sm-10 required"><input name="data[Teacher][password]" role="form" class="form-control" type="password" id="TeacherPassword" required="required"/></div></div><div class="form-group" style="padding:1.5em 0;"><div class="col-sm-offset-2 col-sm-10"><input  class="btn btn-default" title="Se connecter" type="submit" value="Se connecter"/></div></div></form>						</div>
             	</div>
   				</div>
   			</div>


   		</div>


   		<footer id="footer">
   			<div class="container">
   	<div class="row">
   		<div class="col-xs-12 col-lg-2 visible-lg-block" id="sidebarBottom">
   			<div id="scienceFest">
   				à l'occasion de la
   				<a href="http://www.fetedelascience.fr/"><img src="http://circuit-scientifique-bordelais.cnrs.fr/img/logos/fetedelascience.png" alt="Logo de la Fête de la science" title="Fête de la Science"/></a>
   			</div>
   		</div>
   		<div class="col-xs-12 col-lg-10" id="credits">
   			<div id="labs">
   				<a href="http://www.enscbp.fr/"><img src="http://circuit-scientifique-bordelais.cnrs.fr/img/logos/ENSCBP.png" id="ENSCBPLogo" alt="logo de l'École Nationale Supérieure de Chimie, de Biologie et de Physique" title="École Nationale Supérieure de Chimie, de Biologie et de Physique"/></a>
   				<a href="http://www.cea.fr/"><img src="http://circuit-scientifique-bordelais.cnrs.fr/img/logos/CEA.png" id="CEALogo" alt="logo du Commissariat à l'Énergie Atomique et aux Énergies Alternatives" title="Commissariat à l'Énergie Atomique et aux Énergies Alternatives"/></a>
   				<a href="http://www.cnrs.fr/"><img src="http://circuit-scientifique-bordelais.cnrs.fr/img/logos/CNRS.png" id="CNRSLogo" alt="logo du Centre National de Recherche Scientifique" title="Centre National de Recherche Scientifique"/></a>
   				<a href="http://www.inra.fr/"><img src="http://circuit-scientifique-bordelais.cnrs.fr/img/logos/INRA.png" id="INRALogo" alt="logo de l'Institut National de la Recherche Agronomique" title="Institut National de la Recherche Agronomique"/></a>
   				<a href="http://www.inria.fr/"><img src="http://circuit-scientifique-bordelais.cnrs.fr/img/logos/INRIA.png" id="INRIALogo" alt="logo de l'Institut National de Recherche en Informatique et en Automatique" title="Institut National de Recherche en Informatique et en Automatique"/></a>
   				<a href="http://www.irstea.fr/"><img src="http://circuit-scientifique-bordelais.cnrs.fr/img/logos/IRSTEA.png" id="IRSTEALogo" alt="logo de l'Institut National de Recherche en Sciences et Technologies pour l'Environnement et l'Agriculture" title="Institut National de Recherche en Sciences et Technologies pour l'Environnement et l'Agriculture"/></a>
   				<a href="http://www.u-bordeaux.fr/"><img src="http://circuit-scientifique-bordelais.cnrs.fr/img/logos/UBX.png" id="UBXLogo" alt="logo de l'Université de Bordeaux" title="Université de Bordeaux"/></a>
   				<a href="http://www.u-bordeaux-montaigne.fr/"><img src="http://circuit-scientifique-bordelais.cnrs.fr/img/logos/UBM.png" id="UBMLogo" alt="logo de l'Université Bordeaux Montaigne" title="Université Bordeaux Montaigne"/></a>
   				<a href="http://www.inserm.fr/"><img src="http://circuit-scientifique-bordelais.cnrs.fr/img/logos/INSERM.png" id="INSERMLogo" alt="logo de l'Institut National de la Santé Et de la Recherche Médicale" title="Institut National de la Santé Et de la Recherche Médicale"/></a>
   				<a href="https://www.institutoptique.fr/"><img src="http://circuit-scientifique-bordelais.cnrs.fr/img/logos/IOGS.png" id="IOGSLogo" alt="logo de l'Institut d'optique Graduate School" title="Institut d'optique Graduate School"/></a>
   			</div>
   			<div id="help">
   				Avec l'appui de
   				<a href="http://www.cap-sciences.net/"><img src="http://circuit-scientifique-bordelais.cnrs.fr/img/logos/CapSciences.png" id="CapSciencesLogo" alt="logo de Cap Sciences" title="Cap Sciences"/></a>
   				<a href="http://www.ac-bordeaux.fr/"><img src="http://circuit-scientifique-bordelais.cnrs.fr/img/logos/ACBordeaux.png" id="ACBdXLogo" alt="logo de l'Académie de Bordeaux" title="Académie de Bordeaux"/></a>
   			</div>
   			<div id="footerLinks">
   				<a href="/page/contacts">Contacts</a> | <a href="/admin/pages">Administrateurs</a> | <a href="/page/legals">Mentions légales</a>
   			</div>
   		</div>
   	</div>
   </div>		</footer>
   		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
   		<script type="text/javascript" src="http://circuit-scientifique-bordelais.cnrs.fr/js/bootstrap.min.js"></script>    </body>
   </html>
