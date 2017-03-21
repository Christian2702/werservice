import unittest
from config import ConfigParse

class TestConfigParse(unittest.TestCase):
    def test_config_read(self):
        try:
            a= ConfigParse()
        except:
            self.fail("Could not Create Object")



    def test_readconfig(self):
        a = ConfigParse()
        try:
            x,b,c = a.config_read()
        except:
            self.fail("Could not find file or missing head")

        self.assertNotEquals(x,"")
        self.assertNotEquals(b,"")
        self.assertNotEquals(c,"")

    def test_write_test(self):
        a = ConfigParse()
        try:
            a.config_write("127.0.0.1")
        except:
            self.fail("Could not write Config")
        self.assertNotEquals(a.uname, "")
        self.assertNotEquals(a.mac, "")



if __name__ == "__main__":
    unittest.main()