package com.example.myandroidkotlin.view

/**
 * ClassName: cn.cloudwalk.myapplication.kotlin.Particle<br/>
 * Description: 粒子类
 * date: 2020/9/14 15:41<br/>
 *
 * @author YCKJ1729
 * @version V1.0.0
 * @since JDK 1.8
 */

class Particle(
    //粒子出发的x轴
    var x: Float,
    //粒子出发的y轴
    var y: Float,
    //粒子半径
    var radius: Float,
    //x轴偏移量
    var offSetX: Float,
    //最终偏移量
    var offSet: Float,
    //方向距离
    var direction: Float,
    //移动速度
    var speed: Float,
    //移动角度
    var angle: Double,
    //最大偏移量
    var maxOffSet: Float
)