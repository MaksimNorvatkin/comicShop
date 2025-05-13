package org.comic.model.repository;

import org.comic.model.entity.Comic;

import java.util.ArrayList;
import java.util.List;

public class ComicRepository {

    private List<Comic> comics; // список комиксов
    private Long nextId = 1L; // счетчик id

    // если файл то конструктор принимает список
    public ComicRepository(List<Comic> comics) {
        this.comics = comics;
    }
    public void addComic(Comic comic) {
        comic.setId(nextId);
        comics.add(comic);
        nextId++;
        System.out.println("Комикс добавлен: " + comic.getTitle());
    }
    public List<Comic> getAllComics() {
        return new ArrayList<>(comics); // Возвращаем копию списка
    }
}
