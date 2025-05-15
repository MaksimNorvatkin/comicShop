package org.comic;

import org.comic.model.entity.Comic;
import org.comic.model.repository.ComicRepository;
import org.comic.model.servise.ReportService;

public class ReportServiceTest {
    public static void main(String[] args) {
        ComicRepository repository = new ComicRepository();
        ReportService reportService = new ReportService(repository);

        // Добавляем тестовые данные
        repository.addComic(new Comic(null, "Бэтмен", "Боб Кейн", "DC", 80, "Супергероика", 2023, 200.0, 500.0));
        repository.addComic(new Comic(null, "Супермен", "Джерри Сигел", "DC", 70, "Супергероика", 2023, 150.0, 400.0));

        // Топ жанров
        System.out.println("Популярные жанры: " + reportService.getTopGenres()); // {Супергероика=2}
    }
}
