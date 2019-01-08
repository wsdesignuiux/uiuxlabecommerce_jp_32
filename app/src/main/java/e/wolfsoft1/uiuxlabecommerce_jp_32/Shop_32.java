package e.wolfsoft1.uiuxlabecommerce_jp_32;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.viewpagerindicator.LinePageIndicator;

import java.util.ArrayList;

import e.wolfsoft1.uiuxlabecommerce_jp_32.adapter.ColorAdapter_32;
import e.wolfsoft1.uiuxlabecommerce_jp_32.adapter.JacketViewPagerAdapterShop_32;
import e.wolfsoft1.uiuxlabecommerce_jp_32.adapter.SizeAdapter_32;
import e.wolfsoft1.uiuxlabecommerce_jp_32.model.Color_Model;
import e.wolfsoft1.uiuxlabecommerce_jp_32.model.Size_Model;

public class Shop_32 extends AppCompatActivity {

    ViewPager viewpager_jacket;
    RecyclerView size_recycler_32, color_recycler_32;
    ArrayList<Size_Model> size_modelArrayList;
    ArrayList<Color_Model> color_modelArrayList;

    LinePageIndicator indicator_line;

    private String size[] = {"X", "XL", "S", "XS", "XL", "XX", "L"};
    private Integer color[] = {R.drawable.ic_color1, R.drawable.ic_color2, R.drawable.ic_color3, R.drawable.ic_color4, R.drawable.ic_color5, R.drawable.ic_color6, R.drawable.ic_color7, R.drawable.ic_color8};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_32);

        indicator_line = findViewById(R.id.indicator_line);

        viewpager_jacket = findViewById(R.id.viewpager_jacket);
        size_recycler_32 = findViewById(R.id.size_recycler_32);

        color_recycler_32 = findViewById(R.id.color_recycler_32);

        JacketViewPagerAdapterShop_32 viewPagerAdapter = new JacketViewPagerAdapterShop_32(getSupportFragmentManager(), 3);
        viewpager_jacket.setAdapter(viewPagerAdapter);

        indicator_line.setViewPager(viewpager_jacket);
        size_modelArrayList = new ArrayList<>();
        color_modelArrayList = new ArrayList<>();

        for (int i = 0; i < size.length; i++) {
            Size_Model size_model = new Size_Model(size[i]);
            size_modelArrayList.add(size_model);
        }
        for (int i = 0; i < color.length; i++) {
            Color_Model color_model = new Color_Model(color[i]);
            color_modelArrayList.add(color_model);
        }

        size_recycler_32.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        SizeAdapter_32 sizeAdapter = new SizeAdapter_32(this, size_modelArrayList);
        size_recycler_32.setAdapter(sizeAdapter);

        color_recycler_32.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        ColorAdapter_32 adapter = new ColorAdapter_32(this, color_modelArrayList);
        color_recycler_32.setAdapter(adapter);
    }
}
