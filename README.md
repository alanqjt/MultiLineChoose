### Android流式布局实现多行Checkbox功能

在我们开发过程中，我们有的时候会碰到这么一种需求，就是需要单选，但是呢？得多行显示要选的内容item，常规做法使用RadioGroup加上RadioButton来实现，但是前提是我们知道所要选择的item个数，如果碰到这么一种情况，所给出的item数量不确定，也就是从后台服务器中获取，有多少显示多少？这就有点郁闷了，没关系，今天我们来提供一种新的实现方式，那就是流式布局来实现类似功能。

### 特点

依赖包体积小、集成方便，提供多种自定义属性，基本能覆盖所有需求。

### apk演示下载

![](http://img.blog.csdn.net/20161028170127631)

[http://fir.im/cv1b](http://fir.im/cv1b)

### 效果演示

![](http://img.blog.csdn.net/20161028163119962)

### 使用方法

**gradle引用**

```
compile 'liji.library.dev:multilinechooselib:2.0.3'
```



### 最近更新说明
[全部更新说明](https://github.com/crazyandcoder/MultiLineChoose/wiki/%E6%9B%B4%E6%96%B0%E8%AF%B4%E6%98%8E)
####  V2.0.3版本更新内容（2019.01.15）
1. 新增全部选中的属性方法



**自定义属性**
[自定义属性大全](https://github.com/crazyandcoder/MultiLineChoose/wiki/%E5%B1%9E%E6%80%A7%E6%A0%B7%E5%BC%8F%E5%A4%A7%E5%85%A8)

**使用方法**

```
//属性设置，其中style="@style/FlowLayout"请见上面的自定义属性大全
<com.ihidea.multilinechooselib.MultiLineChooseLayout
                android:id="@+id/flowLayout"
                style="@style/FlowLayout"
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:layout_marginTop="5dp">
</com.ihidea.multilinechooselib.MultiLineChooseLayout>

//设置数据源
private List<String> mColorData = new ArrayList<>();
private MultiLineChooseLayout singleChoose;
singleChoose = (MultiLineChooseLayout) findViewById(R.id.singleChoose);	
	mColorData.add("红色");
        mColorData.add("橙色");
        mColorData.add("黄色");
        mColorData.add("绿色");
        mColorData.add("蓝色");
        mColorData.add("灰色");
        mColorData.add("紫色");     
singleChoose.setList(mColorData);

//单选
singleChoose.setOnItemClickListener(new MultiLineChooseLayout.onItemClickListener() {
            @Override
            public void onItemClick(int position, String text) {
                singleChooseTv.setText("结果：position: " + position + "   " + text);
            }
        });

//取消选中项
singleChoose.cancelAllSelectedItems();
         
``` 
**如果要设置多选，请在style中设置item_multiChooseable=true**
**如果要设置流式布局，则将item的宽和高都设置为wrap_content**

### 常用方法介绍
[常用方法介绍](https://github.com/crazyandcoder/MultiLineChoose/wiki/%E5%B8%B8%E8%A7%81%E4%BD%BF%E7%94%A8%E6%96%B9%E6%B3%95)

 


