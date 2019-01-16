package com.wancient.springcloud.manage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 统计
 * Created by IntelliJ IDEA.
 * User: CainWu
 * Date: 2018/12/24
 * Time: 9:22
 * To change this template use File | Settings | File Templates.
 **/
@RequestMapping("/manage/charts")
@Controller
public class ChartsController {

    /**
     * 折线图
     *
     * @return
     */
    @RequestMapping("/line_chart")
    public String lineChart() {
        return "/charts/line-chart";
    }

    /**
     * 时间轴折线图
     * @return
     */
    @RequestMapping("/timeline_line_chart")
    public String timelineLineChart() {
        return  "/charts/timeline-line-chart";
    }

    /**
     * 区域图
     * @return
     */
    @RequestMapping("/area_chart")
    public String areaChart() {
        return  "/charts/area-chart";
    }

    /**
     * 柱状图
     * @return
     */
    @RequestMapping("histogram_chart")
    public String histogramChart() {
        return  "/charts/histogram-chart";
    }

    /**
     * 饼状图
     * @return
     */
    @RequestMapping("pie_chart")
    public String pieChart() {
        return  "/charts/pie-chart";
    }

    /**
     * 3D柱状图
     * @return
     */
    @RequestMapping("three_d_histogram_chart")
    public String threeDHistogramChart() {
        return  "/charts/3d-histogram-chart";
    }

    /**
     * 3D饼状图
     * @return
     */
    @RequestMapping("three_d_pie_chart")
    public String threeDPieChart() {
        return  "/charts/3d-pie-chart";
    }



}
