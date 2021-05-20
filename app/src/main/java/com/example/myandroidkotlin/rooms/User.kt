package com.example.myandroidkotlin.rooms

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * ClassName: User<br/>
 * Description: TODO Description. <br/>
 * date: 2021/5/19 15:41<br/>
 *
 * @author YCKJ1729
 * @version V1.0.0
 * @since JDK 1.8
 */
@Entity(tableName = "users")
data class User(
    //指定key值
    @PrimaryKey val uid: Int,
    //指定在数据库表单中的 列名
    @ColumnInfo(name = "first_name") val firstName: String?,
    @ColumnInfo(name = "last_name") val lastName: String?
)

