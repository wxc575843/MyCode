#coding:utf-8
import urllib
str0='<a title="" target="_blank" href="http://blog.sina.com.cn/s/blog_4701280b0102egl0.html">地震思考录</a>'
title=str0.find('<a title')
print title
href=str0.find('href=')
print href
html=str0.find('.html')
print html
url=str0[href+6:html+5]
print url
content=urllib.urlopen(url).read()
print content
filename=url[-26:]
print filename
open(filename,'w').write(content)	
