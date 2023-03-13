package com.wowcher.clock.service;

import com.wowcher.clock.utils.GeneralUtils;
import org.springframework.stereotype.Service;

@Service
public class ClockServiceImpl implements ClockService{

    @Override
    public String convertTime(String time) {
        GeneralUtils.validate(time);
        String output = "It's ";
        String [] timeArr = time.split(":");
        if("12".equals(timeArr[0]) && "00".equals(timeArr[1])) {
            output += "Midday";
        }else if("00".equals(timeArr[0]) && "00".equals(timeArr[1])) {
            output += "Midnight";
        }else {
            output += GeneralUtils.solution(Integer.parseInt(timeArr[0]));
            output += " ";
            output += GeneralUtils.solution(Integer.parseInt(timeArr[1]));
        }
        return output;

    }
}
