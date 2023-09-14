#!/usr/bin/env python3

import sys
x = [word.strip() for word in sys.stdin if "q" in word.lower().replace("qu", "")]
print("Words with q but no u:", x)