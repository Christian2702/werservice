from uuid import getnode as get_mac
mac = get_mac()

print ':'.join(("%012X" % mac)[i:i+2] for i in range(0, 12, 2))