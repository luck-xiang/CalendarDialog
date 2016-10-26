package com.kxiang.calendar;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.kxiang.calendar.rlv.OnRecycleItemSelectListener;
import com.kxiang.calendar.rlv.decoration.RecycleItemDivider;

import java.util.List;

/**
 * 项目名称:frontdesk
 * 创建人:kexiang
 * 创建时间:2016/10/11 14:22
 */
public class PopDropDownBox extends PopupWindow {


    public PopDropDownBox(Context context, int width,
                          TextView showText, List<String> list) {
        super(context);

        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View mMenuView = inflater.inflate(R.layout.pop_drop_down_box, null);

        //设置RedactPop弹出窗体的宽
        this.setWidth(width);
        //设置RedactPop弹出窗体的高
        this.setHeight(ViewGroup.LayoutParams.MATCH_PARENT);
        //设置RedactPop弹出窗体可点击
        this.setFocusable(true);
//        //设置RedactPop弹出窗体动画效果
//        this.setAnimationStyle(R.style.redactpop_anim_style);
        //实例化一个ColorDrawable颜色为半透明
        ColorDrawable dw = new ColorDrawable(0x00000000);
        //设置RedactPop弹出窗体的背景
        this.setBackgroundDrawable(dw);

        //设置RedactPop的View
        this.setContentView(mMenuView);
        initRecycleALLView(mMenuView, context, showText, list);
    }

    private RecyclerView rlv_all;
    private DropDownBoxAdapter allAdapter;
    private List<String> listTxt;


    public void initRecycleALLView(View view, Context context,
                                   final TextView showText, List<String> list) {

        rlv_all = (RecyclerView) view.findViewById(R.id.rlv_all);
        listTxt = list;


        allAdapter = new DropDownBoxAdapter(context, listTxt);
        rlv_all.setAdapter(allAdapter);
        rlv_all.setLayoutManager(new LinearLayoutManager(context));
        rlv_all.addItemDecoration(
                new RecycleItemDivider(context,
                        LinearLayoutManager.VERTICAL,
                        context.getResources().getColor(R.color.color_b4b4b4))
        );

        allAdapter.setOnRecycleItemSelectListener(new OnRecycleItemSelectListener() {
            @Override
            public void OnRecycleItemSelect(View view, int position) {

                int year = getInt(showText.getText() + "");

                if (onItemSelcectListener != null) {
                    onItemSelcectListener.OnItemSelcect(
                            Integer.parseInt(listTxt.get(position) + "") - year

                    );
                }
                dismiss();

            }
        });
    }

    private int getInt(String str) {
        return Integer.parseInt(str.substring(0, str.length() - 1));

    }


    public interface OnItemSelcectListener {
        void OnItemSelcect(int item);
    }

    private OnItemSelcectListener onItemSelcectListener;

    public void setOnItemSelcectListener(OnItemSelcectListener onItemSelcectListener) {
        this.onItemSelcectListener = onItemSelcectListener;
    }
}
