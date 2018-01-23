package com.example.sfhan.aaa;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private ExpandableListView lv;
    private List<memBean> list2;
    private List<memBean> list3;
    private List<memBean> list4;
    private Map<String,List<memBean>> map=new HashMap<>();
    String [] arr=new String[]{"武动","不朽","百炼"};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initview();
    }
    private void initview(){

        list2=new ArrayList<>();
        list3=new ArrayList<>();
        list4=new ArrayList<>();
        memBean m1=new memBean("乾坤","林动","出生在青阳镇没落的林家，背景是林氏家族。");
        memBean m2=new memBean("凡人","莫无忌","我本凡人");
        memBean m3=new memBean("成仙","林轩","仙路崎岖，百般磨练终成正果。");

        list2.add(m1);
        list3.add(m2);
        list4.add(m3);
        map.put(arr[0],list2);
        map.put(arr[1],list3);
        map.put(arr[2],list4);

        lv=findViewById(R.id.expandablelistview);
        lv.setAdapter(new setAdapter());
//        //设置Group默认展开
//        int groupCount = lv.getCount();
//        for(int i=0;i<groupCount;i++){
//            lv.expandGroup(i);
//        }

    }
            public class setAdapter extends BaseExpandableListAdapter{
                //  获得父项的数量
                @Override
                public int getGroupCount() {
                    return map.size();
                }
                //  获得某个父项的子项数目
                @Override
                public int getChildrenCount(int i) {
                    return map.get(arr[i]).size();
                }

                //  获得某个父项
                @Override
                public Object getGroup(int i) {
                    return map.get(arr[i]);
                }

                //  获得某个父项的某个子项id
                @Override
                public Object getChild(int i, int i1) {
                    return i1;
                }

                //  获得某个父项的id
                @Override
                public long getGroupId(int i) {
                    return i;
                }

                //  获得某个父项的某个子项的id
                @Override
                public long getChildId(int i, int i1) {
                    return i1;
                }

                //  按函数的名字来理解应该是是否具有稳定的id，这个方法目前一直都是返回false，没有去改动过
                @Override
                public boolean hasStableIds() {
                    return false;
                }

                //  获得父项显示的view
                @Override
                public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
                    View view1=null;
                    GroupHolder groupholder = null;
                    if(view!=null){
                        view1 = view;
                        groupholder = (GroupHolder) view1.getTag();
                    }else{
                        view1 = LayoutInflater.from(MainActivity.this).inflate(R.layout.item_list, null);
                        groupholder =new GroupHolder();
                        groupholder.mSpaceText = (TextView) view1.findViewById(R.id.group_text);
                        groupholder.image=view1.findViewById(R.id.imagee);
                        view1.setTag(groupholder);
                    }
                    groupholder.mSpaceText.setText(arr[i]);



                    // 自定义前面的收缩图标，根据当前父条目的展开状态来设置不同的图片
                    if (b) {
                        // 条目展开，设置向下的箭头
                        groupholder.image.setImageResource(R.drawable.sj1);
                    } else {
                        // 条目未展开，设置向上的箭头
                        groupholder.image.setImageResource(R.drawable.sj);
                    }
                    return view1;

                }

                //  获得子项显示的view
                @Override
                public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
                    View view1=null;
                    ChildHolder childholder = null;
                    if(view!=null){
                        view1 = view;
                        childholder = (ChildHolder) view.getTag();
                    }else{
                        view1 = View.inflate(MainActivity.this,R.layout.child, null);
                        childholder = new ChildHolder();
                        childholder.mImage = (ImageView) view1.findViewById(R.id.image1);
                        childholder.mPrice = (TextView) view1.findViewById(R.id.textTwo);
                        childholder.mStateText = (TextView) view1.findViewById(R.id.textOne);
                        childholder.mSecondPrice = (TextView) view1.findViewById(R.id.textThree);
                        view1.setTag(childholder);
                    }
                      childholder.mImage.setImageResource(R.drawable.q1);
                      childholder.mStateText.setText( map.get(arr[i]).get(i1).getName());
                      childholder.mPrice.setText( map.get(arr[i]).get(i1).getSex());
                      childholder.mSecondPrice.setText(map.get(arr[i]).get(i1).getAge()+"");
                      return view1;
                }

                //  子项是否可选中，如果需要设置子项的点击事件，需要返回true
                @Override
                public boolean isChildSelectable(int i, int i1) {
                    return false;
                }
            }

//父组件Holder
    static class GroupHolder{
        TextView mSpaceText;
        ImageView image;
    }
//子组件Holder
    static class ChildHolder{
        ImageView mImage;
        TextView mStateText;
        TextView mPrice;
        TextView mSecondPrice;
    }

}

