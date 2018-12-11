package tech.purdy.todolist.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import tech.purdy.todolist.R;

public class ToDoListActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_screen);
    }
}
