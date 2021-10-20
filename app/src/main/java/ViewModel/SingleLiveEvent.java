package ViewModel;

import android.util.Log;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import java.util.concurrent.atomic.AtomicBoolean;

public class SingleLiveEvent<T> extends MutableLiveData {
    private  static final  String TAG= "SingleLiveEvent";
    private final AtomicBoolean mPending = new AtomicBoolean(false);





    @Override
    public void observe(@NonNull LifecycleOwner owner, @NonNull Observer observer) {
        if (hasActiveObservers()) {
            Log.w(TAG, "observe: Mutltple observers registred but only one will notified of changes.");
        }
        super.observe(owner, t -> {
            if (mPending.compareAndSet(true,false)){
                observer.onChanged(t);
            }
        });
    }

    @MainThread
    public void setValue(@NonNull Object t) {
        mPending.set(true);
        super.setValue(t);
    }
    @SuppressWarnings({"unused", "RedundantSupression"})
    @MainThread
    public void call() {
        setValue(null);
    }
}
