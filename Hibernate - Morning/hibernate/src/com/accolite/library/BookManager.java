package com.accolite.library;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class BookManager {
	
	private static SessionFactory factory;

	public static void main(String[] args) {
		
		try {
			factory = new Configuration().configure().buildSessionFactory();
		} catch (Exception e) {
			System.err.println(e);
		}

		BookManager bookManager = new BookManager();

		String Books[][] = 
			{
				{ "IIT JEE Papers" , "D C PANDEY" },
				{ "Concept of Physics", "H.C Verma" },
				{ "Introduction to Algorithms", " Thomas H. Cormen" }, 
				{ "Ikigai: The Japanese secret to a long and happy life", "Héctor García" },
				{ "Think Like a Monk:", "Jay Shetty" } 
			};
		int years[] = { 2020, 2019, 2005, 2018, 2017 };
		
		bookManager.getBooks();
		
		
		System.out.println("Adding  5 Books to Library");
//		 Add Books to Library
		for (int i = 0; i < years.length; i++) {
			bookManager.addBook(Books[i][0], Books[i][1], years[i]);
		}
		System.out.println();
		
		System.out.println("Getting All Books Info");
		bookManager.getBooks();
		System.out.println();
		
		System.out.println("Updating Books with Id 1");
		bookManager.updateBookById(1);
		System.out.println();
		
		bookManager.getBooks();
		System.out.println();
		
		System.out.println("Deleting Book with ID 2");
		bookManager.deleteBookById(2);
		System.out.println();
		bookManager.getBooks();
		
		System.out.println();
		System.out.println("Count of Books are: " + bookManager.countBooks());
	}

	public Integer addBook(String title, String author, int year) {
		Session session = factory.openSession();
		Transaction tx = null;
		Integer bookId = null;
		try {
			tx = session.beginTransaction();
			Book book = new Book(title, author, year);
			bookId = (Integer) session.save(book);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null)
				tx.rollback();
		} finally {
			session.close();
		}
		return bookId;
	}

	
	private void getBooks() {
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			List<Book> booksList = session.createQuery("FROM Book").list();
			if(booksList.size() == 0)
			{
				System.out.println("Book not Available");
			}
			else
			{
				System.out.println("Id\tTite\tAuthor\tYear");
				for(Book book : booksList) {
					System.out.println(book.getId() + "\t" + book.getTitle() + "\t" + book.getAuthor() + "\t" + book.getYear());
				}
				tx.commit();	
			}
		} catch (Exception e) {
			e.printStackTrace();
			if(tx!=null) {
				tx.rollback();
			}
		}finally {
			session.close();
		}
	}
	
	private void updateBookById(int id) {
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Book book  = session.get(Book.class, id);
			System.out.println("Book to be Updated is:");
			System.out.println(book.getId() + "\t" + book.getTitle() + "\t" + book.getAuthor() + "\t" + book.getYear());
			book.setTitle("Updated Book");
			book.setAuthor("Aagam Shah");
			book.setYear(2020);
			session.update(book);
			tx.commit();
			System.out.println("Book is Updated");
			} catch (Exception e) {
				e.printStackTrace();
				if(tx!=null)
					tx.rollback();
			} finally {
				session.close();
		}
	}
	private void deleteBookById(int id) {
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Book book  = session.get(Book.class, id);
			System.out.println("Book Deleted is: ");
			System.out.println(book.getId() + "\t" + book.getTitle() + "\t" + book.getAuthor() + "\t" + book.getYear());
			session.delete(book);
			tx.commit();
			System.out.println("Book is Deleted");
		} catch (Exception e) {
			e.printStackTrace();
			if(tx!=null)
				tx.rollback();
		} finally {
			session.close();		
			}	
	}
	private int countBooks() {
		Session session = factory.openSession();
		Transaction tx = null;
		int countBook = 0;
		try {
			tx = session.beginTransaction();
			List<Book> booksList = session.createQuery("FROM Book").list();
			countBook = booksList.size();
			tx.commit();
		}catch (Exception e) {
			e.printStackTrace();
			if(tx!=null) {
				tx.rollback();
			}
		}finally {
			session.close();
		}
		return countBook;
	}
}
