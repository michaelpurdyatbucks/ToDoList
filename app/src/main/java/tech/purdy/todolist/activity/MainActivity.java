package tech.purdy.todolist.activity;

import android.annotation.SuppressLint;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import tech.purdy.todolist.R;
import tech.purdy.todolist.fragment.TaskCreationFragment;
import tech.purdy.todolist.fragment.TaskListFragment;

public class MainActivity extends AppCompatActivity
{
    private static final String TAG = "MainActivity";

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
        SectionsStatePagerAdapter adapater = new SectionsStatePagerAdapter(getSupportFragmentManager());
        adapater.addFragment(new TaskListFragment(), "TaskListFragment");
        adapater.addFragment(new TaskCreationFragment(), "TaskCreationFragment");
        viewPager.setAdapter(adapater);
    }

    public void setViewPager(int fragmentNumber)
    {
        SectionsStatePagerAdapter adapater = (SectionsStatePagerAdapter) mViewPager.getAdapter();
        adapater.updateFragments();
        mViewPager.setCurrentItem(fragmentNumber);
    }

    @Override
    public void onBackPressed()
    {
        if (mViewPager.getCurrentItem() != 0) {
            mViewPager.setCurrentItem(mViewPager.getCurrentItem() - 1,false);
        }else{
            finish();
        }
    }
}
