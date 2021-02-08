package com.example.myandroidkotlin.permissionx

import android.Manifest
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.myandroidkotlin.R
import com.permissionx.guolindev.PermissionX

class PermissionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_permission)
        PermissionX.init(this@PermissionActivity)
            .permissions(
                Manifest.permission.CALL_PHONE,
                Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.CAMERA
            )
            .setDialogTintColor(Color.parseColor("#008577"), Color.parseColor("#83e8dd"))
            //在开始前解释授权用法
            .explainReasonBeforeRequest()
            .onExplainRequestReason { scope,deniedList ->
                val message = "PermissionX需要您同意以下权限才能正常使用"
                scope.showRequestReasonDialog(deniedList, message, "确定", "取消")
            }
            //永久无法授权的权限，需打开系统界面授权
            .onForwardToSettings { scope,deniedList ->
                scope.showForwardToSettingsDialog(deniedList, "您需要去应用程序设置当中手动开启权限", "我已明白", "取消")
            }
            .request { allGranted, grantedList, deniedList ->
                if (allGranted) {
                    Toast.makeText(this@PermissionActivity, "所有申请的权限都已通过", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this@PermissionActivity, "您拒绝了如下权限$deniedList", Toast.LENGTH_SHORT).show()
                }
            }
    }
}