package io.github.mobileteacher.wordsexchange;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity
public class HiddenWord {

    @PrimaryKey
    @NonNull
    private String clearText;

    private String category;
    private String hint;
    private String language;


    public HiddenWord(String clearText, String hint, String category, int level, String language) {
        this.clearText = clearText;
        this.category = category;
        this.hint = hint;
        this.language = language;
        this.level = level;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    private int level;


    public String getClearText() {
        return clearText;
    }

    public void setClearText(String clearText) {
        this.clearText = clearText;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getHint() {
        return hint;
    }

    public void setHint(String hint) {
        this.hint = hint;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
