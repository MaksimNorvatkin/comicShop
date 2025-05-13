package org.comic.model.repository;

import org.comic.model.entity.Comic;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ComicRepository {

    private List<Comic> comics; // список комиксов
    private Long nextId = 1L; // счетчик id

    // если файл то конструктор принимает список
    public ComicRepository(List<Comic> comics) {
        this.comics = comics;
    }

    public void addComic(Comic comic) {
        if (comic.getTitle() == null || comic.getAuthor() == null) {
            throw new IllegalArgumentException("Название и автор обязательны!");
        }
        comic.setId(nextId);
        comics.add(comic);
        nextId++;
        System.out.println("Комикс добавлен: " + comic.getTitle());
    }

    //получить все комиксы
    public List<Comic> getAllComics() {
        return new ArrayList<>(comics); // Возвращаем копию списка
    }

    //Удалить комикс по id
    public boolean deleteComic(Long id) {
        return comics.removeIf(comic -> comic.getId().equals(id));
    }

    // Поиск по ID
    public Comic findById(Long id) {
        return comics.stream()
                .filter(comic -> comic.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    // поииск по нозванию
    public List<Comic> findByTitle(String title) {
        return comics.stream()
                .filter(comic -> comic.getTitle().equalsIgnoreCase(title))
                .toList();
    }

    //поиск по автору
    public List<Comic> findByAuthor(String author) {
        return comics.stream()
                .filter(comic -> comic.getAuthor().equalsIgnoreCase(author))
                .collect(Collectors.toList());
    }

    // Поиск по жанру
    public List<Comic> findByGenre(String genre) {
        return comics.stream()
                .filter(comic -> comic.getGenre().equalsIgnoreCase(genre))
                .toList();
    }

    // Редактирование комикса
    public void updateComic(Comic updatedComic) {
        Comic existing = findById(updatedComic.getId());
        if (existing != null) {
            // Копируем поля из updatedComic в existing
            existing.setTitle(updatedComic.getTitle());
            existing.setAuthor(updatedComic.getAuthor());
            existing.setPublisher(updatedComic.getPublisher());
            existing.setPageCount(updatedComic.getPageCount());
            existing.setGenre(updatedComic.getGenre());
            existing.setYear(updatedComic.getYear());
            existing.setCostPrice(updatedComic.getCostPrice());
            existing.setSellingPrice(updatedComic.getSellingPrice());
            existing.setSequel(updatedComic.isSequel());
            existing.setOnSale(updatedComic.isOnSale());
            existing.setDiscount(updatedComic.getDiscount());
            existing.setReserved(updatedComic.isReserved());
            existing.setReservedBy(updatedComic.getReservedBy());
            existing.setSalesCount(updatedComic.getSalesCount());
        }


    }
}
