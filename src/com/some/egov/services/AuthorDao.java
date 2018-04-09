package com.some.egov.services;

import com.some.egov.beans.Author;

public interface AuthorDao {

	void save(Author author);

	Author selectOneById(long a_no);

	int updateAuthor(Author author);

}
