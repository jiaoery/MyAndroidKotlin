package com.example.myandroidkotlin.workmanager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.work.*
import com.example.myandroidkotlin.R
import com.example.myandroidkotlin.databinding.ActivityWorkManagerBinding
import java.util.concurrent.TimeUnit

class WorkManagerActivity : AppCompatActivity() {

    private lateinit var binding: ActivityWorkManagerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_work_manager)

    }


    fun onclick(view: View) {
        when (view.id) {
            R.id.btn_add_work -> addWork()
            R.id.btn_period_work -> addPeroidWork()
            R.id.btn_interval_work -> addIntervalWork()
            R.id.btn_constraint_work -> addConstraintWork()
            R.id.btn_interval_delay_work -> addintervalDelayWork()
            R.id.btn_retry_work->addRetryWork()
            R.id.btn_inputdata_work->inputDataWork()
        }
    }

    private fun addWork() {
        val uploadWorkRequest: WorkRequest =
            OneTimeWorkRequestBuilder<UploadWorker>()
                .addTag("cleanup")
                .build()

        WorkManager
            .getInstance(this)
            .enqueue(uploadWorkRequest)
    }

    /**
     * 周期性 时间必须超过15分钟一次的频率；否则报 Interval duration lesser than minimum allowed value; Changed to 900000"
     */
    private fun addPeroidWork() {
        val saveRequest =
            PeriodicWorkRequestBuilder<UploadWorker>(16, TimeUnit.MINUTES)
                .addTag("cleanup")
                .build()

        WorkManager
            .getInstance(this)
            .enqueue(saveRequest)
    }


    /**
     * 提交周期间隔性的work任务；这里具备灵活时间，如这类从 45分钟 ~1小时内都可以自由时间运行
     */
    private fun addIntervalWork() {

        val myUploadWork = PeriodicWorkRequestBuilder<UploadWorker>(
            1, TimeUnit.HOURS, // repeatInterval (the period cycle)
            15, TimeUnit.MINUTES
        ) // flexInterval
            .addTag("cleanup")
            .build()

        WorkManager
            .getInstance(this)
            .enqueue(myUploadWork)

    }

    /**
     * 添加带约束条件的worker任务
     */
    private fun addConstraintWork() {

        /**
         * 添加限制条件
         */
        val constraints = Constraints.Builder()
            .setRequiredNetworkType(NetworkType.UNMETERED)
            .setRequiresCharging(true)
            .build()

        val myWorkRequest: WorkRequest =
            OneTimeWorkRequestBuilder<UploadWorker>()
                .setConstraints(constraints)
                .addTag("cleanup")
                .build()

        WorkManager
            .getInstance(this)
            .enqueue(myWorkRequest)

    }

    /**
     * 间隔型
     */
    private fun addintervalDelayWork() {
        val myWorkRequest = OneTimeWorkRequestBuilder<UploadWorker>()
            .setInitialDelay(10, TimeUnit.MINUTES)
            .addTag("cleanup")
            .build()

        WorkManager.getInstance(this).enqueue(myWorkRequest)

    }

    /**
     * 重试
     */
    private fun addRetryWork() {
        val myWorkRequest = OneTimeWorkRequestBuilder<RetryWorker>()
            .setBackoffCriteria(
                //具备线性LINEAR和指数型EXPONENTIAL
                BackoffPolicy.LINEAR,
                OneTimeWorkRequest.MIN_BACKOFF_MILLIS,
                TimeUnit.MILLISECONDS
            )
            .build()

        WorkManager.getInstance(this).enqueue(myWorkRequest)
    }


    /**
     * 带输入数据的work
     */
    private fun inputDataWork() {
        // Create a WorkRequest for your Worker and sending it input
        val myUploadWork = OneTimeWorkRequestBuilder<InputDataWork>()
            .setInputData(
                workDataOf(
                    "IMAGE_URI" to "http://www.baidu.com"
                )
            )
            .build()

        WorkManager.getInstance(this).enqueue(myUploadWork)
    }
}