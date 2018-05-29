package com.indo.room.Repository;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import com.indo.room.Dao.WordDao;
import com.indo.room.Room.WordRoomDatabase;
import com.indo.room.enity.Word;

import java.util.List;

public class WordRepository {

    private WordDao mWordDao;
    private LiveData<List<Word>> mAllWord;

    public WordRepository(Application application) {
        WordRoomDatabase db = WordRoomDatabase.getDatabase(application);
        mWordDao = db.wordDao();
        mAllWord = mWordDao.getAllWord();
    }
    public LiveData<List<Word>> getAllWord(){
        return mAllWord;
    }
    public void insert(Word word){
        new insertAsyncTask(mWordDao).execute(word);
    }

    public static class insertAsyncTask extends AsyncTask<Word, Void, Void>{

        private WordDao mAsynsTackDao;
        insertAsyncTask(WordDao dao){
            mAsynsTackDao = dao;
        }
        @Override
        protected Void doInBackground(Word... words) {
           mAsynsTackDao.insert(words [0]);
            return null;
        }
    }
}
