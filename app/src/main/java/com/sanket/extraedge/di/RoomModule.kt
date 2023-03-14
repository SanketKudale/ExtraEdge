package com.sanket.extraedge.di

import android.content.Context
import androidx.room.Room
import com.sanket.extraedge.db.AppDatabase
import com.sanket.extraedge.db.Constant
import com.sanket.extraedge.db.RocketEntity
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    @Provides
    @Singleton
    fun provide(@ApplicationContext context: Context) = Room.databaseBuilder(
        context, AppDatabase::class.java, Constant.ROCKET_TABLE)
        .allowMainThreadQueries()
        .fallbackToDestructiveMigration()
        .build()


    @Provides
    @Singleton
    fun provideDao(db: AppDatabase) = db.appDao()

    @Provides
    fun provideEntity() = RocketEntity()
}