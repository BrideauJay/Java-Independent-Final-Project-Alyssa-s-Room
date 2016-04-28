This project is designed to function as a level in a theoretical larger RPG/mystery game. 
The Player navigates a room, interacting with Items to gather information and find Clues to help solve a murder mystery.
In this level, there are three Items to interact with, and one Clue.
Can you find the Clue?
 / 
This commit has basically all functionality intact. The Player can move around inside the room using the arrow keys but cannot leave it, and no attention is paid to Furniture in moving (this may be changed in a future commit). When the Player is close enough to an Item and presses the space bar, they can get all the information for the Item they're close to, including the hint if the Item is a Clue. Pressing the X button will dismiss this alert.

 / 
 Goals for next commit: 
 - popup of controls upon launch that can be dismissed with the X button.
 - getting Player to avoid walking over Furniture in some way.
