package ra.demo.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ra.demo.model.dto.request.CandidateCreateDTO;
import ra.demo.model.dto.request.CandidateUpdateDTO;
import ra.demo.model.dto.response.ApiResponse;
import ra.demo.model.entity.Candidate;
import ra.demo.service.CandidateService;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/candidates")
public class CandidateController {
    @Autowired
    private CandidateService candidateService;

    @PostMapping
    public ResponseEntity<ApiResponse<Candidate>> save(@Valid @RequestBody CandidateCreateDTO candidateCreateDTO) {
        return new ResponseEntity<>(new ApiResponse<>(
                true,
                "Them thanh cong",
                candidateService.save(candidateCreateDTO),
                null,
                HttpStatus.OK
        ), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ApiResponse<Candidate>> updateCandidate(
            @PathVariable Long id,
            @Valid
            @ModelAttribute CandidateUpdateDTO dto) {

        return new ResponseEntity<>(new ApiResponse<>(
                true,
                "Cập nhật thành công",
                candidateService.update(id, dto),
                null,
                HttpStatus.OK
        ),HttpStatus.OK);
    }
}
