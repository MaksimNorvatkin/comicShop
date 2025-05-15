package org.comic.model.servise;


import org.comic.model.entity.Comic;
import org.comic.model.repository.ComicRepository;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ReportService {
    private final ComicRepository comicRepository;

    public ReportService(ComicRepository comicRepository) {
        this.comicRepository = comicRepository;
    }

    // Новинки (за текущий год)
    public List<Comic> getNewComics() {
        int currentYear = LocalDate.now().getYear();
        return comicRepository.getAllComics().stream()
                .filter(comic -> comic.getYear() == currentYear)
                .toList();
    }

    // Топ продаваемых комиксов
    public List<Comic> getTopSellingComics(int limit) {
        return comicRepository.getAllComics().stream()
                .sorted(Comparator.comparingInt(Comic::getSalesCount).reversed())
                .limit(limit)
                .toList();
    }

    // Топ авторов (по количеству комиксов)
    public Map<String, Long> getTopAuthors() {
        return comicRepository.getAllComics().stream()
                .collect(Collectors.groupingBy(
                        Comic::getAuthor,
                        Collectors.counting()
                ));
    }

    // Топ жанров
    public Map<String, Long> getTopGenres() {
        return comicRepository.getAllComics().stream()
                .collect(Collectors.groupingBy(
                        Comic::getGenre,
                        Collectors.counting()
                ));
    }
}