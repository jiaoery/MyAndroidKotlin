package com.example.myandroidkotlin.workmanager

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters

/**
 * ClassName: RetryWorker<br/>
 * Description: TODO Description. <br/>
 * date: 2021/6/4 14:20<br/>
 *
 * @author YCKJ1729
 * @version V1.0.0
 * @since JDK 1.8
 */
class RetryWorker(appContext: Context, workerParams: WorkerParameters): Worker(appContext, workerParams) {

    override fun doWork(): Result {

        // Do the work here--in this case, upload the images.
        uploadImages()

        // Indicate whether the work finished successfully with the Result
        return Result.retry()
    }

    private fun uploadImages(){
        Log.d("Work","UploadWorker is working")
    }
}