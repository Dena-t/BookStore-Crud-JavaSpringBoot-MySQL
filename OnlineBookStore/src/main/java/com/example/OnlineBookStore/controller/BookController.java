package com.example.OnlineBookStore.controller;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.OnlineBookStore.entity.Book;
import com.example.OnlineBookStore.service.BookService;

@Controller
@RequestMapping("/")
public class BookController {
	@Autowired
	private BookService bookService;
	
	public BookController(BookService theBookService) {
		bookService = theBookService;	
	}

	@GetMapping("/list")
	public String listBook(Model theModel) {

		List<Book> theBook = bookService.findAll();
		theModel.addAttribute("book", theBook);
		return "list-books";
	}

	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel, Principal principal) {
		if (principal == null) {
			return "redirect:/showMyLoginPage";
		}

		Book theBook = new Book();
		theModel.addAttribute("book", theBook);
		return "book-form";
	}

	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("bookId") int theId, Model theModel, Principal principal) {
		if (principal == null) {
			return "redirect:/showMyLoginPage";
		}

		Book theBook = bookService.findById(theId);
		theModel.addAttribute("book", theBook);
		return "book-form";
	}

	@PostMapping("/save")
	public String saveBook(@ModelAttribute("book") Book theBook) {

		bookService.save(theBook);

		return "redirect:list";
	}

//	@PreAuthorize("hasAnyRole('ADMIN','MANAGER')")
	@GetMapping("/delete")
	public String delete(@RequestParam("bookId") int theId, Principal principal) {
		if (principal == null) {
			return "redirect:/showMyLoginPage";
		}
		bookService.deleteById(theId);

		return "redirect:list";

	}

	@GetMapping("/showMyLoginPage")
	public String showMyLoginPage() {
		return "fancy-login";
	}

	@GetMapping("/access-denied")
	public String showAccessDenied() {
		return "access-denied";
	}
	
	   @GetMapping("/book-details")
	   public String showBookDetails(@RequestParam("bookId") int theId, Model model) {
	       // Retrieve the book details based on the book ID
	       Book book = bookService.findById(theId);
	       // Pass the book details to the view
	       model.addAttribute("book", book);
	       return "book-details";
	   }
	   @GetMapping("/hr")
		public String showLeaders() {
			return "hr";

		}@GetMapping("/management")
		public String showManagement() {
			return "management";

		}
		@GetMapping("/it")
		public String showIt() {
			return "it";

		}
	
}
