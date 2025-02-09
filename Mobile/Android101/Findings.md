# Solve Android101
### https://cybertalents.com/challenges/mobile-security/android101

## Run the app 
### Run the app on android studio emulator 
![alt text](image.png)
it asks to access location and camera
![alt text](login.png)
it has a simple login form 

## Static code analysis 

### Decompile APK with apktool

``` bash
apktool d app.apk 
```

### Strart with  `Manifest.xml`

The app is taking access to `ACCESS_NETWORK_STATE , ACCESS_COARSE_LOCATION , CAMERA`

#### Search for any sensitive data in `/res/values/strings.xml`
We found search function with queries and a login form 

### Decompile APK with jadx-Gui

#### analyze the MainActivity Class
```
public class MainActivity extends ActionBarActivity {
    public int weezy = 152;

    private String getUser() {
        String resp = this.weezy > 152 ? "Legolas" : "Aragon";
        this.weezy += 100;
        return resp;
    }

    private String getPass() {
        return this.weezy > 152 ? "Saruman" : "Gandalf";
    }
```
MainActivity Class extends ActionBarActivity, providing backward-compatible action bar features.

public weezy is an integer field initialized to 152.
getUser() method returns "Legolas" if weezy is greater than 152, otherwise returns "Aragon". It increments weezy by 100 anyway.
getPass() method returns "Saruman" if weezy is greater than 152, otherwise returns "Gandalf".

#### Login Logic
When the button is clicked:

1. Username and password are retrieved from the EditText fields.
2. Logs the entered credentials.
3. Compares the entered username and password with values returned by `getUser()` and `getPass()`.
4. If they match *(have a value of 0)*, it logs "granted access", shows a **"access granted!"** toast, and starts MainActivity2.
5. If they don't match, it shows an **"access denied!"** toast.

The `getUser()` function will be called first.
The string str will have the value `Legolas`.
The value of the weezy variable will be increased by 100, so the value will be **252**.
The `getPass()` function will be called.
Since the current value of the variable weezy is **252**, the `getPass()` function will have the value `Saruman`.

So the credentials are LegolasSaruman 

#### Get the MD5 of the credentials as the challenge description 
``` bash 
echo -n "LegolasSaruman" | md5sum 
```

We found also 
```java
public String Validate(String f) {
        StringBuilder str = new StringBuilder(f);
        for (int i = 0; i < str.length(); i++) {
            for (int j = i; j < str.length() - 1; j++) {
                char t = str.charAt(j);
                str.setCharAt(j, str.charAt(j + 1));
                str.setCharAt(j + 1, t);
            }
        }
        if (str.toString().equals(String.valueOf(new char[]{'l', 'g', 'c', 'n', 'y', 'u', 'r', 'V', 'r', '3', '4', 'd', '0', 'D', 'f', '{', '_', '_', '3', '_', 'R', '}', '4', '3', 'n', 'a', '5', '0', '1'}))) {
            Toast.makeText(getApplicationContext(), String.valueOf(new char[]{'C', 'o', 'r', 'r', 'e', 'c', 't'}), 1).show();
        }
        return "" + str.toString();
    }
```
### Code Explanation 
1. `Input and Initialization`: It takes a String parameter `f` and initializes a `StringBuilder` object `str` with the input string.

2. `String Shuffling (swapping)`: It uses two nested `for` loops to repeatedly swap characters within the string. The inner loop goes through the string, and in each iteration, it swaps the character at index `j` with the character at index `j+1`. This process seems to result in the string being shuffled or reordered.

3. `Validation`: After the shuffling, the method compares the modified string (`str.toString()`) with a specific target string that appears to be a hardcoded sequence of characters.

4. `Toast Message`: If the shuffled string matches the target sequence exactly, a "Correct" message is displayed using `Toast.makeText`.

5. `Return`: Finally, the method returns the **shuffled string**.

*You can use [rev.py](rev.py) to reverse the logic*

flag : flag{c4n_y0u_r3V3r53_4ndR01D}

>Find More on ==> github.com/MedhatHassan 