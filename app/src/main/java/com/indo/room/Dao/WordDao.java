package com.indo.room.Dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.indo.room.enity.Word;

import java.util.List;

@Dao
public interface WordDao {

    @Insert
    void insert(Word word);

    @Query("delete from word_table")
    void deleteAll();

    @Query("Select * from word_table order BY word ASC")
    LiveData<List<Word>>getAllWord();
}
