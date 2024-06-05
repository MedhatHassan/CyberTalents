package android.support.v4.media;

import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.MediaMetadataCompatApi21;
import android.support.v4.util.ArrayMap;
import android.util.Log;
import java.util.Set;

/* loaded from: classes.dex */
public final class MediaMetadataCompat implements Parcelable {
    public static final Parcelable.Creator<MediaMetadataCompat> CREATOR;
    private static final ArrayMap<String, Integer> METADATA_KEYS_TYPE = new ArrayMap<>();
    public static final String METADATA_KEY_ALBUM = "android.media.metadata.ALBUM";
    public static final String METADATA_KEY_ALBUM_ART = "android.media.metadata.ALBUM_ART";
    public static final String METADATA_KEY_ALBUM_ARTIST = "android.media.metadata.ALBUM_ARTIST";
    public static final String METADATA_KEY_ALBUM_ART_URI = "android.media.metadata.ALBUM_ART_URI";
    public static final String METADATA_KEY_ART = "android.media.metadata.ART";
    public static final String METADATA_KEY_ARTIST = "android.media.metadata.ARTIST";
    public static final String METADATA_KEY_ART_URI = "android.media.metadata.ART_URI";
    public static final String METADATA_KEY_AUTHOR = "android.media.metadata.AUTHOR";
    public static final String METADATA_KEY_COMPILATION = "android.media.metadata.COMPILATION";
    public static final String METADATA_KEY_COMPOSER = "android.media.metadata.COMPOSER";
    public static final String METADATA_KEY_DATE = "android.media.metadata.DATE";
    public static final String METADATA_KEY_DISC_NUMBER = "android.media.metadata.DISC_NUMBER";
    public static final String METADATA_KEY_DISPLAY_DESCRIPTION = "android.media.metadata.DISPLAY_DESCRIPTION";
    public static final String METADATA_KEY_DISPLAY_ICON = "android.media.metadata.DISPLAY_ICON";
    public static final String METADATA_KEY_DISPLAY_ICON_URI = "android.media.metadata.DISPLAY_ICON_URI";
    public static final String METADATA_KEY_DISPLAY_SUBTITLE = "android.media.metadata.DISPLAY_SUBTITLE";
    public static final String METADATA_KEY_DISPLAY_TITLE = "android.media.metadata.DISPLAY_TITLE";
    public static final String METADATA_KEY_DURATION = "android.media.metadata.DURATION";
    public static final String METADATA_KEY_GENRE = "android.media.metadata.GENRE";
    public static final String METADATA_KEY_NUM_TRACKS = "android.media.metadata.NUM_TRACKS";
    public static final String METADATA_KEY_RATING = "android.media.metadata.RATING";
    public static final String METADATA_KEY_TITLE = "android.media.metadata.TITLE";
    public static final String METADATA_KEY_TRACK_NUMBER = "android.media.metadata.TRACK_NUMBER";
    public static final String METADATA_KEY_USER_RATING = "android.media.metadata.USER_RATING";
    public static final String METADATA_KEY_WRITER = "android.media.metadata.WRITER";
    public static final String METADATA_KEY_YEAR = "android.media.metadata.YEAR";
    private static final int METADATA_TYPE_BITMAP = 2;
    private static final int METADATA_TYPE_LONG = 0;
    private static final int METADATA_TYPE_RATING = 3;
    private static final int METADATA_TYPE_TEXT = 1;
    private static final String TAG = "MediaMetadata";
    private final Bundle mBundle;
    private Object mMetadataObj;

