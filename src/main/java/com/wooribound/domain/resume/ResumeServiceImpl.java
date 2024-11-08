package com.wooribound.domain.resume;

import com.wooribound.domain.resume.dto.ResumeDTO;
import com.wooribound.domain.resume.dto.ResumeDetailDTO;
import com.wooribound.domain.wbuser.WbUser;
import com.wooribound.domain.wbuser.WbUserRepository;
import com.wooribound.domain.workhistory.WorkHistory;
import com.wooribound.domain.workhistory.WorkHistoryRepository;
import com.wooribound.global.exception.NoWbUserException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ResumeServiceImpl implements ResumeService {

    private final ResumeRepository resumeRepository;
    private final WbUserRepository wbUserRepository;
    private final WorkHistoryRepository workHistoryRepository;

    @Override
    public ResumeDTO getResume(String userId) {
        Resume resume = resumeRepository.findByUserId(userId).orElseThrow();

        return ResumeDTO.builder()
                .userId(resume.getWbUser().getUserId())
                .userImg(resume.getUserImg())
                .resumeEmail(resume.getResumeEmail())
                .userIntro(resume.getUserIntro())
                .build();
    }

    @Override
    public String registerResume(ResumeDTO resumeDTO) {
        WbUser wbUser = wbUserRepository.findById(resumeDTO.getUserId())
                .orElseThrow((NoWbUserException::new));


        Resume resume = Resume.builder()
                .wbUser(wbUser)
                .userImg(resumeDTO.getUserImg())
                .resumeEmail(resumeDTO.getResumeEmail())
                .userIntro(resumeDTO.getUserIntro())
                .build();

        resumeRepository.save(resume);

        return "이력서가 성공적으로 등록되었습니다.";
    }

    @Override
    public String updateResume(ResumeDTO resumeDTO) {
        Resume resume = resumeRepository.findByUserId(resumeDTO.getUserId())
                .stream().findFirst().orElse(null);
        if (resume == null) {
            return "이력서를 찾을 수 없습니다.";
        }
        resume.setUserImg(resumeDTO.getUserImg());
        resume.setResumeEmail(resumeDTO.getResumeEmail());
        resume.setUserIntro(resumeDTO.getUserIntro());
        resumeRepository.save(resume);
        return "이력서가 성공적으로 수정되었습니다.";
    }

    @Override
    public ResumeDetailDTO getWbUserResume(String userId) {

        Resume resume = resumeRepository.findByUserId(userId).orElseThrow();
        List<WorkHistory> workHistoryList = workHistoryRepository.findByUserId(userId);

        List<String> jobs = workHistoryList.stream()
                .map(workHistory -> workHistory.getJob().getJobName())  // jobName만 추출
                .collect(Collectors.toList());

        return ResumeDetailDTO.builder()
                .userName(resume.getWbUser().getName())
                .jobPoint(resume.getWbUser().getJobPoint())
                .phone(resume.getWbUser().getPhone())
                .addrCity(resume.getWbUser().getAddrCity())
                .addrProvince(resume.getWbUser().getAddrProvince())
                .userImg(resume.getUserImg())
                .resumeEmail(resume.getResumeEmail())
                .jobList(jobs)
                .build();
    }
}
