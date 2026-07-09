package ra.demo.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.demo.model.dto.request.CandidateCreateDTO;
import ra.demo.model.dto.request.CandidateUpdateDTO;
import ra.demo.model.entity.Candidate;
import ra.demo.repository.CandidateRepository;
import ra.demo.service.CandidateService;

@Service
public class CandidateServiceImpl implements CandidateService {
    @Autowired
    private CandidateRepository candidateRepository;

    @Override
    public Candidate save(CandidateCreateDTO candidateCreateDTO) {
        Candidate candidate = Candidate.builder()
                .fullName(candidateCreateDTO.getFullName())
                .email(candidateCreateDTO.getEmail())
                .age(candidateCreateDTO.getAge())
                .yearsOfExperience(candidateCreateDTO.getYearsOfExperience())
                .phone(candidateCreateDTO.getPhone())
                .build();
        return  candidateRepository.save(candidate);
    }

    @Override
    public Candidate findById(Long id) {
        return candidateRepository.findById(id).orElseThrow(() -> new RuntimeException("Không tìm thấy sản phẩm có mã: " + id));
    }

    @Override
    public Candidate update(Long id, CandidateUpdateDTO candidateUpdateDTO) {

        Candidate candidate = candidateRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Không tìm thấy ứng viên"));

        candidate.setAddress(candidateUpdateDTO.getAddress());
        candidate.setBio(candidateUpdateDTO.getBio());

        return candidateRepository.save(candidate);
    }
}
