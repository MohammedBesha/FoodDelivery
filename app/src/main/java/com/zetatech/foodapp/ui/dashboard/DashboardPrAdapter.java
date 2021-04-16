package com.zetatech.foodapp.ui.dashboard;


import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.zetatech.foodapp.data.models.KitchenCategory;
import com.zetatech.foodapp.ui.kitchens.KitchensFragment;
import java.util.List;

public class DashboardPrAdapter extends FragmentStatePagerAdapter {

    private List<KitchenCategory> mKitchenCategory ;

    public DashboardPrAdapter(FragmentManager fm, List<KitchenCategory> kitchenCategory) {
        super(fm,BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        this.mKitchenCategory = kitchenCategory;
    }



    @Override
    public Fragment getItem(int position) {


        return  KitchensFragment.newInstance(mKitchenCategory.get(position).getKitchens());

    }


    @Override
    public int getCount() {
        return mKitchenCategory.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mKitchenCategory.get(position).getName();
    }
}
