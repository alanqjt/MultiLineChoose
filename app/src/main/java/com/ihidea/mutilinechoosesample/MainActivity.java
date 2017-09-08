package com.ihidea.mutilinechoosesample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.ihidea.multilinechooselib.MultiLineChooseLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    
    private List<String> mColorData = new ArrayList<>();
    
    private List<String> mEquipData = new ArrayList<>();
    
    private List<String> mLikeData = new ArrayList<>();
    
    private MultiLineChooseLayout singleChoose;
    
    private MultiLineChooseLayout multiChoose;
    
    private MultiLineChooseLayout flowLayout;
    
    private TextView singleChooseTv;
    
    private TextView multiChooseTv;
    
    private TextView flowLayoutTv;
    
    private Button button;
    
    List<String> multiChooseResult = new ArrayList<>();
    
    List<String> flowLayoutResult = new ArrayList<>();
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        singleChoose = (MultiLineChooseLayout) findViewById(R.id.singleChoose);
        multiChoose = (MultiLineChooseLayout) findViewById(R.id.multiChoose);
        flowLayout = (MultiLineChooseLayout) findViewById(R.id.flowLayout);
        
        singleChooseTv = (TextView) findViewById(R.id.singleChooseTv);
        multiChooseTv = (TextView) findViewById(R.id.multiChooseTv);
        flowLayoutTv = (TextView) findViewById(R.id.flowLayoutTv);
        
        initData();
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                singleChoose.cancelAllSelectedItems();
                multiChoose.cancelAllSelectedItems();
                flowLayout.cancelAllSelectedItems();
            }
        });
        
        //单选
        singleChoose.setOnItemClickListener(new MultiLineChooseLayout.onItemClickListener() {
            @Override
            public void onItemClick(int position, String text) {
                singleChooseTv.setText("结果：position: " + position + "   " + text);
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
        
        //流式布局
        flowLayout.setOnItemClickListener(new MultiLineChooseLayout.onItemClickListener() {
            @Override
            public void onItemClick(int position, String text) {
                flowLayoutResult = flowLayout.getAllItemSelectedTextWithListArray();
                if (flowLayoutResult != null && flowLayoutResult.size() > 0) {
                    String textSelect = "";
                    for (int i = 0; i < flowLayoutResult.size(); i++) {
                        textSelect += flowLayoutResult.get(i) + " , ";
                    }
                    flowLayoutTv.setText("结果：" + textSelect);
                }
            }
        });
        
    }
    
    private void initData() {
        
        mColorData.add("红色");
        mColorData.add("橙色");
        mColorData.add("黄色");
        mColorData.add("绿色");
        mColorData.add("蓝色");
        mColorData.add("灰色");
        mColorData.add("紫色");
        singleChoose.setList(mColorData);
        
        mEquipData.add("电脑");
        mEquipData.add("手机");
        mEquipData.add("钥匙");
        mEquipData.add("毛笔");
        mEquipData.add("足球");
        mEquipData.add("雨伞");
        mEquipData.add("电视");
        mEquipData.add("天气");
        
        multiChoose.setList(mEquipData);
        
        mLikeData.add("国内新闻");
        mLikeData.add("今日头条");
        mLikeData.add("视频");
        mLikeData.add("文字");
        mLikeData.add("图片");
        mLikeData.add("语音");
        flowLayout.setList(mLikeData);
        
    }
}
