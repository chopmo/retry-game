# RETRY - the game

About a quarter of a game, implemented in ClojureScript. 

# Controls

* W: Thrust
* A: Rotate left
* D: Rotate right
* SPACE: Rewind time

# Original idea notes

## First iteration:
The playing field is on a single screen, no scrolling. The goal is to reach the right edge of the screen as fast as possible. The player is a triangle that starts at the left edge of the screen and can be controlled with three simple commands: Thrust, rotate left, rotate right. There are no obstacles and there is no gravity, but there is a drag effect that causes the player to gradually lose momentum. 

## Second iteration: 
There are a number of simple, stationary obstacles in the game world which the player needs to do dodge on his way to the right edge of the screen.wefwef If the player hits an obstacle, he dies. A stopwatch is shown during gameplay, and the top 5 times are displayed, with initials. The player is prompted to enter initials (up to three letters) if he makes the highscore list. w

## Third iteration: 
When the player dies, the world freezes but the stopwatch keeps running. The player can hold the space bar to rewind time in 2x realtime. Play resumes when the space bar is released, so the player should rewind as little as possible while still giving himself enough time to dodge the obstacle that killed him. The goal is the same as before, to complete the course as quickly as possible, measured in wall clock time. 

## Extras: 
 * Replays with and without deaths
 * Multiplayer

# Background

I wrote this while sitting in with a group of people who competed in Ludum Dare 2014 here in Aarhus, Denmark. I never intended to submit to the competition myself, but this gave me a great opportunity to play around with ClojureScript and get my hands dirty with some functional programming. 
