public interface IFavoritable<TFavorite extends IFavorite> {
    void addFavorite(TFavorite user);
    void removeFavorite(TFavorite user);
}
