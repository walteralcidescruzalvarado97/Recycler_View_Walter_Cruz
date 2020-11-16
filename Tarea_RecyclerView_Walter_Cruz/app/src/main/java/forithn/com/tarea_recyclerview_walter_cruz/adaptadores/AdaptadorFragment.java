package forithn.com.tarea_recyclerview_walter_cruz.adaptadores;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class AdaptadorFragment extends FragmentPagerAdapter {

    private ArrayList<Fragment> fragments;



    public AdaptadorFragment(@NonNull FragmentManager fm, ArrayList< Fragment > fragments) {
        super(fm);
        this.fragments = fragments;
    }

    public AdaptadorFragment(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }
}
