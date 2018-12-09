package tech.purdy.todolist;

import android.app.Fragment;

public class TaskActivity extends SingleFragmentActivity
{
    @Override
    protected android.support.v4.app.Fragment createFragment()
    {
        return new TaskFragment();
    }
}
