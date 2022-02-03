package com.bank.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bank.domain.DocumentType;
import com.bank.repository.DocumentTypeRepository;

@Service
public class DocumentTypeImplementation implements DocumentTypeService {

	@Autowired
	DocumentTypeRepository documentTypeRepository;

	@Override
	@Transactional(readOnly = true)
	public List<DocumentType> findAll() {
		return documentTypeRepository.findAll();
	}

	@Override
	public Optional<DocumentType> findById(Integer id) {
		return documentTypeRepository.findById(id);
	}

	@Override
	public Long count() {
		return documentTypeRepository.count();
	}

	@Override
	public void validate(DocumentType entity) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public DocumentType save(DocumentType entity) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DocumentType update(DocumentType entity) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(DocumentType entity) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteById(Integer id) throws Exception {
		// TODO Auto-generated method stub

	}

}
