#!/bin/bash

BASE="http://localhost:8080/lab07-student-server/students"

echo "========================================"
echo " Task 01 - CRUD Tests"
echo "========================================"

# a. GET all students
echo ""
echo "--- (a) GET all students ---"
curl -s -w "\nHTTP Status: %{http_code}\n" \
     -H "Content-Type: application/json" \
     "$BASE"

# b. POST - create new student
echo ""
echo "--- (b) POST - create new student ---"
curl -s -w "\nHTTP Status: %{http_code}\n" \
     -X POST \
     -H "Content-Type: application/json" \
     -d '{"name":"Kasun Pathirana","email":"kasun@eng.jfn.ac.lk","department":"Computer Engineering"}' \
     "$BASE"

# c. PUT - update email of student regNo=1
echo ""
echo "--- (c) PUT - update email of regNo=1 ---"
curl -s -w "\nHTTP Status: %{http_code}\n" \
     -X PUT \
     -H "Content-Type: application/json" \
     -d '{"email":"alice.updated@eng.jfn.ac.lk"}' \
     "$BASE/1"

# Verify update - GET single student regNo=1
echo ""
echo "--- Verify update: GET regNo=1 ---"
curl -s -w "\nHTTP Status: %{http_code}\n" \
     -H "Content-Type: application/json" \
     "$BASE/1"

# d. DELETE - delete student regNo=3
echo ""
echo "--- (d) DELETE - delete regNo=3 ---"
curl -s -w "\nHTTP Status: %{http_code}\n" \
     -X DELETE \
     "$BASE/3"

# Verify deletion - GET all should not contain regNo=3
echo ""
echo "--- Verify deletion: GET all students ---"
curl -s -w "\nHTTP Status: %{http_code}\n" \
     -H "Content-Type: application/json" \
     "$BASE"

echo ""
echo "========================================"
echo " Task 01 Tests Complete"
echo "========================================"
