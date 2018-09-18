package io.github.mobileteacher.wordsexchange;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

@Dao
public interface HiddenWordDAO {
    @Insert
    public void insertWord(HiddenWord hiddenWord);

    @Update
    public void updateWord(HiddenWord hiddenWord);

    @Delete
    public void deleteWord(HiddenWord hiddenWord);

    @Query("SELECT * FROM hiddenword")
    public HiddenWord[] getAllWords();

    @Query("SELECT * FROM hiddenword WHERE level = :chosenLevel")
    public HiddenWord[] getWordsFromLevel(int chosenLevel);

}
