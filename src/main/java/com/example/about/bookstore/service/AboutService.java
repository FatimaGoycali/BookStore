package com.example.about.bookstore.service;

import com.example.about.bookstore.dao.repository.AboutRepository;
import com.example.about.bookstore.mapper.AboutMapper;
import com.example.about.bookstore.model.dto.AboutDto;
import org.springframework.stereotype.Service;


@Service
public class AboutService {
    private final AboutRepository aboutRepository;

    public AboutService(AboutRepository aboutRepository) {
        this.aboutRepository = aboutRepository;
    }

    public AboutDto getAboutParam() {
        return AboutMapper.INSTANCE.mapToDto(aboutRepository.findById(1).get());
    }
}
