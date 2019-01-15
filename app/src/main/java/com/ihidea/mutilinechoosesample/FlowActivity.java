package com.ihidea.mutilinechoosesample;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.ihidea.multilinechooselib.MultiLineChooseLayout;

import java.util.ArrayList;
import java.util.List;

public class FlowActivity extends Activity {
    private List<String> mLikeData = new ArrayList<>();

    private MultiLineChooseLayout flowLayout;

    private TextView flowLayoutTv;

    private Button button;
    private Button button1;
    List<String> flowLayoutResult = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liu);
        flowLayout = (MultiLineChooseLayout) findViewById(R.id.flowLayout);

        flowLayoutTv = (TextView) findViewById(R.id.flowLayoutTv);

        initData();
        button1 = (Button) findViewById(R.id.button1);
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                flowLayout.cancelAllSelectedItems();

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

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flowLayout.setAllSelected();
            }
        });

        //流式布局
        flowLayout.setOnItemClickListener(new MultiLineChooseLayout.onItemClickListener() {
            @Override
            public void onItemClick(final int position, final String text) {

                final String originalTxt = mLikeData.get(position);

                NumPop numPop = new NumPop(FlowActivity.this, new XCallbackListener() {
                    @Override
                    protected void callback(Object... obj) {
                        //取消
                        if (!TextUtils.isEmpty(text) && text.contains("X")) {
                            flowLayout.setIndexItemSelected(position, true);
                        } else {
                            flowLayout.setIndexItemSelected(position, false);
                        }
                    }
                }, new XCallbackListener() {
                    @Override
                    protected void callback(Object... obj) {
                        if (!TextUtils.isEmpty((String) (obj[0]))) {
                            Integer num = Integer.parseInt((String) (obj[0]));
                            if (num == 0) {
                                flowLayout.setIndexItemText(position, originalTxt);
                                flowLayout.setIndexItemSelected(position, false);
                            } else {
                                flowLayout.setIndexItemText(position, originalTxt + " X " + num);
                                flowLayout.setIndexItemSelected(position, true);
                            }
                        }

                    }
                });
                numPop.show();


            }
        });


    }

    private void initData() {

        mLikeData.add("国内新闻");
        mLikeData.add("今日头条");
        mLikeData.add("视频");
        mLikeData.add("文字");
        mLikeData.add("图片");
        mLikeData.add("语音");
        flowLayout.setList(mLikeData);

    }
}
