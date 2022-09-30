# SolLolmon
SolLolmon is an aide to train for problem solving through question of the day. 

## History

### The Question of Sol
Sol means day, a daily ration. 
For people who train in problem-solving, including a practice problem in a sol
— especially when the sol contains stress — 
helps a lot over the days.
This ritual is called Question of the Sol. 

### Lolmon at UBC Math
Question of the Sol brought life to UBC Undergrad Math Society's discord server.
When questions were posted daily over 3 months, animated exchange developed, involving a growing participant base.
It made me, Lolmon, particularly happy.

This ritual required **a sacrifice** - a server member, driven to bring a problem to the server every day. 
They begin by procuring the daily problem, followed by a solution. 
The sacrifice's consistent effort would encourage others to discuss Question of the Sol, give solutions, and nominate questions for the Sol.
Since this process is human, the integrity and persona of the sacrifice are important: 
they must attempt the daily question with perseverance,
build up understanding with the server regarding skill level of the broad member body and themself,
and engage others in conversation.

This project aims to automate the sacrifice's duty and share it with a team, maintaining organization and transparency. 

## Project Proposal

### Data Structure
A question class has the following fields:
- question tex: a .tex file stored in project data
- contributor: who gave this problem to SolLolmon?
- source: where did the contributor find this problem? If it is original, what is its inspiration?
- date added: when did the contributor give this problem to SolLolmon?
- date(s) sealed: has this problem been chosen as Question of the Sol? When are its sols if so?
- solutions: list of solution classes
- seal: when this problem is to be/was presented as Question of the Sol, would/did it have pre-made solutions?
If there were no pre-made solutions, does its contributor have access to a solution through the source? 
- nutritional information: what theorems or discipline seem hopeful to the contributor for solving this problem? 

A solution class must be associated with a parent question class. It has the following fields:
- solution tex: a .tex file
- seal: is this solution prepared by the question contributor (accessed through question class)?
Or caught fresh on or after the day of SolLolmon's seal?
- contributor: who gave this solution to SolLolmon?
- source: how is the solution credit divided between the contributor, written texts, and other people?
- date added: some date later than question date added. 
- nutrient: record some named ideas that were used, eg. Hall's (thm)

A ritual involves
- name: what is the entity that the ritual serves? eg. Putnam
- collection of questions and their solutions
- a group of users: everyone in the group has permissions to execute all question and solution methods
- Sol count: count the Sols since this ritual is initiated

A user must be identified by
- username: to be identified in ritual, and to enter data through SolLolmon
- email: for receiving Question of the Sol

### On tick
In practical use, a tick will be a day. On each tick, for each ritual,
1. Select a question instance
2. Render a pdf of the question instance in Question of the Sol format, adding to statement tex:
   1. ritual name
   2. Sol count
   3. contributor
   4. date added
   5. source
   6. question seal
3. Push pdf to all users in ritual through email
4. Increment Sol number

### Any Time
1. Take text or file input through command line or GUI to 
   1. create question instances
   2. create solution instances
2. Allow user to edit fields in existing questions and solutions
3. Allow user to search for question and solution classes by any field
4. Store questions and solutions by Ritual, allowing multiple users in the same Ritual to access the Ritual.

***Rituals should be exported such that other projects, such as discord bots, can build on Rituals initiated in SolLolmon.***

<p align="right">
  <img src="https://i.pinimg.com/originals/05/5c/55/055c550ac2ddeabc7671489e05795114.jpg" alt="Solomon's seal." height="300"/>
</p>
<p align="right">
  Solomon's seal.
</p>

## Wish list: For Share
Possibly outside the scope of 210 project,
SolLolmon can be built into a discord bot to help the user run Question of the Sol for a group.
**On tick**, send the pdf in a discord server in step 3.  
**Any time**, let any server member perform these actions through commands on discord.

