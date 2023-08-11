import urllib.request, urllib.parse, urllib.error
from bs4 import BeautifulSoup
import ssl

ctx = ssl.create_default_context()
ctx.check_hostname = False
ctx.verify_mode = ssl.CERT_NONE

url = input('Enter URL: ')
html = urllib.request.urlopen(url, context=ctx).read()
soup = BeautifulSoup(html, 'html.parser')

count = input('Enter count: ')
count = int(count)
pos = input('Enter position: ')
pos = int(pos)

tags = soup('a')
for i in range(count):
    j = 0
    for tag in tags:
        j = j + 1
        if j == pos:
            url = tag.get('href', None)
            html = urllib.request.urlopen(url, context=ctx).read()
            soup = BeautifulSoup(html, 'html.parser')
            tags = soup('a')
            break
print(tag.contents[0])
