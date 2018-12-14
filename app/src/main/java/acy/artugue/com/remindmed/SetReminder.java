package acy.artugue.com.remindmed;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.os.Vibrator;
import android.provider.Settings;



public class SetReminder extends BroadcastReceiver{

    @Override
    public void onReceive(Context context, Intent intent) {
        //MediaPlayer mediaPlayer = MediaPlayer.create(context, Settings.System.DEFAULT_RINGTONE_URI);
        // mediaPlayer.start();

        final MediaPlayer player = MediaPlayer.create(context, Settings.System.DEFAULT_RINGTONE_URI);
        player.start();

        CountDownTimer timer = new CountDownTimer(20000, 20000) {

            @Override
            public void onTick(long millisUntilFinished) {
                // Nothing to do
            }

            @Override
            public void onFinish() {
                if (player.isPlaying()) {
                    player.stop();
                    player.release();
                }
            }
        };
        timer.start();

        Vibrator v = (Vibrator) context.getSystemService(context.VIBRATOR_SERVICE);
        v.vibrate(10000);

    }


}

