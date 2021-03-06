package com.jack.loopviewpager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.jack.loopviewpager.transformer.AccordionTransformer;
import com.jack.loopviewpagers.IndicatiorCanvasView;
import com.jack.loopviewpagers.LoopViewPager;
import com.jack.loopviewpagers.interfaces.CreateView;
import com.jack.loopviewpagers.interfaces.IndicatorAnimator;
import com.jack.loopviewpagers.interfaces.OnPageClickListener;
import com.jack.loopviewpagers.interfaces.UpdateImage;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Jack
 */
public class MainActivity extends AppCompatActivity {

    public LoopViewPager viewPager;
    public List<Fragment> listFragment=new ArrayList<>();
    ViewPageFragment viewPageFragment1=new ViewPageFragment();
    ViewPageFragment viewPageFragment2=new ViewPageFragment();
    ViewPageFragment viewPageFragment3=new ViewPageFragment();
    ViewPageFragment viewPageFragment4=new ViewPageFragment();
    ViewPageFragment viewPageFragment5=new ViewPageFragment();
    ViewPageFragment viewPageFragment6=new ViewPageFragment();
    ViewPageFragment viewPageFragment7=new ViewPageFragment();
    ViewPageFragment viewPageFragment8=new ViewPageFragment();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String image="https://img4.duitang.com/uploads/item/201506/06/20150606155423_h5zyU.thumb.700_0.jpeg";
        viewPager=findViewById(R.id.view_pager);

//        initData1();
//        viewPager.setData(getSupportFragmentManager(),listFragment);

        List<String> data=new ArrayList<>();
        final LayoutInflater layoutInflater=LayoutInflater.from(this);
        data.add("View1");data.add("View2");
        data.add("View3"); data.add("View4");
        data.add("View5"); data.add("View6");
        viewPager.setData(this, data, new CreateView() {
            @Override
            public View createView(int position) {
                Log.e("Main_Create",position+"");
                return layoutInflater.inflate(R.layout.layout_view,null);
            }
            @Override
            public void updateView(View view,int position, Object item) {
                Log.e("Main_Update",position+"");
                ((TextView)view.findViewById(R.id.view_name)).setText((String)item);
            }
            @Override
            public void deleteView(int position){
                Log.e("Main_Delete",position+"");
            }
        });
        viewPager.setAnimation(true,new AccordionTransformer());


//        viewPager.setIndicatorAnimator(new IndicatorAnimator() {
//            @Override
//            public void indicatorView(View view) {
//                PropertyValuesHolder scaleYAnimator=PropertyValuesHolder.ofFloat("scaleY",1f,1.3f,1f);
//                PropertyValuesHolder scaleXAnimator=PropertyValuesHolder.ofFloat("scaleX",1f,1.3f,1f);
//                ObjectAnimator.ofPropertyValuesHolder(view, scaleYAnimator, scaleXAnimator).setDuration(1500).start();
//            }
//        });
        viewPager.setAnimation(true,new AccordionTransformer());
//        viewPager.setIndicatorType(IndicatiorCanvasView.class);
//        viewPager.setIndicatorGravity(LoopViewPager.IndicatorGravity.CENTER);


//        List<Integer> data=new ArrayList<>();
//        data.add(R.mipmap.ic_banner1);
//        data.add(R.mipmap.ic_banner2);
//        data.add(R.mipmap.ic_banner3);
//        viewPager.setData(this, data, new UpdateImage<Integer>() {
//            @Override
//            public void loadImage(ImageView view, int position, Integer item) {
//                view.setScaleType(ImageView.ScaleType.FIT_XY);
//                Glide.with(MainActivity.this).load(item).into(view);
//            }
//        });



//        viewPager.startBanner();

    }

    public void initData1(){
        Bundle bundle=new Bundle();
        bundle.putString("name","Fragment1");
        viewPageFragment1.setArguments(bundle);
        listFragment.add(viewPageFragment1);

        Bundle bundle2=new Bundle();
        bundle2.putString("name","Fragment2");
        viewPageFragment2.setArguments(bundle2);
        listFragment.add(viewPageFragment2);

        Bundle bundle3=new Bundle();
        bundle3.putString("name","Fragment3");
        viewPageFragment3.setArguments(bundle3);
        listFragment.add(viewPageFragment3);

        Bundle bundle4=new Bundle();
        bundle4.putString("name","Fragment4");
        viewPageFragment4.setArguments(bundle4);
        listFragment.add(viewPageFragment4);

        Bundle bundle5=new Bundle();
        bundle5.putString("name","Fragment5");
        viewPageFragment5.setArguments(bundle5);
        listFragment.add(viewPageFragment5);

        Bundle bundle6=new Bundle();
        bundle6.putString("name","Fragment6");
        viewPageFragment6.setArguments(bundle6);
        listFragment.add(viewPageFragment6);

        Bundle bundle7=new Bundle();
        bundle7.putString("name","Fragment7");
        viewPageFragment7.setArguments(bundle7);
        listFragment.add(viewPageFragment7);

        Bundle bundle8=new Bundle();
        bundle8.putString("name","Fragment8");
        viewPageFragment8.setArguments(bundle8);
        listFragment.add(viewPageFragment8);
    }

}
