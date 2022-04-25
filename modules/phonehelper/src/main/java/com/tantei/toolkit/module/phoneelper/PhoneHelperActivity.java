package com.tantei.toolkit.module.phoneelper;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.tantei.toolkit.module.phoneelper.adapter.ViewPager2Adapter;
import com.tantei.toolkit.module.phoneelper.bean.Page;
import com.tantei.toolkit.module.phoneelper.view.InfoFragment;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;


@AndroidEntryPoint
@Route(path = "/phoneHelper/PhoneHelperActivity")
public class PhoneHelperActivity extends AppCompatActivity implements TabLayoutMediator.TabConfigurationStrategy {

    private static final String TAG = "PhoneHelperActivity";

    private TabLayout tabLayout = null;
    private ViewPager2 viewPager = null;

    private List<Page> pages = new ArrayList<>();
    private List<String> titles = new ArrayList<>();

    @Inject
    SystemInfo systemInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.phonehelper_activity_phone_helper);

        tabLayout = findViewById(R.id.phonehelper_tabLayout);
        viewPager = findViewById(R.id.phonehelper_viewPager2);

        pages.add(new Page(getResources().getString(R.string.phonehelper_system_info), new InfoFragment()));
        pages.add(new Page(getResources().getString(R.string.phonehelper_system_info), new InfoFragment()));
        pages.add(new Page(getResources().getString(R.string.phonehelper_system_info), new InfoFragment()));

        setViewPage(pages);
    }

    private void setViewPage(List<Page> pages) {
        ViewPager2Adapter viewPager2Adapter = new ViewPager2Adapter(this);
        ArrayList<Fragment> fragments = new ArrayList<>();

        for (Page page : pages) {
            titles.add(page.getName());
            fragments.add(page.getFragment());
        }

        viewPager2Adapter.setData(fragments);
        viewPager.setAdapter(viewPager2Adapter);
        new TabLayoutMediator(tabLayout, viewPager, this).attach();
    }

    @Override
    public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
        tab.setText(titles.get(position));
    }
}