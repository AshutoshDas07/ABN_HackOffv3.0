package com.example.knowthetrend;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.anychart.chart.common.dataentry.DataEntry;
import com.anychart.chart.common.dataentry.ValueDataEntry;

import java.util.ArrayList;
import java.util.List;

public class ChartListActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private List<DataEntry> colours;
    private List<DataEntry> brands;
    private List<List<DataEntry>> shoeslist;
    private List<DataEntry> cuts;
    private List<DataEntry> shirtsbrands;
    private List<List<DataEntry>> shirtslist;
    private List<DataEntry> collars;
    private List<List<DataEntry>> tshirtslist;
    private List<DataEntry> tshirtsbrands;
    private List<DataEntry> jacketstypes;
    private List<DataEntry> jacketsbrands;
    private List<List<DataEntry>> jacketlist;
    private List<String> shoestext;
    private List<String> shirtstext;
    private List<String> tshirtstext;
    private List<String> ethnictext;
    private List<String> jackettext;

    private List<DataEntry> LTopTypes;
    private List<DataEntry> LTopBrands;
    private List<DataEntry> LSleeveType;
    private List<List<DataEntry>> Ltops;
    private List<List<DataEntry>> Lshirts;
    private List<DataEntry> LfootwearType;
    private List<DataEntry> LfootwearBrand;
    private List<List<DataEntry>> Lfootwear;
    private List<String> Ltoptext;
    private List<String> Lshirtstext;
    private List<String> Lfootwewartext;
    int Min;
    int Max;
    int pos;
    int catnum;
    Intent receivedIntent;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chart_list_activity);
        receivedIntent=getIntent();
        pos=receivedIntent.getIntExtra("POS",0);
        catnum=receivedIntent.getIntExtra("catType",0);
        //men
        cuts=new ArrayList<>();
        shoestext=new ArrayList<>();
        shirtstext=new ArrayList<>();
        tshirtstext=new ArrayList<>();
        jackettext=new ArrayList<>();
        ethnictext=new ArrayList<>();
        shoestext.add("Top Colours");
        shoestext.add("Top Brands");
        shirtstext.add("Top Colours");
        shirtstext.add("Top Brands");
        shirtstext.add("Top Fits");
        tshirtstext.add("Top Colours");
        tshirtstext.add("Top Neck Type");
        tshirtstext.add("Top Brands");
        jackettext.add("Top Colours");
        jackettext.add("Top Jacket Type");
        jackettext.add("Top Brands");
        shirtslist=new ArrayList<>();
        collars=new ArrayList<>();
        colours=new ArrayList<>();
        brands=new ArrayList<>();
        tshirtslist=new ArrayList<>();
        shoeslist=new ArrayList<>();
        jacketstypes=new ArrayList<>();
        jacketlist=new ArrayList<>();
        shirtsbrands=new ArrayList<>();
        tshirtsbrands=new ArrayList<>();
        jacketsbrands=new ArrayList<>();
        Min=20;
        Max=90;
        colours.add(new ValueDataEntry("Red", Min + (int)(Math.random() * ((Max - Min) + 1))));
        colours.add(new ValueDataEntry("Blue", Min + (int)(Math.random() * ((Max - Min) + 1))));
        colours.add(new ValueDataEntry("Green", Min + (int)(Math.random() * ((Max - Min) + 1))));
        colours.add(new ValueDataEntry("Violet", Min + (int)(Math.random() * ((Max - Min) + 1))));
        brands.add(new ValueDataEntry("Nike", Min + (int)(Math.random() * ((Max - Min) + 1))));
        brands.add(new ValueDataEntry("Puma", Min + (int)(Math.random() * ((Max - Min) + 1))));
        brands.add(new ValueDataEntry("Adidas", Min + (int)(Math.random() * ((Max - Min) + 1))));
        brands.add(new ValueDataEntry("Bata", Min + (int)(Math.random() * ((Max - Min) + 1))));
        shirtsbrands.add(new ValueDataEntry("Allen Solley", Min + (int)(Math.random() * ((Max - Min) + 1))));
        shirtsbrands.add(new ValueDataEntry("Mark & Spencer", Min + (int)(Math.random() * ((Max - Min) + 1))));
        shirtsbrands.add(new ValueDataEntry("Peter England", Min + (int)(Math.random() * ((Max - Min) + 1))));
        shirtsbrands.add(new ValueDataEntry("Van Huesen", Min + (int)(Math.random() * ((Max - Min) + 1))));
        tshirtsbrands.add(new ValueDataEntry("Tommy Hilfiger", Min + (int)(Math.random() * ((Max - Min) + 1))));
        tshirtsbrands.add(new ValueDataEntry("Levi's", Min + (int)(Math.random() * ((Max - Min) + 1))));
        tshirtsbrands.add(new ValueDataEntry("Fila", Min + (int)(Math.random() * ((Max - Min) + 1))));
        tshirtsbrands.add(new ValueDataEntry("Van Huesen", Min + (int)(Math.random() * ((Max - Min) + 1))));
        collars.add(new ValueDataEntry("Round Neck",Min + (int)(Math.random() * ((Max - Min) + 1))));
        collars.add(new ValueDataEntry("V Neck",Min + (int)(Math.random() * ((Max - Min) + 1))));
        collars.add(new ValueDataEntry("Collar Neck",Min + (int)(Math.random() * ((Max - Min) + 1))));
       jacketstypes.add(new ValueDataEntry("Denim",(int)(Math.random() * ((Max - Min) + 1))));
       jacketstypes.add(new ValueDataEntry("Leather",(int)(Math.random() * ((Max - Min) + 1))));
       jacketstypes.add(new ValueDataEntry("Hooded",(int)(Math.random() * ((Max - Min) + 1))));
       jacketstypes.add(new ValueDataEntry("Denim",(int)(Math.random() * ((Max - Min) + 1))));
       cuts.add(new ValueDataEntry("Classic Fit",(int)(Math.random() * ((Max - Min) + 1))));
       cuts.add(new ValueDataEntry("Skinny Fit",(int)(Math.random() * ((Max - Min) + 1))));
       cuts.add(new ValueDataEntry("Slimt Fitt",(int)(Math.random() * ((Max - Min) + 1))));
       jacketsbrands.add(new ValueDataEntry("Moncler",(int)(Math.random() * ((Max - Min) + 1))));
       jacketsbrands.add(new ValueDataEntry("Canada Goose",(int)(Math.random() * ((Max - Min) + 1))));
       jacketsbrands.add(new ValueDataEntry("APC",(int)(Math.random() * ((Max - Min) + 1))));
       jacketsbrands.add(new ValueDataEntry("Belstaff",(int)(Math.random() * ((Max - Min) + 1))));
        shoeslist.add(colours);
        shoeslist.add(brands);
        shirtslist.add(colours);
        shirtslist.add(shirtsbrands);
        shirtslist.add(cuts);
        tshirtslist.add(colours);
        tshirtslist.add(collars);
        tshirtslist.add(tshirtsbrands);
        jacketlist.add(colours);
        jacketlist.add(jacketstypes);
        jacketlist.add(jacketsbrands);

        //women
        LTopBrands=new ArrayList<>();
        LTopTypes=new ArrayList<>();
        LSleeveType=new ArrayList<>();
        Ltops=new ArrayList<>();
        Lshirts=new ArrayList<>();
        LfootwearType=new ArrayList<>();
        LfootwearBrand=new ArrayList<>();
        Lfootwear=new ArrayList<>();
        Ltoptext=new ArrayList<>();
        Lfootwewartext=new ArrayList<>();
        Lshirtstext=new ArrayList<>();

        Ltoptext.add("Top Colours");
        Ltoptext.add("Top Sleeves Types");
        Ltoptext.add("Top Brands");
        Ltoptext.add("Top Types");
        Lshirtstext.add("Top Colours");
        Lshirtstext.add("Top Brands");
        Lfootwewartext.add("Top FootWear Type");
        Lfootwewartext.add("Top FootWear Brand");

        LTopBrands.add(new ValueDataEntry("LV", Min + (int)(Math.random() * ((Max - Min) + 1))));
        LTopBrands.add(new ValueDataEntry("Prada", Min + (int)(Math.random() * ((Max - Min) + 1))));
        LTopBrands.add(new ValueDataEntry("H&M", Min + (int)(Math.random() * ((Max - Min) + 1))));
        LTopBrands.add(new ValueDataEntry("Gucci", Min + (int)(Math.random() * ((Max - Min) + 1))));
        LSleeveType.add(new ValueDataEntry("Half Sleeves", Min + (int)(Math.random() * ((Max - Min) + 1))));
        LSleeveType.add(new ValueDataEntry("3/4th Sleeves", Min + (int)(Math.random() * ((Max - Min) + 1))));
        LTopTypes.add(new ValueDataEntry("Typical Kurtas", Min + (int)(Math.random() * ((Max - Min) + 1))));
        LTopTypes.add(new ValueDataEntry("Tees", Min + (int)(Math.random() * ((Max - Min) + 1))));
        LTopTypes.add(new ValueDataEntry("Modern Kurta", Min + (int)(Math.random() * ((Max - Min) + 1))));
        LfootwearType.add(new ValueDataEntry("Heels", Min + (int)(Math.random() * ((Max - Min) + 1))));
        LfootwearType.add(new ValueDataEntry("Wedges", Min + (int)(Math.random() * ((Max - Min) + 1))));
        LfootwearType.add(new ValueDataEntry("Sandles", Min + (int)(Math.random() * ((Max - Min) + 1))));
        LfootwearBrand.add(new ValueDataEntry("Regal", Min + (int)(Math.random() * ((Max - Min) + 1))));
        LfootwearBrand.add(new ValueDataEntry("Mochi", Min + (int)(Math.random() * ((Max - Min) + 1))));
        LfootwearBrand.add(new ValueDataEntry("Liberty", Min + (int)(Math.random() * ((Max - Min) + 1))));

        Ltops.add(colours);
        Ltops.add(LSleeveType);
        Ltops.add(LTopBrands);
        Ltops.add(LTopTypes);
        Lshirts.add(colours);
        Lshirts.add(LTopBrands);
        Lfootwear.add(LfootwearType);
        Lfootwear.add(LfootwearBrand);

        recyclerView=findViewById(R.id.chartList);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        if(catnum==0) {
            if (pos == 0) {
                recyclerView.setAdapter(new ChartAdapter(this, shirtslist, shirtstext));
            } else if (pos == 1) {
                recyclerView.setAdapter(new ChartAdapter(this, tshirtslist, tshirtstext));
            } else if (pos == 2) {
                recyclerView.setAdapter(new ChartAdapter(this, jacketlist, jackettext));
            } else if (pos == 3) {
                recyclerView.setAdapter(new ChartAdapter(this, jacketlist, jackettext));
            } else if (pos == 4) {
                recyclerView.setAdapter(new ChartAdapter(this, shoeslist, shoestext));
            } else {
                recyclerView.setAdapter(new ChartAdapter(this, shirtslist, shirtstext));
            }
        }else if(catnum==1){
            if (pos == 0) {
                recyclerView.setAdapter(new ChartAdapter(this, Ltops, Ltoptext));
            } else if (pos == 1) {
                recyclerView.setAdapter(new ChartAdapter(this, Lshirts, Lshirtstext));
            } else if (pos == 2) {
                recyclerView.setAdapter(new ChartAdapter(this, Lshirts, Lshirtstext));
            } else if (pos == 3) {
                recyclerView.setAdapter(new ChartAdapter(this, Lshirts, Lshirtstext));
            } else if (pos == 4) {
                recyclerView.setAdapter(new ChartAdapter(this, Lfootwear, Lfootwewartext));
            } else {
                recyclerView.setAdapter(new ChartAdapter(this, Lshirts, Lshirtstext));
            }
        }else{

            }
    }
}
