package com.example.myandroidkotlin.permissionx

import android.Manifest
import android.content.ActivityNotFoundException
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import com.example.myandroidkotlin.BaseActivity
import com.permissionx.guolindev.PermissionX


class PermissionActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_permission)
        PermissionX.init(this@PermissionActivity)
            .permissions(
                Manifest.permission.CALL_PHONE,
                Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.CAMERA
            )
            .setDialogTintColor(Color.parseColor("#008577"), Color.parseColor("#83e8dd"))
            //在开始前解释授权用法
            .explainReasonBeforeRequest()
            .onExplainRequestReason { scope, deniedList ->
                val message = "PermissionX需要您同意以下权限才能正常使用"
                scope.showRequestReasonDialog(deniedList, message, "确定", "取消")
            }
            //永久无法授权的权限，需打开系统界面授权
            .onForwardToSettings { scope, deniedList ->
                scope.showForwardToSettingsDialog(deniedList, "您需要去应用程序设置当中手动开启权限", "我已明白", "取消")
            }
            .request { allGranted, grantedList, deniedList ->
                if (allGranted) {
                    Toast.makeText(this@PermissionActivity, "所有申请的权限都已通过", Toast.LENGTH_SHORT).show()
                    openAssignFolder()
                } else {
                    Toast.makeText(
                        this@PermissionActivity,
                        "您拒绝了如下权限$deniedList",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
    }


    private fun openAssignFolder() {

        val i = Intent()
        i.action = Intent.ACTION_GET_CONTENT
        i.addCategory(Intent.CATEGORY_OPENABLE)
            i.type = "video/*,image/jpg,image/jpeg,image/png,image/bmp"
        i.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION or Intent.FLAG_GRANT_WRITE_URI_PERMISSION)

        try {
            startActivity(i)
            //            startActivity(Intent.createChooser(intent,"选择浏览工具"));
        } catch (e: ActivityNotFoundException) {
            e.printStackTrace()
        }
    }
}