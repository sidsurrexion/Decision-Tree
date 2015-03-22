Instructions on how to compile and execute the code:

1. The main driver file for the project is Driver.java. This file is kept in the same project folder as other
JAVA files.

2. The Project Name is decisiontree and includes JAVA files and test files.

3. For compiling we run the command prompt as an administrator and reach the directory where
the project JAVA files have been kept. So in my case this has been;

C:\Users\Snow_Leopard\workspace\decisiontree\src\decisiontree>

4. Once the directory was reached, following command was provided;

C:\Users\Snow_Leopard\workspace\decisiontree\src\decisiontree>javac Driver.java

This compiles the code

5. After this we execute the code by giving the following command:

C:\Users\Snow_Leopard\workspace\decisiontree\src\decisiontree>java Driver

The input that would be asked would be;

Enter the file name: <file name is provided>

to-print:{yes,no} (To enter either yes/no)

And the decision tree will be generated for the above input

Note: You may observe that the test files are kept in two different folders within the project
folder. The reason of doing this was to run the code in both Eclipse and Command Prompt 
which recognized each different folder as the home folder. In the UNIX environment it will be
required to execute the file from the terminal window from the project location folder which
includes the JAVA files. 