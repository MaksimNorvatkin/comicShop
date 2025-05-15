package org.comic;

import org.comic.model.entity.Comic;
import org.comic.model.repository.ComicRepository;
import org.comic.model.servise.ComicService;

public class ComicServiceTest {
    public static void main(String[] args) {
        // 1. Подготовка
        ComicRepository repository = new ComicRepository();
        ComicService service = new ComicService(repository);

        // 2. Добавляем комикс
        Comic comic = new Comic(null, "Бэтмен", "Боб Кейн", "DC", 80, "Супергероика", 1939, 200.0, 500.0);
        service.addComic(comic);

        // 3. Продаём комикс
        service.sellComic(1L);
        System.out.println("Продажи: " + repository.findById(1L).getSalesCount()); // Должно быть 1

        // 4. Добавляем скидку
        service.applyDiscount(1L, 10.0); // Скидка 10%
        System.out.println("Цена со скидкой: " + repository.findById(1L).getSellingPrice() * 0.9);
    }
}
