package org.comic.model.servise;

import org.comic.model.entity.Comic;
import org.comic.model.repository.ComicRepository;
import java.util.List;

public class ComicService {
    private final ComicRepository comicRepository;

    // Конструктор (внедряем зависимость от репозитория)
    public ComicService(ComicRepository comicRepository) {
        this.comicRepository = comicRepository;
    }

    // === Основные методы (прокси к репозиторию) ===
    public void addComic(Comic comic) {
        comicRepository.addComic(comic);
    }

    public List<Comic> getAllComics() {
        return comicRepository.getAllComics();
    }

    // === Бизнес-логика ===
    // Продажа комикса (увеличивает счётчик продаж)
    public void sellComic(Long comicId) {
        Comic comic = comicRepository.findById(comicId);
        if (comic != null) {
            comic.setSalesCount(comic.getSalesCount() + 1);
            comicRepository.updateComic(comic);
        }
    }

    // Добавление скидки
    public void applyDiscount(Long comicId, double discountPercent) {
        Comic comic = comicRepository.findById(comicId);
        if (comic != null) {
            comic.setOnSale(true);
            comic.setDiscount(discountPercent);
            comicRepository.updateComic(comic);
        }
    }

    // Бронирование для покупателя
    public void reserveComic(Long comicId, String customerLogin) {
        Comic comic = comicRepository.findById(comicId);
        if (comic != null) {
            comic.setReserved(true);
            comic.setReservedBy(customerLogin);
            comicRepository.updateComic(comic);
        }
    }

    // Списывание комикса (удаление + логирование)
    public void writeOffComic(Long comicId) {
        if (comicRepository.deleteComic(comicId)) {
            System.out.println("Комикс списан.");
        } else {
            System.out.println("Ошибка: комикс не найден.");
        }
    }
}