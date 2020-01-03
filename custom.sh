#!/bin/bash

mvn clean package
java -jar target/ox-?.?.jar $1