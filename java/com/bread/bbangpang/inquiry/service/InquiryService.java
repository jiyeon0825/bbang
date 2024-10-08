package com.bread.bbangpang.inquiry.service;

import com.bread.bbangpang.inquiry.dto.InquiryDTO;
import com.bread.bbangpang.inquiry.repository.InquiryRepository;
import com.bread.bbangpang.post.dto.PostDTO;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class InquiryService {

    @Autowired
    private InquiryRepository inquiryRepository;

    public void addInquiry(InquiryDTO inquiryDTO) {
        inquiryRepository.save(inquiryDTO);
    }

    public Page<InquiryDTO> inquiryList(Pageable pageable) {
        return inquiryRepository.findAll(pageable);
    }

    public Page<InquiryDTO> searchInquiryType(String searchKeyword, Pageable pageable) {
        return inquiryRepository.findByInquiryTypeContaining(searchKeyword, pageable);
    }
    public Page<InquiryDTO> searchInquiryTitle(String searchKeyword, Pageable pageable) {
        return inquiryRepository.findByInquiryTitleContaining(searchKeyword, pageable);
    }
    public Page<InquiryDTO> searchInquiryWriter(String searchKeyword, Pageable pageable) {
        return inquiryRepository.findByInquiryWriterContaining(searchKeyword, pageable);
    }

    @Transactional
    public int inquiryViews(Integer inquiryNo) {
        return inquiryRepository.updateViews(inquiryNo);
    }

    public InquiryDTO inquiry(Integer inquiryNo) {
        return inquiryRepository.findById(inquiryNo).get();
    }

    public boolean checkPassword(Integer inquiryNo, String inquiryPassword) {
        InquiryDTO inquiry = inquiryRepository.findById(inquiryNo).orElseThrow(() -> new RuntimeException("Inquiry not found"));
        // 비밀번호 확인 (예시로 비밀번호를 평문으로 비교, 실제로는 암호화된 비밀번호를 비교해야 함)
        return inquiry.getInquiryPassword().equals(inquiryPassword);
    }

    public void deleteInquiry(Integer inquiryNo) {
        inquiryRepository.deleteById(inquiryNo);
    }

}
