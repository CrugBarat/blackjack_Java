# BlackJack

This exercise was tasked to me by CodeClan, Glasgow where I studied towards a PDA Level 8 in Professional Software Development. The exercise brief can be found below.

**Brief**

Simulate a game of “BlackJack”

To start off with you should be working in a TDD fashion and creating tests for your classes.

**MVP**

- Deal two cards to a dealer and a player
- Compare the hands
- Determine the winner from who has the highest value hand

**Extension**
- Allow the player to “twist” or “stick”
- Player go bust if hand value exceeds 21 and they automatically lose the round
- Dealer will twist if hand < 16
- Compare hands once both dealer and player have stuck.
- Allow for more players to play

---

# BlackJack Rules

- Aces may be counted as 1 or 11 points
- 2 to 9 according to card value
- Tens & face cards count as ten points

The value of a hand is the sum of the point values of the individual cards.

Except, "BlackJack", which consists of an ace and any 10-point card, which outranks all other 21-point hands.

To start, the dealer will give two cards to each player and two cards to them self. One of the dealer cards is dealt face up.

Play begins with the player to the dealer’s left.

The following are the choices available to the player:

- Stand: Player stands pat with his cards
- Twist: Player draws another card (and more if they wish)
- If this card causes the player’s total points to exceed 21 then they loses

The following are the choices available to the dealer:

- After each player has had their turn, the dealer will turn over their hole card
- If the dealer has 16 or less, then they will draw another card
- If the dealer goes over 21 points, then any player who didn’t already bust wins
- If the dealer does not bust, then the higher point total between the player and dealer will win
