package com.minami.lnx.tmailbanner;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class SecondFragment extends Fragment {
     Main2Activity.BannerInterface bannerInterface;
     private int positionInVp ;

    public SecondFragment() {
        // Required empty public constructor
    }


    public static SecondFragment newInstance(int position) {
        Bundle args = new Bundle();
        args.putInt("int" ,position);
        SecondFragment fragment = new SecondFragment();
        fragment.setArguments(args);
        return fragment;
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        positionInVp = getArguments().getInt("int");
        return inflater.inflate(R.layout.fragment_second, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if(bannerInterface!=null){
            view.findViewById(R.id.iv_main).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    bannerInterface.onClick(v,positionInVp);
                }
            });

            view.findViewById(R.id.tv_main).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    bannerInterface.onClick(v,positionInVp);
                }
            });
        }

    }

    public SecondFragment setBannerInterface(Main2Activity.BannerInterface bannerInterface) {
           this.bannerInterface = bannerInterface;

           return this ;
    }
}
