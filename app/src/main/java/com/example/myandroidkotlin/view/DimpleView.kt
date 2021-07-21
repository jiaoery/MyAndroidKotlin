package com.example.myandroidkotlin.view

import android.animation.ValueAnimator
import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import android.view.animation.LinearInterpolator
import java.lang.Math.*
import java.util.*
import kotlin.system.measureTimeMillis

/**
 * ClassName: DimpleView<br/>
 * Description: TODO Description. <br/>
 * date: 2020/9/14 15:44<br/>
 *
 * @author YCKJ1729
 * @version V1.0.0
 * @since JDK 1.8
 */
class DimpleView(context: Context?, attrs: AttributeSet): View(context,attrs){
    //定义一个粒子的集合
    private var particleList =  mutableListOf<Particle>()
    //定义画笔
    private var paint = Paint()
    var path = Path()

    private var mWidth = 0f
    private var mHeight = 0f
    private var animator = ValueAnimator.ofFloat(0f, 1f)

    private val pathMeasure = PathMeasure()//路径，用于测量扩散圆某一处的X,Y值
    private var pos = FloatArray(2) //扩散圆上某一点的x,y
    private val tan = FloatArray(2)//扩散圆上某一点切线
    private val random = Random()
    private val particleNumber = 2000//粒子数量
    private val particleRadius = 2.2f//粒子半径
    private val diffusionRadius = 268f//扩散圆半径



    init {
        //初始化动画效果
        animator.duration = 2000
        animator.repeatCount = -1
        animator.interpolator = LinearInterpolator()
        animator.addUpdateListener {
            updateParticle(it.animatedValue as Float)
            invalidate()
        }
        //初始化画笔效果
        paint.color = Color.WHITE
        paint.isAntiAlias = true
    }

    //计算粒子的围绕半径和相关属性
    private fun updateParticle(fl: Float) {
        particleList.forEachIndexed { index, particle ->
            //当粒子的当前偏移量超过最大偏移量
            if (particle.offSet > particle.maxOffSet) {
                particle.offSet = 0f
                particle.speed = random.nextInt(3) + 1.5f
                particle.maxOffSet = random.nextInt(250).toFloat()
            }
            //粒子起点x坐标
            particle.x = (mWidth / 2 + cos(particle.angle) * (diffusionRadius + particle.offSet)).toFloat()+particle.offSetX*particle.direction

            if (particle.y > mHeight / 2) {
                particle.y = (sin(particle.angle) * (diffusionRadius + particle.offSet) + mHeight / 2).toFloat()
            } else {
                particle.y = (mHeight / 2 - sin(particle.angle) * (diffusionRadius + particle.offSet)).toFloat()
            }

            particle.offSet += particle.speed
        }
    }


    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        //绘制粒子
        val time = measureTimeMillis {
            particleList.forEachIndexed { _, particle ->
                //随着渐变，改变粒子的透明度
                if (particle.offSet > 5f) {
                    paint.alpha = ((1f - particle.offSet / particle.maxOffSet) * 0.8 * 225f).toInt()
                    canvas.drawCircle(particle.x, particle.y, particle.radius, paint)
                } else {
                    //粒子透明
                    paint.alpha = 225
                }
                canvas.drawCircle(particle.x, particle.y, particle.radius, paint)
            }
        }
//        Log.d("DimpleView","ondraw cost  time total :$time")
    }


    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        mWidth = w.toFloat()
        mHeight = h.toFloat()
        //确定路径中心和扩散半径
        path.addCircle(mWidth / 2, mHeight / 2, diffusionRadius, Path.Direction.CCW)
        pathMeasure.setPath(path, false)
        //生成对应数量的粒子
        for (i in 0 .. particleNumber) {
            pathMeasure.getPosTan(i / particleNumber.toFloat() * pathMeasure.length, pos, tan)
            val offSet = random.nextInt(200)
            //随机速度
            val speed = random.nextInt(2) + 0.5f
            val randomX = random.nextInt(6) - 3f
            val randomY = random.nextInt(6) - 3f
            val offSetX = random.nextInt(3)
            val direction = random.nextInt(3)-1.5f
            val angel = acos(((pos[0] - mWidth / 2) / diffusionRadius).toDouble())
            val maxOffSet = random.nextInt(250) + 0f
            particleList.add(
                Particle(
                    pos[0] + randomX,
                    pos[1] + randomY,
                    particleRadius,
                    offSetX.toFloat(),
                    offSet.toFloat(),
                    direction,
                    speed,
                    angel,
                    maxOffSet
                )
            )
        }
        animator.start()
    }

}