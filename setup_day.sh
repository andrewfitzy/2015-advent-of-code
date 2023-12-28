#!/bin/bash

# Ask for the day
read -p 'Challenge Day: ' day

echo Initialising solution and test folder for day $day

# Copy the three directories and rename to contain the day
cp -R ./src/main/java/io/github/andrewfitzy/day_xx ./src/main/java/io/github/andrewfitzy/day_$day
cp -R ./src/test/java/io/github/andrewfitzy/day_xx ./src/test/java/io/github/andrewfitzy/day_$day
cp -R ./src/test/resources/day_xx ./src/test/resources/day_$day

# Then we'll replace xx in the src and test files with the day number
sed -i '' "s/xx/$day/g" ./src/main/java/io/github/andrewfitzy/day_$day/Task01.java
sed -i '' "s/xx/$day/g" ./src/main/java/io/github/andrewfitzy/day_$day/Task02.java
sed -i '' "s/xx/$day/g" ./src/test/java/io/github/andrewfitzy/day_$day/TestTask01.java
sed -i '' "s/xx/$day/g" ./src/test/java/io/github/andrewfitzy/day_$day/TestTask02.java


