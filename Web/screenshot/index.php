<?php

if(isset($_GET['url'])){
    //--- Set the parameters --------------//
    $url  = $_GET['server'].$_GET['url'];
    // print_r($url);
    // exit;
    $apikey = "ab6e7c527efda467019ba2687739c74c089fe5cd9c2a";
    $file = __DIR__.'/thumbs/'.md5($url).'.jpg';
    //echo $file;
    $fileURL = 'thumbs/'.md5($url).'.jpg';
    $width  = 640;
    //--- Make the call -------------------//
    $fetchUrl = "https://api.thumbnail.ws/api/".$apikey ."/thumbnail/get?url=".urlencode($url)."&width=".$width;

    $fakeUrl = $url;


    if(filter_var($url, FILTER_VALIDATE_URL)) {
        $r = parse_url($url);
        //print_r($r);

        if(!preg_match('/internalapi[1-9]\.local/', $url)) {
            echo 'Invalid HOST:-'.'<br />';
            echo 'You must choose one of our internal apis internalapi [1:9] only'.'<br />';
            echo 'Given: '.htmlentities($url);
            exit;
        }

        //replace "http://internalapi1.local/api/get_thumb/" with "" to allow file_get_contents
        // if(!strstr($url,'@') && !strstr($url,';') && !strstr($url,'$') && !strstr($url,'?') ){
        //     $url = str_replace('http://internalapi1.local/api/get_thumb/','',$url);
        // }
        

        

        //echo $file;
        if(!file_exists($file)){
            //echo 'Grab';
            set_error_handler(function($errno, $errstr, $errfile, $errline, array $errcontext) { print_r($errstr);/* ignore errors */ });
            $x = file_get_contents($url);
            restore_error_handler();
            //--- Do something with the image -----//
            file_put_contents($file, $x);
        }

    
    }else{
        echo "Not valid url";
        exit;
    }

   // exit;

    // echo 'Grab';
    // set_error_handler(function($errno, $errstr, $errfile, $errline, array $errcontext) { print_r($errstr);/* ignore errors */ });
    // $x = file_get_contents('http://internalapi.local/api/'.$url);
    // restore_error_handler();
    // print_r($x);
    
    // //get the cache
    // if(!file_exists($file)){
    //     echo 'Grab';
        

        
    //     print_r($x);
    // }

   // exit;

    // if(strstr($url,'@')){

    //     $info = explode('@',$url);
    //     $url = $info[1];

    //     $serverIP = '54.187.57.106';
    //     $supposeURL = $serverIP.'/latest/meta-data/hostname';
    //     $supposeURL2 = '127.0.0.1/latest/meta-data/hostname';

    //     if(strstr($url,$supposeURL) || strstr($url,$supposeURL2))
    //     {
    //         $jpeg =  'Server!Host@Flag';
    //         file_put_contents($file, $jpeg);
    //     }else{

    //         $fetchUrl2 = "https://api.thumbnail.ws/api/".$apikey ."/thumbnail/get?url=".urlencode($info[1])."&width=".$width;
    //         $jpeg = file_get_contents($fetchUrl2);
    //         file_put_contents($file, $jpeg);
    //     }
    // }else{

    //     if(!file_exists($file)){
    //         $jpeg = file_get_contents($fetchUrl);
    //         //--- Do something with the image -----//
    //         file_put_contents($file, $jpeg);
    //     }else{

    //     }
    // }

}
?>

<html>
    <head>
        <title>Hello Thumb</title>
    </head>
    <body>
        <div style="padding:100px;text-align:center">
            <h1>Get Thumbnail</h1>
            <form action="" method="get">
                <?php
                    if(isset($file) && isset($fileURL)){
                        ?>
                    <img src="<?php echo $fileURL; ?>" alt="<?php echo str_replace('"',"'",$fakeUrl) ?>" />
                        <?php
                    }else{
                ?>
                    <input type="text" name="url" placeholder="http://google.com" value="" style="width:70%;display:block;margin:auto;" />
                    Server :
                    <select name="server">
                        <option value="http://internalapi1.local/">http://internalapi1.local</option>
                        <option value="http://internalapi2.local/">http://internalapi2.local</option>
                        <option value="http://internalapi3.local/">http://internalapi3.local</option>
                        <option value="http://internalapi4.local/">http://internalapi4.local</option>
                        <option value="http://internalapi5.local/">http://internalapi5.local</option>
                        <option value="http://internalapi6.local/">http://internalapi6.local</option>
                        <option value="http://internalapi7.local/">http://internalapi7.local</option>
                        <option value="http://internalapi8.local/">http://internalapi8.local</option>
                        <option value="http://internalapi9.local/">http://internalapi9.local</option>
                    </select>
                    &nbsp; &nbsp;
                    <input type="submit" value="Get Thumb" />
                    <div>
                        Sorry for the interruption , but all the local api servers are down at the moment .... <i>Is this will stop you ;) ?</i>
                    </div>
                <?php } ?>
            </form>
        </div>
    </body>
</html>

[0m