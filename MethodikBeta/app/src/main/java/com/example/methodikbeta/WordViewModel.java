package com.example.methodikbeta;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import java.util.List;

//    Warning:
// Never pass context into ViewModel instances.
// Do not store Activity, Fragment, or View instances
// or their Context in the ViewModel.

// Provide data to the UI survive configuration changes
// Acts as a communication center between the Repository and the UI
public class WordViewModel extends AndroidViewModel {

    private WordRepository mRepository;

    private LiveData<List<Word>> mAllWords;

    public WordViewModel (Application application) {
        super(application);
        mRepository = new WordRepository(application);
        mAllWords = mRepository.getAllWords();
    }

    LiveData<List<Word>> getAllWords() {
        return mAllWords;
    }

    public void insert(Word word) {
        mRepository.insert(word);
    }
}
