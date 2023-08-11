import urllib.request, urllib.parse, urllib.error
import json
import ssl

ctx = ssl.create_default_context()
ctx.check_hostname = False
ctx.verify_mode = ssl.CERT_NONE

url = input('Enter - ')
print('Retrieving ', url)
uh = urllib.request.urlopen(url, context=ctx)
data = uh.read().decode()

js = json.loads(data)

print('Retrieving', url)
print('Retrieved',len(data),'characters')
sum = 0
for i in js['comments']:
    sum = sum + i['count']
print('Sum:',sum)
print('Count:',len(js['comments']))
