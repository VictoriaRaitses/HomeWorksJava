package telran;

/**
 * Standart list data structure
 *
 * @param <T>
 */
public interface OurList<T> {

    public void add(T elt);

    public int size();

    public void set(int index, T elt);

    public T get(int index);

    public boolean contains(T elt);
    /**
     * @param  index
     * @return the elt
     */

}
