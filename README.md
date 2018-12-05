# To Do List
Michael Purdy
CISC135 E59

## Overview
ToDoList is an application that helps manages tasks that need to be done.
It aims to be simple, so the user is not distracted from whats important - 
**getting stuff done**.


## Layout
![Design](docs/ToDoList.png?raw=true "Design")

## Tasks
They are why the user is here.
A Task is made up of the following attributes:
* title _Required_
* date completed
* description 
* date due

Tasks are either created or completed.

### Creating a Task
Tasks are created by pressing the New Task button.
A Title is all that is required for a Task to be made.
Upon task creation, the task is added to the task list.

### Viewing a Task
While a task can be viewed on the main screen, there may be times where a user needs to see more about the task.
This allows the user to view full descriptions in the case of truncated text.

_In future updates_, this is where the user would be able to edit tasks.

### Completing a Task
Tasks are completed by selecting touching the Task Status checkbox.
This then changes the tasks date completed field to the current date.
If a task is closed by accident, the user can uncheck the task, which would remove the completed date field.
```
if task is currently completed
  set the completed date to null (or maybe to 9999-12-31)
otherwise
  set the completed date to today
conditionally render the checkmark
```

### Displaying a task


## Limitations
There is no current implementation for task editing or deleting.
If a task needs to be fixed, the user should complete it and create a new one.
