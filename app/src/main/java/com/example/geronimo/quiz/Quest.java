package com.example.geronimo.quiz;

/**
 * Created by Geronimo on 20.01.2018.
 */

public class Quest {
    private int mTextResId;
    private boolean mAnswerTrue;


    public Quest(int mTextResId, boolean mAnswerTrue){
        this.mTextResId = mTextResId;
        this.mAnswerTrue = mAnswerTrue;
    }

    public int getTextResId() {
        return mTextResId;
    }

    public void setTextResId(int textResId) {
        mTextResId = textResId;
    }

    public boolean isAnswerTrue() {
        return mAnswerTrue;
    }

    public void setAnswerTrue(boolean answerTrue) {
        mAnswerTrue = answerTrue;
    }
}
