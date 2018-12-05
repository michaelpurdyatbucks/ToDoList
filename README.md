# To Do List

Michael Purdy
CISC135 E59

## Overview

_To Do List_ is an application that helps manage tasks that need to be completed.
It aims to be simple, so the User is not distracted from whats important -
**getting stuff done**.

## Main Screen

This is where the User will spend the majority of their time in the application.
This is the main Activity.
![Main Screen](docs/MainScreen.png?raw=true "Main Screen")

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

Tasks can be created by touching the New Task button, which brings up the New Task screen.

![New Task Screen](docs/NewTaskScreen.png?raw=true "New Task Screen")

A title is the only required field for a task to be made.
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

Tasks can be viewed by touching a task.
This brings up the View Task screen.

![Task View Screen](docs/TaskViewScreen.png?raw=true "Task View Screen")

This allows Users an exploded view of a specific task.
This is particularly useful for viewing truncated text and for seeing a tasks completion date.

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