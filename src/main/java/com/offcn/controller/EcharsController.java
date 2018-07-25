package com.offcn.controller;

import com.offcn.bean.Echarts;
import com.offcn.bean.Echartsb;
import com.offcn.bean.Echartsc;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class EcharsController {


    @RequestMapping("/bar")
    public @ResponseBody List<Echarts> bar(){
        Echarts e = new Echarts();
        e.setName("a");
        e.setAge(1);
        Echarts e2 = new Echarts();
        e2.setName("b");
        e2.setAge(2);
        Echarts e3 = new Echarts();
        e3.setName("c");
        e3.setAge(3);
        List<Echarts> list = new ArrayList<Echarts>();
        list.add(e);
        list.add(e2);
        list.add(e3);

        return list;
    }

    @RequestMapping("/barb")
    public @ResponseBody List<Echartsb> barb(){
        Echartsb e = new Echartsb();
        e.setName("a");
        e.setValue(100);
        Echartsb e2 = new Echartsb();
        e2.setName("b");
        e2.setValue(200);
        Echartsb e3 = new Echartsb();
        e3.setName("c");
        e3.setValue(300);
        List<Echartsb> list = new ArrayList<Echartsb>();
        list.add(e);
        list.add(e2);
        list.add(e3);

        return list;
    }

    @RequestMapping("/barc")
    public @ResponseBody List<Echartsc> barc(){
        Echartsc e = new Echartsc();
        e.setValue(100);
        Echartsc e2 = new Echartsc();
        e2.setValue(200);
        Echartsc e3 = new Echartsc();
        e3.setValue(300);
        List<Echartsc> list = new ArrayList<Echartsc>();
        list.add(e);
        list.add(e2);
        list.add(e3);

        return list;
    }




}
