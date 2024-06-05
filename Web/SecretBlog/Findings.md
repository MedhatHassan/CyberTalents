# Solve Secret Blog
#### https://cybertalents.com/challenges/web/secret-blog
![alt text](images/image-1.png)

### try ro login with admin 
username: admin
pawword: admin
![alt text](images/image.png)

### directory brute force with dirsearech
`dirsearch -u http://wcamxwl32pue3e6mle435rka8v5xj6zqdkgxu639-web.cybertalentslabs.com/ -x 404,403`
Output:
```bash
200 -  560B  - /flag.php                                         
302 -    0B  - /login.php  ->  ./flag.php  
```

### Change admin value to `True` in the cookies
![alt text](images/image-2.png)

>Find More on ==> github.com/MedhatHassan 