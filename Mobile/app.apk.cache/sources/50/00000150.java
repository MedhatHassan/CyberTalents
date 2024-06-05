package android.support.v4.media.session;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.RatingCompat;
import android.support.v4.media.session.MediaControllerCompatApi21;
import android.support.v4.media.session.MediaSessionCompat;
import android.text.TextUtils;
import android.view.KeyEvent;

/* loaded from: classes.dex */
public final class MediaControllerCompat {
    private final MediaControllerImpl mImpl;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface MediaControllerImpl {
        boolean dispatchMediaButtonEvent(KeyEvent keyEvent);

        Object getMediaController();

        MediaMetadataCompat getMetadata();

        PlaybackInfo getPlaybackInfo();

        PlaybackStateCompat getPlaybackState();

        int getRatingType();

        TransportControls getTransportControls();

        void registerCallback(Callback callback, Handler handler);

        void sendCommand(String str, Bundle bundle, ResultReceiver resultReceiver);

        void unregisterCallback(Callback callback);
    }

    public MediaControllerCompat(Context context, MediaSessionCompat session) {
        if (session == null) {
            throw new IllegalArgumentException("session must not be null");
        }
        if (Build.VERSION.SDK_INT >= 21) {
            this.mImpl = new MediaControllerImplApi21(context, session);
        } else {
            this.mImpl = new MediaControllerImplBase();
        }
    }

    public MediaControllerCompat(Context context, MediaSessionCompat.Token sessionToken) throws RemoteException {
        if (sessionToken == null) {
            throw new IllegalArgumentException("sessionToken must not be null");
        }
        if (Build.VERSION.SDK_INT >= 21) {
            this.mImpl = new MediaControllerImplApi21(context, sessionToken);
        } else {
            this.mImpl = new MediaControllerImplBase();
        }
    }

    public TransportControls getTransportControls() {
        return this.mImpl.getTransportControls();
    }

    public boolean dispatchMediaButtonEvent(KeyEvent keyEvent) {
        if (keyEvent == null) {
            throw new IllegalArgumentException("KeyEvent may not be null");
        }
        return this.mImpl.dispatchMediaButtonEvent(keyEvent);
    }

    public PlaybackStateCompat getPlaybackState() {
        return this.mImpl.getPlaybackState();
    }

    public MediaMetadataCompat getMetadata() {
        return this.mImpl.getMetadata();
    }

    public int getRatingType() {
        return this.mImpl.getRatingType();
    }

    public PlaybackInfo getPlaybackInfo() {
        return this.mImpl.getPlaybackInfo();
    }

    public void registerCallback(Callback callback) {
        registerCallback(callback, null);
    }

    public void registerCallback(Callback callback, Handler handler) {
        if (callback == null) {
            throw new IllegalArgumentException("callback cannot be null");
        }
        if (handler == null) {
            handler = new Handler();
        }
        this.mImpl.registerCallback(callback, handler);
    }

    public void unregisterCallback(Callback callback) {
        if (callback == null) {
            throw new IllegalArgumentException("callback cannot be null");
        }
        this.mImpl.unregisterCallback(callback);
    }

    public void sendCommand(String command, Bundle params, ResultReceiver cb) {
        if (TextUtils.isEmpty(command)) {
            throw new IllegalArgumentException("command cannot be null or empty");
        }
        this.mImpl.sendCommand(command, params, cb);
    }

    public Object getMediaController() {
        return this.mImpl.getMediaController();
    }

    /* loaded from: classes.dex */
    public static abstract class Callback {
        final Object mCallbackObj;

        public Callback() {
            if (Build.VERSION.SDK_INT >= 21) {
                this.mCallbackObj = MediaControllerCompatApi21.createCallback(new StubApi21());
            } else {
                this.mCallbackObj = null;
            }
        }

        public void onSessionDestroyed() {
        }

        public void onSessionEvent(String event, Bundle extras) {
        }

        public void onPlaybackStateChanged(PlaybackStateCompat state) {
        }

        public void onMetadataChanged(MediaMetadataCompat metadata) {
        }

        /* loaded from: classes.dex */
        private class StubApi21 implements MediaControllerCompatApi21.Callback {
            private StubApi21() {
            }

            @Override // android.support.v4.media.session.MediaControllerCompatApi21.Callback
            public void onSessionDestroyed() {
                Callback.this.onSessionDestroyed();
            }

            @Override // android.support.v4.media.session.MediaControllerCompatApi21.Callback
            public void onSessionEvent(String event, Bundle extras) {
                Callback.this.onSessionEvent(event, extras);
            }

            @Override // android.support.v4.media.session.MediaControllerCompatApi21.Callback
            public void onPlaybackStateChanged(Object stateObj) {
                Callback.this.onPlaybackStateChanged(PlaybackStateCompat.fromPlaybackState(stateObj));
            }

            @Override // android.support.v4.media.session.MediaControllerCompatApi21.Callback
            public void onMetadataChanged(Object metadataObj) {
                Callback.this.onMetadataChanged(MediaMetadataCompat.fromMediaMetadata(metadataObj));
            }
        }
    }

    /* loaded from: classes.dex */
    public static abstract class TransportControls {
        public abstract void fastForward();

        public abstract void pause();

        public abstract void play();

        public abstract void rewind();

        public abstract void seekTo(long j);

        public abstract void setRating(RatingCompat ratingCompat);

        public abstract void skipToNext();

        public abstract void skipToPrevious();

        public abstract void stop();

        TransportControls() {
        }
    }

    /* loaded from: classes.dex */
    public static final class PlaybackInfo {
        public static final int PLAYBACK_TYPE_LOCAL = 1;
        public static final int PLAYBACK_TYPE_REMOTE = 2;
        private final int mAudioStream;
        private final int mCurrentVolume;
        private final int mMaxVolume;
        private final int mPlaybackType;
        private final int mVolumeControl;

