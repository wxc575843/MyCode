#coding:utf-8
import urllib
import webbrowser
import time
page=1
url=['']*500
i=0
for page in xrange(1,8):
	con=urllib.urlopen('http://blog.sina.com.cn/s/articlelist_1191258123_0_'+str(page)+'.html').read()
	title=con.find(r'<a title=')
	href=con.find(r'href=',title)
	html=con.find(r'.html',href)
	while title!=-1 and href!=-1 and html!=-1:
		url[i]=con[href+6:html+5]
		print url[i], i
		i=i+1
		title=con.find(r'<a title=',html)
		href=con.find(r'href=',title)
		html=con.find(r'.html',href)
	else:
		print 'find end'	
j=0
while j < i :
	content=urllib.urlopen(url[j]).read()
	open(r'hanhan/'+url[j][-26:],'w+').write(content)
	print 'download', j, url[j]
	j=j+1
	# time.sleep(2)
else:
	print 'download article finished'
# webbrowser.open(url)
# print con