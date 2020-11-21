package com.dubinsky.programmingjoke;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class JokeDetailActivity extends AppCompatActivity {

    TextView jokeIdFull;
    TextView jokeSetupFull;
    TextView jokeDeliveryFull;
    ApiInterface api;
    private CompositeDisposable disposables;
    String html;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke_detail);
        jokeIdFull = findViewById(R.id.jokeIdFull);
        jokeSetupFull = findViewById(R.id.jokeSetupFull);
        jokeDeliveryFull = findViewById(R.id.jokeDeliveryFull);
        api = ApiConfiguration.getApi();
        disposables = new CompositeDisposable();
        if (getIntent().getExtras() != null) {
            disposables.add(
                    api.joke(getIntent().getIntExtra("id", 1))
                            .subscribeOn(Schedulers.io())
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribe(
                                    (joke) -> {
                                        jokeIdFull.setText("Шутка №" + joke.id);
                                        jokeSetupFull.setText(joke.setup);
                                        jokeDeliveryFull.setText(joke.delivery);
                                    },
                                    (error) -> {
                                        error.printStackTrace();
                                        Toast.makeText(this, error.getMessage(), Toast.LENGTH_LONG).show();
                                    }));
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (disposables.isDisposed()) {
            disposables.dispose();
        }
    }
}