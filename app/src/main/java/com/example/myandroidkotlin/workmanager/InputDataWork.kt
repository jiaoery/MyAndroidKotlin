package com.example.myandroidkotlin.workmanager

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters

/**
 * ClassName: InputDataWork<br/>
 * Description: TODO Description. <br/>
 * date: 2021/6/4 14:39<br/>
 *
 * @author YCKJ1729
 * @version V1.0.0
 * @since JDK 1.8
 */
class InputDataWork(appContext: Context, workerParams: WorkerParameters): Worker(appContext, workerParams){

        override fun doWork(): Result {
            val imageUriInput =
                inputData.getString("IMAGE_URI") ?: return Result.failure()

            uploadFile(imageUriInput)
            return Result.success()
        }

    private fun uploadFile(imageUriInput: String) {
        Log.d("Work",imageUriInput)
    }

}