import urllib.request, urllib.parse, urllib.error
from bs4 import BeautifulSoup
import ssl

# Ignore SSL certificate errors
ctx = ssl.create_default_context()
ctx.check_hostname = False
ctx.verify_mode = ssl.CERT_NONE

url = input('Enter - ')
html = urllib.request.urlopen(url, context=ctx).read()
soup = BeautifulSoup(html, 'html.parser')

tags = soup('h2')
for tag in tags:
    print('Componente:', tag.contents[0])
    print('')

tags = soup('span')
for tag in tags:
    if tag.get('class') == 'price-tag-fraction':
        print('Precio:', tag.contents[0])
        print('')
