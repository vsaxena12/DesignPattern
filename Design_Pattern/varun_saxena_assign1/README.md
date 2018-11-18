# CSX42: Assignment 1
## Name: VARUN SAXENA

-----------------------------------------------------------------------
-----------------------------------------------------------------------


Following are the commands and the instructions to run ANT on your project.
#### Note: build.xml is present in coursesRegistration/src folder.

-----------------------------------------------------------------------
## Instruction to clean:

####Command: ant -buildfile coursesRegistration/src/build.xml clean

Description: It cleans up all the .class files that were generated when you
compiled your code.

-----------------------------------------------------------------------
## Instruction to compile:

####Command: ant -buildfile coursesRegistration/src/build.xml all

Description: Compiles your code and generates .class files inside the BUILD folder.

-----------------------------------------------------------------------
## Instruction to run:

####Command: ant -buildfile coursesRegistration/src/build.xml run -Darg0=<input_file.txt> -Darg1=<delete_file.txt>

Note: Arguments accept the absolute path of the files.


-----------------------------------------------------------------------
## Description:

STudentLevel decides the level of the student. If the student is in third year, 
highest priority will be given and so on.
Sort students based on their level. Assign courses according to the student level. 
registration_results.txt is generated in the folder coursesRegistration along 
with src.

Time Complexity of Scheduler -> O(n^2) in worst case

##References:
http://www.avajava.com/tutorials/lessons/how-do-i-read-a-string-from-a-file-line-by-line.html
https://www.geeksforgeeks.org/arraylist-in-java/
https://beginnersbook.com/2013/12/hashmap-in-java-with-example/

-----------------------------------------------------------------------
### Academic Honesty statement:
-----------------------------------------------------------------------

"I have done this assignment completely on my own. I have not copied
it, nor have I given my solution to anyone else. I understand that if
I am involved in plagiarism or cheating an official form will be
submitted to the Academic Honesty Committee of the Watson School to
determine the action that needs to be taken."

Date: -- September 26, 2018

