#!/bin/bash

# Function to remove non-hex characters from a string
clean_hex_string() {
  local input_string="$1"
  # Remove any characters that are not 0-9, a-f, or A-f
  local cleaned_string=$(echo "$input_string" | sed 's/[^0-9a-fA-F]//g')
  echo "$cleaned_string"
}

if [ -z "$1" ]; then
  echo "Usage: $0 <string>"
  exit 1
fi

input_string="$1"

cleaned_string=$(clean_hex_string "$input_string")

echo "Cleaned Hex String: $cleaned_string"
