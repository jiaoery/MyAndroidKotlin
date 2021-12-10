package com.example.myandroidkotlin.rooms

import androidx.lifecycle.LiveData
import androidx.room.*

/**
 * ClassName: UerDao<br/>
 * Description: 操作类
 * date: 2021/5/19 15:42<br/>
 *
 * @author YCKJ1729
 * @version V1.0.0
 * @since JDK 1.8
 */
@Dao
interface UserDao {
    @Query("SELECT * FROM users")
     fun getAll(): List<User>

    @Query("SELECT * FROM users WHERE uid IN (:userIds)")
     fun loadAllByIds(userIds: IntArray): List<User>

    @Query("SELECT * FROM users WHERE first_name LIKE :first AND " +
            "last_name LIKE :last LIMIT 1")
     fun findByName(first: String, last: String): User

    @Insert(onConflict = OnConflictStrategy.REPLACE)
     fun insertAll(vararg users: User)

    @Delete
     fun delete(user: User)
}
