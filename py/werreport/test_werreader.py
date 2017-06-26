import unittest
from werreader import werreader

class Testwerreader(unittest.TestCase):
    def test_Object_create(self):
        try:
            a = werreader()
        except:
            self.fail("Konnte Objekt nicht erstellen.")
    def test_werreader_read(self):
        a = werreader()
        try:
            x = a.read("Report.wer")
        except:
            self.fail("Could not Read File")










if __name__ == "__main__":
    unittest.main()