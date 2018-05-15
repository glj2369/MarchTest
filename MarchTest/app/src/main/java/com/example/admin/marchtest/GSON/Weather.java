package com.example.admin.marchtest.GSON;

import java.util.List;

public class Weather {


    private List<HeWeather6Bean> HeWeather6;

    public List<HeWeather6Bean> getHeWeather6() {
        return HeWeather6;
    }

    public void setHeWeather6(List<HeWeather6Bean> HeWeather6) {
        this.HeWeather6 = HeWeather6;
    }

    public static class HeWeather6Bean {
        /**
         * basic : {"cid":"CN101070101","location":"沈阳","parent_city":"沈阳","admin_area":"辽宁","cnty":"中国","lat":"41.79676819","lon":"123.42909241","tz":"+8.00"}
         * update : {"loc":"2018-05-01 11:47","utc":"2018-05-01 03:47"}
         * status : ok
         * daily_forecast : [{"cond_code_d":"101","cond_code_n":"101","cond_txt_d":"多云","cond_txt_n":"多云","date":"2018-05-01","hum":"60","mr":"19:54","ms":"05:41","pcpn":"0.0","pop":"0","pres":"1015","sr":"04:43","ss":"18:44","tmp_max":"20","tmp_min":"10","uv_index":"3","vis":"16","wind_deg":"44","wind_dir":"东北风","wind_sc":"3-4","wind_spd":"16"},{"cond_code_d":"101","cond_code_n":"101","cond_txt_d":"多云","cond_txt_n":"多云","date":"2018-05-02","hum":"34","mr":"20:53","ms":"06:15","pcpn":"0.0","pop":"0","pres":"1016","sr":"04:42","ss":"18:45","tmp_max":"20","tmp_min":"9","uv_index":"5","vis":"18","wind_deg":"9","wind_dir":"北风","wind_sc":"4-5","wind_spd":"31"},{"cond_code_d":"100","cond_code_n":"100","cond_txt_d":"晴","cond_txt_n":"晴","date":"2018-05-03","hum":"26","mr":"21:50","ms":"06:54","pcpn":"0.0","pop":"0","pres":"1014","sr":"04:41","ss":"18:46","tmp_max":"19","tmp_min":"6","uv_index":"5","vis":"20","wind_deg":"1","wind_dir":"北风","wind_sc":"5-6","wind_spd":"40"}]
         */

        private BasicBean basic;
        private UpdateBean update;
        private String status;
        private List<DailyForecastBean> daily_forecast;

        public BasicBean getBasic() {
            return basic;
        }

        public void setBasic(BasicBean basic) {
            this.basic = basic;
        }

        public UpdateBean getUpdate() {
            return update;
        }

