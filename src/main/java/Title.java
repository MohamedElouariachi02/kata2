import java.util.List;

public record Title(String code, Title.Type type, String originalTitle, boolean isAdult, List<Genre> genres) {

    public enum Type {
        Videogame, Tvpilot, Movie, Tvseries, Tvminiseries, Short, Tvspecial, Tvshort, Video, Tvmovie, Tvepisode
    }

    public enum Genre {
        Action, Adult, Adventure, Animation, Biography, Comedy, Crime, Documentary, Drama, Family, Fantasy, FilmNoir, GameShow, genres, History, Horror, Music, Musical, Mystery, News, RealityTV, Romance, SciFi, Short, Sport, TalkShow, Thriller, War, Western
    }


}
