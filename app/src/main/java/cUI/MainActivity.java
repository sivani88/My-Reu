package cUI;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.Toolbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.maru.R;
import com.example.maru.databinding.ActivityMainBinding;
import com.example.maru.databinding.ToolbarBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding mBinding;
    ToolbarBinding mToolbarBinding;
    Toolbar mToolbar;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());

        

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.add_filter_menu, menu);
        return true;
    }
}
