package com.example.jetpackcompose_todoapp.di

import android.content.Context
import androidx.room.Room
import com.example.jetpackcompose_todoapp.data.local.TodoDao
import com.example.jetpackcompose_todoapp.data.local.TodoDatabase
import com.example.jetpackcompose_todoapp.util.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context): TodoDatabase {
        return Room.databaseBuilder(
            context,
            TodoDatabase::class.java,
            Constants.DATABASE_NAME
        ).build()
    }

    @Singleton
    @Provides
    fun provideDao(todoDatabase: TodoDatabase): TodoDao {
        return todoDatabase.todoDao()
    }
}