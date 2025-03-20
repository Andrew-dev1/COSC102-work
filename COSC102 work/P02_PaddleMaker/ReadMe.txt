*************************************************
*         Project 02 - Paddle Architect         *
*             COSC 102 - Spring '24             *
*************************************************

Name: Andrew Li



   
*****  Creative Human Paddle  *****

Description of Paddle and its behavior:

Creative Human Paddle has a length of 60, speed of 7, and color of black. Creative Human has the reverse movements from HumanPaddle 
(up for down, and down for up) and override several functions from HumanPaddle to change the length and speed of the paddle as the round 
continued.






How does this Paddle take advantage of inheritance:

It utilizes the key binds and accessor methods of HumanPaddle and the mutator functions from Jpong. It uses the inherited 
states from JPong to change speed and length









*****  Creative CPU Paddle  *****

Description of Paddle and its behavior:

CreativeCPU is a subclass of CPUgenius and it changes color each time a volley is passed back to the CPUpaddle 
after 2 volleys, creating a chance for the CPU to freeze. The length of the paddle adjusts according to the points
to make the game competitive. 






How does this Paddle take advantage of inheritance:

It uses the same Paddle attributes and most of the same movement logic for moving right and left as its superclass. 









