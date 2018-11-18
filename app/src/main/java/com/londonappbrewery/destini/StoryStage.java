package com.londonappbrewery.destini;

public class StoryStage {

    private int storyText, topButtonText, bottomButtonText;

    public StoryStage(int storyText, int topButtonText, int bottomButtonText){
        this.storyText  = storyText;
        this.topButtonText = topButtonText;
        this.bottomButtonText = bottomButtonText;
    }

    public int getStoryText() {
        return storyText;
    }

    public void setStoryText(int storyText) {
        this.storyText = storyText;
    }

    public int getTopButtonText() {
        return topButtonText;
    }

    public void setTopButtonText(int topButtonText) {
        this.topButtonText = topButtonText;
    }

    public int getBottomButtonText() {
        return bottomButtonText;
    }

    public void setBottomButtonText(int bottomButtonText) {
        this.bottomButtonText = bottomButtonText;
    }
}
