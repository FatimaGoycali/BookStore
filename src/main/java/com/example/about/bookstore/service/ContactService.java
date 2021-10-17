package com.example.about.bookstore.service;

import com.example.about.bookstore.dao.repository.ContactRepository;
import com.example.about.bookstore.mapper.ContactMapper;
import com.example.about.bookstore.model.dto.ContactDto;
import org.springframework.stereotype.Service;

@Service
public class ContactService {

    private final ContactRepository contactRepository;
    private final ContactMapper contactMapper;

    public ContactService(ContactRepository contactRepository, ContactMapper contactMapper) {
        this.contactRepository = contactRepository;
        this.contactMapper = contactMapper;
    }

    public boolean saveContact(ContactDto contactDto) {
        contactRepository.save(contactMapper.mapDtoToEntity(contactDto));
        return true;
    }
}
