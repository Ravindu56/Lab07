#!/bin/bash

echo ""
echo "########################################"
echo "#   EC9590 Lab 07 - Full Test Suite    #"
echo "########################################"

# Check server is up first
echo ""
echo "Checking server health..."
HTTP_CODE=$(curl -s -o /dev/null -w "%{http_code}" \
    "http://localhost:8080/lab07-student-server/students")

if [ "$HTTP_CODE" != "200" ]; then
    echo "ERROR: Server not running or not reachable."
    echo "Start it with: cd lab07-student-server && mvn spring-boot:run"
    exit 1
fi

echo "Server is UP (HTTP $HTTP_CODE)"
echo ""

bash test-task01.sh
echo ""
bash test-task02.sh

echo ""
echo "########################################"
echo "#           All Tests Done             #"
echo "########################################"
