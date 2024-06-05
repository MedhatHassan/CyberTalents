# Solve remote CVE
### https://cybertalents.com/challenges/machines/remote-cve

#### Run nmap 
`nmap -A -p- -Pn -T5 54.67.120.72`

*Output in [nmap](nmap.txt) file*

We found `HttpFileServer httpd 2.3`

Run `searchsploit HttpFileServer` 

```
--------------------------------------------------------------------------
Exploit Title |  Path
--------------------------------------------------------------------------
Rejetto HttpFileServer 2.3.x - Remote Command Execution (3) | windows/webapps/49125.py
--------------------------------------------------------------------------
Shellcodes: No Results
```
We found CVE-2014-6287 for `HttpFileServer 2.3`

### Resources 
[CVE-2014-6287 exploit-db](https://www.exploit-db.com/exploits/39161)
[CVE-2014-6287 github](https://github.com/randallbanner/Rejetto-HTTP-File-Server-HFS-2.3.x---Remote-Command-Execution)

>Find More on ==> github.com/MedhatHassan 