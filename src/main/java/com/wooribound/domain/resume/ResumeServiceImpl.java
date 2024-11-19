package com.wooribound.domain.resume;

import com.wooribound.domain.resume.dto.ResumeDTO;
import com.wooribound.domain.resume.dto.ResumeDetailDTO;
import com.wooribound.domain.wbuser.WbUser;
import com.wooribound.domain.wbuser.WbUserRepository;
import com.wooribound.domain.workhistory.WorkHistory;
import com.wooribound.domain.workhistory.WorkHistoryRepository;
import com.wooribound.global.exception.NoWbUserException;
import com.wooribound.global.exception.NotEntityException;
import com.wooribound.global.util.AuthenticateUtil;
import com.wooribound.global.util.S3Util;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ResumeServiceImpl implements ResumeService {

    @Value("${aws.s3.wbUser.folder}")
    String wbUserFolderName;

    private final S3Util s3Util;
    private final AuthenticateUtil authenticateUtil;
    private final ResumeRepository resumeRepository;
    private final WbUserRepository wbUserRepository;
    private final WorkHistoryRepository workHistoryRepository;

    @Override
    public ResumeDTO getResume(Authentication authentication) {
        String userId = authenticateUtil.CheckWbUserAuthAndGetUserId(authentication);

        Optional<WbUser> byIdWbUser = wbUserRepository.findById(userId);
        if (byIdWbUser.isEmpty()) {
            throw new NotEntityException();
        }

        Optional<Resume> byUserIdResume = resumeRepository.findByUserId(byIdWbUser.get().getUserId());

        ResumeDTO.ResumeDTOBuilder dtoBuilder = ResumeDTO.builder()
                .userId(byIdWbUser.get().getUserId())
                .userName(byIdWbUser.get().getName())
                .userPhone(byIdWbUser.get().getPhone());

        if (byUserIdResume.isPresent()) {
            Resume resume = byUserIdResume.get();
            dtoBuilder
                    .userImg(resume.getUserImg())
                    .resumeEmail(resume.getResumeEmail())
                    .userIntro(resume.getUserIntro());
        } else {
            // 이력서가 없을 때 빈 값 설정
            dtoBuilder
                    .userImg("")
                    .resumeEmail("")
                    .userIntro("");
        }

        return dtoBuilder.build();
    }

    @Override
    public ResumeDTO registerResume(Authentication authentication, MultipartFile userImg, String resumeEmail, String userIntro) throws IOException {
        String userId = authenticateUtil.CheckWbUserAuthAndGetUserId(authentication);

        Optional<WbUser> byIdWbUser = wbUserRepository.findById(userId);
        if (byIdWbUser.isEmpty()) {
            throw new NotEntityException();
        }

        long resumeId = 1L;
        Optional<Long> maxResumeId = resumeRepository.getMaxResumeId();
        if (maxResumeId.isPresent()) {
            resumeId = maxResumeId.get() + 1;
        }

        String fileURL = s3Util.uploadFile(userImg, wbUserFolderName);

        Resume resume = Resume.builder()
                .resumeId(resumeId)
                .wbUser(byIdWbUser.get())
                .userImg(fileURL)
                .resumeEmail(resumeEmail)
                .userIntro(userIntro)
                .build();

        Resume savedResume = resumeRepository.save(resume);


        return ResumeDTO.builder()
                .userId(savedResume.getWbUser().getUserId())
                .userName(savedResume.getWbUser().getName())
                .userPhone(savedResume.getWbUser().getPhone())
                .userImg(savedResume.getUserImg())
                .resumeEmail(savedResume.getResumeEmail())
                .userIntro(savedResume.getUserIntro())
                .build();
    }

    @Override
    public ResumeDTO updateResume(Authentication authentication, MultipartFile userImg, String resumeEmail, String userIntro) throws IOException {
        String userId = authenticateUtil.CheckWbUserAuthAndGetUserId(authentication);

        Optional<WbUser> byIdWbUser = wbUserRepository.findById(userId);
        if (byIdWbUser.isEmpty()) {
            throw new NotEntityException();
        }

        Optional<Resume> byIdResume = resumeRepository.findByUserId(byIdWbUser.get().getUserId());
        if (byIdResume.isEmpty()) {
            throw new NotEntityException();
        }

        Resume resume = byIdResume.get();

        if (userImg != null) {
            // s3에서 파일 삭제
            s3Util.deleteFile(byIdResume.get().getUserImg(), wbUserFolderName);

            // s3에 새로운 파일 업로드
            String fileURL = s3Util.uploadFile(userImg, wbUserFolderName);

            resume.setUserImg(fileURL);
        }

        resume.setResumeEmail(resumeEmail);
        resume.setUserIntro(userIntro);
        Resume savedResume = resumeRepository.save(resume);

        return ResumeDTO.builder()
                .userId(savedResume.getWbUser().getUserId())
                .userName(savedResume.getWbUser().getName())
                .userPhone(savedResume.getWbUser().getPhone())
                .userImg(savedResume.getUserImg())
                .resumeEmail(savedResume.getResumeEmail())
                .userIntro(savedResume.getUserIntro())
                .build();
    }

    @Override
    public ResumeDetailDTO getWbUserResume(String userId) {
        try {
            WbUser byIdWbUser = wbUserRepository.findById(userId)
                    .orElseThrow(() -> new NoWbUserException("해당 사용자 ID를 찾을 수 없습니다: " + userId));

            Resume resume = resumeRepository.findByUserId(userId).orElseThrow();
            List<WorkHistory> workHistoryList = workHistoryRepository.findByUserId(userId);

            List<String> jobs = workHistoryList.stream()
                    .map(workHistory -> workHistory.getJob().getJobName()) // jobName만 추출
                    .collect(Collectors.toList());

            return ResumeDetailDTO.builder()
                    .userName(resume.getWbUser().getName())
                    .jobPoint(resume.getWbUser().getJobPoint())
                    .phone(resume.getWbUser().getPhone())
                    .addrCity(resume.getWbUser().getAddrCity())
                    .addrProvince(resume.getWbUser().getAddrProvince())
                    .userIntro(resume.getUserIntro())
                    .userImg(resume.getUserImg())
                    .resumeEmail(resume.getResumeEmail())
                    .jobList(jobs)
                    .build();
        } catch (NoWbUserException e) {
            throw e;
        }
    }


    private String createFileName(String fileName){
        return UUID.randomUUID().toString().concat(fileName);
    }
}
