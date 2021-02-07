package com.example.myandroidkotlin

/**
 * ClassName: OnNetworkStatusChange<br/>
 * Description: TODO Description. <br/>
 * date: 2021/1/29 17:45<br/>
 *
 * @author YCKJ1729
 * @version V1.0.0
 * @since JDK 1.8
 */
interface OnNetworkStatusChange {
    /**
     * 网络类型改变
     * @param isAviable 网络是否可用，true 可用
     * @param type 网络类型  （网络不可用 type -1）
     */
    fun onNetWorkStatusChanged(isAviable:Boolean,type:Int)
}