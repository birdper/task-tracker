# Task tracker

Web API for entering project data into the database (task tracker)

## Functional requirements
- Ability to create / view / edit / delete information about projects
- Ability to create / view / edit / delete task information
- Ability to add and remove tasks from a project (one project can contain
several tasks)
- Ability to view all tasks in the project  

### Each task should be a part of only one project

### Project
- the name of the project
- project start
- project completion date
- the current status of the project (enum: NotStarted, Active, Completed)
- priority (int)

### Task
- task name
- description
- task status (enum: ToDo / InProgress / Done)
- priority (int)
