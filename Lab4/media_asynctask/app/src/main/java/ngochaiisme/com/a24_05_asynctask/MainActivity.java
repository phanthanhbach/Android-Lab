package ngochaiisme.com.a24_05_asynctask;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.Bundle;

import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class MainActivity extends AppCompatActivity {
    private String audioUrl = "https://vnno-vn-5-tf-mp3-s1-zmp3.zmdcdn.me/5208b7cb2d8fc4d19d9e/8605293512770827667?authen=exp=1687501341~acl=/5208b7cb2d8fc4d19d9e/*~hmac=5f6734f47e954e8c17a92666d8316022&fs=MTY4NzMyODU0MTIwM3x3ZWJWNnwxMDM0Njg5OTAxfDEwNC4yOC4yMzmUsICdUngNzI&filename=Bai-Ka-Tuoi-Tre-JGKiD-Emcee-L-KraziNoyze-Linh-Cao.mp3";
    private TextView mTitleTextView;
    private SeekBar mSeekBar;
    private MediaPlayer mediaPlayer;
    private Button playButton;
    private Button pauseButton;
    private ProgressBar progressBar;
    private Handler mHandler = new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTitleTextView = findViewById(R.id.title_text_view);
        mSeekBar = findViewById(R.id.seek_bar);
        playButton = findViewById(R.id.play_button);
        pauseButton = findViewById(R.id.pause_button);
        progressBar = findViewById(R.id.progress_bar);
        mediaPlayer = new MediaPlayer();

        new DownloadAudioTask().execute(audioUrl);

        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mediaPlayer.isPlaying()) {
                    mediaPlayer.start();
                }

                updateSeekBar();
            }
        });
        pauseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mediaPlayer.isPlaying()) {
                    mediaPlayer.pause();
                }
            }
        });
    }

    private class DownloadAudioTask extends AsyncTask<String, Integer, Boolean> {
       private File audioFile;
        @Override
        protected Boolean doInBackground(String... params) {
            String audioUrl = params[0];
            int totalSize = 0;
            int downloadedSize = 0;
            try {
                URL url = new URL(audioUrl);
                URLConnection connection = url.openConnection();
                connection.connect();
                totalSize = connection.getContentLength();
                InputStream inputStream = new BufferedInputStream(url.openStream());
              audioFile = createTempAudioFile();
               FileOutputStream outputStream = new FileOutputStream(audioFile);
                byte[] buffer = new byte[1024];
                int bufferLength;
                while ((bufferLength = inputStream.read(buffer)) > 0) {
                    downloadedSize += bufferLength;
                    publishProgress((int) ((downloadedSize * 100) / totalSize));
                  outputStream.write(buffer, 0, bufferLength);
                    }

               outputStream.close();
                try {
                    mediaPlayer.setDataSource(audioFile.getAbsolutePath());
                    Log.e("check_0511", "link mp3: "+ audioFile.getAbsolutePath() );
                    mediaPlayer.prepare();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
               inputStream.close();

                return true;
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
        }
        @Override
        protected void onPreExecute() {
            progressBar.setVisibility(View.VISIBLE);
            playButton.setEnabled(false);
            pauseButton.setEnabled(false);
        }
        @Override
        protected void onPostExecute(Boolean result) {
            progressBar.setVisibility(View.GONE);
            if (result) {
                playButton.setEnabled(true);
                pauseButton.setEnabled(true);
                mTitleTextView.setText("Bài Ka Tuổi Trẻ" +"\n"
                        +convertDuration(mediaPlayer.getCurrentPosition()) +
                        "/"+ convertDuration( mediaPlayer.getDuration()) );
                Toast.makeText(getApplicationContext(),"Bài hát đã sẵn sàng.",Toast.LENGTH_SHORT).show();
            }
        }
        @Override
        protected void onProgressUpdate(Integer... values) {
            progressBar.setProgress(values[0]);
        }
        private File createTempAudioFile() throws IOException {
            File cacheDir = getCacheDir();
            String fileName = "temp_audio.mp3";
            File tempFile = new File(cacheDir, fileName);
            tempFile.createNewFile();
            return tempFile;
        }
    }








    private void updateSeekBar() {
        mSeekBar.setMax(mediaPlayer.getDuration());
      //  Toast.makeText(getApplicationContext(),"Chuẩn bị update seekbar",Toast.LENGTH_SHORT).show();
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (mediaPlayer != null) {
                    mTitleTextView.setText("Bài Ka Tuổi Trẻ - đang phát" +"\n"
                            +convertDuration(mediaPlayer.getCurrentPosition()) +
                            "/"+ convertDuration( mediaPlayer.getDuration()) );
                  //  Toast.makeText(getApplicationContext(),"dang update seekbar",Toast.LENGTH_SHORT).show();
                    mSeekBar.setProgress(mediaPlayer.getCurrentPosition());
                    Log.e("check_0511", "current Position"+mediaPlayer.getCurrentPosition());
                    Log.e("check_0511", "Duration"+mediaPlayer.getCurrentPosition());
                    updateSeekBar();
                }
            }
        }, 1000);
    }
    private String convertDuration(long duration) {
        int minutes = (int) (duration / (1000 * 60));
        int seconds = (int) ((duration / 1000) % 60);
        return String.format("%02d:%02d", minutes, seconds);
    }
}





