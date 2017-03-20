import urllib
import urllib2


# Getting Data from REST url
url = ""
response_GET = urllib2.urlopen(url).read()


# POST Data to REST url
url = ""
params = urllib.urlencode({
  'att1': '1',
  'att2': '2'
})
response_POST = urllib2.urlopen(url, params).read()
