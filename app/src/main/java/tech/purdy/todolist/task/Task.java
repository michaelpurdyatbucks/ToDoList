package tech.purdy.todolist.task;

import java.util.Date;
import java.util.UUID;

public class Task
{
    private UUID mId;
    private String title;
    private String description;
    private Date dueDate;
    private Date completedDate;

    public Task()
    {
        mId = UUID.randomUUID();
    }

    public UUID getId()
    {
        return mId;
    }

    public String getDueDateAsString()
    {
        String date = "";
        if (dueDate != null)
        {
            date = String.format("%s-%s-%s", dueDate.getMonth() + 1, dueDate.getDay() + 1, dueDate.getYear()+90);
        }
        return date;
    }

    public String getCompletedDateAsString()
    {
        return completedDate == null ? "" : completedDate.toString();
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

    public Date getDueDate()
    {
        return dueDate;
    }

    public void setDueDate(Date dueDate)
    {
        this.dueDate = dueDate;
    }

    public Date getCompletedDate()
    {
        return completedDate;
    }

    public void setCompletedDate(Date completedDate)
    {
        this.completedDate = completedDate;
    }

    public boolean isCompleted()
    {
        return getCompletedDate() == null ? false : true;
    }
}
