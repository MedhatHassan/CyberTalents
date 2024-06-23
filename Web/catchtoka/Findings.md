# Solve catchtoka
#### https://cybertalents.com/challenges/web/catchtoka

![alt text](image.png)
### Run Directory bruteforce
`dirsearch -u http://wcamxwl32pue3e6mg23g207f834kj6zqdkgxu639-web.cybertalentslabs.com -x 403,404`
No ouput

### Analyze request with burp
```
GET / HTTP/1.1
Host: wcamxwl32pue3e6mg23g207f834kj6zqdkgxu639-web.cybertalentslabs.com
User-Agent: Mozilla/5.0 (X11; Linux x86_64; rv:109.0) Gecko/20100101 Firefox/115.0
Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,*/*;q=0.8
Accept-Language: en-US,en;q=0.5
Accept-Encoding: gzip, deflate
Connection: close
Cookie: _ga_B38952S5RT=GS1.1.1718765785.1.1.1718765798.47.0.0; _ga=GA1.1.1474852010.1718765786; _clck=yv78z1%7C2%7Cfmr%7C0%7C1631; ajs_anonymous_id=79cb6015-fb56-43db-bbe9-121c0fe1885e; _fbp=fb.1.1718765789636.122478108392360263; _ga_S72LBY47R8=GS1.1.1718766980.1.1.1718767179.0.0.0
Upgrade-Insecure-Requests: 1
```
Change `Accept-Language` to `Accept-Language: de` For Gemrman

![alt text](image-1.png)
>Find More on ==> github.com/MedhatHassan 
