# Solve Ziggy
#### https://cybertalents.com/challenges/cryptography/ziggy

Challenge Description:
Sometimes combining two weak crypto algorithms won't be a bad idea, will it? decode the content of this file and get the message. Flag format: Flag{MESSAGE} Note: - all the message characters should be uppercase. - the message has meaning and its not a random text.

### T9 Decoding 
*You can use [decoder.py](decoder.py) script*

```bash
python decoder.py 
Decoded Message: SAHFIXODNLEEODPXIRCE
```
Note: this looks like another chipher because we have a key `At: 120`

### Rail Fence Cipher Decode
Docode with CyberChef -> Key = 10 , Offset = 120

flag : Flag{OLDXFASHIONEDXRECIPE}

### Resources
[T9 predictive text](https://en.wikipedia.org/wiki/T9_(predictive_text))
[CyberChef Rail Fence Cipher Decode](https://gchq.github.io/CyberChef/#recipe=Rail_Fence_Cipher_Decode(10,120)&input=U0FIRklYT0ROTEVFT0RQWElSQ0U)