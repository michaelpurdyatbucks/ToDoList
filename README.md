# To Do List

Michael Purdy
CISC135 E59

## Overview

_To Do List_ is an application that helps manage tasks that need to be completed.
It aims to be simple, so the User is not distracted from whats important -
**getting stuff done**.

## Layout

### Main Screen

This is where the User will spend the majority of their time in the application.
This is the main Activity.
![Main Screen](docs/MainScreen.png?raw=true "Main Screen")

### New Task Screen

This is what the User is presented with when touching the New Task button.
This is how a new task is created.
![New Task Screen](docs/NewTaskScreen.png?raw=true "New Task Screen")

### Task View Screen

This is how the User is preseneted with when touching a task.
This expands the task details.

![Task View Screen](docs/TaskViewScreen.png?raw=true "Task View Screen")

## Tasks

Tasks are why the User is here.
They are the main purpose of the application.
A Task is made up of the following attributes:

* title - ___Required___
* date completed
* description
* date due

Tasks can be created, viewed, and completed.

### Creating a Task

Tasks are created by pressing the New Task button.
A Title is all that is required for a Task to be made.
Upon task creation, the task is added to the task list.

```psudocode
New Task button is touched
  User enters a Title
  User enters a Due Date
  User enters a Description
  User confirms
    create a new Task

    if the User provided a due date
      set the new Task's due date to the User input
    if the User provided a description
      set the new Task's description to the User input

    if the User provided a title
      set the new Task's title to the User input
      add the new Task to the Task List
    else
      cancel task creation
      show Toast saying a title is required
```

### Viewing a Task

While a task can be viewed on the main screen, there may be times where a User wants to see more about the task.
This allows the User to view full descriptions in the case of truncated text.

```psudocode
User touches the View Task button
  display/overlay View Task Activity(Fragment)
  display task title
  if task has a description
    display it
  if task has a due date
    display it
  if the task is completed
    display the completion date
```

### Completing a Task

Tasks are completed by touching the Task Status checkbox.
This changes the task date completed field to the current date.
If the User wants to un-complete a task, the User touoch the Task Status checkbox again, which would remove the completed date field.

```psudocode
User touches the Task Status checkbox
  if task is currently completed
    set the completed date to null
  otherwise
    set the completed date to today

render the checkmark accordingly
```