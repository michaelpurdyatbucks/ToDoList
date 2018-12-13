package tech.purdy.todolist.activity;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.UUID;

import tech.purdy.todolist.R;
import tech.purdy.todolist.fragment.TaskCreationFragment;
import tech.purdy.todolist.fragment.TaskDetailFragment;
import tech.purdy.todolist.fragment.TaskListFragment;

public class MainActivity extends AppCompatActivity
{
    private static final String TAG = "MainActivity";

    private static UUID mCurrentTaskUUID;
    private int lastActivity = 0;
    private SectionsStatePagerAdapter mSectionsStatePagerAdapter;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo_list);
        Log.d(TAG, "onCreate: Started.");

        mSectionsStatePagerAdapter = new SectionsStatePagerAdapter(getSupportFragmentManager());

        mViewPager = (ViewPager) findViewById(R.id.container);
        setupViewPager(mViewPager);
    }

    private void setupViewPager(ViewPager viewPager)
    {
        SectionsStatePagerAdapter adapter = new SectionsStatePagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new TaskListFragment(), "TaskListFragment");
        adapter.addFragment(new TaskCreationFragment(), "TaskCreationFragment");
        adapter.addFragment(new TaskDetailFragment(), "TaskDetailFragment");
        viewPager.setAdapter(adapter);
    }

    public void setViewPager(int fragmentNumber)
    {
        lastActivity = mViewPager.getCurrentItem();
        SectionsStatePagerAdapter adapter = (SectionsStatePagerAdapter) mViewPager.getAdapter();
        adapter.updateFragments();
        mViewPager.setCurrentItem(fragmentNumber);
    }

    @Override
    public void onBackPressed()
    {
        if (mViewPager.getCurrentItem() != 0) {
            mViewPager.setCurrentItem(lastActivity, true);
            lastActivity = 0;
        }else{
            finish();
        }
    }

    public static void setmCurrentTaskUUID(UUID uuid)
    {
        mCurrentTaskUUID = uuid;
    }

    public static UUID getmCurrentTaskUUID()
    {
        return mCurrentTaskUUID;
    }
}
