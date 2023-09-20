#!/bin/sh

sed 's/[[:space:]]\+/\n/g' | tr -s "\n"
