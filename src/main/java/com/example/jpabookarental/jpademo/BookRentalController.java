package com.example.jpabookarental.jpademo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class BookRentalController
{
    @Autowired
    BookRentalService bookRentalService;

    @PostMapping("/bookRental")
    public BookRental addBook(@Valid @RequestBody  BookRental bookRental)
    {
       return bookRentalService.addBook(bookRental);
    }


    @GetMapping("/bookRental")
    public List<BookRental> getBook()
    {
        return bookRentalService.getBook();
    }

    @GetMapping("/bookRental/byIsbn/{isbn}")
    public Optional<BookRental> findById (@Valid @PathVariable @RequestBody(required = true) int isbn)
    {
        return  bookRentalService.findById(isbn);

    }

    @GetMapping("/bookRental/byAuthor/{authorName}")
    public BookRental getBookRentalByAuthorName( @Valid @PathVariable @RequestBody(required = true) String authorName)
    {
        return bookRentalService.getBookRentalByAuthor(authorName);

    }

    @GetMapping("/bookRental/byTitle/{bookTitle}")
    public BookRental getBookRentalsByBookTitle(@Valid @PathVariable @RequestBody String bookTitle)
    {
        return bookRentalService.getBookRentalsByBookTitle(bookTitle);

    }

    @DeleteMapping("/bookRental/delete/{isbn}")
    public void deleteBook(@PathVariable int isbn)
    {
         bookRentalService.deleteBook(isbn);
    }

    @PutMapping("/bookRental")
    public BookRental updateBook(@Valid @RequestBody BookRental bookRental)
    {
        return bookRentalService.updateBook(bookRental);
    }


  @PutMapping("/bookRental/rent")
    public ResponseEntity<String> updateRent(@Valid @RequestBody BookRental bookRental)
    {
        return bookRentalService.updateRent(bookRental);
    }

    @PutMapping("/bookRental/return")
    public ResponseEntity<String> returnBook(@Valid @RequestBody BookRental bookRental)
    {
        return bookRentalService.returnBook(bookRental);
    }

}
