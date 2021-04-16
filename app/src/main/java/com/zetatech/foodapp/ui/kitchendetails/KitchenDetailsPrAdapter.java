package com.zetatech.foodapp.ui.kitchendetails;



import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import com.zetatech.foodapp.data.models.KitchenMenu;
import com.zetatech.foodapp.ui.meals.MealsFragment;
import java.util.List;

public class KitchenDetailsPrAdapter extends FragmentStatePagerAdapter {

    private List<KitchenMenu> mKitchenMenus ;

    public KitchenDetailsPrAdapter(FragmentManager fm, List<KitchenMenu> kitchenMenus) {
        super(fm,BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        this.mKitchenMenus = kitchenMenus;
    }



    @Override
    public Fragment getItem(int position) {

        return MealsFragment.newInstance(mKitchenMenus.get(position).getId());

    }


    @Override
    public int getCount() {
        return mKitchenMenus.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mKitchenMenus.get(position).getName();
    }
}
