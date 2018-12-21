# CSX42: Assignment 2
## Name: VARUN SAXENA 

-----------------------------------------------------------------------
-----------------------------------------------------------------------


Following are the commands and the instructions to run ANT on your project:
#### Note: build.xml is present in studentCoursesBackup/src folder.

-----------------------------------------------------------------------
## Instruction to clean:

####Command: ant -buildfile studentCoursesBackup/src/build.xml clean

Description: It cleans up all the .class files that were generated when you
compiled your code.

-----------------------------------------------------------------------
## Instruction to compile:

####Command: ant -buildfile studentCoursesBackup/src/build.xml all

Description: Compiles your code and generates .class files inside the BUILD folder.

-----------------------------------------------------------------------
## Instruction to run:

####Command: ant -buildfile studentCoursesBackup/src/build.xml run -Darg0=<input_file.txt> -Darg1=<delete_file.txt> -Darg2=<output1_file.txt> -Darg3=<output2_file.txt> -Darg4=<output3_file.txt>

Note: Arguments accept the absolute path of the files.


-----------------------------------------------------------------------
## Description:
1. Navigate into the directory studentCoursesBackup. 
2. Execute the above commands to compile and run the code and clean command to delete the jar files.
3. Arguments needs to accept the absolute path in the file. 
Ex. ant -buildfile studentCoursesBackup/src/build.xml run -Dargs=/home/codestack/Desktop/input.txt 
As it displays the complete location.
4. Tree used is Binary Search Tree: 
Insert - O(n) 
Search - O(n)
Delete - O(n)
5. It uses Observer pattern to display the result. Data enters the BST Node and follows the Observer Pattern.
6. Pass the correct number of Arguments. There should be five arguments while passing the arguments.

References:
1. Data Structures & Algorithms in Java(second edition) by Robert Lafore, page # (406-410).
2. https://www.google.com/search?client=ubuntu&hs=s9d&channel=fs&ei=JLC7W_TqF4yGsQXXupKgCQ&q=bst+with+two+arguments+java&oq=bst+with+two+arguments+&gs_l=psy-ab.1.2.33i22i29i30l8.8355.8355..10513...0.0..0.110.110.0j1......0....1..gws-wiz.......0i71.4u3MW7c0RA0
3. https://introcs.cs.princeton.edu/java/44st/BST.java.html
4. https://algorithms.tutorialhorizon.com/binary-search-tree-complete-implementation
5. https://github.com/dblandin/Binary-Search-Tree/blob/master/BinarySearchTree.java
6. https://gist.github.com/aaronjwood/3b4aaa2a4792d7cf2df4
7. https://gist.github.com/gtke/4656846
8. https://github.com/dherath/CS_Design_Patterns_A2/tree/master/studentCoursesBackup/src/studentCoursesBackup

-----------------------------------------------------------------------
### Academic Honesty statement:
-----------------------------------------------------------------------

"I have done this assignment completely on my own. I have not copied
it, nor have I given my solution to anyone else. I understand that if
I am involved in plagiarism or cheating an official form will be
submitted to the Academic Honesty Committee of the Watson School to
determine the action that needs to be taken. "

Date: -- October 10, 2018

