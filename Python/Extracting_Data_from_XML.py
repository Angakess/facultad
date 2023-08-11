import urllib.request, urllib.parse, urllib.error
import xml.etree.ElementTree as ET
import ssl

# Ignore SSL certificate errors
ctx = ssl.create_default_context()
ctx.check_hostname = False
ctx.verify_mode = ssl.CERT_NONE

url = input('Enter - ')
print('Retrieving ', url)
data = urllib.request.urlopen(url, context=ctx).read()
tree = ET.fromstring(data)
print('Retrieved ', len(data),' characters')
lst = tree.findall('comments/comment')
print('Count: ', len(lst))
sum = 0
for item in lst:
    sum = sum + int(item.find('count').text)
print('Sum: ', sum)