    static {
        METADATA_KEYS_TYPE.put(METADATA_KEY_TITLE, 1);
        METADATA_KEYS_TYPE.put(METADATA_KEY_ARTIST, 1);
        METADATA_KEYS_TYPE.put(METADATA_KEY_DURATION, 0);
        METADATA_KEYS_TYPE.put(METADATA_KEY_ALBUM, 1);
        METADATA_KEYS_TYPE.put(METADATA_KEY_AUTHOR, 1);
        METADATA_KEYS_TYPE.put(METADATA_KEY_WRITER, 1);
        METADATA_KEYS_TYPE.put(METADATA_KEY_COMPOSER, 1);
        METADATA_KEYS_TYPE.put(METADATA_KEY_COMPILATION, 1);
        METADATA_KEYS_TYPE.put(METADATA_KEY_DATE, 1);
        METADATA_KEYS_TYPE.put(METADATA_KEY_YEAR, 0);
        METADATA_KEYS_TYPE.put(METADATA_KEY_GENRE, 1);
        METADATA_KEYS_TYPE.put(METADATA_KEY_TRACK_NUMBER, 0);
        METADATA_KEYS_TYPE.put(METADATA_KEY_NUM_TRACKS, 0);
        METADATA_KEYS_TYPE.put(METADATA_KEY_DISC_NUMBER, 0);
        METADATA_KEYS_TYPE.put(METADATA_KEY_ALBUM_ARTIST, 1);
        METADATA_KEYS_TYPE.put(METADATA_KEY_ART, 2);
        METADATA_KEYS_TYPE.put(METADATA_KEY_ART_URI, 1);
        METADATA_KEYS_TYPE.put(METADATA_KEY_ALBUM_ART, 2);
        METADATA_KEYS_TYPE.put(METADATA_KEY_ALBUM_ART_URI, 1);
        METADATA_KEYS_TYPE.put(METADATA_KEY_USER_RATING, 3);
        METADATA_KEYS_TYPE.put(METADATA_KEY_RATING, 3);
        METADATA_KEYS_TYPE.put(METADATA_KEY_DISPLAY_TITLE, 1);
        METADATA_KEYS_TYPE.put(METADATA_KEY_DISPLAY_SUBTITLE, 1);
        METADATA_KEYS_TYPE.put(METADATA_KEY_DISPLAY_DESCRIPTION, 1);
        METADATA_KEYS_TYPE.put(METADATA_KEY_DISPLAY_ICON, 2);
        METADATA_KEYS_TYPE.put(METADATA_KEY_DISPLAY_ICON_URI, 1);
        CREATOR = new Parcelable.Creator<MediaMetadataCompat>() { // from class: android.support.v4.media.MediaMetadataCompat.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public MediaMetadataCompat createFromParcel(Parcel in) {
                return new MediaMetadataCompat(in);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public MediaMetadataCompat[] newArray(int size) {
                return new MediaMetadataCompat[size];
            }
        };
    }

    private MediaMetadataCompat(Bundle bundle) {
        this.mBundle = new Bundle(bundle);
    }

    private MediaMetadataCompat(Parcel in) {
        this.mBundle = in.readBundle();
    }

    public boolean containsKey(String key) {
        return this.mBundle.containsKey(key);
    }

    public CharSequence getText(String key) {
        return this.mBundle.getCharSequence(key);
    }

    public String getString(String key) {
        CharSequence text = this.mBundle.getCharSequence(key);
        if (text != null) {
            return text.toString();
        }
        return null;
    }

    public long getLong(String key) {
        return this.mBundle.getLong(key, 0L);
    }

    public RatingCompat getRating(String key) {
        try {
            RatingCompat rating = (RatingCompat) this.mBundle.getParcelable(key);
            return rating;
        } catch (Exception e) {
            Log.w(TAG, "Failed to retrieve a key as Rating.", e);
            return null;
        }
    }

