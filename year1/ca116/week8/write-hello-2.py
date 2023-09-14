#!/usr/bin/env python3

import sys
args = sys.argv[1]
file_name = args
message = "Hello world.\n"
with open(file_name, "w") as f_out:
    f_out.write(message)
