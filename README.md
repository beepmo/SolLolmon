# SolLolmon
SolLolmon runs question of the day. 

## History

### The Question of Sol
Sol means day, a daily ration. 
Including a practice problem in a sol
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

This project aims to automate the sacrifice's task and share it with a team, maintaining organization and transparency. 

## Project Proposal

### Features
- Each sol, automatically post a stored question and any stored solution for the preceding day
- Add questions and solutions in store for all users; get accredited
- Keep track of:
  - source: how was the writeup found or inspired?
  - nutrition: theorems or disciplines pertaining to the problem
  - initial upload date of question and solution
  - status of each question's use in project


<p align="center">
  <img src="https://i.pinimg.com/originals/05/5c/55/055c550ac2ddeabc7671489e05795114.jpg" alt="Solomon's seal." height="300"/>
<p align="center">
   <i>P. odoratum thunberg</i>
<p align="center">
   Solomon's seal.
</p>

### Wish list: For Share
The store or question and solution should be exported such that other projects, 
such as discord bots, can use a database of questions and solutions collected in SolLolmon.

## User Stories

### Phase 1
As a user, I want to add questions to a project.

As a user, I want to search for a question from a project and add solutions to it.

As a user, I want to print a question of the sol on command.

When my contribution is selected as question of the sol, 
I want the preamble to include my name as well as attribution to any sources I used.

### Phase 2
As a user, I want to save all my contributions to file.

As a user, I want to load the entire project from file.


# Instructions for Grader

- You can generate the first required event related to adding Xs to a Y by the "Add question" button. 
Input some "inverted" inline latex: all text to be enclosed in \textrm and all math to just be.
  - For example paste this into dialog: 

     \textrm{Prove Cayley-Hamilton for } 2 \times 2 \textrm{matrices: }A^2 - \mathrm{tr}(A) + det|A|I = 0.
- You can generate the second required event related to adding Xs to a Y by clicking the "New day" button. 
This requires store to be non-empty.
A question will be sealed as the question of the day.
- You can locate my visual component by the beautifully rendered latex for
any question that you add (button: "Add question") or get for the day (button: "New day"), 
or all the questions in store (button: "Get store"). 
- You can save the state of my application by clicking the save button.
- You can reload the state of my application by selecting yes when prompted.

# Phase 4: Task 2

Below is console output on quit:

    =====================================================
    
    Event log of all that happened this session:
    
    Created project: SolLolmon
    
    Added question by Smon from source "Conversation" to SolLolmon
    
    Added question by Lolmon from source "Arvin's contribution to UBC math circles, from AoPS" to SolLolmon
    
    Added question by Lolmon from source "Macroeconmics simple multiplier" to SolLolmon
    
    Added question by Lolmon from source "stress" to SolLolmon
    
    Sealed a question to call it a day 10.
    
    Saved project: SolLolmon

# Phase 4: Task 3

Questions: 
- For ui classes which need user input in an `init` method 
to set up fields that have to be non-null for the application to run, 
do associations count as "not null after constructor complete"?
- Would `Main()` be included in UML?
- Are `Event` and `EventLog` dependencies of the logging part of model?