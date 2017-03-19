from ConfigParser import SafeConfigParser
import random
class werreader(object):
    def __init__(self):
        self.version = ""
        self.EventType = ""
        self.EventTime = ""
        self.ReportIdentifier = ""
        self.Bucketid = ""
        self.AppName = ""
        self.AppPath = ""

    def read(self, path):
        self.path = str(path)

        #FIX FOR READING WITH CONFIG PARSER

        sourceEncoding = "utf-16"
        targetEncoding = "utf-8"
        source = open(self.path,"rb")
        target = open(self.path+"fixed", "w")
        target.write(unicode(source.read(), sourceEncoding).encode(targetEncoding))
        target.close()
        source.close()

        #FIXING SECTION HEADER for ConfigParser
        fix = open(self.path+"fixed","r+")
        fix.seek(0, 0)
        fix.write("[wer]\n")
        fix.close()


        #READING
        parser = SafeConfigParser()
        parser.read(self.path+"fixed")

        self.version = parser.get("wer","Version")
        self.EventType = parser.get("wer","EventType")
        self.EventTime = parser.get("wer","EventTime")
        self.ReportIdentifier = parser.get("wer","ReportIdentifier")
        self.Bucketid = parser.get("wer","Response.BucketId")
        self.AppName = parser.get("wer","AppName")
        self.AppPath = parser.get("wer","AppPath")

        return self.version,self.EventType,self.EventTime, self.ReportIdentifier,self.Bucketid,self.AppName,self.AppPath


a = werreader()
a.read("C:\ProgramData\Microsoft\Windows\WER\ReportArchive\Critical_10.0.14393.1051__778caec5af73fbca2ceb0e035e75a8e59639bb_00000000_1c9c1ac0\Report.wer")