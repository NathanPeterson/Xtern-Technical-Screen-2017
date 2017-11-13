# Xtern-Technical-Screen-2017
Successful submission for Xtern 2017 Technical Screen

## My Implementation
Hits on all points discussed below, while also giving the user a full command line game experience. 
  * This includes using points to bet and earn prizes in the item shop
  * Error handling on all forms
  * Create Users
  * Multiple Users with their own scores and names
  * Different Difficulty levels
  * Get Item Info
  * Full backlog for every player
  * Gracfully Quit the Program
  
# Techpoint Given Problem: 
## The Background
A new cryptocurrency has hit the market called XternCoin, and you are the lead developer, product manager, IT analyst, and/or designer (depending on the role you are applying for in Xtern).

Like all cryptocurrencies, XternCoin has value because of the compute difficulty of solving cryptographic problems. What's our cryptographic problem? Guessing random numbers.

XternCoin users must guess random numbers. If they guess correctly, they are awarded a coin. Once they have coins, they can trade them with other users, buy things... all the normal stuff you can do with dollars. At least, that's the idea.

## The Problem
Right now, XternCoin is just an idea and a small spec.

Your job, should you choose to accept it, is to advance the creation of XternCoin in a way that best fits your background and skillset. Pick one of the sections below based upon the role you are applying for in Xtern. If your role isn't listed verbatim, read over them all and try your hand at something similar, or contact TechPoint (talent@techpoint.org) for more help.

## Scoring Criteria 
These are relatively open-ended questions. You can expect grading will be appropriately open-ended. If you can go above-and-beyond the prompt to produce something really cool, you can expect us to recognize that.

We know your time is valuable. You shouldn't have to spend more than an hour or two on this.


# Instructions
XternCoin operates like this: The "server" (your code you are writing) stores a single random number. Clients have to guess what this number is. If they guess correctly, the app awards them 1 coin and chooses a new random number for the next guess.

Today, we are going to write a few functions XternCoin's server will need.

  * func HandleGuess(userId string, guess int) bool {}
Function which takes a user's id and a user's guess, and returns whether or not their guess was correct.
  * func GetCoins(userId string) int {}
  * Function which takes a userid and returns how many coins they have.

Finally, one more function is required:
  * func StartGuessing() {}
  
A function which, when called, pretends to be a user of XternCoin and uses the other two functions you've written to accumulate coins by guessing random numbers in a loop (indefinite is fine).

Remember that users of XternCoin would only have access to the two functions you wrote above; they can't directly see what random number they are trying to guess, so this function will have to guess randomly as well.

It'd be a good idea to log every attempt you make, as well as a running count of how many coins you have. Here are some things you might consider:
  * State to store the number of coins each user has
  * State to store the current number clients are trying to guess
  * Logic to generate a new random number when the correct one is guessed

While the above three functions are all that is required of this assessment a full implementation may require more. If you’d like to demonstrate more of your awesome skills feel free to write a complete program. 


