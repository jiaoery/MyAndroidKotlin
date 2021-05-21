package com.example.myandroidkotlin.rooms

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import java.lang.RuntimeException

/**
 * ClassName: AppDatabase<br/>
 * Description: TODO Description. <br/>
 * date: 2021/5/19 15:45<br/>
 *
 * @author YCKJ1729
 * @version V1.0.0
 * @since JDK 1.8
 */
@Database(entities = [User::class], version = 2,exportSchema = true)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao

    companion object{
        private const val OLD_DB_NAME = "rooms.db"
        private const val DB_NAME = "test.db"

        private var  rooms:AppDatabase?= null

        private val MIGRATION_1_2 = object : Migration(1, 2) {
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("CREATE TABLE `users` (`uid` INTEGER, `first_name` TEXT, 'last_name' TEXT" +
                        "PRIMARY KEY(`uid`))")
            }
        }

        fun create(applicationContext: Context): AppDatabase {
            // We eventually delete the old DB if a previous version of Chuck/Chucker was used.
            applicationContext.getDatabasePath(OLD_DB_NAME).delete()
            rooms = Room.databaseBuilder(applicationContext, AppDatabase::class.java, DB_NAME)
                .addMigrations(MIGRATION_1_2)
                .fallbackToDestructiveMigration()
                .build()

            return rooms!!
        }

        fun getRooms():AppDatabase{
            if(rooms==null){
                throw RuntimeException("Please create AppDatabase first!")
            }
            return rooms!!
        }

    }
}
