# Solve Cheers
##### https://cybertalents.com/challenges/web/cheers

![alt text](images/image.png)

### Run Directory bruteforce

```bash
dirsearch -u http://wcamxwl32pue3e6mekgvdqyu93rqj6zqdkgxu639-web.cybertalentslabs.com -x 403,404
```

No output 

in the error message the website has an error in **welcome** **parameter** 

### add welcome parameter 

```http
http://wcamxwl32pue3e6mekgvdqyu93rqj6zqdkgxu639-web.cybertalentslabs.com/index.php/?welcome=
```
![alt text](images/image-1.png)

in the error message the website has an error in **gimme_flag**  **parameter** 

### add welcome gimme_flag

```
http://wcamxwl32pue3e6mekgvdqyu93rqj6zqdkgxu639-web.cybertalentslabs.com/index.php/?welcome&gimme_flag
```

![alt text](images/image-2.png)

Run Directory bruteforce