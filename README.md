![example workflow](https://github.com/andrewfitzy/2015-advent-of-code/actions/workflows/build_and_test.yml/badge.svg)
# 2015-advent-of-code

This repo contains the solutions for my path of Advent of Code 2015. I complete AoC to get familiar with a technology, its build tools and testing tools, it's kind of a mini-production type workflow I follow.

In this year I chose to use the following tools:
- [Java v19.0.1](https://openjdk.org/projects/jdk/19/). I have the OpenJDK version of the JDK on my machine so this is the version I have used. I know there are other versions available but in theory they are all interchangeable, right... right? 
- [Gradle v8.1.1](https://docs.gradle.org/8.1.1/release-notes.html). From April 2023 which is when I set up this repo. 
- [Spotless v6.12.0](https://github.com/diffplug/spotless/releases/tag/gradle%2F6.12.0). Also using the Palantir formatting configuration [v2.28.0](https://github.com/palantir/palantir-java-format/releases/tag/2.28.0).
- [SpotBugs v6.0.4](https://github.com/spotbugs/spotbugs-gradle-plugin/releases/tag/6.0.4). Code analysis tool which is useful for finding bugs. 
- [JUnit v5.8.1](https://junit.org/junit5/docs/5.8.1/release-notes/). Unit test framework.

All development was completed using IntelliJ which is an awesome development environment. 

## Building
```bash
$ ./gradlew build  
```

## Testing
```bash
$ ./gradlew check  
```

## Committing
I couldn't get pre-commit to work so there are no automated checks on commit. This means that I've been running the following for each commit...
```bash
$ ./gradlew spotlessApply  
$ ./gradlew spotbugsMain
$ git add --all
$ git commit -a
```
With the list of commands above, I've run spotless and spotbugs separately, this is because I didn't want to run the whole test suite before every commit, I have a GitHub actions file setup for this. If I had a pre-commit hook set up, the spotless and spotbugs tasks are the ones that would be run so the result of these actions is not different to if they were automatically triggered.

## Progress
|                                                | Challenge                         |                                                          Task 1                                                           |                                                          Task 2                                                           |
|:-----------------------------------------------|:----------------------------------|:-------------------------------------------------------------------------------------------------------------------------:|:-------------------------------------------------------------------------------------------------------------------------:|
| [Day 01](https://adventofcode.com/2015/day/1)  | Not Quite Lisp                    | [🌟](https://github.com/andrewfitzy/2015-advent-of-code/blob/main/src/main/java/io/github/andrewfitzy/day_01/Task01.java) | [🌟](https://github.com/andrewfitzy/2015-advent-of-code/blob/main/src/main/java/io/github/andrewfitzy/day_01/Task02.java) |
| [Day 02](https://adventofcode.com/2015/day/2)  | I Was Told There Would Be No Math | [🌟](https://github.com/andrewfitzy/2015-advent-of-code/blob/main/src/main/java/io/github/andrewfitzy/day_02/Task01.java) | [🌟](https://github.com/andrewfitzy/2015-advent-of-code/blob/main/src/main/java/io/github/andrewfitzy/day_02/Task02.java) |
| [Day 03](https://adventofcode.com/2015/day/3)  | Perfectly Spherical Houses in a Vacuum | [🌟](https://github.com/andrewfitzy/2015-advent-of-code/blob/main/src/main/java/io/github/andrewfitzy/day_03/Task01.java) | [🌟](https://github.com/andrewfitzy/2015-advent-of-code/blob/main/src/main/java/io/github/andrewfitzy/day_03/Task02.java) |
| [Day 04](https://adventofcode.com/2015/day/4)  | The Ideal Stocking Stuffer | [🌟](https://github.com/andrewfitzy/2015-advent-of-code/blob/main/src/main/java/io/github/andrewfitzy/day_04/Task01.java) | [🌟](https://github.com/andrewfitzy/2015-advent-of-code/blob/main/src/main/java/io/github/andrewfitzy/day_04/Task02.java) |
| [Day 05](https://adventofcode.com/2015/day/5)  | Doesn't He Have Intern-Elves For This? | [🌟](https://github.com/andrewfitzy/2015-advent-of-code/blob/main/src/main/java/io/github/andrewfitzy/day_05/Task01.java) | [🌟](https://github.com/andrewfitzy/2015-advent-of-code/blob/main/src/main/java/io/github/andrewfitzy/day_05/Task02.java) |
| [Day 06](https://adventofcode.com/2015/day/6)  | Probably a Fire Hazard | [🌟](https://github.com/andrewfitzy/2015-advent-of-code/blob/main/src/main/java/io/github/andrewfitzy/day_06/Task01.java) | [🌟](https://github.com/andrewfitzy/2015-advent-of-code/blob/main/src/main/java/io/github/andrewfitzy/day_06/Task02.java) |
| [Day 07](https://adventofcode.com/2015/day/7)  | Some Assembly Required | [🌟](https://github.com/andrewfitzy/2015-advent-of-code/blob/main/src/main/java/io/github/andrewfitzy/day_07/Task01.java) | [🌟](https://github.com/andrewfitzy/2015-advent-of-code/blob/main/src/main/java/io/github/andrewfitzy/day_07/Task02.java) |
| [Day 08](https://adventofcode.com/2015/day/8)  | Matchsticks | [🌟](https://github.com/andrewfitzy/2015-advent-of-code/blob/main/src/main/java/io/github/andrewfitzy/day_08/Task01.java) | [🌟](https://github.com/andrewfitzy/2015-advent-of-code/blob/main/src/main/java/io/github/andrewfitzy/day_08/Task02.java) |
| [Day 09](https://adventofcode.com/2015/day/9)  | All in a Single Night | [🌟](https://github.com/andrewfitzy/2015-advent-of-code/blob/main/src/main/java/io/github/andrewfitzy/day_09/Task01.java) | [🌟](https://github.com/andrewfitzy/2015-advent-of-code/blob/main/src/main/java/io/github/andrewfitzy/day_09/Task02.java) |
| [Day 10](https://adventofcode.com/2015/day/10) | Elves Look, Elves Say | [🌟](https://github.com/andrewfitzy/2015-advent-of-code/blob/main/src/main/java/io/github/andrewfitzy/day_10/Task01.java) | [🌟](https://github.com/andrewfitzy/2015-advent-of-code/blob/main/src/main/java/io/github/andrewfitzy/day_10/Task02.java) |
| [Day 11](https://adventofcode.com/2015/day/11) | Corporate Policy | [🌟](https://github.com/andrewfitzy/2015-advent-of-code/blob/main/src/main/java/io/github/andrewfitzy/day_11/Task01.java) | [🌟](https://github.com/andrewfitzy/2015-advent-of-code/blob/main/src/main/java/io/github/andrewfitzy/day_11/Task02.java) |
| [Day 12](https://adventofcode.com/2015/day/12) | JSAbacusFramework.io | [🌟](https://github.com/andrewfitzy/2015-advent-of-code/blob/main/src/main/java/io/github/andrewfitzy/day_12/Task01.java) | [🌟](https://github.com/andrewfitzy/2015-advent-of-code/blob/main/src/main/java/io/github/andrewfitzy/day_12/Task02.java) |
| [Day 13](https://adventofcode.com/2015/day/13) | Knights of the Dinner Table | [🌟](https://github.com/andrewfitzy/2015-advent-of-code/blob/main/src/main/java/io/github/andrewfitzy/day_13/Task01.java) | [🌟](https://github.com/andrewfitzy/2015-advent-of-code/blob/main/src/main/java/io/github/andrewfitzy/day_13/Task02.java) |
| [Day 14](https://adventofcode.com/2015/day/14) | Reindeer Olympics | [🌟](https://github.com/andrewfitzy/2015-advent-of-code/blob/main/src/main/java/io/github/andrewfitzy/day_14/Task01.java) | [🌟](https://github.com/andrewfitzy/2015-advent-of-code/blob/main/src/main/java/io/github/andrewfitzy/day_14/Task02.java) |
| [Day 15](https://adventofcode.com/2015/day/15) | Science for Hungry People | [🌟](https://github.com/andrewfitzy/2015-advent-of-code/blob/main/src/main/java/io/github/andrewfitzy/day_15/Task01.java) | [🌟](https://github.com/andrewfitzy/2015-advent-of-code/blob/main/src/main/java/io/github/andrewfitzy/day_15/Task02.java) |
| [Day 16](https://adventofcode.com/2015/day/16) | Aunt Sue | [🌟](https://github.com/andrewfitzy/2015-advent-of-code/blob/main/src/main/java/io/github/andrewfitzy/day_16/Task01.java) | [🌟](https://github.com/andrewfitzy/2015-advent-of-code/blob/main/src/main/java/io/github/andrewfitzy/day_16/Task02.java) |
| [Day 17](https://adventofcode.com/2015/day/17) | No Such Thing as Too Much | [🌟](https://github.com/andrewfitzy/2015-advent-of-code/blob/main/src/main/java/io/github/andrewfitzy/day_17/Task01.java) | [🌟](https://github.com/andrewfitzy/2015-advent-of-code/blob/main/src/main/java/io/github/andrewfitzy/day_17/Task02.java) |
| [Day 18](https://adventofcode.com/2015/day/18) | Like a GIF For Your Yard | [🌟](https://github.com/andrewfitzy/2015-advent-of-code/blob/main/src/main/java/io/github/andrewfitzy/day_18/Task01.java) | [🌟](https://github.com/andrewfitzy/2015-advent-of-code/blob/main/src/main/java/io/github/andrewfitzy/day_18/Task02.java) |
| [Day 19](https://adventofcode.com/2015/day/19) | Medicine for Rudolph | [🌟](https://github.com/andrewfitzy/2015-advent-of-code/blob/main/src/main/java/io/github/andrewfitzy/day_19/Task01.java) | [🌟](https://github.com/andrewfitzy/2015-advent-of-code/blob/main/src/main/java/io/github/andrewfitzy/day_19/Task02.java) |
| [Day 20](https://adventofcode.com/2015/day/20) | Infinite Elves and Infinite Houses | [🌟](https://github.com/andrewfitzy/2015-advent-of-code/blob/main/src/main/java/io/github/andrewfitzy/day_20/Task01.java) | [🌟](https://github.com/andrewfitzy/2015-advent-of-code/blob/main/src/main/java/io/github/andrewfitzy/day_20/Task02.java) |
| [Day 21](https://adventofcode.com/2015/day/21) | RPG Simulator 20XX | [🌟](https://github.com/andrewfitzy/2015-advent-of-code/blob/main/src/main/java/io/github/andrewfitzy/day_21/Task01.java) | [🌟](https://github.com/andrewfitzy/2015-advent-of-code/blob/main/src/main/java/io/github/andrewfitzy/day_21/Task02.java) |
| [Day 22](https://adventofcode.com/2015/day/22) | Wizard Simulator 20XX | [🌟](https://github.com/andrewfitzy/2015-advent-of-code/blob/main/src/main/java/io/github/andrewfitzy/day_22/Task01.java) | [🌟](https://github.com/andrewfitzy/2015-advent-of-code/blob/main/src/main/java/io/github/andrewfitzy/day_22/Task02.java) |
| [Day 23](https://adventofcode.com/2015/day/23) | Opening the Turing Lock | [🌟](https://github.com/andrewfitzy/2015-advent-of-code/blob/main/src/main/java/io/github/andrewfitzy/day_23/Task01.java) | [🌟](https://github.com/andrewfitzy/2015-advent-of-code/blob/main/src/main/java/io/github/andrewfitzy/day_23/Task02.java) |
| [Day 24](https://adventofcode.com/2015/day/24) | It Hangs in the Balance | [🌟](https://github.com/andrewfitzy/2015-advent-of-code/blob/main/src/main/java/io/github/andrewfitzy/day_24/Task01.java) | [🌟](https://github.com/andrewfitzy/2015-advent-of-code/blob/main/src/main/java/io/github/andrewfitzy/day_24/Task02.java) |
| [Day 25](https://adventofcode.com/2015/day/25) | Let It Snow | [🌟](https://github.com/andrewfitzy/2015-advent-of-code/blob/main/src/main/java/io/github/andrewfitzy/day_25/Task01.java) |                                                                                                                           |