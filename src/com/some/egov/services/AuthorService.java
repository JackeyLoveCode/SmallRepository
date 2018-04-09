package com.some.egov.services;

import com.some.egov.beans.Author;

public interface AuthorService {

	void saveAuthor(Author author);

	Author findOneById(long a_no);

	int updateAuthor(Author author);

}
