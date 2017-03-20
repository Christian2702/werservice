import unittest
from config import ConfigParse

class TestConfigParse(unittest.TestCase):
    def test_config_read(self):
        try:
            a= ConfigParse()
        except:
            self.fail("Could not Create Object")

        try:
            a,b,c = a.config_read()
        except:
            self.fail("Could not find file or missing head")

        self.assertNotEquals(a,"")
        self.assertNotEquals(b,"")
        self.assertNotEquals(c,"")




if __name__ == "__main__":
    unittest.main()