package org.comic;

import org.comic.model.entity.Comic;
import org.comic.model.repository.ComicRepository;

import java.util.ArrayList;
import java.util.List;

public class ComicRepositoryTest {
    public static void main(String[] args) {
        // 1. Создаем репозиторий
        List<Comic> comicList = new ArrayList<>();  // Создаём пустой список
        ComicRepository repository = new ComicRepository(comicList);  // Передаём его

        // 2. Создаем комикс
        Comic comic = new Comic(
                null,                           // ID пока не известен
                "Бэтмен: Тёмный рыцарь",       // Название
                "Фрэнк Миллер",                // Автор
                "DC Comics",                   // Издательство
                120,                           // Страниц
                "Супергероика",                // Жанр
                1986,                          // Год
                500.0,                         // Себестоимость
                1000.0                         // Цена продажи
        );
        Comic comic2 = new Comic(
                null, "Бэтмен", "Фрэнк Миллер", "DC",
                100, "Супергероика", 1986, 500.0, 1000.0
        );

        // 3. Добавляем комикс
        repository.addComic(comic);
        repository.addComic(comic2);

        // 4. Проверяем, что комикс добавился
        List<Comic> allComics = repository.getAllComics();
        System.out.println("Все комиксы в репозитории:");
        for (Comic c : allComics) {
            System.out.println(c.getId() + ": " + c.getTitle());
        }
    }
}