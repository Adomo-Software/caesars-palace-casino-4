Read about Caesars Palace Casino - https://en.wikipedia.org/wiki/The_Hangover 

Clone this template https://github.com/angliukas/task-template.git  

Rename it to correct one. The name must be in lower-case. The words of the name must be separetated by hiphens;

Replace classes by yours; 

Rename package name;

IMPORTANT requirements:

NO if-else, switch and similar statements!!!;

No if/else in for(…)

NO while(…) statements

NO classes in one file;

NO static classes;

NO abstract classes;

The floor should be EASY configured without rewriting a code;

Copy the task description to README ;

Your task is:

 Build casino which contains four/five floors. For example: 

Floor firstFloor = new FirstFloor(new Config(...));
Floor secondFloor = new SecondFloor(new Config(...));
or
FirstFloor firstFloor = new Casino(new Config(...));
SecondFloor secondFloor = new Casino(new Config(...));

A one of the floors is on reconstruction.

Implement elevator;

The elevator can be called only from the first floor;  From 1 to somewhere; No need to go back; It is for simplicity;

 The list of available floors should be printed. It can be done with the method or so;

the example of the list.

    4
    3
    
    1
    //the ordering is not important. It can be like so:
    1
    2 - under construction
    3
    4

 when guest  ask system to go to the floor which is under construction it should go nowhere;

 when guest ask system got 4th floor the trace of passed floors should be printed:  1, 2, 3, 4;

The main concept how to build the hotel you can find here:

https://docs.oracle.com/javase/tutorial/java/concepts/index.html

This Java documentation will help you to implement a solution:

https://docs.oracle.com/javase/tutorial/java/javaOO/index.html

https://docs.oracle.com/javase/tutorial/java/IandI/index.html
