# To Do List

Michael Purdy
CISC135 E59

## Overview

_To Do List_ is an application that helps manages tasks that need to be done.
It aims to be simple, so the user is not distracted from whats important - 
**getting stuff done**.

## Layout

### Main Screen

![Main Screen](docs/MainScreen.png?raw=true "Main Screen")

### New Task Screen

![New Task Screen](docs/NewTaskScreen.png?raw=true "New Task Screen")

## Tasks

They are why the user is here.
A Task is made up of the following attributes:

* title - ___Required___
* date completed
* description 
* date due

### Creating a Task

Tasks are created by pressing the New Task button.
A Title is all that is required for a Task to be made.
Upon task creation, the task is added to the task list.

```psudocode
New Task button is touched
  Create a new Task
  User enters a Title
  User enters a Due Date
  User enters a Description
  User confirms
    if the User provided a due date
      set the task's due date to the User input
    if the User provided a description
      set the task's description to the User input
    if the user provided a title
      set the task's title to the user input
      add the task to the Task List
    if the user did not provide a title
      Cancel task creation
      Show Toast saying a title is required
```

### Viewing a Task

While a task can be viewed on the main screen, there may be times where a user needs to see more about the task.
This allows the user to view full descriptions in the case of truncated text.

_In future updates_, this is where the user would be able to edit tasks.

### Completing a Task

Tasks are completed by touching the Task Status checkbox.
This then changes the tasks date completed field to the current date.
If the user wants to un-complete a task, the user touoch the Task Status checkbox again, which would remove the completed date field.

```psudocode
Task Status checkbox is touched
  if task is currently completed
    set the completed date to null
  otherwise
    set the completed date to today

render the checkmark accordingly
```

## Limitations

There is no current implementation for task editing or deleting.
If a task needs to be fixed, the user should complete it and create a new one.