    public Bitmap getBitmap(String key) {
        try {
            Bitmap bmp = (Bitmap) this.mBundle.getParcelable(key);
            return bmp;
        } catch (Exception e) {
            Log.w(TAG, "Failed to retrieve a key as Bitmap.", e);
            return null;
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeBundle(this.mBundle);
    }

    public int size() {
        return this.mBundle.size();
    }

    public Set<String> keySet() {
        return this.mBundle.keySet();
    }

    public static MediaMetadataCompat fromMediaMetadata(Object metadataObj) {
        if (metadataObj == null || Build.VERSION.SDK_INT < 21) {
            return null;
        }
        Builder builder = new Builder();
        for (String key : MediaMetadataCompatApi21.keySet(metadataObj)) {
            Integer type = METADATA_KEYS_TYPE.get(key);
            if (type != null) {
                switch (type.intValue()) {
                    case 0:
                        builder.putLong(key, MediaMetadataCompatApi21.getLong(metadataObj, key));
                        continue;
                    case 1:
                        builder.putText(key, MediaMetadataCompatApi21.getText(metadataObj, key));
                        continue;
                    case 2:
                        builder.putBitmap(key, MediaMetadataCompatApi21.getBitmap(metadataObj, key));
                        continue;
                    case 3:
                        builder.putRating(key, RatingCompat.fromRating(MediaMetadataCompatApi21.getRating(metadataObj, key)));
                        continue;
                }
            }
        }
        MediaMetadataCompat metadata = builder.build();
        metadata.mMetadataObj = metadataObj;
        return metadata;
    }

    public Object getMediaMetadata() {
        if (this.mMetadataObj != null || Build.VERSION.SDK_INT < 21) {
            return this.mMetadataObj;
        }
        Object builderObj = MediaMetadataCompatApi21.Builder.newInstance();
        for (String key : keySet()) {
            Integer type = METADATA_KEYS_TYPE.get(key);
            if (type != null) {
                switch (type.intValue()) {
                    case 0:
                        MediaMetadataCompatApi21.Builder.putLong(builderObj, key, getLong(key));
                        continue;
                    case 1:
                        MediaMetadataCompatApi21.Builder.putText(builderObj, key, getText(key));
                        continue;
                    case 2:
                        MediaMetadataCompatApi21.Builder.putBitmap(builderObj, key, getBitmap(key));
                        continue;
                    case 3:
                        MediaMetadataCompatApi21.Builder.putRating(builderObj, key, getRating(key).getRating());
                        continue;
                }
            }
        }
        this.mMetadataObj = MediaMetadataCompatApi21.Builder.build(builderObj);
        return this.mMetadataObj;
    }

    /* loaded from: classes.dex */
    public static final class Builder {
        private final Bundle mBundle;

        public Builder() {
            this.mBundle = new Bundle();
        }

        public Builder(MediaMetadataCompat source) {
            this.mBundle = new Bundle(source.mBundle);
        }

        public Builder putText(String key, CharSequence value) {
            if (MediaMetadataCompat.METADATA_KEYS_TYPE.containsKey(key) && ((Integer) MediaMetadataCompat.METADATA_KEYS_TYPE.get(key)).intValue() != 1) {
                throw new IllegalArgumentException("The " + key + " key cannot be used to put a CharSequence");
            }
            this.mBundle.putCharSequence(key, value);
            return this;
        }

        public Builder putString(String key, String value) {
            if (MediaMetadataCompat.METADATA_KEYS_TYPE.containsKey(key) && ((Integer) MediaMetadataCompat.METADATA_KEYS_TYPE.get(key)).intValue() != 1) {
                throw new IllegalArgumentException("The " + key + " key cannot be used to put a String");
            }
            this.mBundle.putCharSequence(key, value);
            return this;
        }

        public Builder putLong(String key, long value) {
            if (MediaMetadataCompat.METADATA_KEYS_TYPE.containsKey(key) && ((Integer) MediaMetadataCompat.METADATA_KEYS_TYPE.get(key)).intValue() != 0) {
                throw new IllegalArgumentException("The " + key + " key cannot be used to put a long");
            }
            this.mBundle.putLong(key, value);
            return this;
        }

        public Builder putRating(String key, RatingCompat value) {
            if (MediaMetadataCompat.METADATA_KEYS_TYPE.containsKey(key) && ((Integer) MediaMetadataCompat.METADATA_KEYS_TYPE.get(key)).intValue() != 3) {
                throw new IllegalArgumentException("The " + key + " key cannot be used to put a Rating");
            }
            this.mBundle.putParcelable(key, value);
            return this;
        }

        public Builder putBitmap(String key, Bitmap value) {
            if (MediaMetadataCompat.METADATA_KEYS_TYPE.containsKey(key) && ((Integer) MediaMetadataCompat.METADATA_KEYS_TYPE.get(key)).intValue() != 2) {
                throw new IllegalArgumentException("The " + key + " key cannot be used to put a Bitmap");
            }
            this.mBundle.putParcelable(key, value);
            return this;
        }

        public MediaMetadataCompat build() {
            return new MediaMetadataCompat(this.mBundle);
        }
    }
}