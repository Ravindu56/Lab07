#!/bin/bash

SECURE="http://localhost:8080/lab07-student-server/students/secure/1"
VALID_CREDS=$(echo -n "student:password123" | base64)
WRONG_CREDS=$(echo -n "wronguser:wrongpass" | base64)
MALFORMED_CREDS="Tk9UVkFMSURCQVNFNjQ="

echo "========================================"
echo " Task 02 - HTTP Basic Auth Tests"
echo "========================================"

# Test 1: No Authorization header -> expect 401
echo ""
echo "--- Test 1: NO Authorization header (expect 401) ---"
curl -s -w "\nHTTP Status: %{http_code}\n" \
     -H "Content-Type: application/json" \
     "$SECURE"

# Test 2: Wrong credentials -> expect 401
echo ""
echo "--- Test 2: WRONG credentials (expect 401) ---"
echo "Sending: Basic $WRONG_CREDS"
curl -s -w "\nHTTP Status: %{http_code}\n" \
     -H "Content-Type: application/json" \
     -H "Authorization: Basic $WRONG_CREDS" \
     "$SECURE"

# Test 3: Valid credentials via header -> expect 200
echo ""
echo "--- Test 3: VALID credentials via header (expect 200) ---"
echo "Sending: Basic $VALID_CREDS"
curl -s -w "\nHTTP Status: %{http_code}\n" \
     -H "Content-Type: application/json" \
     -H "Authorization: Basic $VALID_CREDS" \
     "$SECURE"

# Test 4: curl --user flag (mirrors Authenticator class behaviour) -> expect 200
echo ""
echo "--- Test 4: curl --user flag = Authenticator class behaviour (expect 200) ---"
curl -s -w "\nHTTP Status: %{http_code}\n" \
     -H "Content-Type: application/json" \
     --user "student:password123" \
     "$SECURE"

# Test 5: Malformed Base64 -> expect 401
echo ""
echo "--- Test 5: Malformed credentials (expect 401) ---"
echo "Sending: Basic $MALFORMED_CREDS"
curl -s -w "\nHTTP Status: %{http_code}\n" \
     -H "Content-Type: application/json" \
     -H "Authorization: Basic $MALFORMED_CREDS" \
     "$SECURE"

echo ""
echo "========================================"
echo " Task 02 Tests Complete"
echo "========================================"
