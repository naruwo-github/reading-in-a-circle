#!/bin/bash
mysql -u root -proot -D sandbox < 001-create-tables.sql

# NOTE: wait until the MySQL server to come up
