from ConfigParser import SafeConfigParser
from uuid import getnode as get_mac # for mac addr
import os # for current uname


class ConfigParse(object):

    def __init__(self):
        self.server = ""
        self.uname = ""
        self.mac = ""

    def config_read(self):

        parser = SafeConfigParser()
        parser.read('config.ini')

        self.server = parser.get('config', 'server')
        self.uname = parser.get('config', 'uname')
        self.mac = parser.get('config', 'mac')

        return self.server,self.uname,self.mac

    def config_write(self,server):


        # GET Windows uname
        self.uname = os.getenv('username')

        #GET PC MAC ADDR
        mac = get_mac()
        self.mac = ':'.join(("%012X" % mac)[i:i + 2] for i in range(0, 12, 2))


        config = open("config.ini","w")
        config.writelines("[config]\n")
        config.writelines("server="+str(server)+"\n")
        config.writelines("uname="+str(self.uname)+"\n")
        config.writelines("mac="+str(self.mac)+"\n")
"""
#test
a = ConfigParse()
a.config_write("127.0.0.1")
x,b,c = a.config_read()
print x,b,c
"""