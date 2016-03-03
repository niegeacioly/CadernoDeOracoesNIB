package nib.org.br.oracoes.app.view.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import nib.org.br.oracoes.R;
import nib.org.br.oracoes.app.data.DatabaseManager;
import nib.org.br.oracoes.app.presenter.MainPresenter;
import nib.org.br.oracoes.app.presenter.impl.MainPresenterImpl;
import nib.org.br.oracoes.app.presenter.view.MainView;
import nib.org.br.oracoes.app.view.adapter.WeekPrayerViewPagerAdapter;
import nib.org.br.oracoes.app.view.fragment.PrayerListFragment;

public class MainActivity extends AppCompatActivity implements MainView {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private MainPresenter presenter;

    public MainActivity(){
        DatabaseManager.init(getBaseContext());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.main_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        viewPager = (ViewPager) findViewById(R.id.viewpager_week_prayers);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.main_tabs);
        tabLayout.setupWithViewPager(viewPager);

        presenter = new MainPresenterImpl(this);

        setupViewPager(viewPager);
    }

    @Override protected void onResume() {
        super.onResume();
        presenter.onResume();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_settings:
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override protected void onDestroy() {
        presenter.onDestroy();
        super.onDestroy();
    }

    private void setupViewPager(ViewPager viewPager) {
        WeekPrayerViewPagerAdapter adapter = new WeekPrayerViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new PrayerListFragment(), getResources().getString(R.string.monday));
        adapter.addFragment(new PrayerListFragment(), getResources().getString(R.string.tuesday));
        adapter.addFragment(new PrayerListFragment(), getResources().getString(R.string.wednesday));
        adapter.addFragment(new PrayerListFragment(), getResources().getString(R.string.thursday));
        adapter.addFragment(new PrayerListFragment(), getResources().getString(R.string.friday));
        adapter.addFragment(new PrayerListFragment(), getResources().getString(R.string.saturday));
        viewPager.setAdapter(adapter);
    }

}
