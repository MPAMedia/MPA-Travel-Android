package com.mpa.android.nefertari.data;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import com.mpa.android.nefertari.model.CityInfo;
import com.mpa.android.nefertari.model.UserComment;
import com.mpa.android.nefertari.model.WeatherDay;
import com.mpa.android.nefertari.utils.DateUtils;
import com.mpa.android.nefertari.utils.StringUtils;

/**
 * Created by phamngocthanh on 7/12/17.
 */

public class SampleData {
    public static List<CityInfo> getCityInfoList (){
        List<CityInfo> cityInfoList = new LinkedList<>();
        for (int i = 0; i < 30; i++){
            CityInfo cityInfo = new CityInfo();
            cityInfo.setCityId(String.valueOf(i));
            cityInfo.setCityName("City Name: " + i);
            cityInfoList.add(cityInfo);
        }

        return cityInfoList;
    }

    public static  List<UserComment> getListComment(int size){
        List<UserComment> userCommentList = new LinkedList<>();
        for (int i = 0; i < size; i++){
            UserComment userComment = new UserComment();
            userComment.setUserName("User "+ i);
            userComment.setcDate(DateUtils.randomDate());
            userComment.setText(StringUtils.randomString(new Random().nextInt(200)));
            userCommentList.add(userComment);
        }

        return userCommentList;
    }

    public static  List<WeatherDay> getListWeatherDays(int size){
        List<WeatherDay> userCommentList = new LinkedList<>();
        for (int i = 0; i < size; i++){
            WeatherDay weatherDay = new WeatherDay();
            weatherDay.setDay("Day "+i);
            weatherDay.setTempHi(new Random().nextInt(50)+"");
            weatherDay.setTempLo(new Random().nextInt(50)+"");
            weatherDay.setTempStatus("rainning day");
            weatherDay.setTempThumb("1");
            userCommentList.add(weatherDay);
        }

        return userCommentList;
    }
}
