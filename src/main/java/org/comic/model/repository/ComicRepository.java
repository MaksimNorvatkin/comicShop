package org.comic.model.repository;

import org.comic.model.entity.Comic;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ComicRepository {

    private static final String FILE_PATH = "comics.json"; // Путь к файлу
    private final ObjectMapper mapper = new ObjectMapper(); // Для работы с JSON
    private List<Comic> comics; // список комиксов
    private Long nextId = 1L; // счетчик id

    public ComicRepository() {
        this.comics = loadFromFile(); // Загружаем данные при старте
        updateNextId();
    }
//    // если файл то конструктор принимает список
//    public ComicRepository(List<Comic> comics) {
//        this.comics = comics;
//    }


// Загрузка данных из файла
private List<Comic> loadFromFile() {
    try {
        File file = new File(FILE_PATH);
        if (file.exists()) {
            Comic[] comicsArray = mapper.readValue(file, Comic[].class);
            return new ArrayList<>(Arrays.asList(comicsArray));
        }
    } catch (IOException e) {
        System.err.println("Ошибка загрузки файла: " + e.getMessage());
    }
    return new ArrayList<>(); // Если файла нет, вернём пустой список
}

    // Сохранение данных в файл
    private void saveToFile() {
        try {
            mapper.writeValue(new File(FILE_PATH), comics);
        } catch (IOException e) {
            System.err.println("Ошибка сохранения файла: " + e.getMessage());
        }
    }

    // Обновляем nextId на основе максимального ID в списке(При загрузке данных из файла нужно восстановить nextId,
    // чтобы новые комиксы получали корректный ID.)
    private void updateNextId() {
        nextId = comics.stream()
                .mapToLong(Comic::getId)
                .max()
                .orElse(0) + 1;
    }

    //получить все комиксы
    public List<Comic> getAllComics() {
        return new ArrayList<>(comics); // Возвращаем копию списка
    }
    public void addComic(Comic comic) {
        comic.setId(nextId++);
        comics.add(comic);
        saveToFile();
    }

    // Удаление комикса по id
    public boolean deleteComic(Long id) {
        boolean removed = comics.removeIf(c -> c.getId().equals(id));
        if (removed) {
            saveToFile();
        }
        return removed;
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
            saveToFile();
        }



    }
}
