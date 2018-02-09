#!/usr/bin/env bash

filename="${1##*/}"
cp "$1" "${PWD}/$filename"
tail -n +2 "$filename" > "$filename.tmp" && mv "$filename.tmp" "$filename"