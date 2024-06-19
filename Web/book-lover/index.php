<?php
$flag = 'xeeflag345';

libxml_disable_entity_loader(false);

if($_FILES){
  $books = $_FILES['books'];
  // print_r($books);exit;
  if($books['type'] != 'text/xml'){
    echo 'Only xml Document Allowed';
    exit;
  }
  //check extention
  $ext = pathinfo($books['name'], PATHINFO_EXTENSION);
  if($ext != 'xml'){
    echo 'Only xml Extention Are Allowed';
    exit;
  }
  
  $xmlstr = file_get_contents($books['tmp_name']);
  $doc = new DOMDocument();
  
  $doc->loadXML($xmlstr, LIBXML_NOENT);
  $items = $doc->getElementsByTagName('book');

  $name = $_POST['name'];
  $content = nl2br($doc->textContent);
}
?>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title>Book Store</title>

    <!-- Bootstrap -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.3/css/font-awesome.min.css" />

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
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
          <a class="navbar-brand" href="#">Book Lover</a>
        </div>
        <div id="navbar" class="collapse navbar-collapse">
          <ul class="nav navbar-nav">
            <li><a href="index.php">Home</a></li>
            
          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </nav>
    <div class="container" style="padding-top:50px;">
        <h1>Book Lover</h1>
        <h2>Share your love , by sharing us your library</h2>
        <p>&nbsp;</p>
        <?php 
        if(isset($name)){
          echo '<h3>Thanks '.$name.' for sharing your love</h3>';
          echo '<p>'.$content.'</p>';
        }
        ?>
        <div class="row">
          <div class="col-sm-6 col-sm-offset-3">
            <form action="" method="post"  enctype="multipart/form-data">
              <input type="text" name="name" placeholder="Your Name" class="form-control">
              <input type="file" name="books" required="required">
              <p>Only xml files accepted </p>
              <button type="submit">Upload</button>
            </form>
          </div>
        </div>
    </div>

    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
    
  </body>
</html>
