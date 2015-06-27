This project is about Random number generation. Right now in this project there is only one function present. i.e it will return the value between 0-9. 

In future we will implement this random generator for generating random numbers up to a certain extent. Unlike other random generators this project does not use the inputs from mouse or key presses etc. Instead it used recursive hashing. and picks a random byte from it. It then converts the corresponding hex character to an integer. Depending on the users input the hash function compiles the random integer.


function <b>Random_Generator(int times);</b>

Times = How many times a user want to run the hash function to get a random number.

function <b> sha1(String s); </b>

Input a random string. In this project the random string is nothing but the epoch time. As hash functions are irreversible so there is no chance that people can recreate the original time. There are some other functions in the program do check it.


More functions will be added to this project in future.
