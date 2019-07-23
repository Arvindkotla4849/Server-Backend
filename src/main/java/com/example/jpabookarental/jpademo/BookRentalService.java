package com.example.jpabookarental.jpademo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public class BookRentalService
{
    @Autowired
    BookRentalRepository bookRentalRepository;

    public BookRental addBook(BookRental bookRental)

    {
        return bookRentalRepository.save(bookRental);
    }

    public List<BookRental> getBook()
    {
       return  (List<BookRental>) bookRentalRepository.findAll();

    }

    public Optional<BookRental> findById(int Isbn)

    {
        return bookRentalRepository.findById(Isbn);
    }

    public BookRental getBookRentalByAuthor(String authorName)
    {
        return bookRentalRepository.getBookRentalByAuthorName(authorName);
    }

     public BookRental getBookRentalsByBookTitle(String bookTitle)
    {
        return bookRentalRepository.getBookRentalsByBookTitle(bookTitle);
    }

    public void  deleteBook(int isbn)
    {

        bookRentalRepository.deleteById(isbn);
    }

    public BookRental updateBook(BookRental bookRental)
    {
        /*if (bookRentalRepository.findById(ISBN).isPresent()){
            bookRental bookRental1=bookRentalRepository.findById(ISBN).get();
        }*/
       // BookRental bookRental1=bookRentalRepository.findById(bookRental.getIsbn()).orElse(null);
        return bookRentalRepository.save(bookRental);


    }

  public ResponseEntity<String> updateRent(BookRental bookRental){

         bookRentalRepository.save(bookRental);
         bookRentalRepository.findById(bookRental.getIsbn());
         return new ResponseEntity<>("ok", HttpStatus.OK);
    }

    public ResponseEntity<String> returnBook(BookRental bookRental)
    {
        bookRentalRepository.findById(bookRental.getIsbn());
        Optional<BookRental> delete=bookRentalRepository.findById(bookRental.getIsbn());
        return new ResponseEntity<String>("Returned Successfully",HttpStatus.OK);

    }


}
