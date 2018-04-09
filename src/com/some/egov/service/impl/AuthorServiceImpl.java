package com.some.egov.service.impl;

import org.springframework.transaction.annotation.Transactional;

import com.some.egov.beans.Author;
import com.some.egov.services.AuthorDao;
import com.some.egov.services.AuthorService;
@Transactional
public class AuthorServiceImpl implements AuthorService {
	private AuthorDao authorDao;
	public void setAuthorDao(AuthorDao authorDao) {
		this.authorDao = authorDao;
	}
	public void saveAuthor(Author author) {
		authorDao.save(author);
	}
	public Author findOneById(long a_no) {
		Author author = authorDao.selectOneById(a_no);
		return author;
	}
	public int updateAuthor(Author author) {
		return authorDao.updateAuthor(author);
	}
	
}
