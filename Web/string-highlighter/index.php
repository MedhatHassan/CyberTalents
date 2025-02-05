<?php
//only the server can reveal the flag on http://google.com
//?x=red: {{print(`whoami`)}}
///{${ print_r(`whoami`) }}
// /dev/ctf

function x($string)
{
  $x = preg_match_all('/([a-z0-9_]+)\s*\(/isU', $string,$matches);
  if($x){
    //$func = $matches[1][0];
    foreach($matches[1] as $func){
      //echo $func;
      if(function_exists($func)){
        echo 'Code contains php code , php codes is forbidden';
        exit;
      } 
    }
       
    //exit;
  }
	//$r = str_replace('/dev/ctf', '\\"xxdd33\\"', $string);
	$r = preg_replace('/(red|green|white|black|blue):\s*(.*)/', 'echo \'<div style="color:$1;">\'.strtolower("$2").\'</div>\';', $string);
	//echo $r;
	return eval($r);
}

if(isset($_POST['stp'])){
	x($_POST['stp']);
	exit;
}

?>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title>Welcome to String highlighter 1</title>

    <!-- Bootstrap -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>
  <body>
    <nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#">String highlighter</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          
        </div><!--/.navbar-collapse -->
      </div>
    </nav>
   

    <div class="jumbotron">
      <div class="container">
        <h1>String highlighter</h1>
        <p>&nbsp;</p>
        <div class="row">
	        <div class="col-sm-6">
	        	<h2>Type any string to highlight</h2>
		        <form action="" method="post">
		        	<div class="row">
		        		<div class="col-sm-12">
		        			<select name="color" class="form-control">
		        				<option value="red">Red</option>        				
		        				<option value="blue">Blue</option>        				
		        				<option value="green">Green</option>        				
		        				<option value="white">White</option>        				
		        				<option value="black">Black</option>        				
		        			</select>
		        		</div>
		        	</div>
		        	<p>&nbsp;</p>
		        	<div class="row">
		        		<div class="col-sm-12">
		        			<textarea  name="text" rows="10" class="form-control"></textarea>
		        		</div>
		        	</div>
		        	<p>&nbsp;</p>
		        	<div class="row">
		        		<div class="col-sm-12">
		        			<button type="button" name="" class="sub btn btn-primary btn-block"> Highlight now !</button>
		        		</div>
		        	</div>
		        </form>
	        </div>
	        <div class="col-sm-6">
	        	<h2>Preview</h2>
	        	<div class="preview"></div>
	        </div>
        </div>
      </div>
    </div>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script type="text/javascript">
    	$('.sub').on('click',function(){
    		var color = $('select').val();
    		var txt = $('textarea').val();
    		var stringToParse = color + ':' + txt;
    		$.post('',{stp:stringToParse},function(data){
    			$('.preview').html(data);
    		});
    	});
    </script>
  </body>
</html>