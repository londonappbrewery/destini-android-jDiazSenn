package com.londonappbrewery.destini;

import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // TODO: Steps 4 & 8 - Declare member variables here:
    Button mTopButton, mBottomButton;
    TextView mStoryText;

    StoryStage[] mStoryArray = {
            new StoryStage(R.string.T1_Story, R.string.T1_Ans1, R.string.T1_Ans2),
            new StoryStage(R.string.T2_Story, R.string.T2_Ans1, R.string.T2_Ans2),
            new StoryStage(R.string.T3_Story, R.string.T3_Ans1, R.string.T3_Ans2),
            new StoryStage(R.string.T4_End, -1, -1),
            new StoryStage(R.string.T5_End, -1, -1),
            new StoryStage(R.string.T6_End, -1, -1),

    };

    int mStoryIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // TODO: Step 5 - Wire up the 3 views from the layout to the member variables:
        mTopButton = findViewById(R.id.buttonTop);
        mBottomButton = findViewById(R.id.buttonBottom);
        mStoryText = findViewById(R.id.storyTextView);

        if(savedInstanceState != null) {
            mStoryIndex = savedInstanceState.getInt("StoryIndexKey");
        } else {
            mStoryIndex = 0;
        }

        setValues();

        // TODO: Steps 6, 7, & 9 - Set a listener on the top button:
        mTopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateStory(1);
            }
        });


        // TODO: Steps 6, 7, & 9 - Set a listener on the bottom button:
        mBottomButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateStory(2);
            }
        });

    }

    public void updateStory(int buttonPressed){
        if(buttonPressed == 1) {
            Log.d("DESTINY###", "Pressed Top Buttom");
            switch(mStoryIndex) {
                case 0:
                    mStoryIndex = 2;
                    break;
                case 1:
                    mStoryIndex = 2;
                    break;
                case 2:
                    mStoryIndex = 5;
                    break;
            }
        } else {
            Log.d("DESTINY###", "Pressed Bottom Button");
            switch(mStoryIndex) {
                case 0:
                    mStoryIndex = 1;
                    break;
                case 1:
                    mStoryIndex = 3;
                    break;
                case 2:
                    mStoryIndex = 4;
                    break;
            }
        }
        setValues();
    }

    public void setValues() {
        mStoryText.setText(mStoryArray[mStoryIndex].getStoryText());
        if(mStoryArray[mStoryIndex].getTopButtonText() > 0) {
            mTopButton.setText(mStoryArray[mStoryIndex].getTopButtonText());
            mBottomButton.setText(mStoryArray[mStoryIndex].getBottomButtonText());
        } else {
            mTopButton.setVisibility(View.GONE);
            mBottomButton.setVisibility(View.GONE);
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("StoryIndexKey", mStoryIndex);
    }
}
