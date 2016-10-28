package com.kxiang.calendar;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.TextView;

public class CalendarActivity extends FragmentActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);


        initCalendar();

    }

    private TextView tv_calendar;

    private void initCalendar() {
        tv_calendar = (TextView) findViewById(R.id.tv_calendar);
        initOnClick(R.id.btn_calendar);
    }


    private void initOnClick(int id) {
        findViewById(id).setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_calendar:
                DialogCalender calender = new DialogCalender();
                calender.show(getSupportFragmentManager(), "dialog_calender");
                calender.setOnItemClickListener(new DialogCalender.OnItemClickListener() {
                    @Override
                    public void OnItemClick(int year, int month, DataMonthBean.DayBean dayBean) {
                        tv_calendar.setText(
                                "阳历：" +
                                        year + "年" +
                                        month + "月" +
                                        dayBean.getSolarCalendar() + "日" +
                                        "\n农历：" +
                                        dayBean.getLunarYear() + "年" +
                                        dayBean.getLunarMonth() +
                                        dayBean.getLunarCalendar()
                        );
                    }
                });
                break;
        }

    }
}
