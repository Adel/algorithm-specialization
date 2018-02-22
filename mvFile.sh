#!/usr/bin/env bash
# used to copy a file stripping first line (package name) to root directory for easy submissions
filename="${1##*/}"
cp "$1" "${PWD}/$filename"
tail -n +2 "$filename" > "$filename.tmp" && mv "$filename.tmp" "$filename"