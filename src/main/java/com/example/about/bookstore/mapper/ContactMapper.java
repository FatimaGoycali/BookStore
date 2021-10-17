package com.example.about.bookstore.mapper;
import com.example.about.bookstore.dao.entity.ContactUs;
import com.example.about.bookstore.model.dto.ContactDto;
import org.springframework.stereotype.Component;

@Component
public class ContactMapper {

    public ContactUs mapDtoToEntity(ContactDto contactDto) {
        return new ContactUs(
                contactDto.getFirstName(),
                contactDto.getLastName(),
                contactDto.getPhone(),
                contactDto.getEmail(),
                contactDto.getMessage()
        );
    }
}