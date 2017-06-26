from ConfigParser import SafeConfigParser
import os
from uuid import getnode as get_mac
import json
import requests
class werreader(object):
    def __init__(self):
        self.version = ""
        self.EventType = ""
        self.EventTime = ""
        self.ReportIdentifier = ""
        self.Bucketid = ""
        self.AppName = ""
        self.AppPath = ""
        self.uname = ""
        self.mac = ""

    def read(self, path):
        self.path = str(path)

        #FIX FOR READING WITH CONFIG PARSER

        sourceEncoding = "utf-16"
        targetEncoding = "utf-8"
        source = open(self.path,"rb")
        target = open(self.path+"fixed", "w")
        target.write("11111\n")   #If it looks stupid but it works it aint stupid
        target.write(unicode(source.read(), sourceEncoding).encode(targetEncoding))
        target.close()
        source.close()

        #FIXING SECTION HEADER for ConfigParser
        fix = open(self.path+"fixed","r+")
        fix.seek(0, 0)
        fix.write("[wer]\n")
        fix.close()

        self.uname = os.getenv('username')

        # GET PC MAC ADDR
        mac = get_mac()
        self.mac = ':'.join(("%012X" % mac)[i:i + 2] for i in range(0, 12, 2))

        #READING
        parser = SafeConfigParser()
        parser.read(self.path+"fixed")

        self.AppName = parser.get("wer", "AppName")
        self.AppPath = parser.get("wer", "AppPath")
        self.version = parser.get("wer","Version")
        self.EventType = parser.get("wer","EventType")
        self.EventTime = parser.get("wer","EventTime")
        #self.ReportIdentifier = parser.get("wer","ReportIdentifier")
        self.Bucketid = parser.get("wer","Response.BucketId")

        self.EventTime = float(self.EventTime)


        return self.AppName,self.AppPath,self.version,self.uname,self.mac,self.EventType,self.Bucketid,self.EventTime


os.system("dir C:\ProgramData\Microsoft\Windows\WER\ReportQueue\ /b *.wer /s /A-D /o:gn>Reports.txt")

#out = open("out.txt", "w")
jout = open("json.txt","w")


#get IP and Port for REST Connection

opt = SafeConfigParser()
opt.read("config.ini")
ip = opt.get("config","server")
port = opt.get("config","port")




a = werreader()
#x = a.read("C:\ProgramData\Microsoft\Windows\WER\ReportQueue\AppCrash_AD2F1837.HPPrint_7abab9a238d31ce95943fa32488e7ff1e0ef441f_8eaf7b11_2e13e4ac\Report.wer")
#print x
with open('Reports.txt') as fp:
    for line in fp:
        print str(line)
        try:
            x = a.read(str(line.rstrip("\n")))
            print x
            print type(x)
            jsonfile = json.dumps({ "appName": x[0], "appPath": x[1], "Version": x[2], "userName": x[3],"macAddress" : x[4], "eventType" : x[5], "bucketId": x[6], "eventTime": x[7]})
            jout.write(str(jsonfile+"\n"))
            #out.write(str(x)+"\n")

            #Send JSON
            #url = "http://"+ip+":"+port+"/rest/report"
            #response = requests.post(url, data=jsonfile)
        except:
            "No Report found"