        PlaybackInfo(int type, int stream, int control, int max, int current) {
            this.mPlaybackType = type;
            this.mAudioStream = stream;
            this.mVolumeControl = control;
            this.mMaxVolume = max;
            this.mCurrentVolume = current;
        }

        public int getPlaybackType() {
            return this.mPlaybackType;
        }

        public int getAudioStream() {
            return this.mAudioStream;
        }

        public int getVolumeControl() {
            return this.mVolumeControl;
        }

        public int getMaxVolume() {
            return this.mMaxVolume;
        }

        public int getCurrentVolume() {
            return this.mCurrentVolume;
        }
    }

    /* loaded from: classes.dex */
    static class MediaControllerImplBase implements MediaControllerImpl {
        MediaControllerImplBase() {
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public void registerCallback(Callback callback, Handler handler) {
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public void unregisterCallback(Callback callback) {
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public boolean dispatchMediaButtonEvent(KeyEvent event) {
            return false;
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public TransportControls getTransportControls() {
            return null;
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public PlaybackStateCompat getPlaybackState() {
            return null;
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public MediaMetadataCompat getMetadata() {
            return null;
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public int getRatingType() {
            return 0;
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public PlaybackInfo getPlaybackInfo() {
            return null;
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public void sendCommand(String command, Bundle params, ResultReceiver cb) {
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public Object getMediaController() {
            return null;
        }
    }

    /* loaded from: classes.dex */
    static class MediaControllerImplApi21 implements MediaControllerImpl {
        private final Object mControllerObj;

        public MediaControllerImplApi21(Context context, MediaSessionCompat session) {
            this.mControllerObj = MediaControllerCompatApi21.fromToken(context, session.getSessionToken().getToken());
        }

        public MediaControllerImplApi21(Context context, MediaSessionCompat.Token sessionToken) throws RemoteException {
            this.mControllerObj = MediaControllerCompatApi21.fromToken(context, sessionToken.getToken());
            if (this.mControllerObj == null) {
                throw new RemoteException();
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public void registerCallback(Callback callback, Handler handler) {
            MediaControllerCompatApi21.registerCallback(this.mControllerObj, callback.mCallbackObj, handler);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public void unregisterCallback(Callback callback) {
            MediaControllerCompatApi21.unregisterCallback(this.mControllerObj, callback.mCallbackObj);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public boolean dispatchMediaButtonEvent(KeyEvent event) {
            return MediaControllerCompatApi21.dispatchMediaButtonEvent(this.mControllerObj, event);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public TransportControls getTransportControls() {
            Object controlsObj = MediaControllerCompatApi21.getTransportControls(this.mControllerObj);
            if (controlsObj != null) {
                return new TransportControlsApi21(controlsObj);
            }
            return null;
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public PlaybackStateCompat getPlaybackState() {
            Object stateObj = MediaControllerCompatApi21.getPlaybackState(this.mControllerObj);
            if (stateObj != null) {
                return PlaybackStateCompat.fromPlaybackState(stateObj);
            }
            return null;
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public MediaMetadataCompat getMetadata() {
            Object metadataObj = MediaControllerCompatApi21.getMetadata(this.mControllerObj);
            if (metadataObj != null) {
                return MediaMetadataCompat.fromMediaMetadata(metadataObj);
            }
            return null;
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public int getRatingType() {
            return MediaControllerCompatApi21.getRatingType(this.mControllerObj);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public PlaybackInfo getPlaybackInfo() {
            Object volumeInfoObj = MediaControllerCompatApi21.getPlaybackInfo(this.mControllerObj);
            if (volumeInfoObj != null) {
                return new PlaybackInfo(MediaControllerCompatApi21.PlaybackInfo.getPlaybackType(volumeInfoObj), MediaControllerCompatApi21.PlaybackInfo.getLegacyAudioStream(volumeInfoObj), MediaControllerCompatApi21.PlaybackInfo.getVolumeControl(volumeInfoObj), MediaControllerCompatApi21.PlaybackInfo.getMaxVolume(volumeInfoObj), MediaControllerCompatApi21.PlaybackInfo.getCurrentVolume(volumeInfoObj));
            }
            return null;
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public void sendCommand(String command, Bundle params, ResultReceiver cb) {
            MediaControllerCompatApi21.sendCommand(this.mControllerObj, command, params, cb);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public Object getMediaController() {
            return this.mControllerObj;
        }
    }

    /* loaded from: classes.dex */
    static class TransportControlsApi21 extends TransportControls {
        private final Object mControlsObj;

        public TransportControlsApi21(Object controlsObj) {
            this.mControlsObj = controlsObj;
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void play() {
            MediaControllerCompatApi21.TransportControls.play(this.mControlsObj);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void pause() {
            MediaControllerCompatApi21.TransportControls.pause(this.mControlsObj);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void stop() {
            MediaControllerCompatApi21.TransportControls.stop(this.mControlsObj);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void seekTo(long pos) {
            MediaControllerCompatApi21.TransportControls.seekTo(this.mControlsObj, pos);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void fastForward() {
            MediaControllerCompatApi21.TransportControls.fastForward(this.mControlsObj);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void rewind() {
            MediaControllerCompatApi21.TransportControls.rewind(this.mControlsObj);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void skipToNext() {
            MediaControllerCompatApi21.TransportControls.skipToNext(this.mControlsObj);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void skipToPrevious() {
            MediaControllerCompatApi21.TransportControls.skipToPrevious(this.mControlsObj);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void setRating(RatingCompat rating) {
            MediaControllerCompatApi21.TransportControls.setRating(this.mControlsObj, rating != null ? rating.getRating() : null);
        }
    }
}