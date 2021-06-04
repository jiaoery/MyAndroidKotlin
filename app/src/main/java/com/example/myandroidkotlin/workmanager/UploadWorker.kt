package com.example.myandroidkotlin.workmanager

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters

/**
 * ClassName: UploadWorker<br/>
 * Description: 上传任务
 * date: 2021/6/3 17:52<br/>
 *
 * @author YCKJ1729
 * @version V1.0.0
 * @since JDK 1.8
 */

class UploadWorker(appContext: Context, workerParams: WorkerParameters): Worker(appContext, workerParams) {

    override fun doWork(): Result {

        // Do the work here--in this case, upload the images.
        uploadImages()

        // Indicate whether the work finished successfully with the Result
        return Result.success()
    }

    private fun uploadImages(){
        Log.d("Work","UploadWorker is working")
    }
}
