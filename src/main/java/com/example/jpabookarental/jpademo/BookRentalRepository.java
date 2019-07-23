package com.example.jpabookarental.jpademo;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;


public interface BookRentalRepository extends CrudRepository<BookRental ,Integer >
{
    @Modifying
    @Query("update BookRental bookrental set bookrental.stock=bookrental.stock-1 where  bookrental.isbn=?1")
    int updateRent(Long isbn);
   // long readDistinctFirstByIsbnRegex(long isbn);
   @Modifying
   @Query(value = "delete from bookrental where bookRental_isbn=:bookRental_isbn",nativeQuery = true)
   int deleteByBookIsbn(long borrower_id);
    BookRental getBookRentalByAuthorName(String authorName);
    BookRental getBookRentalsByBookTitle(String bookTitle);
}
