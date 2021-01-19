package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.NotFoundException;
import ru.netology.domain.Product;
import ru.netology.domain.TShirt;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {
    private ProductRepository repository = new ProductRepository();
    private Book countMonteCristo = new Book(413, "count Monte Cristo", 1200, "A. Dyuma", 520, 1844);
    private Book theWitcher = new Book(449, "The Witcher", 1900, "A. Sapkovskiy", 1342, 1991);
    private Book onegin = new Book(404, "Onegin", 780, "A. Pushkin", 352, 1833);
    private Book gameOfThrones = new Book(404, "Game Of Trones", 2300, "J. Martin", 1000, 1996);
    private Book lordOfTheRings = new Book(490, "Lord Of The Rings", 2400, "J.R. Tolkin", 746, 1954);
    private TShirt nirvana = new TShirt(333, "Nirvana", 300, "blue", "L");
    private TShirt slipknot = new TShirt(334, "Slipknot", 500, "black", "M");
    private TShirt asILayDying = new TShirt(335, "AsILayDying", 700, "black", "L");
    private TShirt bulletForMyValentine = new TShirt(336, "BulletForMyValentine", 800, "white", "S");

    @BeforeEach
    public void addedElements() {
        repository.save(countMonteCristo);
        repository.save(theWitcher);
        repository.save(onegin);
        repository.save(gameOfThrones);
        repository.save(lordOfTheRings);
        repository.save(nirvana);
        repository.save(slipknot);
        repository.save(asILayDying);
        repository.save(bulletForMyValentine);
    }

    @Test
    void shouldRemoveByRealId() {
        repository.removeById(413);
        Product[] expected = new Product[]{theWitcher, onegin, gameOfThrones, lordOfTheRings, nirvana, slipknot, asILayDying, bulletForMyValentine};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldRemoveByNotExistedId() {
        assertThrows(NotFoundException.class, () -> repository.removeById(480));
    }
}