        public void setUpdate(UpdateBean update) {
            this.update = update;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public List<DailyForecastBean> getDaily_forecast() {
            return daily_forecast;
        }

        public void setDaily_forecast(List<DailyForecastBean> daily_forecast) {
            this.daily_forecast = daily_forecast;
        }

        public static class BasicBean {
            /**
             * cid : CN101070101
             * location : 沈阳
             * parent_city : 沈阳
             * admin_area : 辽宁
             * cnty : 中国
             * lat : 41.79676819
             * lon : 123.42909241
             * tz : +8.00
             */

            private String cid;
            private String location;
            private String admin_area;
            private String cnty;

            public String getCid() {
                return cid;
            }

            public void setCid(String cid) {
                this.cid = cid;
            }

            public String getLocation() {
                return location;
            }

            public void setLocation(String location) {
                this.location = location;
            }

            public String getAdmin_area() {
                return admin_area;
            }

            public void setAdmin_area(String admin_area) {
                this.admin_area = admin_area;
            }

            public String getCnty() {
                return cnty;
            }

            public void setCnty(String cnty) {
                this.cnty = cnty;
            }
        }

        public static class UpdateBean {
            /**
             * loc : 2018-05-01 11:47
             * utc : 2018-05-01 03:47
             */

            private String loc;
            private String utc;

            public String getLoc() {
                return loc;
            }

            public void setLoc(String loc) {
                this.loc = loc;
            }

            public String getUtc() {
                return utc;
            }

            public void setUtc(String utc) {
                this.utc = utc;
            }
        }

        public static class DailyForecastBean {
            /**
             * cond_code_d : 101
             * cond_code_n : 101
             * cond_txt_d : 多云
             * cond_txt_n : 多云
             * date : 2018-05-01
             * hum : 60
             * mr : 19:54
             * ms : 05:41
             * pcpn : 0.0
             * pop : 0
             * pres : 1015
             * sr : 04:43
             * ss : 18:44
             * tmp_max : 20
             * tmp_min : 10
             * uv_index : 3
             * vis : 16
             * wind_deg : 44
             * wind_dir : 东北风
             * wind_sc : 3-4
             * wind_spd : 16
             */

            private String cond_code_d;
            private String cond_code_n;
            private String cond_txt_d;
            private String cond_txt_n;
            private String date;
            private String hum;
            private String mr;
            private String ms;
            private String pcpn;
            private String pop;
            private String pres;
            private String sr;
            private String ss;
            private String tmp_max;
            private String tmp_min;
            private String uv_index;
            private String vis;
            private String wind_deg;
            private String wind_dir;
            private String wind_sc;
            private String wind_spd;

            public String getCond_code_d() {
                return cond_code_d;
            }

            public void setCond_code_d(String cond_code_d) {
                this.cond_code_d = cond_code_d;
            }

            public String getCond_code_n() {
                return cond_code_n;
            }

            public void setCond_code_n(String cond_code_n) {
                this.cond_code_n = cond_code_n;
            }

            public String getCond_txt_d() {
                return cond_txt_d;
            }

            public void setCond_txt_d(String cond_txt_d) {
                this.cond_txt_d = cond_txt_d;
            }

            public String getCond_txt_n() {
                return cond_txt_n;
            }

            public void setCond_txt_n(String cond_txt_n) {
                this.cond_txt_n = cond_txt_n;
            }

            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }

            public String getHum() {
                return hum;
            }

            public void setHum(String hum) {
                this.hum = hum;
            }

            public String getMr() {
                return mr;
            }

            public void setMr(String mr) {
                this.mr = mr;
            }

            public String getMs() {
                return ms;
            }

            public void setMs(String ms) {
                this.ms = ms;
            }

            public String getPcpn() {
                return pcpn;
            }

            public void setPcpn(String pcpn) {
                this.pcpn = pcpn;
            }

            public String getPop() {
                return pop;
            }

            public void setPop(String pop) {
                this.pop = pop;
            }

            public String getPres() {
                return pres;
            }

            public void setPres(String pres) {
                this.pres = pres;
            }

            public String getSr() {
                return sr;
            }

            public void setSr(String sr) {
                this.sr = sr;
            }

            public String getSs() {
                return ss;
            }

            public void setSs(String ss) {
                this.ss = ss;
            }

            public String getTmp_max() {
                return tmp_max;
            }

            public void setTmp_max(String tmp_max) {
                this.tmp_max = tmp_max;
            }

            public String getTmp_min() {
                return tmp_min;
            }

            public void setTmp_min(String tmp_min) {
                this.tmp_min = tmp_min;
            }

            public String getUv_index() {
                return uv_index;
            }

            public void setUv_index(String uv_index) {
                this.uv_index = uv_index;
            }

            public String getVis() {
                return vis;
            }

            public void setVis(String vis) {
                this.vis = vis;
            }

            public String getWind_deg() {
                return wind_deg;
            }

            public void setWind_deg(String wind_deg) {
                this.wind_deg = wind_deg;
            }

            public String getWind_dir() {
                return wind_dir;
            }

            public void setWind_dir(String wind_dir) {
                this.wind_dir = wind_dir;
            }

            public String getWind_sc() {
                return wind_sc;
            }

            public void setWind_sc(String wind_sc) {
                this.wind_sc = wind_sc;
            }

            public String getWind_spd() {
                return wind_spd;
            }

            public void setWind_spd(String wind_spd) {
                this.wind_spd = wind_spd;
            }
        }
    }
}
