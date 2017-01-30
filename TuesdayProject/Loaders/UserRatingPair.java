package TuesdayProject.Loaders;

import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;

/**
 * Created by Tony on 2017-01-30.
 */
public class UserRatingPair<U,S> {
    //One user can only rate a movie once. so a pair is enough to store the score and user info
    private U user;
    private S score;

    public UserRatingPair(U user, S score){
        this.user = user;
        this.score = score;
    }
    public void add(U u, S s){
        this.user = u;
        this.score = s;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (!(other instanceof UserRatingPair)) return false;

        UserRatingPair<?, ?> that = (UserRatingPair<?, ?>) other;

        if (!user.equals(that.user)) return false;
        return score.equals(that.score);
    }

    @Override
    public int hashCode() {
        int result = user.hashCode();
        result = 31 * result + score.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "UserRatingPair{" +
                "user=" + user +
                ", score=" + score +
                '}';
    }

    public U getUser() {return user;}

    public S getScore() {return score;}
}

