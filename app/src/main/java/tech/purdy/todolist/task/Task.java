package tech.purdy.todolist.task;

import java.util.Date;
import java.util.UUID;

public class Task
{
    private UUID mId;
    private String title;
    private String description;
    private String dueDate;
    private String completedDate;

    public Task()
    {
        mId = UUID.randomUUID();
    }

    public UUID getId()
    {
        return mId;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public boolean isCompleted()
    {
        return getCompletedDate() == null ? false : true;
    }

    public String getDueDate()
    {
        return dueDate;
    }

    public void setDueDate(String dueDate)
    {
        this.dueDate = dueDate;
    }

    public String getCompletedDate()
    {
        return completedDate;
    }

    public void setCompletedDate(String completedDate)
    {
        this.completedDate = completedDate;
    }
}
