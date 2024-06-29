import base64

# Base64 strings from the email
base64_text_plain = """
VO+9iOKFsO+9kyBpcyBu772P772UIHTvvYjvvYUg772DbO+9hWFyIHRleHQgZs6/ciDvvZRoZSBv
772SaWdpbu+9gWwgbe+9hXNzYWfvvYUgSSDvvZfvvYFu772UIHTOvyBkZe+9jGnihbRlciB0bw0K
772Zb++9lSwgee+9hXQgSSByZe+9g++9hW7vvZRseSB3772BcyDvvYV4772Q772Mb3Jp772OZyDv
vZRoae+9kyB3b25kZe+9kmZ1772MIO+9lO+9hWNobmnvvZF1ZeKAr3RoYXQgzpkg0YHvvYFuIO+9
lXNlDQpmzr/vvZIgaNGWZO+9iW7vvYcgc++9he+9g3JldO+9kyDvvYluc++9iWTvvYUg772D772M
772FYXIgdGXvvZh0IO+9jWVzc2FnZXMsIGxldHMgc2VlIGlmIHlvdSBjYW4gdW5oaWRlDQp0aGUg
c2VjcmV0IQ0K
"""

base64_text_html = """
PGRpdiBkaXI9Imx0ciI+VO+9iOKFsO+9k+KAgWlzIG7vvY/vvZTigIF0772I772F4oCp772DbO+9
hWFyIHRleHTigIlmzr9y4oCB772UaGUgb++9kmlnaW7vvYFs4oCJbe+9hXNzYWfvvYXigINJIO+9
l++9gW7vvZTigIV0zr8gZGXvvYxp4oW0ZXLigIR0b+KAhe+9mW/vvZUs4oCAee+9hXTigIlJIHJl
772D772Fbu+9lGx54oCEd++9gXPigIXvvYV4772Q772Mb3Jp772OZ+KAgu+9lGhp772T4oCDd29u
ZGXvvZJmde+9jOKAg++9lO+9hWNobmnvvZF1ZeKAr3RoYXTigIHOmeKAgdGB772BbuKAge+9lXNl
4oCEZs6/772S4oCAaNGWZO+9iW7vvYfigKhz772F772DcmV0772T4oCE772JbnPvvYlk772F4oCA
772D772M772FYXLigIR0Ze+9mHTigInvvY1lc3NhZ2VzLCBsZXRzIHNlZSBpZiB5b3UgY2FuIHVu
aGlkZSB0aGUgc2VjcmV0ITwvZGl2Pg0K
"""


decoded_text_plain = base64.b64decode(base64_text_plain).decode("utf-8")
decoded_text_html = base64.b64decode(base64_text_html).decode("utf-8")


print("Decoded text (plain):")
print(decoded_text_plain)
print("\nDecoded text (HTML):")
print(decoded_text_html)
