package com.example.geronimo.quiz;

import android.app.Activity;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
    private Button mtButt, mfButt, mNext, mPrev;
    private TextView mTextView;
    private static final String TAG = "QuizActivity";
    private Quest[] mQuestsBank = new Quest[]{
            new Quest(R.string.question_australia,true),
            new Quest(R.string.question_oceans,true),
            new Quest(R.string.question_mideast,false),
            new Quest(R.string.question_africa,false),
            new Quest(R.string.question_americas,true),
            new Quest(R.string.question_asia,true)

    };
    private int mCurrentIndex = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate(Bundle) called");
        setContentView(R.layout.activity_main);
    mNext = (Button) findViewById(R.id.mnextButt);
    mtButt = (Button) findViewById(R.id.mtrueButt);
    mfButt = (Button) findViewById(R.id.mfalceButt);
    mTextView = (TextView) findViewById(R.id.mQuestion);
    mPrev = (Button) findViewById(R.id.mprevButt);
        updateQuestion();

    mtButt.setOnClickListener(new View.OnClickListener(){
        @Override
        public void onClick(View view) {

            checkAnswer(true);
        }
    });

    mfButt.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            checkAnswer(false);
        }
    });

    mNext.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            mCurrentIndex = (mCurrentIndex + 1) % mQuestsBank.length;
            updateQuestion();
        }
    });
    mPrev.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
           if(mCurrentIndex > 0) {
               mCurrentIndex = (mCurrentIndex - 1) % mQuestsBank.length;
               updateQuestion();
           }
        }
    });

    }
    private void updateQuestion(){
        int question = mQuestsBank[mCurrentIndex].getTextResId();
        mTextView.setText((getResources().getString(question)));

    }

    private void checkAnswer(boolean answerLog){
        boolean answerIsTrue = mQuestsBank[mCurrentIndex].isAnswerTrue();

        if(answerIsTrue == answerLog){

            Toast.makeText(MainActivity.this,"Правильный ответ",Toast.LENGTH_SHORT).show();

        }else{
            Toast.makeText(MainActivity.this,"уи-уи-уи-уи",Toast.LENGTH_SHORT).show();

        }


    }
    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG, "onStart() called");
    }
    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "onResume() called");
    }
    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, "onPause() called");
    }
    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG, "onStop() called");
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy() called");
    }//
}
