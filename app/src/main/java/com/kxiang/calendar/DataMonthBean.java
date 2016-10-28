package com.kxiang.calendar;

import java.util.List;

/**
 * 项目名称:UserDefinedView
 * 创建人:kexiang
 * 创建时间:2016/10/21 12:52
 * 当日的信息
 */

public class DataMonthBean {

    private String month;
    private List<DayBean> day;

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public List<DayBean> getDay() {
        return day;
    }

    public void setDay(List<DayBean> day) {
        this.day = day;
    }

    public static class DayBean {

        private String solarCalendar;
        private String lunarCalendar;
        private boolean dimBright;

        public boolean isDimBright() {
            return dimBright;
        }

        public void setDimBright(boolean dimBright) {
            this.dimBright = dimBright;
        }

        /**
         * 阳历
         *
         * @return
         */
        public String getSolarCalendar() {
            return solarCalendar;
        }

        public void setSolarCalendar(String solarCalendar) {
            this.solarCalendar = solarCalendar;
        }

        /**
         * 阴历
         *
         * @return
         */
        public String getLunarCalendar() {
            return lunarCalendar;
        }

        public void setLunarCalendar(String lunarCalendar) {
            this.lunarCalendar = lunarCalendar;
        }
    }

}
