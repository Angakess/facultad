import re
data = input('Enter the data file: ')
text = open(data)
sum = 0
for line in text:
    x = re.findall('[0-9]+', line)
    for i in x:
        y = int(i)
        sum = sum + y
print(sum)
