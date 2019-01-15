package com.ihidea.mutilinechoosesample;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.ihidea.multilinechooselib.MultiLineChooseLayout;

import java.util.ArrayList;
import java.util.List;

public class SameItemActivity extends Activity {
    
    private List<String> mEquipData = new ArrayList<>();
    
    private MultiLineChooseLayout multiChoose;
    
    private TextView multiChooseTv;
    
    private Button button;
    private Button button1;

    List<String> multiChooseResult = new ArrayList<>();
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_same_item);
        
        multiChoose = (MultiLineChooseLayout) findViewById(R.id.multiChoose);
        
        multiChooseTv = (TextView) findViewById(R.id.multiChooseTv);
        
        initData();
        button = (Button) findViewById(R.id.button);
        button1 = (Button) findViewById(R.id.button1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                multiChoose.cancelAllSelectedItems();
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                multiChoose.setAllSelected();
            }
        });
        
        //多选
        multiChoose.setOnItemClickListener(new MultiLineChooseLayout.onItemClickListener() {
            @Override
            public void onItemClick(int position, String text) {
                multiChooseResult = multiChoose.getAllItemSelectedTextWithListArray();
                if (multiChooseResult != null && multiChooseResult.size() > 0) {
                    String textSelect = "";
                    for (int i = 0; i < multiChooseResult.size(); i++) {
                        textSelect += multiChooseResult.get(i) + " , ";
                    }
                    multiChooseTv.setText("结果：" + position);
                }
            }
        });
        
    }
    
    private void initData() {
        
        mEquipData.add("电脑");
        mEquipData.add("手机");
        mEquipData.add("钥匙");
        mEquipData.add("毛笔");
        mEquipData.add("足球");
        mEquipData.add("雨伞");
        mEquipData.add("电视");
        mEquipData.add("天气");
        
        multiChoose.setList(mEquipData);
        
    }
}
