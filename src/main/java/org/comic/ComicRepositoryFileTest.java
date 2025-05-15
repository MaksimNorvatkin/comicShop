package org.comic;

import org.comic.model.entity.Comic;
import org.comic.model.repository.ComicRepository;

import java.util.List;

public class ComicRepositoryFileTest {
    public static void main(String[] args) {
        // 1. Создаём репозиторий (загрузит данные из файла)
        ComicRepository repository = new ComicRepository();

        // 2. Добавляем комикс
        Comic spiderMan = new Comic(null, "Человек-паук 2", "Стэн Ли", "Marvel",
                50, "Супергероика", 1963, 320.0, 7400.0);
        repository.addComic(spiderMan);

        // 3. Проверяем поиск
        List<Comic> found = repository.findByTitle("человек-паук 2");
        System.out.println("Найден: " + found.get(0).getTitle());  // Человек-паук

//        // 4. Удаляем комикс
//        repository.deleteComic(1L);
//        System.out.println("После удаления: " + repository.getAllComics().size());  // 0

        // 5. Перезапусти программу — файл должен сохраниться!
    }
}
