package android.support.v4.media;

import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

/* loaded from: classes.dex */
public final class RatingCompat implements Parcelable {
    public static final Parcelable.Creator<RatingCompat> CREATOR = new Parcelable.Creator<RatingCompat>() { // from class: android.support.v4.media.RatingCompat.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RatingCompat createFromParcel(Parcel p) {
            return new RatingCompat(p.readInt(), p.readFloat());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RatingCompat[] newArray(int size) {
            return new RatingCompat[size];
        }
    };
    public static final int RATING_3_STARS = 3;
    public static final int RATING_4_STARS = 4;
    public static final int RATING_5_STARS = 5;
    public static final int RATING_HEART = 1;
    public static final int RATING_NONE = 0;
    private static final float RATING_NOT_RATED = -1.0f;
    public static final int RATING_PERCENTAGE = 6;
    public static final int RATING_THUMB_UP_DOWN = 2;
    private static final String TAG = "Rating";
    private Object mRatingObj;
    private final int mRatingStyle;
    private final float mRatingValue;

    private RatingCompat(int ratingStyle, float rating) {
        this.mRatingStyle = ratingStyle;
        this.mRatingValue = rating;
    }

    public String toString() {
        return "Rating:style=" + this.mRatingStyle + " rating=" + (this.mRatingValue < 0.0f ? "unrated" : String.valueOf(this.mRatingValue));
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return this.mRatingStyle;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.mRatingStyle);
        dest.writeFloat(this.mRatingValue);
    }

    public static RatingCompat newUnratedRating(int ratingStyle) {
        switch (ratingStyle) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                return new RatingCompat(ratingStyle, RATING_NOT_RATED);
            default:
                return null;
        }
    }

    public static RatingCompat newHeartRating(boolean hasHeart) {
        return new RatingCompat(1, hasHeart ? 1.0f : 0.0f);
    }

    public static RatingCompat newThumbRating(boolean thumbIsUp) {
        return new RatingCompat(2, thumbIsUp ? 1.0f : 0.0f);
    }

    public static RatingCompat newStarRating(int starRatingStyle, float starRating) {
        float maxRating;
        switch (starRatingStyle) {
            case 3:
                maxRating = 3.0f;
                break;
            case 4:
                maxRating = 4.0f;
                break;
            case 5:
                maxRating = 5.0f;
                break;
            default:
                Log.e(TAG, "Invalid rating style (" + starRatingStyle + ") for a star rating");
                return null;
        }
        if (starRating < 0.0f || starRating > maxRating) {
            Log.e(TAG, "Trying to set out of range star-based rating");
            return null;
        }
        return new RatingCompat(starRatingStyle, starRating);
    }

    public static RatingCompat newPercentageRating(float percent) {
        if (percent < 0.0f || percent > 100.0f) {
            Log.e(TAG, "Invalid percentage-based rating value");
            return null;
        }
        return new RatingCompat(6, percent);
    }

    public boolean isRated() {
        return this.mRatingValue >= 0.0f;
    }

    public int getRatingStyle() {
        return this.mRatingStyle;
    }

    public boolean hasHeart() {
        if (this.mRatingStyle != 1) {
            return false;
        }
        return this.mRatingValue == 1.0f;
    }

    public boolean isThumbUp() {
        return this.mRatingStyle == 2 && this.mRatingValue == 1.0f;
    }

    public float getStarRating() {
        switch (this.mRatingStyle) {
            case 3:
            case 4:
            case 5:
                if (isRated()) {
                    return this.mRatingValue;
                }
                break;
        }
        return RATING_NOT_RATED;
    }

    public float getPercentRating() {
        return (this.mRatingStyle == 6 && isRated()) ? this.mRatingValue : RATING_NOT_RATED;
    }

    public static RatingCompat fromRating(Object ratingObj) {
        RatingCompat rating = null;
        if (ratingObj != null && Build.VERSION.SDK_INT >= 21) {
            int ratingStyle = RatingCompatApi21.getRatingStyle(ratingObj);
            if (RatingCompatApi21.isRated(ratingObj)) {
                switch (ratingStyle) {
                    case 1:
                        rating = newHeartRating(RatingCompatApi21.hasHeart(ratingObj));
                        break;
                    case 2:
                        rating = newThumbRating(RatingCompatApi21.isThumbUp(ratingObj));
                        break;
                    case 3:
                    case 4:
                    case 5:
                        rating = newStarRating(ratingStyle, RatingCompatApi21.getStarRating(ratingObj));
                        break;
                    case 6:
                        rating = newPercentageRating(RatingCompatApi21.getPercentRating(ratingObj));
                        break;
                }
            } else {
                rating = newUnratedRating(ratingStyle);
            }
            rating.mRatingObj = ratingObj;
        }
        return rating;
    }

    public Object getRating() {
        if (this.mRatingObj != null || Build.VERSION.SDK_INT < 21) {
            return this.mRatingObj;
        }
        if (isRated()) {
            switch (this.mRatingStyle) {
                case 1:
                    this.mRatingObj = RatingCompatApi21.newHeartRating(hasHeart());
                    break;
                case 2:
                    this.mRatingObj = RatingCompatApi21.newThumbRating(isThumbUp());
                    break;
                case 3:
                case 4:
                case 5:
                    this.mRatingObj = RatingCompatApi21.newStarRating(this.mRatingStyle, getStarRating());
                    break;
                case 6:
                    this.mRatingObj = RatingCompatApi21.newPercentageRating(getPercentRating());
                    return null;
                default:
                    return null;
            }
        } else {
            this.mRatingObj = RatingCompatApi21.newUnratedRating(this.mRatingStyle);
        }
        return this.mRatingObj;
    }
}